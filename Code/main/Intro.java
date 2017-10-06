package com.reroute.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Intro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
					//UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
					//UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
					//UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
					//UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());
					//UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
					//UIManager.setLookAndFeel(new SyntheticaGreenDreamLookAndFeel());
					//UIManager.setLookAndFeel(new SyntheticaMauveMetallicLookAndFeel());
					//UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());
					//UIManager.setLookAndFeel(new SyntheticaSilverMoonLookAndFeel());
					//UIManager.setLookAndFeel(new SyntheticaSkyMetallicLookAndFeel());
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					Intro frame = new Intro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Intro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Smart Search - Welcome");
		setSize(1000, 860);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.WHITE);
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));

		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(Color.WHITE);
		pnlNorth.add(pnlTop);
		pnlTop.setLayout(new BoxLayout(pnlTop, BoxLayout.Y_AXIS));

		JLabel lblEmpty = new JLabel(" ");
		lblEmpty.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		pnlTop.add(lblEmpty);

		JLabel lblEmpty1 = new JLabel(" ");
		lblEmpty1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		pnlTop.add(lblEmpty1);

		JPanel pnlBottom = new JPanel();
		pnlBottom.setBackground(Color.WHITE);
		pnlNorth.add(pnlBottom);
		pnlBottom.setLayout(new BoxLayout(pnlBottom, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		pnlBottom.add(panel);

		JLabel lblLogoUP = new JLabel("");
		panel.add(lblLogoUP);
		lblLogoUP.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\Eeufeeslogo1.jpg"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		pnlBottom.add(panel_1);

		JLabel lblNewLabel = new JLabel("COS301 Main Project");
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 30));

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		pnlBottom.add(panel_9);

		JLabel lblNewLabel_1 = new JLabel("Department of Computer Science ");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		panel_9.add(lblNewLabel_1);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBorder(null);
		pnlCenter.setBackground(Color.WHITE);
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.Y_AXIS));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		pnlCenter.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JLabel label = new JLabel(" ");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_2.add(label);

		JLabel lblNewLabel_2 = new JLabel("System Description : ");
		lblNewLabel_2.setAlignmentX(0.5f);
		lblNewLabel_2.setForeground(SystemColor.activeCaption);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		panel_2.add(lblNewLabel_2);

		JLabel label_1 = new JLabel(" ");
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_2.add(label_1);

		JPanel panel_3 = new JPanel();
		panel_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		panel_3.setBackground(Color.WHITE);
		pnlCenter.add(panel_3);

		JLabel lbl1 = new JLabel("This project forms part of the Reroute Purchase Management System, an application mainly active in the pharmaceutical space. It entails the use of Big Data, in terms of the database including the names of a massive number of products.");
		lbl1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel_3.add(lbl1);

		JLabel lbl2 = new JLabel("Team CodeX from University of Pretoria has developed a system with the ability to perform efficient searches, as well as identify patterns from client behaviour. Additionally, it offers maintainability for the incredibly fast database, making it the perfect tool to handle Big Data queries.");
		lbl2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel_3.add(lbl2);

		JLabel lbl3 = new JLabel("The project was given by the company ReRoute Systems as they were facing the challenge of linking similar words and search through more than 400000 records at the same time.");
		lbl3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel_3.add(lbl3);

		JLabel lbl4 = new JLabel("Data-Re company provided a license to use the Zizo database and the services in order to complete this project.");
		lbl4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel_3.add(lbl4);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		pnlCenter.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));

		JLabel label_3 = new JLabel(" ");
		label_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_7.add(label_3);

		JLabel label_4 = new JLabel(" ");
		label_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_7.add(label_4);

		JLabel lblPressTheFollowing = new JLabel(" Press the following icon to log into Smart Search system");
		lblPressTheFollowing.setAlignmentX(0.5f);
		panel_7.add(lblPressTheFollowing);
		lblPressTheFollowing.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_7.add(panel_8);

		JButton btnLogoStart = new JButton("");
		btnLogoStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login login = new Login();
				login.frmLogin.setVisible(true);
			}
		});
		btnLogoStart.setBackground(Color.WHITE);
		btnLogoStart.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\pms_button4.png"));
		btnLogoStart.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_8.add(btnLogoStart);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_10.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_7.add(panel_10);

		JLabel lblNewLabel_3 = new JLabel("Sponsored  by : ");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.ITALIC, 16));
		panel_10.add(lblNewLabel_3);

		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.WHITE);
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		pnlSouth.add(panel_4, BorderLayout.WEST);

		JLabel lblRerouteLogo = new JLabel("");
		lblRerouteLogo.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\reroutelogo.png"));
		panel_4.add(lblRerouteLogo);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		pnlSouth.add(panel_5, BorderLayout.CENTER);

		JLabel lblDataReLogo = new JLabel("");
		lblDataReLogo.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\Data-re-logo-web.png"));
		panel_5.add(lblDataReLogo);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		pnlSouth.add(panel_6, BorderLayout.EAST);

		JLabel label_2 = new JLabel("CODE X");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(218, 29, 44));
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 70));
		label_2.setBackground(new Color(178, 34, 34));
		panel_6.add(label_2);
	}

}
