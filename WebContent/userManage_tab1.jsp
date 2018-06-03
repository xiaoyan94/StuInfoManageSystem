<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<body>
<div id="test1" class="col s12">
          <!-- MODAL STRUCTURE -->
          <!-- 管理员信息详情弹出框 -->
          <div id="details-admin" class="modal">
            <div class="modal-content">
              <!-- <h5>详细资料</h5> -->
              <div class="row">
                 <div class="input-field col s6">
                   <i class="material-icons prefix">group</i>
                   <input readonly id="details_admin_id" type="text" class="validate" value=" ">
                   <label for="details_admin_id">ID</label>
                 </div>
                 <div class="input-field col s6 ">
                   <i class="material-icons prefix">account_circle</i>
                   <input readonly id="details_admin_username" type="text" class="validate" value=" ">
                   <label for="details_admin_username">用户名</label>
                 </div>
               </div>
               <div class="row">
                 <div class="input-field col s6">
                   <i class="material-icons prefix">person</i>
                   <input readonly id="details_admin_realname" type="text" class="validate" value=" ">
                   <label for="details_admin_realname">姓名</label>
                 </div>
                 <div class="input-field col s6">
               	 <i class="material-icons prefix">spa</i>
                 <label> <span>性别</span></label> 
                 <div class="col s4 offset-s2">
                    <input required="required" id="details_admin_nan" class="disabled" name="sex" type="radio" value="男" />
                    <label for="details_admin_nan">男</label>
                    <input checked disabled="disabled" required="required" class="" id="details_admin_nv" name="sex" type="radio" value="女" />
                    <label for="details_admin_nv">女</label>
                 </div>
                </div>
               </div>
               <div class="row">
                 <div class="input-field col s6">
                   <i class="material-icons prefix">phone</i>
                   <input readonly id="details_admin_telephone" type="tel" class="validate" value=" ">
                   <label for="details_admin_telephone">联系电话</label>
                 </div>
                 <div class="input-field col s6">
                   <i class="material-icons prefix">email</i>
                   <input readonly id="details_admin_email" type="text" class="validate" value="  ">
                   <label for="details_admin_email">Email</label>
                 </div>
               </div>                  
               <div class="row">
                 <div class="input-field col s6">
                   <i class="material-icons prefix">vpn_key</i>
                   <input readonly id="details_admin_password" type="password" class="validate" value=" " data-length="20">
                   <label for="details_admin_password">密码</label>
                 </div>
                 <div class="col s4 offset-s1 "  style="padding-top:1rem">
              		<a href="#!" class="bottom col s12 top modal-action modal-close waves-effect waves-green btn waves-light">关闭窗口<i class="material-icons right">cancel</i></a>
                 </div>
               </div>
            </div>
