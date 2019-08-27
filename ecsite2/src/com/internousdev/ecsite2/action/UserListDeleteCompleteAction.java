package com.internousdev.ecsite2.action;

import java.sql.SQLException;

import com.internousdev.ecsite2.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{

	private String message;

	public String execute() throws SQLException{
		String result=SUCCESS;
		UserListDeleteCompleteDAO dao=new UserListDeleteCompleteDAO();
		int res=0;
		res=dao.delete();

		if(res>0){
			setMessage("ユーザー情報が正しく削除されました。");
		}else{
			setMessage("ユーザー情報がありません");
		}
		return result;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}
}
