package gui.frames.biblioteca.itens;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import gui.frames.biblioteca.*;
import gui.frames.style.*;
import pacote.Biblioteca;

public class FrameItens extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel iconArrow;
	
	private JPanel pnlTitle;
	private JLabel lblTitle;
	private JLabel iconX;
	private JPanel panelPesquisarItem;
	private JPanel panelListarTodosOsItens;
	private JPanel panelListarLivros;
	private JPanel panelListarApostilas;
	private JPanel panelListarArtigos;
	private JPanel panelListarRevistas;
	private JPanel panelCadastrarItem;
	private JPanel panelExcluirItem;
	
	public FrameItens(Biblioteca biblioteca) {
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
				FrameItens.this.requestFocus();
			}
		});
		
		panelPesquisarItem = new PanelPesquisarItem(biblioteca);
		panelListarTodosOsItens = new PanelListarTodosOsItens(biblioteca);
		panelListarLivros = new PanelListarLivros(biblioteca);
		panelListarApostilas = new PanelListarApostilas(biblioteca);
		panelListarArtigos = new PanelListarArtigos(biblioteca);
		panelListarRevistas = new PanelListarRevistas(biblioteca);
		panelCadastrarItem = new PanelCadastrarItem(biblioteca);
		panelExcluirItem = new PanelExcluirItem(biblioteca);
		
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
				FrameItens.this.dispose();
				
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
		
		lblTitle = new JLabel("ITENS");
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
		
		JPanel pnlPesquisarItem = new JPanel();
		pnlPesquisarItem.addMouseListener(new PanelButtonMouseAdapter(pnlPesquisarItem) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelPesquisarItem);
			}
		});
		pnlPesquisarItem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(24, 17, 29)));
		pnlPesquisarItem.setBackground(MyColors.PRIMARY);
		pnlPesquisarItem.setBounds(20, 125, 210, 32);
		pnlMenu.add(pnlPesquisarItem);
		pnlPesquisarItem.setLayout(null);
		
		JLabel lblPesquisarItem = new JLabel("PESQUISAR ITEM");
		lblPesquisarItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPesquisarItem.setForeground(MyColors.BACKGROUND);
		lblPesquisarItem.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPesquisarItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisarItem.setBounds(6, 6, 207, 20);
		pnlPesquisarItem.add(lblPesquisarItem);
		
		JPanel pnlListarTodosOsItens = new JPanel();
		pnlListarTodosOsItens.addMouseListener(new PanelButtonMouseAdapter(pnlListarTodosOsItens) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarTodosOsItens);
			}
		});
		pnlListarTodosOsItens.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlListarTodosOsItens.setBackground(MyColors.PRIMARY);
		pnlListarTodosOsItens.setBounds(20, 157, 210, 32);
		pnlMenu.add(pnlListarTodosOsItens);
		pnlListarTodosOsItens.setLayout(null);
		
		JLabel lblListarTodosOsItens = new JLabel("LISTAR TODOS OS ITENS");
		lblListarTodosOsItens.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListarTodosOsItens.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblListarTodosOsItens.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarTodosOsItens.setForeground(new Color(250, 249, 251));
		lblListarTodosOsItens.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarTodosOsItens.setBounds(0, 6, 210, 20);
		pnlListarTodosOsItens.add(lblListarTodosOsItens);
		
		JPanel pnlListarLivros = new JPanel();
		pnlListarLivros.addMouseListener(new PanelButtonMouseAdapter(pnlListarLivros) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarLivros);
			}
		});
		pnlListarLivros.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlListarLivros.setBackground(MyColors.PRIMARY);
		pnlListarLivros.setLayout(null);
		pnlListarLivros.setBounds(20, 189, 210, 32);
		pnlMenu.add(pnlListarLivros);
		
		JLabel lblListarLivros = new JLabel("LISTAR LIVROS");
		lblListarLivros.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListarLivros.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarLivros.setForeground(new Color(250, 249, 251));
		lblListarLivros.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarLivros.setAlignmentX(0.5f);
		lblListarLivros.setBounds(0, 6, 210, 20);
		pnlListarLivros.add(lblListarLivros);
		
		JPanel pnlListarApostilas = new JPanel();
		pnlListarApostilas.addMouseListener(new PanelButtonMouseAdapter(pnlListarApostilas) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarApostilas);
			}
		});
		pnlListarApostilas.setLayout(null);
		pnlListarApostilas.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlListarApostilas.setBackground(new Color(121, 98, 68));
		pnlListarApostilas.setBounds(20, 221, 210, 32);
		pnlMenu.add(pnlListarApostilas);
		
		JLabel lblListarApostilas = new JLabel("LISTAR APOSTILAS");
		lblListarApostilas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListarApostilas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarApostilas.setForeground(new Color(250, 249, 251));
		lblListarApostilas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarApostilas.setAlignmentX(0.5f);
		lblListarApostilas.setBounds(0, 6, 210, 20);
		pnlListarApostilas.add(lblListarApostilas);
		
		JPanel pnlListarArtigos = new JPanel();
		pnlListarArtigos.addMouseListener(new PanelButtonMouseAdapter(pnlListarArtigos) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarArtigos);
			}
		});
		pnlListarArtigos.setLayout(null);
		pnlListarArtigos.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlListarArtigos.setBackground(new Color(121, 98, 68));
		pnlListarArtigos.setBounds(20, 253, 210, 32);
		pnlMenu.add(pnlListarArtigos);
		
		JLabel lblListarArtigos = new JLabel("LISTAR ARTIGOS");
		lblListarArtigos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListarArtigos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarArtigos.setForeground(new Color(250, 249, 251));
		lblListarArtigos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarArtigos.setAlignmentX(0.5f);
		lblListarArtigos.setBounds(0, 6, 210, 20);
		pnlListarArtigos.add(lblListarArtigos);
		
		JPanel pnlListarRevistas = new JPanel();
		pnlListarRevistas.addMouseListener(new PanelButtonMouseAdapter(pnlListarRevistas) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarRevistas);
			}
		});
		pnlListarRevistas.setLayout(null);
		pnlListarRevistas.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlListarRevistas.setBackground(new Color(121, 98, 68));
		pnlListarRevistas.setBounds(20, 285, 210, 32);
		pnlMenu.add(pnlListarRevistas);
		
		JLabel lblListarRevistas = new JLabel("LISTAR REVISTAS");
		lblListarRevistas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListarRevistas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarRevistas.setForeground(new Color(250, 249, 251));
		lblListarRevistas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarRevistas.setAlignmentX(0.5f);
		lblListarRevistas.setBounds(0, 6, 210, 20);
		pnlListarRevistas.add(lblListarRevistas);
		
		JPanel pnlCadastrarItem = new JPanel();
		pnlCadastrarItem.addMouseListener(new PanelButtonMouseAdapter(pnlCadastrarItem) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelCadastrarItem);
			}
		});
		pnlCadastrarItem.setLayout(null);
		pnlCadastrarItem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlCadastrarItem.setBackground(new Color(121, 98, 68));
		pnlCadastrarItem.setBounds(20, 317, 210, 32);
		pnlMenu.add(pnlCadastrarItem);
		
		JLabel lblCadastrarItem = new JLabel("CADASTRAR ITEM");
		lblCadastrarItem.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCadastrarItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarItem.setForeground(new Color(250, 249, 251));
		lblCadastrarItem.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCadastrarItem.setAlignmentX(0.5f);
		lblCadastrarItem.setBounds(0, 6, 210, 20);
		pnlCadastrarItem.add(lblCadastrarItem);
		
		JPanel pnlExcluirItem = new JPanel();
		pnlExcluirItem.addMouseListener(new PanelButtonMouseAdapter(pnlExcluirItem) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelExcluirItem);
			}
		});
		pnlExcluirItem.setLayout(null);
		pnlExcluirItem.setBackground(new Color(121, 98, 68));
		pnlExcluirItem.setBounds(20, 349, 210, 32);
		pnlMenu.add(pnlExcluirItem);
		
		JLabel lblExcluirItem = new JLabel("EXCLUIR ITEM");
		lblExcluirItem.setHorizontalTextPosition(SwingConstants.CENTER);
		lblExcluirItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirItem.setForeground(new Color(250, 249, 251));
		lblExcluirItem.setFont(new Font("Dialog", Font.BOLD, 14));
		lblExcluirItem.setAlignmentX(0.5f);
		lblExcluirItem.setBounds(0, 6, 210, 20);
		pnlExcluirItem.add(lblExcluirItem);
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBounds(252, 2, 346, 396);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);
		
		pnlMainContent.add(panelPesquisarItem);
		pnlMainContent.add(panelListarTodosOsItens);
		pnlMainContent.add(panelListarLivros);
		pnlMainContent.add(panelListarApostilas);
		pnlMainContent.add(panelListarArtigos);
		pnlMainContent.add(panelListarRevistas);
		pnlMainContent.add(panelCadastrarItem);
		pnlMainContent.add(panelExcluirItem);
		
		menuClicked(null);
	}
	
	public void menuClicked(JPanel selectedPanel) {
		panelPesquisarItem.setVisible(false);
		panelListarTodosOsItens.setVisible(false);
		panelListarLivros.setVisible(false);
		panelListarApostilas.setVisible(false);
		panelListarArtigos.setVisible(false);
		panelListarRevistas.setVisible(false);
		panelCadastrarItem.setVisible(false);
		panelExcluirItem.setVisible(false);
		
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