package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.MyPageDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class MyPageDAO {

	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id) throws SQLException{
		ArrayList<MyPageDTO>myPageDTO=new ArrayList<MyPageDTO>();

		String sql=
				"SELECT ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id=iit.id WHERE ubit.item_transaction_id=? AND ubit.user_master_id=? ORDER BY insert_date DESC";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				MyPageDTO dto=new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				myPageDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return myPageDTO;

	}
	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id) throws SQLException{
		String sql="delete from user_buy_item_transaction where item_transaction_id=? and user_master_id=?";

		int result=0;

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			result=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
	public void buyItemHistoryDeleteAll() throws SQLException{
		String sql="delete from user_buy_item_transaction";



		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

	}

}
