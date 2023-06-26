package pacote;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Arquivos {

	public Arquivos() {
		try {
			System.out.println("Grava��o e Leitura de Arquivos\n"); 
			File livro = new File("C:/Users/aylac/Documents/Unicamp/Engenharia de Computa��o/7� Semestre/Programa��o Orientada a Objetos - MC322/Projeto_MC322/README.md");
			System.out.println("Arquivo gravado: " + livro.getName() + "\n");
			System.out.println("Leitura do arquivo: " + livro.getName() + "\n");
		    Scanner reader = new Scanner(livro);
		    while (reader.hasNextLine()) {
		        String data = reader.nextLine();
		        System.out.println(data);
		    }
		    reader.close();
		} catch (IOException e) {
			      System.out.println("Arquivo n�o encontrado");
			      e.printStackTrace();
		}
	}
}
