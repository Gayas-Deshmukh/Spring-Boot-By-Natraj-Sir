<%@ page language="java" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees Report</title>

<style type="text/css">
	.emp-table {
		border-collapse: collapse;
		text-align: center;
		width: 100%;
	}
	
	th {
		background-color: #b4e6e6;
	}
	
	td {
		background-color: #ffdcdc;
	}
	
	tr, th, td {
	  border: 1px solid black;
	  padding: 2px;
	}
	
	.current-page {
		background-color: aqua;
	}
	
</style>
</head>
<body>
	<div style="float: right; display: flex;">
		<div>
			<button style="background-color: #fce1e1; margin-right: 5px;text-align: center;">
			    <a style="text-decoration: none;" href="add-emp"><img alt="" src="images/add-emp.jpg" height="25px" width="25px">Add</a>
			</button>
		</div>
		<div>
			<button style="background-color: #fce1e1; height: 35px">
				<a style="text-decoration: none;" href="./">Cancel</a>
			</button>
		</div>
	</div>
	
	<h2 style="text-align: center; margin-top: 30px; margin-bottom: 30px;">Employees</h2>
	
	<c:if test="${!empty resultMsg}">
		<h2 style="text-align: center; margin-top: 10px; margin-bottom: 10px; color: green;">${resultMsg}</h2>
	</c:if>
	
	<div style="text-align: center;">
		<c:choose>
			<c:when test="${!empty emplList.getContent()}">
				<table class="emp-table" align="center">
					<tr>
						<th>Emp No</th>
						<th>Name</th>
						<th>Des.</th>
						<th>Salary</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach var="emp" items="${emplList.getContent()}">
						<tr> 
							<td>${emp.empno}</td>
							<td>${emp.ename}</td>
							<td>${emp.deg}</td>
							<td>${emp.sal}</td>
							<td><a href="edit?eno=${emp.empno}"><img alt="" src="images/edit.webp" height="25px" width="30px"></a></td>
							<td><a href="delete?eno=${emp.empno}" onclick="return confirm('Are you sure, do want to delete this record?')"><img src="images/delete.jpg" height="25px" width="30px"></a></td>
						</tr>
					</c:forEach>
				</table>
				
				<div style="text-align: center; padding-top: 5px;"> 
					<c:if test="${emplList.hasPrevious()}">
						<a href="emp-report?page=${emplList.getPageable().getPageNumber() -1}">Previous</a>&nbsp;&nbsp;
					</c:if>
					
					<c:if test="${!emplList.isFirst()}">
						<a href="emp-report?page=0">First</a>&nbsp;&nbsp;
					</c:if>
					
					<c:forEach var="i" begin="1" end="${emplList.getTotalPages()}" step="1">
						[<a href="emp-report?page=${i-1}" class="${ emplList.getPageable().getPageNumber() == (i -1) ? 'current-page' : '' }">${i}</a>]&nbsp;&nbsp;
					</c:forEach>
					
					<c:if test="${!emplList.isLast()}">
						<a href="emp-report?page=${emplList.getTotalPages() - 1}">Last</a>&nbsp;&nbsp;
					</c:if>
					
					<c:if test="${emplList.hasNext()}">
						<a href="emp-report?page=${emplList.getPageable().getPageNumber() + 1}">Next</a>&nbsp;&nbsp;
					</c:if>
				</div>
			</c:when>
			<c:otherwise> <label style="background-color: yellow;">Employees not found</label></c:otherwise>
		</c:choose>
	</div>
</body>
</html>