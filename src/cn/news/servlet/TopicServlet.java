package cn.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.news.dao.NewsDao;
import cn.news.dao.TopicsDao;
import cn.news.dao.Impl.NewsDaoImpl;
import cn.news.dao.Impl.TopicsDaoImpl;
import cn.news.entity.Topic;

public class TopicServlet extends HttpServlet {
	TopicsDao topicsDao =new TopicsDaoImpl();
	NewsDao newsDao=new NewsDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    String opr =request.getParameter("opr");
	    PrintWriter out=response.getWriter();
	    String contextPath=request.getContextPath();
	    String path = request.getContextPath();
	    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
				out.print("<script type=\"text/javascript\">");
				out.print("alert(\"当前主题创建成功，点击确认返回主题列表\");");
				out.print("location.href=\""+contextPath+"/util/topics?opr=list\";");
				out.print("</script>");
	  		}else{
	    //重新填入
	  			topicsDao.addTopic(tname);
				out.print("<script type=\"text/javascript\">");
				out.print("alert(\"当前主题信息已存在，请输入不同的主题！\");");
				out.print("location.href=\"../newspages/topic_add.jsp\";");
				out.print("</script>");	
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
	    					out.print("<script type=\"text/javascript\">");
	    					out.print("alert(\"更新成功，点击返回主题列表\");");
	    					out.print("location.href=\"topic_control.jsp?opr=list\";");
	    					out.print("</script>");	
						}else{
							out.print("<script type=\"text/javascript\">");
	    					out.print("alert(\"更新失败，请联系管理员，点击返回主题列表\");");
	    					out.print("location.href=\"topic_control.jsp?opr=list\";");
	    					out.print("</script>");
						}						
	    			}else{
	    				out.print("<script type=\"text/javascript\">");
    					out.print("alert(\"更新失败,这个主题名已经存在\");");
    					out.print("location.href=\"topic_control.jsp?opr=list\";");
    					out.print("</script>");
	    			}
			 }else if("del".equals(opr)){
	    	//删除主题
	    	String tid = request.getParameter("tid");
	    	
	    	if(newsDao.getNewsCountByTID(Integer.parseInt(tid))==0){
	    			if(topicsDao.deleteTopic(Integer.parseInt(tid))>0){
	    				out.print("<script type=\"text/javascript\">");
    					out.print("alert(\"已经成功删除主题，点击返回主题列表\");");
    					out.print("topic_control.jsp?opr=list\";");
    					out.print("</script>");
	    			}else{
	    				out.print("<script type=\"text/javascript\">");
    					out.print("alert(\"删除主题失败，请联系管理员！点击返回主题列表\");");
    					out.print("topic_control.jsp?opr=list\";");
    					out.print("</script>");
	    					}
			}else{
				out.print("<script type=\"text/javascript\">");
				out.print("alert(\"该主题下面有文章不能删除\");");
				out.print("topic_control.jsp?opr=list\";");
				out.print("</script>");
					
			}

	    }
		
		out.flush();
		out.close();
	}

}
