package arquivos;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface Arquivo<T> {
    public String GravarDados(ArrayList<T> lista) throws IOException;
    public String LerDados(ArrayList<T> lista) throws IOException, ParseException;

}
