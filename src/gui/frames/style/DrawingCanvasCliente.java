package gui.frames.style;

import java.awt.*;
import javax.swing.*;

public class DrawingCanvasCliente extends JPanel {
	private static final long serialVersionUID = 1L;
	Font font = new Font("Dialog", Font.BOLD, 40);
	FontMetrics fontMetrics;
	  
	public DrawingCanvasCliente() {
		setSize(600, 200);
	    setBackground(Color.white);
	    fontMetrics = getFontMetrics(font);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
	
	    g2D.setFont(font);
	    GradientPaint gp = new GradientPaint(
	                            370, 100,
	                            MyColors.PRIMARY,
	                            fontMetrics.stringWidth("Cliente"),
	                            fontMetrics.getHeight(),
	                            MyColors.ACCENT);             
	    g2D.setPaint(gp);
	    g2D.drawString("Cliente",230,140);
	}
}