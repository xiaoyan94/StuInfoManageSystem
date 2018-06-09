function refresh_notice_list(){
	search_notice({'pageSize':5});
}
function search_notice(params){
	$("#notice_ul").empty();
	$('#preloading').css('display','block');
	$.ajax({
		"url" : "${pageContext.request.contextPath}/noticeAction_list",
		"data" : params,
		"dataType" : "json",
		"success" : function(data) {
			$('#preloading').css('display','none');
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
		      <div class="collapsible-header active">
		      <i class="material-icons">filter_drama</i>
		   	  <span>${i+1}. </span>
		   	  <span> ${e.title}</span>
		      <a class="right">发布人：${e.admin.adminName}(${e.admin.adminRealName})</a>
		      <span class="right">&nbsp;&nbsp;&nbsp;&nbsp;</span>
		      <a class="right">发布时间：${time}</a>
		      </div>
		      <div class="collapsible-body">
		      	<div class="row" style="margin-bottom:0;">
		      	<p>通知内容：${e.content}</p>
		      	<a onclick="delete_notice('${e.id}')" class="right waves-effect waves-light btn tooltipped" data-position="bottom" data-tooltip="删除" href="#!">
		      	<i class="material-icons left">delete</i>
		      	删除
		      	</a>
		      	</div>
		      </div>
		    </li>
					`;
					$("#notice_ul").append(row);
				});
				$('.collapsible').collapsible();
				Materialize.toast('刷新成功', 1500, 'rounded');
			}
		},
		"async" : true
	});
}
function delete_notice(id){
	$('#delete_notice_modal').modal("open");
	$('#delete_notice_btn').attr('onclick',"delete_notice_ajax("+id+")");
}
function delete_notice_ajax(id){
	$('.progress').css('display','block');
	$.ajax({
		"url" : "${pageContext.request.contextPath}/noticeAction_delete",
		"data" : {
			"id":id
		},
		"dataType" : "json",
		"success" : function(data) {
			$('#delete_notice_modal').modal("close");
			if(data.success==true){
				Materialize.toast('删除成功', 3500, 'rounded');
			}else{
				Materialize.toast('删除失败', 3500, 'rounded');
			}
			$('.progress').css('display','none');
			refresh_notice_list();
		},
		"async" : true
	});
}
function add_notice(){
	$('.progress').css('display','block');
	Materialize.toast('操作已提交', 3500, 'rounded');
	$.ajax({
		"url" : "${pageContext.request.contextPath}/noticeAction_save",
		"data" : {
			"admin.adminId":$('#admin_id').val(),
			"title":$('#add_notice_title').val(),
			"content":$('#add_notice_content').val()
		},
		"dataType" : "json",
		"success" : function(data) {
			$('#add_notice_modal').modal("close");
			if(data.success==true){
				Materialize.toast('添加成功', 4000, 'rounded');
			}else{
				Materialize.toast('添加失败', 3500, 'rounded');
			}
			$('.progress').css('display','none');
			refresh_notice_list();
		},
		"async" : true
	});
}
function submit_search_notice_form(){
	$('#search_notice_modal').modal("close");
	search_notice({
		'pageSize':4,
		'currentPage':1,
		'searchKey':$('#search_notice_key').val()
		});
}
function get_search_focus(){
	$('#search_notice_modal').modal('open');
	$('#search_notice_key').focus();
}
function get_add_focus(){
	$('#add_notice_modal').modal('open');
	$('#add_notice_title').focus();
}