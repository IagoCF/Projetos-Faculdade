import java.util.Date;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Pizza strogonoff = new Pizza("Pizza Strogonoff", 50.00, new Date(), 0.600, "strogonoff", "molho de tomate");
		Pizza frangoRequeijao = new Pizza("Pizza Frango c/ Requeijão", 47.50, new Date(), 0.600, "frango com requeijão", "molho de tomate");
		
		Lanches frangoTeriaky = new Lanches("Frango Teriaky", 12.00, new Date(), 0.200, "brioche", "frango teriaky", "molho de queijo");
		Lanches paoComOvo  = new Lanches("Pão c/ Bife e Ovo", 14.00, new Date(), 0.300, "francês", "Ovo frito e bife", "");
		
		Salgadinho coxinha = new Salgadinho("Coxinha Franho c/ Catupiry", 8.00, new Date(), 0.300, "Frito", "Massa de Farinha de trigo", "Frango com Requeijão");
		Salgadinho pastel = new Salgadinho("Pastel", 10.00, new Date(), 0.400, "Frito", "Massa de pastel", "Frango com Requeijão");

		ArrayList<Item> pedido = new ArrayList();
		
		//pedido 1
		pedido.add(strogonoff);
		pedido.add(frangoTeriaky);
		pedido.add(frangoRequeijao);
		Pedido pedido1 = new Pedido("João", pedido, 200.00);
		pedido1.mostrarFatura();
		pedido.clear();
		
		//pedido 2
		pedido.add(pastel);
		pedido.add(pastel);
		pedido.add(coxinha);
		Pedido pedido2 = new Pedido("Marcos", pedido, 75.00);
		pedido2.mostrarFatura();
		pedido.clear();
		
		//pedido 3
		pedido.add(paoComOvo);
		Pedido pedido3 = new Pedido("Luis", pedido, 20.00);
		pedido3.mostrarFatura();
		pedido.clear();
		
	}

}
