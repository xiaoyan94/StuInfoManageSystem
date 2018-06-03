<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="test4">
        <!-- CAROUSEL -->
        <h1>CAROUSEL</h1>

        <!-- CAROUSEL FULL SLIDER -->
        <h1>CAROUSEL FULL SLIDER</h1>
      

        <!-- COLLAPSIBLE -->
        <h1>COLLAPSIBLE</h1>
        

        <!--TOASTS-->
        <h1>TOASTS</h1>
        <a onclick="Materialize.toast('Post Saved', 4000, 'rounded')" class="btn pulse">Toast!</a>

        <!-- TOOLTIPS -->
        <h1>TOOLTIPS</h1>
        <a href="" class="btn tooltipped" data-position="top" data-tooltip="I am tooltip">Hover Me</a>
        <a href="" class="btn tooltipped" data-position="bottom" data-tooltip="I am tooltip" data-delay="5000">Hover Me</a>
        <a href="" class="btn tooltipped" data-position="left" data-tooltip="I am tooltip">Hover Me</a>
        <a href="" class="btn tooltipped" data-position="right" data-tooltip="I am tooltip">Hover Me</a>

        <!-- DROPDOWN -->
        <h1>DROPDOWN</h1>
        <a href="" class="dropdown-button btn" data-activates="dropdown2" >Dropdown</a>
        <!-- Dropdown Structure -->
        <ul id='dropdown2' class='dropdown-content'>
          <li><a href="#!">one</a></li>
          <li><a href="#!">two</a></li>
          <li class="divider"></li>
          <li><a href="#!">three</a></li>
          <li><a href="#!"><i class="material-icons">view_module</i>four</a></li>
          <li><a href="#!"><i class="material-icons">cloud</i>five</a></li>
        </ul>

        <!-- MATERIAL BOXED-->
        <h1>MATERIAL BOXED</h1>

        <img src="http://materializecss.com/images/sample-1.jpg" alt="" class="materialboxed" data-caption="Here is an image caption">

        <!-- SLIDER -->
        

        <!-- MODAL -->
        <h1>MODAL</h1>

        <!-- MODAL TRIGGERS -->
        <a href="#modal1" class="btn waves-effect">Modal 1</a>
        <a href="#modal2" class="btn waves-effect red">Modal 2</a>

        <!-- MODAL STRUCTURE -->
        <div id="modal1" class="modal">
          <div class="modal-content">
            <h4>Modal Header</h4>
            <p>A bunch of text</p>
          </div>
          <div class="modal-footer">
            <a href="" class="modal-action modal-close waves-effect waves-green">Button</a>
          </div>
        </div>

        <div id="modal2" class="modal">
          <div class="modal-content">
            <h4>Modal 2 Header</h4>
            <p>A bunch of text</p>
          </div>
          <div class="modal-footer">
            <a href="" class="modal-action modal-close waves-effect waves-green">Button</a>
          </div>
        </div>

        <!-- SIDENAV -->
        <h1>SIDENAV</h1>
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
        <a href="" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>

        

        <!-- TAP TARGET -->
        <div class="fixed-action-btn" style="bottom:45px;right:24px">
          <a id="menu" onclick="$('.tap-target').tapTarget('open')" class="waves-effect waves-light btn btn-floating btn-large cyan">
            <i class="material-icons">menu</i>
          </a>
        </div>

        <a onclick="$('.tap-target').tapTarget('open')" class="waves-effect waves-light btn cyan">Open Tap Target</a>
        <a onclick="$('.tap-target').tapTarget('close')" class="waves-effect waves-light btn cyan">Close Tap Target</a>

        <!-- TAP TARGET CONTENT -->
        <div class="tap-target cyan" data-activates="menu">
          <div class="tap-target-content white-text">
            <h5>Tap Target Content</h5>
            <p class="white-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptate nihil sequi enim. In vitae, facilis cum reprehenderit architecto explicabo aliquam, dicta amet et ex nostrum rem minus aliquid natus, numquam.</p>
          </div>
        </div>

        </div>
</body>
</html>