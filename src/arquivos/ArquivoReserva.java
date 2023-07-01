package arquivos;

import sistema.Admin;
import sistema.Emprestimo;
import sistema.Reserva;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArquivoReserva implements Arquivo<Reserva>{
    @Override
    public String GravarDados(ArrayList<Reserva> lista) throws IOException {
        File file = new File("src/arquivos/ArquivosCSV/Reservas1.csv");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fileWriter);
        pw.println("CNPJ_BIBLIOTECA,TITULO_ITEM,DATA,CODE_CLIENTE,CODE,POSICAO");
        return null;
    }

    @Override
    public String LerDados(ArrayList<Reserva> lista) throws IOException {
        File file = new File("src/arquivos/ArquivosCSV/Reservas.csv"); //Mudar para ser acessada por qualquer usuário

        String demilitador = ",";
        ArrayList<String[]> linhas = new ArrayList<>();
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linha = br.readLine();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            while (linha != null) {
                if (linha.equals("CNPJ_BIBLIOTECA,TITULO_ITEM,DATA,CODE_CLIENTE,CODE,POSICAO")) {
                    linha = br.readLine();
                    continue;
                }
                String[] campos = linha.split(demilitador);
                linhas.add(campos);
                lista.add(new Reserva(Admin.getBiblioteca(campos[0]), Admin.getBiblioteca(campos[0]).getItem(campos[1]), LocalDate.parse(campos[2], dtf), Admin.getBiblioteca(campos[0]).getCliente(campos[4]), Integer.parseInt(campos[5])));
                linha = br.readLine();
            }
            br.close();
            return "Reservas carregadas com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}

