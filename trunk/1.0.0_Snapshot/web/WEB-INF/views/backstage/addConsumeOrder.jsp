<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="17" valign="top" background="images/mail_leftbg.gif"><img
			src="images/left-top-right.gif" width="17" height="29" /></td>
		<td valign="top" background="images/content-bg.gif">
		<table width="100%" height="31" border="0" cellpadding="0"
			cellspacing="0" class="left_topbg" id="table2">
			<tr>
				<td height="31">
				<div class="titlebt">添加订单</div>
				</td>
			</tr>
		</table>
		</td>
		<td width="16" valign="top" background="images/mail_rightbg.gif"><img
			src="images/nav-right-bg.gif" width="16" height="29" /></td>
	</tr>
	<tr>
		<td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
		<td valign="top" bgcolor="#F7F8F9">
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="2" valign="top">&nbsp;</td>
				<td>&nbsp;</td>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" valign="top"></td>
				<td width="7%">&nbsp;</td>
				<td width="40%" valign="top"></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" valign="top">
				<form:form commandName="order">
					<table>
						<tr>
							<td>First Name:</td>
							<td><form:input path="firstName" /></td>
						</tr>
						<tr>
							<td>Last Name:</td>
							<td><form:input path="lastName" /></td>
						</tr>
						<tr>
							<td colspan="3"><input type="submit" value="Save Changes" />
							</td>
						</tr>
					</table>
				</form:form>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				</td>
				<td>&nbsp;</td>
				<td valign="top"></td>
			</tr>
			<tr>
				<td height="40" colspan="4">
				<table width="100%" height="1" border="0" cellpadding="0"
					cellspacing="0" bgcolor="#CCCCCC">
					<tr>
						<td></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td width="2%">&nbsp;</td>
				<td width="51%" class="left_txt"><img
					src="images/icon-mail2.gif" width="16" height="11">CRM <br>
				<img src="images/icon-phone.gif" width="17" height="14">
				http://192.168.1.251/crm</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
		</td>
		<td background="images/mail_rightbg.gif">&nbsp;</td>
	</tr>
	<tr>
		<td valign="bottom" background="images/mail_leftbg.gif"><img
			src="images/buttom_left2.gif" width="17" height="17" /></td>
		<td background="images/buttom_bgs.gif"><img
			src="images/buttom_bgs.gif" width="17" height="17"></td>
		<td valign="bottom" background="images/mail_rightbg.gif"><img
			src="images/buttom_right2.gif" width="16" height="17" /></td>
	</tr>
</table>
</body>
</html>
