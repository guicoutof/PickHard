<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PickHard</title>
</head>
<body>
<div><h1>Pick Hard<h1/></div>
<div><p> Gerador randomico de times de League of Legends</p></div>
<div><p><b>Alunos :</b> Guilherme Couto Fernandes</p>
	<p>Leonardo Lucas Ferreira </p>
</div>

	<%
	ArrayList<String> champions = null; 
	champions = (ArrayList<String>) request.getAttribute("champions");
	if(champions == null){
		champions = new ArrayList<String>();
		champions.add("Campeão");
		champions.add("Campeão");
		champions.add("Campeão");
		champions.add("Campeão");
		champions.add("Campeão");
	}
	%>
	<form action="gerarTime" method="post">
		<tr>
			 <th>Topo: <%= champions.get(0)%></td><br>
			<th>Selva: <%= champions.get(1)%></td><br>
			<th>Meio: <%= champions.get(2)%></td><br>
			<th>Baixo: <%= champions.get(3)%></td><br>
			<th>Suporte: <%= champions.get(4)%> </td><br>
			<td><input type="submit" value="Gerar"></td><br>
		</tr>
	</form>
	<div>
	<h4>Listar Campeões</h4>
	</div>
	<form action="listarCampeoes" method="post">
		<input type="submit" value="Listar">
	</form>
	<div>
	<h4>Inserir Campeões</h4>
	</div>
	<form action="listarCampeoes" method="get">
		Campeão : <input type="text" name="name"><br>
		<input type="submit" value="Inserir"> 
	</form>


</body>
</html>