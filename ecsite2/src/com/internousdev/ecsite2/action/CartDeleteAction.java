package com.internousdev.ecsite2.action;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartInfoDAO;
import com.internousdev.ecsite2.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartDeleteAction extends ActionSupport implements SessionAware{

	private List<CartInfoDTO> cartList;
	private String[] checkList;
	private Map<String,Object> session;

	public String execute() throws SQLException{
		String result=SUCCESS;
		CartInfoDAO dao=new CartInfoDAO();
		int count=0;

		String userId=String.valueOf(session.get("login_user_id"));
		for(String id:checkList){
			count += dao.delete(id);
		}
		if(count==checkList.length){
			cartList=dao.getCartInfo(userId);

		}
		return result;

	}
	public List<CartInfoDTO> getCartList(){
		return cartList;
	}
	public void setCartList(List<CartInfoDTO>cartList){
		this.cartList=cartList;
	}
	public String[] getCheckList(){
		return checkList;
	}
	public void setCheckList(String[] checkList){
		this.checkList=checkList;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}
