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
                      <a class="active" href="AdminClass.jsp">
                          <i class="fa fa-book"></i>
                          <span>课程名单</span>
                      </a>
                  </li>
                  <li class="sub-menu">
                      <a href="AdminTeacher.jsp">
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
          	<h3><i class="fa fa-angle-right"></i> 课程名单</h3>
          	
          	 	<div class="row">
          	 		<div class="col-md-3">
          	 			<button class="btn btn-info btn-sm" onclick="openModel();"><i class="fa fa-check"></i></button>
          	 		</div>
          	 	</div>
          	 	<hr>
				<div class="row">
	                  <div class="col-md-12">
	                  	  <div class="content-panel">
		                      <table class="table" id="dataTable">
		                          <thead>
		                          <tr>
		                              <th>课程名</th>
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
						课程操作
					</h4>
				</div>
				<div class="modal-body">
					<form role="form" id="formdata">
					  <div class="form-group">
						<input type="hidden" name="id" value="0">
					  </div>
					  <div class="form-group">
					    <label for="name">课程名</label>
					    <input type="text" class="form-control" name="className">
					  </div>
					  <div class="form-group">
					    <label for="name">是否有效</label>
					    <select class="form-control" name="status">
					      <option value="0">有效 </option>
					      <option value="1">失效 </option>
					    </select>
					  </div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" data-dismiss="modal">取消
					</button>
					<button type="button" class="btn btn-success" onclick="updateClass();">确认
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
			getData(1);
		});
		
		function openModel(){
			$("#myModal").modal('show');
		}
		
		function getData(num){
			//防止对新的查询产生影响
			//清空
			$("#dataTable tbody").html("");
			//解锁
			$("#prev").removeClass("disabled");
			$("#next").removeClass("disabled");
			
			$.ajax({
				type:'get',
				url:'${pageContext.request.contextPath }/classname_pagelist',
				dataType:'json',
				data:{
					"pageNumber":num,
					"pageSize":5
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
							"<td>"+ls[i].className+"</td>"+
							"<td>"+isOK(ls[i].status)+"</td>"+
							"<td>"+
			                "<button class='btn btn-info btn-xs' onclick='edit("+ls[i].id+");'>修改</button>"+
			               	"</td>"+
							"</tr>";
					}
					$("#dataTable tbody").append(trls);
				}
			});
		}
		
		function getPrevData(){
			var nowNum=$("#nowpage").val();
			//alert(parseInt(nowNum)-1);
			var preNum = parseInt(nowNum)-1;
			getData(preNum);
		}
		
		function getNextData(){
			var nowNum=$("#nowpage").val();
			//alert(parseInt(nowNum)+1);
			var nextNum = parseInt(nowNum)+1;
			getData(nextNum);
		}
		
		function edit(id){
			getInfo(id);
			$("#myModal").modal('show');
		}
		
		function getInfo(id){
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath }/classname_getId',
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
					$("#formdata input[name='className']").val(rs.className);
					$("#formdata select").val(rs.status);
				}
			});
		}
		
		function updateClass(){
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
				url:'${pageContext.request.contextPath }/classname_update',
				dataType:'json',
				data:form,
				async:false,
				error:function(result){
					alert(result);
				},
				success:function(result){
					getData(1);
				}
			});
		}
		
		function save(form){
        	$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath }/classname_save',
				dataType:'json',
				data:form,
				async:false,
				error:function(result){
					alert(result);
				},
				success:function(result){
					getData(1);
				}
			});
		}
		
		function isOK(str){
			if(str==0){
				return "有效";
			}else{
				return "失效";
			}
			
		}
	</script>
  

  </body>
</html>
