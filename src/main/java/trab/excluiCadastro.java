package trab;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/excluiCadastro")
public class excluiCadastro extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cadastroId = request.getParameter("cadastroId");

        try (Connection conexao = conecta.getConnection()) {
            String sqlVerifica = "SELECT COUNT(*) FROM cadastro.cadastros WHERE id = ?";
            
            try (PreparedStatement psVerifica = conexao.prepareStatement(sqlVerifica)) {
                psVerifica.setInt(1, Integer.parseInt(cadastroId));
                ResultSet rs = psVerifica.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    String sql = "DELETE FROM cadastro.cadastros WHERE id = ?";
                    try (PreparedStatement prs = conexao.prepareStatement(sql)) {
                        prs.setInt(1, Integer.parseInt(cadastroId));
                        prs.executeUpdate();
                        response.getWriter().println("Cadastro excluído com sucesso.");
                        response.sendRedirect("index.jsp");
                    }
                } else {
                    response.getWriter().println("Cadastro com ID " + cadastroId + " não encontrado.");
                }
            }
            
        } catch (SQLException | NumberFormatException e) {
            throw new ServletException("Erro ao excluir o cadastro", e);
        }
    }
}