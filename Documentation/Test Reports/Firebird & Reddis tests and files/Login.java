package com.reroute.main;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class Login {
	public JFrame frmLogin;
	private JTextField edtUsername;
	private JPasswordField edtPassword;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = 0;
	private int height = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 594, 408);
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		width = 600;
		height = 450;
		frmLogin.setSize(width, height);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel pnl_North = new JPanel();
		frmLogin.getContentPane().add(pnl_North, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("Catura (ReRoute Systems)");
		pnl_North.add(lblTitle);

		JPanel pnl_Center = new JPanel();
		frmLogin.getContentPane().add(pnl_Center, BorderLayout.CENTER);
		pnl_Center.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblUsername = new JLabel("Username : ");
		pnl_Center.add(lblUsername);

				edtUsername = new JTextField();
				edtUsername.setToolTipText("Username");
				pnl_Center.add(edtUsername);
				edtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password : ");
		pnl_Center.add(lblPassword);

		edtPassword = new JPasswordField();
		edtPassword.setToolTipText("Password");
		pnl_Center.add(edtPassword);
		edtPassword.setColumns(10);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Admin\\caturalogo.jpg"));
		pnl_Center.add(lblLogo);

		JPanel pnl_South = new JPanel();
		frmLogin.getContentPane().add(pnl_South, BorderLayout.SOUTH);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(edtUsername.getText().equals("") && edtPassword.getText().equals("")){
					frmLogin.dispose();
					MainMenu menu = new MainMenu();
					menu.frmMenu.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid Credentials");
				}
			}
		});
		pnl_South.add(btnLogin);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLogin.dispose();
			}
		});
		pnl_South.add(btnExit);
	}
}
