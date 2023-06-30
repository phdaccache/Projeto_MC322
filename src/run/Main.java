package run;
import javax.swing.*;

import gui.frames.*;

public class Main {
	private JFrame FrameMain;
	public static void main(String[] args) throws Exception {
		// Duplicando a escala da tela
		System.setProperty("sun.java2d.uiScale", "2");

		// Rodando o programa
		Main window = new Main();
		window.FrameMain.setVisible(true);
		window.FrameMain.toFront();
		window.FrameMain.requestFocus();

		// Rodando uma segunda thread para gravar os dados apos a execucao do programa
		ThreadGravarArquivos thread = new ThreadGravarArquivos();
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}));

		// ArrayList<Biblioteca> listaBiblioteca = new ArrayList<Biblioteca>();
		// Biblioteca b1 = new Biblioteca("Biblioteca", "81277798000115", "Rua 11", "(00) 00000-0000", null, null, null, null, "123");
		// Biblioteca b2 = new Biblioteca("Bibliotecaa", "22475123000111", "Rua 11", "(00) 00000-0000", null, null, null, null, "123");
		// listaBiblioteca.add(b1);
		// listaBiblioteca.add(b2);
		// System.out.println(GravarDadosBiblioteca(listaBiblioteca));
	}
    
    public Main() {
		FrameMain = new FrameMain();
	}
}