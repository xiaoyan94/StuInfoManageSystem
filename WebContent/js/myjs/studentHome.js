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

//notice-----------------------------------------------------
function refresh_notice_list(){
	search_notice({'pageSize':5});
}
function search_notice(params){
	$("#notice_ul").empty();
	$('#preloading').css('display','block');
	$('#notice_pager').css('display','none');
	$.ajax({
		"url" : "${pageContext.request.contextPath}/noticeAction_list",
		"data" : params,
		"dataType" : "json",
		"success" : function(data) {
			$('#preloading').css('display','none');
			$('#notice_pager').css('display','block');
			if(data.success==true){
				$(data.notice).each(function(i,e){
					var date = new Date(e.time);
					var time = date.getFullYear()+'年'
						+date.getMonth()+'月'
						+date.getDate()+'日'+'&nbsp;&nbsp;'
						+date.getHours()+'时'
						+date.getMinutes()+'分'
						+date.getSeconds()+'秒';
					var row = `
			<li>
		      <div class="row collapsible-header active" style="margin-right:0;margin-left:0">
			      <div calss="col s6">
				      <i class="material-icons">filter_drama</i>
				   	  <span>${i+1}. </span>
				   	  <span> ${e.title}</span>
			      </div>
			      <div class="col s6">
					  <a>发布人：${e.admin.adminName}(${e.admin.adminRealName})</a>
				      <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
				      <a>发布时间：${time}</a>
			      </div>
		      </div>
		      <div class="collapsible-body">
		      	<div class="row" style="margin-bottom:0;">
		      	<p>通知内容：${e.content}</p>
		      	
		      	</div>
		      </div>
		    </li>
					`;
					$("#notice_ul").append(row);
				});
				create_pagination('#notice_pager',data,'search_notice_page');
				$('.collapsible').collapsible();
				Materialize.toast('刷新成功', 1500, 'rounded');
			}
		},
		"async" : true
	});
}

//生成分页导航
function create_pagination(selector,data,function_name){
	$(selector).empty();
	var pre;
	if(data.currentPage==1){
		pre = `<li class="disabled"><a href="javascript:Materialize.toast('没有更多数据啦', 2000, 'rounded')"><i class="material-icons">chevron_left</i></a></li>`;
	}else{
		pre = `<li class="waves-effect"><a href="javascript:${function_name}(${data.currentPage-1},${data.pageSize})"><i class="material-icons">chevron_left</i></a></li>`;
	}
	$(selector).append(pre);
	for(var i = data.currentPage>4 ? data.currentPage-4 : 0;i<data.totalPage && i<data.currentPage+3;i++){
		var li = `<li class="waves-effect ${data.currentPage==i+1?' active blue lighten-2':' '}"><a href="javascript:${function_name}(${i+1},${data.pageSize})">${i+1}</a></li>`;
		$(selector).append(li);
	}//生成分页数据
	var next;
	if(data.currentPage==data.totalPage){
		next = `<li class="disabled"><a href="javascript:Materialize.toast('没有更多数据啦', 2000, 'rounded')"><i class="material-icons">chevron_right</i></a></li>`;
	}else{
		next = `<li class="waves-effect"><a href="javascript:${function_name}(${data.currentPage+1},${data.pageSize})"><i class="material-icons">chevron_right</i></a></li>`;
	}
	$(selector).append(next);
	var total=`<li class="waves-effect"><a>第${data.currentPage}页，共${data.totalPage}页</a></li>`;
	$(selector).append(total);
}
function submit_search_notice_form(){
	$('#search_notice_modal').modal("close");
	search_notice_page(1,5);
}
function search_notice_page(currentPage,pageSize){
	search_notice({
		'pageSize':pageSize,
		'currentPage':currentPage,
		'searchKey':$('#search_notice_key').val()
		});
}
function get_search_focus(){
	$('#search_notice_modal').modal('open');
	$('#search_notice_key').focus();
}
