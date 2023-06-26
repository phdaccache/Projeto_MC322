package gui.frames.biblioteca.emprestimos;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import gui.frames.biblioteca.*;
import gui.frames.style.*;

public class FrameEmprestimos extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel iconArrow;
	private JLabel iconX;
	private JPanel pnlTitle;
	private JLabel lblTitle;
	
	private JPanel panelListarTodosOsEmprestimos;
	private JPanel panelListarEmprestimosAtrasados;
	private JPanel panelListarEmprestimosPorCliente;
	
	public FrameEmprestimos() {
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
				FrameEmprestimos.this.requestFocus();
			}
		});
		
		panelListarTodosOsEmprestimos = new PanelListarTodosOsEmprestimos();
		panelListarEmprestimosAtrasados = new PanelListarEmprestimosAtrasados();
		panelListarEmprestimosPorCliente = new PanelListarEmprestimosPorCliente();
		
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
				FrameEmprestimos.this.dispose();
				
				JFrame frameBiblioteca = new FrameBiblioteca();
				frameBiblioteca.setVisible(true);
				frameBiblioteca.toFront();
				frameBiblioteca.requestFocus();
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
		
		lblTitle = new JLabel("EMPRÉSTIMOS");
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
		
		JPanel pnlListarTodosOsEmprestimos = new JPanel();
		pnlListarTodosOsEmprestimos.addMouseListener(new PanelButtonMouseAdapter(pnlListarTodosOsEmprestimos) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarTodosOsEmprestimos);
			}
		});
		pnlListarTodosOsEmprestimos.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(24, 17, 29)));
		pnlListarTodosOsEmprestimos.setBackground(MyColor.PRIMARY);
		pnlListarTodosOsEmprestimos.setBounds(20, 125, 210, 32);
		pnlMenu.add(pnlListarTodosOsEmprestimos);
		pnlListarTodosOsEmprestimos.setLayout(null);
		
		JLabel lblListarTodosOsEmprestimos = new JLabel("EMPRÉSTIMOS");
		lblListarTodosOsEmprestimos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListarTodosOsEmprestimos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblListarTodosOsEmprestimos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarTodosOsEmprestimos.setForeground(new Color(250, 249, 251));
		lblListarTodosOsEmprestimos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarTodosOsEmprestimos.setBounds(0, 6, 210, 20);
		pnlListarTodosOsEmprestimos.add(lblListarTodosOsEmprestimos);
		
		JPanel pnlListarEmprestimosAtrasados = new JPanel();
		pnlListarEmprestimosAtrasados.addMouseListener(new PanelButtonMouseAdapter(pnlListarEmprestimosAtrasados) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarEmprestimosAtrasados);
			}
		});
		pnlListarEmprestimosAtrasados.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColor.TEXT));
		pnlListarEmprestimosAtrasados.setBackground(MyColor.PRIMARY);
		pnlListarEmprestimosAtrasados.setLayout(null);
		pnlListarEmprestimosAtrasados.setBounds(20, 157, 210, 32);
		pnlMenu.add(pnlListarEmprestimosAtrasados);
		
		JLabel lblListarEmprestimosAtrasados = new JLabel("EMPRÉSTIMOS ATRASADOS");
		lblListarEmprestimosAtrasados.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListarEmprestimosAtrasados.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarEmprestimosAtrasados.setForeground(new Color(250, 249, 251));
		lblListarEmprestimosAtrasados.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarEmprestimosAtrasados.setAlignmentX(0.5f);
		lblListarEmprestimosAtrasados.setBounds(0, 6, 210, 20);
		pnlListarEmprestimosAtrasados.add(lblListarEmprestimosAtrasados);
		
		JPanel pnlListarEmprestimosPorCliente = new JPanel();
		pnlListarEmprestimosPorCliente.addMouseListener(new PanelButtonMouseAdapter(pnlListarEmprestimosPorCliente) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarEmprestimosPorCliente);
			}
		});
		pnlListarEmprestimosPorCliente.setBackground(MyColor.PRIMARY);
		pnlListarEmprestimosPorCliente.setBounds(20, 189, 210, 32);
		pnlMenu.add(pnlListarEmprestimosPorCliente);
		pnlListarEmprestimosPorCliente.setLayout(null);
		
		JLabel lblListarEmprestimosPorCliente = new JLabel("EMPRÉSTIMOS POR CLIENTE");
		lblListarEmprestimosPorCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblListarEmprestimosPorCliente.setForeground(MyColor.BACKGROUND);
		lblListarEmprestimosPorCliente.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarEmprestimosPorCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarEmprestimosPorCliente.setBounds(0, 6, 210, 20);
		pnlListarEmprestimosPorCliente.add(lblListarEmprestimosPorCliente);
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBounds(252, 2, 346, 396);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);
		
		pnlMainContent.add(panelListarTodosOsEmprestimos);
		pnlMainContent.add(panelListarEmprestimosAtrasados);
		pnlMainContent.add(panelListarEmprestimosPorCliente);
		
		menuClicked(null);
	}
	
	public void menuClicked(JPanel selectedPanel) {		
		panelListarTodosOsEmprestimos.setVisible(false);
		panelListarEmprestimosAtrasados.setVisible(false);
		panelListarEmprestimosPorCliente.setVisible(false);
		
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