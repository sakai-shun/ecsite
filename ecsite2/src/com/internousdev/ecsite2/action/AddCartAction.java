package com.internousdev.ecsite2.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware{
	private int count;
	private int id;
	private Map<String,Object> session;

	public String execute() throws SQLException{
		CartInfoDAO dao=new CartInfoDAO();

		String result=SUCCESS;
		dao.setCartInfo((session.get("login_user_id")).toString(),id ,count );

		return result;
	}
	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count=count;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}
