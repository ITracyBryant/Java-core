package Msg_Server;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sun.mail.handlers.image_gif;
public class Msg_Client {
	private Socket socket;
	public Msg_Client() {
		System.out.println("客户端初始化...");
		try {
			socket=new Socket("10.10.5.97", 9999);
			System.out.println("客户端初始化完毕...");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void send_Msg(String msg){
		
		OutputStreamWriter writer;
		PrintWriter printWriter=null;
		try {
			OutputStream out = socket.getOutputStream();
			writer = new OutputStreamWriter(out, "UTF-8");
			printWriter=new PrintWriter(writer,true);
			printWriter.println(msg);
			printWriter.flush();
			System.out.println("数据发送完毕");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		Msg_Client client=new Msg_Client();
		for (int i=0;i<100;i++){
			
			client.send_Msg("User:18616020429;Pit:-3.3;Rol:-0.1;Yaw:-163.5;Lon:121.90468618029664;Lat:30.87635448709497;Alt:32.2"+"\n");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
