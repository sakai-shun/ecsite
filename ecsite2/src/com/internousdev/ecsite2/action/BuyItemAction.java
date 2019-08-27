package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private String id;
	private int count;
	private String pay;
	private String errorMessage;

	public String execute(){
		BuyItemDAO dao=new BuyItemDAO();
		BuyItemDTO dto=dao.getBuyItemInfo();
		session.put("itemStock",dto.getItemStock());

		String result=SUCCESS;
		session.put("count", count);
		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price",intCount*intPrice);
		String payment;
		if(id!=null){
			session.put("id", id);
		}

		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay",payment);
		}else{
			payment="クレジットカード";
			session.put("pay", payment);
		}
		int countStock=Integer.parseInt(session.get("itemStock").toString());
		if(countStock < count){
			result=ERROR;
			setErrorMessage("在庫がありません");
			return result;
		}
		return result;
	}
	public void setCount(int count){
		this.count=count;
	}
	public void setPay(String pay){
		this.pay=pay;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
}
