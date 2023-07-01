package gui.frames.cliente.itens;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import gui.frames.style.MyColors;
import sistema.Cliente;

public class PanelPesquisarItem extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel iconX;
	
	public PanelPesquisarItem(Cliente cliente) {
		setBounds(0, 0, 346, 396);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("PESQUISAR ITEM");
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

		JTextField txtInput1 = new JTextField();
		txtInput1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput1.setForeground(MyColors.TEXT);
				if (txtInput1.getText().equals("Titulo")) {
					txtInput1.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput1.getText().equals("")) {
					txtInput1.setText("Titulo");
					txtInput1.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput1.setBorder(null);
		txtInput1.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput1.setSelectionColor(MyColors.ACCENT);
		txtInput1.setForeground(MyColors.PLACEHOLDER);
		txtInput1.setText("Titulo");
		txtInput1.setBackground(MyColors.BACKGROUND);
		txtInput1.setBounds(10, 5, 100, 15);
		pnlInput1.add(txtInput1);
		txtInput1.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 160, 280, 163);
		add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setSelectionColor(MyColors.ACCENT);
		textArea.setEditable(false);
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(textArea);

		JPanel lblPesquisarBtn = new JPanel();
		lblPesquisarBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String titulo = txtInput1.getText();
					String resultado = cliente.pesquisarItem(titulo);

					// String recebida do backend
					textArea.setText(resultado);

				} catch (IllegalArgumentException error) {
					JOptionPane.showMessageDialog(null, error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPesquisarBtn.setBackground(MyColors.ACCENT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPesquisarBtn.setBackground(MyColors.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblPesquisarBtn.setBackground(MyColors.SECONDARY_ACCENT);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblPesquisarBtn.setBackground(MyColors.ACCENT);
			}
		});

		lblPesquisarBtn.setBackground(MyColors.PRIMARY);
		lblPesquisarBtn.setBounds(53, 334, 240, 40);
		add(lblPesquisarBtn);
		lblPesquisarBtn.setLayout(null);
		
		JLabel lblPesquisar = new JLabel("PESQUISAR");
		lblPesquisar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisar.setForeground(MyColors.BACKGROUND);
		lblPesquisar.setFont(new Font("Arial", Font.BOLD, 14));
		lblPesquisar.setBounds(0, 5, 250, 30);
		lblPesquisarBtn.add(lblPesquisar);
	}
}
