package arquivos;

import sistema.Admin;
import sistema.Reserva;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArquivoReserva implements Arquivo<Reserva>{
    @Override
    public String GravarDados(ArrayList<Reserva> lista) throws IOException {
        File file = new File("src/arquivos/ArquivosCSV/Reservas.csv");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fileWriter);
        pw.println("CNPJ_BIBLIOTECA,TITULO_ITEM,DATA,CPF_CLIENTE,CODE,POSICAO");
        for (Reserva reserva : lista) {
            pw.println(reserva.getBiblioteca().getCNPJ() + "," + reserva.getItem().getTitulo() + "," + reserva.getData() + "," + reserva.getCliente().getCPF() + "," + reserva.getCode() + "," + reserva.getPosicao());
        }
        fileWriter.close();
        return "Reservas salvas com sucesso!";
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
                if (linha.equals("CNPJ_BIBLIOTECA,TITULO_ITEM,DATA,CPF_CLIENTE,CODE,POSICAO")) {
                    linha = br.readLine();
                    continue;
                }
                String[] campos = linha.split(demilitador);
                linhas.add(campos);
                Reserva reserva = new Reserva(Admin.getBiblioteca(campos[0]), Admin.getBiblioteca(campos[0]).getItem(campos[1]), LocalDate.parse(campos[2], dtf), Admin.getBiblioteca(campos[0]).getCliente(campos[3]), Integer.parseInt(campos[5]));
                ArrayList<Reserva> listaReserva = new ArrayList<>();
                Admin.getBiblioteca(campos[0]).getCliente(campos[3]).setListaReservasItens(listaReserva);
                Admin.getBiblioteca(campos[0]).getCliente(campos[3]).getListaReservasItens().add(reserva);
                lista.add(reserva);
                linha = br.readLine();
            }
            br.close();
            return "Reservas carregadas com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}

