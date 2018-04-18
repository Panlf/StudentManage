<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <!DOCTYPE html>
<html>
   <head>
      <title>注册</title>
      <!-- 在IE运行最新的渲染模式 -->
      <meta http-equiv="X-UA-Compatible" content="IE=edge">

      <!--为了让 Bootstrap 开发的网站对移动设备友好，确保适当的绘制和触屏缩放，需要在网页的 head 之中添加 viewport meta 标签
          initial-scale=1.0 确保网页加载时，以 1:1 的比例呈现，不会有任何的缩放
      -->
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <!-- 引入 Bootstrap -->
      <link href="assets/css/bootstrap.css" rel="stylesheet">

 	  <link href="assets/css/bootstrapValidator.min.css" rel="stylesheet">
      <link href="assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
      <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
      <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->

      <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="assets/js/jquery.js"></script>
      <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
      <script src="assets/js/bootstrap.min.js"></script>
	
      <script src="assets/js/bootstrap-datetimepicker.min.js"></script>
      <script src="assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
      
      <script src="assets/js/bootstrapValidator.min.js"></script>
      <script src="assets/js/zh_CN.js"></script>
      <style type="text/css">
            .bg{background:url("assets/img/bg1.jpg") repeat fixed;background-size:100% 100%;}
            .center-vertical {
                  display: block;

                  margin-top: 50px;

              }
       </style>
   </head>
   <body class="bg">
       <div class="row">
       <div class="col-md-4 col-md-push-7 center-vertical">
       <div class="panel panel-info">
          <div class="panel-heading">
            <h3 class="panel-title">
                学生注册
            </h3>
          </div>
          <div class="panel-body">
            <form class="form-horizontal" id="defaultForm" role="form">
              <div class="form-group">
                <label for="number" class="col-md-3 control-label">学号</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" name="number"
                       placeholder="请输入学号">
                </div>
              </div>
              <div class="form-group">
                <label for="realname" class="col-md-3 control-label">真名</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" name="realname"
                       placeholder="请输入真名">
                </div>
              </div>
              <div class="form-group">
                <label for="sex" class="col-md-3 control-label">性别</label>
                <div class="col-md-9">
                  <label class="radio-inline">
                  		<input type="radio" name="sex" id="male" value="0" checked> 男
                  </label>
                  	<label class="radio-inline">
                  		<input type="radio" name="sex" id="female"  value="1"> 女
                  	</label>
                </div>
              </div>
              <div class="form-group">
                <label for="username" class="col-md-3 control-label">用户名</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" name="username"
                       placeholder="请输入用户名">
                </div>
              </div>
              <div class="form-group">
                <label for="password" class="col-md-3 control-label">密码</label>
                <div class="col-md-9">
                  <input type="password" class="form-control" name="password"
                       placeholder="请输入密码">
                </div>
              </div>
              <div class="form-group">
                <label for="birthday" class="col-md-3 control-label">生日</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" name="birthday" id="date"
                       placeholder="请选择生日">
                </div>
              </div>
			<div class="form-group">
			    <label for="classType" class="col-md-3 control-label">班级</label>
			     <div class="col-md-9">
				    <select class="form-control" name="classType">
				      <option value="1">一年级</option>
				      <option value="2">二年级</option>
				      <option value="3">三年级</option>
				      <option value="4">四年级</option>
				      <option value="5">五年级</option>
				      <option value="6">六年级</option>
				    </select>
			    </div>
			 </div>
              <div class="form-group">
                <div class="col-md-offset-3 col-sm-9">
                  <button class="btn btn-info" onclick="saveStudent();">注册</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript">
    $(function(){
        $("#date").datetimepicker({
          format: "yyyy-mm-dd",
          language:  'zh-CN',
          autoclose: true,
          minView: 2
        });
        
        $('#defaultForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
              valid: 'glyphicon glyphicon-ok',
              invalid: 'glyphicon glyphicon-remove',
              validating: 'glyphicon glyphicon-refresh'
            },
	      fields: {
	          username: {
	              validators: {
	                  notEmpty: {
	                      message: '用户名不能为空'
	                  },
	                  stringLength: {
	                      min: 6,
	                      max: 30,
	                      message: '用户名字符必须大于6小于30'
	                  },
	                  regexp: {
	                      regexp: /^[a-zA-Z0-9_\.]+$/,
	                      message: '用户名只能是字符、数字、点'
	                  }
	              }
	          },
	          number: {
	              validators: {
	                  notEmpty: {
	                      message: '学号不能为空'
	                  }
	              }
	          },
	          realname: {
	              validators: {
	                  notEmpty: {
	                      message: '真名不能为空'
	                  }
	              }
	          },
	          password: {
	              validators: {
	                  notEmpty: {
	                      message: '密码不能为空'
	                  }
	              }
	          }
	      }
	  });
    });
    
    function saveStudent(){
       var bootstrapValidator = $("#defaultForm").data('bootstrapValidator');
   	   bootstrapValidator.validate();
   	   if(bootstrapValidator.isValid()){
   		   //alert('成功可以提交');
   		   var form = $("#defaultForm").serialize();
	   		$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath }/student_save',
				dataType:'json',
				data:form,
				async:false,
				error:function(result){
					alert(result);
				},
				success:function(result){
					if(result.code==1){
						window.location.href="${pageContext.request.contextPath }/login.jsp";
					}else{
						window.location.reload();
					}
				}
			});
   	   }else{
   		   return;
   	   } 
    }
    </script>
   </body>
</html>
    
