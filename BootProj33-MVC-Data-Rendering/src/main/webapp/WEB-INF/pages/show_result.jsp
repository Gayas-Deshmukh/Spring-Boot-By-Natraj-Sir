<%@ page language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 
	<!-- Passing Simple Value -->
<label>My name is : ${Name}</label><br>
<label>My age is : ${Age}</label>

 --%>
 
 <!-- Passing Array & Collection -->
<%-- <h1>Model Attributes are :</h1>
	<b>Fav Color :</b> <%= Arrays.toString(((String [])request.getAttribute("FavColor"))) %> <br>
	<b>Nick Names :</b> ${NickNames } <br>
	<b>Phone Num :</b> ${PhoneNum } <br>
	<b>Id Details :</b> ${IdDetails }
 --%>

 	<!-- Use of JSTL -->
  <!-- Passing Array & Collection -->
<%-- 	<h1>Model Attributes are ( Use JSTL) :</h1>
	<b>Fav Color :</b> 
	 <c:forEach var="color" items="${FavColor}">
	   ${color},
	 </c:forEach>
	<br>
	<b>Nick Names :</b>
	 <c:forEach var="name" items="${NickNames}">
	   ${name},
	 </c:forEach>
	 <br>
	<b>Phone Num :</b>
	<c:forEach var="ph" items="${PhoneNum}">
	   ${ph},
	 </c:forEach>
	 <br>
	<b>Id Details :</b>
	<c:forEach var="id" items="${IdDetails}">
	   ${id},
	 </c:forEach> --%>
	 
	 <!-- Passing Model class obj --> 
	 <c:if test="${!empty Emp}">
	 	<b>Employee Info :</b> <br>
	 	Emp No : ${Emp.empNo } <br>
	 	Emp Name : ${Emp.empName } <br>
	 	Emp Salary : ${Emp.empSalary } <br>
	 	Emp Address : ${Emp.empAdd }
	 </c:if>
	 
	 <!-- Passing collection of model class obj -->
	 <c:choose>
	 	<c:when test="${!empty Empls}">
	 		<table border="1" align="center" bgcolor="cyan">
	 			<tr>
	 				<th> Emp No </th>
	 				<th> Emp Name </th>
	 				<th> Emp Salary </th>
	 				<th> Emp Addrs </th>
	 			</tr>
	 			<c:forEach var="emp" items="${Empls}">
	 				<tr>
	 					<td>${emp.empNo }</td>
	 					<td>${emp.empName }</td>
	 					<td>${emp.empSalary }</td>
	 					<td>${emp.empAdd }</td>
	 				</tr>
	 			</c:forEach>
	 		</table>
	 	</c:when>
	 	<c:otherwise>
	 		Employee data not found.
	 	</c:otherwise>
	 </c:choose>
	 
</body>
</html>