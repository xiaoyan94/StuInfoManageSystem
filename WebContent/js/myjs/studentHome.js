function showTips(){
	$('a:contains(取消)').attr('class',$('a:contains(取消)').attr('class') + ' tooltipped');
	$('a:contains(取消)').attr('data-position', 'top');
	$('a:contains(取消)').attr('href', '#!');
	$('a:contains(取消)').attr('data-tooltip', '取消操作并且返回');
	$('a:contains(取消)').attr('onclick',
			'Materialize.toast("操作已取消", 4000, "rounded");');
	$('*[disabled="disabled"]').attr('class', $('*[disabled="disabled"]').attr('class')+' tooltipped');
	$('*[disabled="disabled"]').attr('data-position', 'top');
	$('*[disabled="disabled"]').attr('data-tooltip', '此项信息不可操作');
	$('*[disabled="disabled"]').attr('data-position', 'top');
	$('*[readonly="readonly"]').attr('class', $('*[readonly="readonly"]').attr('class')+' tooltipped');
	$('*[readonly="readonly"]').attr('data-position', 'top');
	$('*[readonly="readonly"]').attr('data-tooltip', '此项信息不可操作');
	$('*[readonly="readonly"]').attr('data-position', 'top');
	$('#sign_btn').attr('class', $('#sign_btn').attr('class')+' tooltipped');
	$('#sign_btn').attr('data-position', 'top');
	$('#sign_btn').attr('data-tooltip', '点击签到');
	$('#sign_btn').attr('data-position', 'top');
	$('ul.tabs').tabs('select_tab', 'edit_t2');
}
function initSignCalendar(){
	//ajax获取日历json数据
	$.ajax({
		"url" : "${pageContext.request.contextPath}/timecardAction_getSignedDays",
		"dataType" : "json",
		"success" : function(data) {
			if(data.status=="success"){
				calUtil.init(data.days);
				initTimecards();
				Materialize.toast('获取签到日历成功', 3500, 'rounded');
			}
		},
		"async" : true
	});
//	var signList = [ {
//		"signDay" : "10"
//	}, {
//		"signDay" : "11"
//	}];
//	calUtil.init(signList);
}
function initSignCalendarByMonth(date){
	//ajax获取日历json数据
	$.ajax({
		"url" : "${pageContext.request.contextPath}/timecardAction_getSignedDaysByMonth",
		"data":{
			"date":date
		},
		"dataType" : "json",
		"success" : function(data) {
			if(data.status=="success"){
				calUtil.init(data.days);
				Materialize.toast('成功获取'+date+'的签到日历', 4500, 'rounded');
			}
		},
		"async" : true
	});
}
function initTapTarget(){
	$.ajax({
		//返回当日是否签到及签到时间
		"url" : "${pageContext.request.contextPath}/timecardAction_listByStudentDate",
		"dataType" : "json",
		"success" : function(data) {
			if(data.status=="success"){
				if(data.isSign==false){
					$('#sign_tap-target').text('今天还没有签到~点击签到按钮进行签到~');
					$('#sign_btn').removeClass('green');
					$('#sign_btn').addClass('red');
					$('.tap-target').removeClass('green');
					$('.tap-target').removeClass('cyan');
					$('.tap-target').addClass('red');
					Materialize.toast("请尽快签到", 4000, "rounded");
					$('.tap-target').tapTarget('open');;
					$('.tap-target').tapTarget();;
					$('.tooltipped').tooltip();;
				}else{
					$('#sign_tap-target').text('今天已经签到过啦~~');
					$('.tap-target').addClass('green');
					$('#sign_btn').removeClass('red');
					$('#sign_btn').removeClass('pulse');
					$('#sign_btn').addClass('green');
					$('.tap-target').removeClass('red');
					Materialize.toast("今日已签到", 4000, "rounded");
					$('#sign_btn').attr('data-tooltip', '今天已经签到过啦~~');
					$('.tap-target').tapTarget('close');
					$('.tooltipped').tooltip();;
				}
				//calUtil.init(data.days);
				//Materialize.toast('成功获取'+date+'的签到日历', 4500, 'rounded');
			}
		},
		"async" : true
	});
}
function sign_btn(){
	$.ajax({
		//签到
		"url" : "${pageContext.request.contextPath}/timecardAction_sign",
		"dataType" : "json",
		"success" : function(data) {
			if(data.status=="success"){
				Materialize.toast("签到成功", 4000, "rounded");
				initSignCalendar();
				$('#sign_headtext').text('签到成功');
				$('#sign_tap-target').text('今天已经签到过啦~~');
				$('.tap-target').addClass('green');
				$('#sign_btn').removeClass('red');
				$('#sign_btn').addClass('green');
				$('.tap-target').removeClass('red');
				$('#sign_btn').attr('data-tooltip', '今天已经签到过啦~~');
				$('#sign_btn').removeClass('pulse');
				$('.tap-target').tapTarget('close');
				$('.tap-target').tapTarget();
				$('.tooltipped').tooltip();;
			} else if(data.isSign==true){
				Materialize.toast(data.msg, 4000, "rounded");
				$('#sign_headtext').text('签到成功');
				$('#sign_tap-target').text('今天已经签到过啦~~');
				$('.tap-target').removeClass('red');
				$('.tap-target').addClass('green');
				$('#sign_btn').removeClass('red');
				$('#sign_btn').removeClass('pulse');
				$('#sign_btn').addClass('green');
				$('.tap-target').tapTarget();
				$('.tooltipped').tooltip();
			}else if(data.status=='failed'){
				Materialize.toast('签到失败:'+data.msg, 4000, "rounded");
			}else{
				Materialize.toast('还没签到', 4000, "rounded");
				$('.tap-target').addClass('green');
			}
			//Materialize.toast('成功获取'+date+'的签到日历', 4500, 'rounded');
		},
		"async" : true
	});
}
function initTimecards(){
	$.ajax({
		//签到
		"url" : "${pageContext.request.contextPath}/timecardAction_listByStudent",
		"dataType" : "json",
		"success" : function(data) {
			if(data.status=="success"){
				if(data.timecards!=null){
					var l = data.timecards.length;
					$('#timecards').empty();
					$('#timecards').append(`
					<li class="collection-header"><h6>签到记录</h6></li>
						`);
					for(var i=l-1;i>0;i--){
						$('#timecards').append(
						`<li class="collection-item">
						<div>${data.timecards[i].replace('T',' ')}
						<a href="#!" class="secondary-content">
						<i class="material-icons">check</i>
						</a></div></li>`		
						);
					}
				}
			}
		},
		"async" : true
	});
}