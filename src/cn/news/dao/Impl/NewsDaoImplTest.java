package cn.news.dao.Impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.news.dao.NewsDao;
import cn.news.entity.News;

public class NewsDaoImplTest {

	

	@Test
	public void test() {
		NewsDao newsDao =new NewsDaoImpl();
		List<News> list=newsDao.getAllnewsByTID1(1);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getTname());
		}
	}

}
