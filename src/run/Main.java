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
		// ThreadGravarArquivos thread = new ThreadGravarArquivos();
		// Runtime.getRuntime().addShutdownHook(new Thread(() -> {
		// 	thread.start();
		// 	try {
		// 		thread.join();
		// 	} catch (InterruptedException e) {
		// 		e.printStackTrace();
		// 	}
		// }));
	}
    
    public Main() {
		FrameMain = new FrameMain();
	}
}