package com.reroute.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.SystemColor;

public class EditDictionary{

	public JFrame frmEditDictionary;
	private static final String FILENAME = "C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\Dictionary.txt";
	private int index = -1;
	private ArrayList<String> wordsToRead = new ArrayList<String>();
	private int sizeOfWordsToRead = 0;
	private JComboBox cmbWords = null;
	//private static final String FILENAME = "C:\\data\\pharma\\refdata\\dict.txt";
	/**
	 * Create the application.
	 */
	public EditDictionary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditDictionary = new JFrame();
		frmEditDictionary.setTitle("Smart Search - Edit Dictionary");
		frmEditDictionary.setBounds(100, 100, 700, 500);
		frmEditDictionary.setSize(1000, 860);
		frmEditDictionary.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmEditDictionary.setLocationRelativeTo(null);
		frmEditDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditDictionary.setForeground(Color.WHITE);

		JPanel pnlNorth = new JPanel();
		frmEditDictionary.getContentPane().add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setLayout(new BorderLayout(0, 0));
		pnlNorth.setBackground(Color.WHITE);

		JLabel lblEditDictionary = new JLabel(" Edit Dictionary");
		pnlNorth.add(lblEditDictionary, BorderLayout.NORTH);
		lblEditDictionary.setHorizontalAlignment(SwingConstants.LEFT);
		lblEditDictionary.setForeground(new Color(220, 20, 60));
		lblEditDictionary.setFont(new Font("Segoe UI", Font.PLAIN, 60));

		JPanel pnlCenter = new JPanel();
		frmEditDictionary.getContentPane().add(pnlCenter, BorderLayout.CENTER);

		pnlCenter.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		pnlCenter.setBackground(Color.WHITE);

		JPanel panel_4 = new JPanel();
		pnlCenter.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));

		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		JLabel label = new JLabel("Select key words to delete from Dictionary: ");
		panel_2.add(label);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(220, 20, 60));
		label.setFont(new Font("Segoe UI", Font.PLAIN, 25));

		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3);
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);

		JLabel lblWords = new JLabel("Words: ");
		panel_3.add(lblWords);
		lblWords.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		cmbWords = new JComboBox();
		panel_3.add(cmbWords);
		cmbWords.setPreferredSize(new Dimension(250, 30));
		cmbWords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = cmbWords.getSelectedIndex();
			}
		});
		cmbWords.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		//======READ FILE=======
		loadFile();
		//======================
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.activeCaptionBorder);
		btnDelete.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\delete_trashcanArtboard 2.png"));
		panel_3.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				wordsToRead.remove(index);
				cmbWords.removeAll();
				//cmbWords = new JComboBox();
				for(int i=0; i<wordsToRead.size();++i){
					cmbWords.addItem(wordsToRead.get(i));
				}
				JOptionPane.showMessageDialog(null, "Deleted successfully!");
			}
		});
		btnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JPanel pnlSouth = new JPanel();
		frmEditDictionary.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new BoxLayout(pnlSouth, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		pnlSouth.add(panel);
		JButton btnSave = new JButton("    Save     ");
		btnSave.setBackground(SystemColor.activeCaptionBorder);
		btnSave.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\save_load_stiffy_white_icon1.png"));
		panel.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sizeOfWordsToRead != wordsToRead.size()){
					writeFile();
					JOptionPane.showMessageDialog(null, "Changes saved!");
				}
				frmEditDictionary.dispose();
				MainMenu mainmenu = new MainMenu();
				mainmenu.frmMenu.setVisible(true);
			}
		});
		btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnSave.setActionCommand("OK");
		frmEditDictionary.getRootPane().setDefaultButton(btnSave);

		JLabel label_2 = new JLabel("                      ");
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panel.add(label_2);

		JButton btnReturn = new JButton("Return");
		btnReturn.setBackground(SystemColor.activeCaptionBorder);
		btnReturn.setIcon(new ImageIcon("C:\\Users\\Jocelyn\\Documents\\Catura\\Java\\ReRoute\\ReRoute\\done_back_previous_icon.png"));
		panel.add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEditDictionary.dispose();
				MainMenu mainmenu = new MainMenu();
				mainmenu.frmMenu.setVisible(true);
			}
		});
		btnReturn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnReturn.setActionCommand("Cancel");

		JPanel panel_1 = new JPanel();
		pnlSouth.add(panel_1);
		pnlSouth.setBackground(Color.WHITE);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		panel_1.setBackground(Color.WHITE);

		JLabel lblEmpty = new JLabel("  ");
		lblEmpty.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panel_1.add(lblEmpty);

		JLabel label_1 = new JLabel("    ");
		panel_1.add(label_1);
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));

	}

	public void writeFile(){
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			fw = new FileWriter(FILENAME, false);
			bw = new BufferedWriter(fw);

			for(int i=0; i<wordsToRead.size();++i){
				bw.write(wordsToRead.get(i));
				bw.newLine();
			}
			//JOptionPane.showMessageDialog(null, "New keywords added!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null){
					bw.close();
				}

				if (fw != null){
					fw.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public void loadFile(){
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				wordsToRead.add(sCurrentLine);
			}

			sizeOfWordsToRead = wordsToRead.size();

		} catch (IOException e) {
			e.printStackTrace();
		}

		for(int i=0; i<wordsToRead.size();++i){
			cmbWords.addItem(wordsToRead.get(i));
		}
	}

}
