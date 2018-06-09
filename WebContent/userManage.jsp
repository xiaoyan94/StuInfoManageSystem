<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html>
  <html>
    <head>
      <!--Import Google Icon Font-->   
	  <link href="css/icon.css" rel="stylesheet">
      <!--Import materialize.css-->
      <link rel="stylesheet" href="css/materialize-0.98.2.min.css">

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <meta charset="utf-8">
      <title>科大校外学生管理平台</title>
      <style type="text/css">
        #tab1 li:hover{
          background-color: cyan;
        }
      </style>
    </head>
    <body>
      <!-- SIDENAV -->
      <ul id="slide-out" class="side-nav">
        <li>
          <a href="#"><i class="material-icons">cloud</i> Link 1</a>
        </li>
        <li>
          <a href="#">Link 2</a>
        </li>
        <li>
          <div class="divider"></div>
        </li>
        <li>
          <a class="subheader" href="#">Subheaderr</a>
        </li>
        <li>
          <a class="waves-effect" href="#">Link 3</a>
        </li>
      </ul>
      <!-- <a href="" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a> -->

      <!--  -->
      <!-- 注销确认弹出框 -->
      <!-- Modal Structure -->
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
            <li><a href="statisticsAction">信息统计</a></li>
            <li class="active"><a href="adminAction">信息管理</a></li>
            <li><a href="messageAction">沟通交流</a></li>
            <li><a href="#!" class="dropdown-button" data-activates="dropdown1" data-beloworigin="true">欢迎您，<s:property value="#session.user.adminRealName"/><i class="material-icons right">arrow_drop_down</i></a></li>
          </ul>
          <ul id="dropdown1" class="dropdown-content">
            <li><a href="#!">个人信息</a></li>
            <li><a href="#!">密码修改</a></li>
            <li class="divider"></li>
            <li><a href="#!">注销</a></li>
          </ul>
        </div>
        <div class="nav-content">
          <ul id="tab1" class="tabs tabs-transparent col s12">
              <li class="tab col s2"><a class="active" href="#test1">普通管理员</a></li>
              <li class="tab col s2"><a href="#test2" onclick="refresh_student_list()">学生用户</a></li>
              <li class="tab col s2"><a href="#test3" onclick="refresh_college_list()">学院管理</a></li>
              <li class="tab col s2"><a href="#test4" onclick="refresh_profession_list()">专业管理</a></li>
              <li class="tab col s2"><a href="#test5" onclick="refresh_classes_list()">班级管理</a></li>
              <li class="tab col s2"><a href="#test6" onclick="refresh_going_list()">去向管理</a></li>
          </ul>
        </div>
      </nav>
      <div class="section"></div>
      <div class="container" style="width: 80%">
        <!-- TABS test1开始 普通管理员 -->
        <%@include file="userManage_tab1.jsp" %>
        <!-- tab1 test1普通管理员结束 -->

        <!-- tab2 学生开始 -->
        <%@include file="userManage_tab2.jsp" %>
        <!-- tab2 学生结束 -->

        <!-- tab3 开始 -->
        <%@include file="userManage_tab3.jsp" %>
        <%@include file="userManage_tab4.jsp" %>
        <%@include file="userManage_tab5.jsp" %>
        <%@include file="userManage_tab6.jsp" %>
		
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
      <div style="height:0px"></div>
      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
      <script src="js/materialize-0.98.2.min.js"></script>
      <script>
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
          // $('.tooltipped').tooltip({
          //   enterDelay:1,
          //   inDuration:1
          // });
        });
        //批量为按钮添加提示功能
        //tooltipped" data-position="top" data-tooltip="确认更新资料吗？"
        $('a:contains(取消)').attr('class',$('a:contains(取消)').attr('class')+' tooltipped');
        $('a:contains(取消)').attr('data-position','top');
        $('a:contains(取消)').attr('href','#!');
        $('a:contains(取消)').attr('data-tooltip','取消操作并且返回');
        $('a:contains(取消)').attr('onclick','Materialize.toast("操作已取消", 4000, "rounded");');
        
        //Materialize.toast('Hello,<s:property value="#session.user.adminRealName"/>', 4000, 'rounded');
        Materialize.toast('<s:property value="#msg"/>', 4000, 'rounded');
        //解决单选按钮不显示
        // $(":radio").css("position","unset");
        // $(":radio").css("opacity","1");
      </script>
      <script type="text/javascript" src="js/myjs/userManage.js"></script>
    </body>
  </html>
    