package cos301.main;

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

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

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
					//UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
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
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.setBackground(Color.WHITE);
		frmLogin.setTitle("Smart Search - Login");
		frmLogin.setBounds(100, 100, 450, 450);
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		frmLogin.setSize(800, 600);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel pnl_North = new JPanel();
		frmLogin.getContentPane().add(pnl_North, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		pnl_North.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel pnl_Center = new JPanel();
		frmLogin.getContentPane().add(pnl_Center, BorderLayout.CENTER);
		pnl_Center.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnlBorder = new JPanel();
		pnl_Center.add(pnlBorder);
		pnlBorder.setLayout(new BorderLayout(0, 0));

		JPanel pnlCenter_North = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlCenter_North.getLayout();
		pnlCenter_North.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		pnlBorder.add(pnlCenter_North, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		pnlCenter_North.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);

		JLabel lblLogo = new JLabel("CODE X");
		panel_5.add(lblLogo);
		lblLogo.setForeground(new Color(255, 0, 0));
		lblLogo.setFont(new Font("Segoe UI", Font.PLAIN, 70));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setVerticalAlignment(SwingConstants.TOP);
		lblLogo.setIcon(null);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);

		JLabel lblSlogan = new JLabel("EXCEED | EXCEL | EXPRESS");
		panel_6.add(lblSlogan);
		lblSlogan.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblSlogan.setVerticalAlignment(SwingConstants.TOP);
		lblSlogan.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSlogan.setBackground(Color.WHITE);
		lblSlogan.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);

		JLabel label_3 = new JLabel("Smart Search");
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		panel_4.add(label_3);

		JPanel pnlCenter_Center = new JPanel();
		pnlBorder.add(pnlCenter_Center, BorderLayout.CENTER);

		JPanel pnlInput = new JPanel();
		pnlCenter_Center.add(pnlInput);
		pnlInput.setLayout(new BoxLayout(pnlInput, BoxLayout.Y_AXIS));

		JPanel panel_8 = new JPanel();
		pnlInput.add(panel_8);

		JLabel lblUsername = new JLabel("Username : ");
		panel_8.add(lblUsername);

		edtUsername = new JTextField();
		pnlInput.add(edtUsername);
		edtUsername.setToolTipText("Username");
		edtUsername.setColumns(10);

		JPanel panel_7 = new JPanel();
		pnlInput.add(panel_7);

		JLabel lblPassword = new JLabel("Password : ");
		panel_7.add(lblPassword);

		edtPassword = new JPasswordField();
		pnlInput.add(edtPassword);
		edtPassword.setToolTipText("Password");
		edtPassword.setColumns(10);

		JPanel pnlCenter_South = new JPanel();
		pnlBorder.add(pnlCenter_South, BorderLayout.SOUTH);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnLogin.setBackground(Color.RED);
		btnLogin.setForeground(Color.WHITE);
		pnlCenter_South.add(btnLogin);

		JButton btnExit = new JButton("  Exit  ");
		btnExit.setBackground(Color.RED);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		pnlCenter_South.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLogin.dispose();
			}
		});
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

		JPanel pnl_South = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnl_South.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		frmLogin.getContentPane().add(pnl_South, BorderLayout.SOUTH);

		JLabel label = new JLabel("ReRoute Systems");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnl_South.add(label);
	}
}
