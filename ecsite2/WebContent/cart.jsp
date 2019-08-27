<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cart画面</title>
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
	#text-center{
		display:inline-block;
		text-align:center;
	}
</style>
</head>
<body>
<script src="./js/cart.js"></script>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>カート一覧</p>
		</div>
		<s:if test="message!=null">
			<h3><s:property value="message"/></h3>
		</s:if>
		<s:else>
		<form id="cart">
			<table border="1">
				<tr>
					<th>#</th>
					<th>商品名</th>
					<th>値段</th>
					<th>購入個数</th>
					<th>カートに入れた日時</th>
					<th>合計金額</th>
				</tr>
				<s:iterator value="cartList">
					<tr>
						<td><input type="checkbox" name="checkList" class="checkList" value='<s:property value="productId"/>' onchange="checkValue(this)"></td>
						<td><s:property value="itemName"/></td>
						<td><s:property value="itemPrice"/><span>円</span></td>
						<td><s:property value="productCount"/><span>個</span></td>
						<td><s:property value="registDate"/></td>
						<td><s:property value="totalPrice"/><span>円</span></td>
					</tr>
				</s:iterator>
			</table>
			<table>
				<tr>
					<td><s:submit value="購入" onclick="goCartBuyAction()"/></td>
					<td><s:submit id="deleteButton" value="削除" onclick="goCartDeleteAction()" disabled="true"/></td>
				</tr>
			</table>
		</form>
		</s:else>
		<s:form action="GoHomeAction">
			<s:submit value="HOME"/>
		</s:form>
	</div>
	<div id="footer">
	</div>
</body>
</html>