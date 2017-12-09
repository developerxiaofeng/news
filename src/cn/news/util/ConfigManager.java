package cn.news.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



/**
 * 
 * @author 好好想想
 *
 *功能：通过单例模式读取配置文件
 */
public class ConfigManager {
	static ConfigManager configManager=new ConfigManager();//饿汉式
	static Properties properties;
	//初始化构造
	ConfigManager(){
		properties=new Properties();
		try {
			properties.load(ConfigManager.class.getClassLoader().getResourceAsStream("database.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//对外提供访问的方式
	public static ConfigManager getInstrance(){
		return configManager;
	}
	//调用键值对的值
	public static String getValue(String key){
		return properties.getProperty(key); 
	}
}




