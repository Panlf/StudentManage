<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <title>登录</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" id="formdata">
		        <h2 class="form-login-heading">管理员登录</h2>
		        <div class="login-wrap">
		            <input type="text" class="form-control" placeholder="用户名" name="username" autofocus>
		            <br>
		            <input type="password" class="form-control" placeholder="密码" name="password">
		            <label class="checkbox">
		            </label>
		            <button class="btn btn-theme btn-block" onclick="loginUser();"><i class="fa fa-lock"></i> 登录</button>
		        </div>
		      </form>	  	
	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("assets/img/login-bg.jpg", {speed: 500});
        
        function loginUser(){
        	var form=$("#formdata").serialize();
        	$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath }/manage_login',
				dataType:'json',
				data:form,
				async:false,
				error:function(result){
					alert(result);
				},
				success:function(result){
					if(result.code==1){
						window.location.href="AdminClass.jsp";
						window.event.returnValue=false;
					}else{
						window.location.reload();
					}
				}
			});
        }
        
    </script>


  </body>
</html>
