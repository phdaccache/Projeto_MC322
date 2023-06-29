package gui.frames.cliente.emprestimos;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import gui.frames.cliente.FrameCliente;
import gui.frames.style.*;

public class FrameEmprestimos extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel iconArrow;
	private JLabel iconX;
	private JPanel pnlTitle;
	private JLabel lblTitle;
	
	private JPanel panelMeusEmprestimos;
	private JPanel panelEmprestimosAtrasados;
	private JPanel panelGerarEmprestimo;
	private JPanel panelDevolverEmprestimo;
	private JPanel panelRenovarEmprestimo;
	
	private int mouseX;
	private int mouseY;
	
	public FrameEmprestimos() {
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
				FrameEmprestimos.this.requestFocus();
			}
		});
		
		panelMeusEmprestimos = new PanelMeusEmprestimos();
		panelEmprestimosAtrasados = new PanelEmprestimosAtrasados();
		panelGerarEmprestimo = new PanelGerarEmprestimo();
		panelDevolverEmprestimo = new PanelDevolverEmprestimo();
		panelRenovarEmprestimo = new PanelRenovarEmprestimo();
		
		JPanel dragPanel = new JPanel();
		dragPanel.setOpaque(false);
		dragPanel.setBounds(32, 2, 536, 25);
		contentPane.add(dragPanel);
		
		dragPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				FrameEmprestimos.this.setLocation(FrameEmprestimos.this.getX() + e.getX() - mouseX, FrameEmprestimos.this.getY()+e.getY()-mouseY);
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
				FrameEmprestimos.this.dispose();
				
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
		
		lblTitle = new JLabel("EMPRÉSTIMOS");
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
		
		JPanel pnlMeusEmprestimos = new JPanel();
		pnlMeusEmprestimos.addMouseListener(new PanelButtonMouseAdapter(pnlMeusEmprestimos) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelMeusEmprestimos);
			}
		});
		pnlMeusEmprestimos.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(24, 17, 29)));
		pnlMeusEmprestimos.setBackground(MyColors.PRIMARY);
		pnlMeusEmprestimos.setBounds(20, 125, 210, 32);
		pnlMenu.add(pnlMeusEmprestimos);
		pnlMeusEmprestimos.setLayout(null);
		
		JLabel lblMeusEmprestimos = new JLabel("MEUS EMPRÉSTIMOS");
		lblMeusEmprestimos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMeusEmprestimos.setForeground(MyColors.BACKGROUND);
		lblMeusEmprestimos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMeusEmprestimos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeusEmprestimos.setBounds(0, 6, 210, 20);
		pnlMeusEmprestimos.add(lblMeusEmprestimos);
		
		JPanel pnlEmprestimosAtrasados = new JPanel();
		pnlEmprestimosAtrasados.addMouseListener(new PanelButtonMouseAdapter(pnlEmprestimosAtrasados) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelEmprestimosAtrasados);
			}
		});
		pnlEmprestimosAtrasados.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlEmprestimosAtrasados.setBackground(MyColors.PRIMARY);
		pnlEmprestimosAtrasados.setBounds(20, 157, 210, 32);
		pnlMenu.add(pnlEmprestimosAtrasados);
		pnlEmprestimosAtrasados.setLayout(null);
		
		JLabel lblEmprestimosAtrasados = new JLabel("EMPRÉSTIMOS ATRASADOS");
		lblEmprestimosAtrasados.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmprestimosAtrasados.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblEmprestimosAtrasados.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmprestimosAtrasados.setForeground(new Color(250, 249, 251));
		lblEmprestimosAtrasados.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmprestimosAtrasados.setBounds(0, 6, 210, 20);
		pnlEmprestimosAtrasados.add(lblEmprestimosAtrasados);
		
		JPanel pnlGerarEmprestimo = new JPanel();
		pnlGerarEmprestimo.addMouseListener(new PanelButtonMouseAdapter(pnlGerarEmprestimo) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelGerarEmprestimo);
			}
		});
		pnlGerarEmprestimo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlGerarEmprestimo.setBackground(MyColors.PRIMARY);
		pnlGerarEmprestimo.setLayout(null);
		pnlGerarEmprestimo.setBounds(20, 189, 210, 32);
		pnlMenu.add(pnlGerarEmprestimo);
		
		JLabel lblGerarEmprestimo = new JLabel("GERAR EMPRÉSTIMO");
		lblGerarEmprestimo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGerarEmprestimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerarEmprestimo.setForeground(new Color(250, 249, 251));
		lblGerarEmprestimo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGerarEmprestimo.setAlignmentX(0.5f);
		lblGerarEmprestimo.setBounds(0, 6, 210, 20);
		pnlGerarEmprestimo.add(lblGerarEmprestimo);
		
		JPanel pnlDevolverEmprestimo = new JPanel();
		pnlDevolverEmprestimo.addMouseListener(new PanelButtonMouseAdapter(pnlDevolverEmprestimo) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelDevolverEmprestimo);
			}
		});
		pnlDevolverEmprestimo.setLayout(null);
		pnlDevolverEmprestimo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlDevolverEmprestimo.setBackground(new Color(121, 98, 68));
		pnlDevolverEmprestimo.setBounds(20, 221, 210, 32);
		pnlMenu.add(pnlDevolverEmprestimo);
		
		JLabel lblDevolverEmprestimo = new JLabel("DEVOLVER EMPRÉSTIMO");
		lblDevolverEmprestimo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDevolverEmprestimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevolverEmprestimo.setForeground(new Color(250, 249, 251));
		lblDevolverEmprestimo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDevolverEmprestimo.setAlignmentX(0.5f);
		lblDevolverEmprestimo.setBounds(0, 6, 210, 20);
		pnlDevolverEmprestimo.add(lblDevolverEmprestimo);
		
		JPanel pnlRenovarEmprestimo = new JPanel();
		pnlRenovarEmprestimo.addMouseListener(new PanelButtonMouseAdapter(pnlRenovarEmprestimo) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelRenovarEmprestimo);
			}
		});
		pnlRenovarEmprestimo.setLayout(null);
		pnlRenovarEmprestimo.setBackground(new Color(121, 98, 68));
		pnlRenovarEmprestimo.setBounds(20, 253, 210, 32);
		pnlMenu.add(pnlRenovarEmprestimo);
		
		JLabel lblRenovarEmprestimo = new JLabel("RENOVAR EMPÉSTIMO");
		lblRenovarEmprestimo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRenovarEmprestimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRenovarEmprestimo.setForeground(new Color(250, 249, 251));
		lblRenovarEmprestimo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRenovarEmprestimo.setAlignmentX(0.5f);
		lblRenovarEmprestimo.setBounds(0, 6, 210, 20);
		pnlRenovarEmprestimo.add(lblRenovarEmprestimo);
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBounds(252, 2, 346, 396);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);
		
		pnlMainContent.add(panelMeusEmprestimos);
		pnlMainContent.add(panelEmprestimosAtrasados);
		pnlMainContent.add(panelGerarEmprestimo);
		pnlMainContent.add(panelDevolverEmprestimo);
		pnlMainContent.add(panelRenovarEmprestimo);
		
		menuClicked(null);
	}
	
	public void menuClicked(JPanel selectedPanel) {		
		panelMeusEmprestimos.setVisible(false);
		panelEmprestimosAtrasados.setVisible(false);
		panelGerarEmprestimo.setVisible(false);
		panelDevolverEmprestimo.setVisible(false);
		panelRenovarEmprestimo.setVisible(false);
		
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