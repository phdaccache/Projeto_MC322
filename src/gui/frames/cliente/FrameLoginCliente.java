package gui.frames.cliente;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import gui.frames.*;
import gui.frames.style.*;

public class FrameLoginCliente extends JFrame {
	private Image img_user = new ImageIcon(FrameLoginCliente.class.getResource("../../res/user.png")).getImage().getScaledInstance(70, 85, Image.SCALE_SMOOTH);
	private Image img_lock = new ImageIcon(FrameLoginCliente.class.getResource("../../res/lock.png")).getImage().getScaledInstance(70, 85, Image.SCALE_SMOOTH);
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPanel pnlLoginBtn;
	private JLabel lblLogin;
	private JLabel iconArrow;
	private JLabel iconX;
	private JLabel lblUserIcon;
	private JLabel lblLockIcon;
	private JTextField lblLoginMessage;
	private JPanel pnlTitle;
	private JLabel lblTitle;
	
	private int mouseX;
	private int mouseY;

	public FrameLoginCliente() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(MyColors.SECONDARY_BACKGROUND);
		contentPane.setBorder(new LineBorder(MyColors.ACCENT, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameLoginCliente.this.requestFocus();
			}
		});
		
		JPanel dragPanel = new JPanel();
		dragPanel.setOpaque(false);
		dragPanel.setBounds(32, 2, 536, 25);
		contentPane.add(dragPanel);
		
		dragPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				FrameLoginCliente.this.setLocation(FrameLoginCliente.this.getX() + e.getX() - mouseX, FrameLoginCliente.this.getY()+e.getY()-mouseY);
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
		iconArrow.setBackground(MyColors.SECONDARY_BACKGROUND);
		iconArrow.setForeground(MyColors.PRIMARY);
		iconArrow.setHorizontalTextPosition(SwingConstants.CENTER);
		iconArrow.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
		iconArrow.setHorizontalAlignment(SwingConstants.CENTER);
		iconArrow.setBounds(2, 2, 30, 25);
		iconArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameLoginCliente.this.dispose();
				
				JFrame frameMain = new FrameMain();
				frameMain.setVisible(true);
				frameMain.toFront();
				frameMain.requestFocus();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				iconArrow.setBackground(MyColors.PLACEHOLDER);
				iconArrow.setForeground(MyColors.BACKGROUND);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				iconArrow.setBackground(MyColors.SECONDARY_BACKGROUND);
				iconArrow.setForeground(MyColors.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				iconArrow.setBackground(MyColors.SECONDARY_PLACEHOLDER);
				iconArrow.setForeground(MyColors.BACKGROUND);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				iconArrow.setBackground(MyColors.PLACEHOLDER);
				iconArrow.setForeground(MyColors.BACKGROUND);
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
		
		DrawingCanvasCliente drawingCanvas = new DrawingCanvasCliente();
		contentPane.add(drawingCanvas);
		
		pnlTitle = new JPanel();
		pnlTitle.setBounds(175, 45, 250, 60);
		pnlTitle.setBackground(MyColors.SECONDARY_BACKGROUND);
		contentPane.add(pnlTitle);
		pnlTitle.setLayout(null);
		
		lblTitle = new JLabel("Login do");
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setForeground(MyColors.PRIMARY);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 40));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 250, 60);
		pnlTitle.add(lblTitle);
		
		JPanel pnlUsername = new JPanel();
		pnlUsername.setBackground(MyColors.BACKGROUND);
		pnlUsername.setBounds(175, 165, 250, 40);
		contentPane.add(pnlUsername);
		pnlUsername.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtUsername.setForeground(MyColors.TEXT);
				if (txtUsername.getText().equals("CPF do Cliente")) {
					txtUsername.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().equals("")) {
					txtUsername.setText("CPF do Cliente");
					txtUsername.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsername.setSelectionColor(MyColors.ACCENT);
		txtUsername.setForeground(MyColors.PLACEHOLDER);
		txtUsername.setText("CPF do Cliente");
		txtUsername.setBackground(MyColors.BACKGROUND);
		txtUsername.setBounds(10, 10, 185, 20);
		pnlUsername.add(txtUsername);
		txtUsername.setColumns(10);
		
		lblUserIcon = new JLabel("");
		lblUserIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserIcon.setBounds(210, 0, 40, 40);
		lblUserIcon.setIcon(new ImageIcon(img_user));
		pnlUsername.add(lblUserIcon);
		
		JPanel pnlPassword = new JPanel();
		pnlPassword.setLayout(null);
		pnlPassword.setBackground(MyColors.BACKGROUND);
		pnlPassword.setBounds(175, 215, 250, 40);
		contentPane.add(pnlPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				txtPassword.setForeground(MyColors.TEXT);
				if (txtPassword.getText().equals("Senha")) {
					txtPassword.setEchoChar('*');
					txtPassword.setText("");
				}
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if (txtPassword.getText().equals("")) {
					txtPassword.setText("Senha");
					txtPassword.setEchoChar((char)0);
					txtPassword.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPassword.setSelectionColor(MyColors.ACCENT);
		txtPassword.setForeground(MyColors.PLACEHOLDER);
		txtPassword.setText("Senha");
		txtPassword.setBackground(MyColors.BACKGROUND);
		txtPassword.setBounds(10, 10, 185, 20);
		pnlPassword.add(txtPassword);
		
		lblLockIcon = new JLabel("");
		lblLockIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLockIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblLockIcon.setBounds(210, 0, 40, 40);
		lblLockIcon.setIcon(new ImageIcon(img_lock));
		pnlPassword.add(lblLockIcon);
		
		pnlLoginBtn = new JPanel();
		pnlLoginBtn.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
			if (txtUsername.getText().equals("cliente") && txtPassword.getText().equals("123")) {
				lblLoginMessage.setText("");
				FrameLoginCliente.this.dispose();
				
				FrameCliente cliente = new FrameCliente();
				cliente.setVisible(true);
				cliente.toFront();
				cliente.requestFocus();
				}
			else if (txtUsername.getText().equals("") || txtUsername.getText().equals("CPF do Cliente") || 
					 txtPassword.getText().equals("") || txtPassword.getText().equals("Senha")) {
					
				lblLoginMessage.setText("Preencha todos os campos.");
				}
			else {
				lblLoginMessage.setText("Usuário e/ou senha inválidos.");	
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlLoginBtn.setBackground(MyColors.ACCENT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlLoginBtn.setBackground(MyColors.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlLoginBtn.setBackground(MyColors.SECONDARY_ACCENT);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlLoginBtn.setBackground(MyColors.ACCENT);
			}
		});
		pnlLoginBtn.setBackground(MyColors.PRIMARY);
		pnlLoginBtn.setBounds(175, 290, 250, 40);
		contentPane.add(pnlLoginBtn);
		pnlLoginBtn.setLayout(null);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(MyColors.BACKGROUND);
		lblLogin.setFont(new Font("Arial", Font.BOLD, 14));
		lblLogin.setBounds(102, 5, 46, 30);
		pnlLoginBtn.add(lblLogin);
		
		lblLoginMessage = new JTextField("");
		lblLoginMessage.setEditable(false);
		lblLoginMessage.setSelectionColor(MyColors.ACCENT);
		lblLoginMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginMessage.setForeground(MyColors.TEXT);
		lblLoginMessage.setBorder(null);
		lblLoginMessage.setBackground(MyColors.SECONDARY_BACKGROUND);
		lblLoginMessage.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLoginMessage.setBounds(175, 265, 250, 13);
		contentPane.add(lblLoginMessage);
	}
}