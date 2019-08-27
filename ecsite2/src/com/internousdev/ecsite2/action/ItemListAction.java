package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.ItemListDAO;
import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	private List<ItemInfoDTO>List=new ArrayList<ItemInfoDTO>();

	public String execute() throws SQLException{
		ItemListDAO dao=new ItemListDAO();
		List=dao.getItemList(
				);

		if(!(List.size()>0)){
			List=null;
		}
		String result=SUCCESS;
		return result;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public List<ItemInfoDTO> getList(){
		return List;
	}
	public void setList(List<ItemInfoDTO>List){
		this.List=List;
	}

}
