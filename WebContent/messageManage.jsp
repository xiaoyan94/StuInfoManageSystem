<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

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
          <li><a href="adminAction_show">首页</a></li>
          <li><a href="statisticsAction">信息统计</a></li>
          <li><a href="adminAction">信息管理</a></li>
          <li class="active"><a href="#!">沟通交流</a></li>
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
        <ul id="tab1" class="tabs tabs-transparent">
            <li class="tab col s3"><a class="active" href="#liuyan_tab">留言管理</a></li>
            <li class="tab col s3"><a href="#notice_tab">公告管理</a></li>
            <li class="tab col s3 disabled"><a href="#test3">在线聊天</a></li>
            <li class="tab col s3"><a href="#test4">更多</a></li>
        </ul>
      </div>
    </nav>
    <div class="section"></div>
    <div class="container" style="width: 80%">
		<div id="notice_tab" class="col s12">
		  <ul class="collapsible popout" data-collapsible="expandable">
		    <li class="active">
		      <div class="collapsible-header active">
		      <i class="material-icons">filter_drama</i>
		   		   公告标题一
		      <a class="right">发布时间：2018-09-09</a>
		      </div>
		      <div class="collapsible-body">
		      	<div class="row">
		      	<p>内容：人的一生，其实就是一场自己对自己的战争。</p>
		      	<a class="right waves-effect waves-light btn tooltipped" data-position="bottom" data-tooltip="详情" href="#!" onclick="details_admin('<s:property value="#admin.adminId"/>')"><i class="material-icons left">delete</i>
		      	删除
		      	</a>
		      	</div>
		      </div>
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
		      <div class="collapsible-header active"><i class="material-icons">notice</i>
		      	留言一
		      	<a href="#!" class="right">留言作者：小明</a>
		      </div>
		      <div class="collapsible-body">
		      	<p>回复：人的一生，其实就是一场自己对自己的战争。</p>
		      	<div class="divider"></div>
		      	<a style="margin-top:5px " class="right waves-effect waves-light btn tooltipped" data-position="bottom" data-tooltip="详情" href="#!" onclick="details_admin('<s:property value="#admin.adminId"/>')"><i class="material-icons left">add</i>
		      	添加回复
		      	</a>
		      	<div class="section"></div>
		      </div>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
    <script>
      $(document).ready(function(){
    	//初始化折叠列表  
    	$('.collapsible').collapsible();  
    	
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
      
      //Materialize.toast('Hello,<s:property value="#session.user.adminRealName"/>', 4000, 'rounded');
      Materialize.toast('<s:property value="#msg"/>', 4000, 'rounded');
      //解决单选按钮不显示
      // $(":radio").css("position","unset");
      // $(":radio").css("opacity","1");
    </script>
    <script type="text/javascript" src="js/myjs/userManage.js"></script>
  </body>
</html>
    