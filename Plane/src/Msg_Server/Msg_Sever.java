package Msg_Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DBUtil.Change_WGS;
import DBUtil.ConUtil;
import Dao.SqlCon;

//import javax.enterprise.inject.New;

import entity.L_User;
import entity.U_info;

public class Msg_Sever {
	private ServerSocket serverSocket;
	private List<PrintWriter> list;
	File dirFile;
	// File file;
	SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Msg_Sever() {
		try {
			System.out.println("鏈嶅姟鍣ㄥ垵濮嬪寲...");
			serverSocket = new ServerSocket(9999);

			list = new ArrayList<PrintWriter>();
			System.out.println("鏈嶅姟鍣ㄥ垵濮嬪寲瀹屾瘯...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("鏈嶅姟鍣ㄥ垵濮嬪寲澶辫触...");
			e.printStackTrace();
		}
	}

	public void start() {
		while (true) {
			System.out.println("绛夊緟瀹㈡埛绔繛鎺�...");
			try {
				Socket socket = serverSocket.accept();
				Com_Run run = new Com_Run(socket);
				Thread thread = new Thread(run);
				thread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class Com_Run implements Runnable {
		private Socket socket;

		public Com_Run(Socket socket) {
			this.socket = socket;

		}

		public void run() {
			String ip = socket.getInetAddress().getHostAddress();
			int port = socket.getPort();
			Connection connection = null;
			System.out.println(ip + ":" + port + "杩炴帴鎴愬姛...");
			PrintWriter printWriter = null;
			PrintWriter pWriter = null;
			SqlCon sqlCon = new SqlCon();
			String userString = null;
			float lat_new = 0;
			float lon_new = 0;
			FileWriter fileWriter = null;

			try {
				// pWriter=new PrintWriter(file);
				InputStream in = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				InputStreamReader reader = new InputStreamReader(in, "UTF-8");
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
				BufferedReader bufferedReader = new BufferedReader(reader);
				printWriter = new PrintWriter(outputStreamWriter, true);
				String msg;
				list.add(printWriter);
				connection = ConUtil.getConnection();
				// connection.prepareStatement("insert into l_user() values()");
				String user = null;
				Change_WGS change_WGS = new Change_WGS();

				Date date = new Date();
				String time = format.format(date);
				String time2 = format2.format(date);
				boolean flag = false;
				while ((msg = bufferedReader.readLine()) != null) {
					System.out.println(ip + ":" + port + msg);

					if (user != null) {
						user = msg.split(";")[0].split(":")[1];
					}
					if (msg.indexOf("NaN") == -1 && msg.indexOf("null") == -1) {
						String[] note = msg.split(";");
						userString = note[0].split(":")[1];

						float pit = Float.parseFloat(note[1].split(":")[1]);
						float rol = Float.parseFloat(note[2].split(":")[1]);
						float yaw = Float.parseFloat(note[3].split(":")[1]);
						float lon = Float.parseFloat(note[4].split(":")[1]);
						float lat = Float.parseFloat(note[5].split(":")[1]);
						float alt = Float.parseFloat(note[6].split(":")[1]);
						float[] l = change_WGS.wgs2bd(lat, lon);
						lat_new = l[0];
						lon_new = l[1];
						dirFile = new File("E:/" + userString);
						if (!dirFile.exists()) {
							dirFile.mkdir();
						}
						fileWriter = new FileWriter("E:/" + userString + "/" + time + ".txt", true);
						fileWriter.write(msg + "\n");
						fileWriter.flush();
						// pWriter.append(msg+"\n");
						// pWriter.flush();
						L_User l_User = new L_User(userString, rol, yaw, lon_new, lat_new, alt, pit);
						sqlCon.update_l_user(l_User);
						if (!flag) {
							U_info u_info = new U_info();
							u_info.setUser(userString);
							u_info.setStartime(time2);
							u_info.setStart_lat(lat_new);
							u_info.setStart_lon(lon_new);
							sqlCon.add_user_info(u_info);
							flag = true;
						}
					} else {
						continue;
					}
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String endtime = format.format(new Date());
				PreparedStatement prepareStatement = connection
						.prepareStatement("UPDATE u" + userString + " set endtime=? WHERE 1 ORDER BY id DESC LIMIT 1");
				prepareStatement.setString(1, endtime);
				prepareStatement.executeUpdate();

				System.out.println("璀﹀憡:" + ip + ":" + port + "鐢ㄦ埛宸蹭笅绾�...");
			} catch (Exception e) {
				System.out.println("璀﹀憡:" + ip + ":" + port + "鐢ㄦ埛宸蹭笅绾�...");
			} finally {
				try {
					String time3 = format2.format(new Date());
					U_info u_info = new U_info();
					u_info.setEndtime(time3);
					u_info.setEnd_lat(lat_new);
					u_info.setEnd_lon(lon_new);
					u_info.setUser(userString);
					// sqlCon.update_user_info(u_info);
					list.remove(printWriter);
					System.out.println("璀﹀憡:" + ip + ":" + port + "鐢ㄦ埛宸蹭笅绾�...");
					if (pWriter != null) {
						pWriter.close();
					}
					if (printWriter != null) {
						printWriter.close();
					}
					if (fileWriter != null) {
						fileWriter.close();
					}
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Msg_Sever msg_Sever = new Msg_Sever();
		msg_Sever.start();
	}
}
