<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎登录</title>
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript">
	
	
	$(function() {
		if(''!='${msg}'){
			M.toast({html: '${msg}', classes: 'rounded', displayLength:4000});
		}
		$("#login_btn").click(function(){
			if($("input[type='radio'][name='role']:checked").length == 0){
				//alert('长度为0');
				M.toast({html: '<span class="white-text">请选择登录身份</span>', classes: 'rounded', displayLength:4000});
				//return;
			}
			if($('#username').val()==""){
				M.toast({html: '<span class="white-text">用户名不能为空</span>', classes: 'rounded', displayLength:4000});
				//return;
			}
			if($('#password').val()==""){
				M.toast({html: '<span class="white-text">密码不能为空 ！</span>', classes: 'rounded', displayLength:4000});
				return;
			}
			$("#form").submit();
			//alert("ok");
			//M.toast({html: 'ss', classes: 'rounded', displayLength:4000});
			 /*
			 Materializecss版本不同写法不同
			 Materialize.toast('Hello,<s:property value="#session.user.adminRealName"/>', 4000, 'rounded');
	         */
			//alert("s");
		});
		//alert("");
	});
</script>
</head>
<body>
	<div class="container">
		<div class="section"></div>
		<div class="row" style="width: 400px;">
			<div class="container">
				<img class="responsive-img" style="width: 250px;"
					src="https://i.imgur.com/ax0NCsK.gif" />
				<h5 class="indigo-text">科大校外学生管理系统</h5>
				<div class="section"></div>
			</div>
				<div class="section"></div>

			<form id="form" class="col s12" method="post" action="loginAction_login">
				<div class="row">
					<div class="col s12 offset-s0">
						<label> <span>登录身份</span></label> <label> <input <s:if test="#session.role==0">checked</s:if>
							class="with-gap" name="role" type="radio" required="required" value="0" /> <span>学生</span>
						</label> <label> <input class="with-gap" name="role"
							type="radio" required="required" value="1" <s:if test="#session.role==1">checked</s:if>/> <span>普通管理员</span>
						</label>
						<label> <input class="with-gap" name="role"
							type="radio" required="required" value="2" <s:if test="#session.role==2">checked</s:if>/> <span>系统管理员</span>
						</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="username" name="username" type="text" class="validate" value='<s:property value="#session.username"/>'> <label
							for="username">用户名</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="password" name="password" type="password" class="validate"> <label
							for="password">密码</label>
					</div>
					<%-- <div class="red-text col s11 offset-s1"><s:actionerror/></div>
					<div class="green-text col s11 offset-s1"><s:property value="#msg"/></div> --%>
				</div>
				<div class="row">
					<div id="login_btn" class="pulse input-field col s12 waves-effect waves-light btn" >
						登录
					</div>
				</div>
				<div>
					<a class="right" href="#!">忘记密码？</a>
				</div>
			</form>
		</div>

	</div>
</body>
</html>