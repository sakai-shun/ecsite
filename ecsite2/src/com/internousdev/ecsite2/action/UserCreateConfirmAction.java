package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String,Object>session;
	private String errorMessage;


	public String execute() throws SQLException{
		String result=SUCCESS;
		UserCreateConfirmDAO dao=new UserCreateConfirmDAO();



		if(!(loginUserId.equals(""))
				&&!(loginPassword.equals(""))
				&&!(userName.equals(""))){
			if(!dao.isExistUser(loginUserId)){
				session.put("loginUserId", loginUserId);
				session.put("loginPassword", loginPassword);
				session.put("userName", userName);

			}else{
				setErrorMessage("すでに登録されているログインIDです。");
				result=ERROR;
			}




		}else{
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}




		return result;
	}
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String password){
		this.loginPassword=password;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}

}
