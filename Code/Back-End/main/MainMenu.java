package com.reroute.main;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class MainMenu {
	public JFrame frmMenu;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = 0;
	private int height = 0;

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("Smart Search - Menu");
		frmMenu.setBounds(100, 100, 450, 450);
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		width = 600;
		height = 450;
		frmMenu.setSize(1000, 860);
		frmMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmMenu.setLocationRelativeTo(null);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnl_North = new JPanel();
		pnl_North.setBackground(Color.WHITE);
		frmMenu.getContentPane().add(pnl_North, BorderLayout.NORTH);

		JLabel lblSmartSearchMenu = new JLabel("Smart Search Pharmaceutical Menu");
		lblSmartSearchMenu.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		pnl_North.add(lblSmartSearchMenu);
		lblSmartSearchMenu.setForeground(new Color(220, 20, 60));
		//====================

		JPanel pnl_Center = new JPanel();
		pnl_Center.setBackground(Color.WHITE);
		frmMenu.getContentPane().add(pnl_Center, BorderLayout.CENTER);
		pnl_Center.setLayout(null);

		JButton btnSearch = new JButton("Search Product");
		btnSearch.setForeground(SystemColor.textHighlight);
		btnSearch.setBackground(SystemColor.activeCaptionBorder);
		btnSearch.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\ic_search_catura_blue.png"));
		btnSearch.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMenu.dispose();
				SearchProduct searchproduct = new SearchProduct();
				searchproduct.frmSearchProduct.setVisible(true);
			}
		});
		btnSearch.setBounds(621, 103, 258, 221);
		pnl_Center.add(btnSearch);

		JButton btnDictionary = new JButton("Dictionary");
		btnDictionary.setForeground(SystemColor.textHighlight);
		btnDictionary.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\dictionaryArtboard 1.png"));
		btnDictionary.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnDictionary.setBackground(SystemColor.activeCaptionBorder);
		btnDictionary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMenu.dispose();
				Dictionary dictionary = new Dictionary();
				dictionary.frmDictionary.setVisible(true);
			}
		});
		btnDictionary.setBounds(1070, 103, 248, 221);
		pnl_Center.add(btnDictionary);

		JButton btnEditDictionary = new JButton("Edit Dictionary");
		btnEditDictionary.setForeground(SystemColor.textHighlight);
		btnEditDictionary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.dispose();
				EditDictionary editdictionary = new EditDictionary();
				editdictionary.frmEditDictionary.setVisible(true);
			}
		});
		btnEditDictionary.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\dictionary editArtboard 1.png"));
		btnEditDictionary.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnEditDictionary.setBackground(SystemColor.activeCaptionBorder);
		btnEditDictionary.setBounds(621, 349, 258, 221);
		pnl_Center.add(btnEditDictionary);

		JButton btnNewButton = new JButton("Delete Product");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\delete_trashcanArtboard 1.png"));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(1069, 349, 248, 221);
		pnl_Center.add(btnNewButton);

		JPanel pnl_South = new JPanel();
		pnl_South.setBackground(Color.WHITE);
		frmMenu.getContentPane().add(pnl_South, BorderLayout.SOUTH);
		pnl_South.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		pnl_South.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.WHITE);

				JPanel panel_2 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel_2.setBackground(Color.WHITE);
				panel.add(panel_2);

				JLabel lblNewLabel_2 = new JLabel("          ");
				lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel_2.add(lblNewLabel_2);

								JButton btnReturn = new JButton("Return");
								btnReturn.setForeground(SystemColor.textHighlight);
								panel_2.add(btnReturn);
								btnReturn.setHorizontalAlignment(SwingConstants.LEFT);
								btnReturn.setBackground(SystemColor.activeCaptionBorder);
								btnReturn.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\done_back_previous_icon.png"));
								btnReturn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
								btnReturn.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										frmMenu.dispose();
										Login login = new Login();
										login.frmLogin.setVisible(true);
									}
								});

				JLabel lblNewLabel = new JLabel(" ");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				panel.add(lblNewLabel);

				JLabel label = new JLabel(" ");
				label.setFont(new Font("Tahoma", Font.PLAIN, 20));
				panel.add(label);

				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.WHITE);
				pnl_South.add(panel_1, BorderLayout.NORTH);

				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\pills1.jpg"));
				panel_1.add(lblNewLabel_1);
	}
}
