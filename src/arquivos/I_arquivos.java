package arquivos;
import sistema.Biblioteca;

import java.util.ArrayList;

public interface I_arquivos<T> {
    public String GravarDados(ArrayList<T> lista);
    public String LerDados(ArrayList<T> lista);

}
