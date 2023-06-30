package sistema;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;

public class Admin {
    // Atributos
    public static ArrayList<Biblioteca> listaBibliotecas = new ArrayList<>();
    public static LocalDate data = LocalDate.now(); // Data atual do sistema

    public static String listarBibliotecas() {
        String string = "";
        if (listaBibliotecas == null || listaBibliotecas.isEmpty()) {
            string += "Nao há bibliotecas cadastradas.\n";
        } else {
            for(Biblioteca biblioteca : listaBibliotecas){
                string += (biblioteca + "\n");
                string += "---------------------------------------------\n";
            }
        }

        return string;
    }

    public static String cadastrarBiblioteca(String nome, String cnpj, String endereco, String telefone, String senha) {
        // Caso em que o CNPJ e invalido
        if (!Validacao.validarDocumento(cnpj, "CNPJ")) {
            throw new IllegalArgumentException("CNPJ invalido");
        }

        // Caso em que o CNPJ ja existe
        for (Biblioteca biblioteca : listaBibliotecas) {
            if (biblioteca.getCNPJ().equals(cnpj)) {
                throw new IllegalArgumentException("Ja existe a biblioteca de CNPJ " + cnpj);
            }
        }

        // Cadastro da biblioteca
        Biblioteca biblioteca = new Biblioteca(nome, cnpj, endereco, telefone, senha);
        listaBibliotecas.add(biblioteca);
        return "Biblioteca cadastrada!\n";
    }

    public static String excluirBiblioteca(String cnpj) {
        // Checar se a biblioteca existe antes de excluir
        for (Biblioteca biblioteca : listaBibliotecas) {
            if (biblioteca.getCNPJ().equals(cnpj)) {
                listaBibliotecas.remove(biblioteca);
                return String.format("Biblioteca '%s' de CNPJ %s removida!", biblioteca.getNome(), cnpj);
            }
        }

        throw new IllegalArgumentException("Nao existe a biblioteca de CNPJ " + cnpj);
    }

    public static String avancarTempo(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("O número de dias deve ser positivo");
        }
        // Avancar tempo
        data = data.plusDays(dias);
        atualizarEmprestimos(dias);
        return String.format("Tempo avançado em %d dias!", dias);
    }

    public static void atualizarEmprestimos(int dias){
        for(Biblioteca biblioteca : listaBibliotecas){
            for(Emprestimo emprestimo : biblioteca.getEmprestimos()){
                if(emprestimo.getData_fim().isBefore(data)){
                    //O item não está atrasado
                }
                else{
                    //O item está atrasado
                    if(numeroAleatorio() >= 5){ // Pelo número aleatório será definido se o cliente devolve ou não o item
                        emprestimo.getItem().setStatus("atrasado");
                        emprestimo.getCliente().setMulta(dias*10); // A cada dia, recebe 10 reais de multa
                        emprestimo.setStatus("Atrasado");
                    }//item foi entregue a tempo
                    else{
                        if(emprestimo.getItem().getListaReservas().size() > 1){
                            //Seta como disponivel para fazer emprestimo
                            emprestimo.getItem().setStatus("disponivel");
                            //Faz emprestimo com o cliente na lista de reservas
                            emprestimo.getItem().getListaReservas().get(0).getCliente().fazerEmprestimo(emprestimo.getItem().getTitulo());
                            //Seta como emprestado novamente
                            emprestimo.getItem().setStatus("reservado");
                            //Remove o cliente da lista de reservas
                            emprestimo.getCliente().RemoverReserva(emprestimo.getItem().getTitulo());
                            //Devolve o emprestimo, finalizando a operação
                            emprestimo.getCliente().DevolverEmprestimo(emprestimo.getItem().getTitulo());

                        }
                        else if(emprestimo.getItem().getListaReservas().size() == 1){
                            //Seta como disponivel para fazer emprestimo
                            emprestimo.getItem().setStatus("disponivel.");
                            //Faz emprestimo com o cliente na lista de reservas
                            emprestimo.getItem().getListaReservas().get(0).getCliente().fazerEmprestimo(emprestimo.getItem().getTitulo());
                            //Seta como emprestado novamente, dado que não há reservas
                            emprestimo.getItem().setStatus("emprestado");
                            //Devolve o emprestimo original.
                            emprestimo.getCliente().DevolverEmprestimo(emprestimo.getItem().getTitulo());
                        }
                        else{
                            //Apenas devolve o emprestimo
                            emprestimo.getCliente().DevolverEmprestimo(emprestimo.getItem().getTitulo());
                        }
                    }
                }
            }
        }
    }


    public static int numeroAleatorio(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(11); // Gera um número aleatório de 0 a 10
        return numeroAleatorio;
    }
}