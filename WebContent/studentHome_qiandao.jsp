<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<body>
	<div id="sign" class="row">
	<div class="col s6">
		<ul class="collection with-header">
		        <li class="collection-header"><h6>签到日历</h6><div id="calendar"></div></li>
		        <li class="collection-item">
					
				</li>
			</ul>
		
	</div>
		<div class="col s6">
<!-- 			<div>
				<div class="fixed-action-btn">
		          <a id="sign_btn" class="btn-floating btn-large red oulse pulse">
		            <i class="large material-icons">check</i>
		          </a>
		          <ul>
		            <li><a class="btn-floating red"><i class="material-icons">insert_chart</i></a></li>
		            <li><a class="btn-floating yellow darken-1"><i class="material-icons">format_quote</i></a></li>
		            <li><a class="btn-floating green"><i class="material-icons">publish</i></a></li>
		            <li><a class="btn-floating blue"><i class="material-icons">attach_file</i></a></li>
		          </ul>
		        </div>
			</div> -->
					
			<div>
			<div>
				<img src="https://tool.lu/netcard/">
			</div>
			<ul id="timecards" class="collection with-header">
		        <li class="collection-header"><h6>最近签到</h6></li>
		        <li class="collection-item"><div>2018-5-5 10：10<a href="#!" class="secondary-content"><i class="material-icons">check</i></a></div></li>
			</ul>
			</div>
		</div>
	        <!-- TAP TARGET -->
        <div class="fixed-action-btn" style="bottom:45px;right:24px">
          <a id="sign_btn" onclick="sign_btn()" class="waves-effect waves-light btn btn-floating btn-large red pulse">
            <i class="material-icons">check</i>
          </a>
        </div>

<!--         <a onclick="$('.tap-target').tapTarget('open')" class="waves-effect waves-light btn cyan">Open Tap Target</a>
        <a onclick="$('.tap-target').tapTarget('close')" class="waves-effect waves-light btn cyan">Close Tap Target</a>
 -->
        <!-- TAP TARGET CONTENT -->
        <div class="tap-target cyan" data-activates="sign_btn">
          <div class="tap-target-content white-text">
            <h5 id="sign_headtext">签到</h5>
            <p id="sign_tap-target" class="white-text">今天还没有签到！</p>
          </div>
        </div>
	</div>
</body>
</html>