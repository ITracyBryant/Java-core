package message;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import Dao.No_fly_dao;
import Dao.Nofly;

public class Scan_message {
	public static void main(String[] args) {
		Nofly nofly=new Nofly();
		No_fly_dao no_fly_dao=new No_fly_dao();
		SendMsg sendMsg=new SendMsg();
		int i=0;
		while(true){
			System.out.println(i++);
			nofly.deleteByLow();
			no_fly_dao.deleteByLow();
			List<String> list = nofly.findAll();
			for (String string : list) {
				try {
					sendMsg.send_Msg(string);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
