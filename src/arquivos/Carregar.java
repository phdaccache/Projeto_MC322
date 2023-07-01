package arquivos;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import sistema.*;

public class Carregar {
    public static void carregarDados() {
        ArrayList<Biblioteca> listaBiblioteca = new ArrayList<>();
        ArquivoBiblioteca arquivoBiblioteca = new ArquivoBiblioteca();
        ArquivoEstudante arquivoEstudante = new ArquivoEstudante();
        ArquivoProfessor arquivoProfessor = new ArquivoProfessor();

        ArquivoLivro arquivoLivro = new ArquivoLivro();
        ArquivoArtigo arquivoArtigo = new ArquivoArtigo();
        ArquivoApostila arquivoApostila = new ArquivoApostila();
        ArquivoRevista arquivoRevista = new ArquivoRevista();

        ArquivoEmprestimo arquivoEmprestimo = new ArquivoEmprestimo();
        ArquivoReserva arquivoReserva = new ArquivoReserva();

        try {
            System.out.println(arquivoBiblioteca.LerDados(listaBiblioteca));
            for(int i = 0; i < listaBiblioteca.size(); i++){

                Admin.cadastrarBiblioteca(listaBiblioteca.get(i).getNome(), listaBiblioteca.get(i).getCNPJ(), listaBiblioteca.get(i).getEndereco(), listaBiblioteca.get(i).getTelefone(), listaBiblioteca.get(i).getSenha());


                ArrayList<Cliente> listaClientes = new ArrayList<>();
                ArrayList<Item> listaItens = new ArrayList<>();

                ArrayList<Estudante> listaEstudantes = listaBiblioteca.get(i).getEstudantes();
                ArrayList<Professor> listaProfessores = listaBiblioteca.get(i).getProfessores();
                ArrayList<Livro> listaLivros = listaBiblioteca.get(i).getLivros();
                ArrayList<Revista> listaRevistas = listaBiblioteca.get(i).getRevistas();
                ArrayList<Artigo> listaArtigos = listaBiblioteca.get(i).getArtigos();
                ArrayList<Apostila> listaApostilas = listaBiblioteca.get(i).getApostilas();
                ArrayList<Emprestimo> listaEmprestimos = listaBiblioteca.get(i).getEmprestimos();
                ArrayList<Reserva> listaReservas = listaBiblioteca.get(i).getReservas();

                //Leitura dos dados .csv
                System.out.println(arquivoEstudante.LerDados(listaEstudantes));
                System.out.println(arquivoProfessor.LerDados(listaProfessores));
                System.out.println(arquivoLivro.LerDados(listaLivros));
                System.out.println(arquivoRevista.LerDados(listaRevistas));
                System.out.println(arquivoArtigo.LerDados(listaArtigos));
                System.out.println(arquivoApostila.LerDados(listaApostilas));

                //Coloca os dados lidos em uma lista só
                listaClientes.addAll(listaEstudantes);
                listaClientes.addAll(listaProfessores);
                listaItens.addAll(listaLivros);
                listaItens.addAll(listaRevistas);
                listaItens.addAll(listaArtigos);
                listaItens.addAll(listaApostilas);

                Admin.getBiblioteca(listaBiblioteca.get(i).getCNPJ()).setClientes(listaClientes);
                Admin.getBiblioteca(listaBiblioteca.get(i).getCNPJ()).setItens(listaItens);


                System.out.println(arquivoEmprestimo.LerDados(listaEmprestimos));
                System.out.println(arquivoReserva.LerDados(listaReservas));
                //Finaliza colocando os emprestimos e reservas na biblioteca

                Admin.getBiblioteca(listaBiblioteca.get(i).getCNPJ()).setEmprestimos(listaEmprestimos);
                Admin.getBiblioteca(listaBiblioteca.get(i).getCNPJ()).setReservas(listaReservas);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch(NumberFormatException e){
            throw new RuntimeException(e);
        }
    }
}