package gui.frames.biblioteca.minhaConta;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import gui.frames.biblioteca.FrameLoginBiblioteca;
import gui.frames.style.MyColors;
import sistema.Biblioteca;

public class PanelExcluirConta extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel iconX;
	
	public PanelExcluirConta(Biblioteca biblioteca, JFrame frameMinhaConta) {
		setBounds(0, 0, 346, 396);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("EXCLUIR CONTA");
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

		JLabel lblConfirmacao = new JLabel("Deseja realmente excluir sua conta?");
		lblConfirmacao.setFont(new Font("Dialog", Font.BOLD, 15));
		lblConfirmacao.setForeground(Color.red);
		lblConfirmacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmacao.setBounds(10, 150, 326, 60);
		add(lblConfirmacao);

		JPanel pnlExcluirBtn = new JPanel();
		pnlExcluirBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String message = biblioteca.excluirConta();
					int confirmation = JOptionPane.showConfirmDialog(null, message, "Confirmação", JOptionPane.DEFAULT_OPTION);
					if(confirmation == 0) {
						frameMinhaConta.dispose();
						JFrame frame = new FrameLoginBiblioteca();
						frame.setVisible(true);
						frame.toFront();
						frame.requestFocus();
					}
				} catch (IllegalArgumentException error) {
					JOptionPane.showMessageDialog(null, error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlExcluirBtn.setBackground(MyColors.ACCENT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlExcluirBtn.setBackground(MyColors.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlExcluirBtn.setBackground(MyColors.SECONDARY_ACCENT);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlExcluirBtn.setBackground(MyColors.ACCENT);
			}
		});
		pnlExcluirBtn.setBackground(MyColors.PRIMARY);
		pnlExcluirBtn.setBounds(53, 290, 240, 40);
		add(pnlExcluirBtn);
		pnlExcluirBtn.setLayout(null);
		
		JLabel lblExcluir = new JLabel("EXCLUIR");
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setForeground(MyColors.BACKGROUND);
		lblExcluir.setFont(new Font("Arial", Font.BOLD, 14));
		lblExcluir.setBounds(0, 5, 250, 30);
		pnlExcluirBtn.add(lblExcluir);
	}
}