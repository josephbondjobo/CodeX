package com.reroute.main;

import javax.swing.JFrame;
import javax.swing.JTextField;
import com.reroute.datasource.Product;
import com.reroute.datasource.ProductDao;
import com.reroute.datasource.ProductImpl;
import com.reroute.tools.NumericUtil;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class SearchProduct extends JFrame{

	private String[] progress = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};
	private LocalDb localdb = null;
	public JFrame frmSearchProduct;
	private ProductDao productdao = new ProductImpl();
	/*Constant variables*/
	private String[] prodSchedOptions = new String[]{"1","2","3","4","5","6","7","&"};
	private String and = "And";

	/*Text fields variables declaration*/
	private JTextField edtProductID = new JTextField();

	private JTextField edtProductName1 = new JTextField();
	private JTextField edtProductName2 = new JTextField();
	private JTextField edtProductName3 = new JTextField();
	private JTextField edtProductName4 = new JTextField();
	private JTextField edtProductName5 = new JTextField();
	private JTextField edtProductStrength = new JTextField();
	private JTextField edtProductPack = new JTextField();
	private TextArea edtProductDescrip = new TextArea();

	/*Combo variables*/
	private JComboBox<String> cmbProductSched = new JComboBox<String>();

	/*Grid list declaration*/
	java.awt.List listGrid = null;

	/*variables*/
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String name5;

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = 0;
	private int height = 0;
	private JTextField edtTimeExecuted;

	private List<Product> aProductList = null;
	private NumericUtil numericutil = new NumericUtil();
	private DateFormat dateFormat = new SimpleDateFormat("mm:ss");
	private Date startRunningTime = null;
	private Date endRunningTime = null;

	/**
	 * Create the application.
	 */
	public SearchProduct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmSearchProduct = new JFrame();
		frmSearchProduct.setBounds(100, 100, 450, 300);
		frmSearchProduct.setTitle("Search product");
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		height = 850; //fix height screen
		width = 1100;
		frmSearchProduct.setSize(width, height);
		frmSearchProduct.setLocationRelativeTo(null);
		frmSearchProduct.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmSearchProduct.getContentPane().setLayout(new BorderLayout(0, 0));

		/*Panels declaration*/
		JPanel panel = new JPanel();
		frmSearchProduct.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel pnlNorth = new JPanel();
		panel.add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("");
		pnlNorth.add(lblNewLabel);

		JPanel pnlCenter = new JPanel();
		panel.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));

		JPanel pnlSubCenter = new JPanel();
		pnlCenter.add(pnlSubCenter);
		pnlSubCenter.setLayout(null);

		JPanel pnlSouth = new JPanel();
		panel.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//----------------------------------------------
		JButton btnReset = new JButton("Reset");
		pnlSouth.add(btnReset);


		//----------------------------------------------

		JButton btnCancel = new JButton("Cancel");
		pnlSouth.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSearchProduct.dispose();
				MainMenu menu = new MainMenu();
				menu.frmMenu.setVisible(true);
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cleanTextField();
			}
		});

		/*Label declaration*/
		JLabel lblProductSched = new JLabel("Product Schedule    :");
		lblProductSched.setBounds(21, 267, 121, 14);
		pnlSubCenter.add(lblProductSched);

		JLabel lblProductName = new JLabel("Product Name : ");
		lblProductName.setBounds(21, 97, 121, 14);
		pnlSubCenter.add(lblProductName);

		JLabel lblProductDescription = new JLabel("Product Description :");
		lblProductDescription.setBounds(21, 139, 121, 14);
		pnlSubCenter.add(lblProductDescription);

		JLabel lblProductPack = new JLabel("Product Pack :");
		lblProductPack.setBounds(21, 204, 121, 14);
		pnlSubCenter.add(lblProductPack);

		JLabel lblProductStrength = new JLabel("Product Strength :");
		lblProductStrength.setBounds(21, 235, 121, 14);
		pnlSubCenter.add(lblProductStrength);

		JLabel lblAnd_1 = new JLabel(and);
		lblAnd_1.setBounds(383, 97, 32, 14);
		pnlSubCenter.add(lblAnd_1);

		JLabel lblAnd_2 = new JLabel(and);
		lblAnd_2.setBounds(493, 97, 32, 14);
		pnlSubCenter.add(lblAnd_2);

		JLabel lblAnd_3 = new JLabel(and);
		lblAnd_3.setBounds(604, 97, 32, 14);
		pnlSubCenter.add(lblAnd_3);

		JLabel lblAnd_4 = new JLabel(and);
		lblAnd_4.setBounds(699, 97, 32, 14);
		pnlSubCenter.add(lblAnd_4);

		JLabel lblNameSearchResults = new JLabel("Name search results:");
		lblNameSearchResults.setBounds(321, 358, 136, 14);
		pnlSubCenter.add(lblNameSearchResults);

		JLabel lblProductId = new JLabel("Product ID :");
		lblProductId.setBounds(21, 66, 89, 14);
		pnlSubCenter.add(lblProductId);

		/*Text field initialization*/
		edtProductID.setBounds(181, 63, 192, 20);
		edtProductID.setEnabled(true);
		pnlSubCenter.add(edtProductID);
		edtProductID.setColumns(10);

		edtProductName1.setBounds(181, 94, 192, 20);
		pnlSubCenter.add(edtProductName1);
		edtProductName1.setColumns(10);
		edtProductName2.setBounds(425, 94, 58, 20);
		pnlSubCenter.add(edtProductName2);
		edtProductName2.setColumns(10);

		edtProductName3.setBounds(535, 94, 58, 20);
		pnlSubCenter.add(edtProductName3);
		edtProductName3.setColumns(10);

		edtProductName4.setBounds(646, 94, 42, 20);
		pnlSubCenter.add(edtProductName4);
		edtProductName4.setColumns(10);

		edtProductName5.setBounds(741, 94, 42, 20);
		pnlSubCenter.add(edtProductName5);
		edtProductName5.setColumns(10);

		edtProductPack.setBounds(182, 201, 191, 20);
		pnlSubCenter.add(edtProductPack);
		edtProductPack.setColumns(10);

		edtProductStrength.setBounds(181, 232, 191, 20);
		pnlSubCenter.add(edtProductStrength);
		edtProductStrength.setColumns(10);

		edtProductDescrip.setBounds(181, 120, 424, 76);
		pnlSubCenter.add(edtProductDescrip);

		/*Combo initialization*/
		cmbProductSched.setModel(new DefaultComboBoxModel<String>(prodSchedOptions));
		cmbProductSched.setBounds(182, 263, 191, 23);
		pnlSubCenter.add(cmbProductSched);

		/*Time executed*/
		JLabel lblTimeExecuted = new JLabel("Time Executed : ");
		lblTimeExecuted.setBounds(24, 669, 136, 14);
		pnlSubCenter.add(lblTimeExecuted);

		edtTimeExecuted = new JTextField();
		edtTimeExecuted.setBounds(181, 666, 192, 20);
		pnlSubCenter.add(edtTimeExecuted);
		edtTimeExecuted.setColumns(10);
		edtTimeExecuted.setEnabled(false);

		/*Grid List Initialization*/
		listGrid = new java.awt.List();
		listGrid.setBounds(181, 392, 424, 268);
		pnlSubCenter.add(listGrid);
		//----------------------------------------------
		listGrid.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(final java.awt.event.MouseEvent e) {
				/*cleaning textfield except Grid for new search*/
				cleanTextFieldExceptGrid();
				displayValues(aProductList.get(listGrid.getSelectedIndex()));
			}
		});
		//----------------------------------------------
		JButton btnSearchName = new JButton("Search");
		btnSearchName.setBounds(800, 93, 77, 23);
		pnlSubCenter.add(btnSearchName);

		//----------------------------------------------
		JButton btnSearchReddis = new JButton("Search Reddis");
		btnSearchReddis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Destroying Grid list for new search*/
				listGrid.removeAll();
				/*open db*/
				localdb = new LocalDb();
				//get time here
				startRunningTime = new Date();
				//======
				name1 = edtProductName1.getText().toUpperCase();

				if(name1.equals("")){
					JOptionPane.showMessageDialog(null, "Nothin found.");
				}
				else{
					/*
					Product product = productdao.getProductName(name1);
					if(product != null){
						displayValues(product);
					}*/
					//int pid = numericutil.str2Int(localdb.findKey(name1));
					Set<String> list = localdb.findKey(name1);
					for (String key : list) {
						System.out.print("Key: "+key+" => ");
						Set<String> members = localdb.getMembers(key);
						System.out.println(members);
					}
					endRunningTime = new Date();
					/*aProductList = productdao.getProductNameLike(name1, name2, name3, name4, name5);
					if(aProductList.size() > 0){
						displayValues(aProductList.get(0));
							for(int i=0;(i< 20 && i<aProductList.size());++i){
								listGrid.add(aProductList.get(i).getProductName()+" - "+ aProductList.get(i).getProductPack());
								//NORVASC,NEEDLE NOVOFINE,NUROFEN
								//OINT JAR PVC CLEAR 500ML SCREWCAP SINGLE
							}
							//get time here
							endRunningTime = new Date();
							//========
					}
					else{
						JOptionPane.showMessageDialog(null, "Nothin found.");
					}*/

					edtTimeExecuted.setText(getSearchRunningTime()+"ms");
					//
				}
				localdb.close();
			}
		});
		btnSearchReddis.setBounds(773, 135, 116, 23);
		pnlSubCenter.add(btnSearchReddis);
		//----------------------------------------------
		JButton btnCopy = new JButton("Copy");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyDataFromMainDb();
			}
		});
		btnCopy.setBounds(788, 173, 89, 23);
		pnlSubCenter.add(btnCopy);
		btnSearchName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Destroying Grid list for new search*/
				listGrid.removeAll();
				//get time here
				startRunningTime = new Date();
				//======
				name1 = edtProductName1.getText().toUpperCase();
				name2 = edtProductName2.getText().toUpperCase();
				name3 = edtProductName3.getText().toUpperCase();
				name4 = edtProductName4.getText().toUpperCase();
				name5 = edtProductName5.getText().toUpperCase();

				if(name1.equals("") && name2.equals("") && name3.equals("") && name4.equals("") && name5.equals("")){
					JOptionPane.showMessageDialog(null, "Nothin found.");
				}
				else{
					/*
					Product product = productdao.getProductName(name1);
					if(product != null){
						displayValues(product);
					}*/
					aProductList = productdao.getProductNameLike(name1, name2, name3, name4, name5);
					if(aProductList.size() > 0){
						displayValues(aProductList.get(0));
							for(int i=0;(i< 20 && i<aProductList.size());++i){
								listGrid.add(aProductList.get(i).getProductName()+" - "+ aProductList.get(i).getProductPack());
								//NORVASC,NEEDLE NOVOFINE,NUROFEN
								//OINT JAR PVC CLEAR 500ML SCREWCAP SINGLE
							}
							//get time here
							endRunningTime = new Date();
							//========
					}
					else{
						JOptionPane.showMessageDialog(null, "Nothin found.");
					}

					edtTimeExecuted.setText(getSearchRunningTime()+"ms");
					//
				}
			}
		});
	}

	public String getSearchRunningTime(){
		long diff = Math.abs(startRunningTime.getTime() - endRunningTime.getTime());
		long diffSeconds = diff / 1000 % 60;
		long diffMilliseconds = diff / 1 % 60;
		return ""+diffMilliseconds;
	}
	/*Help function to CLEAN all textfields*/
	private void cleanTextField(){
		listGrid.removeAll();
		edtProductID.setText("");
		edtProductName1.setText("");
		edtProductName2.setText("");
		edtProductName3.setText("");
		edtProductName4.setText("");
		edtProductName5.setText("");
		edtProductStrength.setText("");
		edtProductDescrip.setText("");
		edtProductPack.setText("");
		cmbProductSched.setSelectedIndex(0);
		cmbProductSched.setSelectedIndex(0);
	}

	/*Help function to CLEAN all textfields except on Grid*/
	private void cleanTextFieldExceptGrid(){
		edtProductID.setText("");
		//edtProductName1.setText("");
		//edtProductName1.setText("");
		//edtProductName2.setText("");
		//edtProductName3.setText("");
		//edtProductName4.setText("");
		//edtProductName5.setText("");
		edtProductStrength.setText("");
		edtProductDescrip.setText("");
		edtProductPack.setText("");
		cmbProductSched.setSelectedIndex(0);
		cmbProductSched.setSelectedIndex(0);
	}

	//--------------------------------------
	/*Help function to display details of product with name using Product parameter*/
	private void displayValues(Product pProduct){
		edtProductID.setText(String.valueOf(pProduct.getIdProduct()));
		edtProductStrength.setText(pProduct.getProductStrength());
		edtProductDescrip.setText(pProduct.getProductDescription());
		edtProductPack.setText(pProduct.getProductPack());
		cmbProductSched.setSelectedItem(pProduct.getProductSchedule());
	}
	//--------------------------------------
	private void copyDataFromMainDb(){
		localdb = new LocalDb();
		localdb.deleteAll();
		for(int i=0; i<progress.length;++i){
			System.out.println("=="+(i*100)/36+"%== "+progress[i]);
			List<Product> aProductList = productdao.getProductNameStartWith(progress[i]);
			if(aProductList != null){
				for(int j=0; j< aProductList.size();++j){
					localdb.enqueue(aProductList.get(j).getProductName(),""+aProductList.get(j).getIdProduct());
					//localdb.enqueue(""+aProductList.get(j).getIdProduct(),aProductList.get(j).getProductName());
				}
			}
		}
		System.out.println("===========\nReddis DB size: "+localdb.size());
		localdb.close();
	}
}
