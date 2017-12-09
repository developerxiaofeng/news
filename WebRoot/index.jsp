
<%@page import="cn.news.entity.News"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="cn.news.dao.Impl.NewsDaoImpl"%>
<%@page import="cn.news.dao.NewsDao"%>
<%@page import="cn.news.dao.Impl.TopicsDaoImpl"%>
<%@page import="cn.news.dao.TopicsDao"%>
<%@page import="cn.news.entity.Topic"%>
<%@page import="javax.swing.border.TitledBorder"%>
<%@page import="cn.news.entity.Topic"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<link href="css/index.css" rel="stylesheet" type="text/css"/>

</head>

<body>
<script type="text/javascript">
</script>
	<%
	request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    TopicsDao topicsDao =new TopicsDaoImpl();
    NewsDao newsDao=new NewsDaoImpl();
	List<Topic> list = topicsDao.getAllTopics();
	List<News> list4=(List<News>)request.getAttribute("list4");
	
	 %>
	<div id="container">
	<%@ include file="index-elements/index_sidebar.jsp" %>
		<div class="main">
			<div class="class_type">
				<img src="" alt="" />
			</div>
			<div class="content">
				<ul class="class_date">
					<%
					
   				int n=0;
   				for(Topic topic:list){
   					n++;
   					if(n%11==1){ out.println("<li id='class_month'>");}
   			%>
					<a href="util/news_control.jsp?opr=listTitle&tid=<%=topic.getTid()%>">

						<b><%=topic.gettName() %></b> </a>&nbsp;&nbsp;&nbsp;&nbsp;
					<%
   				if(n%11==0)	{out.println("</li>");}	
   				
   			}
   			if(n%11!=0)	{out.println("</li>");};
   			%>
				
				
				</ul>
				
		<ul class="classlist">
					<%
				if(list4==null){
   					out.println("<h6>出现错误，请稍后再试或者与管理员联系</h6>");			
   				}else if(list4.size()==0){
   					out.println("<h6>抱歉，没有找到相关的新闻</h6>");
   				}else{
   					DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   					n=0;
   					for(News news: list4){
   						%>
						<li><a href='#'><%=news.getNtitle() %></a> 
						<span><%=df.format(news.getNcreateDate()) %></span>
						</li>
					<%
   					 	 n++;
   						if(n%5==0){out.println("<li class='space'></li>");}
   					
   					}
   				}
					 %>
					<p align="right">
						当前页：[1/2]&nbsp; <a href="#">下一页</a><a href="#">末页</a>
					</p>
				
		</ul>
				
		</div>
			
			
			
			
		</div>



	</div>
	<div id=""></div>

</body>
</html>
