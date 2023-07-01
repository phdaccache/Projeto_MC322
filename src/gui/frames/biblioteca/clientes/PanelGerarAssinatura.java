package gui.frames.biblioteca.clientes;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import gui.frames.style.MyColors;
import sistema.Biblioteca;

public class PanelGerarAssinatura extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel iconX;
	
	public PanelGerarAssinatura(Biblioteca biblioteca, JFrame frameClientes) {
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
				if (txtInput1.getText().equals("CPF")) {
					txtInput1.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput1.getText().equals("")) {
					txtInput1.setText("CPF");
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

		///////////////////////// Input 2 /////////////////////////

		JPanel pnlInput2 = new JPanel();
		pnlInput2.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput2.setBackground(MyColors.BACKGROUND);
		pnlInput2.setBounds(178, 125, 115, 25);
		add(pnlInput2);
		pnlInput2.setLayout(null);

		JComboBox<String> comboBox = new JComboBox<String>(new String[] {"Básico", "Prata", "Dourado"});
		comboBox.setBounds(0, 0, 115, 25);
		pnlInput2.add(comboBox);

		JPanel pnlGerarBtn = new JPanel();
		pnlGerarBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String cpf = txtInput1.getText();
					String assinatura = (String)comboBox.getSelectedItem();
					String message = biblioteca.gerarAssinatura(cpf, assinatura);
					int confirmation = JOptionPane.showConfirmDialog(null, message, "Confirmação", JOptionPane.DEFAULT_OPTION);
					if(confirmation == 0) {
						frameClientes.dispose();
						JFrame frame = new FrameClientes(biblioteca);
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
				pnlGerarBtn.setBackground(MyColors.ACCENT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlGerarBtn.setBackground(MyColors.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlGerarBtn.setBackground(MyColors.SECONDARY_ACCENT);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlGerarBtn.setBackground(MyColors.ACCENT);
			}
		});
		pnlGerarBtn.setBackground(MyColors.PRIMARY);
		pnlGerarBtn.setBounds(53, 290, 240, 40);
		add(pnlGerarBtn);
		pnlGerarBtn.setLayout(null);
		
		JLabel lblGerar = new JLabel("GERAR");
		lblGerar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerar.setForeground(MyColors.BACKGROUND);
		lblGerar.setFont(new Font("Arial", Font.BOLD, 14));
		lblGerar.setBounds(0, 5, 250, 30);
		pnlGerarBtn.add(lblGerar);
	}
}