package com.plf.manage.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.SessionFactory;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.plf.manage.dao.GradeDao;
import com.plf.manage.domain.Grade;
import com.plf.manage.dto.GradeDto;
import com.plf.manage.dto.MyScoreDto;

@Repository
@Scope("prototype")
public class GradeDaoImpl implements GradeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Grade grade) {
		sessionFactory.getCurrentSession().save(grade);
	}

	@Override
	public void update(Grade grade) {
		sessionFactory.getCurrentSession().update(grade);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GradeDto> list(Integer teacherId) {
		String sql ="select g.id as gradeId,k.realname as studenName,g.score,k.studentId,c.className from"
				+ " (select realname,id as studentId from student"
				+ " where classType = (SELECT classType from teacher where id="+teacherId+"))k"
				+ " left join (select * from grade where teacherId="+teacherId+") g on g.studentId=k.studentId"
				+ " left join teacher t on t.id = g.teacherId"
				+ " left join classname c on c.id=t.classNameId";
		
		List<Object[]> list= sessionFactory.getCurrentSession()
				.createNativeQuery(sql)
				.addScalar("gradeId", IntegerType.INSTANCE)
				.addScalar("studenName", StringType.INSTANCE)
				.addScalar("score", DoubleType.INSTANCE)
				.addScalar("studentId", IntegerType.INSTANCE)
				.addScalar("className", StringType.INSTANCE)
				.getResultList();
		
		List<GradeDto> dtos = new ArrayList<GradeDto>();
		
		for(Object[] l : list){
			GradeDto gd = new GradeDto();
			gd.setGradeId((Integer)l[0]);
			gd.setStudentName((String)l[1]);
			gd.setScore((Double)l[2]);
			gd.setStudentId((Integer)l[3]);
			gd.setClassName((String)l[4]);
			dtos.add(gd);
		}
		return dtos;
	}

	@Override
	public List<MyScoreDto> listMyScore(Integer studentId) {
		String sql = "select g.score,c.className from grade g"
				+ " left join teacher t on t.id=g.teacherId"
				+ " left join student s on s.id=g.studentId"
				+ " left join classname c on c.id=t.classNameId"
				+ " where s.id="+studentId;
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
		if(list!=null && list.size()>0){
			List<MyScoreDto> ls = new ArrayList<MyScoreDto>();
			for(int i=0;i<list.size();i++){
				MyScoreDto c = new MyScoreDto();
				
					try {
						BeanUtils.populate(c, list.get(i));
					} catch (IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
				
				ls.add(c);
			}
			return ls;
		}
		
		return null;
	}

}
