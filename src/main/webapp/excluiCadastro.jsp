<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="excluiCadastro" method="post">
        <p for="cadastroId">ID do Cadastro:</p>
        <input type="text" id="cadastroId" name="cadastroId" required>
        <input type="submit" value="Excluir">
    </form>
</body>
</html>