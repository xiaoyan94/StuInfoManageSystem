<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<div id="notice_tab" >
	   <!-- 搜索表单开始 -->
     <div id="search_notice_modal" class="modal">
     	<div class="modal-content">
        <form id="search_notice_form" action="javascript:submit_search_notice_form()" class="col s12" method="post">
         <div class="row">
           <div class="input-field col s10">
             <input id="search_notice_key" name="searchKey" type="text" class="validate required" data-length="20">
             <label for="search_notice_key">请输入搜索关键词</label>
           </div>
	       <div onclick="submit_search_notice_form()" class="input-field col s2 modal-action modal-close waves-effect waves-light btn">搜索</div>
         </div>
       </form>
     	</div>
     	<%-- <div class="modal-footer">
     		<a href="" class="modal-action modal-close waves-effect waves-green red btn waves-light">确认<i class="material-icons right">send</i></a>
       <span class="right">&nbsp;&nbsp;</span>
       <a href="javascript:void(0);" class="modal-action modal-close waves-effect waves-green btn waves-light">取消<i class="material-icons right">cancel</i></a>
     	</div> --%>
     </div>
     <!-- 搜索表单结束 -->
    <div class="section"></div>
    <div id='preloading' style="text-align: center;">
    		<div style="height: 200px;">
    		</div>
		    <div class="preloader-wrapper big active">
		      <div class="spinner-layer spinner-blue">
		        <div class="circle-clipper left">
		          <div class="circle"></div>
		        </div><div class="gap-patch">
		          <div class="circle"></div>
		        </div><div class="circle-clipper right">
		          <div class="circle"></div>
		        </div>
		      </div>
		
		      <div class="spinner-layer spinner-red">
		        <div class="circle-clipper left">
		          <div class="circle"></div>
		        </div><div class="gap-patch">
		          <div class="circle"></div>
		        </div><div class="circle-clipper right">
		          <div class="circle"></div>
		        </div>
		      </div>
		
		      <div class="spinner-layer spinner-yellow">
		        <div class="circle-clipper left">
		          <div class="circle"></div>
		        </div><div class="gap-patch">
		          <div class="circle"></div>
		        </div><div class="circle-clipper right">
		          <div class="circle"></div>
		        </div>
		      </div>
		
		      <div class="spinner-layer spinner-green">
		        <div class="circle-clipper left">
		          <div class="circle"></div>
		        </div><div class="gap-patch">
		          <div class="circle"></div>
		        </div><div class="circle-clipper right">
		          <div class="circle"></div>
		        </div>
		      </div>
		    </div>
		   <div>
		    <font face="Microsoft YaHei">正在加载...</font>
		   </div>
		</div>
		<div>
    
		  <ul id="notice_ul" class="collapsible popout" data-collapsible="expandable">
		  </ul>
		  <!-- 分页 -->
			<div class="row center">
				<ul class="pagination" id="notice_pager">
				    <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
				    <li class="active blue lighten-2"><a href="#!">1</a></li>
				    <li class="waves-effect"><a href="#!">2</a></li>
				    <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
				</ul>
			</div>
		<div class="fixed-action-btn">
          <a onclick="get_search_focus()" href="#!" class="btn-floating btn-large red oulse">
            <i class="large material-icons">search</i>
          </a>
          <!-- <ul>
            <li><a class="btn-floating green"><i class="material-icons">attach_file</i></a></li>
            <li><a onclick="get_search_focus()" href="#!" class="btn-floating blue"><i class="material-icons">search</i></a></li>
          </ul> -->
        </div>
		</div>
		
<!--    全局悬浮按钮
        <div class="fixed-action-btn">
          <a class="btn-floating btn-large red oulse">
            <i class="large material-icons">add</i>
          </a>
          <ul>
            <li><a class="btn-floating red"><i class="material-icons">insert_chart</i></a></li>
            <li><a class="btn-floating yellow darken-1"><i class="material-icons">format_quote</i></a></li>
            <li><a class="btn-floating green"><i class="material-icons">publish</i></a></li>
            <li><a class="btn-floating blue"><i class="material-icons">attach_file</i></a></li>
          </ul>
        </div>
-->
</div>