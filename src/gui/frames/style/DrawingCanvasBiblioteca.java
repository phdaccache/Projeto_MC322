package gui.frames.style;

import java.awt.*;
import javax.swing.*;

public class DrawingCanvasBiblioteca extends JPanel {
	private static final long serialVersionUID = 1L;
	Font font = new Font("Dialog", Font.BOLD, 40);
	FontMetrics fontMetrics;
	  
	public DrawingCanvasBiblioteca() {
		setSize(600, 200);
	    setBackground(Color.white);
	    fontMetrics = getFontMetrics(font);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
	
	    g2D.setFont(font);
	    GradientPaint gp = new GradientPaint(
	                            370, 100,
	                            MyColor.PRIMARY,
	                            fontMetrics.stringWidth("Biblioteca"),
	                            fontMetrics.getHeight(),
	                            MyColor.ACCENT);             
	    g2D.setPaint(gp);
	    g2D.drawString("Biblioteca",205,140);
	}
}