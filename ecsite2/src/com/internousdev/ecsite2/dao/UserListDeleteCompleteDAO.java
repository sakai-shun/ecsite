package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;


public class UserListDeleteCompleteDAO {

	public int delete() throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="delete from login_user_transaction where admin_flg !='a' or admin_flg is  null";
		int result=0;
		try{
			PreparedStatement ps=con.prepareStatement(sql);

			result=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
}
