package websocket;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import DBUtil.ConUtil;

@ServerEndpoint("/websocket")
public class WebServer {
	private Session session;
	@OnOpen
	public void open(Session session){
		System.out.println(session.getId()+"已连接");
		this.session=session;
	}
	@OnMessage
	public void message(Session session,Integer num_number) throws IOException, Exception{
		Connection connection = ConUtil.getConnection();
		if(num_number!=0){
			PreparedStatement prepareStatement = connection.prepareStatement("select * from l_user where id=?");
			prepareStatement.setInt(1, num_number);
			ResultSet re = prepareStatement.executeQuery();
			if (re.next()) {
				String user = re.getString("user");
				String euq = re.getString("euq");
				float row = re.getFloat("row");
				float yaw = re.getFloat("yaw");
				float lon = re.getFloat("lon");
				float lat = re.getFloat("lat");
				float alt = re.getFloat("alt");
				float pit = re.getFloat("pit");
				String msg=user+"\n"+euq+"\n"+row+"\n"+yaw+"\n"+lon+"\n"+lat+"\n"+alt+"\n"+pit;
				session.getBasicRemote().sendText(msg);
			}
			prepareStatement.close();
		}else {
			PreparedStatement prepareStatement = connection.prepareStatement("select * from l_user");
			prepareStatement.setInt(1, num_number);
			ResultSet re = prepareStatement.executeQuery();
			String msg="";
			while(re.next()) {
				String user = re.getString("user");
				String euq = re.getString("euq");
				float row = re.getFloat("row");
				float yaw = re.getFloat("yaw");
				float lon = re.getFloat("lon");
				float lat = re.getFloat("lat");
				float alt = re.getFloat("alt");
				float pit = re.getFloat("pit");
				msg+=user+"\n"+euq+"\n"+row+"\n"+yaw+"\n"+lon+"\n"+lat+"\n"+alt+"\n"+pit;
				
			}
			session.getBasicRemote().sendText(msg);
			prepareStatement.close();
		}
		
	}
	@OnClose
	public void close(Session session){
		try {
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
