package cn.news.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.news.util.ConfigManager;



public class BaseDao {

	protected Connection conn =null; 	//数据库连接对象
	protected PreparedStatement pstmt =null;

	protected ResultSet rs=null;
	/**
	 *获取数据库连接对象
	 */
	public Connection getConnection(){
		ConfigManager conf = ConfigManager.getInstrance();
		if(conn==null){
			//获取连接并捕获异常
			try {
				Class.forName(conf.getValue("driver"));
				conn = DriverManager.getConnection(conf.getValue("url"),
						conf.getValue("username"), 
						conf.getValue("password"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		return conn;

	}

	
	public Connection getConnection2(){
		Connection conn =null;
		try {
			//初始化上下文
			Context ctx= new InitialContext();
			//获取与逻辑名相关的数据源对象
			 Context envContext = (Context)ctx.lookup("java:/comp/env/"); 
	            //参数jdbc/mysqlds为数据源和JNDI绑定的名字
	            DataSource ds = (DataSource)envContext.lookup("jdbc/news"); 
			conn=ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	/**
	 * 关闭数据库连接
	 * @param conn
	 * @param stmt
	 */
	public void closeAll(Connection conn,PreparedStatement stmt,ResultSet rs){
		//若结果集对象不为空，则关闭 
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 增、删、改  操作
	 * @param preparedSql
	 * @param param
	 * @return
	 */
	public int exceuteUpdate(String preparedSql,Object...params){
		
		int num=0;
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(preparedSql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					//为预编译SQL设置参数
					pstmt.setObject(i+1, params[i]);
				}
			}
			num=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn, pstmt, null);
		}


		return num;

	}
	/**
	 * 数据查询的操作
	 * @param preparedSql
	 * @param params
	 * @return
	 */
	
	public ResultSet executeQuery(String preparedSql,Object...params){
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(preparedSql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					//为预编译SQL设置参数
					pstmt.setObject(i+1, params[i]);
				}
			}
			rs=pstmt.executeQuery();
			
			
		} catch (Exception e) {
			
		}finally{
			closeAll(null, null, null);
		}
		
		
		return rs;
		
	}
	
	
	/**
	 * 数据查询的操作
	 * @param preparedSql
	 * @param params
	 * @return
	 */
	
	public ResultSet executeQuery1(String preparedSql,Object...params){
		conn=getConnection2();
		try {
			pstmt=conn.prepareStatement(preparedSql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					//为预编译SQL设置参数
					pstmt.setObject(i+1, params[i]);
				}
			}
			rs=pstmt.executeQuery();
			
			
		} catch (Exception e) {
			
		}finally{
			closeAll(null, null, null);
		}
		
		
		return rs;
		
	}
}

