package com.internousdev.ecsite2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;

public class UserDeleteCompleteDAO {

	public int delete(String loginId) throws SQLException{
		DBConnector db =new DBConnector();
		Connection con=db.getConnection();

		String sql="delete from login_user_transaction where login_id=?";
		int result=0;
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginId);

			result=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
}
