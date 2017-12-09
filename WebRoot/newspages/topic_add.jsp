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
    <h1 id="opt_type">添加主题：</h1>
    <form action="util/topics?opr=add" method="post" onsubmit="return check();">
    	<p>
    		<lable>主题名称</lable>
    		<input name="tname" type="text" class="opt_input"/>
    		
    	</p>
    	<input type="submit" value="提交" class="opt_sub"/>
    	<input type="reset" value="重置" class="opt_sub"/>
    </form>
  </body>
</html>
