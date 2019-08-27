package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.ItemListDAO;
import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAnotherConfirmAction extends ActionSupport implements SessionAware{

	private String id;
	private Map<String,Object>session;
	public ItemInfoDTO dto=new ItemInfoDTO();

	public String execute() throws SQLException{
		String result=SUCCESS;

		if(session.containsKey("login_user_id")){
			ItemListDAO dao=new ItemListDAO();


			dto=dao.selectItemInfo(id);
			session.put("id", id);
			session.put("buyItem_name", dto.getItemName());
			session.put("buyItem_price", dto.getItemPrice());
			session.put("itemStock", dto.getItemStock());
		}
		return result;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}
