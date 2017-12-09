package cn.news.dao.Impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.news.dao.TopicsDao;
import cn.news.entity.Topic;

public class TopicsDaoImplTest {

	

	@Test
	public void testGetAllTopics() {
		List<Topic> list =new ArrayList<Topic>();
		TopicsDaoImpl td =new TopicsDaoImpl();
		list=td.getAllTopics();
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getTid()+list.get(i).gettName());
		}
		
	}

	
}
