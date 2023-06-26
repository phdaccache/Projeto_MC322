package gui.frames.cliente.itens;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import gui.frames.cliente.FrameCliente;
import gui.frames.style.*;

public class FrameItens extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel iconArrow;
	private JLabel iconX;
	private JPanel pnlTitle;
	private JLabel lblTitle;
	
	private JPanel panelPesquisarItem;
	private JPanel panelUltimasAquisicoes;
	
	public FrameItens() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(MyColor.ACCENT);
		contentPane.setBorder(new LineBorder(MyColor.ACCENT, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameItens.this.requestFocus();
			}
		});
		
		panelPesquisarItem = new PanelPesquisarItem();
		panelUltimasAquisicoes = new PanelUltimasAquisicoes();
		
		iconArrow = new JLabel("< ");
		iconArrow.setOpaque(true);
		iconArrow.setBackground(MyColor.PRIMARY);
		iconArrow.setForeground(MyColor.BACKGROUND);
		iconArrow.setHorizontalTextPosition(SwingConstants.CENTER);
		iconArrow.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
		iconArrow.setHorizontalAlignment(SwingConstants.CENTER);
		iconArrow.setBounds(2, 2, 30, 25);
		iconArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameItens.this.dispose();
				
				JFrame frameCliente = new FrameCliente();
				frameCliente.setVisible(true);
				frameCliente.toFront();
				frameCliente.requestFocus();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				iconArrow.setBackground(MyColor.PLACEHOLDER);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				iconArrow.setBackground(MyColor.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				iconArrow.setBackground(MyColor.SECONDARY_PLACEHOLDER);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				iconArrow.setBackground(MyColor.PLACEHOLDER);
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
	
		pnlTitle = new JPanel();
		pnlTitle.setBounds(2, 45, 248, 60);
		pnlTitle.setBackground(MyColor.ACCENT);
		contentPane.add(pnlTitle);
		pnlTitle.setLayout(null);
		
		lblTitle = new JLabel("ITENS");
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setForeground(MyColor.BACKGROUND);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 248, 60);
		pnlTitle.add(lblTitle);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(MyColor.PRIMARY);
		pnlMenu.setBounds(2, 2, 248, 396);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		JPanel pnlPesquisarItem = new JPanel();
		pnlPesquisarItem.addMouseListener(new PanelButtonMouseAdapter(pnlPesquisarItem) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelPesquisarItem);
			}
		});
		pnlPesquisarItem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(24, 17, 29)));
		pnlPesquisarItem.setBackground(MyColor.PRIMARY);
		pnlPesquisarItem.setBounds(20, 125, 210, 32);
		pnlMenu.add(pnlPesquisarItem);
		pnlPesquisarItem.setLayout(null);
		
		JLabel lblPesquisarItem = new JLabel("PESQUISAR ITEM");
		lblPesquisarItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPesquisarItem.setForeground(MyColor.BACKGROUND);
		lblPesquisarItem.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPesquisarItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisarItem.setBounds(30, 6, 150, 20);
		pnlPesquisarItem.add(lblPesquisarItem);
		
		JPanel pnlUltimasAquisicoes = new JPanel();
		pnlUltimasAquisicoes.addMouseListener(new PanelButtonMouseAdapter(pnlUltimasAquisicoes) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelUltimasAquisicoes);
			}
		});
		pnlUltimasAquisicoes.setBackground(MyColor.PRIMARY);
		pnlUltimasAquisicoes.setBounds(20, 157, 210, 32);
		pnlMenu.add(pnlUltimasAquisicoes);
		pnlUltimasAquisicoes.setLayout(null);
		
		JLabel lblUltimasAquisicoes = new JLabel("ÚLTIMAS AQUISIÇÕES");
		lblUltimasAquisicoes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUltimasAquisicoes.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUltimasAquisicoes.setHorizontalAlignment(SwingConstants.CENTER);
		lblUltimasAquisicoes.setForeground(new Color(250, 249, 251));
		lblUltimasAquisicoes.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUltimasAquisicoes.setBounds(0, 6, 210, 20);
		pnlUltimasAquisicoes.add(lblUltimasAquisicoes);
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBounds(252, 2, 346, 396);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);
		
		pnlMainContent.add(panelPesquisarItem);
		pnlMainContent.add(panelUltimasAquisicoes);
		
		menuClicked(null);
	}
	
	public void menuClicked(JPanel selectedPanel) {		
		panelPesquisarItem.setVisible(false);
		panelUltimasAquisicoes.setVisible(false);
		
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