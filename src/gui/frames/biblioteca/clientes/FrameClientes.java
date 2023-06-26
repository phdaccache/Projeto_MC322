package gui.frames.biblioteca.clientes;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import gui.frames.biblioteca.*;
import gui.frames.style.*;

public class FrameClientes extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel iconArrow;
	private JLabel iconX;
	private JPanel pnlTitle;
	private JLabel lblTitle;
	
	private JPanel panelListarTodosOsClientes;
	private JPanel panelListarEstudantes;
	private JPanel panelListarProfessores;
	private JPanel panelCadastrarCliente;
	private JPanel panelExcluirCliente;
	private JPanel panelListarAssinaturas;
	private JPanel panelGerarAssinatura;
	private JPanel panelExcluirAssinatura;
	private JPanel pnlCadastrarCliente;
	
	private JLabel lblCadastrarCliente;
	private JPanel pnlExcluirCliente;
	private JLabel lblExcluirCliente;
	private JPanel pnlListarAssinaturas;
	private JLabel lblListarAssinaturas;
	private JPanel pnlGerarAssinatura;
	private JLabel lblGerarAssinatura;
	private JPanel pnlExcluirAssinatura;
	private JLabel lblExcluirAssinatura;
	
	public FrameClientes() {
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
				FrameClientes.this.requestFocus();
			}
		});
		
		panelListarTodosOsClientes = new PanelListarTodosOsClientes();
		panelListarEstudantes = new PanelListarEstudantes();
		panelListarProfessores = new PanelListarProfessores();
		panelCadastrarCliente = new PanelCadastrarCliente();
		panelExcluirCliente = new PanelExcluirCliente();
		panelListarAssinaturas = new PanelListarAssinaturas();
		panelGerarAssinatura = new PanelGerarAssinatura();
		panelExcluirAssinatura = new PanelExcluirAssinatura();
		
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
				FrameClientes.this.dispose();
				
				JFrame frameBiblioteca = new FrameBiblioteca();
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
		
		lblTitle = new JLabel("CLIENTES");
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
		
		JPanel pnlListarClientes = new JPanel();
		pnlListarClientes.addMouseListener(new PanelButtonMouseAdapter(pnlListarClientes) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarTodosOsClientes);
			}
		});
		pnlListarClientes.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlListarClientes.setBackground(MyColors.PRIMARY);
		pnlListarClientes.setBounds(20, 125, 210, 32);
		pnlMenu.add(pnlListarClientes);
		pnlListarClientes.setLayout(null);
		
		JLabel lblListarClientes = new JLabel("LISTAR TODOS OS CLIENTES");
		lblListarClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblListarClientes.setForeground(MyColors.BACKGROUND);
		lblListarClientes.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarClientes.setBounds(6, 6, 207, 20);
		pnlListarClientes.add(lblListarClientes);
		
		JPanel pnlListarEstudantes = new JPanel();
		pnlListarEstudantes.addMouseListener(new PanelButtonMouseAdapter(pnlListarEstudantes) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarEstudantes);
			}
		});
		pnlListarEstudantes.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlListarEstudantes.setBackground(MyColors.PRIMARY);
		pnlListarEstudantes.setBounds(20, 157, 210, 32);
		pnlMenu.add(pnlListarEstudantes);
		pnlListarEstudantes.setLayout(null);
		
		JLabel lblListarEstudantes = new JLabel("LISTAR ESTUDANTES");
		lblListarEstudantes.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListarEstudantes.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblListarEstudantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarEstudantes.setForeground(new Color(250, 249, 251));
		lblListarEstudantes.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarEstudantes.setBounds(0, 6, 210, 20);
		pnlListarEstudantes.add(lblListarEstudantes);
		
		JPanel pnlListarProfessores = new JPanel();
		pnlListarProfessores.addMouseListener(new PanelButtonMouseAdapter(pnlListarProfessores) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarProfessores);
			}
		});
		pnlListarProfessores.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlListarProfessores.setBackground(MyColors.PRIMARY);
		pnlListarProfessores.setLayout(null);
		pnlListarProfessores.setBounds(20, 189, 210, 32);
		pnlMenu.add(pnlListarProfessores);
		
		JLabel lblListarProfessores = new JLabel("LISTAR PROFESSORES");
		lblListarProfessores.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListarProfessores.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarProfessores.setForeground(new Color(250, 249, 251));
		lblListarProfessores.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarProfessores.setAlignmentX(0.5f);
		lblListarProfessores.setBounds(0, 6, 210, 20);
		pnlListarProfessores.add(lblListarProfessores);
		
		pnlCadastrarCliente = new JPanel();
		pnlCadastrarCliente.addMouseListener(new PanelButtonMouseAdapter(pnlCadastrarCliente) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelCadastrarCliente);
			}
		});
		pnlCadastrarCliente.setLayout(null);
		pnlCadastrarCliente.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlCadastrarCliente.setBackground(new Color(121, 98, 68));
		pnlCadastrarCliente.setBounds(20, 221, 210, 32);
		pnlMenu.add(pnlCadastrarCliente);
		
		lblCadastrarCliente = new JLabel("CADASTRAR CLIENTE");
		lblCadastrarCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCadastrarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarCliente.setForeground(new Color(250, 249, 251));
		lblCadastrarCliente.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCadastrarCliente.setAlignmentX(0.5f);
		lblCadastrarCliente.setBounds(0, 6, 210, 20);
		pnlCadastrarCliente.add(lblCadastrarCliente);
		
		pnlExcluirCliente = new JPanel();
		pnlExcluirCliente.addMouseListener(new PanelButtonMouseAdapter(pnlExcluirCliente) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelExcluirCliente);
			}
		});
		pnlExcluirCliente.setLayout(null);
		pnlExcluirCliente.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlExcluirCliente.setBackground(new Color(121, 98, 68));
		pnlExcluirCliente.setBounds(20, 253, 210, 32);
		pnlMenu.add(pnlExcluirCliente);
		
		lblExcluirCliente = new JLabel("EXCLUIR CLIENTE");
		lblExcluirCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		lblExcluirCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirCliente.setForeground(new Color(250, 249, 251));
		lblExcluirCliente.setFont(new Font("Dialog", Font.BOLD, 14));
		lblExcluirCliente.setAlignmentX(0.5f);
		lblExcluirCliente.setBounds(0, 6, 210, 20);
		pnlExcluirCliente.add(lblExcluirCliente);
		
		pnlListarAssinaturas = new JPanel();
		pnlListarAssinaturas.addMouseListener(new PanelButtonMouseAdapter(pnlListarAssinaturas) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelListarAssinaturas);
			}
		});
		pnlListarAssinaturas.setLayout(null);
		pnlListarAssinaturas.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlListarAssinaturas.setBackground(new Color(121, 98, 68));
		pnlListarAssinaturas.setBounds(20, 285, 210, 32);
		pnlMenu.add(pnlListarAssinaturas);
		
		lblListarAssinaturas = new JLabel("LISTAR ASSINATURAS");
		lblListarAssinaturas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListarAssinaturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarAssinaturas.setForeground(new Color(250, 249, 251));
		lblListarAssinaturas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListarAssinaturas.setAlignmentX(0.5f);
		lblListarAssinaturas.setBounds(0, 6, 210, 20);
		pnlListarAssinaturas.add(lblListarAssinaturas);
		
		pnlGerarAssinatura = new JPanel();
		pnlGerarAssinatura.addMouseListener(new PanelButtonMouseAdapter(pnlGerarAssinatura) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelGerarAssinatura);
			}
		});
		pnlGerarAssinatura.setLayout(null);
		pnlGerarAssinatura.setBorder(new MatteBorder(0, 0, 1, 0, (Color) MyColors.TEXT));
		pnlGerarAssinatura.setBackground(new Color(121, 98, 68));
		pnlGerarAssinatura.setBounds(20, 317, 210, 32);
		pnlMenu.add(pnlGerarAssinatura);
		
		lblGerarAssinatura = new JLabel("GERAR ASSINATURA");
		lblGerarAssinatura.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGerarAssinatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerarAssinatura.setForeground(new Color(250, 249, 251));
		lblGerarAssinatura.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGerarAssinatura.setAlignmentX(0.5f);
		lblGerarAssinatura.setBounds(0, 6, 210, 20);
		pnlGerarAssinatura.add(lblGerarAssinatura);
		
		pnlExcluirAssinatura = new JPanel();
		pnlExcluirAssinatura.addMouseListener(new PanelButtonMouseAdapter(pnlExcluirAssinatura) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelExcluirAssinatura);
			}
		});
		pnlExcluirAssinatura.setLayout(null);
		pnlExcluirAssinatura.setBackground(new Color(121, 98, 68));
		pnlExcluirAssinatura.setBounds(20, 349, 210, 32);
		pnlMenu.add(pnlExcluirAssinatura);
		
		lblExcluirAssinatura = new JLabel("EXCLUIR ASSINATURA");
		lblExcluirAssinatura.setHorizontalTextPosition(SwingConstants.CENTER);
		lblExcluirAssinatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirAssinatura.setForeground(new Color(250, 249, 251));
		lblExcluirAssinatura.setFont(new Font("Dialog", Font.BOLD, 14));
		lblExcluirAssinatura.setAlignmentX(0.5f);
		lblExcluirAssinatura.setBounds(0, 6, 210, 20);
		pnlExcluirAssinatura.add(lblExcluirAssinatura);
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBounds(252, 2, 346, 396);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);
		
		pnlMainContent.add(panelListarTodosOsClientes);
		pnlMainContent.add(panelListarEstudantes);
		pnlMainContent.add(panelListarProfessores);
		pnlMainContent.add(panelCadastrarCliente);
		pnlMainContent.add(panelExcluirCliente);
		pnlMainContent.add(panelListarAssinaturas);
		pnlMainContent.add(panelGerarAssinatura);
		pnlMainContent.add(panelExcluirAssinatura);
		
		menuClicked(null);
	}
	
	public void menuClicked(JPanel selectedPanel) {
		panelListarTodosOsClientes.setVisible(false);
		panelListarEstudantes.setVisible(false);
		panelListarProfessores.setVisible(false);
		panelCadastrarCliente.setVisible(false);
		panelExcluirCliente.setVisible(false);
		panelListarAssinaturas.setVisible(false);
		panelGerarAssinatura.setVisible(false);
		panelExcluirAssinatura.setVisible(false);
		
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