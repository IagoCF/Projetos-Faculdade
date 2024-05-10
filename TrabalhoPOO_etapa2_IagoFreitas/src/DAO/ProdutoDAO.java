package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelo.Produto;

public class ProdutoDAO {
	private Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    //Insert
    public void adicionarProduto(Produto produto) throws SQLException{
    	String query = "INSERT INTO produto (nome, descricao, precoCusto, precoVenda, quantidade, categoria) VALUES (?, ? , ? , ? , ? , ?)";
    	try(PreparedStatement stmt = conexao.prepareStatement(query)){
    		stmt.setString(1, produto.getNome());
    		stmt.setString(2, produto.getDescricao());
    		stmt.setDouble(3, produto.getPrecoCusto());
    		stmt.setDouble(4, produto.getPrecoVenda());
    		stmt.setInt(5, produto.getQuantidade());
    		stmt.setString(6, produto.getCategoria());
    		stmt.executeUpdate();
    	}
    }
    
    //Consulta por codigo
    public void consultarProdutoCodigo(Integer codigo) throws SQLException{
    	String query = "SELECT * FROM produto WHERE codigo = ?";
    	try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
    	}
    }
    
    //Consulta por nome
    public void consultarProdutoNome(String nome) throws SQLException{
    	String query = "SELECT * FROM produto WHERE nome = ?";
    	try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
    	}
    }
    
    //Consulta por categoria
    public void consultarProdutoCategoria(String categoria) throws SQLException{
    	String query = "SELECT * FROM produto WHERE categoria = ?";
    	try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, categoria);
            stmt.executeUpdate();
    	}
    }
    
    //update
    public void atualizarProduto(Produto produto, Integer codigo) throws SQLException{
    	String query = "UPDATE produto SET nome=?, descricao=?, precoCusto=?, precoVenda=?, quantidade=?, categoria=? WHERE codigo=?";
    	try(PreparedStatement stmt = conexao.prepareStatement(query)){
    		stmt.setString(1, produto.getNome());
    		stmt.setString(2, produto.getDescricao());
    		stmt.setDouble(3, produto.getPrecoCusto());
    		stmt.setDouble(4, produto.getPrecoVenda());
    		stmt.setInt(5, produto.getQuantidade());
    		stmt.setString(6, produto.getCategoria());
    		stmt.setInt(7, codigo);
    		stmt.executeUpdate();
    	}
    }
    
    //Remover produto
    public void removerProduto(Integer codigo) throws SQLException {
        String query = "DELETE FROM produto WHERE codigo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        }
    }
}
