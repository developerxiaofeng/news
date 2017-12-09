<%@page import="cn.news.dao.NewsDao"%>
<%@page import="cn.news.dao.Impl.NewsDaoImpl"%>
<%@page import="cn.news.entity.News"%>
<%@page import="cn.news.dao.TopicsDao"%>
<%@page import="cn.news.entity.Topic"%>
<%@page import="cn.news.dao.Impl.TopicsDaoImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>My JSP 'admin.jsp' starting page</title>



</head>

<body>
	<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    String opr =request.getParameter("opr");
    TopicsDao topicsDao =new TopicsDaoImpl();
    
    if("list".equals(opr)){
    //编辑主题，显示所有主题信息
    	List<Topic> list = topicsDao.getAllTopics();
    	request.setAttribute("list", list);
    	request.getRequestDispatcher("../newspages/topic_list.jsp").forward(request, response);
    }else if("add".equals(opr)){
    	//添加主题
    	String tname = request.getParameter("tname");
    	Topic topic =topicsDao.findTopicByName(tname);
    	if(topic==null){
			topicsDao.addTopic(tname);
			
   %>
	<script type="text/javascript">
   				alert("当前主题创建成功，点击确认返回主题列表");
   					location.href="topic_control.jsp?opr=list";
   			</script>
	<%  	
  			  }else{
    //重新填入
    %>
	<script type="text/javascript">
  		 	alert("当前主题信息已存在，请输入不同的主题！");
  		 	location.href="../newspages/topic_add.jsp";
 			  </script>

	<%
    }
    
    }else if("upd".equals(opr)){
    	//更新主题
    	String tNewName = request.getParameter("tNewName");
    	String hidden = request.getParameter("hidden");
    	
    	
    	String tName = request.getParameter("hidden");
    	Topic newTopic =topicsDao.findTopicByName(tNewName);
    	out.print(tName+"++"+tNewName);
    	Topic topic =topicsDao.findTopicByName(tName);
    			if(newTopic==null&&topic!=null){
    				topic.settName(tNewName);
    				int result=topicsDao.updateTopic(topic);
    				if(result>0){
    				%>
	<script>
						
    					alert("更新成功，点击返回主题列表");
    					location.href="topic_control.jsp?opr=list";
    					</script>
	<% 			
					}else{
					
					%>
	<script>
    					alert("更新失败，请联系管理员，点击返回主题列表");
    					location.href="topic_control.jsp?opr=list";
    					</script>
	<% 	
					}						
    			}else{
    				%>
	<script type="text/javascript">
							alert("123");
    					</script>

	<%	
    			}
		

    }else if("del".equals(opr)){
    	//删除主题
    	String tid = request.getParameter("tid");
    	NewsDao newsDao=new NewsDaoImpl();
    	if(newsDao.getNewsCountByTID(Integer.parseInt(tid))==0){
    			if(topicsDao.deleteTopic(Integer.parseInt(tid))>0){
    				%>
	<script>
    					alert("已经成功删除主题，点击返回主题列表");
    					location.href="topic_control.jsp?opr=list";
    					</script>
	<% 
    			}else{
    				%>
	<script type="text/javascript">
    						alert("删除主题失败，请联系管理员！点击返回主题列表");
    						location.href="topic_control.jsp?opr=list";
    					</script>

	<%	
    			}
		}else{
				%>
	<script type="text/javascript">
    						alert("该主题下面有文章不能删除");
    						location.href="topic_control.jsp?opr=list";
    					</script>

	<%	
		}

    }
     %>
</body>
</html>
