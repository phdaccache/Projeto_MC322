package gui.frames;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import gui.frames.admin.FrameAdmin;
import gui.frames.biblioteca.FrameLoginBiblioteca;
import gui.frames.cliente.FrameLoginCliente;
import gui.frames.style.DrawingCanvasMain;
import gui.frames.style.MyColor;

public class FrameMain extends JFrame {
	private Image img_books = new ImageIcon(FrameLoginBiblioteca.class.getResource("../../res/books.png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlDecoration;
	private JPanel pnlTitle;
	private JLabel iconX;
	private JLabel lblTitle;
	private JLabel lblIconBooks;

	public FrameMain() {		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(MyColor.ACCENT);
		contentPane.setBorder(new LineBorder(MyColor.ACCENT, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		iconX = new JLabel("X");
		iconX.setAlignmentX(Component.CENTER_ALIGNMENT);
		iconX.setOpaque(true);
		iconX.setBackground(MyColor.PRIMARY);
		iconX.setForeground(MyColor.BACKGROUND);
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
			}
			@Override
			public void mouseExited(MouseEvent e) {
				iconX.setBackground(MyColor.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				iconX.setBackground(MyColor.SECONDARY_CLOSE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				iconX.setBackground(MyColor.CLOSE);
			}
		});
		contentPane.add(iconX);
		
		DrawingCanvasMain drawingCanvas = new DrawingCanvasMain();
		contentPane.add(drawingCanvas);
		
		pnlTitle = new JPanel();
		pnlTitle.setBounds(50, 140, 250, 60);
		pnlTitle.setBackground(MyColor.SECONDARY_BACKGROUND);
		contentPane.add(pnlTitle);
		pnlTitle.setLayout(null);
		
		lblTitle = new JLabel("Sistema de");
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setForeground(MyColor.PRIMARY);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 40));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 250, 60);
		pnlTitle.add(lblTitle);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(MyColor.PRIMARY);
		pnlMenu.setBounds(350, 2, 248, 396);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		JPanel pnlAdmin = new JPanel();
		pnlAdmin.addMouseListener(new PanelButtonMouseAdapter(pnlAdmin) {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameAdmin = new FrameAdmin();
				menuClicked(frameAdmin);
			}
		});
		pnlAdmin.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(24, 17, 29)));
		pnlAdmin.setBackground(MyColor.PRIMARY);
		pnlAdmin.setBounds(20, 120, 210, 40);
		pnlMenu.add(pnlAdmin);
		pnlAdmin.setLayout(null);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAdmin.setForeground(MyColor.BACKGROUND);
		lblAdmin.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(30, 10, 150, 20);
		pnlAdmin.add(lblAdmin);
		
		JPanel pnlLoginBiblioteca = new JPanel();
		pnlLoginBiblioteca.addMouseListener(new PanelButtonMouseAdapter(pnlLoginBiblioteca) {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameLoginBiblioteca = new FrameLoginBiblioteca();
				menuClicked(frameLoginBiblioteca);
			}
		});
		pnlLoginBiblioteca.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColor.TEXT));
		pnlLoginBiblioteca.setBackground(MyColor.PRIMARY);
		pnlLoginBiblioteca.setBounds(20, 160, 210, 40);
		pnlMenu.add(pnlLoginBiblioteca);
		pnlLoginBiblioteca.setLayout(null);
		
		JLabel lblLoginBiblioteca = new JLabel("LOGIN BIBLIOTECA");
		lblLoginBiblioteca.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLoginBiblioteca.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblLoginBiblioteca.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginBiblioteca.setForeground(new Color(250, 249, 251));
		lblLoginBiblioteca.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLoginBiblioteca.setBounds(30, 10, 150, 20);
		pnlLoginBiblioteca.add(lblLoginBiblioteca);
		
		JPanel pnlLoginCliente = new JPanel();
		pnlLoginCliente.addMouseListener(new PanelButtonMouseAdapter(pnlLoginCliente) {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameLoginCliente = new FrameLoginCliente();
				menuClicked(frameLoginCliente);
			}
		});
		pnlLoginCliente.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColor.TEXT));
		pnlLoginCliente.setBackground(MyColor.PRIMARY);
		pnlLoginCliente.setLayout(null);
		pnlLoginCliente.setBounds(20, 200, 210, 40);
		pnlMenu.add(pnlLoginCliente);
		
		JLabel lblLoginCliente = new JLabel("LOGIN CLIENTE");
		lblLoginCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLoginCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginCliente.setForeground(new Color(250, 249, 251));
		lblLoginCliente.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLoginCliente.setAlignmentX(0.5f);
		lblLoginCliente.setBounds(30, 10, 150, 20);
		pnlLoginCliente.add(lblLoginCliente);
		
		JPanel pnlSair = new JPanel();
		pnlSair.addMouseListener(new PanelButtonMouseAdapter(pnlSair) {
			@Override
			public void mouseClicked(MouseEvent e) {
				int confirmation = JOptionPane.showConfirmDialog(null, "Encerrar Programa?", "Confirmation", JOptionPane.WARNING_MESSAGE);
				if(confirmation == 0) {
					System.exit(0);
				}
			}
		});
		pnlSair.setBackground(MyColor.PRIMARY);
		pnlSair.setLayout(null);
		pnlSair.setBounds(20, 240, 210, 40);
		pnlMenu.add(pnlSair);
		
		JLabel lblSair = new JLabel("SAIR");
		lblSair.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setForeground(new Color(250, 249, 251));
		lblSair.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSair.setAlignmentX(0.5f);
		lblSair.setBounds(30, 10, 150, 20);
		pnlSair.add(lblSair);
		
		pnlDecoration = new JPanel();
		pnlDecoration.setBounds(2, 2, 346, 396);
		contentPane.add(pnlDecoration);
		pnlDecoration.setLayout(null);
		
		lblIconBooks = new JLabel("");
		lblIconBooks.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIconBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconBooks.setBounds(50, 20, 250, 110);
		lblIconBooks.setIcon(new ImageIcon(img_books));
		pnlDecoration.add(lblIconBooks);
		
		JPanel pnlCredits = new JPanel();
		pnlCredits.setBounds(40, 272, 250, 80);
		pnlDecoration.add(pnlCredits);
		pnlCredits.setLayout(null);
		
		JLabel lblCreditsTitle = new JLabel("Projeto Final MC322 - 1s2023");
		lblCreditsTitle.setForeground(MyColor.PRIMARY);
		lblCreditsTitle.setBackground(MyColor.SECONDARY_BACKGROUND);
		lblCreditsTitle.setFont(new Font("Arial", Font.BOLD, 12));
		lblCreditsTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCreditsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreditsTitle.setBounds(0, 0, 250, 16);
		pnlCredits.add(lblCreditsTitle);
		
		JLabel lblNome1 = new JLabel("Pedro Henrique Antoine Cortez Daccache");
		lblNome1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNome1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome1.setForeground(MyColor.PRIMARY);
		lblNome1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome1.setBackground(new Color(238, 237, 239));
		lblNome1.setBounds(0, 16, 250, 16);
		pnlCredits.add(lblNome1);
		
		JLabel lblNome2 = new JLabel("Bernardo de Andrade Dias da Costa");
		lblNome2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNome2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome2.setForeground(MyColor.PRIMARY);
		lblNome2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome2.setBackground(new Color(238, 237, 239));
		lblNome2.setBounds(0, 32, 250, 16);
		pnlCredits.add(lblNome2);
		
		JLabel lblNome3 = new JLabel("Isabela Velasco Ferrer Almeida");
		lblNome3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNome3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome3.setForeground(MyColor.PRIMARY);
		lblNome3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome3.setBackground(new Color(238, 237, 239));
		lblNome3.setBounds(0, 48, 250, 16);
		pnlCredits.add(lblNome3);
		
		JLabel lblNome4 = new JLabel("Ayla Cristine Pereira Machado");
		lblNome4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNome4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome4.setForeground(MyColor.PRIMARY);
		lblNome4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome4.setBackground(new Color(238, 237, 239));
		lblNome4.setBounds(0, 64, 250, 16);
		pnlCredits.add(lblNome4);
	}
	
	public void menuClicked(JFrame frame) {
		FrameMain.this.dispose();
		
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