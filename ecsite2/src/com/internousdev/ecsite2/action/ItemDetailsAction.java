package com.internousdev.ecsite2.action;

import java.sql.SQLException;

import com.internousdev.ecsite2.dao.ItemDetailsDAO;
import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailsAction extends ActionSupport {


	private String id;
	private ItemInfoDTO dto;


	public String execute() throws SQLException{
		ItemDetailsDAO dao=new ItemDetailsDAO();
		dto=dao.getItemInfo(id);
		if(dto.getItemName()==null){
			dto=null;
		}


		return SUCCESS;
	}

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	public ItemInfoDTO getDto(){
		return dto;
	}
	public void setDto(ItemInfoDTO dto){
		this.dto=dto;
	}
}
