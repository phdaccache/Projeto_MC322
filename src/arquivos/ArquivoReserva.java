package arquivos;

import sistema.Admin;
import sistema.Reserva;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ArquivoReserva implements Arquivo<Reserva>{
    @Override
    public String GravarDados(ArrayList<Reserva> lista) {
        return null;
    }

    @Override
    public String LerDados(ArrayList<Reserva> lista) throws IOException {
        File file = new File("src/arquivos/Bibliotecas_arquivos/Reservas.csv"); //Mudar para ser acessada por qualquer usuário

        String demilitador = ",";
        ArrayList<String[]> linhas = new ArrayList<>();
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linha = br.readLine();

            while (linha != null) {
                if (linha.equals("CNPJ_BIBLIOTECA,CODE_ITEM,DATA,CODE_CLIENTE,CODE,POSICAO")) {
                    linha = br.readLine();
                    continue;
                }

                String[] campos = linha.split(demilitador);
                linhas.add(campos);
                lista.add(new Reserva(Admin.getBiblioteca(campos[0]), Admin.getBiblioteca(campos[0]).getItem(campos[1]), LocalDate.parse(campos[2]), Admin.getBiblioteca(campos[0]).getCliente(campos[5]), Integer.parseInt(campos[6]), Integer.parseInt(campos[7])));
                linha = br.readLine();
        }
            br.close();
            return "Reservas carregadas com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}
