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

	public FrameLoginCliente() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(MyColor.SECONDARY_BACKGROUND);
		contentPane.setBorder(new LineBorder(MyColor.ACCENT, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameLoginCliente.this.requestFocus();
			}
		});
		
		iconArrow = new JLabel("< ");
		iconArrow.setOpaque(true);
		iconArrow.setBackground(MyColor.SECONDARY_BACKGROUND);
		iconArrow.setForeground(MyColor.PRIMARY);
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
				iconArrow.setBackground(MyColor.PLACEHOLDER);
				iconArrow.setForeground(MyColor.BACKGROUND);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				iconArrow.setBackground(MyColor.SECONDARY_BACKGROUND);
				iconArrow.setForeground(MyColor.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				iconArrow.setBackground(MyColor.SECONDARY_PLACEHOLDER);
				iconArrow.setForeground(MyColor.BACKGROUND);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				iconArrow.setBackground(MyColor.PLACEHOLDER);
				iconArrow.setForeground(MyColor.BACKGROUND);
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
		
		DrawingCanvasCliente drawingCanvas = new DrawingCanvasCliente();
		contentPane.add(drawingCanvas);
		
		pnlTitle = new JPanel();
		pnlTitle.setBounds(175, 45, 250, 60);
		pnlTitle.setBackground(MyColor.SECONDARY_BACKGROUND);
		contentPane.add(pnlTitle);
		pnlTitle.setLayout(null);
		
		lblTitle = new JLabel("Login do");
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setForeground(MyColor.PRIMARY);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 40));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 250, 60);
		pnlTitle.add(lblTitle);
		
		JPanel pnlUsername = new JPanel();
		pnlUsername.setBackground(MyColor.BACKGROUND);
		pnlUsername.setBounds(175, 165, 250, 40);
		contentPane.add(pnlUsername);
		pnlUsername.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtUsername.setForeground(MyColor.TEXT);
				if (txtUsername.getText().equals("CPF do Cliente")) {
					txtUsername.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().equals("")) {
					txtUsername.setText("CPF do Cliente");
					txtUsername.setForeground(MyColor.PLACEHOLDER);
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsername.setSelectionColor(MyColor.ACCENT);
		txtUsername.setForeground(MyColor.PLACEHOLDER);
		txtUsername.setText("CPF do Cliente");
		txtUsername.setBackground(MyColor.BACKGROUND);
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
		pnlPassword.setBackground(MyColor.BACKGROUND);
		pnlPassword.setBounds(175, 215, 250, 40);
		contentPane.add(pnlPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				txtPassword.setForeground(MyColor.TEXT);
				if (txtPassword.getText().equals("Senha")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
				}
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if (txtPassword.getText().equals("")) {
					txtPassword.setText("Senha");
					txtPassword.setEchoChar((char)0);
					txtPassword.setForeground(MyColor.PLACEHOLDER);
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPassword.setSelectionColor(MyColor.ACCENT);
		txtPassword.setForeground(MyColor.PLACEHOLDER);
		txtPassword.setText("Senha");
		txtPassword.setBackground(MyColor.BACKGROUND);
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
				pnlLoginBtn.setBackground(MyColor.ACCENT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlLoginBtn.setBackground(MyColor.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlLoginBtn.setBackground(MyColor.SECONDARY_ACCENT);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlLoginBtn.setBackground(MyColor.ACCENT);
			}
		});
		pnlLoginBtn.setBackground(MyColor.PRIMARY);
		pnlLoginBtn.setBounds(175, 290, 250, 40);
		contentPane.add(pnlLoginBtn);
		pnlLoginBtn.setLayout(null);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(MyColor.BACKGROUND);
		lblLogin.setFont(new Font("Arial", Font.BOLD, 14));
		lblLogin.setBounds(102, 5, 46, 30);
		pnlLoginBtn.add(lblLogin);
		
		lblLoginMessage = new JTextField("");
		lblLoginMessage.setEditable(false);
		lblLoginMessage.setSelectionColor(MyColor.ACCENT);
		lblLoginMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginMessage.setForeground(MyColor.TEXT);
		lblLoginMessage.setBorder(null);
		lblLoginMessage.setBackground(MyColor.SECONDARY_BACKGROUND);
		lblLoginMessage.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLoginMessage.setBounds(175, 265, 250, 13);
		contentPane.add(lblLoginMessage);
	}
}