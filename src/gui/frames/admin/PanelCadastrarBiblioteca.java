package gui.frames.admin;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

import gui.frames.style.MyColors;
import pacote.Admin;

public class PanelCadastrarBiblioteca extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel iconX;
	
	public PanelCadastrarBiblioteca(JFrame frameAdmin) {
		setBounds(0, 0, 346, 396);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("CADASTRAR BIBLIOTECA");
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
				if (txtInput1.getText().equals("Nome")) {
					txtInput1.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput1.getText().equals("")) {
					txtInput1.setText("Nome");
					txtInput1.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput1.setBorder(null);
		txtInput1.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput1.setSelectionColor(MyColors.ACCENT);
		txtInput1.setForeground(MyColors.PLACEHOLDER);
		txtInput1.setText("Nome");
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

		JTextField txtInput2 = new JTextField();
		txtInput2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput2.setForeground(MyColors.TEXT);
				if (txtInput2.getText().equals("CNPJ")) {
					txtInput2.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput2.getText().equals("")) {
					txtInput2.setText("CNPJ");
					txtInput2.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput2.setBorder(null);
		txtInput2.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput2.setSelectionColor(MyColors.ACCENT);
		txtInput2.setForeground(MyColors.PLACEHOLDER);
		txtInput2.setText("CNPJ");
		txtInput2.setBackground(MyColors.BACKGROUND);
		txtInput2.setBounds(10, 5, 100, 15);
		pnlInput2.add(txtInput2);
		txtInput2.setColumns(10);

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
				if (txtInput3.getText().equals("Endereço")) {
					txtInput3.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput3.getText().equals("")) {
					txtInput3.setText("Endereço");
					txtInput3.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput3.setBorder(null);
		txtInput3.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput3.setSelectionColor(MyColors.ACCENT);
		txtInput3.setForeground(MyColors.PLACEHOLDER);
		txtInput3.setText("Endereço");
		txtInput3.setBackground(MyColors.BACKGROUND);
		txtInput3.setBounds(10, 5, 100, 15);
		pnlInput3.add(txtInput3);
		txtInput3.setColumns(10);

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
		txtInput4.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput4.setSelectionColor(MyColors.ACCENT);
		txtInput4.setForeground(MyColors.PLACEHOLDER);
		txtInput4.setText("Telefone");
		txtInput4.setBackground(MyColors.BACKGROUND);
		txtInput4.setBounds(10, 5, 100, 15);
		pnlInput4.add(txtInput4);
		txtInput4.setColumns(10);

		///////////////////////// Input 5 /////////////////////////

		JPanel pnlInput5 = new JPanel();
		pnlInput5.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput5.setBackground(MyColors.BACKGROUND);
		pnlInput5.setBounds(115, 195, 115, 25);
		add(pnlInput5);
		pnlInput5.setLayout(null);

		JTextField txtInput5 = new JTextField();
		txtInput5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput5.setForeground(MyColors.TEXT);
				if (txtInput5.getText().equals("Senha")) {
					txtInput5.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput5.getText().equals("")) {
					txtInput5.setText("Senha");
					txtInput5.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput5.setBorder(null);
		txtInput5.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput5.setSelectionColor(MyColors.ACCENT);
		txtInput5.setForeground(MyColors.PLACEHOLDER);
		txtInput5.setText("Senha");
		txtInput5.setBackground(MyColors.BACKGROUND);
		txtInput5.setBounds(10, 5, 100, 15);
		pnlInput5.add(txtInput5);
		txtInput5.setColumns(10);

		JPanel pnlCadastroBtn = new JPanel();
		pnlCadastroBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = txtInput1.getText();
				String cnpj = txtInput2.getText();
				String endereco = txtInput3.getText();
				String telefone = txtInput4.getText();
				String senha = txtInput5.getText();
				Admin.CadastrarBiblioteca(nome, cnpj, endereco, telefone, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), senha);
				int confirmation = JOptionPane.showConfirmDialog(null, "Biblioteca Cadastrada!", "Confirmation", JOptionPane.DEFAULT_OPTION);
				if(confirmation == 0) {
					frameAdmin.dispose();
					JFrame frame = new FrameAdmin();
					frame.setVisible(true);
					frame.toFront();
					frame.requestFocus();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlCadastroBtn.setBackground(MyColors.ACCENT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlCadastroBtn.setBackground(MyColors.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlCadastroBtn.setBackground(MyColors.SECONDARY_ACCENT);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlCadastroBtn.setBackground(MyColors.ACCENT);
			}
		});
		pnlCadastroBtn.setBackground(MyColors.PRIMARY);
		pnlCadastroBtn.setBounds(48, 290, 250, 40);
		add(pnlCadastroBtn);
		pnlCadastroBtn.setLayout(null);
		
		JLabel lblCadastrar = new JLabel("CADASTRAR");
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setForeground(MyColors.BACKGROUND);
		lblCadastrar.setFont(new Font("Arial", Font.BOLD, 14));
		lblCadastrar.setBounds(0, 5, 250, 30);
		pnlCadastroBtn.add(lblCadastrar);
	}
}
