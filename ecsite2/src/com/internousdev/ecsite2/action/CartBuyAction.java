package com.internousdev.ecsite2.action;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dao.CartInfoDAO;
import com.internousdev.ecsite2.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartBuyAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;

	private int productId;

	public String execute() throws SQLException{
		String result=SUCCESS;
		BuyItemDAO dao=new BuyItemDAO();
		@SuppressWarnings("unchecked")
		List<CartInfoDTO> cartList=(List<CartInfoDTO>)session.get("cartList");
		int count=0;
		for (CartInfoDTO dto:cartList){
			count+=dao.regist(
					dto.getProductId(),
					dto.getTotalPrice(),
					dto.getProductCount(),
					dto.getUserId()
					);
		}
		if(count>0){
			CartInfoDAO cartInfoDAO=new CartInfoDAO();
			cartInfoDAO.deleteAll();

		}
		return result;
	}
	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId=productId;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}
