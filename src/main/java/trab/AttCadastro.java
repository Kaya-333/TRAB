package trab;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AttCadastro")
public class AttCadastro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");

        try (Connection conexao = conecta.getConnection()) {
            String sql = "UPDATE cadastro.cadastros SET email = ?, nome = ?, senha = ? WHERE id = ?";
            try (PreparedStatement prs = conexao.prepareStatement(sql)) {
                prs.setString(1, email);
                prs.setString(2, nome);
                prs.setString(3, senha);
                prs.setInt(4, id);

                prs.executeUpdate();
            }
        } catch (Exception e) {
            throw new ServletException("Erro ao alterar cadastro", e);
        }
        response.sendRedirect("index.jsp");
    }   
}