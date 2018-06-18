<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta charset="utf-8">
<title>学生 - 科大校外学生管理平台</title>
<style type="text/css">
#tab1 li:hover {
	background-color: cyan;
}
</style>
</head>
<body>
	<div class="row" id="edit-student">
		<div class="row">
			<div class="col s12">
				<ul class="tabs">
					<li class="tab col s4 active"><a class="active"
						href="#edit_t1">基本信息</a></li>
					<li class="tab col s4"><a href="#edit_t2">去向信息</a></li>
					<li class="tab col s4	"><a href="#edit_t3">其他信息</a></li>
				</ul>
			</div>
		</div>
		<form style="height: 280px" id="form_student_edit_t2" class="col s12"
			action="studentAction_save" method="post">
			<div id="edit_t1" class="col s12" style="height: 300px">
				<div class="row">
					<div class="input-field col s6">
						<i class="material-icons prefix">group</i> <select disabled="disabled"
							id="edit_student_classes" name="student_classes">
							<option value="" disabled selected>请选择班级</option>
							<!-- <option value="1">选项 1</option> -->
						</select> <label>所在班级</label>
					</div>
					<div class="input-field col s6">
						<i class="material-icons prefix">navigation</i> <select disabled="disabled"
							id="edit_student_going" name="student_going">
							<option value="" disabled selected>请选择去向</option>
							<!-- <option value="1">选项 1</option> -->
						</select> <label>去向</label>
					</div>
					<div class="input-field col s6 ">
						<i class="material-icons prefix">account_circle</i> <input
							readonly="readonly" required="required" id="edit_student_id"
							name="id" type="text" class="validate required" data-length="20"
							value=" "> <label for="edit_student_id">学号</label>
					</div>
					<div class="input-field col s6">
						<i class="material-icons prefix">person</i> <input readonly="readonly"
							required="required" id="edit_student_name" name="name"
							type="text" class="validate" data-length="20" value=" ">
						<label for="edit_student_name">姓名</label>
					</div>
					<div class="input-field col s6">
						<i class="material-icons prefix">spa</i> <label> <span>性别</span></label>
						<div class="col s4 offset-s2">
							<input required="required" checked id="edit_student_nan" class=""
								name="sex" type="radio" value="男" /> <label
								for="edit_student_nan">男</label> <input required="required"
								class="" id="edit_student_nv" name="sex" type="radio" value="女" />
							<label for="edit_student_nv">女</label>
						</div>
					</div>
				</div>
				<div class="section"></div>
				<div class="modal-footer right">
				    <a id="edit_student_link" onclick="edit_student_ajax()" class="modal-action modal-close waves-effect waves-green red btn waves-light">更新资料<i class="material-icons right">send</i></a>
				    <span class="right">&nbsp;&nbsp;</span>
				    <a href="javascript:$('ul.tabs').tabs('select_tab', 'edit_t2');;" class="modal-action modal-close waves-effect waves-green btn waves-light">下一页<i class="material-icons right">arrow_forward</i></a>
				</div>
			</div>
			<!-- end tab1 -->
			<div id="edit_t2" class="col s12" style="height: 300px">
				<div class="section"></div>
				<div class="input-field col s6">
					<i class="material-icons prefix">group</i> <input
						required="required" id="edit_student_workName"
						name="edit_student_workName" type="text" class="validate"
						data-length="20" value=" "> <label
						for="edit_student_workName">单位</label>
				</div>
				<div class="input-field col s6">
					<i class="material-icons prefix">person</i> <input
						required="required" id="edit_student_workLinkmanName"
						name="edit_student_workLinkmanName" type="text" class="validate"
						data-length="20" value=" "> <label
						for="edit_student_workLinkmanName">单位联系人姓名</label>
				</div>
				<div class="input-field col s6">
					<i class="material-icons prefix">phone</i> <input
						required="required" id="edit_student_workTel"
						name="edit_student_workTel" type="tel" class="validate"
						data-length="11" value=" "> <label
						for="edit_student_workTel">单位联系电话</label>
				</div>
				<div class="input-field col s6">
					<i class="material-icons prefix">navigation</i> <input
						required="required" id="edit_student_workAddress"
						name="edit_student_workAddress" type="text" class="validate"
						data-length="20" value=" "> <label
						for="edit_student_workAddress">单位地址</label>
				</div>
				<div class="section"></div>
				<div class="modal-footer right">
				    <a id="edit_student_link" onclick="edit_student_ajax()" class="modal-action modal-close waves-effect waves-green red btn waves-light">更新资料<i class="material-icons right">send</i></a>
				    <span class="right">&nbsp;&nbsp;</span>
				    <a href="javascript:$('ul.tabs').tabs('select_tab', 'edit_t3');;" class="modal-action modal-close waves-effect waves-green btn waves-light">下一页<i class="material-icons right">arrow_forward</i></a>
				</div>
			</div>
			<div id="edit_t3" class="col s12" style="height: 300px">
				<div class="section"></div>
				<div class="input-field col s6">
					<i class="material-icons prefix">vpn_key</i> <input 
						required="required" id="edit_student_password" name="password"
						type="password" class="validate" data-length="20" value=" ">
					<label for="edit_student_password">登录密码</label>
				</div>
				<div class="input-field col s6">
					<i class="material-icons prefix">phone</i> <input
						required="required" id="edit_student_tel" name="tel" type="tel"
						class="validate" data-length="11" value=" "> <label
						for="edit_student_tel">联系电话</label>
				</div>
				<div class="input-field col s6">
					<i class="material-icons prefix">email</i> <input
						id="edit_student_email" name="email" type="email" class="validate"
						value=" "> <label for="edit_student_email">Email</label>
				</div>
				<div class="input-field col s6">
					<i class="material-icons prefix">person</i> <input
						required="required" id="edit_student_idCard" name="idCard"
						type="text" class="validate" data-length="20" value=" "> <label
						for="edit_student_idCard">身份证号</label>
				</div>
				<div class="section"></div>
				<div class="modal-footer right">
				    <a id="edit_student_link" onclick="edit_student_ajax()" class="modal-action modal-close waves-effect waves-green red btn waves-light">更新资料<i class="material-icons right">send</i></a>
				    <span class="right">&nbsp;&nbsp;</span>
				    <a href="javascript:$('ul.tabs').tabs('select_tab', 'edit_t1');;" class="modal-action modal-close waves-effect waves-green btn waves-light">下一页<i class="material-icons right">arrow_forward</i></a>
				</div>
			</div>
			
			<!-- <div class="row">
            <div id="edit_student_link" onclick="edit_student_ajax()" class="modal-action modal-close input-field col s5 waves-effect waves-light btn">更新此学生信息</div>
            	<div class="col s2"></div>
            <div id="" onclick="" class="modal-action modal-close input-field col s5 waves-effect waves-light btn">返回</div>
          </div> -->
		</form>
	</div>

	<!--    悬浮按钮
        <div class="fixed-action-btn">
          <a class="btn-floating btn-large red oulse">
            <i class="large material-icons">add</i>
          </a>
          <ul>
            <li><a class="btn-floating red"><i class="material-icons">insert_chart</i></a></li>
            <li><a class="btn-floating yellow darken-1"><i class="material-icons">format_quote</i></a></li>
            <li><a class="btn-floating green"><i class="material-icons">publish</i></a></li>
            <li><a class="btn-floating blue"><i class="material-icons">attach_file</i></a></li>
          </ul>
        </div>
