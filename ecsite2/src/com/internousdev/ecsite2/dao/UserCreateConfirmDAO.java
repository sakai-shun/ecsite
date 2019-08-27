package com.internousdev.ecsite2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;

public class UserCreateConfirmDAO {

	public boolean isExistUser(String loginUserId) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();


		String sql="select count(*) as count from login_user_transaction where login_id=?";
		boolean result=false;
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginUserId);

			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				if(rs.getInt("count")>0){
					result=true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
}
