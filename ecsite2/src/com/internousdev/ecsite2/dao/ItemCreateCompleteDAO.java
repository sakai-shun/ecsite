package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class ItemCreateCompleteDAO {


		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil util=new DateUtil();

		String sql="insert into item_info_transaction (item_name,item_price,item_stock,insert_date) values(?,?,?,?)";

		public void createItem(String itemName,String itemPrice,String itemStock) throws SQLException{
			try{
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, itemName);
				ps.setString(2, itemPrice);
				ps.setString(3, itemStock);
				ps.setString(4, util.getDate());

				ps.execute();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				con.close();
			}

		}

}
