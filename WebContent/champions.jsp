<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Champions</title>
</head>
<body>
<div>
<h2>Inserir Campe�o</h2>
</div>
<form action="listarCampeoes" method="get">
		Campe�o: <input type="text" name="name"><br> 
		<input type="submit" value="Inserir"> 
	</form>
<div>
	<h1>Campe�es</h1>
</div>
	<%
	ArrayList<String> champions = (ArrayList<String>) request.getAttribute("championsGeneral");
	for(String s: champions){
	%><%=s%><br><%
	}
	%>
	<div>
	<form action="gerarTime">
    	<input type="submit" value="Home" />
	</form>
	</div>
	
</body>
</html>