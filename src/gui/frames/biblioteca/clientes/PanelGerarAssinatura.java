package gui.frames.biblioteca.clientes;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import gui.frames.style.MyColors;

public class PanelGerarAssinatura extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel iconX;
	
	public PanelGerarAssinatura() {
		setBounds(0, 0, 346, 396);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("GERAR ASSINATURA");
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
		pnlInput1.setBounds(53, 125, 115, 25);
		add(pnlInput1);
		pnlInput1.setLayout(null);

		JTextField txtInput1 = new JTextField();
		txtInput1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput1.setForeground(MyColors.TEXT);
				if (txtInput1.getText().equals("Input1")) {
					txtInput1.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput1.getText().equals("")) {
					txtInput1.setText("Input1");
					txtInput1.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput1.setBorder(null);
		txtInput1.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput1.setSelectionColor(MyColors.ACCENT);
		txtInput1.setForeground(MyColors.PLACEHOLDER);
		txtInput1.setText("CPF");
		txtInput1.setBackground(MyColors.BACKGROUND);
		txtInput1.setBounds(10, 5, 100, 15);
		pnlInput1.add(txtInput1);
		txtInput1.setColumns(10);

		// Pegar a informação de dentro do input:
		txtInput1.getText();

		///////////////////////// Input 2 /////////////////////////

		JPanel pnlInput2 = new JPanel();
		pnlInput2.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput2.setBackground(MyColors.BACKGROUND);
		pnlInput2.setBounds(178, 125, 115, 25);
		add(pnlInput2);
		pnlInput2.setLayout(null);

		JTextField txtInput2 = new JTextField();
		txtInput2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput2.setForeground(MyColors.TEXT);
				if (txtInput2.getText().equals("Input2")) {
					txtInput2.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput2.getText().equals("")) {
					txtInput2.setText("Input2");
					txtInput2.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput2.setBorder(null);
		txtInput2.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput2.setSelectionColor(MyColors.ACCENT);
		txtInput2.setForeground(MyColors.PLACEHOLDER);
		txtInput2.setText("Assinatura: Prata ou Dourado");
		txtInput2.setBackground(MyColors.BACKGROUND);
		txtInput2.setBounds(10, 5, 100, 15);
		pnlInput2.add(txtInput2);
		txtInput2.setColumns(10);

		txtInput2.getText();

	}
}