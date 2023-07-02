package arquivos;

import sistema.Item;
import sistema.Livro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArquivoItem {
    public String GravarDados(ArrayList<Item> lista) throws IOException {
        File file = new File("src/arquivos/ArquivosCSV/Itens.csv");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fileWriter);
        pw.println("CODE,QUANTIDADE,STATUS,TITULO,AUTOR,ANO,CLASSE");
        for (Item item : lista) {
            if(item instanceof Livro){
                pw.println(item.getCode() + "," + item.getQuantidade() + "," + item.getStatus() + "," + item.getTitulo() + "," + item.getAutor() + "," + item.getAno() + "," + "Livro");
            }
            else{
                pw.println(item.getCode() + "," + item.getQuantidade() + "," + item.getStatus() + "," + item.getTitulo() + "," + item.getAutor() + "," + item.getAno() + "," + "Revista");
            }
        }
        fileWriter.close();
        return "Itens salvos com sucesso!";
    }
}
