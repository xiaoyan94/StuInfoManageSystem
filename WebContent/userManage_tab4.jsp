<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<body>
<div id="test4" class="col s12">
	<!-- 表格开始 -->
	<table class="striped highlight centered">
	  <thead class="blue lighten-2">
	    <tr>
	        <th>序号</th>
	        <th>专业编号</th>
	        <th>专业名称</th>
	        <th>学院</th>
	        <th>操作</th>
	    </tr>
	  </thead>
	  <tbody id="profession_list_table">
	    <tr>
	      <td>1</td>
	      <td>10000</td>
	      <td>软件工程</td>
	      <td>信息科学技术学院</td>
	      <td>
	        <a onclick="details_profession('id')" class="waves-effect waves-light btn tooltipped" data-position="bottom" data-tooltip="详情" href="#details_profession"><i class="material-icons left">info</i>详情</a>&nbsp;&nbsp;
	        <a onclick="edit_profession('id')" class="waves-effect waves-light btn tooltipped green" data-position="bottom" data-tooltip="编辑" href="#edit_profession"><i class="material-icons left">edit</i>编辑</a>&nbsp;&nbsp;
	        <a onclick="delete_profession('id')" class="waves-effect waves-light btn tooltipped red" data-position="bottom" data-tooltip="删除" href="#delete_profession"><i class="material-icons left">delete</i>删除</a>
	      </td>
	    </tr>
	  </tbody>
	</table>
	<!-- 表格结束 -->
	<!-- 悬浮按钮开始 -->
    <div class="fixed-action-btn">
      <a id="btn-floating-1" onclick="add_profession()" href="#add_profession" class="btn-floating btn-large red pulse tooltipped modal-trigger" data-position="top" data-tooltip="添加专业" >
        <i class="large material-icons">add</i>
      </a>
