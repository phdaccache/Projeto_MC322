package gui.frames.biblioteca.itens;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import gui.frames.style.MyColors;
import sistema.Biblioteca;

public class PanelCadastrarItem extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel iconX;
	
	public PanelCadastrarItem (Biblioteca biblioteca, JFrame frameItens) {
		setBounds(0, 0, 346, 396);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("CADASTRAR ITEM");
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
		pnlInput1.setBounds(115, 100, 115, 25);
		add(pnlInput1);
		pnlInput1.setLayout(null);

		JComboBox<String> comboBox = new JComboBox<String>(new String[] {"Livro", "Apostila", "Artigo", "Revista"});
		comboBox.setBounds(0, 0, 115, 25);
		pnlInput1.add(comboBox);

		///////////////////////// Input 2 /////////////////////////

		JPanel pnlInput2 = new JPanel();
		pnlInput2.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput2.setBackground(MyColors.BACKGROUND);
		pnlInput2.setBounds(53, 135, 115, 25);
		add(pnlInput2);
		pnlInput2.setLayout(null);

		JTextField txtInput2 = new JTextField();
		txtInput2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput2.setForeground(MyColors.TEXT);
				if (txtInput2.getText().equals("Páginas")) {
					txtInput2.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput2.getText().equals("")) {
					txtInput2.setText("Páginas");
					txtInput2.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput2.setBorder(null);
		txtInput2.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput2.setSelectionColor(MyColors.ACCENT);
		txtInput2.setForeground(MyColors.PLACEHOLDER);
		txtInput2.setText("Páginas");
		txtInput2.setBackground(MyColors.BACKGROUND);
		txtInput2.setBounds(10, 5, 100, 15);
		pnlInput2.add(txtInput2);
		txtInput2.setColumns(10);

		///////////////////////// Input 3 /////////////////////////

		JPanel pnlInput3 = new JPanel();
		pnlInput3.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput3.setBackground(MyColors.BACKGROUND);
		pnlInput3.setBounds(178, 135, 115, 25);
		add(pnlInput3);
		pnlInput3.setLayout(null);

		JTextField txtInput3 = new JTextField();
		txtInput3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput3.setForeground(MyColors.TEXT);
				if (txtInput3.getText().equals("Título")) {
					txtInput3.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput3.getText().equals("")) {
					txtInput3.setText("Título");
					txtInput3.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput3.setBorder(null);
		txtInput3.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput3.setSelectionColor(MyColors.ACCENT);
		txtInput3.setForeground(MyColors.PLACEHOLDER);
		txtInput3.setText("Título");
		txtInput3.setBackground(MyColors.BACKGROUND);
		txtInput3.setBounds(10, 5, 100, 15);
		pnlInput3.add(txtInput3);
		txtInput3.setColumns(10);

		///////////////////////// Input 4 /////////////////////////

		JPanel pnlInput4 = new JPanel();
		pnlInput4.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput4.setBackground(MyColors.BACKGROUND);
		pnlInput4.setBounds(53, 170, 115, 25);
		add(pnlInput4);
		pnlInput4.setLayout(null);

		JTextField txtInput4 = new JTextField();
		txtInput4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput4.setForeground(MyColors.TEXT);
				if (txtInput4.getText().equals("Autor(es)")) {
					txtInput4.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput4.getText().equals("")) {
					txtInput4.setText("Autor(es)");
					txtInput4.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput4.setBorder(null);
		txtInput4.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput4.setSelectionColor(MyColors.ACCENT);
		txtInput4.setForeground(MyColors.PLACEHOLDER);
		txtInput4.setText("Autor(es)");
		txtInput4.setBackground(MyColors.BACKGROUND);
		txtInput4.setBounds(10, 5, 100, 15);
		pnlInput4.add(txtInput4);
		txtInput4.setColumns(10);

		///////////////////////// Input 5 /////////////////////////

		JPanel pnlInput5 = new JPanel();
		pnlInput5.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput5.setBackground(MyColors.BACKGROUND);
		pnlInput5.setBounds(178, 170, 115, 25);
		add(pnlInput5);
		pnlInput5.setLayout(null);

		JTextField txtInput5 = new JTextField();
		txtInput5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput5.setForeground(MyColors.TEXT);
				if (txtInput5.getText().equals("Ano")) {
					txtInput5.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput5.getText().equals("")) {
					txtInput5.setText("Ano");
					txtInput5.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput5.setBorder(null);
		txtInput5.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput5.setSelectionColor(MyColors.ACCENT);
		txtInput5.setForeground(MyColors.PLACEHOLDER);
		txtInput5.setText("Ano");
		txtInput5.setBackground(MyColors.BACKGROUND);
		txtInput5.setBounds(10, 5, 100, 15);
		pnlInput5.add(txtInput5);
		txtInput5.setColumns(10);

		///////////////////////// Input 6 /////////////////////////

		JPanel pnlInput6 = new JPanel();
		pnlInput6.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput6.setBackground(MyColors.BACKGROUND);
		pnlInput6.setBounds(53, 205, 115, 25);
		add(pnlInput6);
		pnlInput6.setLayout(null);

		JTextField txtInput6 = new JTextField();
		txtInput6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput6.setForeground(MyColors.TEXT);
				if (txtInput6.getText().equals("Editora")) {
					txtInput6.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput6.getText().equals("")) {
					txtInput6.setText("Editora");
					txtInput6.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput6.setBorder(null);
		txtInput6.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput6.setSelectionColor(MyColors.ACCENT);
		txtInput6.setForeground(MyColors.PLACEHOLDER);
		txtInput6.setText("Editora");
		txtInput6.setBackground(MyColors.BACKGROUND);
		txtInput6.setBounds(10, 5, 100, 15);
		pnlInput6.add(txtInput6);
		txtInput6.setColumns(10);

		///////////////////////// Input 7 /////////////////////////

		JPanel pnlInput7 = new JPanel();
		pnlInput7.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput7.setBackground(MyColors.BACKGROUND);
		pnlInput7.setBounds(178, 205, 115, 25);
		add(pnlInput7);
		pnlInput7.setLayout(null);

		JTextField txtInput7 = new JTextField();
		txtInput7.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput7.setForeground(MyColors.TEXT);
				if (txtInput7.getText().equals("ISBN")) {
					txtInput7.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput7.getText().equals("")) {
					txtInput7.setText("ISBN");
					txtInput7.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput7.setBorder(null);
		txtInput7.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput7.setSelectionColor(MyColors.ACCENT);
		txtInput7.setForeground(MyColors.PLACEHOLDER);
		txtInput7.setText("ISBN");
		txtInput7.setBackground(MyColors.BACKGROUND);
		txtInput7.setBounds(10, 5, 100, 15);
		pnlInput7.add(txtInput7);
		txtInput7.setColumns(10);

		///////////////////////// Input 8 /////////////////////////

		JPanel pnlInput8 = new JPanel();
		pnlInput8.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput8.setBackground(MyColors.BACKGROUND);
		pnlInput8.setBounds(53, 240, 115, 25);
		add(pnlInput8);
		pnlInput8.setLayout(null);

		JTextField txtInput8 = new JTextField();
		txtInput8.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput8.setForeground(MyColors.TEXT);
				if (txtInput8.getText().equals("Edição")) {
					txtInput8.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput8.getText().equals("")) {
					txtInput8.setText("Edição");
					txtInput8.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput8.setBorder(null);
		txtInput8.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput8.setSelectionColor(MyColors.ACCENT);
		txtInput8.setForeground(MyColors.PLACEHOLDER);
		txtInput8.setText("Edição");
		txtInput8.setBackground(MyColors.BACKGROUND);
		txtInput8.setBounds(10, 5, 100, 15);
		pnlInput8.add(txtInput8);
		txtInput8.setColumns(10);

		///////////////////////// Input 9 /////////////////////////

		JPanel pnlInput9 = new JPanel();
		pnlInput9.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput9.setBackground(MyColors.BACKGROUND);
		pnlInput9.setBounds(178, 240, 115, 25);
		add(pnlInput9);
		pnlInput9.setLayout(null);

		JTextField txtInput9 = new JTextField();
		txtInput9.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput9.setForeground(MyColors.TEXT);
				if (txtInput9.getText().equals("Tema")) {
					txtInput9.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput9.getText().equals("")) {
					txtInput9.setText("Tema");
					txtInput9.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput9.setBorder(null);
		txtInput9.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput9.setSelectionColor(MyColors.ACCENT);
		txtInput9.setForeground(MyColors.PLACEHOLDER);
		txtInput9.setText("Tema");
		txtInput9.setBackground(MyColors.BACKGROUND);
		txtInput9.setBounds(10, 5, 100, 15);
		pnlInput9.add(txtInput9);
		txtInput9.setColumns(10);

		///////////////////////// Input 10 /////////////////////////

		JPanel pnlInput10 = new JPanel();
		pnlInput10.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput10.setBackground(MyColors.BACKGROUND);
		pnlInput10.setBounds(53, 205, 115, 25);
		add(pnlInput10);
		pnlInput10.setLayout(null);
		pnlInput10.setVisible(false);

		JTextField txtInput10 = new JTextField();
		txtInput10.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput10.setForeground(MyColors.TEXT);
				if (txtInput10.getText().equals("Disciplina")) {
					txtInput10.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput10.getText().equals("")) {
					txtInput10.setText("Disciplina");
					txtInput10.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput10.setBorder(null);
		txtInput10.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput10.setSelectionColor(MyColors.ACCENT);
		txtInput10.setForeground(MyColors.PLACEHOLDER);
		txtInput10.setText("Disciplina");
		txtInput10.setBackground(MyColors.BACKGROUND);
		txtInput10.setBounds(10, 5, 100, 15);
		pnlInput10.add(txtInput10);
		txtInput10.setColumns(10);
		txtInput10.setVisible(false);

		///////////////////////// Input 11 /////////////////////////

		JPanel pnlInput11 = new JPanel();
		pnlInput11.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput11.setBackground(MyColors.BACKGROUND);
		pnlInput11.setBounds(178, 205, 115, 25);
		add(pnlInput11);
		pnlInput11.setLayout(null);
		pnlInput11.setVisible(false);

		JTextField txtInput11 = new JTextField();
		txtInput11.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput11.setForeground(MyColors.TEXT);
				if (txtInput11.getText().equals("Instituição")) {
					txtInput11.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput11.getText().equals("")) {
					txtInput11.setText("Instituição");
					txtInput11.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput11.setBorder(null);
		txtInput11.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput11.setSelectionColor(MyColors.ACCENT);
		txtInput11.setForeground(MyColors.PLACEHOLDER);
		txtInput11.setText("Instituição");
		txtInput11.setBackground(MyColors.BACKGROUND);
		txtInput11.setBounds(10, 5, 100, 15);
		pnlInput11.add(txtInput11);
		txtInput11.setColumns(10);
		txtInput11.setVisible(false);

		///////////////////////// Input 12 /////////////////////////

		JPanel pnlInput12 = new JPanel();
		pnlInput12.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput12.setBackground(MyColors.BACKGROUND);
		pnlInput12.setBounds(53, 205, 115, 25);
		add(pnlInput12);
		pnlInput12.setLayout(null);
		pnlInput12.setVisible(false);

		JTextField txtInput12 = new JTextField();
		txtInput12.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput12.setForeground(MyColors.TEXT);
				if (txtInput12.getText().equals("DOI")) {
					txtInput12.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput12.getText().equals("")) {
					txtInput12.setText("DOI");
					txtInput12.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput12.setBorder(null);
		txtInput12.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput12.setSelectionColor(MyColors.ACCENT);
		txtInput12.setForeground(MyColors.PLACEHOLDER);
		txtInput12.setText("DOI");
		txtInput12.setBackground(MyColors.BACKGROUND);
		txtInput12.setBounds(10, 5, 100, 15);
		pnlInput12.add(txtInput12);
		txtInput12.setColumns(10);
		txtInput12.setVisible(false);

		///////////////////////// Input 13 /////////////////////////

		JPanel pnlInput13 = new JPanel();
		pnlInput13.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput13.setBackground(MyColors.BACKGROUND);
		pnlInput13.setBounds(178, 205, 115, 25);
		add(pnlInput13);
		pnlInput13.setLayout(null);
		pnlInput13.setVisible(false);

		JTextField txtInput13 = new JTextField();
		txtInput13.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput13.setForeground(MyColors.TEXT);
				if (txtInput13.getText().equals("Resumo Artigo")) {
					txtInput13.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput13.getText().equals("")) {
					txtInput13.setText("Resumo Artigo");
					txtInput13.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput13.setBorder(null);
		txtInput13.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput13.setSelectionColor(MyColors.ACCENT);
		txtInput13.setForeground(MyColors.PLACEHOLDER);
		txtInput13.setText("Resumo Artigo");
		txtInput13.setBackground(MyColors.BACKGROUND);
		txtInput13.setBounds(10, 5, 100, 15);
		pnlInput13.add(txtInput13);
		txtInput13.setColumns(10);
		txtInput13.setVisible(false);

		///////////////////////// Input 14 /////////////////////////

		JPanel pnlInput14 = new JPanel();
		pnlInput14.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput14.setBackground(MyColors.BACKGROUND);
		pnlInput14.setBounds(115, 240, 115, 25);
		add(pnlInput14);
		pnlInput14.setLayout(null);
		pnlInput14.setVisible(false);

		JTextField txtInput14 = new JTextField();
		txtInput14.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput14.setForeground(MyColors.TEXT);
				if (txtInput14.getText().equals("Key Words")) {
					txtInput14.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput14.getText().equals("")) {
					txtInput14.setText("Key Words");
					txtInput14.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput14.setBorder(null);
		txtInput14.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput14.setSelectionColor(MyColors.ACCENT);
		txtInput14.setForeground(MyColors.PLACEHOLDER);
		txtInput14.setText("Key Words");
		txtInput14.setBackground(MyColors.BACKGROUND);
		txtInput14.setBounds(10, 5, 100, 15);
		pnlInput14.add(txtInput14);
		txtInput14.setColumns(10);
		txtInput14.setVisible(false);

		///////////////////////// Input 15 /////////////////////////

		JPanel pnlInput15 = new JPanel();
		pnlInput15.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput15.setBackground(MyColors.BACKGROUND);
		pnlInput15.setBounds(53, 205, 115, 25);
		add(pnlInput15);
		pnlInput15.setLayout(null);
		pnlInput15.setVisible(false);

		JTextField txtInput15 = new JTextField();
		txtInput15.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput15.setForeground(MyColors.TEXT);
				if (txtInput15.getText().equals("Edição")) {
					txtInput15.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput15.getText().equals("")) {
					txtInput15.setText("Edição");
					txtInput15.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput15.setBorder(null);
		txtInput15.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput15.setSelectionColor(MyColors.ACCENT);
		txtInput15.setForeground(MyColors.PLACEHOLDER);
		txtInput15.setText("Edição");
		txtInput15.setBackground(MyColors.BACKGROUND);
		txtInput15.setBounds(10, 5, 100, 15);
		pnlInput15.add(txtInput15);
		txtInput15.setColumns(10);
		txtInput15.setVisible(false);

		///////////////////////// Input 16 /////////////////////////

		JPanel pnlInput16 = new JPanel();
		pnlInput16.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput16.setBackground(MyColors.BACKGROUND);
		pnlInput16.setBounds(178, 205, 115, 25);
		add(pnlInput16);
		pnlInput16.setLayout(null);
		pnlInput16.setVisible(false);

		JTextField txtInput16 = new JTextField();
		txtInput16.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput16.setForeground(MyColors.TEXT);
				if (txtInput16.getText().equals("Instituição")) {
					txtInput16.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput16.getText().equals("")) {
					txtInput16.setText("Instituição");
					txtInput16.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput16.setBorder(null);
		txtInput16.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput16.setSelectionColor(MyColors.ACCENT);
		txtInput16.setForeground(MyColors.PLACEHOLDER);
		txtInput16.setText("Instituição");
		txtInput16.setBackground(MyColors.BACKGROUND);
		txtInput16.setBounds(10, 5, 100, 15);
		pnlInput16.add(txtInput16);
		txtInput16.setColumns(10);
		txtInput16.setVisible(false);

		///////////////////////// Input 17 /////////////////////////

		JPanel pnlInput17 = new JPanel();
		pnlInput17.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput17.setBackground(MyColors.BACKGROUND);
		pnlInput17.setBounds(53, 240, 115, 25);
		add(pnlInput17);
		pnlInput17.setLayout(null);
		pnlInput17.setVisible(false);

		JTextField txtInput17 = new JTextField();
		txtInput17.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput17.setForeground(MyColors.TEXT);
				if (txtInput17.getText().equals("Assuntos")) {
					txtInput17.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput17.getText().equals("")) {
					txtInput17.setText("Assuntos");
					txtInput17.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput17.setBorder(null);
		txtInput17.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput17.setSelectionColor(MyColors.ACCENT);
		txtInput17.setForeground(MyColors.PLACEHOLDER);
		txtInput17.setText("Assuntos");
		txtInput17.setBackground(MyColors.BACKGROUND);
		txtInput17.setBounds(10, 5, 100, 15);
		pnlInput17.add(txtInput17);
		txtInput17.setColumns(10);
		txtInput17.setVisible(false);

		///////////////////////// Input 18 /////////////////////////

		JPanel pnlInput18 = new JPanel();
		pnlInput18.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput18.setBackground(MyColors.BACKGROUND);
		pnlInput18.setBounds(178, 240, 115, 25);
		add(pnlInput18);
		pnlInput18.setLayout(null);
		pnlInput18.setVisible(false);

		JTextField txtInput18 = new JTextField();
		txtInput18.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput18.setForeground(MyColors.TEXT);
				if (txtInput18.getText().equals("ISSN")) {
					txtInput18.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput18.getText().equals("")) {
					txtInput18.setText("ISSN");
					txtInput18.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput18.setBorder(null);
		txtInput18.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput18.setSelectionColor(MyColors.ACCENT);
		txtInput18.setForeground(MyColors.PLACEHOLDER);
		txtInput18.setText("ISSN");
		txtInput18.setBackground(MyColors.BACKGROUND);
		txtInput18.setBounds(10, 5, 100, 15);
		pnlInput18.add(txtInput18);
		txtInput18.setColumns(10);
		txtInput18.setVisible(false);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		String opcao = (String)comboBox.getSelectedItem();
				if (opcao.equals("Livro")) {
					pnlInput6.setVisible(true);
					pnlInput7.setVisible(true);
					pnlInput8.setVisible(true);
					pnlInput9.setVisible(true);
					txtInput6.setVisible(true);
					txtInput7.setVisible(true);
					txtInput8.setVisible(true);
					txtInput9.setVisible(true);

					pnlInput10.setVisible(false);
					pnlInput11.setVisible(false);
					txtInput10.setVisible(false);
					txtInput11.setVisible(false);

					pnlInput12.setVisible(false);
					pnlInput13.setVisible(false);
					pnlInput14.setVisible(false);
					txtInput12.setVisible(false);
					txtInput13.setVisible(false);
					txtInput14.setVisible(false);

					pnlInput15.setVisible(false);
					pnlInput16.setVisible(false);
					pnlInput17.setVisible(false);
					pnlInput18.setVisible(false);
					txtInput15.setVisible(false);
					txtInput16.setVisible(false);
					txtInput17.setVisible(false);
					txtInput18.setVisible(false);
				} else if (opcao.equals("Apostila")) {
					pnlInput6.setVisible(false);
					pnlInput7.setVisible(false);
					pnlInput8.setVisible(false);
					pnlInput9.setVisible(false);
					txtInput6.setVisible(false);
					txtInput7.setVisible(false);
					txtInput8.setVisible(false);
					txtInput9.setVisible(false);

					pnlInput10.setVisible(true);
					pnlInput11.setVisible(true);
					txtInput10.setVisible(true);
					txtInput11.setVisible(true);

					pnlInput12.setVisible(false);
					pnlInput13.setVisible(false);
					pnlInput14.setVisible(false);
					txtInput12.setVisible(false);
					txtInput13.setVisible(false);
					txtInput14.setVisible(false);

					pnlInput15.setVisible(false);
					pnlInput16.setVisible(false);
					pnlInput17.setVisible(false);
					pnlInput18.setVisible(false);
					txtInput15.setVisible(false);
					txtInput16.setVisible(false);
					txtInput17.setVisible(false);
					txtInput18.setVisible(false);
				} else if (opcao.equals("Artigo")) {
					pnlInput6.setVisible(false);
					pnlInput7.setVisible(false);
					pnlInput8.setVisible(false);
					pnlInput9.setVisible(false);
					txtInput6.setVisible(false);
					txtInput7.setVisible(false);
					txtInput8.setVisible(false);
					txtInput9.setVisible(false);

					pnlInput10.setVisible(false);
					pnlInput11.setVisible(false);
					txtInput10.setVisible(false);
					txtInput11.setVisible(false);

					pnlInput12.setVisible(true);
					pnlInput13.setVisible(true);
					pnlInput14.setVisible(true);
					txtInput12.setVisible(true);
					txtInput13.setVisible(true);
					txtInput14.setVisible(true);

					pnlInput15.setVisible(false);
					pnlInput16.setVisible(false);
					pnlInput17.setVisible(false);
					pnlInput18.setVisible(false);
					txtInput15.setVisible(false);
					txtInput16.setVisible(false);
					txtInput17.setVisible(false);
					txtInput18.setVisible(false);
				} else if (opcao.equals("Revista")) {
					pnlInput6.setVisible(false);
					pnlInput7.setVisible(false);
					pnlInput8.setVisible(false);
					pnlInput9.setVisible(false);
					txtInput6.setVisible(false);
					txtInput7.setVisible(false);
					txtInput8.setVisible(false);
					txtInput9.setVisible(false);

					pnlInput10.setVisible(false);
					pnlInput11.setVisible(false);
					txtInput10.setVisible(false);
					txtInput11.setVisible(false);

					pnlInput12.setVisible(false);
					pnlInput13.setVisible(false);
					pnlInput14.setVisible(false);
					txtInput12.setVisible(false);
					txtInput13.setVisible(false);
					txtInput14.setVisible(false);

					pnlInput15.setVisible(true);
					pnlInput16.setVisible(true);
					pnlInput17.setVisible(true);
					pnlInput18.setVisible(true);
					txtInput15.setVisible(true);
					txtInput16.setVisible(true);
					txtInput17.setVisible(true);
					txtInput18.setVisible(true);
				}
			}
		});

		JPanel pnlCadastroBtn = new JPanel();
		pnlCadastroBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String opcao = (String)comboBox.getSelectedItem();
				try {
					String message = "";
					int qtdDePaginas = Integer.parseInt(txtInput2.getText());
					String titulo = txtInput3.getText();
					String autores = txtInput4.getText();
					int ano = Integer.parseInt(txtInput5.getText());

					if (opcao.equals("Livro")) {
						String editora = txtInput6.getText();
						int isbn = Integer.parseInt(txtInput7.getText());
						String edicao = txtInput8.getText();
						String tema = txtInput9.getText();

						message = biblioteca.cadastrarLivro(qtdDePaginas, titulo, autores, ano, editora, isbn, edicao, tema);
					} else if (opcao.equals("Apostila")) {
						String disciplina = txtInput10.getText();
						String instituicao = txtInput11.getText();

						message = biblioteca.cadastrarApostila(qtdDePaginas, titulo, autores, ano, disciplina, instituicao);
					} else if (opcao.equals("Artigo")) {
						int doi = Integer.parseInt(txtInput12.getText());
						String resumo = txtInput13.getText();
						String keyWords = txtInput14.getText();

						message = biblioteca.cadastrarArtigo(qtdDePaginas, titulo, autores, ano, doi, resumo, keyWords);
					} else if (opcao.equals("Revista")) {
						String edicao = txtInput15.getText();
						String instituicao = txtInput16.getText();
						String assuntos = txtInput17.getText();
						int issn = Integer.parseInt(txtInput18.getText());

						message = biblioteca.cadastrarRevista(qtdDePaginas, titulo, autores, ano, edicao, instituicao, assuntos, issn);
					}
					int confirmation = JOptionPane.showConfirmDialog(null, message, "Confirmação", JOptionPane.DEFAULT_OPTION);
					if(confirmation == 0) {
						frameItens.dispose();
						JFrame frame = new FrameItens(biblioteca);
						frame.setVisible(true);
						frame.toFront();
						frame.requestFocus();
					}
				} catch (NumberFormatException error) {
					String message = "Os campos 'Páginas', 'Ano', 'ISBN', 'DOI' e 'ISSN'\ndevem ser preenchidos apenas com números.";
					JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException error) {
					JOptionPane.showMessageDialog(null, error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
		pnlCadastroBtn.setBounds(53, 290, 240, 40);
		add(pnlCadastroBtn);
		pnlCadastroBtn.setLayout(null);
		
		JLabel lblCadastrar = new JLabel("CADASTRAR");
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setForeground(MyColors.BACKGROUND);
		lblCadastrar.setFont(new Font("Arial", Font.BOLD, 14));
		lblCadastrar.setBounds(0, 5, 240, 30);
		pnlCadastroBtn.add(lblCadastrar);
	}
}