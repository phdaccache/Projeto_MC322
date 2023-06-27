package gui.frames.biblioteca.clientes;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import gui.frames.style.MyColors;
import pacote.Biblioteca;

import javax.swing.border.LineBorder;

public class PanelCadastrarCliente extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel iconX;
	
	public PanelCadastrarCliente(Biblioteca biblioteca) {
		setBounds(0, 0, 346, 396);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("CADASTRAR CLIENTE");
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
				if (txtInput1.getText().equals("Tipo de Cliente")) {
					txtInput1.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput1.getText().equals("")) {
					txtInput1.setText("Tipo de Cliente");
					txtInput1.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput1.setBorder(null);
		txtInput1.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput1.setSelectionColor(MyColors.ACCENT);
		txtInput1.setForeground(MyColors.PLACEHOLDER);
		txtInput1.setText("Tipo de Cliente");
		txtInput1.setBackground(MyColors.BACKGROUND);
		txtInput1.setBounds(10, 5, 100, 15);
		pnlInput1.add(txtInput1);
		txtInput1.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String tipo = txtInput1.getText();
		
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
		if (txtInput2.getText().equals("CPF")) {
			txtInput2.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput2.getText().equals("")) {
			txtInput2.setText("CPF");
			txtInput2.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput2.setBorder(null);
		txtInput2.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput2.setSelectionColor(MyColors.ACCENT);
		txtInput2.setForeground(MyColors.PLACEHOLDER);
		txtInput2.setText("CPF");
		txtInput2.setBackground(MyColors.BACKGROUND);
		txtInput2.setBounds(10, 5, 100, 15);
		pnlInput2.add(txtInput2);
		txtInput2.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String cpf = txtInput2.getText();

		///////////////////////// Input 3 /////////////////////////
		
		JPanel pnlInput3 = new JPanel();
		pnlInput3.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput3.setBackground(MyColors.BACKGROUND);
		pnlInput3.setBounds(53, 160, 115, 25);
		add(pnlInput3);
		pnlInput3.setLayout(null);
		
		JTextField txtInput3 = new JTextField();
		txtInput3.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput3.setForeground(MyColors.TEXT);
		if (txtInput3.getText().equals("Nome")) {
			txtInput3.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput3.getText().equals("")) {
			txtInput3.setText("Nome");
			txtInput3.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput3.setBorder(null);
		txtInput3.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput3.setSelectionColor(MyColors.ACCENT);
		txtInput3.setForeground(MyColors.PLACEHOLDER);
		txtInput3.setText("Nome");
		txtInput3.setBackground(MyColors.BACKGROUND);
		txtInput3.setBounds(10, 5, 100, 15);
		pnlInput3.add(txtInput3);
		txtInput3.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String nome = txtInput3.getText();

		///////////////////////// Input 4 /////////////////////////
		
		JPanel pnlInput4 = new JPanel();
		pnlInput4.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput4.setBackground(MyColors.BACKGROUND);
		pnlInput4.setBounds(178, 160, 115, 25);
		add(pnlInput4);
		pnlInput4.setLayout(null);
		
		JTextField txtInput4 = new JTextField();
		txtInput4.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput4.setForeground(MyColors.TEXT);
		if (txtInput4.getText().equals("Telefone")) {
			txtInput4.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput4.getText().equals("")) {
			txtInput4.setText("Telefone");
			txtInput4.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput4.setBorder(null);
		txtInput4.setFont(new Font("Arial", Font.PLAIN, 14));
		txtInput4.setSelectionColor(MyColors.ACCENT);
		txtInput4.setForeground(MyColors.PLACEHOLDER);
		txtInput4.setText("Telefone");
		txtInput4.setBackground(MyColors.BACKGROUND);
		txtInput4.setBounds(10, 5, 100, 15);
		pnlInput4.add(txtInput4);
		txtInput4.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String telefone = txtInput4.getText();

		///////////////////////// Input 5 /////////////////////////
		
		JPanel pnlInput5 = new JPanel();
		pnlInput5.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput5.setBackground(MyColors.BACKGROUND);
		pnlInput5.setBounds(53, 195, 115, 25);
		add(pnlInput5);
		pnlInput5.setLayout(null);
		
		JTextField txtInput5 = new JTextField();
		txtInput5.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput5.setForeground(MyColors.TEXT);
		if (txtInput5.getText().equals("Email")) {
			txtInput5.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput5.getText().equals("")) {
			txtInput5.setText("Email");
			txtInput5.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput5.setBorder(null);
		txtInput5.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput5.setSelectionColor(MyColors.ACCENT);
		txtInput5.setForeground(MyColors.PLACEHOLDER);
		txtInput5.setText("Email");
		txtInput5.setBackground(MyColors.BACKGROUND);
		txtInput5.setBounds(10, 5, 100, 15);
		pnlInput5.add(txtInput5);
		txtInput5.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String email = txtInput5.getText();

		///////////////////////// Input 6 /////////////////////////
		
		JPanel pnlInput6 = new JPanel();
		pnlInput6.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput6.setBackground(MyColors.BACKGROUND);
		pnlInput6.setBounds(178, 195, 115, 25);
		add(pnlInput6);
		pnlInput6.setLayout(null);
		
		JTextField txtInput6 = new JTextField();
		txtInput6.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput6.setForeground(MyColors.TEXT);
		if (txtInput6.getText().equals("Nascimento")) {
			txtInput6.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput6.getText().equals("")) {
			txtInput6.setText("Nascimento");
			txtInput6.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput6.setBorder(null);
		txtInput6.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput6.setSelectionColor(MyColors.ACCENT);
		txtInput6.setForeground(MyColors.PLACEHOLDER);
		txtInput6.setText("Nascimento");
		txtInput6.setBackground(MyColors.BACKGROUND);
		txtInput6.setBounds(10, 5, 100, 15);
		pnlInput6.add(txtInput6);
		txtInput6.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String nascimento = txtInput6.getText();

		///////////////////////// Input 7 /////////////////////////
		
		JPanel pnlInput7 = new JPanel();
		pnlInput7.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput7.setBackground(MyColors.BACKGROUND);
		pnlInput7.setBounds(53, 230, 115, 25);
		add(pnlInput7);
		pnlInput7.setLayout(null);
		
		JTextField txtInput7 = new JTextField();
		txtInput7.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput7.setForeground(MyColors.TEXT);
		if (txtInput7.getText().equals("Senha")) {
			txtInput7.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput7.getText().equals("")) {
			txtInput7.setText("Senha");
			txtInput7.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput7.setBorder(null);
		txtInput7.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput7.setSelectionColor(MyColors.ACCENT);
		txtInput7.setForeground(MyColors.PLACEHOLDER);
		txtInput7.setText("Senha");
		txtInput7.setBackground(MyColors.BACKGROUND);
		txtInput7.setBounds(10, 5, 100, 15);
		pnlInput7.add(txtInput7);
		txtInput7.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String senha = txtInput7.getText();

		///////////////////////// Input 8 /////////////////////////
		
		JPanel pnlInput8 = new JPanel();
		pnlInput8.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput8.setBackground(MyColors.BACKGROUND);
		pnlInput8.setBounds(178, 230, 115, 25);
		add(pnlInput8);
		pnlInput8.setLayout(null);
		
		JTextField txtInput8 = new JTextField();
		txtInput8.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput8.setForeground(MyColors.TEXT);
		if (txtInput8.getText().equals("Assinatura")) {
			txtInput8.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput8.getText().equals("")) {
			txtInput8.setText("Assinatura");
			txtInput8.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput8.setBorder(null);
		txtInput8.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput8.setSelectionColor(MyColors.ACCENT);
		txtInput8.setForeground(MyColors.PLACEHOLDER);
		txtInput8.setText("Assinatura");
		txtInput8.setBackground(MyColors.BACKGROUND);
		txtInput8.setBounds(10, 5, 100, 15);
		pnlInput8.add(txtInput8);
		txtInput8.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String assinatura = txtInput8.getText();

		///////////////////////// Input 9 /////////////////////////
		
		JPanel pnlInput9 = new JPanel();
		pnlInput9.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput9.setBackground(MyColors.BACKGROUND);
		pnlInput9.setBounds(53, 265, 115, 25);
		add(pnlInput9);
		pnlInput9.setLayout(null);
		
		JTextField txtInput9 = new JTextField();
		txtInput9.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput9.setForeground(MyColors.TEXT);
		if (txtInput9.getText().equals("Matrícula")) {
			txtInput9.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput9.getText().equals("")) {
			txtInput9.setText("Matrícula");
			txtInput9.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput9.setBorder(null);
		txtInput9.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput9.setSelectionColor(MyColors.ACCENT);
		txtInput9.setForeground(MyColors.PLACEHOLDER);
		txtInput9.setText("Matrícula");
		txtInput9.setBackground(MyColors.BACKGROUND);
		txtInput9.setBounds(10, 5, 100, 15);
		pnlInput9.add(txtInput9);
		txtInput9.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String matricula = txtInput9.getText();

		///////////////////////// Input 10 /////////////////////////
		
		JPanel pnlInput10 = new JPanel();
		pnlInput10.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput10.setBackground(MyColors.BACKGROUND);
		pnlInput10.setBounds(178, 265, 115, 25);
		add(pnlInput10);
		pnlInput10.setLayout(null);
		
		JTextField txtInput10 = new JTextField();
		txtInput10.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput10.setForeground(MyColors.TEXT);
		if (txtInput10.getText().equals("Curso")) {
			txtInput10.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput10.getText().equals("")) {
			txtInput10.setText("Curso");
			txtInput10.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput10.setBorder(null);
		txtInput10.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput10.setSelectionColor(MyColors.ACCENT);
		txtInput10.setForeground(MyColors.PLACEHOLDER);
		txtInput10.setText("Curso");
		txtInput10.setBackground(MyColors.BACKGROUND);
		txtInput10.setBounds(10, 5, 100, 15);
		pnlInput10.add(txtInput10);
		txtInput10.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String curso = txtInput10.getText();

		///////////////////////// Input 11 /////////////////////////
		
		JPanel pnlInput11 = new JPanel();
		pnlInput11.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput11.setBackground(MyColors.BACKGROUND);
		pnlInput11.setBounds(53, 300, 115, 25);
		add(pnlInput11);
		pnlInput11.setLayout(null);
		
		JTextField txtInput11 = new JTextField();
		txtInput11.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput11.setForeground(MyColors.TEXT);
		if (txtInput11.getText().equals("Ano Graduação")) {
			txtInput11.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput11.getText().equals("")) {
			txtInput11.setText("Ano Graduação");
			txtInput11.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput11.setBorder(null);
		txtInput11.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput11.setSelectionColor(MyColors.ACCENT);
		txtInput11.setForeground(MyColors.PLACEHOLDER);
		txtInput11.setText("Ano Graduação");
		txtInput11.setBackground(MyColors.BACKGROUND);
		txtInput11.setBounds(10, 5, 100, 15);
		pnlInput11.add(txtInput11);
		txtInput11.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String ano_grad = txtInput11.getText();

		///////////////////////// Input 12 /////////////////////////
		
		JPanel pnlInput12 = new JPanel();
		pnlInput12.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput12.setBackground(MyColors.BACKGROUND);
		pnlInput12.setBounds(178, 300, 115, 25);
		add(pnlInput12);
		pnlInput12.setLayout(null);
		
		JTextField txtInput12 = new JTextField();
		txtInput12.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput12.setForeground(MyColors.TEXT);
		if (txtInput12.getText().equals("Instituição")) {
			txtInput12.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput12.getText().equals("")) {
			txtInput12.setText("Instituição");
			txtInput12.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput12.setBorder(null);
		txtInput12.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput12.setSelectionColor(MyColors.ACCENT);
		txtInput12.setForeground(MyColors.PLACEHOLDER);
		txtInput12.setText("Instituição");
		txtInput12.setBackground(MyColors.BACKGROUND);
		txtInput12.setBounds(10, 5, 100, 15);
		pnlInput12.add(txtInput12);
		txtInput12.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String instituicao = txtInput12.getText();

		///////////////////////// Input 13 /////////////////////////
		
		JPanel pnlInput13 = new JPanel();
		pnlInput13.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput13.setBackground(MyColors.BACKGROUND);
		pnlInput13.setBounds(53, 335, 115, 25);
		add(pnlInput13);
		pnlInput13.setLayout(null);
		
		JTextField txtInput13 = new JTextField();
		txtInput13.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput13.setForeground(MyColors.TEXT);
		if (txtInput13.getText().equals("Educação")) {
			txtInput13.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput13.getText().equals("")) {
			txtInput13.setText("Educação");
			txtInput13.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput13.setBorder(null);
		txtInput13.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput13.setSelectionColor(MyColors.ACCENT);
		txtInput13.setForeground(MyColors.PLACEHOLDER);
		txtInput13.setText("Educação");
		txtInput13.setBackground(MyColors.BACKGROUND);
		txtInput13.setBounds(10, 5, 100, 15);
		pnlInput13.add(txtInput13);
		txtInput13.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String educacao = txtInput13.getText();

		///////////////////////// Input 14 /////////////////////////
		
		JPanel pnlInput14 = new JPanel();
		pnlInput14.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput14.setBackground(MyColors.BACKGROUND);
		pnlInput14.setBounds(178, 335, 115, 25);
		add(pnlInput14);
		pnlInput14.setLayout(null);
		
		JTextField txtInput14 = new JTextField();
		txtInput14.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput14.setForeground(MyColors.TEXT);
		if (txtInput14.getText().equals("Área Atuação")) {
			txtInput14.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput14.getText().equals("")) {
			txtInput14.setText("Área Atuação");
			txtInput14.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput14.setBorder(null);
		txtInput14.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput14.setSelectionColor(MyColors.ACCENT);
		txtInput14.setForeground(MyColors.PLACEHOLDER);
		txtInput14.setText("Área Atuação");
		txtInput14.setBackground(MyColors.BACKGROUND);
		txtInput14.setBounds(10, 5, 100, 15);
		pnlInput14.add(txtInput14);
		txtInput14.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String area = txtInput14.getText();

		///////////////////////// Input 15 /////////////////////////
		
		JPanel pnlInput15 = new JPanel();
		pnlInput15.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput15.setBackground(MyColors.BACKGROUND);
		pnlInput15.setBounds(53, 370, 115, 25);
		add(pnlInput15);
		pnlInput15.setLayout(null);
		
		JTextField txtInput15 = new JTextField();
		txtInput15.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput15.setForeground(MyColors.TEXT);
		if (txtInput15.getText().equals("Aulas")) {
			txtInput15.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput15.getText().equals("")) {
			txtInput15.setText("Aulas");
			txtInput15.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput15.setBorder(null);
		txtInput15.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput15.setSelectionColor(MyColors.ACCENT);
		txtInput15.setForeground(MyColors.PLACEHOLDER);
		txtInput15.setText("Aulas");
		txtInput15.setBackground(MyColors.BACKGROUND);
		txtInput15.setBounds(10, 5, 100, 15);
		pnlInput15.add(txtInput15);
		txtInput15.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String aulas = txtInput15.getText();

		///////////////////////// Input 16 /////////////////////////
		
		JPanel pnlInput16 = new JPanel();
		pnlInput16.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput16.setBackground(MyColors.BACKGROUND);
		pnlInput16.setBounds(178, 370, 115, 25);
		add(pnlInput16);
		pnlInput16.setLayout(null);
		
		JTextField txtInput16 = new JTextField();
		txtInput16.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput16.setForeground(MyColors.TEXT);
		if (txtInput16.getText().equals("Ano Ingresso")) {
			txtInput16.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput16.getText().equals("")) {
			txtInput16.setText("Ano Ingresso");
			txtInput16.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput16.setBorder(null);
		txtInput16.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput16.setSelectionColor(MyColors.ACCENT);
		txtInput16.setForeground(MyColors.PLACEHOLDER);
		txtInput16.setText("Ano Ingresso");
		txtInput16.setBackground(MyColors.BACKGROUND);
		txtInput16.setBounds(10, 5, 100, 15);
		pnlInput16.add(txtInput16);
		txtInput16.setColumns(10);
		
		// Pegar a informação de dentro do input:
		//String ano_ing = txtInput16.getText();
	}
}