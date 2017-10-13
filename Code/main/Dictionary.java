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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Dictionary {

	public JFrame frmDictionary;
	private JTextField edtKey1;
	private JTextField edtKey2;
	private String word1 = "";
	private String word2 = "";
//	private static final String FILENAME = "C:\\Users\\Daniel\\Documents\\COS 301\\COS301\\src\\cos301\\Icons-Front-end\\Dictionary.txt";
	private static final String FILENAME = "C:\\data\\pharma\\refdata\\dict.txt";
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
		frmDictionary.setSize(1000, 860);
		frmDictionary.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmDictionary.setLocationRelativeTo(null);
		frmDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) pnlNorth.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmDictionary.getContentPane().add(pnlNorth, BorderLayout.NORTH);

		JLabel lblProductSearch = new JLabel(" Dictionary");
		lblProductSearch.setForeground(new Color(220, 20, 60));
		lblProductSearch.setHorizontalAlignment(SwingConstants.LEFT);
		lblProductSearch.setFont(new Font("Segoe UI", Font.PLAIN, 60));
		pnlNorth.add(lblProductSearch);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) pnlCenter.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		frmDictionary.getContentPane().add(pnlCenter, BorderLayout.CENTER);

		JPanel panelBorder = new JPanel();
		panelBorder.setBackground(Color.WHITE);
		pnlCenter.add(panelBorder);
		panelBorder.setLayout(new BorderLayout(0, 0));

		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.WHITE);
		panelBorder.add(panelNorth, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panelNorth.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_West = new JPanel();
		panel_West.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_West.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_West, BorderLayout.WEST);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_West.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_3);

		JLabel lblInstruction = new JLabel("Enter keywords with same meaning : ");
		panel_3.add(lblInstruction);
		lblInstruction.setForeground(new Color(220, 20, 60));
		lblInstruction.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblInstruction.setHorizontalAlignment(SwingConstants.LEFT);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2);

		edtKey1 = new JTextField();
		edtKey1.setToolTipText("Enter Product Name");
		panel_2.add(edtKey1);
		edtKey1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		edtKey1.setHorizontalAlignment(SwingConstants.LEFT);
		edtKey1.setColumns(20);

		JLabel lblNewLabel_1 = new JLabel("means");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_1);

		edtKey2 = new JTextField();
		panel_2.add(edtKey2);
		edtKey2.setToolTipText("Enter Product ID");
		edtKey2.setHorizontalAlignment(SwingConstants.LEFT);
		edtKey2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		edtKey2.setColumns(20);

		JButton btnDictionarySubmit = new JButton("Submit");
		btnDictionarySubmit.setIcon(new ImageIcon("C:\\Users\\Daniel\\Documents\\COS 301\\COS301\\src\\cos301\\Icons-Front-end\\submit_send_continue.png"));
		btnDictionarySubmit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnDictionarySubmit.setBackground(SystemColor.activeCaptionBorder);
		btnDictionarySubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				word1 = edtKey1.getText().toUpperCase();
				word2 = edtKey2.getText().toUpperCase();

				if(word1.equals("") && word2.equals("")){
					JOptionPane.showMessageDialog(null, "Keyword(s) cannot be empty!");
				}
				else{
					fileWrite(word1,word2);
				}
			}
		});
		panel_2.add(btnDictionarySubmit);

		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.WHITE);
		frmDictionary.getContentPane().add(pnlSouth, BorderLayout.SOUTH);

		JPanel panel_4 = new JPanel();
		pnlSouth.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		panel_4.setBackground(Color.WHITE);

		JButton btnReturn = new JButton("Return");
		btnReturn.setBackground(SystemColor.activeCaptionBorder);
		btnReturn.setIcon(new ImageIcon("C:\\Users\\Daniel\\Documents\\COS 301\\COS301\\src\\cos301\\Icons-Front-end\\done_back_previous_icon.png"));
		panel_4.add(btnReturn);
		btnReturn.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JLabel lblNewLabel = new JLabel("     ");
		panel_4.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel label = new JLabel("     ");
		panel_4.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDictionary.dispose();
				MainMenu mainmenu = new MainMenu();
				mainmenu.frmMenu.setVisible(true);
			}
		});
	}

	public void fileWrite(String key1, String key2){

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			String content = key1+ ","+key2;

			fw = new FileWriter(FILENAME, true);
			bw = new BufferedWriter(fw);
			bw.write(content);
			bw.newLine();

			JOptionPane.showMessageDialog(null, "New keywords added!");
			edtKey1.setText("");//to clear fields
			edtKey2.setText("");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
}
