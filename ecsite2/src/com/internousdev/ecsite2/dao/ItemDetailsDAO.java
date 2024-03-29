package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class ItemDetailsDAO {



	public ItemInfoDTO getItemInfo(String id) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		ItemInfoDTO dto=new ItemInfoDTO();

		String sql="select * from item_info_transaction where id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));

			}
		}catch(Exception e){
			e.printStackTrace();

		}finally{
			con.close();
		}
		return dto;
	}
}
