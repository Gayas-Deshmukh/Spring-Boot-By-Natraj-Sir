<%@ page language="java" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Employee</title>

<link rel="stylesheet" href="css/customStyle.css">
<script type="text/javascript" src="js/validation.js"></script>

</head>
<body>
	 <h1 style="text-align: center;">Employee Registration</h1>
	 
	 <frm:form modelAttribute="emp" onsubmit="return doValidation(this)">
	 	<%-- <p align="center" style="text-align: center;color: red;">
	 		<frm:errors path="*"></frm:errors>
	 	</p> --%>
	 	<table align="center">
	 		<tr>
	 			<td>Employee Name</td>
	 			<td><frm:input  path="ename"/></td>
	 		</tr>
	 		<tr>
	 			<td></td>
	 			<td><frm:errors path="ename"/><span id="enameErr"></span></td>
	 		</tr>
	 		<tr>
	 			<td>Employee Designation</td>
	 			<td><frm:input path="deg"/></td>
	 		</tr>
	 		<tr>
	 			<td></td>
	 			<td><frm:errors path="deg"/><span id="desErr"></span></td>
	 		</tr>
	 		<tr>
	 			<td>Employee Salary</td>
	 			<td><frm:input path="sal"/></td>
	 		</tr>
	 		<tr>
	 			<td></td>
	 			<td><frm:errors path="sal"/><span id="salErr"></span></td>
	 		</tr>
	 		<tr>
	 			<td></td>
	 			<td><input type="submit" value="Submit"> &nbsp;<input type="reset" value="Cancel"></td>
	 		</tr>
	 		<frm:input type="hidden" path="vFlag"/>
	 	</table>
	 </frm:form>
</body>
</html>