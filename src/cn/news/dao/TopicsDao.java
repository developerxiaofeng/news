package cn.news.dao;

import java.util.List;

import cn.news.entity.Topic;

public interface TopicsDao {
	//获取所有的主题
	public List<Topic> getAllTopics();
	//更新主题
	public int updateTopic(Topic topic);
	//根据名字查找主题
	public Topic findTopicByName(String name);
	//添加主题
	public int addTopic(String name);
	//通过Tid删除主题
	public int deleteTopic(int tid);
	
}
