<%@page import="cn.news.entity.Topic"%>
<%@page import="cn.news.entity.News"%>
<%@page import="cn.news.dao.Impl.NewsDaoImpl"%>
<%@page import="cn.news.dao.NewsDao"%>
<%@page import="cn.news.dao.Impl.TopicsDaoImpl"%>
<%@page import="cn.news.dao.TopicsDao"%>
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
    String opr =request.getParameter("opr");
    NewsDao newsDao=new NewsDaoImpl();
    TopicsDao topicsDao =new TopicsDaoImpl();
    NewsDao newDao =new NewsDaoImpl();
    
    if("listTitle".equals(opr)){
    //加载首页的侧边栏指定主题的最新消息
		List<News> list1 =newsDao.getLatestNewsByTid(1, 5);
		List<News> list2 =newsDao.getLatestNewsByTid(2, 5);
		List<News> list3 =newsDao.getLatestNewsByTid(5, 5);
		List<Topic> list=topicsDao.getAllTopics();
		List<News> list4=null;
		String tid=request.getParameter("tid");
		if(tid==null||(tid=tid.trim()).length()==0){
			list4=newDao.getAllnews();
		}else{
			list4=newDao.getAllnewsByTID(Integer.parseInt(tid));
		
		}
		request.setAttribute("list1",list1);
		request.setAttribute("list2",list2);
		request.setAttribute("list3",list3);
		request.setAttribute("list",list);
		request.setAttribute("list4",list4);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	
	}
    
    
    
    
     %>
    
    
  </body>
</html>
