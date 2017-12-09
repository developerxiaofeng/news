<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
   Tomcat连接池测试,获取数据源 <b>
  <%	
  		 try{      
            //初始化查找命名空间
            Context ctx = new InitialContext();  
            //参数java:/comp/env为固定路径   
            Context envContext = (Context)ctx.lookup("java:/comp/env/"); 
            //参数jdbc/mysqlds为数据源和JNDI绑定的名字
            DataSource ds = (DataSource)envContext.lookup("jdbc/news"); 
            Connection conn = ds.getConnection(); 
            PreparedStatement pstmt =null;
				ResultSet rs=null;
            if(conn==null){
				out.print("为空");
				}else{
				
				out.print("不为空");
				}
				String sql="select nid,ntid,ntitle,nauthor,"+
		"ncreateDate,nsummary,tname from news,topic"+
		" where news.ntid=topic.tid"+
		" and news.ntid=?"+
		" order by ncreateDate desc";
				
			pstmt=conn.prepareStatement(sql,1);
			
					//为预编译SQL设置参数
					pstmt.setObject(1, 1);
			
			rs=pstmt.executeQuery();
			rs.next();
			out.print(rs.getInt(1));
			pstmt.close();
			rs.close();	    
            conn.close();     
            out.println("<span style='color:red;'>JNDI测试成功<span>");     
        } catch (NamingException e) {     
            e.printStackTrace();     
        } catch (SQLException e) {     
            e.printStackTrace();     
        } 
  
  
   %>
  </body>
</html>
