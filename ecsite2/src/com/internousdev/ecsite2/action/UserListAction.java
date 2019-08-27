package com.internousdev.ecsite2.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dao.UserListDAO;
import com.internousdev.ecsite2.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserListAction extends ActionSupport {

	private List<UserInfoDTO>userList=new ArrayList<UserInfoDTO>();

	public String execute() throws SQLException{
		UserListDAO dao=new UserListDAO();
		userList=dao.getUserInfo();
		String result=SUCCESS;

		if(userList.size()<0){
			userList=null;
		}
		return result;

	}
	public List<UserInfoDTO> getUserList(){
		return userList;
	}
	public void setUserList(List<UserInfoDTO>userList){
		this.userList=userList;
	}

}
