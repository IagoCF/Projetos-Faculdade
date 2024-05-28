package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.LivroModel;

public class LivroDAO {
	private Connection conexao;
	
	public LivroDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void adicionarLivro(LivroModel livro) throws SQLException{
		String insert = "INSERT INTO livro (titulo, autor) VALUES (?, ?)";
		try(PreparedStatement stmt = conexao.prepareStatement(insert)){
			stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor().toString());
            stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
		}	
	}
	
	public void removerLivro(Integer id) throws SQLException{
		String query = "DELETE FROM livro WHERE id=?";
		try(PreparedStatement stmt = conexao.prepareStatement(query)){
			stmt.setInt(1, id);
            stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
		}	
	}
	
	
	
	
}
