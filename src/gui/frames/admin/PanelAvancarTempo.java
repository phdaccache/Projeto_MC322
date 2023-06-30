package gui.frames.admin;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import gui.frames.style.MyColors;
import sistema.Admin;

public class PanelAvancarTempo extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel iconX;
	
	public PanelAvancarTempo(JFrame frameAdmin) {
		setBounds(0, 0, 346, 396);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("AVANÇAR TEMPO");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 45, 326, 60);
		add(lblNewLabel);
		
		iconX = new JLabel("X");
		iconX.setOpaque(true);
		iconX.setBackground(MyColors.SECONDARY_BACKGROUND);
		iconX.setForeground(MyColors.PRIMARY);
		iconX.setHorizontalTextPosition(SwingConstants.CENTER);
		iconX.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
		iconX.setHorizontalAlignment(SwingConstants.CENTER);
		iconX.setBounds(316, 0, 30, 25);
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
		add(iconX);

		///////////////////////// Input 1 /////////////////////////

		JPanel pnlInput1 = new JPanel();
		pnlInput1.setBorder(new LineBorder(MyColors.TEXT));
		pnlInput1.setBackground(MyColors.BACKGROUND);
		pnlInput1.setBounds(115, 125, 115, 25);
		add(pnlInput1);
		pnlInput1.setLayout(null);

		JTextField txtInput1 = new JTextField();
		txtInput1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInput1.setForeground(MyColors.TEXT);
				if (txtInput1.getText().equals("Dias")) {
					txtInput1.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtInput1.getText().equals("")) {
					txtInput1.setText("Dias");
					txtInput1.setForeground(MyColors.PLACEHOLDER);
				}
			}
		});
		txtInput1.setBorder(null);
		txtInput1.setFont(new Font("Arial", Font.PLAIN, 12));
		txtInput1.setSelectionColor(MyColors.ACCENT);
		txtInput1.setForeground(MyColors.PLACEHOLDER);
		txtInput1.setText("Dias");
		txtInput1.setBackground(MyColors.BACKGROUND);
		txtInput1.setBounds(10, 5, 100, 15);
		pnlInput1.add(txtInput1);
		txtInput1.setColumns(10);

		JPanel pnlAvancarBtn = new JPanel();
		pnlAvancarBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String diasString = txtInput1.getText();
					if(diasString.equals("Dias")) {
						throw new IllegalArgumentException("Preencha todos os campos");
					}
					int dias = Integer.parseInt(diasString);
					String message = Admin.avancarTempo(dias);
					int confirmation = JOptionPane.showConfirmDialog(null, message, "Confirmação", JOptionPane.DEFAULT_OPTION);
					if(confirmation == 0) {
						frameAdmin.dispose();
						JFrame frame = new FrameAdmin();
						frame.setVisible(true);
						frame.toFront();
						frame.requestFocus();
					}
				} catch (NumberFormatException error) {
					String message = "O campo 'Dias' deve ser preenchido com um número.";
					JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException error) {
					JOptionPane.showMessageDialog(null, error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlAvancarBtn.setBackground(MyColors.ACCENT);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlAvancarBtn.setBackground(MyColors.PRIMARY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlAvancarBtn.setBackground(MyColors.SECONDARY_ACCENT);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlAvancarBtn.setBackground(MyColors.ACCENT);
			}
		});
		pnlAvancarBtn.setBackground(MyColors.PRIMARY);
		pnlAvancarBtn.setBounds(48, 290, 250, 40);
		add(pnlAvancarBtn);
		pnlAvancarBtn.setLayout(null);
		
		JLabel lblAvancar = new JLabel("Avançar");
		lblAvancar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvancar.setForeground(MyColors.BACKGROUND);
		lblAvancar.setFont(new Font("Arial", Font.BOLD, 14));
		lblAvancar.setBounds(0, 5, 250, 30);
		pnlAvancarBtn.add(lblAvancar);
	}
}