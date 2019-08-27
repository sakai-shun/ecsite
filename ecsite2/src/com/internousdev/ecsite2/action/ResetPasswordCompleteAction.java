package com.internousdev.ecsite2.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dao.LoginUserDAO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport {

	private String loginId;
	private String password;
	private String newPassword;
	private String message;

	public String execute() throws SQLException{


		LoginUserDAO loginUserDAO=new LoginUserDAO();
		List<LoginDTO> loginDTOList=new ArrayList<LoginDTO>();
		String result=ERROR;


		loginDTOList=loginUserDAO.selectUserInfo();
		if(loginDTOList!=null){
			for(int i=0;i<loginDTOList.size(); i++){
				if(((loginDTOList.get(i)).getLoginId()).equals(loginId)
						&&((loginDTOList.get(i)).getLoginPassword()).equals(password)){
					loginUserDAO.UpdatePassword(loginId, password, newPassword);
					result=SUCCESS;
				}else{
					setMessage("パスワードが異なります。");

				}
			}
			return result;
		}

		return result;
	}
	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId=loginId;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getNewPassword(){
		return newPassword;
	}
	public void setNewPassword(String newPassword){
		this.newPassword=newPassword;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}
}
