import java.util.Date;

public class Item {
	private String nome;
	private Double preco;
	private Date validade;
	private Double peso;
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Item(String nome, Double preco, Date validade, Double peso) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.validade = validade;
		this.peso = peso;
	}
	
	public Double calcularPreco() {
		return 0.0;
	}
	
}
