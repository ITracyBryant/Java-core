package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBUtil.ConUtil;
import entity.Admin;
import entity.L_User;
import entity.No_Fly;
import entity.U_info;
import entity.User;

public  class SqlCon {
	public  void add(User user){
		Connection connection = null;
		try {
			connection = ConUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO user(username,password,s_num) values(?,?,?)");
			prepareStatement.setString(1, user.getUsername());
			prepareStatement.setString(2, user.getPassword());
			prepareStatement.setString(3, user.getS_num());
			prepareStatement.execute();
		} catch (Exception e) {
			System.out.println("数据库连接异常");
			e.printStackTrace();
		}finally{
			ConUtil.closeConnection(connection);
		}
	}
	public User findByName(String name){
		User user=null;
		Connection connection=null;
		try {
			connection = ConUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("select * from user where username=?");
			prepareStatement.setString(1, name);
			ResultSet res = prepareStatement.executeQuery();
			if (res.next()) {
				String username = res.getString("username");
				String password = res.getString("password");
				String s_num = res.getString("s_num");
				user=new User();
				user.setPassword(password);
				user.setS_num(s_num);
				user.setUsername(username);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("数据库查询出错"+e);
		}finally{
			ConUtil.closeConnection(connection);
			
		}
		return user;
		
	}
	public Admin admin(String name){
		Connection connection=null;
		Admin admin=null;
		try {
			connection = ConUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("select * from admin where username=?");
			prepareStatement.setString(1, name);
			ResultSet res = prepareStatement.executeQuery();
			if(res.next()){
				admin=new Admin();
				admin.setPassword(res.getString("password"));
				admin.setUsername(res.getString("username"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConUtil.closeConnection(connection);
		}
		return admin;
	}
	public void Create_User_info(String username){
		Connection connection=null;
		try {
			connection=ConUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("create table u"+username+" (id int primary key not null auto_increment,user varchar(40),startime varchar(40),endtime varchar(40)),start_lon float,start_lat float,end_lon float,end_lat float");
			prepareStatement.execute();
			prepareStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConUtil.closeConnection(connection);
		}
	}
	public void add_user_info(U_info info){
		Connection connection=null;
		try {
			connection=ConUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("insert into u"+info.getUser()+"(user,startime,start_lon,start_lat) values(?,?,?,?)");
			prepareStatement.setString(1, info.getUser());
			prepareStatement.setString(2, info.getStartime());
			prepareStatement.setFloat(3, info.getStart_lon());
			prepareStatement.setFloat(4, info.getStart_lat());
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConUtil.closeConnection(connection);
		}
	}
	public void update_user_info(U_info info){
		Connection connection=null;
		try {
			connection=ConUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("update u"+info.getUser()+" set endtime=?,end_lon=?,end_lat=? where user=?");
			prepareStatement.setString(1, info.getEndtime());
			prepareStatement.setString(4, info.getUser());
			prepareStatement.setFloat(2, info.getEnd_lon());
			prepareStatement.setFloat(3, info.getEnd_lat());
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConUtil.closeConnection(connection);
		}
	}
	public void update_l_user(L_User l_User){
		Connection connection=null;
		try {
			connection=ConUtil.getConnection();
			PreparedStatement pre = connection.prepareStatement("select * from l_user where user=?");
			pre.setString(1, l_User.getUser());
			ResultSet re = pre.executeQuery();
			if(re.next()){
				pre.close();
				PreparedStatement prepareStatement = connection.prepareStatement("update l_user set row=?,yaw=?,lon=?,lat=?,alt=?,pit=? where user=?");
				prepareStatement.setFloat(1, l_User.getRow());
				prepareStatement.setFloat(2, l_User.getYaw());
				prepareStatement.setFloat(3, l_User.getLon());
				prepareStatement.setFloat(4, l_User.getLat());
				prepareStatement.setFloat(5, l_User.getAlt());
				prepareStatement.setFloat(6, l_User.getPit());
				prepareStatement.setString(7, l_User.getUser());
				prepareStatement.executeUpdate();
				prepareStatement.close();
			}else {
				PreparedStatement ps = connection.prepareStatement("insert into l_user(user,euq,row,yaw,lon,lat,alt,pit) values(?,?,?,?,?,?,?,?)");
				ps.setString(1, l_User.getUser());
				ps.setString(2, l_User.getEuq());
				ps.setFloat(3, l_User.getRow());
				ps.setFloat(4, l_User.getYaw());
				ps.setFloat(5, l_User.getLon());
				ps.setFloat(6, l_User.getLat());
				ps.setFloat(7, l_User.getAlt());
				ps.setFloat(8, l_User.getPit());
				ps.executeUpdate();
				ps.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConUtil.closeConnection(connection);
		}
	}
	public void add_no_fly(No_Fly no_Fly){
		Connection connection=null;
		try {
			connection=ConUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("insert into wl(pointnum,type,info,time) values(?,?,?,?)");
			prepareStatement.setInt(1, no_Fly.getPointnum());
			prepareStatement.setString(2, no_Fly.getType());
			prepareStatement.setString(3, no_Fly.getInfo());
			prepareStatement.setString(4, no_Fly.getTime());
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public List<No_Fly> find_No_Fly(){
		List<No_Fly> list=new ArrayList<No_Fly>();
		Connection connection=null;
		try {
			connection=ConUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("select * from wl");
			ResultSet re = prepareStatement.executeQuery();
			while (re.next()) {
				No_Fly no_Fly=new No_Fly();
				no_Fly.setPointnum(re.getInt("pointnum"));
				no_Fly.setInfo(re.getString("info"));
				no_Fly.setTime(re.getString("time"));
				no_Fly.setType(re.getString("type"));
				list.add(no_Fly);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		SqlCon sqlCon=new SqlCon();
		User suer = sqlCon.findByName("sk");
		System.out.println(suer.getPassword());
	}
	
	
}
