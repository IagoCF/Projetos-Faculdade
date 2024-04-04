import java.util.Date;

public class Lanches extends Item{
	private String pao;
	private String recheio;
	private String molho;
	
	public String getPao() {
		return pao;
	}
	public void setPao(String pao) {
		this.pao = pao;
	}
	public String getRecheio() {
		return recheio;
	}
	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}
	public String getMolho() {
		return molho;
	}
	public void setMolho(String molho) {
		this.molho = molho;
	}
	
	public Lanches(String nome, Double preco, Date validade, Double peso, String pao, String recheio, String molho) {
		super(nome, preco, validade, peso);
		this.pao = pao;
		this.recheio = recheio;
		this.molho = molho;
	}
	
	public Double calcularPreco() {
		return getPreco();
	}
	
}
