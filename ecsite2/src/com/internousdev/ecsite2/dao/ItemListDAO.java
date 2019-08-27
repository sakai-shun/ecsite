package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;
public class ItemListDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection con = dbConnector.getConnection();
	public List<ItemInfoDTO> getItemList() throws SQLException {
		List<ItemInfoDTO> itemInfoDTOList = new ArrayList<ItemInfoDTO>();
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
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));

				itemInfoDTOList.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return itemInfoDTOList;
	}
	public ItemInfoDTO selectItemInfo(String id) throws SQLException{
		ItemInfoDTO dto = new ItemInfoDTO();
		String sql="select * from item_info_transaction where id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return dto;


	}

}

