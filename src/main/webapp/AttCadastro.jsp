<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Alterar Cadastro</h2>
    <form action="AttCadastro" method="post">
        <input type="hidden" name="id" value="<%= Integer.parseInt(request.getParameter("id")) %>">
        Email: <input type="email" name="email" required><br>
        Nome: <input type="text" name="nome" required><br>
        Senha: <input type="password" name="senha" required><br>
        <input type="submit" value="Alterar">
    </form>
</body>
</html>