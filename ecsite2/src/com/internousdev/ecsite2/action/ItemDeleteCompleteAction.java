package com.internousdev.ecsite2.action;
import java.sql.SQLException;

import com.internousdev.ecsite2.dao.ItemDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteCompleteAction extends ActionSupport{

	private String id;
	ItemDeleteCompleteDAO dao=new ItemDeleteCompleteDAO();

	public String execute() throws SQLException{

		dao.delete(id);


		return SUCCESS;


	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
}
