
//----------------------------------------------
function delete_going(id,going_name) {
	$('#delete_going_name').text(going_name);
	$('#delete_going_link').attr('href',"javascript:delete_going_ajax('"+id+"','"+going_name+"')");
}
function edit_going(id,going_name) {
	$('#edit_going_id').val(id);
	$('#edit_going_name').val(going_name);
}
function edit_going_ajax() {
	Materialize.toast('操作已提交', 1500, 'rounded')
	$.ajax({
		"url" : "${pageContext.request.contextPath}/goingAction_update",
		"dataType" : "json",
		"data" : {
			"id" :$('#edit_going_id').val() ,
			"name":$('#edit_going_name').val()
		},
		"success" : function(data) {
			if(data.status == 'success'){
				Materialize.toast('更新成功', 5000, 'rounded')
				refresh_going_list();
			}else{
				Materialize.toast('更新失败', 5000, 'rounded')
				if(data.msg!=null){
					Materialize.toast(data.msg, 4000, 'rounded')
				}
			}
		},
		"async" : true//false 同步请求
	});
}
function delete_going_ajax(id,name){
	$.ajax({
	    "url" : "${pageContext.request.contextPath}/goingAction_delete",
	    "dataType" : "json",
	    "data" : {
	      "id" : id,
	      "name":name
	    },
	    "success" : function(data) {
	    	if(data.status == 'success'){
	    		Materialize.toast('删除成功', 2000, 'rounded')
	    		refresh_going_list();
	    	}else{
	    		Materialize.toast('删除失败', 2000, 'rounded')
	    	}
	    },
	    "async" : true//false 同步请求
	});
}
function add_going(){
	Materialize.toast('操作已提交', 2500, 'rounded')
	$.ajax({
		"url" : "${pageContext.request.contextPath}/goingAction_add",
		"dataType" : "json",
		"data" : {
			"name":$('#add_going_name').val()
		},
		"success" : function(data) {
			if(data.status == 'success'){
				Materialize.toast('添加成功', 4000, 'rounded')
				refresh_going_list();
			}else{
				Materialize.toast('添加失败', 4000, 'rounded')
				if(data.msg!=null){
					Materialize.toast(data.msg, 4000, 'rounded')
				}
			}
		},
		"async" : true//false 同步请求
	});
}
function refresh_going_list() {
	$('#going_list_table').empty();
	$.ajax({
	    "url" : "${pageContext.request.contextPath}/goingAction_list",
	    "dataType" : "json",
	    "success" : function(data) {
	    	Materialize.toast('获取到'+data.goings.length+"条数据", 2000, 'rounded')
	    	for(var i=0;i<data.goings.length;i++){
	    		var row = `
	    			<tr>
				      <td>${i+1}</td>
				      <td>${data.goings[i].id}</td>
				      <td>${data.goings[i].name}</td>
				      <td>
				        <a onclick="edit_going('${data.goings[i].id}','${data.goings[i].name}')" class="waves-effect waves-light btn tooltipped green" data-position="bottom" data-tooltip="编辑" href="#edit_going"><i class="material-icons left">edit</i>编辑</a>&nbsp;&nbsp;
				        <a onclick="delete_going('${data.goings[i].id}','${data.goings[i].name}')" class="waves-effect waves-light btn tooltipped red" data-position="bottom" data-tooltip="删除" href="#delete_going"><i class="material-icons left">delete</i>删除</a>
				      </td>
	    			</tr>
	    			`;
	    		$('#going_list_table').append(row);
	    	}
	    	Materialize.toast('刷新成功', 4000, 'rounded');
	    },
	    "async" : true//false 同步请求
	});
}
//--------------------------------------------
function add_classes(){
	$.ajax({
		"url" : "${pageContext.request.contextPath}/classesAction_getProfessionSelectItem",
		"dataType" : "json",
		"success" : function(data) {
			$('#add_classes_profession').empty();
			for(var i=0;i<data.professions.length;i++){
				var row = `
					<option value="${data.professions[i].id}">${data.professions[i].name}</option>
					`;
				$('#add_classes_profession').append(row);
			}
			//$('#edit_profession_college').material_select('destroy');
			//重新初始化select选项的值
			$('select').material_select();
			Materialize.toast('获取item数据成功', 2500, 'rounded');
		},
		"async" : true
	});
}
function add_classes_ajax(){
	Materialize.toast('操作已提交', 2500, 'rounded')
	$.ajax({
		"url" : "${pageContext.request.contextPath}/classesAction_add",
		"dataType" : "json",
		"data" : {
			"name":$('#add_classes_name').val(),
			"classes_profession" :$('#add_classes_profession').val()
		},
		"success" : function(data) {
			if(data.status == 'success'){
				Materialize.toast('添加成功', 4000, 'rounded')
				refresh_classes_list();
			}else{
				if(data.msg!=null){
					Materialize.toast('添加失败：'+data.msg, 4000, 'rounded')
				}else{
					Materialize.toast('添加失败', 4000, 'rounded')
				}
			}
		},
		"async" : true//false 同步请求
	});
}
function refresh_classes_list(){
	$('#classes_list_table').empty();
	$.ajax({
		"url" : "${pageContext.request.contextPath}/classesAction_list",
		"dataType" : "json",
		"success" : function(data) {
			Materialize.toast('获取到'+data.classes.length+"条数据", 2000, 'rounded')
			for(var i=0;i<data.classes.length;i++){
				var row = `
					<tr>
				      <td>${i+1}</td>
				      <td>${data.classes[i].id}</td>
				      <td>${data.classes[i].name}</td>
				      <td>${data.classes[i]['profession.name']}</td>
					  <td>${data.classes[i]['profession.college.name']}</td>
				      <td>
				        <a onclick="edit_classes('${data.classes[i].id}','${data.classes[i].name}','${data.classes[i]['profession.college.id']}')" class="waves-effect waves-light btn tooltipped" data-position="bottom" data-tooltip="详情" href="#edit_classes"><i class="material-icons left">info</i>详情</a>&nbsp;&nbsp;
				        <a onclick="edit_classes('${data.classes[i].id}','${data.classes[i].name}','${data.classes[i]['profession.college.id']}')" class="waves-effect waves-light btn tooltipped green" data-position="bottom" data-tooltip="编辑" href="#edit_classes"><i class="material-icons left">edit</i>编辑</a>&nbsp;&nbsp;
				        <a onclick="delete_classes('${data.classes[i].id}','${data.classes[i].name}')" class="waves-effect waves-light btn tooltipped red" data-position="bottom" data-tooltip="删除" href="#delete_classes"><i class="material-icons left">delete</i>删除</a>
				      </td>
				    </tr>
					`;
				$('#classes_list_table').append(row);
			}
			Materialize.toast('刷新成功', 4000, 'rounded');
		},
		"async" : true//false 同步请求
	});
}
function delete_classes(id,name){
	$('#delete_classes_name').text(name);
	$('#delete_classes_link').attr('onclick','delete_classes_ajax("'+id+'")');
}
function delete_classes_ajax(id){
	$.ajax({
	    "url" : "${pageContext.request.contextPath}/classesAction_delete",
	    "dataType" : "json",
	    "data" : {
	      "id" : id
	    },
	    "success" : function(data) {
	    	if(data.status == 'success'){
	    		Materialize.toast('删除成功', 2000, 'rounded')
	    		refresh_classes_list();
	    	}else{
	    		Materialize.toast('删除失败', 2000, 'rounded')
	    	}
	    },
	    "async" : true//false 同步请求
	});
}
function edit_classes(id,classes_name,profession_id) {
	$('#edit_classes_id').val(id);
	$('#edit_classes_name').val(classes_name);
	$.ajax({
		"url" : "${pageContext.request.contextPath}/classesAction_getProfessionSelectItem",
		"dataType" : "json",
		"success" : function(data) {
			$('#edit_classes_profession').empty();
			for(var i=0;i<data.professions.length;i++){
				var row = `
					<option ${data.professions[i].id==profession_id?'selected':''} value="${data.professions[i].id}">${data.professions[i].name}</option>
					`;
				$('#edit_classes_profession').append(row);
			}
			//重新初始化
			$('select').material_select();
			Materialize.toast('获取item数据成功', 500, 'rounded');
		},
		"async" : true
	});
}
function edit_classes_ajax(){
	$.ajax({
		"url" : "${pageContext.request.contextPath}/classesAction_update",
		"data":{
			"id":$('#edit_classes_id').val(),
			"name":$('#edit_classes_name').val(),
			"classes_profession":$('#edit_classes_profession').val()
		},
		"dataType" : "json",
		"success" : function(data) {
			if(data.status=="success"){
				Materialize.toast('更新数据成功', 5000, 'rounded');
				refresh_classes_list();
			}else{
				Materialize.toast('更新数据失败:'+data.msg, 5000, 'rounded');
			}
		},
		"async" : true
	});
}
//----------------------------
function add_profession(){
	$.ajax({
		"url" : "${pageContext.request.contextPath}/professionAction_getCollegeSelectItem",
		"dataType" : "json",
		"success" : function(data) {
			$('#add_profession_college').empty();
			//$('#edit_profession_college').material_select('destroy');
			for(var i=0;i<data.options.length;i++){
				var row = `
					<option value="${data.options[i].id}">${data.options[i].name}</option>
					`;
				$('#add_profession_college').append(row);
			}
			//$('#edit_profession_college').material_select('destroy');
			//重新初始化
			$('select').material_select();
			Materialize.toast('获取item数据成功', 2500, 'rounded');
		},
		"async" : true
	});
}
function add_profession_ajax(){
	Materialize.toast('操作已提交', 2500, 'rounded')
	$.ajax({
		"url" : "${pageContext.request.contextPath}/professionAction_add",
		"dataType" : "json",
		"data" : {
			"name":$('#add_profession_name').val(),
			"profession_college" :$('#add_profession_college').val()
		},
		"success" : function(data) {
			if(data.status == 'success'){
				Materialize.toast('添加成功', 4000, 'rounded')
				refresh_profession_list();
			}else{
				if(data.msg!=null){
					Materialize.toast('添加失败：'+data.msg, 4000, 'rounded')
				}else{
					Materialize.toast('添加失败', 4000, 'rounded')
				}
			}
		},
		"async" : true//false 同步请求
	});
}
function delete_profession(id,name){
	$('#delete_profession_name').text(name);
	$('#delete_profession_link').attr('onclick	','delete_profession_ajax("'+id+'")');
}
function delete_profession_ajax(id){
	$.ajax({
	    "url" : "${pageContext.request.contextPath}/professionAction_delete",
	    "dataType" : "json",
	    "data" : {
	      "id" : id
	    },
	    "success" : function(data) {
	    	if(data.status == 'success'){
	    		Materialize.toast('删除成功', 2000, 'rounded')
	    		refresh_profession_list();
	    	}else{
	    		Materialize.toast('删除失败', 2000, 'rounded')
	    	}
	    },
	    "async" : true//false 同步请求
	});
}
function edit_profession(id,profession_name,college_id) {
	$('#edit_profession_id').val(id);
	$('#edit_profession_name').val(profession_name);
	$.ajax({
		"url" : "${pageContext.request.contextPath}/professionAction_getCollegeSelectItem",
		"dataType" : "json",
		"success" : function(data) {
			$('#edit_profession_college').empty();
			//$('#edit_profession_college').material_select('destroy');
			for(var i=0;i<data.options.length;i++){
				var row = `
					<option ${data.options[i].id==college_id?'selected':''} value="${data.options[i].id}">${data.options[i].name}</option>
					`;
				$('#edit_profession_college').append(row);
			}
			//$('#edit_profession_college').material_select('destroy');
			//重新初始化
			$('select').material_select();
			Materialize.toast('获取item数据成功', 500, 'rounded');
		},
		"async" : true
	});
}

