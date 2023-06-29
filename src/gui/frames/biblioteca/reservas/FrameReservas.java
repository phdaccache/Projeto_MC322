package gui.frames.biblioteca.reservas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import gui.frames.biblioteca.*;
import gui.frames.style.*;
import sistema.Biblioteca;

public class FrameReservas extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel iconArrow;
	private JLabel iconX;
	private JPanel pnlTitle;
	private JLabel lblTitle;
	
	private JPanel panelListarTodasAsReservas;
	private JPanel panelListarReservasPorCliente;
	
	private int mouseX;
	private int mouseY;
	
	public FrameReservas(Biblioteca biblioteca) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(MyColors.ACCENT);
		contentPane.setBorder(new LineBorder(MyColors.ACCENT, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameReservas.this.requestFocus();
			}
		});
		
		panelListarTodasAsReservas = new PanelListarTodasAsReservas(biblioteca);
		panelListarReservasPorCliente = new PanelListarReservasPorCliente(biblioteca);
		
		JPanel dragPanel = new JPanel();
		dragPanel.setOpaque(false);
		dragPanel.setBounds(32, 2, 536, 25);
		contentPane.add(dragPanel);
		
		dragPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				FrameReservas.this.setLocation(FrameReservas.this.getX() + e.getX() - mouseX, FrameReservas.this.getY()+e.getY()-mouseY);
			}
		});
		dragPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX= e.getX();
				mouseY=e.getY();
			}
		});
		
		iconArrow = new JLabel("< ");
		iconArrow.setOpaque(true);
		iconArrow.setBackground(MyColors.PRIMARY);
		iconArrow.setForeground(MyColors.BACKGROUND);
		iconArrow.setHorizontalTextPosition(SwingConstants.CENTER);
		iconArrow.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
		iconArrow.setHorizontalAlignment(SwingConstants.CENTER);
		iconArrow.setBounds(2, 2, 30, 25);
		iconArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameReservas.this.dispose();
				
				JFrame frameBiblioteca = new FrameBiblioteca(biblioteca);
				frameBiblioteca.setVisible(true);
				frameBiblioteca.toFront();
				frameBiblioteca.requestFocus();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				iconArrow.setBackground(MyColors.PLACEHOLDER);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				iconArrow.setBackground(MyColors.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				iconArrow.setBackground(MyColors.SECONDARY_PLACEHOLDER);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				iconArrow.setBackground(MyColors.PLACEHOLDER);
			}
		});
		contentPane.add(iconArrow);
		
		iconX = new JLabel("X");
		iconX.setOpaque(true);
		iconX.setBackground(MyColors.SECONDARY_BACKGROUND);
		iconX.setForeground(MyColors.PRIMARY);
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
		contentPane.add(iconX);
	
		pnlTitle = new JPanel();
		pnlTitle.setBounds(2, 45, 248, 60);
		pnlTitle.setBackground(MyColors.ACCENT);
		contentPane.add(pnlTitle);
		pnlTitle.setLayout(null);
		
		lblTitle = new JLabel("RESERVAS");
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setForeground(MyColors.BACKGROUND);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 248, 60);
		pnlTitle.add(lblTitle);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(MyColors.PRIMARY);
		pnlMenu.setBounds(2, 2, 248, 396);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		JPanel pnlListarTodasAsReservas = new JPanel();
		pnlListarTodasAsReservas.addMouseListener(new PanelButtonMouseAdapter(pnlListarTodasAsReservas) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarTodasAsReservas);
			}
		});
		pnlListarTodasAsReservas.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(24, 17, 29)));
		pnlListarTodasAsReservas.setBackground(MyColors.PRIMARY);
		pnlListarTodasAsReservas.setBounds(20, 125, 210, 32);
		pnlMenu.add(pnlListarTodasAsReservas);
		pnlListarTodasAsReservas.setLayout(null);
		
		JLabel lblListarTodasAsReservas = new JLabel("RESERVAS");
		lblListarTodasAsReservas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListarTodasAsReservas.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblListarTodasAsReservas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarTodasAsReservas.setForeground(new Color(250, 249, 251));
		lblListarTodasAsReservas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarTodasAsReservas.setBounds(0, 6, 210, 20);
		pnlListarTodasAsReservas.add(lblListarTodasAsReservas);
		
		JPanel pnlListarReservasPorCliente = new JPanel();
		pnlListarReservasPorCliente.addMouseListener(new PanelButtonMouseAdapter(pnlListarReservasPorCliente) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarReservasPorCliente);
			}
		});
		pnlListarReservasPorCliente.setBackground(MyColors.PRIMARY);
		pnlListarReservasPorCliente.setBounds(20, 157, 210, 32);
		pnlMenu.add(pnlListarReservasPorCliente);
		pnlListarReservasPorCliente.setLayout(null);
		
		JLabel lblListarReservasPorCliente = new JLabel("RESERVAS POR CLIENTE");
		lblListarReservasPorCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblListarReservasPorCliente.setForeground(MyColors.BACKGROUND);
		lblListarReservasPorCliente.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarReservasPorCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarReservasPorCliente.setBounds(0, 6, 210, 20);
		pnlListarReservasPorCliente.add(lblListarReservasPorCliente);
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBounds(252, 2, 346, 396);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);
		
		pnlMainContent.add(panelListarTodasAsReservas);
		pnlMainContent.add(panelListarReservasPorCliente);
		
		menuClicked(null);
	}
	
	public void menuClicked(JPanel selectedPanel) {		
		panelListarTodasAsReservas.setVisible(false);
		panelListarReservasPorCliente.setVisible(false);
		
		if (selectedPanel != null) {
			selectedPanel.setVisible(true);
		}
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;
		
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(MyColors.ACCENT);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(MyColors.PRIMARY);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(MyColors.SECONDARY_ACCENT);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(MyColors.ACCENT);
		}
	}
}