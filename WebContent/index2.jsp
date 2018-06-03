<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>科大校外学生管理平台</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".dropdown-trigger").dropdown();
		alert("js ok");
	});
</script>

<script type="text/javascript" src="js/materialize.min.js"></script>
</head>
<body>
	<!-- Navbar goes here -->
	<!-- Dropdown Structure -->
	<ul id="dropdown1" class="dropdown-content">
		<li><a href="#!">管理员管理</a></li>
		<li class="divider"></li>
		<li><a href="#!">学生管理</a></li>
	</ul>
	<ul id="dropdown2" class="dropdown-content">
		<li><a href="#!">信息管理</a></li>
		<li><a href="#!">two</a></li>
		<li class="divider"></li>
		<li><a href="#!">three</a></li>
	</ul>
	<ul id="dropdown3" class="dropdown-content">
		<li><a href="#!">学院管理</a></li>
		<li><a href="#!">专业管理</a></li>
		<li class="divider"></li>
		<li><a href="#!">班级管理</a></li>
	</ul>
 	<nav class="nav">
		<div class="nav-wrapper">
			<a href="#!" class="brand-logo right  hide-on-small-only">科大校外学生管理平台</a>
			<ul class="left">
				<li><a class="dropdown-trigger" data-target="dropdown1" href="#!">用户管理<i class="material-icons right">arrow_drop_down</i></a></li>
				<li><a href="">链接</a></li>
				<li><a class="dropdown-trigger" href="#!"
					data-target="dropdown1">Dropdown<i class="material-icons right">arrow_drop_down</i></a></li>
			</ul>
		</div	>
	</nav>

	<hr />
	<div class="divider"></div>

	<!-- Page Layout here -->
	
	<div class="row">

		<div class="col s12 m3 l2">
			<!-- Note that "m4 l3" was added -->
			<!-- Grey navigation panel

              This content will be:
          3-columns-wide on large screens,
          4-columns-wide on medium screens,
          12-columns-wide on small screens  -->

			<div class="collection">
				<a href="#!" class="collection-item dropdown-trigger"
					data-target="dropdown2">>> 学生管理</a> <a href="#!"
					class="collection-item active dropdown-trigger"
					data-target="dropdown3">>> 院系管理</a> <a href="#!"
					class="collection-item">Alvin</a> <a href="#!"
					class="collection-item">Alvin</a> <a href="#!"
					class="collection-item">Alvin</a> <a href="#!"
					class="collection-item">Alvin</a>
			</div>

		</div>

		<div class="col s12 m9 l10">
			Note that "m8 l9" was added
			Teal page content
			<br/>
              This content will be:
          9-columns-wide on large screens,
          8-columns-wide on medium screens,
          12-columns-wide on small screens 
		</div>

	</div>
	
	<%-- <%@include file="footer.jsp"%> --%>
</body>
</html>