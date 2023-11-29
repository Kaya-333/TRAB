package trab;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AttVerificaID")
public class AttVerificaID extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        boolean existe = false;

        try (Connection conexao = conecta.getConnection()) {
            String sql = "SELECT id FROM cadastro.cadastros WHERE id = ?";
            try (PreparedStatement prs = conexao.prepareStatement(sql)) {
                prs.setInt(1, id);
                ResultSet rs = prs.executeQuery();
                existe = rs.next();
            }
        } catch (Exception e) {
            throw new ServletException("Erro ao verificar ID", e);
        }

        if (existe) {
            response.sendRedirect("AttCadastro.jsp?id=" + id);
        } else {
            response.getWriter().println("ID não encontrado.");
        }
    }
}