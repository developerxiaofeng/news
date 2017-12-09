<%@page import="cn.news.entity.Topic"%>
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
  request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
   %>
    <div id="opt_area">
    	<ul class="classlist">
    	<%
    	List<Topic> list =(ArrayList<Topic>)request.getAttribute("list");
    	for(Topic tempTopic:list){
			
			%>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;<%=tempTopic.gettName() %>
			&nbsp;&nbsp;&nbsp;&nbsp;
			</li>
			
			
			<a href="newspages/topic_upd.jsp?tname=<%=tempTopic.gettName()%>">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="util/topic_control.jsp?opr=del&tid=<%=tempTopic.getTid()%>">删除</a>
			
			
			
			<%
			}
    	 %>
    	</ul>
    </div>
  </body>
</html>