<!--             <ul>
              <li><a class="btn-floating red"><i class="material-icons">insert_chart</i></a></li>
              <li><a class="btn-floating yellow darken-1"><i class="material-icons">format_quote</i></a></li>
              <li><a class="btn-floating green"><i class="material-icons">publish</i></a></li>
              <li><a class="btn-floating blue"><i class="material-icons">attach_file</i></a></li>
            </ul> -->
    </div>
    <!-- 悬浮按钮结束 -->
	<div class="section"></div>
	<!-- 分页 -->

	<!-- MODAL STRUCTURE -->
	<!-- 信息详情弹出框 -->
	<div id="details_profession" class="modal">
	  <div class="modal-content">
	    <h4>详细资料</h4>
	    <div class="row">
	       <div class="input-field col s6">
	         <i class="material-icons prefix">group</i>
	         <input disabled="disabled" id="details_profession_id" type="text" class="validate" value=" ">
	         <label for="details_profession_id">专业编号</label>
	       </div>
	       <div class="input-field col s6 ">
	         <i class="material-icons prefix">account_circle</i>
	         <input readonly="readonly" id="details_profession_name" type="text" class="validate" value=" ">
	         <label for="details_profession_name">专业名称</label>
	       </div>
	     </div>
	     <div class="row">
	       <div class="input-field col s6 ">
	         <i class="material-icons prefix">account_circle</i>
	         <input readonly="readonly" id="details_profession_college" type="text" class="validate" value=" ">
	         <label for="details_profession_college">所属学院</label>
	       </div>
	       
	     </div>
	  </div>
	  <div class="divider"></div>
	  <div class="modal-footer">
	    <a href="#!" class="modal-action modal-close waves-effect waves-green red btn waves-light">确定<i class="material-icons right">send</i></a>
	    <span class="right">&nbsp;&nbsp;</span>
	    <a onclick="Materialize.toast('操作已取消', 500, 'rounded')" href="javascript:void(0);" class="modal-action modal-close waves-effect waves-green btn pulse waves-light">取消<i class="material-icons right">cancel</i></a>
	  </div>
	</div>
	<div id="add_profession" class="modal">
	  <div class="modal-content">
	    <h4>详细资料</h4>
	    <div class="row" style="height: 250px">
	       <div class="input-field col s6 ">
	         <i class="material-icons prefix">account_circle</i>
	         <input id="add_profession_name" type="text" class="validate" value=" ">
	         <label for="add_profession_name">专业名称</label>
	       </div>
	      	<div class="input-field col s6">
		         <i class="material-icons prefix">spa</i>
				<select id="add_profession_college" name="profession_college">
					<option value="" disabled selected>请选择学院</option>
					<!-- <option value="1">选项 1</option>
					<option value="2">选项 2</option>
					<option value="3">选项 3</option> -->
				</select>
				<label>专业所在学院</label>
		 	</div>
	     </div>
	  </div>
	       
	  <div class="divider"></div>
	  <div class="modal-footer">
	    <a href="#!" onclick="add_profession_ajax()" class="modal-action modal-close waves-effect waves-green red btn waves-light">添加信息<i class="material-icons right">send</i></a>
	    <span class="right">&nbsp;&nbsp;</span>
	    <a onclick="Materialize.toast('操作已取消', 500, 'rounded')" href="javascript:void(0);" class="modal-action modal-close waves-effect waves-green btn pulse waves-light">取消<i class="material-icons right">cancel</i></a>
	  </div>
	  </div>
	</div>
	<!-- profession信息编辑弹出框 -->
	<div id="edit_profession" class="modal">
	  <div class="modal-content">
	    <h4>编辑资料</h4>
	    <div class="row">
	      <form class="col s12" action="" method="post">
	      <div class="row">
		       <div class="input-field col s6">
		         <i class="material-icons prefix">group</i>
		         <input disabled="disabled" id="edit_profession_id" type="text" class="validate" value=" ">
		         <label for="edit_profession_id">专业编号</label>
		       </div>
		       <div class="input-field col s6 ">
		         <i class="material-icons prefix">account_circle</i>
		         <input id="edit_profession_name" type="text" class="validate" value=" ">
		         <label for="edit_profession_name">专业名称</label>
		       </div>
		  </div>
		  <div class="row">
		       <div class="input-field col s6">
		         <i class="material-icons prefix">spa</i>
				<select id="edit_profession_college" name="profession_college">
					<option value="" disabled selected>请选择学院</option>
					<!-- <option value="1">选项 1</option>
					<option value="2">选项 2</option>
					<option value="3">选项 3</option> -->
				</select>
				<label>专业所在学院</label>
			   </div>
		       
		  </div>
	      </form>
	      </div>
	  </div>
	  <div class="divider"></div>
	  <div class="modal-footer">
	    <a href="#!" onclick="edit_profession_ajax()" class="modal-action modal-close waves-effect waves-green red btn waves-light">更新资料<i class="material-icons right">send</i></a>
	    <span class="right">&nbsp;&nbsp;</span>
	    <a href="#!" onclick="Materialize.toast('操作已取消', 1500, 'rounded')" class="modal-action modal-close waves-effect waves-green btn waves-light">取消<i class="material-icons right">cancel</i></a>
	  </div>
	</div>
	<!-- 删除确认弹出框 -->
	  <!-- Modal Structure -->
	<div id="delete_profession" class="modal">
	  <div class="modal-content">
	    <h4>删除确认</h4>
	    <h6>
				<i class="material-icons">warning</i>确认删除专业<span id="delete_profession_name" class="green-text"></span>吗？
		</h6>
	  </div>
	  <div class="modal-footer">
	    <a id="delete_profession_link" class="modal-action modal-close waves-effect waves-green red btn waves-light">确认删除<i class="material-icons right">send</i></a>
	    <span class="right">&nbsp;&nbsp;</span>
	    <a href="javascript:void(0);" class="modal-action modal-close waves-effect waves-green btn waves-light">取消操作<i class="material-icons right">cancel</i></a>
	  </div>
	</div>
	
</body>
</html>