package gui.frames.cliente.reservas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import gui.frames.cliente.FrameCliente;
import gui.frames.style.*;
import sistema.Cliente;

public class FrameReservas extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel iconArrow;
	private JLabel iconX;
	private JPanel pnlTitle;
	private JLabel lblTitle;
	
	private JPanel panelMinhasReservas;
	private JPanel panelReservarItem;
	private JPanel panelCancelarReserva;
	
	private int mouseX;
	private int mouseY;
	
	public FrameReservas(Cliente cliente) {
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
		
		panelMinhasReservas = new PanelMinhasReservas();
		panelReservarItem = new PanelReservarItem();
		panelCancelarReserva = new PanelCancelarReserva();
		
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
				
				JFrame frameCliente = new FrameCliente(cliente);
				frameCliente.setVisible(true);
				frameCliente.toFront();
				frameCliente.requestFocus();
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
		
		JPanel pnlMinhasReservas = new JPanel();
		pnlMinhasReservas.addMouseListener(new PanelButtonMouseAdapter(pnlMinhasReservas) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelMinhasReservas);
			}
		});
		pnlMinhasReservas.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(24, 17, 29)));
		pnlMinhasReservas.setBackground(MyColors.PRIMARY);
		pnlMinhasReservas.setBounds(20, 125, 210, 32);
		pnlMenu.add(pnlMinhasReservas);
		pnlMinhasReservas.setLayout(null);
		
		JLabel lblMinhasReservas = new JLabel("MINHAS RESERVAS");
		lblMinhasReservas.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMinhasReservas.setForeground(MyColors.BACKGROUND);
		lblMinhasReservas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMinhasReservas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinhasReservas.setBounds(30, 6, 150, 20);
		pnlMinhasReservas.add(lblMinhasReservas);
		
		JPanel pnlReservarItem = new JPanel();
		pnlReservarItem.addMouseListener(new PanelButtonMouseAdapter(pnlReservarItem) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelReservarItem);
			}
		});
		pnlReservarItem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlReservarItem.setBackground(MyColors.PRIMARY);
		pnlReservarItem.setBounds(20, 157, 210, 32);
		pnlMenu.add(pnlReservarItem);
		pnlReservarItem.setLayout(null);
		
		JLabel lblReservarItem = new JLabel("RESERVAR ITEM");
		lblReservarItem.setHorizontalTextPosition(SwingConstants.CENTER);
		lblReservarItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblReservarItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservarItem.setForeground(new Color(250, 249, 251));
		lblReservarItem.setFont(new Font("Dialog", Font.BOLD, 14));
		lblReservarItem.setBounds(30, 6, 150, 20);
		pnlReservarItem.add(lblReservarItem);
		
		JPanel pblCancelarReserva = new JPanel();
		pblCancelarReserva.addMouseListener(new PanelButtonMouseAdapter(pblCancelarReserva) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelCancelarReserva);
			}
		});
		pblCancelarReserva.setBackground(MyColors.PRIMARY);
		pblCancelarReserva.setLayout(null);
		pblCancelarReserva.setBounds(20, 189, 210, 32);
		pnlMenu.add(pblCancelarReserva);
		
		JLabel lblCancelarReserva = new JLabel("CANCELAR RESERVA");
		lblCancelarReserva.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCancelarReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelarReserva.setForeground(new Color(250, 249, 251));
		lblCancelarReserva.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCancelarReserva.setAlignmentX(0.5f);
		lblCancelarReserva.setBounds(30, 6, 150, 20);
		pblCancelarReserva.add(lblCancelarReserva);
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBounds(252, 2, 346, 396);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);
		
		pnlMainContent.add(panelMinhasReservas);
		pnlMainContent.add(panelReservarItem);
		pnlMainContent.add(panelCancelarReserva);
		
		menuClicked(null);
	}
	
	public void menuClicked(JPanel selectedPanel) {		
		panelMinhasReservas.setVisible(false);
		panelReservarItem.setVisible(false);
		panelCancelarReserva.setVisible(false);
		
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