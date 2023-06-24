package pacote;

import java.util.ArrayList;
import java.util.Date;

public class Admin {
    private ArrayList<Biblioteca> bibliotecas;
    private Date data;

    //Construtor
    public Admin(ArrayList<Biblioteca> bibliotecas, Date data) {
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

    //Metodos
    public Date Avancatempo(int dias) {
        //AtualizarClientes();
        //AtualizarEmprestimos();
        //AtualizarReservas();
        //AtualizarBibliotecas();
        //AtualizarItens();
        return null;
    }
    public void CadastraBiblioteca(Biblioteca biblioteca) {
        for(Biblioteca b : bibliotecas){
            if(b.getNome().equals(biblioteca.getNome())){
                System.out.println("Biblioteca já cadastrada");
                return;
            }
            else{
                bibliotecas.add(biblioteca);
                System.out.println("Biblioteca cadastrada com sucesso");
                return;
            }
        }
    }
    public void RemoveBiblioteca(Biblioteca biblioteca) {
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
    }
    public void listarBibliotecas() {
        for(Biblioteca b : bibliotecas){
            System.out.println("**********");
            System.out.println(b.toString());
            System.out.println("**********");
        }
    }

    
}
