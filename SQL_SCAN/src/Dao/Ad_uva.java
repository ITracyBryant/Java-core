package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Ad_uva_list;
import Util.DBUtil;

public class Ad_uva {
	private Connection connection=DBUtil.getConnection();
	public void save(Ad_uva_list list){
		String sqlString="insert into ad_uva_list(User,Euq,Pit,Row,Yaw,Lon,Lat,Alt) values(?,?,?,?,?,?,?,?)";
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement=connection.prepareStatement(sqlString);
			prepareStatement.setString(1, list.getUser());
			prepareStatement.setString(2, list.getEuq());
			prepareStatement.setFloat(3, list.getPit());
			prepareStatement.setFloat(4, list.getRow());
			prepareStatement.setFloat(5, list.getRow());
			prepareStatement.setDouble(6, list.getLon());
			prepareStatement.setDouble(7, list.getLat());
			prepareStatement.setFloat(8,list.getAlt());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (prepareStatement!=null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void update(Ad_uva_list list){
		String sqlString="update ad_uva_list set Pit=?,Row=?,Yaw=?,Lon=?,Lat=?,Alt=? where User=?";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setFloat(1, list.getPit());
			preparedStatement.setFloat(2, list.getRow());
			preparedStatement.setFloat(3, list.getYaw());
			preparedStatement.setDouble(4, list.getLon());
			preparedStatement.setDouble(5, list.getLat());
			preparedStatement.setFloat(6, list.getAlt());
			preparedStatement.setString(7, list.getUser());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
				}
			}
		}
	}
	public boolean findByName(String name){
		String sqlString="select * from ad_uva_list where User=?";
		PreparedStatement preparedStatement=null;
		boolean flag=false;
		try {
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setString(1, name);
			ResultSet re = preparedStatement.executeQuery();
			flag=re.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		Ad_uva ad_uva=new Ad_uva();
		boolean flag=ad_uva.findByName("13262880098");
		System.out.println(flag);
	}
}
