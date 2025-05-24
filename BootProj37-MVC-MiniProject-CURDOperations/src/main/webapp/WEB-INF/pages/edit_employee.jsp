<%@ page language="java" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
	 <h1 style="text-align: center;">Edit Employee</h1>
	 
	 <frm:form modelAttribute="emp">
	 	<table align="center">
	 	    <tr>
	 			<td>Employee No</td>
	 			<td><frm:input  path="empno" readonly="true"/></td>
	 		</tr>
	 		<tr>
	 			<td>Employee Name</td>
	 			<td><frm:input  path="ename"/></td>
	 		</tr>
	 		<tr>
	 			<td>Employee Designation</td>
	 			<td><frm:input path="deg"/></td>
	 		</tr>
	 		<tr>
	 			<td>Employee Salary</td>
	 			<td><frm:input path="sal"/></td>
	 		</tr>
	 		<tr>
	 			<td></td>
	 			<td><input type="submit" value="Submit"> &nbsp;<input type="reset" value="Cancel"></td>
	 		</tr>
	 	</table>
	 </frm:form>
</body>
</html>