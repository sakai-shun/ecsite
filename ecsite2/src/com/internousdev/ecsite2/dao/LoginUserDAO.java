package com.internousdev.ecsite2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.LoginDTO;
import com.internousdev.ecsite2.util.DBConnector;


public class LoginUserDAO {

	public void UpdatePassword(String loginId,String password,String newPassword) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();


		String sql="update login_user_transaction set login_pass=?  where login_id=? and login_pass=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, loginId);
			ps.setString(3, password);
			ps.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

	}
	public List<LoginDTO> selectUserInfo() throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<LoginDTO> loginDTOList=new ArrayList<LoginDTO>();
		LoginDTO loginDTO=null;
		String sql="select * from login_user_transaction";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				loginDTO=new LoginDTO();
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTOList.add(loginDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return loginDTOList;
	}
}
