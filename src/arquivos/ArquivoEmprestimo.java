package arquivos;

import sistema.Admin;
import sistema.Emprestimo;
import sistema.Estudante;
import sistema.Reserva;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArquivoEmprestimo implements Arquivo<Emprestimo>{
    @Override
    public String GravarDados(ArrayList<Emprestimo> lista) throws IOException {
        File file = new File("src/arquivos/ArquivosCSV/Emprestimos.csv");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fileWriter);
        pw.println("CNPJ_BIBLIOTECA,TITULO_ITEM,STATUS,DATA_INI,DATA_FIM,CPF_CLIENTE,CODE_EMPRESTIMO");
        for (Emprestimo emprestimo : lista) {
            pw.println(emprestimo.getBiblioteca().getCNPJ() + "," + emprestimo.getItem().getTitulo() + "," + emprestimo.getStatus() + "," + emprestimo.getData_ini() + "," + emprestimo.getData_fim() + "," + emprestimo.getCliente().getCPF() + "," + emprestimo.getCode());
        }
        fileWriter.close();
        return "Emprestimos salvos com sucesso!";
    }

    @Override
    public String LerDados(ArrayList<Emprestimo> lista) throws IOException {

        File file = new File("src/arquivos/ArquivosCSV/Emprestimos.csv"); //Mudar para ser acessada por qualquer usuário

        String demilitador = ",";
        ArrayList<String[]> linhas = new ArrayList<>();
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linha = br.readLine();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            while (linha != null) {
                if (linha.equals("CNPJ_BIBLIOTECA,TITULO_ITEM,STATUS,DATA_INI,DATA_FIM,CPF_CLIENTE,CODE_EMPRESTIMO")) {
                    linha = br.readLine();
                    continue;
                }

                String[] campos = linha.split(demilitador);
                linhas.add(campos);
                Emprestimo emprestimo = new Emprestimo(Admin.getBiblioteca(campos[0]), Admin.getBiblioteca(campos[0]).getItem(campos[1]), LocalDate.parse(campos[3], dtf), LocalDate.parse(campos[4], dtf), Admin.getBiblioteca(campos[0]).getCliente(campos[5]), campos[2], Integer.parseInt(campos[6]));
                ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>();
                Admin.getBiblioteca(campos[0]).getCliente(campos[5]).setListaEmprestimos(listaEmprestimos);
                Admin.getBiblioteca(campos[0]).getCliente(campos[5]).getListaEmprestimos().add(emprestimo);
                lista.add(emprestimo);
                linha = br.readLine();
            }
            br.close();
            return "Emprestimos carregados com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}