<%--             <div class="divider"></div>
            <div class="modal-footer">
              <a href="#!" class="modal-action modal-close waves-effect waves-green red btn waves-light">提交<i class="material-icons right">send</i></a>
              <span class="right">&nbsp;&nbsp;</span>
              <a href="#!" class="modal-action modal-close waves-effect waves-green btn waves-light pulse">返回<i class="material-icons right">cancel</i></a>
            </div> --%>
          </div>
          <!-- 管理员信息编辑弹出框 -->
          <div id="edit-admin" class="modal">
            <div class="modal-content">
              <!-- <h4>编辑资料</h4> -->
              <div class="row">
                <form id="edit_admin_form" class="col s12" action="adminAction_update" method="post">
                  <div class="row">
                    <div class="input-field col s6">
                      <i class="material-icons prefix">group</i>
                      <input readonly id="edit_admin_id" name="id" type="text" class="validate tooltipped" data-position="bottom" data-tooltip="id不可修改" value="10000000">
                      <label for="edit_admin_id">ID</label>
                    </div>
                    <div class="input-field col s6 ">
                      <i class="material-icons prefix">account_circle</i>
                      <input readonly id="edit_admin_username" name="username" type="text" class="validate tooltipped" data-position="bottom" data-tooltip="用户名不可修改" value="username">
                      <label for="edit_admin_username">用户名</label>
                    </div>
                  </div>
                  <div class="row">
                    <div class="input-field col s6">
                      <i class="material-icons prefix">person</i>
                      <input id="edit_admin_realname" name="adminRealName" type="text" class="validate" value=" ">
                      <label for="edit_admin_realname">姓名</label>
                    </div>
                    <div class="input-field col s6">
	               	 <i class="material-icons prefix">spa</i>
	                 <label> <span>性别</span></label> 
	                 <div class="col s4 offset-s2">
	                    <input required="required" checked id="edit_admin_nan" class="" name="sex" type="radio" value="男" />
	                    <label for="edit_admin_nan">男</label>
	                    <input required="required" class="" id="edit_admin_nv" name="sex" type="radio" value="女" />
	                    <label for="edit_admin_nv">女</label>
	                 </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="input-field col s6">
                      <i class="material-icons prefix">phone</i>
                      <input id="edit_admin_telephone" name="tel" type="tel" class="validate" value="1378448394">
                      <label for="edit_admin_telephone">联系电话</label>
                    </div>
                    <div class="input-field col s6">
                      <i class="material-icons prefix">email</i>
                      <input id="edit_admin_email" name="email" type="email" class="validate" value="ruguo_0904@163.com">
                      <label for="edit_admin_email">Email</label>
                    </div>
                  </div>                  
                  <div class="row">
                    <div class="input-field col s6">
                      <i class="material-icons prefix">vpn_key</i>
                      <input id="edit_admin_password" type="password" name="password" class="validate" value=" " data-length="20">
                      <label for="edit_admin_password">密码</label>
                    </div>
                    <div class="col s6" style="padding-top:1rem">
		              <a href="#!" onclick="Materialize.toast('操作已取消', 4000, 'rounded')" class="modal-action modal-close waves-effect waves-green btn waves-light pulse tooltipped" data-position="top" data-tooltip="取消更改并返回">取消操作<i class="material-icons right">cancel</i></a>
		              <%-- <span class="right">&nbsp;&nbsp;</span> --%>
	                  <a href="#!" onclick="edit_admin_form_submit()" class="modal-action modal-close waves-effect waves-green red btn waves-light tooltipped" data-position="top" data-tooltip="确认更新资料吗？">更新资料<i class="material-icons right">send</i></a>
                    </div>
                  </div>
                </form>
                </div>
            </div>
            <!-- <div class="divider"></div> -->
