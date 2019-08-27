<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>buyItemAnotherConfirm画面</title>
<style type="text/css">
	body{
		margin:0;
		padding:0;
		line-height:1.6;
		letter-spacing:1px;
		font-family:Verdana,Helvetica,sans-serif;
		color:#333;
		background:#fff;
	}
	table{
		text-align:center;
		margin:0 auto;
	}
	#top{
		width:780px;
		margin:30px auto;
		border:1px solid #333;

	}
	#header{
		width:100%;
		height:80px;
		background-color:black;

	}
	#main{
		width:100%;
		height:500px;
		text-align:center;
	}
	#footer{
		width:100%;
		height:80px;
		background-color:black;
		clear:both;
	}

</style>
</head>
<body>
<script src="./js/buyItemAnother.js"></script>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>商品購入画面</p>
		</div>
		<s:form id="buyItem">
			<table>
				<tr>
					<td><label>商品名</label></td>
					<td><s:property value="dto.itemName"/></td>
				</tr>
				<tr>
					<td><label>値段</label></td>
					<td><s:property value="dto.itemPrice"/><span>円</span></td>
				</tr>
				<tr>
					<td><label>購入個数</label></td>
					<td>
						<select name="count">
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
						<span>個</span>
					</td>
				</tr>
				<tr>
					<td><label>支払い方法</label></td>
					<td>
						<input type="radio" name="pay" value="1" checked="checked">現金払い
						<input type="radio" name="pay" value="2">クレジットカード
					</td>
				</tr>
				<tr>
					<td><s:submit value="カートに追加" onclick="goAddCartAction()"/></td>
					<td><s:submit value="購入" onclick="goBuyItemAction()"/></td>
					<s:hidden name="id" value="%{id}"/>
					
					
				</tr>
			</table>

		</s:form>

	</div>
	<div id="footer">
	</div>
</body>
</html>