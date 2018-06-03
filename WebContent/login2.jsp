<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
<style>
body {
	display: flex;
	min-height: 100vh;
	flex-direction: column;
}

main {
	flex: 1 0 auto;
}

body {
	background: #fff;
}

.input-field input[type=date]:focus+label, .input-field input[type=text]:focus+label,
	.input-field input[type=username]:focus+label, .input-field input[type=password]:focus+label
	{
	color: #e91e63;
}

.input-field input[type=date]:focus, .input-field input[type=text]:focus,
	.input-field input[type=username]:focus, .input-field input[type=password]:focus
	{
	border-bottom: 2px solid #e91e63;
	box-shadow: none;
}
</style>
</head>

<body>
	<div class="section"></div>
	<center>
		<img class="responsive-img" style="width: 250px;"
			src="https://i.imgur.com/ax0NCsK.gif" />
		<div class="section"></div>

		<h5 class="indigo-text">科大校外学生管理平台</h5>
		<div class="section"></div>

		<div class="container">
			<div class="z-depth-1 grey lighten-4 row"
				style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

				<form class="col s12" method="post" action="${pageContext.request.contextPath }/StudentAction_login">
					<div class='row'>
						<div class='col s12'></div>
					</div>

					<div class='row'>
						<div class='input-field col s12'>
							<input class='validate' type='text' name='username'
								id='username' /> <label for='username'>输入您的用户名</label>
						</div>
					</div>
<%-- 					<div class='row'>
						<div class='input-field col s12'>
							<span class="red"><s:property value="exception.message"/></span>
						</div>
					</div> --%>

					<div class='row'>
						<div class='input-field col s12'>
							<input class='validate' type='password' name='password'
								id='password' /> <label for='password'>输入您的密码</label>
						</div>
						<label style='float: right;'> <a class='pink-text'
							href='#!'><b>忘记密码?</b></a>
						</label>
					</div>

					<font style="color: red"><s:property value="exception.message"/></font>
					<br />
					<br />
					<center>
						<div class='row'>
							<button type='submit' name='btn_login'
								class='col s12 btn btn-large waves-effect indigo'>登录</button>
						</div>
					</center>
				</form>
			</div>
		</div>
		<a href="#!">创建账户</a>
	</center>

	<div class="section"></div>
	<div class="section"></div>

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
</body>

</html>