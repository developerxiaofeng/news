package cn.news.dao.Impl;

import cn.news.dao.BaseDao;
import cn.news.dao.UserDao;
import cn.news.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	/**
	 * 增
	 */
	
	public int addUser(User user) {
		int result=0;
		try {
			String sql="insert into news_users(uname,upwd) values(?,?)";
			result=this.exceuteUpdate(sql, user.getuName(),user.getUpwd());
		} catch (Exception e) {
		}finally{
			this.closeAll(null, null, null);
		}
		
		return result;
	}
	/**
	 * 删
	 */
	public int deleteUser(User user) {
		int result=0;
		try {
			String sql="insert into news_users(uname,upwd) values(?,?)";
			result=this.exceuteUpdate(sql, user.getuName(),user.getUpwd());
		} catch (Exception e) {
		}finally{
			this.closeAll(null, null, null);
		}
		
		return result;
	}

}
