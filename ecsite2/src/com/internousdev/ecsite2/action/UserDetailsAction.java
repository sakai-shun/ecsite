package com.internousdev.ecsite2.action;
import java.sql.SQLException;

import com.internousdev.ecsite2.dao.UserDetailsDAO;
import com.internousdev.ecsite2.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailsAction extends ActionSupport{

	private String loginId;
	private UserInfoDTO dto=new UserInfoDTO();

	public String execute() throws SQLException{
		UserDetailsDAO dao=new UserDetailsDAO();

		dto =dao.select(loginId);


		if(dto.getLoginId()==null){
			dto=null;
		}
		String result=SUCCESS;
		return result;
	}
	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId=loginId;
	}
	public UserInfoDTO getDto(){
		return dto;
	}
	public void setDto(UserInfoDTO dto){
		this.dto=dto;
	}

}
