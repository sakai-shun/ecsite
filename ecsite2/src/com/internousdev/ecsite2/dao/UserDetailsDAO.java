package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.dto.UserInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class UserDetailsDAO {

	public UserInfoDTO select(String loginId) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		UserInfoDTO dto=new UserInfoDTO();

		String sql="select * from login_user_transaction where login_id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginId);

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				dto.setId(rs.getString("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("updated_date"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dto;
	}
}
