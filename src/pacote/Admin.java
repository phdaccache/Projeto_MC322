package pacote;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;

public class Admin {
    // Atributos
    public static ArrayList<Biblioteca> listaBibliotecas = new ArrayList<>();
    public static LocalDate data; // Data atual do sistema

    public static String Avancatempo(int dias) {
	    try {
	        if (dias <= 0) {
	            throw new IllegalArgumentException("O número de dias deve ser positivo");
	        }
	        // Resto do código para avançar o tempo
            data = data.plusDays(dias);
            AtualizarEmprestimos(dias);

	    } catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
	    }

        return null;
    }

    public static String CadastrarBiblioteca(String nome, String CNPJ, String endereco, String telefone, ArrayList<Item> itens, ArrayList<Cliente> clientes, ArrayList<Emprestimo> emprestimos, ArrayList<Reserva> reservas, String senha) {
    	        try {
            if (nome == null || CNPJ == null || endereco == null || telefone == null || itens == null || clientes == null || emprestimos == null || reservas == null) {
                throw new IllegalArgumentException("Argumento nulo!");
            }
            // Resto do código para criar uma biblioteca
            Biblioteca biblioteca = new Biblioteca(nome, CNPJ, endereco, telefone, senha);
            listaBibliotecas.add(biblioteca);
            System.out.println("Biblioteca criada com sucesso");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

    public static void ExcluirBiblioteca(Biblioteca biblioteca) {
    	try {
	        if (listaBibliotecas == null) {
	            throw new IllegalArgumentException("Lista vazia!");
	        }
        for(Biblioteca b : listaBibliotecas){
            if(b.getNome().equals(biblioteca.getNome())){
                listaBibliotecas.remove(biblioteca);
                System.out.println("Biblioteca removida com sucesso");
                return;
            }
            else{
                System.out.println("Biblioteca não encontrada");
                return;
            }
        } 
    	} catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
            return;
 	    }
    }

    public static ArrayList<String> listarBibliotecas() {
    	try {
            if (listaBibliotecas == null || listaBibliotecas.isEmpty()) {
                throw new IllegalArgumentException("Lista vazia!");
            } else {
                ArrayList<String> listaExemplo = new ArrayList<>();
                for(Biblioteca b : listaBibliotecas){
                    listaExemplo.add(b.toString());
                }
                return listaExemplo;
            }
    	} catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
            return null;
 	    }
    }
    public static void AtualizarEmprestimos(int dias){
        for(Biblioteca biblioteca : listaBibliotecas){
            for(Emprestimo emprestimo : biblioteca.getEmprestimos()){
                if(emprestimo.getData_fim().isBefore(data)){
                    //O item não está atrasado
                }
                else{
                    //O item está atrasado
                    if(numeroAleatório() >= 5){ // Pelo número aleatório será definido se o cliente devolve ou não o item
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


    public static int numeroAleatório(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(11); // Gera um número aleatório de 0 a 10
        return numeroAleatorio;
    }


    
}
