package com.internousdev.ecsite2.dto;

public class CartInfoDTO {

	private int id;
	private String userId;
	private int productId;
	private int productCount;
	private String registDate;
	private String updateDate;
	private int totalPrice;
	private String itemName;
	private int itemPrice;

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}
	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId=productId;
	}
	public int getProductCount(){
		return productCount;
	}
	public void setProductCount(int productCount){
		this.productCount=productCount;
	}
	public String getRegistDate(){
		return registDate;
	}
	public void setRegistDate(String registDate){
		this.registDate=registDate;
	}
	public String getUpdateDate(){
		return updateDate;
	}
	public void setUpdateDate(String updateDate){
		this.updateDate=updateDate;
	}
	public int getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice){
		this.totalPrice=totalPrice;
	}
	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	public int getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(int itemPrice){
		this.itemPrice=itemPrice;
	}
}
