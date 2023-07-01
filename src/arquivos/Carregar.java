package arquivos;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import sistema.Admin;
import sistema.Biblioteca;
import sistema.Emprestimo;
import sistema.Estudante;
import sistema.Livro;

public class Carregar {
    public static void carregarDados() {
        System.out.println("oi");
        ArrayList<Biblioteca> listaBiblioteca = new ArrayList<>();
        ArquivoBiblioteca arquivoBiblioteca = new ArquivoBiblioteca();
        ArquivoEstudante arquivoEstudante = new ArquivoEstudante();
        ArquivoLivro arquivoLivro = new ArquivoLivro();
        ArquivoEmprestimo arquivoEmprestimo = new ArquivoEmprestimo();
        try {
            System.out.println(arquivoBiblioteca.LerDados(listaBiblioteca));
            for(int i = 0; i < listaBiblioteca.size(); i++){
                Admin.cadastrarBiblioteca(listaBiblioteca.get(0).getNome(), listaBiblioteca.get(0).getCNPJ(), listaBiblioteca.get(0).getEndereco(), listaBiblioteca.get(0).getTelefone(), listaBiblioteca.get(0).getSenha());
            }

            ArrayList<Estudante> listaEstudantes = new ArrayList<>();
            ArrayList<Livro> listaLivros = new ArrayList<>();
            ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>();
            listaEstudantes = listaBiblioteca.get(0).getEstudantes();
            listaLivros = listaBiblioteca.get(0).getLivros();
            listaEmprestimos = listaBiblioteca.get(0).getEmprestimos();

            System.out.println(arquivoEstudante.LerDados(listaEstudantes));
            System.out.println(arquivoLivro.LerDados(listaLivros));
            System.out.println(arquivoEmprestimo.LerDados(listaEmprestimos));
            System.out.println(listaBiblioteca.get(0).getNome());
            System.out.println(listaEstudantes.get(1).getNome());
            System.out.println(listaLivros.get(0).getTitulo());
            //System.out.println(listaEmprestimos.get(0).getItem().getTitulo());
            if(listaLivros.isEmpty()){
                System.out.println("lista vazia");
            }
            System.out.println(listaLivros.get(0).getTitulo());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch(NumberFormatException e){
            throw new RuntimeException(e);
        }
    }
}