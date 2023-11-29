package trab;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addBanco")
public class addBanco extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String nome  = request.getParameter("nome");
		String senha = request.getParameter("senha");

		try(Connection conexao = conecta.getConnection()){
					
			String sql = "INSERT INTO cadastro.cadastros (email, nome, senha) VALUES (?, ?, ?)";
			try (PreparedStatement prs = conexao.prepareStatement(sql)) {
				
				prs.setString(1, email);
				prs.setString(2, nome);
				prs.setString(3, senha);
		
				prs.executeUpdate();

				response.sendRedirect("index.jsp");
			}
			catch (SQLException e) {
				throw new ServletException("Erro durante a inserção no banco de dados", e);
			}
		}
		catch (SQLException e) {
            throw new ServletException("Erro ao obter conexão com o banco de dados", e);
        }
	}
}