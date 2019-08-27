<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>resetPassword画面</title>
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
	</div>
	<div id="main">
		<div id="top">
			<p>パスワード再設定画面</p>
		</div>
		<s:if test="message!=null">
			<h3><s:property value="message"/></h3>
		</s:if>
		<table>
		<s:form action="ResetPasswordCompleteAction">

				<tr>
					<td><label>ログインID</label></td>
					<td><input type="text" name="loginId" value="" /></td>
				</tr>
				<tr>
					<td><label>現在のパスワード</label></td>
					<td><input type="password" name="password" value="" /></td>
				</tr>
				<tr>
					<td><label>新しいパスワード</label></td>
					<td><input type="password" name="newPassword" value="" /></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<s:submit value="再設定"/>
					</td>
				</tr>


		</s:form>
		</table>
	</div>
	<div id="footer">
	</div>
</body>
</html>