<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="trab.Cadastro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h2>Lista de Cadastros</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Email</th>
            <th>Nome</th>
            <th>Senha</th>
        </tr>
        <%
            List<Cadastro> cadastros = (List<Cadastro>) request.getAttribute("cadastros");
            if (cadastros != null) {
                for (Cadastro cadastro : cadastros) {
        %>
        <tr>
            <td><%= cadastro.getId() %></td>
            <td><%= cadastro.getEmail() %></td>
            <td><%= cadastro.getNome() %></td>
            <td><%= cadastro.getSenha() %></td>
        </tr>
        <% 
                }
            }
        %>
    </table>
</body>
</html>