function edit_profession_ajax(){
	$.ajax({
		"url" : "${pageContext.request.contextPath}/professionAction_update",
		"data":{
			"id":$('#edit_profession_id').val(),
			"name":$('#edit_profession_name').val(),
			"profession_college":$('#edit_profession_college').val()
		},
		"dataType" : "json",
		"success" : function(data) {
			if(data.status=="success"){
				Materialize.toast('更新数据成功', 5000, 'rounded');
				refresh_profession_list();
			}else{
				Materialize.toast('更新数据失败:'+data.msg, 5000, 'rounded');
			}
		},
		"async" : true
	});
}
function refresh_profession_list() {
	$('#profession_list_table').empty();
	$.ajax({
		"url" : "${pageContext.request.contextPath}/professionAction_list",
		"dataType" : "json",
		"success" : function(data) {
			Materialize.toast('获取到'+data.professions.length+"条数据", 2000, 'rounded')
			for(var i=0;i<data.professions.length;i++){
				var row = `
					<tr>
				      <td>${i+1}</td>
				      <td>${data.professions[i].id}</td>
				      <td>${data.professions[i].name}</td>
				      <td>${data.professions[i]['college.name']}</td>
				      <td>
				        <a onclick="edit_profession('${data.professions[i].id}','${data.professions[i].name}','${data.professions[i]['college.id']}')" class="waves-effect waves-light btn tooltipped" data-position="bottom" data-tooltip="详情" href="#edit_profession"><i class="material-icons left">info</i>详情</a>&nbsp;&nbsp;
				        <a onclick="edit_profession('${data.professions[i].id}','${data.professions[i].name}','${data.professions[i]['college.id']}')" class="waves-effect waves-light btn tooltipped green" data-position="bottom" data-tooltip="编辑" href="#edit_profession"><i class="material-icons left">edit</i>编辑</a>&nbsp;&nbsp;
				        <a onclick="delete_profession('${data.professions[i].id}','${data.professions[i].name}')" class="waves-effect waves-light btn tooltipped red" data-position="bottom" data-tooltip="删除" href="#delete_profession"><i class="material-icons left">delete</i>删除</a>
				      </td>
				    </tr>
					`;
				$('#profession_list_table').append(row);
			}
			Materialize.toast('刷新成功', 4000, 'rounded');
		},
		"async" : true//false 同步请求
	});
}

