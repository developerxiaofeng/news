<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
  <base href="<%=basePath%>">
    <title>My JSP 'admin.jsp' starting page</title>
    
	

  </head>
  
  <body>
  
    <%
  request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String temp=request.getParameter("tname");
    
   %>
    <h1 id="opt_type">更新主题：</h1>
    <form action="util/topic_control.jsp?opr=upd" method="post" onsubmit="return check();">
    	<p>
    		<lable>主题名称</lable>
    		<input name="tNewName" type="text" class="opt_input"/>
    		<input type="hidden" name="hidden" value="<%=temp%>"/>
    	</p>
    	<input type="submit" value="提交" class="opt_sub"/>
    	<input type="reset" value="重置" class="opt_sub"/>
    </form>
  </body>
</html>
