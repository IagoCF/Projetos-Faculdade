package Modelo;

public class ProdutoAlimenticio extends Produto{
	
	public ProdutoAlimenticio(Integer codigo, Integer quantidade, String nome,
							String descricao, String categoria, Double precoCusto,
							Double precoVenda){
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
	}
}