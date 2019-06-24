package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Nofly_number;
import Util.DBUtil;

public class Nofly {
	private Connection connection=DBUtil.getConnection();
	public List<String> findAll(){
		String sqlString="select * from nofly_number";
		PreparedStatement preparedStatement=null;
		List<String> list=new ArrayList<String>();
		try {
			preparedStatement=connection.prepareStatement(sqlString);
			ResultSet re = preparedStatement.executeQuery();
			
			while(re.next()){
				String number=re.getString("number");
				list.add(number);
			}
			
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
		return list;
	}
	public void deleteByLow(){
		Date date=new Date();
		long ontime=date.getTime()-60000;
		System.out.println(ontime);
		String sqlString="delete from nofly_number where intime < ?";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setLong(1, ontime);
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
}
