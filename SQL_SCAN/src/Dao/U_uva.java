package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Test_uva_info;
import Util.DBUtil;

public class U_uva {
	private Connection connection=DBUtil.getConnection();
	public void save(Test_uva_info uva_info){
		String sqlString="insert into u"+uva_info.getUsername()+"(username,startime,startLon,startLat) values(?,?,?,?)";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setString(1, uva_info.getUsername());
			preparedStatement.setString(2, uva_info.getStartime());
			preparedStatement.setDouble(3, uva_info.getStartLon());
			preparedStatement.setDouble(4, uva_info.getStartLat());
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
					e.printStackTrace();
				}
			}
		}
	}
	public void update(Test_uva_info info){
		String sqlString="update u"+info.getUsername()+" set endtime=?,endLon=?,endLat=? WHERE 1 ORDER BY id DESC LIMIT 1";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setString(1, info.getEndtime());
			preparedStatement.setDouble(2, info.getEndLon());
			preparedStatement.setDouble(3, info.getEndLat());
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
	public static void main(String[] args) {
		U_uva u_uva=new U_uva();
		Test_uva_info info=new Test_uva_info();
		info.setUsername("13262880098");
		info.setEndtime("222222");
		info.setEndLon(55.25325);
		info.setEndLat(3.55646);
		u_uva.update(info);
	}
}
