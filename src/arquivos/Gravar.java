package arquivos;
import sistema.Admin;
import sistema.Biblioteca;

import java.io.IOException;

public class Gravar {
    public static void gravarDados() throws IOException {
        ArquivoLivro arquivoLivro = new ArquivoLivro();
        ArquivoArtigo arquivoArtigo = new ArquivoArtigo();
        ArquivoApostila arquivoApostila = new ArquivoApostila();
        ArquivoRevista arquivoRevista = new ArquivoRevista();
        ArquivoItem arquivoItem = new ArquivoItem();

        ArquivoProfessor arquivoProfessor = new ArquivoProfessor();
        ArquivoEstudante arquivoEstudante = new ArquivoEstudante();
        ArquivoCliente arquivoCliente = new ArquivoCliente();

        ArquivoEmprestimo arquivoEmprestimo = new ArquivoEmprestimo();
        ArquivoReserva arquivoReserva = new ArquivoReserva();
        ArquivoBiblioteca arquivoBiblioteca = new ArquivoBiblioteca();

        for(Biblioteca biblioteca : Admin.listaBibliotecas){
            arquivoReserva.GravarDados(biblioteca.getReservas());
            arquivoEmprestimo.GravarDados(biblioteca.getEmprestimos());
            arquivoCliente.GravarDados(biblioteca.getClientes());
            arquivoItem.GravarDados(biblioteca.getItens());
            arquivoLivro.GravarDados(biblioteca.getLivros());
            arquivoArtigo.GravarDados(biblioteca.getArtigos());
            arquivoApostila.GravarDados(biblioteca.getApostilas());
            arquivoRevista.GravarDados(biblioteca.getRevistas());
            arquivoProfessor.GravarDados(biblioteca.getProfessores());
            arquivoEstudante.GravarDados(biblioteca.getEstudantes());
            arquivoBiblioteca.GravarDados(Admin.listaBibliotecas);
        }
        return;
    }
}
