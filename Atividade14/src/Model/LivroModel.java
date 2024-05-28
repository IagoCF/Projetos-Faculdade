package Model;

public class LivroModel {
	private Integer id;
	private String titulo, autor;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public LivroModel(Integer id, String titulo, String autor) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
	}
	
	
}
