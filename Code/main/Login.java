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
import javax.swing.UnsupportedLookAndFeelException;

import org.jdesktop.swingx.prompt.PromptSupport;

import com.reroute.datasource.UserDetailNew;
import com.reroute.serverutil.GetUserDetail;

import de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaGreenDreamLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaMauveMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSkyMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Login {
	public int colorDarkred = 0xDa1d2c;
	public Color red1 = Color.decode("#Da1d2c");
	public Color red2 = Color.decode("#Ff3e3e");
	public int colorLightRed = 0xFf3e3e;

	public JFrame frmLogin;
	private JTextField edtUsername;
	private JPasswordField edtPassword;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = 0;
	private int height = 0;
	private GetUserDetail getuserdetail = new GetUserDetail();
	private UserDetailNew userdetailnew = new UserDetailNew();

	/**
	 * Create the application.
	 * @throws ParseException
	 * @throws UnsupportedLookAndFeelException
	 */
	public Login(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();

		//frmLogin.setBackground(Color.BLUE);
		frmLogin.setTitle("Smart Search - Login");
		frmLogin.setBounds(100, 100, 450, 450);
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		frmLogin.setSize(1000, 860);
		frmLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frmLogin.getContentPane().setBackground(Color.BLUE);
		frmLogin.setVisible(true);
		frmLogin.getContentPane().setLayout(new BorderLayout(0, 0));
		//frmLogin.setBackground(Color.BLUE);

		JPanel pnl_North = new JPanel();
		frmLogin.getContentPane().add(pnl_North, BorderLayout.NORTH);
		pnl_North.setBackground(Color.WHITE);

		JPanel panel = new JPanel();
		pnl_North.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel pnl_Center = new JPanel();
		frmLogin.getContentPane().add(pnl_Center, BorderLayout.CENTER);
		pnl_Center.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		pnl_Center.setBackground(Color.WHITE);

		JPanel pnlBorder = new JPanel();
		pnlBorder.setBackground(Color.WHITE);
		pnl_Center.add(pnlBorder);
		pnlBorder.setLayout(new BorderLayout(0, 0));

		JPanel pnlCenter_North = new JPanel();
		pnlCenter_North.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) pnlCenter_North.getLayout();
		pnlCenter_North.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		pnlBorder.add(pnlCenter_North, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		pnlCenter_North.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_1.add(panel_5);

		JLabel lblLogo = new JLabel("CODE X");
		panel_5.add(lblLogo);

		lblLogo.setBackground(new Color(178, 34, 34));
		lblLogo.setForeground(red1);
		lblLogo.setFont(new Font("Segoe UI", Font.PLAIN, 130));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setVerticalAlignment(SwingConstants.TOP);
		lblLogo.setIcon(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_1.add(panel_6);

		JLabel lblSlogan = new JLabel("EXCEED | EXCEL | EXPRESS");
		lblSlogan.setBackground(new Color(colorLightRed));
		panel_6.add(lblSlogan);
		lblSlogan.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblSlogan.setVerticalAlignment(SwingConstants.TOP);
		lblSlogan.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSlogan.setBackground(Color.WHITE);
		lblSlogan.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_1.add(panel_10);
		
				JLabel label_3 = new JLabel("Smart Search");
				panel_10.add(label_3);
				label_3.setAlignmentX(0.5f);
				label_3.setBackground(new Color(220, 20, 60));
				label_3.setHorizontalTextPosition(SwingConstants.CENTER);
				label_3.setHorizontalAlignment(SwingConstants.CENTER);
				label_3.setForeground(SystemColor.activeCaption);
				label_3.setFont(new Font("Segoe UI", Font.PLAIN, 75));

		JPanel pnlCenter_Center = new JPanel();
		pnlCenter_Center.setBackground(Color.WHITE);
		pnlBorder.add(pnlCenter_Center, BorderLayout.CENTER);

		JPanel pnlInput = new JPanel();
		pnlCenter_Center.add(pnlInput);
		pnlInput.setLayout(new BoxLayout(pnlInput, BoxLayout.Y_AXIS));

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		pnlInput.add(panel_8);

		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 45));
		panel_8.add(lblUsername);

		edtUsername = new JTextField();
		edtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		pnlInput.add(edtUsername);
		edtUsername.setToolTipText("Enter Username");
		PromptSupport.setPrompt("Username", edtUsername);
		PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, edtUsername);
		edtUsername.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		pnlInput.add(panel_7);

		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 45));
		panel_7.add(lblPassword);

		edtPassword = new JPasswordField();
		edtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		pnlInput.add(edtPassword);
		edtPassword.setToolTipText("Enter Password");
		PromptSupport.setPrompt("Password", edtPassword);
		PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, edtPassword);
		edtPassword.setColumns(10);
		
				JPanel panel_3 = new JPanel();
				pnlInput.add(panel_3);
				panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				panel_3.setBackground(Color.WHITE);
				
						JLabel label_4 = new JLabel("                       ");
						label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
						panel_3.add(label_4);
						
								JPanel panel_9 = new JPanel();
								pnlInput.add(panel_9);
								panel_9.setBackground(Color.WHITE);
								
										JButton btnLogin = new JButton("Login");
										btnLogin.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\login.png"));
										panel_9.add(btnLogin);
										btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
										btnLogin.setBackground(SystemColor.activeCaptionBorder);
										btnLogin.setForeground(Color.WHITE);
										
												JLabel label_2 = new JLabel("                       ");
												panel_9.add(label_2);
												
														JButton btnExit = new JButton("  Exit     ");
														btnExit.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\logout.png"));
														panel_9.add(btnExit);
														btnExit.setBackground(SystemColor.activeCaptionBorder);
														btnExit.setForeground(Color.WHITE);
														btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
														btnExit.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent arg0) {
																frmLogin.dispose();
															}
														});
														btnLogin.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent arg0) {
																//=======Get user from http rest call=====
																userdetailnew = getuserdetail.getLoginFromServer("", "", "", "");
																if(userdetailnew == null){
																	JOptionPane.showMessageDialog(null, "Check your internet connection!");
																}else{
																	if(edtUsername.getText().equals(userdetailnew.getUserName()) && edtPassword.getText().equals(userdetailnew.getUserPassword())){
																		frmLogin.dispose();
																		MainMenu menu = new MainMenu();
																		menu.frmMenu.setVisible(true);
																	}
																	else{
																		JOptionPane.showMessageDialog(null, "Invalid Credentials");
																	}
																}
															}
														});

		JPanel pnlCenter_South = new JPanel();
		pnlCenter_South.setBackground(Color.WHITE);
		pnlBorder.add(pnlCenter_South, BorderLayout.SOUTH);
		pnlCenter_South.setLayout(new BoxLayout(pnlCenter_South, BoxLayout.Y_AXIS));
		
				JPanel panel_4 = new JPanel();
				pnlCenter_South.add(panel_4);
				panel_4.setBackground(Color.WHITE);
				
						JPanel panel_2 = new JPanel();
						panel_4.add(panel_2);
						panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
						panel_2.setBackground(Color.WHITE);
						
								JLabel lblNewLabel = new JLabel("");
								lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\pills1.jpg"));
								lblNewLabel.setAlignmentX(0.5f);
								lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
								panel_2.add(lblNewLabel);

		JPanel pnl_South = new JPanel();
		pnl_South.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) pnl_South.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		frmLogin.getContentPane().add(pnl_South, BorderLayout.SOUTH);

		JLabel label = new JLabel("ReRoute Systems");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		pnl_South.add(label);
	}
}
