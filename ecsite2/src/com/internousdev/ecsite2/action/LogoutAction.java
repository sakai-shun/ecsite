package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	public String execute() throws SQLException{
		CartInfoDAO dao=new CartInfoDAO();
		dao.deleteAll();
		session.clear();
		return SUCCESS;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
