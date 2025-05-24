<%@ page language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div style="text-align: center;">
		<h2>Student Registration Page</h2>
		
		<frm:form action="register" method="post" modelAttribute="stud">
			Student No : <frm:input type="text" path="stdNo"/><br>
			Student Name : <frm:input type="text" path="stdName"/><br>
			Student Address : <frm:input type="text" path="stdAdd"/><br>
			Student Avg : <frm:input type="text" path="avg"/><br>
			<input type="submit" value="Register">
		</frm:form>
	</div>
</body>
</html>