package trab;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaCadastros")
public class listaCadastros extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Cadastro> cadastros = new ArrayList<>();
		try (Connection conexao = conecta.getConnection()) {
			String sql = "SELECT id, email, nome, senha FROM cadastro.cadastros";
			try (PreparedStatement prs = conexao.prepareStatement(sql)) {
				ResultSet rs = prs.executeQuery();
				while (rs.next()) {
					Cadastro cadastro = new Cadastro(rs.getInt("id"), rs.getString("email"),
							rs.getString("nome"), rs.getString("senha"));
					cadastros.add(cadastro);
				}
			}
		} catch (Exception e) {
			throw new ServletException("Erro ao listar cadastros", e);
		}
		request.setAttribute("cadastros", cadastros);
		request.getRequestDispatcher("/listaCadastros.jsp").forward(request, response);
	}
}