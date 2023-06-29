package pacote;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Arquivos {

	public static String GravarDadosBiblioteca(ArrayList<Biblioteca> listaBibliotecas) {
		try {
			File file = new File("Bibliotecas.txt");
			FileWriter fileWriter = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fileWriter);
			pw.println("NOME,CNPJ,ENDERECO,TELEFONE,itens.txt,clientes.txt,emprestimos.txt,reservas.txt,SENHA\n");
			for(int i = 0; i < listaBibliotecas.size(); i++){
				pw.println(listaBibliotecas.get(0).getNome() + "," + listaBibliotecas.get(0).getCNPJ() + "," + listaBibliotecas.get(0).getEndereco() + "," + listaBibliotecas.get(0).getTelefone() + "," + "itens" + i + ".txt" + "," + "clientes" + i + ".txt," + "emprestimos" + i + ".txt" + "," + "reservas" + i + ".txt" + "," + listaBibliotecas.get(0).getSenha());
			}
			fileWriter.close();
			return "Dados gravados com sucesso";
		} catch (IOException e) {
			e.printStackTrace();
			return "Arquivo nao encontrado";
		}
	}

	public static String GravarDadosItens(ArrayList<Item> listaItens) {
		try {
			for(int i = 0; i < listaItens.size(); i++){
				File file = new File("itens" + i + ".txt");
				FileWriter fileWriter = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fileWriter);
				pw.println("TITULO,AUTOR,ANO,EDITORA,EDICAO,ISBN,QUANTIDADE,QUANTIDADE DISPONIVEL\n");
				if(listaItens.get(i) instanceof Livro)
					pw.println(listaItens.get(i).getTitulo() + "," + listaItens.get(i).getAutor() + "," + listaItens.get(i).getAno() + "," + listaItens.get(i).getEditora() + "," + listaItens.get(i).getEdicao() + "," + listaItens.get(i).getISBN() + "," + listaItens.get(i).getQuantidade() + "," + listaItens.get(i).getQuantidadeDisponivel());
				else if(listaItens.get(i) instanceof Revista)
					pw.println(listaItens.get(i).getTitulo() + "," + listaItens.get(i).getAutor() + "," + listaItens.get(i).getAno() + "," + listaItens.get(i).getEditora() + "," + listaItens.get(i).getEdicao() + "," + listaItens.get(i).getISBN() + "," + listaItens.get(i).getQuantidade() + "," + listaItens.get(i).getQuantidadeDisponivel());
				else if(listaItens.get(i) instanceof Apostila)
					pw.println(listaItens.get(i).getTitulo() + "," + listaItens.get(i).getAutor() + "," + listaItens.get(i).getAno() + "," + listaItens.get(i).getEditora() + "," + listaItens.get(i).getEdicao() + "," + listaItens.get(i).getISBN() + "," + listaItens.get(i).getQuantidade() + "," + listaItens.get(i).getQuantidadeDisponivel());
				else if(listaItens.get(i) instanceof Artigo)
					pw.println(listaItens.get(i).getTitulo() + "," + listaItens.get(i).getAutor() + "," + listaItens.get(i).getAno() + "," + listaItens.get(i).getEditora() + "," + listaItens.get(i).getEdicao() + "," + listaItens.get(i).getISBN() + "," + listaItens.get(i).getQuantidade() + "," + listaItens.get(i).getQuantidadeDisponivel());
				pw.println(listaItens.get(i).getTitulo() + "," + listaItens.get(i).getAutor() + "," + listaItens.get(i).getAno() + "," + listaItens.get(i).getEditora() + "," + listaItens.get(i).getEdicao() + "," + listaItens.get(i).getISBN() + "," + listaItens.get(i).getQuantidade() + "," + listaItens.get(i).getQuantidadeDisponivel());
				fileWriter.close();
			}
			return "Dados gravados com sucesso";
		} catch (IOException e) {
			e.printStackTrace();
			return "Arquivo nao encontrado";
		}
	}
}
