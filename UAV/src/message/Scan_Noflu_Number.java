package message;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sk.dao.Nofly_number_dao;

import entity.Nofly_number;

public class Scan_Noflu_Number {
	
	private ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	private Nofly_number_dao nofly_number = context.getBean("nofly_number_dao",Nofly_number_dao.class);
	public void bofly_number(){
		Date date=new Date();
		long intime = date.getTime()-60000;
		nofly_number.deleteByLowTime(intime);
		List<Nofly_number> number = nofly_number.findAll();
		SendMsg msg=new SendMsg();
		for (Nofly_number nofly_number : number) {
			try {
				msg.send_Msg(nofly_number.getNumber());
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
