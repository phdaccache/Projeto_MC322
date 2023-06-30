package arquivos;

import java.util.ArrayList;

public interface Arquivo<T> {
    public String GravarDados(ArrayList<T> lista);
    public String LerDados(ArrayList<T> lista);

}
