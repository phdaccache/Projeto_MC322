package gui.frames.cliente.minhaConta;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import gui.frames.cliente.FrameCliente;
import gui.frames.style.*;

public class FrameMinhaConta extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel iconArrow;
	private JLabel iconX;
	private JPanel pnlTitle;
	private JLabel lblTitle;
	
	private JPanel panelVisualizarDados;
	private JPanel panelEditarDados;
	private JPanel panelExcluirConta;
	
	private int mouseX;
	private int mouseY;
	
	public FrameMinhaConta() {
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
				FrameMinhaConta.this.requestFocus();
			}
		});
		
		panelVisualizarDados = new PanelVisualizarDados();
		panelEditarDados = new PanelEditarDados();
		panelExcluirConta = new PanelExcluirConta();
		
		JPanel dragPanel = new JPanel();
		dragPanel.setOpaque(false);
		dragPanel.setBounds(32, 2, 536, 25);
		contentPane.add(dragPanel);
		
		dragPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				FrameMinhaConta.this.setLocation(FrameMinhaConta.this.getX() + e.getX() - mouseX, FrameMinhaConta.this.getY()+e.getY()-mouseY);
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
				FrameMinhaConta.this.dispose();
				
				JFrame frameCliente = new FrameCliente();
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
		
		lblTitle = new JLabel("MINHA CONTA");
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
		
		JPanel pnlVisualizarDados = new JPanel();
		pnlVisualizarDados.addMouseListener(new PanelButtonMouseAdapter(pnlVisualizarDados) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelVisualizarDados);
			}
		});
		pnlVisualizarDados.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(24, 17, 29)));
		pnlVisualizarDados.setBackground(MyColors.PRIMARY);
		pnlVisualizarDados.setBounds(20, 125, 210, 32);
		pnlMenu.add(pnlVisualizarDados);
		pnlVisualizarDados.setLayout(null);
		
		JLabel lblVisualizarDados = new JLabel("VISUALIZAR DADOS");
		lblVisualizarDados.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblVisualizarDados.setForeground(MyColors.BACKGROUND);
		lblVisualizarDados.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVisualizarDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisualizarDados.setBounds(30, 6, 150, 20);
		pnlVisualizarDados.add(lblVisualizarDados);
		
		JPanel pnlEditarDados = new JPanel();
		pnlEditarDados.addMouseListener(new PanelButtonMouseAdapter(pnlEditarDados) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelEditarDados);
			}
		});
		pnlEditarDados.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlEditarDados.setBackground(MyColors.PRIMARY);
		pnlEditarDados.setBounds(20, 157, 210, 32);
		pnlMenu.add(pnlEditarDados);
		pnlEditarDados.setLayout(null);
		
		JLabel lblEditarDados = new JLabel("EDITAR DADOS");
		lblEditarDados.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEditarDados.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblEditarDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarDados.setForeground(new Color(250, 249, 251));
		lblEditarDados.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEditarDados.setBounds(30, 6, 150, 20);
		pnlEditarDados.add(lblEditarDados);
		
		JPanel pnlExcluirConta = new JPanel();
		pnlExcluirConta.addMouseListener(new PanelButtonMouseAdapter(pnlExcluirConta) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelExcluirConta);
			}
		});
		pnlExcluirConta.setBackground(MyColors.PRIMARY);
		pnlExcluirConta.setLayout(null);
		pnlExcluirConta.setBounds(20, 189, 210, 32);
		pnlMenu.add(pnlExcluirConta);
		
		JLabel lblExcluirConta = new JLabel("EXCLUIR CONTA");
		lblExcluirConta.setHorizontalTextPosition(SwingConstants.CENTER);
		lblExcluirConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirConta.setForeground(new Color(250, 249, 251));
		lblExcluirConta.setFont(new Font("Dialog", Font.BOLD, 14));
		lblExcluirConta.setAlignmentX(0.5f);
		lblExcluirConta.setBounds(30, 6, 150, 20);
		pnlExcluirConta.add(lblExcluirConta);
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBounds(252, 2, 346, 396);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);
		
		pnlMainContent.add(panelVisualizarDados);
		pnlMainContent.add(panelEditarDados);
		pnlMainContent.add(panelExcluirConta);
		
		menuClicked(null);
	}
	
	public void menuClicked(JPanel selectedPanel) {		
		panelVisualizarDados.setVisible(false);
		panelEditarDados.setVisible(false);
		panelExcluirConta.setVisible(false);
		
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