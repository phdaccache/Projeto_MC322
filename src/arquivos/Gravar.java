package arquivos;
import sistema.Admin;
public class Gravar {
    public static void gravarDados() {
        ArquivoLivro arquivoLivro = new ArquivoLivro();
        ArquivoArtigo arquivoArtigo = new ArquivoArtigo();
        ArquivoApostila arquivoApostila = new ArquivoApostila();
        ArquivoRevista arquivoRevista = new ArquivoRevista();
        ArquivoProfessor arquivoProfessor = new ArquivoProfessor();
        ArquivoEstudante arquivoEstudante = new ArquivoEstudante();
        ArquivoEmprestimo arquivoEmprestimo = new ArquivoEmprestimo();
        ArquivoReserva arquivoReserva = new ArquivoReserva();

        arquivoReserva.GravarDados(Admin.getReservas());
        return;
    }
}
