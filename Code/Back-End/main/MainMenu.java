package cos301.main;

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

		JLabel lblSmartSearchMenu = new JLabel("Smart Search Menu");
		lblSmartSearchMenu.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		pnl_North.add(lblSmartSearchMenu);
		lblSmartSearchMenu.setForeground(new Color(220, 20, 60));
		//====================

		JPanel pnl_Center = new JPanel();
		pnl_Center.setBackground(Color.WHITE);
		frmMenu.getContentPane().add(pnl_Center, BorderLayout.CENTER);
		pnl_Center.setLayout(null);

		JButton btnSearch = new JButton("Search Product");
		btnSearch.setBackground(SystemColor.activeCaptionBorder);
		btnSearch.setIcon(new ImageIcon("C:\\Users\\Daniel\\Documents\\COS 301\\COS301\\src\\cos301\\Icons-Front-end\\ic_search_catura_blue.png"));
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
		btnDictionary.setIcon(new ImageIcon("C:\\Users\\Daniel\\Documents\\COS 301\\COS301\\src\\cos301\\Icons-Front-end\\dictionaryArtboard 1.png"));
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
		btnEditDictionary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.dispose();
				EditDictionary editdictionary = new EditDictionary();
				editdictionary.frmEditDictionary.setVisible(true);
			}
		});
		btnEditDictionary.setIcon(new ImageIcon("C:\\Users\\Daniel\\Documents\\COS 301\\COS301\\src\\cos301\\Icons-Front-end\\dictionary editArtboard 1.png"));
		btnEditDictionary.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnEditDictionary.setBackground(SystemColor.activeCaptionBorder);
		btnEditDictionary.setBounds(621, 349, 258, 221);
		pnl_Center.add(btnEditDictionary);

		JButton btnNewButton = new JButton("Delete Product");
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Daniel\\Documents\\COS 301\\COS301\\src\\cos301\\Icons-Front-end\\delete_trashcanArtboard 1.png"));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
                btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(1069, 349, 248, 221);
		pnl_Center.add(btnNewButton);

		JPanel pnl_South = new JPanel();
		pnl_South.setBackground(Color.WHITE);
		frmMenu.getContentPane().add(pnl_South, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		pnl_South.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.WHITE);

				JButton btnReturn = new JButton("Return");
				btnReturn.setBackground(SystemColor.activeCaptionBorder);
				btnReturn.setIcon(new ImageIcon("C:\\Users\\Daniel\\Documents\\COS 301\\COS301\\src\\cos301\\Icons-Front-end\\done_back_previous_icon.png"));
				panel.add(btnReturn);
				btnReturn.setFont(new Font("Segoe UI", Font.PLAIN, 20));

				JLabel lblNewLabel = new JLabel(" ");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				panel.add(lblNewLabel);

				JLabel label = new JLabel(" ");
				label.setFont(new Font("Tahoma", Font.PLAIN, 20));
				panel.add(label);
				btnReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frmMenu.dispose();
						Login login = new Login();
						login.frmLogin.setVisible(true);
					}
				});
	}
}
