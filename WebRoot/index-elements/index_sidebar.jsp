<%@page import="cn.news.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html>
  <head>
    
    <title>My JSP 'index_sidebar.jsp' starting page</title>
    


  </head>
  
  <body>
  <%
  	List<News> list1=(List<News>)request.getAttribute("list1");
  	List<News> list2=(List<News>)request.getAttribute("list2");
  	List<News> list3=(List<News>)request.getAttribute("list3");
  
   %>
   <h1>国内新闻</h1>
   <div class="side_list">
   <%
   for(News news:list1){
   	%>
   		<li> <a href="#"> <%=news.getNtitle() %></a></li>
   	
   <%
   }
   
    %>
   
   </div>
   
  </body>
</html>
