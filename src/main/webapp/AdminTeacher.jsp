<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <title>首页</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <script src="assets/js/chart-master/Chart.js"></script>
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="javascript:void(0)" class="logo"><b>学生管理系统</b></a>
            <!--logo end-->
            
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="${pageContext.request.contextPath }/manage_loginout">登出</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              
              <ul class="sidebar-menu" id="nav-accordion">
                 <li class="mt">
                      <a href="AdminClass.jsp">
                          <i class="fa fa-book"></i>
                          <span>课程名单</span>
                      </a>
                  </li>
                  <li class="sub-menu">
                      <a class="active" href="AdminTeacher.jsp">
                          <i class="fa fa-user"></i>
                          <span>教师名单</span>
                      </a>
                  </li>
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
           <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> 老师名单</h3>
          	
          	 	<div class="row">
          	 		<div class="col-md-3">
          	 			<button class="btn btn-info btn-md" onclick="openModel();"><i class="fa fa-check"></i></button>
          	 		</div>
          	 		<div class="col-md-6  col-md-offset-3">
  						 <div class="col-lg-4">
          	 				<input type="text" placeholder="请输入真名" class="form-control" id="sosoname">
          	 			</div>
          	 			<button class="btn btn-info btn-md" onclick="soso();">搜索</button>
          	 		</div>
          	 	</div>
          	 	<hr>
				<div class="row">
	                  <div class="col-md-12">
	                  	  <div class="content-panel">
		                      <table class="table" id="teachertbale">
		                          <thead>
		                          <tr>
		                              <th>用户名</th>
		                              <th>密码</th>
		                              <th>真名</th>
		                              <th>课程</th>
		                              <th>年级</th>
		                              <th>类别</th>
		                              <th>状态</th>
		                              <th>操作</th>
		                          </tr>
		                          </thead>
		                          <tbody>
		                          </tbody>
		                      </table>
		                      <div class="col-md-4 col-md-offset-8">
		                      	<input type="hidden" id="nowpage">
								<ul class="pager">
								  <li id="prev"><a href="javascript:void(0)" onclick="getPrevData()">&laquo; Prev</a></li>
								  <li id="next"><a href="javascript:void(0)" onclick="getNextData()">Next &raquo;</a></li>
								</ul>
							  </div>
	                  	  </div><!--/content-panel -->
	                  </div><!-- /col-md-12 -->
	                  </div>
	           </section><!--/wrapper -->
      </section>

      <!--main content end-->
  </section>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						用户操作
					</h4>
				</div>
				<div class="modal-body">
					<form role="form" id="formdata">
					  <div class="form-group">
						<input type="hidden" name="id" value="">
					  </div>
					  <div class="form-group">
					    <label for="name">用户名</label>
					    <input type="text" class="form-control" name="username">
					  </div>
					  <div class="form-group">
					    <label for="name">密码</label>
					    <input type="text" class="form-control" name="password">
					  </div>
					  <div class="form-group">
					    <label for="name">真名</label>
					    <input type="text" class="form-control" name="realname">
					  </div>
					  <div class="form-group">
					    <label for="classNameId">课程</label>
					    <select class="form-control" name="classNameId">
					    </select>
					  </div>
					  <div class="form-group">
					    <label for="classType">年级</label>
					    <select class="form-control" name="classType">
					      <option value="1">一年级</option>
					      <option value="2">二年级 </option>
					      <option value="3">三年级</option>
					      <option value="4">四年级</option>
					      <option value="5">五年级</option>
					      <option value="6">六年级</option>
					    </select>
					  </div>
					  <div class="form-group">
					    <label for="teacherType">类别</label>
					    <select class="form-control" name="teacherType">
					      <option value="0">普通教师</option>
					      <option value="1">班主任 </option>
					    </select>
					  </div>
					  <div class="form-group">
					    <label for="status">状态</label>
					    <select class="form-control" name="status">
					      <option value="0">正常 </option>
					      <option value="1">异常</option>
					    </select>
					  </div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" data-dismiss="modal">取消
					</button>
					<button type="button" class="btn btn-success" onclick="updateTeacher();">确认
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/jquery-1.8.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="assets/js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
    
    <script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="assets/js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="assets/js/sparkline-chart.js"></script>    
	<script src="assets/js/zabuto_calendar.js"></script>	
	
	<script type="text/javascript">
		$(function(){
			getData(1,null);
			getClassName();
		});
		
		function openModel(){
			$("#myModal").modal('show');
		}
		
		function getClassName(){
			$.ajax({
				type:'get',
				url:'${pageContext.request.contextPath }/classname_allNames',
				dataType:'json',
				data:null,
				async:false,
				error:function(result){
					alert(result);
				},
				success:function(result){
					var rs = result.result;
					var ls="";
					for(var i=0;i<rs.length;i++){
						ls += '<option value="'+rs[i].id+'">'+rs[i].className+'</option>';
					}
					$("#myModal form select[name='classNameId']").append(ls);
				}
			});
		}
			
		function getData(num,name){
			//防止对新的查询产生影响
			//清空
			$("#teachertbale tbody").html("");
			//解锁
			$("#prev").removeClass("disabled");
			$("#next").removeClass("disabled");
			
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath }/teacher_pageList',
				dataType:'json',
				data:{
					"pageNumber":num,
					"pageSize":5,
					"realname":name
				},
				async:false,
				error:function(result){
					alert(result);
				},
				success:function(result){
					var dt = result.result;
					//alert(JSON.stringify(dt));
					if(!dt.pre){
						$("#prev").addClass("disabled");
					}
					if(!dt.next){
						$("#next").addClass("disabled");
					}
					$("#nowpage").val(dt.page);
					
					var ls = dt.list;
					var trls;
					for(var i = 0;i<ls.length;i++){ 
						trls += "<tr>"+
							"<td>"+ls[i].username+"</td>"+
							"<td>"+ls[i].password+"</td>"+
							"<td>"+ls[i].realname+"</td>"+
							"<td>"+ls[i].className.className+"</td>"+
							"<td>"+ls[i].classType+"</td>"+
							"<td>"+isTeacher(ls[i].teacherType)+"</td>"+
							"<td>"+isStatus(ls[i].status)+"</td>"+
							"<td>"+
			                "<button class='btn btn-info btn-xs' onclick='edit("+ls[i].id+");'>修改</button>"+
			               	"</td>"+
							"</tr>";
					}
					$("#teachertbale tbody").append(trls);
				}
			});
		}
		
		function soso(){
			var name = $("#sosoname").val();
			getData(1,name);
		}
		
		function getPrevData(){
			var nowNum=$("#nowpage").val();
			//alert(parseInt(nowNum)-1);
			var preNum = parseInt(nowNum)-1;
			var name = $("#sosoname").val();
			getData(preNum,name);
		}
	
		function getNextData(){
			var nowNum=$("#nowpage").val();
			//alert(parseInt(nowNum)+1);
			var nextNum = parseInt(nowNum)+1;
			var name = $("#sosoname").val();
			getData(nextNum,name);
		}
		
		function edit(id){
			getInfo(id);
			$("#myModal").modal('show');
		}
		
		function getInfo(id){
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath }/teacher_getId',
				dataType:'json',
				data:{
					"id":id
				},
				async:false,
				error:function(result){
					alert(result);
				},
				success:function(result){
					var rs= result.result;
					$("#formdata input[name='id']").val(rs.id);
					$("#formdata input[name='username']").val(rs.username);
					$("#formdata input[name='password']").val(rs.password);
					$("#formdata input[name='realname']").val(rs.realname);
					$("#formdata select[name='classType']").val(rs.classType);
					$("#formdata select[name='classNameId']").val(rs.className.id);
					$("#formdata select[name='teacherType']").val(rs.teacherType);
					$("#formdata select[name='status']").val(rs.status);
				}
			});
		}
		
		function updateTeacher(){
			var form=$("#formdata").serialize();
			var id=$("#formdata input[name='id']").val();
			if(id==0 || id==null){
				$("#myModal").modal('hide');
				save(form);
			}else{
				$("#myModal").modal('hide');
				update(form);
			}
		}
		
		
		function update(form){
        	$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath }/teacher_update',
				dataType:'json',
				data:form,
				async:false,
				error:function(result){
					alert(result);
				},
				success:function(result){
					getData(1,null);
				}
			});
		}
		
		function save(form){
        	$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath }/teacher_save',
				dataType:'json',
				data:form,
				async:false,
				error:function(result){
					alert(result);
				},
				success:function(result){
					getData(1,null);
				}
			});
		}
		
		function isTeacher(str){
			if(str==0){
				return "普通教师";
			}else{
				return "班主任";
			}
		}
		
		function isStatus(str){
			if(str==0){
				return "正常";
			}else{
				return "异常";
			}
		}
	</script>
  

  </body>
</html>
