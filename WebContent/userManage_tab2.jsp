<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<body>
<div id="test2" class="col s12">
	<!-- 表格开始 -->
	<table class="striped highlight centered">
	  <thead class="blue lighten-2">
	    <tr>
	        <th>序号</th>
	        <th>学号</th>
	        <th>姓名</th>
	        <th>性别</th>
	        <th>电话</th>
	        <th>操作</th>
	    </tr>
	  </thead>
	  <tbody id="student_list_table">
	    <tr>
	      <td>1</td>
	      <td>1408090213</td>
	      <td>小明同学</td>
	      <td>男</td>
	      <td>信息科学技术学院</td>
	      <td>
	        <a class="waves-effect waves-light btn tooltipped" data-position="bottom" data-tooltip="详情" href="#details-student"><i class="material-icons">info</i></a>&nbsp;&nbsp;
	        <a class="waves-effect waves-light btn tooltipped green" data-position="bottom" data-tooltip="编辑" href="#edit-student"><i class="material-icons">edit</i></a>&nbsp;&nbsp;
	        <a class="waves-effect waves-light btn tooltipped red" data-position="bottom" data-tooltip="删除" href="#delete-student"><i class="material-icons">delete</i></a>
	      </td>
	    </tr>
	  </tbody>
	</table>
	<!-- 表格结束 -->
	<div class="section"></div>
	<!-- 分页 -->
	<div class="row center">
		<ul class="pagination">
		    <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
		    <li class="active blue lighten-2"><a href="#!">1</a></li>
		    <li class="waves-effect"><a href="#!">2</a></li>
		    <li class="waves-effect"><a href="#!">3</a></li>
		    <li class="waves-effect"><a href="#!">4</a></li>
		    <li class="waves-effect"><a href="#!">5</a></li>
		    <li class="waves-effect"><a href="#!">6</a></li>
		    <li class="waves-effect"><a href="#!">7</a></li>
		    <li class="waves-effect"><a href="#!">8</a></li>
		    <li class="waves-effect"><a href="#!">9</a></li>
		    <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
		</ul>
	</div>


	<!-- MODAL STRUCTURE -->
	<!-- 学生信息详情弹出框 -->
	<div id="details-student" class="modal">
	  <div class="modal-content">
	    <h4>详细资料</h4>
	    <div class="row">
	       <div class="input-field col s6">
	         <i class="material-icons prefix">group</i>
	         <input readonly id="details_student_id" type="text" class="validate" value=" ">
	         <label for="details_student_id">ID</label>
	       </div>
	       <div class="input-field col s6 ">
	         <i class="material-icons prefix">account_circle</i>
	         <input readonly id="details_student_username" type="text" class="validate" value=" ">
	         <label for="details_student_username">学号</label>
	       </div>
	     </div>
	     <div class="row">
	       <div class="input-field col s6">
	         <i class="material-icons prefix">person</i>
	         <input readonly id="details_student_realname" type="text" class="validate" value=" ">
	         <label for="details_student_realname">姓名</label>
	       </div>
	       <div class="input-field col s6">
	     	 <i class="material-icons prefix">spa</i>
	       <label> <span>性别</span></label> 
	       <div class="col s4 offset-s2">
	          <input required="required" id="details_student_nan" class="disabled" name="sex" type="radio" value="男" />
	          <label for="details_student_nan">男</label>
	          <input checked disabled="disabled" required="required" class="" id="details_student_nv" name="sex" type="radio" value="女" />
	          <label for="details_student_nv">女</label>
	       </div>
	      </div>
	     </div>
	     <div class="row">
	       <div class="input-field col s6">
	         <i class="material-icons prefix">phone</i>
	         <input readonly id="details_student_telephone" type="tel" class="validate" value=" ">
	         <label for="details_student_telephone">联系电话</label>
	       </div>
	       <div class="input-field col s6">
	         <i class="material-icons prefix">email</i>
	         <input readonly id="details_student_email" type="text" class="validate" value="  ">
	         <label for="details_student_email">Email</label>
	       </div>
	     </div>                  
	     <div class="row">
	       <div class="input-field col s6">
	         <i class="material-icons prefix">vpn_key</i>
	         <input readonly id="details_student_password" type="password" class="validate" value=" " data-length="20">
	         <label for="details_student_password">密码</label>
	       </div>
	       <div class="col s4 offset-s1 "  style="padding-top:1rem">
	    		<a href="#!" class="bottom col s12 top modal-action modal-close waves-effect waves-green btn waves-light">关闭窗口<i class="material-icons right">cancel</i></a>
	       </div>
	     </div>
	  </div>
	  <div class="divider"></div>
	  <div class="modal-footer">
	    <a href="#!" onclick="Materialize.toast('操作已提交', 4000, 'rounded')" class="modal-action modal-close waves-effect waves-green red btn waves-light">提交<i class="material-icons right">send</i></a>
	    <span class="right">&nbsp;&nbsp;</span>
	    <a onclick="Materialize.toast('操作已取消', 4000, 'rounded')" href="javascript:void(0);" class="modal-action modal-close waves-effect waves-green btn pulse waves-light">取消<i class="material-icons right">cancel</i></a>
	  </div>
	</div>
	<!-- student信息编辑弹出框 -->
	<div id="edit-student" class="modal">
	  <div class="modal-content">
      	<div class="row">
		    <div class="col s12">
		      <ul class="tabs">
		        <li class="tab col s3 active"><a class="active" href="#edit_t1">基本信息</a></li>
		        <li class="tab col s3"><a href="#edit_t3">去向信息</a></li>
		        <li class="tab col s3"><a href="#edit_t2">其他信息</a></li>
		      </ul>
		    </div>
		</div>
        <form style="height: 280px" id="form_student_edit_t2" class="col s12" action="studentAction_save" method="post">
          <div id="edit_t1" class="col s12">
          <div class="row">
			  <div class="input-field col s6">
		         <i class="material-icons prefix">group</i>
				<select id="edit_student_classes" name="student_classes">
					<option value="" disabled selected>请选择班级</option>
					<!-- <option value="1">选项 1</option>
					<option value="2">选项 2</option>
					<option value="3">选项 3</option> -->
				</select>
				<label>所在班级</label>
			  </div>
			  <div class="input-field col s6">
		         <i class="material-icons prefix">navigation</i>
				<select id="edit_student_going" name="student_going">
					<option value="" disabled selected>请选择去向</option>
					<!-- <option value="1">选项 1</option>
					<option value="2">选项 2</option>
					<option value="3">选项 3</option> -->
				</select>
				<label>去向</label>
			  </div>
            <div class="input-field col s6 ">
              <i class="material-icons prefix">account_circle</i>
              <input readonly="readonly" required="required" id="edit_student_id" name="id" type="text" class="validate required" data-length="20" value=" ">
              <label for="edit_student_id">学号</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">person</i>
              <input required="required" id="edit_student_name" name="name" type="text" class="validate" data-length="20"  value=" ">
              <label for="edit_student_name">姓名</label>
            </div>
            <div class="input-field col s6">
           	  <i class="material-icons prefix">spa</i>
              <label> <span>性别</span></label> 
              <div class="col s4 offset-s2">
                <input required="required" checked id="edit_student_nan" class="" name="sex" type="radio" value="男" />
                <label for="edit_student_nan">男</label>
                <input required="required" class="" id="edit_student_nv" name="sex" type="radio" value="女" />
                <label for="edit_student_nv">女</label>
              </div>
            </div>
          </div>
          </div><!-- end tab1 -->
           <div id="edit_t3" class="row" style="height: 100%">
		    	<div class="section"></div>
		    	<div class="input-field col s6">
	              <i class="material-icons prefix">group</i>
	              <input required="required" id="edit_student_workName" name="edit_student_workName" type="text" class="validate" data-length="20"  value=" ">
	              <label for="edit_student_workName">单位</label>
	            </div>
		    	<div class="input-field col s6">
	              <i class="material-icons prefix">person</i>
	              <input required="required" id="edit_student_workLinkmanName" name="edit_student_workLinkmanName" type="text" class="validate" data-length="20"  value=" ">
	              <label for="edit_student_workLinkmanName">单位联系人姓名</label>
	            </div>
	            <div class="input-field col s6">
	              <i class="material-icons prefix">phone</i>
	              <input required="required" id="edit_student_workTel" name="edit_student_workTel" type="tel" class="validate" data-length="11"  value=" ">
	              <label for="edit_student_workTel">单位联系电话</label>
	            </div>
		    	<div class="input-field col s6">
	              <i class="material-icons prefix">navigation</i>
	              <input required="required" id="edit_student_workAddress" name="edit_student_workAddress" type="text" class="validate" data-length="20"  value=" ">
	              <label for="edit_student_workAddress">单位地址</label>
	            </div>
		    </div>
		    <div id="edit_t2" class="row" style="height: 100%">
		    	<div class="section"></div>
		    	<div class="input-field col s6">
	              <i class="material-icons prefix">vpn_key</i>
	              <input required="required" id="edit_student_password" name="password" type="password" class="validate" data-length="20"  value=" ">
	              <label for="edit_student_password">登录密码</label>
	            </div>
	            <div class="input-field col s6">
	              <i class="material-icons prefix">phone</i>
	              <input required="required" id="edit_student_tel" name="tel" type="tel" class="validate" data-length="11"  value=" ">
	              <label for="edit_student_tel">联系电话</label>
	            </div>
	            <div class="input-field col s6">
	              <i class="material-icons prefix">email</i>
	              <input id="edit_student_email" name="email" type="email" class="validate"  value=" ">
	              <label for="edit_student_email">Email</label>
	            </div>
	            <div class="input-field col s6">
	              <i class="material-icons prefix">person</i>
	              <input required="required" id="edit_student_idCard" name="idCard" type="text" class="validate" data-length="20"  value=" ">
	              <label for="edit_student_idCard">身份证号</label>
	            </div>
		    </div>                  
          <!-- <div class="row">
            <div id="edit_student_link" onclick="edit_student_ajax()" class="modal-action modal-close input-field col s5 waves-effect waves-light btn">更新此学生信息</div>
            	<div class="col s2"></div>
            <div id="" onclick="" class="modal-action modal-close input-field col s5 waves-effect waves-light btn">返回</div>
          </div> -->
        </form>
      	</div>
	  <div class="divider"></div>
	  <div class="modal-footer">
	    <a id="edit_student_link" onclick="edit_student_ajax()" class="modal-action modal-close waves-effect waves-green red btn waves-light">更新资料<i class="material-icons right">send</i></a>
	    <span class="right">&nbsp;&nbsp;</span>
	    <a href="javascript:void(0);" class="modal-action modal-close waves-effect waves-green btn waves-light">取消<i class="material-icons right">cancel</i></a>
	  </div>
	</div>
	<!-- 删除确认弹出框 -->
	  <!-- Modal Structure -->
	<div id="delete-student" class="modal">
	  <div class="modal-content">
	    <h4>删除确认</h4>
	    <p>确认删除学号为<span id="delete_student_id"></span>的学生吗</p>
	  </div>
	  <div class="modal-footer">
	    <a id="delete_student_link" onclick="delete_student_ajax('id')" class="modal-action modal-close waves-effect waves-green red btn waves-light">确认删除<i class="material-icons right">send</i></a>
	    <span class="right">&nbsp;&nbsp;</span>
	    <a href="javascript:void(0);" class="modal-action modal-close waves-effect waves-green btn waves-light">取消操作<i class="material-icons right">cancel</i></a>
	  </div>
	</div>
	<!-- ------------------------ -->
	<div id="add_student" class="modal">
      	<div class="modal-content">
      	<div class="row">
		    <div class="col s12">
		      <ul class="tabs">
		        <li class="tab col s3"><a href="#t1">基本信息</a></li>
		        <li class="tab col s3"><a href="#t3">去向信息</a></li>
		        <li class="tab col s3"><a href="#t2">其他信息</a></li>
		      </ul>
		    </div>
		</div>
        <form id="form_student_add2" class="col s12" action="studentAction_save" method="post">
          <div id="t1" class="col s12">
          <div class="row">
			  <div class="input-field col s6">
		         <i class="material-icons prefix">group</i>
				<select id="add_student_classes" name="student_classes">
					<option value="" disabled selected>请选择班级</option>
					<!-- <option value="1">选项 1</option>
					<option value="2">选项 2</option>
					<option value="3">选项 3</option> -->
				</select>
				<label>所在班级</label>
			  </div>
			  <div class="input-field col s6">
		         <i class="material-icons prefix">navigation</i>
				<select id="add_student_going" name="student_going">
					<option value="" disabled selected>请选择去向</option>
					<!-- <option value="1">选项 1</option>
					<option value="2">选项 2</option>
					<option value="3">选项 3</option> -->
				</select>
				<label>去向</label>
			  </div>
            <div class="input-field col s6 ">
              <i class="material-icons prefix">account_circle</i>
              <input required="required" id="add_student_id" name="id" type="text" class="validate required" data-length="20">
              <label for="add_student_id">学号</label>
            </div>
            <div class="input-field col s6">
              <i class="material-icons prefix">person</i>
              <input required="required" id="add_student_name" name="name" type="text" class="validate" data-length="20">
              <label for="add_student_name">姓名</label>
            </div>
            <div class="input-field col s6">
           	  <i class="material-icons prefix">spa</i>
              <label> <span>性别</span></label> 
              <div class="col s4 offset-s2">
                <input required="required" id="add_student_nan" class="" name="sex" type="radio" value="男" />
                <label for="add_student_nan">男</label>
                <input checked="checked" required="required" class="" id="add_student_nv" name="sex" type="radio" value="女" />
                <label for="add_student_nv">女</label>
              </div>
            </div>
          </div>
          </div><!-- end tab1 -->
           <div id="t3" class="row" style="height: 100%">
		    	<div class="section"></div>
		    	<div class="input-field col s6">
	              <i class="material-icons prefix">group</i>
	              <input required="required" id="add_student_workName" name="add_student_workName" type="text" class="validate" data-length="20">
	              <label for="add_student_workName">单位</label>
	            </div>
		    	<div class="input-field col s6">
	              <i class="material-icons prefix">person</i>
	              <input required="required" id="add_student_workLinkmanName" name="add_student_workLinkmanName" type="text" class="validate" data-length="20">
	              <label for="add_student_workLinkmanName">单位联系人姓名</label>
	            </div>
	            <div class="input-field col s6">
	              <i class="material-icons prefix">phone</i>
	              <input required="required" id="add_student_workTel" name="add_student_workTel" type="tel" class="validate" data-length="11">
	              <label for="add_student_workTel">单位联系电话</label>
	            </div>
		    	<div class="input-field col s6">
	              <i class="material-icons prefix">navigation</i>
	              <input required="required" id="add_student_workAddress" name="add_student_workAddress" type="text" class="validate" data-length="20">
	              <label for="add_student_workAddress">单位地址</label>
	            </div>
		    </div>
		    <div id="t2" class="row" style="height: 100%">
		    	<div class="section"></div>
		    	<div class="input-field col s6">
	              <i class="material-icons prefix">vpn_key</i>
	              <input required="required" id="add_student_password" name="password" type="password" class="validate" data-length="20">
	              <label for="add_student_password">登录密码</label>
	            </div>
	            <div class="input-field col s6">
	              <i class="material-icons prefix">phone</i>
	              <input required="required" id="add_student_tel" name="tel" type="tel" class="validate" data-length="11">
	              <label for="add_student_tel">联系电话</label>
	            </div>
	            <div class="input-field col s6">
	              <i class="material-icons prefix">email</i>
	              <input id="add_student_email" name="email" type="email" class="validate">
	              <label for="add_student_email">Email</label>
	            </div>
	            <div class="input-field col s6">
	              <i class="material-icons prefix">person</i>
	              <input required="required" id="add_student_idCard" name="idCard" type="text" class="validate" data-length="20">
	              <label for="add_student_idCard">身份证号</label>
	            </div>
		    </div>                  
          <div class="row">
            <div id="add_student_link" onclick="add_student_ajax()" class="modal-action modal-close input-field col s12 waves-effect waves-light btn">添加此学生信息</div>
          </div>
        </form>
      	</div>
      	<%-- <div class="modal-footer">
      		<a href="" class="modal-action modal-close waves-effect waves-green red btn waves-light">确认<i class="material-icons right">send</i></a>
        <span class="right">&nbsp;&nbsp;</span>
        <a href="javascript:void(0);" class="modal-action modal-close waves-effect waves-green btn waves-light">取消<i class="material-icons right">cancel</i></a>
      	</div> --%>
      </div>
	<!-- ---------------- -->
	<div class="fixed-action-btn">
       <a id="add_student_btn" onclick="add_student()" href="#add_student" class="btn-floating btn-large red pulse tooltipped modal-trigger" data-position="top" data-tooltip="添加学生" >
         <i class="large material-icons">add</i>
       </a>
     </div>
	</div>
</body>
</html>