//----------------------------------------------
function delete_college(id,college_name) {
	$('#delete_college_name').text(college_name);
	$('#delete_college_link').attr('href',"javascript:delete_college_ajax('"+id+"','"+college_name+"')");
}
function edit_college(id,college_name) {
	$('#edit_college_id').val(id);
	$('#edit_college_name').val(college_name);
	//$('#edit_college_link').attr('href',"javascript:edit_college_ajax()");
}
function edit_college_ajax() {
	Materialize.toast('操作已提交', 1500, 'rounded')
	$.ajax({
		"url" : "${pageContext.request.contextPath}/collegeAction_update",
		"dataType" : "json",
		"data" : {
			//"desc" :$('#add_college_desc').val() ,
			"id" :$('#edit_college_id').val() ,
			"name":$('#edit_college_name').val()
		},
		"success" : function(data) {
			if(data.status == 'success'){
				Materialize.toast('更新成功', 5000, 'rounded')
				refresh_college_list();
			}else{
				Materialize.toast('更新失败', 5000, 'rounded')
				if(data.msg!=null){
					Materialize.toast(data.msg, 4000, 'rounded')
				}
			}
		},
		"async" : true//false 同步请求
	});
}
function delete_college_ajax(id,name){
	$.ajax({
	    "url" : "${pageContext.request.contextPath}/collegeAction_delete",
	    "dataType" : "json",
	    "data" : {
	      "id" : id,
	      "name":name
	    },
	    "success" : function(data) {
	    	if(data.status == 'success'){
	    		Materialize.toast('删除成功', 2000, 'rounded')
	    		refresh_college_list();
	    	}else{
	    		Materialize.toast('删除失败', 2000, 'rounded')
	    	}
//	    	Materialize.toast('获取到'+data.colleges.length+"条数据", 2000, 'rounded')
//	    	for(var i=0;i<data.colleges.length;i++){
//	    		var row = `
//	    			<tr>
//				      <td>${i+1}</td>
//				      <td>${data.colleges[i].id}</td>
//				      <td>${data.colleges[i].name}</td>
//				      <td>
//				        <a onclick="edit_college('${data.colleges[i].id}')" class="waves-effect waves-light btn tooltipped green" data-position="bottom" data-tooltip="编辑" href="#edit_college"><i class="material-icons left">edit</i>编辑</a>&nbsp;&nbsp;
//				        <a onclick="delete_college('${data.colleges[i].id}','${data.colleges[i].name}')" class="waves-effect waves-light btn tooltipped red" data-position="bottom" data-tooltip="删除" href="#delete_college"><i class="material-icons left">delete</i>删除</a>
//				      </td>
//	    			</tr>
//	    			`;
//	    		$('#college_list_table').append(row);
//	    	}
//	    	Materialize.toast('刷新成功', 4000, 'rounded');
	    },
	    "async" : true//false 同步请求
	});
}
function add_college(){
	Materialize.toast('操作已提交', 2500, 'rounded')
	$.ajax({
		"url" : "${pageContext.request.contextPath}/collegeAction_add",
		"dataType" : "json",
		"data" : {
			//"desc" :$('#add_college_desc').val() ,
			"name":$('#add_college_name').val()
		},
		"success" : function(data) {
			if(data.status == 'success'){
				Materialize.toast('添加成功', 4000, 'rounded')
				refresh_college_list();
			}else{
				Materialize.toast('添加失败', 4000, 'rounded')
				if(data.msg!=null){
					Materialize.toast(data.msg, 4000, 'rounded')
				}
			}
//	    	Materialize.toast('获取到'+data.colleges.length+"条数据", 2000, 'rounded')
//	    	for(var i=0;i<data.colleges.length;i++){
//	    		var row = `
//	    			<tr>
//				      <td>${i+1}</td>
//				      <td>${data.colleges[i].id}</td>
//				      <td>${data.colleges[i].name}</td>
//				      <td>
//				        <a onclick="edit_college('${data.colleges[i].id}')" class="waves-effect waves-light btn tooltipped green" data-position="bottom" data-tooltip="编辑" href="#edit_college"><i class="material-icons left">edit</i>编辑</a>&nbsp;&nbsp;
//				        <a onclick="delete_college('${data.colleges[i].id}','${data.colleges[i].name}')" class="waves-effect waves-light btn tooltipped red" data-position="bottom" data-tooltip="删除" href="#delete_college"><i class="material-icons left">delete</i>删除</a>
//				      </td>
//	    			</tr>
//	    			`;
//	    		$('#college_list_table').append(row);
//	    	}
//	    	Materialize.toast('刷新成功', 4000, 'rounded');
		},
		"async" : true//false 同步请求
	});
}
function refresh_college_list() {
	$('#college_list_table').empty();
	$.ajax({
	    "url" : "${pageContext.request.contextPath}/collegeAction_list",
	    "dataType" : "json",
	    "success" : function(data) {
	    	Materialize.toast('获取到'+data.colleges.length+"条数据", 2000, 'rounded')
	    	for(var i=0;i<data.colleges.length;i++){
	    		var row = `
	    			<tr>
				      <td>${i+1}</td>
				      <td>${data.colleges[i].id}</td>
				      <td>${data.colleges[i].name}</td>
				      <td>
				        <a onclick="edit_college('${data.colleges[i].id}','${data.colleges[i].name}')" class="waves-effect waves-light btn tooltipped green" data-position="bottom" data-tooltip="编辑" href="#edit_college"><i class="material-icons left">edit</i>编辑</a>&nbsp;&nbsp;
				        <a onclick="delete_college('${data.colleges[i].id}','${data.colleges[i].name}')" class="waves-effect waves-light btn tooltipped red" data-position="bottom" data-tooltip="删除" href="#delete_college"><i class="material-icons left">delete</i>删除</a>
				      </td>
	    			</tr>
	    			`;
	    		$('#college_list_table').append(row);
	    	}
	    	Materialize.toast('刷新成功', 4000, 'rounded');
	    },
	    "async" : true//false 同步请求
	});
}
//--------------------------------------------------------
function refresh_student_list(){
	var params={currentPage:1};
	search_student(params);
}
function submit_search_student_form(){
//	表单序列化 x形式如下
//	[ 
//	  {name: 'lastname', value: 'World'},
//	  {name: 'alias'}, // 值为空
//	]
	var params = {};//查询条件 json类型
	x=$('#search_student_form').serializeArray();
	$.each(x, function(i, field){
		//遍历JSON数组
		//alert(field.name + ":" + field.value + " ");
		params[field.name] = field.value;
	});
	console.log(params);
	search_student(params);
	$('#search_student_modal').modal('close');
}
/**
 * 查询带分页 更新显示数据
 * @param params JSON格式查询参数
 * @returns
 */
