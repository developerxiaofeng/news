package cn.news.dao.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cn.news.dao.BaseDao;
import cn.news.dao.TopicsDao;
import cn.news.entity.Topic;

public class TopicsDaoImpl extends BaseDao implements TopicsDao{
	//获取所有主题信息
	public List<Topic> getAllTopics() {
		List<Topic> list =new ArrayList<Topic>();
		String sql ="select tid,tName from topic";
		ResultSet rs =null;
		try {
			rs =this.executeQuery(sql);
			while(rs.next()){
				Topic topic =new Topic();
				topic.setTid(rs.getInt(1));
				topic.settName(rs.getString(2));
				list.add(topic);
			}
			
		} catch (Exception e) {

			
		}finally{
			closeAll(this.conn, this.pstmt, this.rs);
		}
		
		
		return list;
	}
	//更新主题
	public int updateTopic(Topic topic) {
		String sql ="Update `topic` set `tname` =? where `tid`=?";
		int result=0;
		try {
			result=exceuteUpdate(sql, topic.gettName(),topic.getTid());
		} catch (Exception e) {

			closeAll(null, null, null);
		}
		
		return result;
	}
	//根据名字查找主题
	public Topic findTopicByName(String name) {
		String sql ="select tid,`tName` from topic where tName=?";
		ResultSet rs=null;
		Topic topic=null;
		try {
			rs=executeQuery(sql, name);
			if(rs.next()){
			topic=new Topic();
			topic.setTid(rs.getInt(1));
			topic.settName(rs.getString(2));
			}
			
			
		} catch (Exception e) {

			closeAll(conn, pstmt, rs);
		}
		
		return topic;
	}
	//添加主题
	public int addTopic(String name) {
		String sql ="insert into topic (tName) values (?)";
		int result=0;
		try {
			result=exceuteUpdate(sql,name);
		} catch (Exception e) {

			closeAll(conn, pstmt, rs);
		}
		
		return result;
	}
	//通过Tid删除主题
	public int deleteTopic(int tid) {
		String sql="delete from topic where tid=?";
		int result=0;
		try {
			result=exceuteUpdate(sql, tid);
		} catch (Exception e) {
			closeAll(null, null, null);
		}
		
		return result;
	}

}