<%--             <div class="modal-footer">
              <a href="#!" onclick="edit_admin_form_submit()" class="modal-action modal-close waves-effect waves-green red btn waves-light tooltipped" data-position="top" data-tooltip="确认更新资料吗？">更新资料<i class="material-icons right">send</i></a>
              <span class="right">&nbsp;&nbsp;</span>
              <a href="#!" onclick="Materialize.toast('操作已取消', 4000, 'rounded')" class="modal-action modal-close waves-effect waves-green btn waves-light pulse tooltipped" data-position="top" data-tooltip="取消更改并返回">取消<i class="material-icons right">cancel</i></a>
            </div> --%>
          </div>
          <!-- 删除确认弹出框 -->
            <!-- Modal Structure -->
          <div id="delete-admin" class="modal">
            <div class="modal-content">
              <h4>删除确认</h4>
              <h6>
              	<i class="material-icons">warning</i>确认删除管理员<span id="delete_admin_username" class="green-text"></span>吗？
              </h6>
            </div>
            <div class="modal-footer">
              <a id="delete_admin_link" href="#!" onclick="Materialize.toast('操作已提交', 4000, 'rounded')" class="modal-action modal-close waves-effect waves-green red btn waves-light tooltipped  tooltipped" data-position="top" data-tooltip="删除后不可恢复！！">确认删除<i class="material-icons right">send</i></a>
              <span class="right">&nbsp;&nbsp;</span>
              <a href="#!" onclick="Materialize.toast('操作已取消', 4000, 'rounded')" class="modal-action modal-close waves-effect waves-green btn waves-light pulse tooltipped" data-position="top" data-tooltip="取消删除操作并返回">取消操作<i class="material-icons right">cancel</i></a>
            </div>
          </div>
          <!-- 表格开始 -->
          <table id="table_admin_list" class="striped highlight centered">
            <thead class="cyan">
              <tr>
                  <th>序号</th>
                  <th>用户名</th>
                  <th>姓名</th>
                  <th>性别</th>
                  <th>联系电话</th>
                  <th>操作</th>
              </tr>
            </thead>
            <tbody>
            <s:iterator value="adminList" var="admin" status="s">
              <tr>
                <td><s:property value="#s.index+1"/></td>
                <td><s:property value="#admin.adminName"/></td>
                <td><s:property value="#admin.adminRealName"/></td>
                <td><s:property value="#admin.sex"/></td>
                <td><s:property value="#admin.adminTel"/></td>
                <%-- <td><a href="mailto:111@222.com">1111111@aaaa.com</a></td> --%>
                <td>
                  <a class="waves-effect waves-light btn tooltipped" data-position="bottom" data-tooltip="详情" href="#details-admin" onclick="details_admin('<s:property value="#admin.adminId"/>')"><i class="material-icons">info</i></a>&nbsp;&nbsp;
                  <a class="waves-effect waves-light btn tooltipped green" data-position="bottom" data-tooltip="编辑" href="#edit-admin" onclick="edit_admin('<s:property value="#admin.adminId"/>')"><i class="material-icons">edit</i></a>&nbsp;&nbsp;
                  <a class="waves-effect waves-light btn tooltipped red" data-position="bottom" data-tooltip="删除" href="#delete-admin" onclick="delete_admin('<s:property value="#admin.adminId"/>','<s:property value="#admin.adminName"/>')"><i class="material-icons">delete</i></a>
                </td>
              </tr>
            </s:iterator>
            </tbody>
          </table>
          <!-- 表格结束 -->

          <!-- 添加管理员表单开始 -->
          <div id="form_admin_add" class="modal">
          	<div class="modal-content">
          	<h4>添加管理员</h4>
            <form id="form_admin_add2" class="col s12" action="adminAction_save" method="post">
              <div class="row">
                <div class="input-field col s4 ">
                  <i class="material-icons prefix">account_circle</i>
                  <input required="required" id="add_admin_username" name="username" type="text" class="validate required" data-length="20">
                  <label for="add_admin_username">用户名</label>
                </div>
                <div class="input-field col s4">
                  <i class="material-icons prefix">vpn_key</i>
                  <input required="required" id="add_admin_password" name="password" type="password" class="validate" data-length="20">
                  <label for="add_admin_password">密码</label>
                </div>
                <div class="input-field col s4">
                  <i class="material-icons prefix">vpn_key</i>
                  <input id="add_admin_repassword" type="password" name="repassword" class="validate"  data-length="20">
                  <label for="add_admin_repassword">确认密码</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s6">
                  <i class="material-icons prefix">person</i>
                  <input required="required" id="add_admin_realname" name="adminRealName" type="text" class="validate" data-length="20">
                  <label for="add_admin_realname">姓名</label>
                </div>
                <div class="input-field col s6">
               	  <i class="material-icons prefix">spa</i>
                  <label> <span>性别</span></label> 
                  <div class="col s4 offset-s2">
                    <input required="required" checked id="add_admin_nan" class="" name="sex" type="radio" value="男" />
                    <label for="add_admin_nan">男</label>
                    <input required="required" class="" id="add_admin_nv" name="sex" type="radio" value="女" />
                    <label for="add_admin_nv">女</label>
                  </div>
                </div>
              </div>
              <!-- <div class="divider"></div> -->
              <div class="row">
                <div class="input-field col s6">
                  <i class="material-icons prefix">phone</i>
                  <input required="required" id="add_admin_telephone" name="tel" type="tel" class="validate" data-length="11">
                  <label for="add_admin_telephone">联系电话</label>
                </div>
                <div class="input-field col s6">
                  <i class="material-icons prefix">email</i>
                  <input id="add_admin_email" name="email" type="email" class="validate">
                  <label for="add_admin_email">Email</label>
                </div>
              </div>                  
              <div class="row">
                <div id="admin_add_btn" onclick="submitAddAdminForm();" class="input-field col s12 waves-effect waves-light btn">添加此管理员信息</div>
              </div>
            </form>
          	</div>
          	<%-- <div class="modal-footer">
          		<a href="" class="modal-action modal-close waves-effect waves-green red btn waves-light">确认<i class="material-icons right">send</i></a>
		          <span class="right">&nbsp;&nbsp;</span>
		          <a href="javascript:void(0);" class="modal-action modal-close waves-effect waves-green btn waves-light">取消<i class="material-icons right">cancel</i></a>
          	</div> --%>
          </div>
          <!-- 添加管理员表单结束 -->
          <!-- 悬浮按钮开始 -->
          <div class="fixed-action-btn">
            <a id="btn-floating-1" href="#form_admin_add" class="btn-floating btn-large red pulse tooltipped modal-trigger" data-position="top" data-tooltip="添加管理员" >
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