function search_student(params){
	$('#student_list_table').empty();
	params.pageSize=10;
	$.ajax({
	    "url" : "${pageContext.request.contextPath}/studentAction_search",
	    "data" : params,
	    "dataType" : "json",
	    "success" : function(data) {
	    	Materialize.toast('一共'+data.totalCount+"条数据", 4000, 'rounded')
	    	for(var i=0;i<data.students.length;i++){
	    		var  row = `
	    		<tr>
	    			<td>${i+1}</td>
	    			<td>${data.students[i].id}</td>
	    			<td>${data.students[i].name}</td>
	    			<td>${data.students[i].sex}</td>
	    			<td>${data.students[i].tel}</td>
	    			<td>
	    			<a onclick="edit_student('${data.students[i].id}')" class="waves-effect waves-light btn tooltipped" data-position="bottom" data-tooltip="详情" href="#edit-student"><i class="material-icons">info</i></a>&nbsp;&nbsp;
	    			<a onclick="edit_student('${data.students[i].id}')" class="waves-effect waves-light btn tooltipped green" data-position="bottom" data-tooltip="编辑" href="#edit-student"><i class="material-icons">edit</i></a>&nbsp;&nbsp;
	    			<a onclick="delete_student('${data.students[i].id}')" class="waves-effect waves-light btn tooltipped red" data-position="bottom" data-tooltip="删除" href="#delete-student"><i class="material-icons">delete</i></a>
	    			</td>
	    			</tr>
	    			`;
	    		$('#student_list_table').append(row);
	    	}//生成表格结束
	    	
	    	create_pagination('#students_pager',data,'search_student');
//	    	$('#students_pager').empty();
//	    	var pre;
//	    	if(data.currentPage==1){
//	    		pre = `<li class="disabled"><a href="javascript:Materialize.toast('没有更多数据啦', 2000, 'rounded')"><i class="material-icons">chevron_left</i></a></li>`;
//	    	}else{
//	    		pre = `<li class="waves-effect"><a href="javascript:search_student({currentPage:${data.currentPage-1}})"><i class="material-icons">chevron_left</i></a></li>`;
//	    	}
//	    	$('#students_pager').append(pre);
//	    	for(var i = data.currentPage>4 ? data.currentPage-4 : 0;i<data.totalPage && i<data.currentPage+3;i++){
//	    		var li = `<li class="waves-effect ${data.currentPage==i+1?' active blue lighten-2':' '}"><a href="javascript:search_student({currentPage:${i+1}})">${i+1}</a></li>`;
//	    		$('#students_pager').append(li);
//	    	}//生成分页数据
//	    	var next;
//	    	if(data.currentPage==data.totalPage){
//	    		next = `<li class="disabled"><a href="javascript:Materialize.toast('没有更多数据啦', 2000, 'rounded')"><i class="material-icons">chevron_right</i></a></li>`;
//	    	}else{
//	    		next = `<li class="waves-effect"><a href="javascript:search_student({currentPage:${data.currentPage+1}})"><i class="material-icons">chevron_right</i></a></li>`;
//	    	}
//	    	$('#students_pager').append(next);
//	    	var total=`<li class="waves-effect"><a>共${data.totalPage}页</a></li>`;
//	    	$('#students_pager').append(total);
	    },
	    "async" : true//false 同步请求
	});
}
//生成分页导航
function create_pagination(selector,data,function_name){
	$(selector).empty();
	var pre;
	if(data.currentPage==1){
		pre = `<li class="disabled"><a href="javascript:Materialize.toast('没有更多数据啦', 2000, 'rounded')"><i class="material-icons">chevron_left</i></a></li>`;
	}else{
		pre = `<li class="waves-effect"><a href="javascript:${function_name}({currentPage:${data.currentPage-1}})"><i class="material-icons">chevron_left</i></a></li>`;
	}
	$(selector).append(pre);
	for(var i = data.currentPage>4 ? data.currentPage-4 : 0;i<data.totalPage && i<data.currentPage+3;i++){
		var li = `<li class="waves-effect ${data.currentPage==i+1?' active blue lighten-2':' '}"><a href="javascript:${function_name}({currentPage:${i+1}})">${i+1}</a></li>`;
		$(selector).append(li);
	}//生成分页数据
	var next;
	if(data.currentPage==data.totalPage){
		next = `<li class="disabled"><a href="javascript:Materialize.toast('没有更多数据啦', 2000, 'rounded')"><i class="material-icons">chevron_right</i></a></li>`;
	}else{
		next = `<li class="waves-effect"><a href="javascript:${function_name}({currentPage:${data.currentPage+1}})"><i class="material-icons">chevron_right</i></a></li>`;
	}
	$(selector).append(next);
	var total=`<li class="waves-effect"><a>第${data.currentPage}页，共${data.totalPage}页</a></li>`;
	$(selector).append(total);
}
function add_student(){
	$.ajax({
		"url" : "${pageContext.request.contextPath}/classesAction_getClassesSelectItem",
		"dataType" : "json",
		"success" : function(data) {
			$('#add_student_classes').empty();
			for(var i=0;i<data.classes.length;i++){
				var row = `
					<option value="${data.classes[i].id}">${data.classes[i].name}</option>
					`;
				$('#add_student_classes').append(row);
			}
			//重新初始化
			$('select').material_select();
			Materialize.toast('获取item数据成功', 500, 'rounded');
		},
		"async" : true
	});
	$.ajax({
		"url" : "${pageContext.request.contextPath}/goingAction_getGoingsSelectItem",
		"dataType" : "json",
		"success" : function(data) {
			$('#add_student_going').empty();
			for(var i=0;i<data.goings.length;i++){
				var row = `
					<option value="${data.goings[i].id}">${data.goings[i].name}</option>
					`;
				$('#add_student_going').append(row);
			}
			//重新初始化
			$('select').material_select();
			Materialize.toast('获取item数据成功', 500, 'rounded');
		},
		"async" : true
	});
}
function add_student_ajax(){
	Materialize.toast('操作已提交', 2500, 'rounded')
	$.ajax({
		"url" : "${pageContext.request.contextPath}/studentAction_add",
		"dataType" : "json",
		"data" : {
			"id":$('#add_student_id').val(),
			"name":$('#add_student_name').val(),
			"idCard":$('#add_student_idCard').val(),
			//jQuery的属性选择器
			"sex":$('input[type="radio"][id*="add_student"][name="sex"]:checked').val(),
			"tel":$('#add_student_tel').val(),
			"password":$('#add_student_password').val(),
			"stu_classes":$('#add_student_classes').val(),
			"stu_going":$('#add_student_going').val(),
			"workName":$('#add_student_workName').val(),
			"workLinkmanName":$('#add_student_workLinkmanName').val(),
			"workTel":$('#add_student_workTel').val(),
			"workAddress":$('#add_student_workAddress').val(),
			
		},
		"success" : function(data) {
			if(data.status == 'success'){
				Materialize.toast('添加成功', 4000, 'rounded')
				//refresh_student_list();
				submit_search_student_form();
			}else{
				if(data.msg!=null){
					Materialize.toast('添加失败：'+data.msg, 4000, 'rounded')
				}else{
					Materialize.toast('添加失败', 4000, 'rounded')
				}
			}
		},
		"async" : true//false 同步请求
	});
}
function details_student(id){
	alert(id);
}
function edit_student(id){
	$.ajax({
		"url" : "${pageContext.request.contextPath}/classesAction_getClassesSelectItem",
		"dataType" : "json",
		"success" : function(data) {
			$('#edit_student_classes').empty();
			for(var i=0;i<data.classes.length;i++){
				var row = `
					<option ${data.classes[i].id==id?'selected':''} value="${data.classes[i].id}">${data.classes[i].name}</option>
					`;
				$('#edit_student_classes').append(row);
			}
			//重新初始化
			$('select').material_select();
			Materialize.toast('获取item数据成功', 500, 'rounded');
		},
		"async" : true
	});
	$.ajax({
		"url" : "${pageContext.request.contextPath}/goingAction_getGoingsSelectItem",
		"dataType" : "json",
		"success" : function(data) {
			$('#edit_student_going').empty();
			for(var i=0;i<data.goings.length;i++){
				var row = `
					<option ${data.goings[i].id==id?'selected':''} value="${data.goings[i].id}">${data.goings[i].name}</option>
					`;
				$('#edit_student_going').append(row);
			}
			//重新初始化
			$('select').material_select();
			Materialize.toast('获取item数据成功', 500, 'rounded');
		},
		"async" : true
	});
	$.ajax({
		"url" : "${pageContext.request.contextPath}/studentAction_getById",
		"data":{
			"id":id
		},
		"dataType" : "json",
		"success" : function(data) {
			if(data.status!="success"){
				Materialize.toast('获取student json失败', 500, 'rounded');
				return;
			}
			$('#edit_student_id').val(data.student.id);
			$('#edit_student_name').val(data.student.name);
			$('#edit_student_idCard').val(data.student.idCard);
			//jQuery的属性选择器
			//$('input[type="radio"][id*="edit_student"][name="sex"]:checked').val();
			$('input[type="radio"][id*="edit_student"][name="sex"][value="'+data.student.sex+'"]').prop('checked',true)
			$('#edit_student_tel').val(data.student.tel);
			$('#edit_student_password').val(data.student.passwd);
//			$('#edit_student_classes').val(data.student.classes);
			//<option value="0" disabled selected>请选择班级</option>
			$('select[id="edit_student_classes"] option[value="'+data.student.classes.id+'"]').prop('selected',true);
			$('select[id="edit_student_going"] option[value="'+data.student.goingRecord.going.id+'"]').prop('selected',true);
			//重新初始化select
			$('select').material_select();
			$('#edit_student_workName').val(data.student.goingRecord.workName);
			$('#edit_student_workLinkmanName').val(data.student.goingRecord.workLinkmanName);
			$('#edit_student_workTel').val(data.student.goingRecord.workTel);
			$('#edit_student_workAddress').val(data.student.goingRecord.workAddress);
			Materialize.toast('获取student json成功', 500, 'rounded');
		},
		"async" : true
	});
}
function edit_student_ajax() {
	$.ajax({
		"url" : "${pageContext.request.contextPath}/studentAction_update",
		"dataType" : "json",
		"data" : {
			"id":$('#edit_student_id').val(),
			"name":$('#edit_student_name').val(),
			"idCard":$('#edit_student_idCard').val(),
			//jQuery的属性选择器
			"sex":$('input[type="radio"][id*="edit_student"][name="sex"]:checked').val(),
			"tel":$('#edit_student_tel').val(),
			"password":$('#edit_student_password').val(),
			"stu_classes":$('#edit_student_classes').val(),
			"stu_going":$('#edit_student_going').val(),
			"workName":$('#edit_student_workName').val(),
			"workLinkmanName":$('#edit_student_workLinkmanName').val(),
			"workTel":$('#edit_student_workTel').val(),
			"workAddress":$('#edit_student_workAddress').val()
			
		},
		"success" : function(data) {
			if(data.status == 'success'){
				Materialize.toast('更新成功', 4000, 'rounded')
				//refresh_student_list();
				submit_search_student_form();
			}else{
				if(data.msg!=null){
					Materialize.toast('更新失败：'+data.msg, 4000, 'rounded')
				}else{
					Materialize.toast('更新失败', 4000, 'rounded')
				}
			}
		},
		"async" : true//false 同步请求
	});
}
function delete_student(id){
	$('#delete_student_id').text(id);
	$('#delete_student_link').attr('onclick',"delete_student_ajax('"+id+"')");
}
function delete_student_ajax(id){
	$.ajax({
	    "url" : "${pageContext.request.contextPath}/studentAction_delete",
	    "dataType" : "json",
	    "data" : {
	      "id" : id
	    },
	    "success" : function(data) {
	    	if(data.status == 'success'){
	    		Materialize.toast('删除成功', 2000, 'rounded')
	    		//refresh_student_list();
				submit_search_student_form();
	    	}else{
	    		Materialize.toast('删除失败', 2000, 'rounded')
	    	}
	    },
	    "async" : true//false 同步请求
	});
}
function test(){
	return '5555';
}
//------------------------------------------
function delete_admin(id,adminName) {
        	//alert(id)
	$('#delete_admin_username').text(adminName);
	$('#delete_admin_link').attr('href',"${pageContext.request.contextPath}/adminAction_delete?id="+id);
}
function edit_admin(id) {
	//alert(id);
	$.ajax({
	    "url" : "${pageContext.request.contextPath}/adminAction_get",
	    "data" : {
	      "id" : id
	    },
	    "dataType" : "json",
	    "success" : function(data) {
	      //alert(data.status)
	      $('#edit_admin_id').val(data.admin.adminId);
	      $('#edit_admin_username').val(data.admin.adminName);
	      $('#edit_admin_password').val(data.admin.adminPasswd);
	      $('#edit_admin_realname').val(data.admin.adminRealName);
	      $('#edit_admin_telephone').val(data.admin.adminTel);
	      $('#edit_admin_email').val(data.admin.adminEmail);
	      if('男' == data.admin.sex){
	    	  $('#edit_admin_nan').attr('checked','checked');
	      }else{
	    	  $('#edit_admin_nv').attr('checked','checked');
	      }
	    },
	    "async" : true//异步请求
	});
}
function details_admin(id) {
	//alert(id);
	$.ajax({
	    "url" : "${pageContext.request.contextPath}/adminAction_get",
	    "data" : {
	      "id" : id
	    },
	    "dataType" : "json",
	    "success" : function(data) {
	      //alert(data.status)
	      $('#details_admin_id').val(data.admin.adminId);
	      $('#details_admin_username').val(data.admin.adminName);
	      $('#details_admin_password').val(data.admin.adminPasswd);
	      $('#details_admin_realname').val(data.admin.adminRealName);
	      $('#details_admin_telephone').val(data.admin.adminTel);
	      $('#details_admin_email').val(data.admin.adminEmail);
	      if('男' == data.admin.sex){
	    	  $('#details_admin_nan').attr('checked','checked');
	      }else{
	    	  $('#details_admin_nv').attr('checked','checked');
	      }
	    },
	    "async" : true//异步请求
	});
}
function edit_admin_form_submit() {
	$('#edit_admin_form').submit();
	Materialize.toast('操作已提交', 4000, 'rounded')
}
function submitAddAdminForm() {
	if($("#add_admin_username").val() == ''){
		//$('#form_admin_add').modal('close');
		alert('请输入用户名');
		return;
	}
	if($("#add_admin_password").val() == ''){
		alert('请输入密码');
		return;
	}
	if($("#add_admin_password").val() != $("#add_admin_repassword").val()){
		alert('两次密码输入不一致');
		return;
	}
	if($("#add_admin_realname").val() == ''){
		alert('请输入姓名');
		return;
	}
	if($("#add_admin_telephone").val() == ''){
		alert('请输入电话');
		return;
	}
	
  	$("#form_admin_add2").submit();
}
/* $('#btn-floating-1').click(function(){  
if($('#table_admin_list').is(':hidden')){  
  $('#table_admin_list').show(); 
  $('#form_admin_add').hide();
  Materialize.toast('查看', 4000, 'rounded');
}  
else{  
  $('#table_admin_list').hide(); 
  $('#form_admin_add').show(); 
  Materialize.toast('添加', 4000, 'rounded');

}   
});  */