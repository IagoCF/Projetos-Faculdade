import java.util.Date;

public class Salgadinho extends Item{
	private String tipo;
	private String massa;
	private String recheio;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMassa() {
		return massa;
	}
	public void setMassa(String massa) {
		this.massa = massa;
	}
	public String getRecheio() {
		return recheio;
	}
	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}
	public Salgadinho(String nome, Double preco, Date validade, Double peso, String tipo, String massa, String recheio) {
		super(nome, preco, validade, peso);
		this.tipo = tipo;
		this.massa = massa;
		this.recheio = recheio;
	}
	
	public Double calcularPreco() {
		return getPreco();
	}
	
}
