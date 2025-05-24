<%@ page language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div style="text-align: center;">
		<h2>Student Registration Page</h2>
		
		<form action="register" method="post">
			Student No : <input type="text" name="stdNo"><br>
			Student Name : <input type="text" name="stdName"><br>
			Student Address : <input type="text" name="stdAdd"><br>
			Student Avg : <input type="text" name="avg"><br>
			<input type="submit" value="Register">
		</form>
	</div>
</body>
</html>