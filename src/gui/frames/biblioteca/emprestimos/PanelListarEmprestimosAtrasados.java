package gui.frames.biblioteca.emprestimos;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import gui.frames.style.MyColors;

public class PanelListarEmprestimosAtrasados extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel iconX;
	
	public PanelListarEmprestimosAtrasados() {
		setBounds(0, 0, 346, 396);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("EMPRÉSTIMOS ATRASADOS");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 45, 326, 60);
		add(lblNewLabel);
		
		iconX = new JLabel("X");
		iconX.setOpaque(true);
		iconX.setBackground(MyColors.SECONDARY_BACKGROUND);
		iconX.setForeground(MyColors.PRIMARY);
		iconX.setHorizontalTextPosition(SwingConstants.CENTER);
		iconX.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
		iconX.setHorizontalAlignment(SwingConstants.CENTER);
		iconX.setBounds(316, 0, 30, 25);
		iconX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int confirmation = JOptionPane.showConfirmDialog(null, "Encerrar Programa?", "Confirmation", JOptionPane.WARNING_MESSAGE);
				if(confirmation == 0) {
					System.exit(0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				iconX.setBackground(MyColors.CLOSE);
				iconX.setForeground(MyColors.BACKGROUND);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				iconX.setBackground(MyColors.SECONDARY_BACKGROUND);
				iconX.setForeground(MyColors.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				iconX.setBackground(MyColors.SECONDARY_CLOSE);
				iconX.setForeground(MyColors.BACKGROUND);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				iconX.setBackground(MyColors.CLOSE);
				iconX.setForeground(MyColors.BACKGROUND);
			}
		});
		add(iconX);
	}
}