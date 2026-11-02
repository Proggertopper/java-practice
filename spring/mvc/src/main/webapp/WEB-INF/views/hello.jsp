<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
	<%
		Integer id = (Integer) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String salary = (String) request.getAttribute("salary");
		out.println("ID : "+ id);
		out.println("Name : "+ name);
		out.println("Salary : "+ salary);
	%>
	<br/>
	Id:
	<b>${id}</b>
	Name:
	<b>${name}</b>
	Salary:
	<b>${salary}</b>
</body>
</html>