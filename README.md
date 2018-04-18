# StudentManage
## 学生管理系统

**使用struts2.5+hibernate5.2+spring4.3做服务端，用bootstrap+jquery+jsp做前端，这个简单的项目主要是自己为了熟悉SSH框架。**


### 该项目主要实现以下功能
- 1、管理员登录  管理员登录为独立页面
- 2、管理员增、改课程
- 3、管理员增、改教师，教师分为班主任和普通教师，班主任查看本班的全部成绩，普通教师只能填写本人所交的课程
- 4、教师登录
- 5、教师增、改学生分数，班主任查看本班的分数
- 6、学生注册、登录
- 7、学生查看自己的分数


### 注意点
#### Hibernate的外键保存
```
ClassName className = new ClassName();
className.setId(classNameId);
teacher.setClassName(className);
teacherService.save(teacher);
```
需要先建一个外键对象，才能把外键Id保存。

#### Hibernate的保存
注意这个session.update()会把NULL值也进行保存。

#### Hibernate的分页
```
List<ClassName> list=sessionFactory.getCurrentSession().createQuery("from ClassName")
		.setFirstResult(begin)
		.setFetchSize(limit).list();
```

#### Hibernate的查询自定义的类(非Entity)
```
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
```

#### Hibernate的查询自定义的类(Entity)
```
@Override
public List<Student> getStudentList(Integer teacherId) {
  return sessionFactory.getCurrentSession().createNativeQuery("select * from student"
      + " where classType in (select classType from teacher where id = "+ teacherId+")", 
      Student.class).getResultList();
}
```

#### 使用JdbcTemplate
```
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

```



