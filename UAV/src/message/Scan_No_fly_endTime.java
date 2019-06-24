package message;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sk.dao.No_fly_dao;

import entity.No_fly;

public class Scan_No_fly_endTime {
	
	private ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	private No_fly_dao nofly = context.getBean("no_fly_dao",No_fly_dao.class);
	public void fly_endtime(){
		Date date=new Date();
		long intime = date.getTime();
		nofly.deleteByLowTime(intime);
	}
}
