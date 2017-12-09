package cn.news.dao;

import java.util.List;

import cn.news.entity.News;



public interface NewsDao {
	
	public int getNewsCountByTID(int tid);
	
	/**
	 * 返回某一主题下的所有新闻
	 * @param tid
	 * @return
	 */
	public List<News> getAllnewsByTID(int tid);
	public List<News> getAllnewsByTID1(int tid);
	/**
	 * 获取所有新闻
	 * @return
	 */
	public List<News> getAllnews();
	public List<News> getLatestNewsByTid(int tid,int limit);
}
