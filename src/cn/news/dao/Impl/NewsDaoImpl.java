package cn.news.dao.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.sun.org.apache.regexp.internal.recompile;

import cn.news.dao.BaseDao;
import cn.news.dao.NewsDao;
import cn.news.entity.News;


public class NewsDaoImpl extends BaseDao implements NewsDao{
	/**
	 * 获取所有新闻
	 * @return
	 */
	public List<News> getAllnews(){
		List<News> list =new ArrayList<News>();
		ResultSet rs =null;
		String sql="select nid,ntid,ntitle,nauthor,"+
		"ncreateDate,nsummary,tname from news,topic"+
				" where news.ntid=topic.tid"+
		" order by ncreateDate desc";
		try {
			rs=this.executeQuery(sql);
			News news =null;
			while(rs.next()){
				news=new News();
				news.setNid(rs.getInt("nid"));
				news.setNtid(rs.getInt("ntid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreateDate(rs.getDate("ncreateDate"));
				news.setNsummary(rs.getString("nsummary"));
				news.setTname(rs.getString("tname"));
				list.add(news);
			}
			System.out.println(list.size());
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			closeAll(conn, null, rs);
		}
		return list;
	}
	/**
	 * 返回某一主题下的所有新闻
	 * @param tid
	 * @return
	 */
	public List<News> getAllnewsByTID(int tid){
		List<News> list =new ArrayList<News>();
		ResultSet rs =null;
		String sql="select nid,ntid,ntitle,nauthor,"+
		"ncreateDate,nsummary,tname from news,topic"+
		" where news.ntid=topic.tid"+
		" and news.ntid=?"+
		" order by ncreateDate desc";
		
		try {
			rs=this.executeQuery(sql,tid);
			News news =null;
			while(rs.next()){
				news=new News();
				news.setNid(rs.getInt("nid"));
				news.setNtid(rs.getInt("ntid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreateDate(rs.getDate("ncreateDate"));
				news.setNsummary(rs.getString("nsummary"));
				news.setTname(rs.getString("tname"));
				list.add(news);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			closeAll(conn, null, rs);
		}
		return list;
	}
	
	/**
	 * 返回某一主题下的所有新闻
	 * @param tid
	 * @return
	 */
	public List<News> getAllnewsByTID1(int tid){
		List<News> list =new ArrayList<News>();
		ResultSet rs =null;
		String sql="select nid,ntid,ntitle,nauthor,"+
		"ncreateDate,nsummary,tname from news,topic"+
		" where news.ntid=topic.tid"+
		" and news.ntid=?"+
		" order by ncreateDate desc";
		
		try {
			rs=this.executeQuery1(sql,tid);
			News news =null;
			while(rs.next()){
				news=new News();
				news.setNid(rs.getInt("nid"));
				news.setNtid(rs.getInt("ntid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNcreateDate(rs.getDate("ncreateDate"));
				news.setNsummary(rs.getString("nsummary"));
				news.setTname(rs.getString("tname"));
				list.add(news);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			closeAll(conn, null, rs);
		}
		return list;
	}
	
	/**
	 * 返回某一主题新闻数量
	 */
	public int getNewsCountByTID(int tid)
	{
		String sql="select count(ntid) from news where ntid=?";
		int count=-1;
		try {
			rs=this.executeQuery(sql, tid);
			rs.next();
			count=rs.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			closeAll(conn, pstmt, rs);
			
		}
		
		return count;
		
	}
	/***
	 * 返回某一主题最新的新闻
	 * @param tid
	 * @param limit
	 * @return
	 */
	public List<News> getLatestNewsByTid(int tid,int limit){
		List<News> list =new ArrayList<News>();
		ResultSet rs =null;
		String sql ="select nid,ntid,ntitle from news"+
				" where ntid=? order by ncreateDate desc limit ?";
		
		try {
			rs=this.executeQuery(sql,tid,limit);
			News news =null;
			while (rs.next()) {
				news =new News();
				news.setNid(rs.getInt("nid"));
				news.setNid(rs.getInt("ntid"));
				news.setNtitle(rs.getString("ntitle"));
				list.add(news);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			closeAll(conn, pstmt, rs);
		}
		
		return list;
		
	}
	
}
