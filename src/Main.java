import javax.swing.*;

import gui.frames.*;
import pacote.Arquivos;

public class Main {
	private JFrame FrameMain;
	
    public static void main(String[] args) throws Exception {
    	Arquivos teste = new Arquivos();
    	System.out.println(teste);
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