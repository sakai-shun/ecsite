package com.internousdev.ecsite2.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dao.ItemListDAO;
import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAnotherAction extends ActionSupport{

	private List<ItemInfoDTO>itemList =new ArrayList<ItemInfoDTO>();
	private String message;

	public String execute() throws SQLException{
		ItemListDAO dao=new ItemListDAO();
		itemList=dao.getItemList();
		String result= SUCCESS;

		if(!(itemList.size()>0)){
			setMessage("商品情報がありません");
			itemList=null;
			result=ERROR;
		}
		return result;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}
	public List<ItemInfoDTO> getItemList(){
		return itemList;
	}
	public void setItemList(List<ItemInfoDTO>itemList){
		this.itemList=itemList;
	}
}
