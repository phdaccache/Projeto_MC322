package gui.frames.admin;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import gui.frames.*;
import gui.frames.style.*;

public class FrameAdmin extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel iconArrow;
	private JLabel iconX;
	private JPanel pnlTitle;
	private JLabel lblTitle;
	
	private JPanel panelListarBibliotecas;
	private JPanel panelCadastrarBiblioteca;
	private JPanel panelExcluirBiblioteca;
	private JPanel panelAvancarTempo;
	
	public FrameAdmin() {
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
				FrameAdmin.this.requestFocus();
			}
		});
		
		panelListarBibliotecas = new PanelListarBibliotecas();
		panelCadastrarBiblioteca = new PanelCadastrarBiblioteca(this);
		panelExcluirBiblioteca = new PanelExcluirBiblioteca();
		panelAvancarTempo = new PanelAvancarTempo();
		
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
				FrameAdmin.this.dispose();
				
				JFrame frameMain = new FrameMain();
				frameMain.setVisible(true);
				frameMain.toFront();
				frameMain.requestFocus();
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
		
		lblTitle = new JLabel("ADMIN");
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
		
		JPanel pnlListarBibliotecas = new JPanel();
		pnlListarBibliotecas.addMouseListener(new PanelButtonMouseAdapter(pnlListarBibliotecas) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarBibliotecas);
			}
		});
		pnlListarBibliotecas.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlListarBibliotecas.setBackground(MyColors.PRIMARY);
		pnlListarBibliotecas.setBounds(20, 125, 210, 32);
		pnlMenu.add(pnlListarBibliotecas);
		pnlListarBibliotecas.setLayout(null);
		
		JLabel lblListarBibliotecas = new JLabel("LISTAR BIBLIOTECAS");
		lblListarBibliotecas.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblListarBibliotecas.setForeground(MyColors.BACKGROUND);
		lblListarBibliotecas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarBibliotecas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarBibliotecas.setBounds(0, 6, 210, 20);
		pnlListarBibliotecas.add(lblListarBibliotecas);
		
		JPanel pnlCadastrarBiblioteca = new JPanel();
		pnlCadastrarBiblioteca.addMouseListener(new PanelButtonMouseAdapter(pnlCadastrarBiblioteca) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelCadastrarBiblioteca);
			}
		});
		pnlCadastrarBiblioteca.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlCadastrarBiblioteca.setBackground(MyColors.PRIMARY);
		pnlCadastrarBiblioteca.setBounds(20, 157, 210, 32);
		pnlMenu.add(pnlCadastrarBiblioteca);
		pnlCadastrarBiblioteca.setLayout(null);
		
		JLabel lblCadastrarBiblioteca = new JLabel("CADASTRAR BIBLIOTECA");
		lblCadastrarBiblioteca.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCadastrarBiblioteca.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCadastrarBiblioteca.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarBiblioteca.setForeground(new Color(250, 249, 251));
		lblCadastrarBiblioteca.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCadastrarBiblioteca.setBounds(0, 6, 210, 20);
		pnlCadastrarBiblioteca.add(lblCadastrarBiblioteca);
		
		JPanel pnlExcluirBiblioteca = new JPanel();
		pnlExcluirBiblioteca.addMouseListener(new PanelButtonMouseAdapter(pnlExcluirBiblioteca) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelExcluirBiblioteca);
			}
		});
		pnlExcluirBiblioteca.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlExcluirBiblioteca.setBackground(MyColors.PRIMARY);
		pnlExcluirBiblioteca.setLayout(null);
		pnlExcluirBiblioteca.setBounds(20, 189, 210, 32);
		pnlMenu.add(pnlExcluirBiblioteca);
		
		JLabel lblExcluirBiblioteca = new JLabel("EXCLUIR BIBLIOTECA");
		lblExcluirBiblioteca.setHorizontalTextPosition(SwingConstants.CENTER);
		lblExcluirBiblioteca.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirBiblioteca.setForeground(new Color(250, 249, 251));
		lblExcluirBiblioteca.setFont(new Font("Dialog", Font.BOLD, 14));
		lblExcluirBiblioteca.setAlignmentX(0.5f);
		lblExcluirBiblioteca.setBounds(0, 6, 210, 20);
		pnlExcluirBiblioteca.add(lblExcluirBiblioteca);
		
		JPanel pnlAvancarTempo = new JPanel();
		pnlAvancarTempo.addMouseListener(new PanelButtonMouseAdapter(pnlAvancarTempo) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelAvancarTempo);
			}
		});
		pnlAvancarTempo.setLayout(null);
		pnlAvancarTempo.setBackground(new Color(121, 98, 68));
		pnlAvancarTempo.setBounds(20, 221, 210, 32);
		pnlMenu.add(pnlAvancarTempo);
		
		JLabel lblAvancarTempo = new JLabel("AVANÇAR TEMPO");
		lblAvancarTempo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAvancarTempo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvancarTempo.setForeground(new Color(250, 249, 251));
		lblAvancarTempo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAvancarTempo.setAlignmentX(0.5f);
		lblAvancarTempo.setBounds(0, 6, 210, 20);
		pnlAvancarTempo.add(lblAvancarTempo);
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBounds(252, 2, 346, 396);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);
		
		pnlMainContent.add(panelListarBibliotecas);
		pnlMainContent.add(panelCadastrarBiblioteca);
		pnlMainContent.add(panelExcluirBiblioteca);
		pnlMainContent.add(panelAvancarTempo);
		
		menuClicked(null);
	}
	
	public void menuClicked(JPanel selectedPanel) {		
		panelListarBibliotecas.setVisible(false);
		panelCadastrarBiblioteca.setVisible(false);
		panelExcluirBiblioteca.setVisible(false);
		panelAvancarTempo.setVisible(false);
		
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