package cn.news.dao.Impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.news.dao.TopicsDao;
import cn.news.dao.UserDao;
import cn.news.entity.Topic;
import cn.news.entity.User;

public class UserDaoImplTest {

	

//	@Test
//	public void testAddUser() {
//		UserDao userDao =new UserDaoImpl();
//		User user =new User();
//		user.setuName("自由");
//		user.setUpwd("12345");
//		int result=userDao.addUser(user);
//		Assert.assertTrue(result==1);
//	}

	@Test
	public void testfindTopicByName() {
		String str ="国";
		TopicsDao topicsDao =new TopicsDaoImpl();
		Topic topic=topicsDao.findTopicByName(str);
		if(topic==null){
			System.out.println("空");
		}
	}

}
