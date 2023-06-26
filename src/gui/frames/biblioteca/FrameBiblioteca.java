package gui.frames.biblioteca;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import gui.frames.*;
import gui.frames.biblioteca.clientes.FrameClientes;
import gui.frames.biblioteca.emprestimos.FrameEmprestimos;
import gui.frames.biblioteca.itens.FrameItens;
import gui.frames.biblioteca.minhaConta.FrameMinhaConta;
import gui.frames.biblioteca.reservas.FrameReservas;
import gui.frames.style.*;

public class FrameBiblioteca extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel iconArrow;
	private JLabel iconX;
	private JPanel pnlTitle;
	private JLabel lblTitle;
	private JPanel pnlMenu;
	private JPanel pnlMinhaConta;
	private JLabel lblMinhaConta;
	private JPanel pnlClientes;
	private JLabel lblClientes;
	private JPanel pnlItens;
	private JLabel lblItens;
	private JPanel pnlEmprestimos;
	private JLabel lblEmprestimos;
	private JPanel pnlReservas;
	private JLabel lblReservas;

	public FrameBiblioteca() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(MyColor.SECONDARY_BACKGROUND);
		contentPane.setBorder(new LineBorder(MyColor.ACCENT, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameBiblioteca.this.requestFocus();
			}
		});
		
		iconArrow = new JLabel("< ");
		iconArrow.setOpaque(true);
		iconArrow.setBackground(MyColor.SECONDARY_BACKGROUND);
		iconArrow.setForeground(MyColor.PRIMARY);
		iconArrow.setHorizontalTextPosition(SwingConstants.CENTER);
		iconArrow.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
		iconArrow.setHorizontalAlignment(SwingConstants.CENTER);
		iconArrow.setBounds(2, 2, 30, 25);
		iconArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int confirmation = JOptionPane.showConfirmDialog(null, "Sair da Conta?", "Confirmation", JOptionPane.WARNING_MESSAGE);
				if(confirmation == 0) {
					FrameBiblioteca.this.dispose();
					
					JFrame frameLoginBiblioteca = new FrameLoginBiblioteca();
					frameLoginBiblioteca.setVisible(true);
					frameLoginBiblioteca.toFront();
					frameLoginBiblioteca.requestFocus();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				iconArrow.setBackground(MyColor.PLACEHOLDER);
				iconArrow.setForeground(MyColor.BACKGROUND);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				iconArrow.setBackground(MyColor.SECONDARY_BACKGROUND);
				iconArrow.setForeground(MyColor.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				iconArrow.setBackground(MyColor.SECONDARY_PLACEHOLDER);
				iconArrow.setForeground(MyColor.BACKGROUND);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				iconArrow.setBackground(MyColor.PLACEHOLDER);
				iconArrow.setForeground(MyColor.BACKGROUND);
			}
		});
		contentPane.add(iconArrow);
		
		iconX = new JLabel("X");
		iconX.setOpaque(true);
		iconX.setBackground(MyColor.SECONDARY_BACKGROUND);
		iconX.setForeground(MyColor.PRIMARY);
		iconX.setHorizontalTextPosition(SwingConstants.CENTER);
		iconX.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
		iconX.setHorizontalAlignment(SwingConstants.CENTER);
		iconX.setBounds(568, 2, 30, 25);
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
				iconX.setBackground(MyColor.CLOSE);
				iconX.setForeground(MyColor.BACKGROUND);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				iconX.setBackground(MyColor.SECONDARY_BACKGROUND);
				iconX.setForeground(MyColor.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				iconX.setBackground(MyColor.SECONDARY_CLOSE);
				iconX.setForeground(MyColor.BACKGROUND);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				iconX.setBackground(MyColor.CLOSE);
				iconX.setForeground(MyColor.BACKGROUND);
			}
		});
		contentPane.add(iconX);
		
		DrawingCanvasBiblioteca drawingCanvas = new DrawingCanvasBiblioteca();
		contentPane.add(drawingCanvas);
		
		pnlTitle = new JPanel();
		pnlTitle.setBounds(175, 45, 250, 60);
		pnlTitle.setBackground(MyColor.SECONDARY_BACKGROUND);
		contentPane.add(pnlTitle);
		pnlTitle.setLayout(null);
		
		lblTitle = new JLabel("Área da");
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setForeground(MyColor.PRIMARY);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 40));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 250, 60);
		pnlTitle.add(lblTitle);
		
		pnlMenu = new JPanel();
		pnlMenu.setBackground(MyColor.PRIMARY);
		pnlMenu.setBounds(2, 184, 596, 214);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		pnlMinhaConta = new JPanel();
		pnlMinhaConta.addMouseListener(new PanelButtonMouseAdapter(pnlMinhaConta) {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameMinhaConta = new FrameMinhaConta();
				menuClicked(frameMinhaConta);
			}
		});
		pnlMinhaConta.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColor.TEXT));
		pnlMinhaConta.setBackground(MyColor.PRIMARY);
		pnlMinhaConta.setBounds(193, 7, 210, 40);
		pnlMenu.add(pnlMinhaConta);
		pnlMinhaConta.setLayout(null);
		
		lblMinhaConta = new JLabel("MINHA CONTA");
		lblMinhaConta.setForeground(MyColor.BACKGROUND);
		lblMinhaConta.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMinhaConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinhaConta.setBounds(30, 10, 150, 20);
		pnlMinhaConta.add(lblMinhaConta);
		
		pnlClientes = new JPanel();
		pnlClientes.addMouseListener(new PanelButtonMouseAdapter(pnlClientes) {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameClientes = new FrameClientes();
				menuClicked(frameClientes);
			}
		});
		pnlClientes.setLayout(null);
		pnlClientes.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColor.TEXT));
		pnlClientes.setBackground(new Color(121, 98, 68));
		pnlClientes.setBounds(193, 47, 210, 40);
		pnlMenu.add(pnlClientes);
		
		lblClientes = new JLabel("CLIENTES");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(new Color(250, 249, 251));
		lblClientes.setFont(new Font("Dialog", Font.BOLD, 14));
		lblClientes.setBounds(30, 10, 150, 20);
		pnlClientes.add(lblClientes);
		
		pnlItens = new JPanel();
		pnlItens.addMouseListener(new PanelButtonMouseAdapter(pnlItens) {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameItens = new FrameItens();
				menuClicked(frameItens);
			}
		});
		pnlItens.setLayout(null);
		pnlItens.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColor.TEXT));
		pnlItens.setBackground(new Color(121, 98, 68));
		pnlItens.setBounds(193, 87, 210, 40);
		pnlMenu.add(pnlItens);
		
		lblItens = new JLabel("ITENS");
		lblItens.setHorizontalAlignment(SwingConstants.CENTER);
		lblItens.setForeground(new Color(250, 249, 251));
		lblItens.setFont(new Font("Dialog", Font.BOLD, 14));
		lblItens.setBounds(30, 10, 150, 20);
		pnlItens.add(lblItens);
		
		pnlEmprestimos = new JPanel();
		pnlEmprestimos.addMouseListener(new PanelButtonMouseAdapter(pnlEmprestimos) {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameEmprestimos = new FrameEmprestimos();
				menuClicked(frameEmprestimos);
			}
		});
		pnlEmprestimos.setLayout(null);
		pnlEmprestimos.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColor.TEXT));
		pnlEmprestimos.setBackground(new Color(121, 98, 68));
		pnlEmprestimos.setBounds(193, 127, 210, 40);
		pnlMenu.add(pnlEmprestimos);
		
		lblEmprestimos = new JLabel("EMPRÉSTIMOS");
		lblEmprestimos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmprestimos.setForeground(new Color(250, 249, 251));
		lblEmprestimos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmprestimos.setBounds(30, 10, 150, 20);
		pnlEmprestimos.add(lblEmprestimos);
		
		pnlReservas = new JPanel();
		pnlReservas.addMouseListener(new PanelButtonMouseAdapter(pnlReservas) {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameReservas = new FrameReservas();
				menuClicked(frameReservas);
			}
		});
		pnlReservas.setLayout(null);
		pnlReservas.setBackground(new Color(121, 98, 68));
		pnlReservas.setBounds(193, 167, 210, 40);
		pnlMenu.add(pnlReservas);
		
		lblReservas = new JLabel("RESERVAS");
		lblReservas.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservas.setForeground(new Color(250, 249, 251));
		lblReservas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblReservas.setBounds(30, 10, 150, 20);
		pnlReservas.add(lblReservas);
		
		//JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(150, 81, 300, 253);
		//contentPane.add(scrollPane);
		
		//JTextArea textArea = new JTextArea();
		//scrollPane.setViewportView(textArea);
	}
	
	public void menuClicked(JFrame frame) {
		FrameBiblioteca.this.dispose();
		
		frame.setVisible(true);
		frame.toFront();
		frame.requestFocus();
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;
		
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(MyColor.ACCENT);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(MyColor.PRIMARY);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(MyColor.SECONDARY_ACCENT);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(MyColor.ACCENT);
		}
	}
}