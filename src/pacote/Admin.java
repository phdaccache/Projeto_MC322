package pacote;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;

public class Admin {
    private ArrayList<Biblioteca> bibliotecas;
    private static LocalDate data; // Data atual do sistema

    //Construtor
    public Admin(ArrayList<Biblioteca> bibliotecas, LocalDate data) {
        this.bibliotecas = bibliotecas;
        this.data = data;
    }

    //Getters e setters
    public ArrayList<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }
    public void setBibliotecas(ArrayList<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }
    public static LocalDate getData() {
    	return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    //Metodos
    public String Avancatempo(int dias) {
	    try {
	        if (dias <= 0) {
	            throw new IllegalArgumentException("O número de dias deve ser positivo");
	        }
	        // Resto do código para avançar o tempo
            setData(getData().plusDays(dias));
	        //AtualizarClientes();
	        //AtualizarEmprestimos();
	        //AtualizarReservas();
	        //AtualizarBibliotecas();
	        //AtualizarItens();     
	    } catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
	    }

        return null;
    }
    public void CadastraBiblioteca(Biblioteca biblioteca) {
    	try {
	        if (this.bibliotecas == null) {
	            throw new IllegalArgumentException();
	        }
    	for(Biblioteca b : this.bibliotecas){
            if(b.getNome().equals(biblioteca.getNome())){
                System.out.println("Biblioteca já cadastrada");
                return;
            }
            else{
            	this.bibliotecas.add(biblioteca);
                System.out.println("Biblioteca cadastrada com sucesso");
                return;
            }
        }
    	} catch (IllegalArgumentException e) {
        	this.bibliotecas = new ArrayList<>();
 	        this.bibliotecas.add(biblioteca);
            System.out.println("Biblioteca cadastrada com sucesso");
            return;
 	    }
    }
    public void RemoveBiblioteca(Biblioteca biblioteca) {
    	try {
	        if (this.bibliotecas == null) {
	            throw new IllegalArgumentException("Lista vazia!");
	        }
        for(Biblioteca b : bibliotecas){
            if(b.getNome().equals(biblioteca.getNome())){
                bibliotecas.remove(biblioteca);
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
    public ArrayList<String> listarBibliotecas() {
    	try {
	        if (this.bibliotecas == null) {
	            throw new IllegalArgumentException("Lista vazia!");
	        }
        for(Biblioteca b : this.bibliotecas){
            //System.out.println("**********");
        	ArrayList<String> listaExemplo = new ArrayList<>();
        	listaExemplo.add(b.toString());
            return listaExemplo;
            //System.out.println("**********");
        }
    	} catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
            return null;
 	    }
		return null;
    }
    public void AtualizarEmprestimos(int dias){
        for(Biblioteca biblioteca : this.bibliotecas){
            for(Emprestimo emprestimo : biblioteca.getEmprestimos()){
                if(emprestimo.getDataLim().isBefore(getData())){
                    //O livro não está atrasado
                }
                else{
                    //O livro está atrasado
                    if(numeroAleatório() >= 5){ // Pelo número aleatório
                        emprestimo.setStatus(false);
                    }
                }
            }
        }
    }

    public int numeroAleatório(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(11); // Gera um número aleatório de 0 a 10
        return numeroAleatorio;
    }


    
}
