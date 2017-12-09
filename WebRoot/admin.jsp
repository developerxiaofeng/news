<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
  <base href="<%=basePath%>">
    <title>  page</title>
    
	

  </head>
  
  <body>
    <div id="opt_list">
    <li><a href="newspages/news_add.jsp">添加新闻</a></li>
    <li><a href="util/do_news_list.jsp">编辑新闻</a></li>
    <li><a href="newspages/topic_add.jsp">添加主题</a></li>
    <li><a href="util/topics?opr=list">编辑主题</a></li>
    </div>
  </body>
</html>
