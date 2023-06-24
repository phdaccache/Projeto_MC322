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
        return null;
    }
    public void CadastraBiblioteca(Biblioteca biblioteca) {
    }
    public void RemoveBiblioteca(Biblioteca biblioteca) {
    }
    public void listarBibliotecas() {
    }

    
}
