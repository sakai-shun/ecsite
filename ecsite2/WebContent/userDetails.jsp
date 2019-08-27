<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="imagetoolbar" content="no">
<meta name="description" content="">
<meta name="keywords" content="">
<title>UserDetails画面</title>
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
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>UserDetails</p>
		</div>
		<s:if test="dto ==null">
			<h3>ユーザーの詳細情報はありません。</h3>
		</s:if>
		<s:elseif test="dto != null">
		<h3>ユーザーリストの情報は以下の通りです</h3>
			<table border="1">
			<tr>
				<th>Id</th>
				<td><s:property value="dto.id"/></td>
			</tr>
			<tr>
				<th>ユーザーID</th>
				<td><s:property value="dto.loginId"/></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><s:property value="dto.loginPassword"/></td>
			</tr>
			<tr>
				<th>ユーザー名</th>
				<td><s:property value="dto.userName"/></td>
			</tr>
			<tr>
				<th>登録日</th>
				<td><s:property value="dto.insert_date"/></td>
			</tr>
			<tr>
				<th>更新日</th>
				<td><s:property value="dto.update_date"/></td>
			</tr>
			</table>



			<s:form action="UserDeleteConfirmAction">
				<s:hidden name="loginId" value="%{loginId}"/>
				<s:submit value="削除"/>
			</s:form>
		</s:elseif>
		<div id="text-right">
			<p>ユーザー一覧は<a href='<s:url action="UserListAction"/>'>こちら</a></p>
		</div>

		<div>

		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>