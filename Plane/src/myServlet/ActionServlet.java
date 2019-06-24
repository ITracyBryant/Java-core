package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import javax.enterprise.inject.New;
//import javax.persistence.Id;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtil.ConUtil;
import Dao.SqlCon;
import entity.Admin;
import entity.No_Fly;
import entity.User;

public class ActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));

		if ("/tologin".equals(action)) {
			SqlCon sqlCon = new SqlCon();
			String username = request.getParameter("username");
			String pwd = request.getParameter("password");
			String remember = request.getParameter("remember");
			System.out.println(username + ":" + pwd + ":" + remember);
			User user = sqlCon.findByName(username);
			if (user != null && user.getPassword().equals(pwd)) {
				request.getSession().setAttribute("use", username);
				if (remember != null) {
					Cookie cookie = new Cookie("username", username);
					Cookie cookie1 = new Cookie("password", pwd);
					response.addCookie(cookie);
					response.addCookie(cookie1);
				}

				request.setAttribute("user_name", username);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("login.do");
			}
		} else if ("/login".equals(action)) {
			Cookie[] cookies = request.getCookies();
			Map<String, String> map = new HashMap<String, String>();
			System.out.println(cookies);
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					map.put(cookie.getName(), cookie.getValue());
				}
				request.setAttribute("user_name", map.get("username"));
				request.setAttribute("user_pwd", map.get("password"));
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("login.jsp");
			}

		} else if ("/toregister".equals(action)) {
			String username = request.getParameter("register_username");
			String password = request.getParameter("register_password");
			String s_num = request.getParameter("device_code");
			SqlCon sqlCon = new SqlCon();
			User user = new User();
			user.setPassword(password);
			user.setS_num(s_num);
			user.setUsername(username);
			sqlCon.add(user);
			Connection connection = null;
			try {
				connection = ConUtil.getConnection();
				PreparedStatement prepareStatement = connection
						.prepareStatement("select table_name  from information_schema.tables  where table_schema='sk'");
				ResultSet re = prepareStatement.executeQuery();
				boolean flag = true;
				while (re.next()) {
					if (re.getString("table_name").equals("u" + username)) {
						flag = true;
						break;
					} else {
						flag = false;
					}
				}
				if (!flag) {
					sqlCon.Create_User_info(username);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConUtil.closeConnection(connection);
			}
			response.sendRedirect("login.do");
		} else if ("/toadmin".equals(action)) {
			String username = request.getParameter("adminname");
			String password = request.getParameter("adminpassword");
			SqlCon sqlCon = new SqlCon();
			Admin admin = sqlCon.admin(username);
			if (admin != null) {
				request.setAttribute("admin", username);
				RequestDispatcher rd = request.getRequestDispatcher("adminindex.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("admin.jsp");
			}

		} else if ("/findAll_list".equals(action)) {
			Connection connecition = null;
			try {
				connecition = ConUtil.getConnection();
				PreparedStatement prepareStatement = connecition.prepareStatement("select * from l_user");
				ResultSet re = prepareStatement.executeQuery();
				String re_list = "";
				while (re.next()) {
					int id = re.getInt("id");
					String user = re.getString("user");
					String euq = re.getString("euq");
					float row = re.getFloat("row");
					float yaw = re.getFloat("yaw");
					float lon = re.getFloat("lon");
					float lat = re.getFloat("lat");
					float alt = re.getFloat("alt");
					float pit = re.getFloat("pit");
					if (user != null) {
						re_list += "User:" + user + ";Pit:" + pit + ";Row:" + row + ";Yaw:" + yaw + ";Lon:" + lon
								+ ";Lat:" + lat + ";Alt:" + alt + "\n";
					} else {
						re_list += "Euq:" + euq + ";Lon:" + lon + ";Lat:" + lat + ";Alt:" + alt + "\n";
					}
				}
				out.println(re_list);
				out.flush();
			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			} finally {
				ConUtil.closeConnection(connecition);
			}

		} else if ("/findByName".equals(action)) {
			Connection connecition = null;
			try {
				connecition = ConUtil.getConnection();
				String name = request.getParameter("user_name");
				// System.out.println("User_name="+name);
				PreparedStatement prepareStatement = connecition.prepareStatement("select * from l_user where user=?");
				prepareStatement.setString(1, name);
				ResultSet re = prepareStatement.executeQuery();
				String re_list = "";
				if (re.next()) {
					int id = re.getInt("id");
					String user = re.getString("user");
					String euq = re.getString("euq");
					float row = re.getFloat("row");
					float yaw = re.getFloat("yaw");
					float lon = re.getFloat("lon");
					float lat = re.getFloat("lat");
					float alt = re.getFloat("alt");
					float pit = re.getFloat("pit");
					if (user != null) {
						re_list += "User:" + user + ";Pit:" + pit + ";Row:" + row + ";Yaw:" + yaw + ";Lon:" + lon
								+ ";Lat:" + lat + ";Alt:" + alt + "\n";
					} else {
						re_list += "Euq:" + euq + ";Lon:" + lon + ";Lat:" + lat + ";Alt:" + alt + "\n";
					}
				}
				out.println(re_list);
				out.flush();
			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			} finally {
				ConUtil.closeConnection(connecition);
			}
		} else if ("/add_no_fly".equals(action)) {
			String no_fly = request.getParameter("no_fly");
			String[] fly_info = no_fly.split(";");
			int pointnum = Integer.parseInt(fly_info[0]);
			String type = fly_info[1];
			String info = fly_info[2];
			String time = fly_info[3];
			No_Fly fly = new No_Fly(pointnum, type, info, time);
			SqlCon sqlCon = new SqlCon();
			sqlCon.add_no_fly(fly);
		} else if ("/get_no_fly".equals(action)) {
			SqlCon sqlCon = new SqlCon();
			List<No_Fly> list = sqlCon.find_No_Fly();
			String no_fly = null;
			String no_time = null;
			// Type:polygon;PointNum:15;Lon:123.1234650000;Lat:54.13465;Lon:123.1234650000;Lat:54.13465;…\n
			for (No_Fly no_Fly : list) {
				String type = no_Fly.getType();
				int pointNum = no_Fly.getPointnum();
				String[] lons_lats = no_Fly.getInfo().split(";");

				int num_count = lons_lats.length / 2;
				float[] lons = new float[num_count];
				float[] lats = new float[num_count];
				for (int i = 0; i < num_count; i++) {
					lons[i] = Float.parseFloat(lons_lats[i]);
				}
				for (int i = num_count; i < lons_lats.length; i++) {
					lats[i - num_count] = Float.parseFloat(lons_lats[i]);
				}
				String time = no_Fly.getTime();
				String start_time = time.split(";")[0];
				String end_time = time.split(";")[1];
				no_time += start_time + ";" + end_time + "\n";
				no_fly += "Type:" + type + ";" + "PointNum:" + pointNum + ";";
				for (int i = 0; i < lats.length; i++) {
					no_fly += "Lon:" + lons[i] + ";" + "Lat:" + lats[i] + ";";
				}
				no_fly += "\n";
			}
			String msg = no_fly + "|" + no_time;
			out.print(msg);
			out.flush();
		}

	}

}
