package com.lc.shopmarket.DataExchage;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ClassLog4j {
	
	public ClassLog4j()
	{
		
	}

	//利用饥汉单例模式进行优化
	static Logger logger = Logger.getLogger(ClassLog4j.class.getName());


	public static org.apache.log4j.Logger getLogger() {
		PropertyConfigurator.configure("src/log4j.properties");
		return logger;
	}

}
