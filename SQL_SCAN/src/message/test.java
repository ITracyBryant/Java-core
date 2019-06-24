package message;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import Dao.Nofly;

public class test {

	public static void main(String[] args) {
		SendMsg msg=new SendMsg();
		try {
			msg.send_Msg("18616020429");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
