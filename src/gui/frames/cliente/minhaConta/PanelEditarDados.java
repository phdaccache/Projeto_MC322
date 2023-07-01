package gui.frames.cliente.minhaConta;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.*;
import javax.swing.border.LineBorder;

import gui.frames.style.MyColors;
import sistema.Cliente;
import sistema.Estudante;
import sistema.Professor;

public class PanelEditarDados extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel iconX;
	
	public PanelEditarDados(Cliente cliente, JFrame frameMinhaConta) {
		setBounds(0, 0, 346, 396);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("EDITAR DADOS");
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
		
		JTextField txtInput2 = new JTextField();
		txtInput2.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput2.setForeground(MyColors.TEXT);
		if (txtInput2.getText().equals("Nome")) {
			txtInput2.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput2.getText().equals("")) {
			txtInput2.setText("Nome");
			txtInput2.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput2.setBorder(null);
		txtInput2.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput2.setSelectionColor(MyColors.ACCENT);
		txtInput2.setForeground(MyColors.PLACEHOLDER);
		txtInput2.setText("Nome");
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
		if (txtInput3.getText().equals("Telefone")) {
			txtInput3.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput3.getText().equals("")) {
			txtInput3.setText("Telefone");
			txtInput3.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput3.setBorder(null);
		txtInput3.setFont(new Font("Arial", Font.PLAIN, 14));
		txtInput3.setSelectionColor(MyColors.ACCENT);
		txtInput3.setForeground(MyColors.PLACEHOLDER);
		txtInput3.setText("Telefone");
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
		if (txtInput4.getText().equals("Email")) {
			txtInput4.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput4.getText().equals("")) {
			txtInput4.setText("Email");
			txtInput4.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput4.setBorder(null);
		txtInput4.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput4.setSelectionColor(MyColors.ACCENT);
		txtInput4.setForeground(MyColors.PLACEHOLDER);
		txtInput4.setText("Email");
		txtInput4.setBackground(MyColors.BACKGROUND);
		txtInput4.setBounds(10, 5, 100, 15);
		pnlInput4.add(txtInput4);
		txtInput4.setColumns(10);

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
		if (txtInput5.getText().equals("Nascimento")) {
			txtInput5.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput5.getText().equals("")) {
			txtInput5.setText("Nascimento");
			txtInput5.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput5.setBorder(null);
		txtInput5.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput5.setSelectionColor(MyColors.ACCENT);
		txtInput5.setForeground(MyColors.PLACEHOLDER);
		txtInput5.setText("Nascimento");
		txtInput5.setBackground(MyColors.BACKGROUND);
		txtInput5.setBounds(10, 5, 100, 15);
		pnlInput5.add(txtInput5);
		txtInput5.setColumns(10);

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
		if (txtInput6.getText().equals("Senha")) {
			txtInput6.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput6.getText().equals("")) {
			txtInput6.setText("Senha");
			txtInput6.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput6.setBorder(null);
		txtInput6.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput6.setSelectionColor(MyColors.ACCENT);
		txtInput6.setForeground(MyColors.PLACEHOLDER);
		txtInput6.setText("Senha");
		txtInput6.setBackground(MyColors.BACKGROUND);
		txtInput6.setBounds(10, 5, 100, 15);
		pnlInput6.add(txtInput6);
		txtInput6.setColumns(10);

		///////////////////////// Input 7 /////////////////////////
		
		JPanel pnlInput7 = new JPanel();
		pnlInput7.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput7.setBackground(MyColors.BACKGROUND);
		pnlInput7.setBounds(53, 230, 115, 25);
		add(pnlInput7);
		pnlInput7.setLayout(null);
		pnlInput7.setVisible(false);
		
		JTextField txtInput7 = new JTextField();
		txtInput7.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput7.setForeground(MyColors.TEXT);
		if (txtInput7.getText().equals("Matrícula")) {
			txtInput7.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput7.getText().equals("")) {
			txtInput7.setText("Matrícula");
			txtInput7.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput7.setBorder(null);
		txtInput7.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput7.setSelectionColor(MyColors.ACCENT);
		txtInput7.setForeground(MyColors.PLACEHOLDER);
		txtInput7.setText("Matrícula");
		txtInput7.setBackground(MyColors.BACKGROUND);
		txtInput7.setBounds(10, 5, 100, 15);
		pnlInput7.add(txtInput7);
		txtInput7.setColumns(10);
		txtInput7.setVisible(false);

		///////////////////////// Input 8 /////////////////////////

		JPanel pnlInput8 = new JPanel();
		pnlInput8.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput8.setBackground(MyColors.BACKGROUND);
		pnlInput8.setBounds(178, 230, 115, 25);
		add(pnlInput8);
		pnlInput8.setLayout(null);
		pnlInput8.setVisible(false);

		JTextField txtInput8 = new JTextField();
		txtInput8.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput8.setForeground(MyColors.TEXT);
		if (txtInput8.getText().equals("Curso")) {
			txtInput8.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput8.getText().equals("")) {
			txtInput8.setText("Curso");
			txtInput8.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput8.setBorder(null);
		txtInput8.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput8.setSelectionColor(MyColors.ACCENT);
		txtInput8.setForeground(MyColors.PLACEHOLDER);
		txtInput8.setText("Curso");
		txtInput8.setBackground(MyColors.BACKGROUND);
		txtInput8.setBounds(10, 5, 100, 15);
		pnlInput8.add(txtInput8);
		txtInput8.setColumns(10);
		txtInput8.setVisible(false);

		///////////////////////// Input 9 /////////////////////////

		JPanel pnlInput9 = new JPanel();
		pnlInput9.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput9.setBackground(MyColors.BACKGROUND);
		pnlInput9.setBounds(115, 265, 115, 25);
		add(pnlInput9);
		pnlInput9.setLayout(null);
		pnlInput9.setVisible(false);

		JTextField txtInput9 = new JTextField();
		txtInput9.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput9.setForeground(MyColors.TEXT);
		if (txtInput9.getText().equals("Ano Graduação")) {
			txtInput9.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput9.getText().equals("")) {
			txtInput9.setText("Ano Graduação");
			txtInput9.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput9.setBorder(null);
		txtInput9.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput9.setSelectionColor(MyColors.ACCENT);
		txtInput9.setForeground(MyColors.PLACEHOLDER);
		txtInput9.setText("Ano Graduação");
		txtInput9.setBackground(MyColors.BACKGROUND);
		txtInput9.setBounds(10, 5, 100, 15);
		pnlInput9.add(txtInput9);
		txtInput9.setColumns(10);
		txtInput9.setVisible(false);

		///////////////////////// Input 10 /////////////////////////

		JPanel pnlInput10 = new JPanel();
		pnlInput10.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput10.setBackground(MyColors.BACKGROUND);
		pnlInput10.setBounds(53, 230, 115, 25);
		add(pnlInput10);
		pnlInput10.setLayout(null);
		pnlInput10.setVisible(false);

		JTextField txtInput10 = new JTextField();
		txtInput10.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput10.setForeground(MyColors.TEXT);
		if (txtInput10.getText().equals("Instituição")) {
			txtInput10.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput10.getText().equals("")) {
			txtInput10.setText("Instituição");
			txtInput10.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput10.setBorder(null);
		txtInput10.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput10.setSelectionColor(MyColors.ACCENT);
		txtInput10.setForeground(MyColors.PLACEHOLDER);
		txtInput10.setText("Instituição");
		txtInput10.setBackground(MyColors.BACKGROUND);
		txtInput10.setBounds(10, 5, 100, 15);
		pnlInput10.add(txtInput10);
		txtInput10.setColumns(10);
		txtInput10.setVisible(false);

		///////////////////////// Input 11 /////////////////////////

		JPanel pnlInput11 = new JPanel();
		pnlInput11.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput11.setBackground(MyColors.BACKGROUND);
		pnlInput11.setBounds(178, 230, 115, 25);
		add(pnlInput11);
		pnlInput11.setLayout(null);
		pnlInput11.setVisible(false);

		JTextField txtInput11 = new JTextField();
		txtInput11.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput11.setForeground(MyColors.TEXT);
		if (txtInput11.getText().equals("Educação")) {
			txtInput11.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput11.getText().equals("")) {
			txtInput11.setText("Educação");
			txtInput11.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput11.setBorder(null);
		txtInput11.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput11.setSelectionColor(MyColors.ACCENT);
		txtInput11.setForeground(MyColors.PLACEHOLDER);
		txtInput11.setText("Educação");
		txtInput11.setBackground(MyColors.BACKGROUND);
		txtInput11.setBounds(10, 5, 100, 15);
		pnlInput11.add(txtInput11);
		txtInput11.setColumns(10);
		txtInput11.setVisible(false);

		///////////////////////// Input 12 /////////////////////////

		JPanel pnlInput12 = new JPanel();
		pnlInput12.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput12.setBackground(MyColors.BACKGROUND);
		pnlInput12.setBounds(53, 265, 115, 25);
		add(pnlInput12);
		pnlInput12.setLayout(null);
		pnlInput12.setVisible(false);

		JTextField txtInput12 = new JTextField();
		txtInput12.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput12.setForeground(MyColors.TEXT);
		if (txtInput12.getText().equals("Área Atuação")) {
			txtInput12.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput12.getText().equals("")) {
			txtInput12.setText("Área Atuação");
			txtInput12.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput12.setBorder(null);
		txtInput12.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput12.setSelectionColor(MyColors.ACCENT);
		txtInput12.setForeground(MyColors.PLACEHOLDER);
		txtInput12.setText("Área Atuação");
		txtInput12.setBackground(MyColors.BACKGROUND);
		txtInput12.setBounds(10, 5, 100, 15);
		pnlInput12.add(txtInput12);
		txtInput12.setColumns(10);
		txtInput12.setVisible(false);

		///////////////////////// Input 13 /////////////////////////
		
		JPanel pnlInput13 = new JPanel();
		pnlInput13.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput13.setBackground(MyColors.BACKGROUND);
		pnlInput13.setBounds(178, 265, 115, 25);
		add(pnlInput13);
		pnlInput13.setLayout(null);
		pnlInput13.setVisible(false);
		
		JTextField txtInput13 = new JTextField();
		txtInput13.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput13.setForeground(MyColors.TEXT);
		if (txtInput13.getText().equals("Aulas")) {
			txtInput13.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput13.getText().equals("")) {
			txtInput13.setText("Aulas");
			txtInput13.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput13.setBorder(null);
		txtInput13.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput13.setSelectionColor(MyColors.ACCENT);
		txtInput13.setForeground(MyColors.PLACEHOLDER);
		txtInput13.setText("Aulas");
		txtInput13.setBackground(MyColors.BACKGROUND);
		txtInput13.setBounds(10, 5, 100, 15);
		pnlInput13.add(txtInput13);
		txtInput13.setColumns(10);
		txtInput13.setVisible(false);

		///////////////////////// Input 14 /////////////////////////
		
		JPanel pnlInput14 = new JPanel();
		pnlInput14.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput14.setBackground(MyColors.BACKGROUND);
		pnlInput14.setBounds(115, 300, 115, 25);
		add(pnlInput14);
		pnlInput14.setLayout(null);
		pnlInput14.setVisible(false);
		
		JTextField txtInput14 = new JTextField();
		txtInput14.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
		txtInput14.setForeground(MyColors.TEXT);
		if (txtInput14.getText().equals("Ano Ingresso")) {
			txtInput14.setText("");
		}
		}
		@Override
		public void focusLost(FocusEvent e) {
		if (txtInput14.getText().equals("")) {
			txtInput14.setText("Ano Ingresso");
			txtInput14.setForeground(MyColors.PLACEHOLDER);
		}
		}
		});
		txtInput14.setBorder(null);
		txtInput14.setFont(new Font("Arial", Font.PLAIN, 13));
		txtInput14.setSelectionColor(MyColors.ACCENT);
		txtInput14.setForeground(MyColors.PLACEHOLDER);
		txtInput14.setText("Ano Ingresso");
		txtInput14.setBackground(MyColors.BACKGROUND);
		txtInput14.setBounds(10, 5, 100, 15);
		pnlInput14.add(txtInput14);
		txtInput14.setColumns(10);
		txtInput14.setVisible(false);

		///////////////////////// Tipo /////////////////////////

		String tipo = cliente instanceof Estudante ? "Estudante" : "Professor";

		if (tipo.equals("Estudante")) {
			pnlInput7.setVisible(true);
			pnlInput8.setVisible(true);
			pnlInput9.setVisible(true);
			txtInput7.setVisible(true);
			txtInput8.setVisible(true);
			txtInput9.setVisible(true);

			pnlInput10.setVisible(false);
			pnlInput11.setVisible(false);
			pnlInput12.setVisible(false);
			pnlInput13.setVisible(false);
			pnlInput14.setVisible(false);
			txtInput10.setVisible(false);
			txtInput11.setVisible(false);
			txtInput12.setVisible(false);
			txtInput13.setVisible(false);
			txtInput14.setVisible(false);
		} else if (tipo.equals("Professor")) {
			pnlInput7.setVisible(false);
			pnlInput8.setVisible(false);
			pnlInput9.setVisible(false);
			txtInput7.setVisible(false);
			txtInput8.setVisible(false);
			txtInput9.setVisible(false);

			pnlInput10.setVisible(true);
			pnlInput11.setVisible(true);
			pnlInput12.setVisible(true);
			pnlInput13.setVisible(true);
			pnlInput14.setVisible(true);
			txtInput10.setVisible(true);
			txtInput11.setVisible(true);
			txtInput12.setVisible(true);
			txtInput13.setVisible(true);
			txtInput14.setVisible(true);
		}

		JPanel pnlEditarBtn = new JPanel();
		pnlEditarBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String message = "";

					String cpf = txtInput1.getText();
					String nome = txtInput2.getText();
					String telefone = txtInput3.getText();
					String email = txtInput4.getText();
					String nascimentoString = txtInput5.getText();
					String senha = txtInput6.getText();
					if (cpf.equals("CPF")) {
						cpf = cliente.getCPF();
					}
					if (nome.equals("Nome")) {
						nome = cliente.getNome();
					}
					if (telefone.equals("Telefone")) {
						telefone = cliente.getTelefone();
					}
					if (email.equals("Email")) {
						email = cliente.getEmail();
					}
					if (nascimentoString.equals("Nascimento")) {
						LocalDate nascimento = cliente.getDataNasc();
					}
					if (senha.equals("Senha")) {
						senha = cliente.getSenha();
					}
					LocalDate nascimento = LocalDate.parse(nascimentoString, dtf);
					
					if (tipo.equals("Estudante")) {
						String matricula = txtInput7.getText();
						String curso = txtInput8.getText();
						int ano_grad = Integer.parseInt(txtInput9.getText());

						//message = cliente.editarDadosEstudante(cpf, nome, telefone, email, nascimento, senha, matricula, curso, ano_grad);
					} else if (tipo.equals("Professor")) {
						String instituicao = txtInput10.getText();
						String educacao = txtInput11.getText();
						String area = txtInput12.getText();
						String aulas = txtInput13.getText();
						int ano_ing = Integer.parseInt(txtInput13.getText());

						//message = cliente.editarDadosProfessor(cpf, nome, telefone, email, nascimento, senha, instituicao, educacao, area, aulas, ano_ing);
					}

					int confirmation = JOptionPane.showConfirmDialog(null, message, "Confirmação", JOptionPane.DEFAULT_OPTION);
					if(confirmation == 0) {
						frameMinhaConta.dispose();
						JFrame frame = new FrameMinhaConta(cliente);
						frame.setVisible(true);
						frame.toFront();
						frame.requestFocus();
					}
				} catch (NumberFormatException error) {
					String message = "Os campos 'Ano Graduação' e 'Ano Ingresso'\ndevem ser preenchidos apenas com números.";
					JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (DateTimeParseException error) {
					String message = "Data tem que estar no formato 'dd/mm/aaaa'.";
					JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException error) {
					JOptionPane.showMessageDialog(null, error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlEditarBtn.setBackground(MyColors.ACCENT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlEditarBtn.setBackground(MyColors.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlEditarBtn.setBackground(MyColors.SECONDARY_ACCENT);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlEditarBtn.setBackground(MyColors.ACCENT);
			}
		});
		pnlEditarBtn.setBackground(MyColors.PRIMARY);
		pnlEditarBtn.setBounds(53, 335, 240, 40);
		add(pnlEditarBtn);
		pnlEditarBtn.setLayout(null);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(MyColors.BACKGROUND);
		lblEditar.setFont(new Font("Arial", Font.BOLD, 14));
		lblEditar.setBounds(0, 5, 250, 30);
		pnlEditarBtn.add(lblEditar);
	}
}