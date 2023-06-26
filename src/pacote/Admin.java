package pacote;

import java.util.ArrayList;
import java.time.LocalDate;

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
    public LocalDate Avancatempo(int dias) {
	    try {
	        if (dias <= 0) {
	            throw new IllegalArgumentException("O número de dias deve ser positivo");
	        }
	        System.out.println("teste");
	        // Resto do código para avançar o tempo
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
    public void listarBibliotecas() {
    	try {
	        if (this.bibliotecas == null) {
	            throw new IllegalArgumentException("Lista vazia!");
	        }
        for(Biblioteca b : bibliotecas){
            System.out.println("**********");
            System.out.println(b.toString());
            System.out.println("**********");
        }
    	} catch (IllegalArgumentException e) {
	        System.out.println("Erro: " + e.getMessage());
            return;
 	    }
    }


    
}
