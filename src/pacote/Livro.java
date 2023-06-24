package pacote;

// import java.util.ArrayList;

public class Livro extends Item{
	private String editora;
	//private ArquivoLivro arquivoLivro;
	
	//Construtor
	public Livro(int code, String titulo, String autores/*, ArrayList<Reserva> listaReservas*/,
			int ano, String editora/*, ArquivoLivro arquivoLivro*/) {
		super(code, titulo, autores,/* listaReservas,*/ ano);
		this.editora = editora;
		//this.arquivoLivro = arquivoLivro;
	}
	//Getters e setters
		public String getEditora() {
			return editora;
		}
		public void setEditora(String editora) {
			this.editora = editora;
		}
}

