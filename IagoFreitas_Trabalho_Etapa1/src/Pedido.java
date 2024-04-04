import java.util.ArrayList;

public class Pedido {
	private String nomeCliente;
	private ArrayList<Item> itens;
	private Double taxa = 5.00;
	private Double pagamento;
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public ArrayList<Item> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	public Double getTaxa() {
		return taxa;
	}
	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	public Double getPagamento() {
		return pagamento;
	}
	public void setPagamento(Double pagamento) {
		this.pagamento = pagamento;
	}
	public Pedido(String nomeCliente, ArrayList<Item> itens, Double pagamento) {
		this.nomeCliente = nomeCliente;
		this.itens = itens;
		this.pagamento = pagamento;
	}
	
	public Double calcularTotal() {
		Double total = 0.0;
		for(Item x : itens) {
			total += x.getPreco();
		}
		total += taxa;
		return total;
	}
	
	public Double calcularTroco(Double pagamento) {
		Double Troco;
		Troco = pagamento - calcularTotal();
		return Troco;
	}
	
	public void mostrarFatura() {
		System.out.println("-------------------------");
		System.out.println(nomeCliente + ", seu preço total é " + calcularTotal());
		System.out.println("");
		System.out.println("Itens comprados:");
		for(Item x : itens) {
			System.out.println(x.getNome());
		}
		System.out.println("Seu troco é: "  + calcularTroco(pagamento));
		System.out.println("");
	}
	
	
}
