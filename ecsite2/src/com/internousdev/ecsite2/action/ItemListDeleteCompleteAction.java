package com.internousdev.ecsite2.action;
import java.sql.SQLException;

import com.internousdev.ecsite2.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport {

	private String message;
	public String execute() throws SQLException{
		ItemListDeleteCompleteDAO dao=new ItemListDeleteCompleteDAO();
		String result=SUCCESS;
		int res=0;
		res=dao.delete();

		if(res>0){

			setMessage("商品情報を正しく削除しました。");
		}else{
			setMessage("商品情報はありません。");
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
