<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<body>
<div id="test6" class="col s12">
	<!-- 表格开始 -->
	<table class="striped highlight centered">
	  <thead class="green lighten-2">
	    <tr>
	        <th>序号</th>
	        <th>去向编号</th>
	        <th>去向类名</th>
	        <th>操作</th>
	    </tr>
	  </thead>
	  <tbody id="going_list_table">
	    <tr>
	      <td>1</td>
	      <td>1</td>
	      <td>出国</td>
	      <td>
	        <!-- <a onclick="details_going('id')" class="waves-effect waves-light btn tooltipped" data-position="bottom" data-tooltip="详情" href="#details_going"><i class="material-icons">info</i></a>&nbsp;&nbsp;
	        --> 
	        <a onclick="edit_going('id','去向名')" class="waves-effect waves-light btn tooltipped green" data-position="bottom" data-tooltip="编辑" href="#edit_going"><i class="material-icons left">edit</i>编辑</a>&nbsp;&nbsp;
	        <a onclick="delete_going('id','去向名')" class="waves-effect waves-light btn tooltipped red" data-position="bottom" data-tooltip="删除" href="#delete_going"><i class="material-icons left">delete</i>删除</a>
	      </td>
	    </tr>
	  </tbody>
	</table>
	<!-- 表格结束 -->
	<div class="section"></div>
	<!-- 分页 -->


	<!-- MODAL STRUCTURE -->

	<!-- going信息编辑弹出框 -->
	<div id="edit_going" class="modal">
	  <div class="modal-content">
	    <h4>编辑资料</h4>
	    <div class="row">
	      <form class="col s12" action="" method="post">
	        <div class="row">
	          <div class="input-field col s6">
	            <i class="material-icons prefix">group</i>
	            <input disabled="disabled" id="edit_going_id" name="id" type="text" class="validate" value="10000000">
	            <label for="edit_going_id">ID</label>
	          </div>
	          <div class="input-field col s6">
	            <i class="material-icons prefix">spa</i>
	            <input id="edit_going_name" name="name" type="text" class="validate" value="10000000">
	            <label for="edit_going_name">去向类名</label>
	          </div>
	        </div>
	        <div class="row">
	          <div class="input-field col s6">
	            <i class="material-icons prefix">edit</i>
	            <input id="edit_going_desc" name="desc" type="text" class="validate" value="备注信息">
	            <label for="edit_going_desc">备注</label>
	          </div>
	        </div>
	      </form>
	      </div>
	  </div>
	  <div class="divider"></div>
	  <div class="modal-footer">
	    <a href="#!" onclick="edit_going_ajax()" class="modal-action modal-close waves-effect waves-green red btn waves-light">更新资料<i class="material-icons right">send</i></a>
	    <span class="right">&nbsp;&nbsp;</span>
	    <a href="#!" onclick="Materialize.toast('操作已取消', 1500, 'rounded')" class="modal-action modal-close waves-effect waves-green btn waves-light">取消<i class="material-icons right">cancel</i></a>
	  </div>
	</div>
	<!-- 删除确认弹出框 -->
	<!-- Modal Structure -->
	<div id="delete_going" class="modal">
		<div class="modal-content">
			<h4>删除确认</h4>
			<h6>
				<i class="material-icons">warning</i>确认删除去向<span id="delete_going_name" class="green-text"></span>吗？
			</h6>
		</div>
		<div class="modal-footer">
			<a id="delete_going_link" href="#!" onclick="Materialize.toast('操作已提交', 4000, 'rounded')" class="modal-action modal-close waves-effect waves-green red btn waves-light tooltipped  tooltipped" data-position="top" data-tooltip="删除后不可恢复！！">确认删除<i class="material-icons right">send</i></a>
			<span class="right">&nbsp;&nbsp;</span>
			<a href="#!" onclick="Materialize.toast('操作已取消', 1500, 'rounded')" class="modal-action modal-close waves-effect waves-green btn waves-light pulse tooltipped" data-position="top" data-tooltip="取消删除操作并返回">取消操作<i class="material-icons right">cancel</i></a>
		</div>
	</div>
	<div id="add_going" class="modal">
		<div class="modal-content">
			<h4>添加去向</h4>
			<div class="row">
		    <form class="col s12" id="add_going_form">
		      <div class="row">
		        <div class="input-field col s6">
		          <input placeholder="去向名称" id="add_going_name" type="text" class="validate">
		          <label for="add_going_name">去向类名</label>
		        </div>
		        <div class="input-field col s6">
		          <input placeholder="添加备注" id="add_going_desc" type="text" class="validate">
		          <label for="add_going_desc">备注</label>
		        </div>
		      </div>
		    </form>
		  	</div>
		</div>
		<div class="modal-footer">
			<a id="add_going_link" href="#!" onclick="add_going()" class="modal-action modal-close waves-effect waves-green red btn waves-light tooltipped  tooltipped" data-position="top" data-tooltip="点击添加">确认添加<i class="material-icons right">send</i></a>
			<span class="right">&nbsp;&nbsp;</span>
			<a href="#!" onclick="Materialize.toast('操作已取消', 1000, 'rounded')" class="modal-action modal-close waves-effect waves-green btn waves-light pulse tooltipped" data-position="top" data-tooltip="取消删除操作并返回">取消操作<i class="material-icons right">cancel</i></a>
		</div>
	</div>
	<!-- 悬浮按钮开始 -->
    <div class="fixed-action-btn">
      <a id="btn-floating-1" href="#add_going" class="btn-floating btn-large red pulse tooltipped modal-trigger" data-position="top" data-tooltip="添加去向" >
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
	</div>
</body>
</html>