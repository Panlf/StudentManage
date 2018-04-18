<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%@ taglib uri="/struts-tags" prefix="s"%>  
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <title>分数单</title>

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
                    <li><a class="logout" href="${pageContext.request.contextPath }/student_loginout">登出</a></li>
            	</ul>
            </div>
            <s:if test="#session.existUserId != null">
           		<input type="hidden" id="userid" name="userid" value="<s:property value="#session.existUserId"/>">
           	</s:if>
           	
           	<s:if test="#session.existUserType != null">
           		<input type="hidden" id="userType" name="userType" value="<s:property value="#session.existUserType"/>">
           	</s:if>
           	
           	<s:if test="#session.teacherType != null">
           		<input type="hidden" id="teacherType" name="teacherType" value="<s:property value="#session.teacherType"/>">
           	</s:if>
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
              	<s:if test="#session.existUserType == 1">
                  <li class="mt">
                      <a  href="index.jsp">
                          <i class="fa fa-book"></i>
                          <span>分数修改</span>
                      </a>
                  </li>
                </s:if>
                <s:if test="#session.teacherType == 1">
                  <li class="sub-menu">
                      <a class="active" href="AllScore.jsp">
                          <i class="fa fa-user"></i>
                          <span>分数查看</span>
                      </a>
                  </li>
               	</s:if>
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
          	<h3><i class="fa fa-angle-right"></i> 分数单</h3>
          	
          	 	
          	 	<hr>
				<div class="row">
	                  <div class="col-md-12">
	                  	  <div class="content-panel">
		                      <table class="table" id="dataTable">
		                          <thead>
		                          <tr>
		                              <th>名单</th>
		                              <th>操作</th>
		                          </tr>
		                          </thead>
		                          <tbody>
		                          </tbody>
		                      </table>
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
						分数详情
					</h4>
				</div>
				<div class="modal-body">
					<table class="table" id="modaldata">
		                          <thead>
		                          <tr>
		                              <th>科目</th>
		                              <th>分数</th>
		                          </tr>
		                          </thead>
		                          <tbody>
		                          </tbody>
		             </table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">确认
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
			var usersid = $("#userid").val();
			var userType = $("#userType").val();
			var teacherType = $("#teacherType").val();
			if(usersid==null || usersid==undefined || userType==0 || teacherType==0){
				window.location.href="${pageContext.request.contextPath }/login.jsp";
			}
			
			getData();
		});
		
		
		function getDataInfo(usersid){
			//清空
			$("#modaldata tbody").html("");
			$.ajax({
				type:'get',
				url:'${pageContext.request.contextPath }/grade_myScore',
				dataType:'json',
				data:{
					"studentId":usersid
				},
				async:false,
				error:function(result){
					alert(result);
				},
				success:function(result){
					var ls = result.result;
					//alert(JSON.stringify(dt));
					var trls;
					for(var i = 0;i<ls.length;i++){ 
						trls += "<tr>"+
							"<td>"+nullToEmpty(ls[i].className)+"</td>"+
							"<td>"+nullToEmpty(ls[i].score)+"</td>"+
							"</tr>";
					}
					$("#modaldata tbody").append(trls);
				}
			});
		}
		
		function info(userid){
			$("#myModal").modal('show');
			getDataInfo(userid);
		}
		
		function getData(){
			//清空
			$("#dataTable tbody").html("");
			var usersid = $("#userid").val();
			$.ajax({
				type:'get',
				url:'${pageContext.request.contextPath }/student_list',
				dataType:'json',
				data:{
					"teacherId":usersid
				},
				async:false,
				error:function(result){
					alert(result);
				},
				success:function(result){
					var ls = result.result;
					//alert(JSON.stringify(dt));
					var trls;
					for(var i = 0;i<ls.length;i++){ 
						trls += "<tr>"+
							"<td>"+nullToEmpty(ls[i].realname)+"</td>"+
							"<td><button class='btn btn-info btn-xs' onclick='info("+ls[i].id+");'>详情</button></td>"+
							"</tr>";
					}
					$("#dataTable tbody").append(trls);
				}
			});
		}
		
		function nullToEmpty(str){
			if(str==null){
				return ""
			}else{
				return str;
			}
		}
		
		
	</script>
  

  </body>
</html>
