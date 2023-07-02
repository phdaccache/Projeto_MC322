package gui.frames.cliente.emprestimos;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

import gui.frames.style.MyColors;
import sistema.Cliente;
import sistema.Emprestimo;
import sistema.Item;

public class PanelRenovarEmprestimo extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel iconX;
	
	public PanelRenovarEmprestimo(Cliente cliente, JFrame frameEmprestimos) {
		setBounds(0, 0, 346, 396);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("RENOVAR EMPRÉSTIMO");
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
		
		///////////////////////// Input 1 /////////////////////////

		JPanel pnlInput1 = new JPanel();
		pnlInput1.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput1.setBackground(MyColors.BACKGROUND);
		pnlInput1.setBounds(115, 125, 115, 25);
		add(pnlInput1);
		pnlInput1.setLayout(null);

		ArrayList<Item> itens = cliente.getBiblioteca().getItens();
		String[] titulos = new String[itens.size()];
		for (int i = 0; i < itens.size(); i++) {
			for (Emprestimo emprestimo : cliente.getListaEmprestimos()) {
				if (emprestimo.getItem().getTitulo().equals(itens.get(i).getTitulo())) {
					titulos[i] = itens.get(i).getTitulo();
				}
			}
		}
		JComboBox<String> comboBox = new JComboBox<String>(titulos);
		comboBox.setBounds(0, 0, 115, 25);
		pnlInput1.add(comboBox);

		JPanel pnlRenovarBtn = new JPanel();
		pnlRenovarBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String titulo = (String)comboBox.getSelectedItem();
					String message = cliente.renovarEmprestimo(titulo);
					int confirmation = JOptionPane.showConfirmDialog(null, message, "Confirmação", JOptionPane.DEFAULT_OPTION);
					if(confirmation == 0) {
						frameEmprestimos.dispose();
						JFrame frame = new FrameEmprestimos(cliente);
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
				pnlRenovarBtn.setBackground(MyColors.ACCENT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlRenovarBtn.setBackground(MyColors.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlRenovarBtn.setBackground(MyColors.SECONDARY_ACCENT);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlRenovarBtn.setBackground(MyColors.ACCENT);
			}
		});
		pnlRenovarBtn.setBackground(MyColors.PRIMARY);
		pnlRenovarBtn.setBounds(53, 290, 240, 40);
		add(pnlRenovarBtn);
		pnlRenovarBtn.setLayout(null);
		
		JLabel lblRenovar = new JLabel("RENOVAR");
		lblRenovar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRenovar.setForeground(MyColors.BACKGROUND);
		lblRenovar.setFont(new Font("Arial", Font.BOLD, 14));
		lblRenovar.setBounds(0, 5, 250, 30);
		pnlRenovarBtn.add(lblRenovar);
	}
}