<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <input type="button" onclick="redirecionar('Cadastro.jsp')"  value="Fazer cadastro" ><br>
    <input type="button" onclick="redirecionar('AttSolicitaID.jsp')"   value="Alterar cadastros"><br>
    <input type="button" onclick="redirecionar('excluiCadastro.jsp')"   value="Excluir cadastros"><br>
  <form action="listaCadastros">
    <input type="submit" value="Listar cadastros" class="b">
  </form>
	
	<script>
  		function redirecionar(pagina) {
  			location.href = pagina;
 		}
  	</script>

</body>
</html>