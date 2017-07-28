package cos301.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dictionary {

	public JFrame frmDictionary;
	private JTextField edtKey1;
	private JTextField edtKey2;
	private String word1 = "";
	private String word2 = "";

	/**
	 * Create the application.
	 */
	public Dictionary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDictionary = new JFrame();
		frmDictionary.setTitle("Smart Search - Dictionary");
		frmDictionary.setBounds(100, 100, 700, 500);
		frmDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnlNorth = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlNorth.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmDictionary.getContentPane().add(pnlNorth, BorderLayout.NORTH);

		JLabel lblProductSearch = new JLabel(" Dictionary");
		lblProductSearch.setForeground(Color.GRAY);
		lblProductSearch.setHorizontalAlignment(SwingConstants.LEFT);
		lblProductSearch.setFont(new Font("Segoe UI", Font.PLAIN, 40));
		pnlNorth.add(lblProductSearch);

		JPanel pnlCenter = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnlCenter.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		frmDictionary.getContentPane().add(pnlCenter, BorderLayout.CENTER);

		JPanel panelBorder = new JPanel();
		pnlCenter.add(panelBorder);
		panelBorder.setLayout(new BorderLayout(0, 0));

		JPanel panelNorth = new JPanel();
		panelBorder.add(panelNorth, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panelNorth.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_West = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_West.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_West, BorderLayout.WEST);

		JPanel panel_1 = new JPanel();
		panel_West.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_3);

		JLabel lblInstruction = new JLabel("Enter keywords with same meaning : ");
		panel_3.add(lblInstruction);
		lblInstruction.setForeground(Color.RED);
		lblInstruction.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblInstruction.setHorizontalAlignment(SwingConstants.LEFT);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		edtKey1 = new JTextField();
		edtKey1.setToolTipText("Enter Product Name");
		panel_2.add(edtKey1);
		edtKey1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edtKey1.setHorizontalAlignment(SwingConstants.LEFT);
		edtKey1.setColumns(20);

		edtKey2 = new JTextField();
		panel_2.add(edtKey2);
		edtKey2.setToolTipText("Enter Product ID");
		edtKey2.setHorizontalAlignment(SwingConstants.LEFT);
		edtKey2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edtKey2.setColumns(20);

		JButton btnDictionarySubmit = new JButton("Submit");
		btnDictionarySubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				word1 = edtKey1.getText();
				word2 = edtKey2.getText();

				if(word1.equals("") && word2.equals("")){
					JOptionPane.showMessageDialog(null, "Keyword(s) cannot be empty!");
				}
				else{
					//do something
				}
			}
		});
		panel_2.add(btnDictionarySubmit);

		JPanel pnlSouth = new JPanel();
		frmDictionary.getContentPane().add(pnlSouth, BorderLayout.SOUTH);

		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDictionary.dispose();
				MainMenu mainmenu = new MainMenu();
				mainmenu.frmMenu.setVisible(true);
			}
		});
		pnlSouth.add(btnReturn);
	}

}
