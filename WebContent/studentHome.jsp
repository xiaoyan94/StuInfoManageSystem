<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html>
  <html>
    <head>
      <!--Import Google Icon Font-->
      <style type="text/css">
      /* fallback */
@font-face {
  font-family: 'Material Icons';
  font-style: normal;
  font-weight: 400;
  src: url(http://fonts.gstatic.com/s/materialicons/v38/flUhRq6tzZclQEJ-Vdg-IuiaDsNc.woff2) format('woff2');
}

.material-icons {
  font-family: 'Material Icons';
  font-weight: normal;
  font-style: normal;
  font-size: 24px;
  line-height: 1;
  letter-spacing: normal;
  text-transform: none;
  display: inline-block;
  white-space: nowrap;
  word-wrap: normal;
  direction: ltr;
  -moz-font-feature-settings: 'liga';
  -moz-osx-font-smoothing: grayscale;
}
      </style>
      <!-- <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"> -->
      <!--Import materialize.css-->
      <link rel="stylesheet" href="css/materialize.min.css">
      <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
	  <link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css"> -->
	<%-- <script type="text/javascript"
		src="http://code.jquery.com/jquery-1.8.2.min.js"></script> --%>
		<link rel="stylesheet" type="text/css" href="css/sign.css" />
	
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <meta charset="utf-8">
      <title>学生 - 科大校外学生管理平台</title>
      <style type="text/css">
        #tab1 li:hover{
          background-color: cyan;
        }
      </style>
    </head>
    <body>
      <!-- 注销确认弹出框 -->
      <div id="logout" class="modal">
        <div class="modal-content">
          <h4>注销登录</h4>
          <p>您确认退出登录？</p>
        </div>
        <div class="modal-footer">
          <a href="logoutAction" onclick="Materialize.toast('已提交操作', 4000, 'rounded')" class="modal-action modal-close waves-effect waves-green red btn waves-light">确认<i class="material-icons right">send</i></a>
          <span class="right">&nbsp;&nbsp;</span>
          <a href="javascript:void(0);" onclick="Materialize.toast('操作已取消', 4000, 'rounded')" class="modal-action modal-close waves-effect waves-green btn waves-light">取消<i class="material-icons right">cancel</i></a>
        </div>
      </div>
      <!-- DROPDOWN -->
      <ul id="dropdown1" class="dropdown-content">
        <li><a href="#!">个人信息</a></li>
        <li><a href="#!">密码修改</a></li>
        <li class="divider"></li>
        <li><a href="#logout">注销</a></li>
      </ul>
      <nav class="nav-extended active lighten-1" >
        <div class="nav-wrapper">
          <a href="" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
          <a href="" class="brand-logo center">科大校外学生管理</a>
          <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="#">首页</a></li>
            <li><a href="#!" class="dropdown-button" data-activates="dropdown1" data-beloworigin="true">欢迎您，<s:property value="#session.student.name"/><i class="material-icons right">arrow_drop_down</i></a></li>
          </ul>
          <ul id="dropdown1" class="dropdown-content">
            <li><a href="#!">个人信息</a></li>
            <li><a href="#!">密码修改</a></li>
            <li class="divider"></li>
            <li><a href="#logout">注销</a></li>
          </ul>
        </div>
        <div class="nav-content">
          <ul id="tab1" class="tabs tabs-transparent">
              <li class="tab col s3"><a class="active" href="#sign">考勤签到</a></li>
              <li class="tab col s3"><a href="#edit-student" onclick="edit_student(${student.id})">个人信息管理</a></li>
              <li class="tab col s3"><a href="#liuyan_tab" onclick="">留言沟通</a></li>
              <li class="tab col s3"><a href="#notice_tab" onclick="">公告通知</a></li>
              <!-- <li class="tab col s3 disabled"><a href="" onclick="">更多</a></li> -->
          </ul>
        </div>
      </nav>
      <div class="section"></div>
      <div class="container" style="width: 80%">
        <%@include file="studentHome_qiandao.jsp" %>
        <%@include file="studentHome_edit.jsp" %>
        <!-- tab3 开始 -->
        		<div id="notice_tab" class="col s12">
		  <ul class="collapsible popout" data-collapsible="expandable">
		    <li class="active">
		      <div class="collapsible-header active"><i class="material-icons">filter_drama</i>公告标题一</div>
		      <div class="collapsible-body">
		      	<p>内容：人的一生，其实就是一场自己对自己的战争。</p>
		      </div>
		    </li>
		    <li class="active">
		      <div class="collapsible-header active"><i class="material-icons">place</i>二</div>
		      <div class="collapsible-body"><p>人的一生，其实就是一场自己对自己的战争。</p></div>
		    </li>
		    <li class="active">
		      <div class="collapsible-header active"><i class="material-icons">whatshot</i>三</div>
		      <div class="collapsible-body"><p>人的一生，其实就是一场自己对自己的战争。</p></div>
		    </li>
		  </ul>
		  
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
		</div>
		
		<div id="liuyan_tab" class="col s12">
		  <ul class="collapsible popout" data-collapsible="accordion">
		    <li class="active">
		      <div class="collapsible-header active"><i class="material-icons">filter_drama</i>
		      	留言一
		      </div>
		      <div class="collapsible-body">
		      	<p>人的一生，其实就是一场自己对自己的战争。</p>
		      	<div class="divider"></div>
		      	<a style="margin-top:5px " class="right waves-effect waves-light btn tooltipped" data-position="bottom" data-tooltip="详情" href="#!" onclick="details_admin('<s:property value="#admin.adminId"/>')"><i class="material-icons left">add</i>
		      	编辑
		      	</a>
		      	<div class="section"></div>
		      </div>
		    </li>
		    <li>
		      <div class="collapsible-header"><i class="material-icons">place</i>二</div>
		      <div class="collapsible-body"><p>人的一生，其实就是一场自己对自己的战争。</p></div>
		    </li>
		    <li>
		      <div class="collapsible-header"><i class="material-icons">whatshot</i>三</div>
		      <div class="collapsible-body"><p>人的一生，其实就是一场自己对自己的战争。</p></div>
		    </li>
		  </ul>
		</div>
		
		<!-- 测试 -->
		<%-- <%@include file="materializecss_test.jsp" %> --%>
		<!-- 测试 -->
        
