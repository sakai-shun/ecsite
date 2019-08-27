package com.internousdev.ecsite2.action;
import java.sql.SQLException;

import com.internousdev.ecsite2.dao.MyPageDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport{

	public String execute() throws SQLException{
		MyPageDAO dao=new MyPageDAO();

		dao.buyItemHistoryDeleteAll();

		return SUCCESS;


	}
}
