package com.internousdev.ecsite2.dto;

public class ItemInfoDTO {

	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String insert_date;
	private String Id;
	private String update_date;


	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice=itemPrice;
	}
	public String getItemStock(){
		return itemStock;
	}
	public  void setItemStock(String itemStock){
		this.itemStock=itemStock;
	}

	public String getInsert_date(){
		return insert_date;
	}
	public void setInsert_date(String insert_date){
		this.insert_date=insert_date;
	}
	public String getId(){
		return Id;
	}
	public void setId(String Id){
		this.Id=Id;
	}
	public String getUpdate_date(){
		return update_date;
	}
	public void setUpdate_date(String update_date){
		this.update_date=update_date;
	}

}