<!--    全局悬浮按钮
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

      </div>
      <!-- ./container结束 -->
      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script> --%>
      <script src="js/materialize.min.js"></script>
      <script type="text/javascript" src="js/myjs/calendar.js"></script>
      <script type="text/javascript" src="js/myjs/userManage.js"></script>
      <script type="text/javascript" src="js/myjs/studentHome.js"></script>
      <script>
      	//必须在页面加载完成之前
      	showTips();
        $(document).ready(function(){
        	
          $('select').material_select();
          // Init Carousel
          $('.carousel').carousel();

          // Init Carousel Slider
          $('.carousel.carousel-slider').carousel({fullWidth:true});

          // Fire off toast
          //Materialize.toast('Hello World', 3000);

          // Init Slider
          $('.slider').slider();

          // Init Modal
          $('.modal').modal({
            dismissible:true,
            endingTop:'10%'
          });

          // Init Sidenav
          $('.button-collapse').sideNav();

          $('.dropdown-button').dropdown({
              inDuration: 300,
              outDuration: 225,
              constrain_width: false, // Does not change width of dropdown to that of the activator
              hover: true, // Activate on hover
              gutter: 0, // Spacing from edge
              belowOrigin: true, // Displays dropdown below the button
              alignment: 'left' // Displays dropdown with edge aligned to the left of button
            }
          );
           /* $('.tooltipped').tooltip({
             enterDelay:1,
             inDuration:1
           }); */
          initSignCalendar();
          initTapTarget();
        });
        //批量为按钮添加提示功能
        //tooltipped" data-position="top" data-tooltip="确认更新资料吗？"
        /* $('a:contains(取消)').attr('class',$('a:contains(取消)').attr('class')+' tooltipped');
        $('a:contains(取消)').attr('data-position','top');
        $('a:contains(取消)').attr('href','#!');
        $('a:contains(取消)').attr('data-tooltip','取消操作并且返回');
        $('a:contains(取消)').attr('onclick','Materialize.toast("操作已取消", 4000, "rounded");'); */
        
        //Materialize.toast('Hello,<s:property value="#session.user.adminRealName"/>', 4000, 'rounded');
        Materialize.toast('<s:property value="#session.msg"/>', 4000, 'rounded');
      </script>
    </body>
  </html>
    