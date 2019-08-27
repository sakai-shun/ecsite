package com.internousdev.ecsite2.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.CartInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;
public class CartInfoDAO {

	public List<CartInfoDTO> getCartInfo(String userId) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<CartInfoDTO>cartList=new ArrayList<CartInfoDTO>();

		String sql="SELECT ci.id,ci.product_id,iit.item_name,iit.item_price,ci.product_count,ci.regist_date,(iit.item_price*ci.product_count) AS total_price,ci.user_id FROM cart_info AS ci LEFT JOIN item_info_transaction AS iit ON iit.id=ci.product_id WHERE ci.user_id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				CartInfoDTO dto=new CartInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setId(rs.getInt("product_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setRegistDate(rs.getString("regist_date"));
				dto.setTotalPrice(rs.getInt("total_price"));
				dto.setUserId(rs.getString("user_id"));
				cartList.add(dto);

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return cartList;
	}
	public void setCartInfo(String userId,int productId,int count) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil util=new DateUtil();

		String sql="insert into cart_info(user_id,product_id,product_count,regist_date,update_date) values(?,?,?,?,now())";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, productId);
			ps.setInt(3, count);
			ps.setString(4, util.getDate());

			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}


	}
	public void deleteAll() throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();


		String sql="delete from cart_info";

		try{
			PreparedStatement ps=con.prepareStatement(sql);


			ps.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

	}
	public int delete(String id) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		int result=0;
		String sql="delete from cart_info where id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			result=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
}
