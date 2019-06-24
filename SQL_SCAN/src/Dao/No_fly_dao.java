package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import Util.DBUtil;

public class No_fly_dao {
	private Connection connection=DBUtil.getConnection();
	public void deleteByLow(){
		Date date=new Date();
		Long ontime=date.getTime()-60000;
		String sqlString="delete from no_fly where endtime<?";
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
