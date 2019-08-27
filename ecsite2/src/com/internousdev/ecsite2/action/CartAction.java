package com.internousdev.ecsite2.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartInfoDAO;
import com.internousdev.ecsite2.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	private List<CartInfoDTO> cartList=new ArrayList<CartInfoDTO>();
	private String message;

	public String execute() throws SQLException{


		CartInfoDAO dao=new CartInfoDAO();
		String result=SUCCESS;
		cartList=dao.getCartInfo((session.get("login_user_id")).toString());

		if(cartList.size()>0){
			session.put("cartList", cartList);


		}else{

			setMessage("商品はありません");
		}
		return result;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public List<CartInfoDTO> getCartList(){
		return cartList;
	}
	public void setCartList(List<CartInfoDTO>cartList){
		this.cartList=cartList;
	}
}
