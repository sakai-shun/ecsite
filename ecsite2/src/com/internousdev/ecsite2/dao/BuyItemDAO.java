package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class BuyItemDAO {


	BuyItemDTO dto=new BuyItemDTO();



	public BuyItemDTO getBuyItemInfo(){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="select id,item_name,item_price,item_stock from item_info_transaction";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getInt("item_stock"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dto;
	}

	public List<ItemInfoDTO> getItemList () throws SQLException {
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();
		String sql ="SELECT * FROM item_info_transaction ORDER BY id";
		try {

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));

				itemList.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return itemList;
	}
	public int regist(int productId,int totalPrice,int totalCount,String userId) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		int count=0;

		String sql="insert into user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,insert_date) values(?,?,?,?,now())";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,productId);
			ps.setInt(2, totalPrice);
			ps.setInt(3, totalCount);
			ps.setString(4, userId);

			count=ps.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return count;
	}
}
