import java.util.Date;

public class Pizza extends Item {
	private static final String NULL = null;
	private String recheio;
	private String borda;
	private String molho;
	
	public String getRecheio() {
		return recheio;
	}
	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}
	public String getBorda() {
		return borda;
	}
	public void setBorda(String borda) {
		this.borda = borda;
	}
	public String getMolho() {
		return molho;
	}
	public void setMolho(String molho) {
		this.molho = molho;
	}
	
	public Pizza(String nome, Double preco, Date validade, Double peso, String recheio, String borda, String molho) {
		super(nome, preco, validade, peso);
		this.recheio = recheio;
		this.borda = borda;
		this.molho = molho;
	}
	
	public Pizza(String nome, Double preco, Date validade, Double peso, String recheio, String molho) {
		super(nome, preco, validade, peso);
		this.recheio = recheio;
		this.molho = molho;
	}
	
	public Double calcularPreco(String borda) {
		if(borda == NULL) {
			return getPreco();
		}
		setPreco(getPreco() + 7.50);
		return getPreco();
	}
	
	
}
