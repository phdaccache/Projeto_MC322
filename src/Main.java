import javax.swing.*;

import gui.frames.*;
import pacote.Arquivos;
import pacote.Biblioteca;

import java.util.ArrayList;

import static pacote.Arquivos.GravarDadosBiblioteca;

public class Main {
	private JFrame FrameMain;
	
    public static void main(String[] args) throws Exception {
		ArrayList<Biblioteca> listaBiblioteca = new ArrayList<Biblioteca>();
		Biblioteca b1 = new Biblioteca("Biblioteca", "81277798000115", "Rua 11", "(00) 00000-0000", null, null, null, null, "123");
		Biblioteca b2 = new Biblioteca("Bibliotecaa", "22475123000111", "Rua 11", "(00) 00000-0000", null, null, null, null, "123");
		listaBiblioteca.add(b1);
		listaBiblioteca.add(b2);
		System.out.println(GravarDadosBiblioteca(listaBiblioteca));
    	System.setProperty("sun.java2d.uiScale", "2");
		Main window = new Main();
		window.FrameMain.setVisible(true);
		window.FrameMain.toFront();
		window.FrameMain.requestFocus();
    }
    
    public Main() {
		FrameMain = new FrameMain();
	}
}