-->

	<!-- ./container结束 -->
	<!--Import jQuery before materialize.js-->
	<%-- <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
       --%>
<%-- 	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
	<script>
		$(document).ready(function() {

			$('select').material_select();
			// Init Carousel
			$('.carousel').carousel();

			// Init Carousel Slider
			$('.carousel.carousel-slider').carousel({
				fullWidth : true
			});

			// Fire off toast
			//Materialize.toast('Hello World', 3000);

			// Init Slider
			$('.slider').slider();

			// Init Modal
			$('.modal').modal({
				dismissible : true,
				endingTop : '10%'
			});

			// Init Sidenav
			$('.button-collapse').sideNav();

			$('.dropdown-button').dropdown({
				inDuration : 300,
				outDuration : 225,
				constrain_width : false, // Does not change width of dropdown to that of the activator
				hover : true, // Activate on hover
				gutter : 0, // Spacing from edge
				belowOrigin : true, // Displays dropdown below the button
				alignment : 'left' // Displays dropdown with edge aligned to the left of button
			});
			// $('.tooltipped').tooltip({
			//   enterDelay:1,
			//   inDuration:1
			// });
		});
		//批量为按钮添加提示功能
		//tooltipped" data-position="top" data-tooltip="确认更新资料吗？"
		$('a:contains(取消)').attr('class',
				$('a:contains(取消)').attr('class') + ' tooltipped');
		$('a:contains(取消)').attr('data-position', 'top');
		$('a:contains(取消)').attr('href', '#!');
		$('a:contains(取消)').attr('data-tooltip', '取消操作并且返回');
		$('a:contains(取消)').attr('onclick',
				'Materialize.toast("操作已取消", 4000, "rounded");');

		//Materialize.toast('Hello,<s:property value="#session.user.adminRealName"/>', 4000, 'rounded');
		Materialize
				.toast('<s:property value="#session.msg"/>', 4000, 'rounded');
		//解决单选按钮不显示
		// $(":radio").css("position","unset");
		// $(":radio").css("opacity","1");
	</script>
	<script type="text/javascript" src="js/myjs/userManage.js"></script>
 --%></body>
</html>
