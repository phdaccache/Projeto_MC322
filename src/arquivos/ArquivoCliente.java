package arquivos;

import sistema.Cliente;
import sistema.Estudante;
import sistema.Livro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArquivoCliente {
    public String GravarDados(ArrayList<Cliente> lista) throws IOException {
        File file = new File("src/arquivos/ArquivosCSV/Clientes.csv");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fileWriter);
        pw.println("BIBLIOTECA_CNPJ,CPF,MULTA,NOME,TELEFONE,EMAIL,DATANASC,SENHA,ASSINATURA,STATUS,CLASSE");
        for (Cliente cliente : lista) {
            if(cliente instanceof Estudante){
                pw.println(cliente.getBiblioteca().getCNPJ() + "," + cliente.getCPF() + "," + cliente.getMulta() + "," + cliente.getNome() + "," + cliente.getTelefone() + "," + cliente.getEmail() + "," + cliente.getDataNasc() + "," + cliente.getSenha() + "," + cliente.getAssinatura() + "," + cliente.getStatus() + "," + "Estudante");
            }
            else{
                pw.println(cliente.getBiblioteca().getCNPJ() + "," + cliente.getCPF() + "," + cliente.getMulta() + "," + cliente.getNome() + "," + cliente.getTelefone() + "," + cliente.getEmail() + "," + cliente.getDataNasc() + "," + cliente.getSenha() + "," + cliente.getAssinatura() + "," + cliente.getStatus() + "," + "Professor");
            }
        }
        fileWriter.close();
        return "Clientes salvos com sucesso!";
    }
}
