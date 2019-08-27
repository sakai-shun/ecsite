<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>buyItemAnother画面</title>
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
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>商品一覧</p>
		</div>
		<h3>以下の商品から選択してください</h3>

		<table>
			<tr>
				<th>id</th>
				<th>商品名</th>
				<th>値段</th>
				<th>在庫</th>
			</tr>
		<s:iterator value="itemList">
			<tr>
				<td><s:property value="id"/></td>
				<td><s:property value="itemName"/></td>
				<td><s:property value="itemPrice"/><span>円</span></td>
				<td><s:property value="itemStock"/><span>個</span></td>
				<td><a href="<s:url action='BuyItemAnotherConfirmAction'><s:param name="id" value="%{id}"/></s:url>">購入</a></td>
			</tr>
		</s:iterator>
		</table>
		<s:form action="GoHomeAction">
			<s:submit value="HOME"/>
		</s:form>

	</div>
	<div id="footer">

	</div>
</body>
</html>