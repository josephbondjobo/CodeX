package cos301.main;

import javax.swing.JFrame;
import javax.swing.JTextField;
import cos301.datasource.Product;
import cos301.util.NumericUtil;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SearchProduct extends JFrame{
	public JFrame frmSearchProduct;
	//private ProductDao productdao = new ProductImpl();
	/*Constant variables*/
	private String[] prodSchedOptions = new String[]{"1","2","3","4","5","6","7","&"};

	/*Text fields variables declaration*/
	private JTextField edtProductID = new JTextField();

	private JTextField edtProductName1 = new JTextField();
	private JTextField edtProductStrength = new JTextField();
	private JTextField edtProductPack = new JTextField();
	private TextArea edtProductDescrip = new TextArea();

	/*Combo variables*/
	private JComboBox<String> cmbProductSched = new JComboBox<String>();

	/*Grid list declaration*/
	java.awt.List listGrid = null;

	/*variables*/
	private String name1;
	private int id = 0;

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
		frmSearchProduct.setBounds(100, 100, 450, 450);
		frmSearchProduct.setTitle("Smart Search - Search Product");
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		frmSearchProduct.setSize(800, 720);
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

		JLabel lblEmpty = new JLabel(" ");
		pnlNorth.add(lblEmpty, BorderLayout.NORTH);

		JPanel pnlCenter = new JPanel();
		panel.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));

		JPanel pnlSubCenter = new JPanel();
		pnlCenter.add(pnlSubCenter);
		pnlSubCenter.setLayout(null);
		JLabel lblProductSched = new JLabel("Product Schedule    :");
		lblProductSched.setBounds(21, 142, 121, 14);
		pnlSubCenter.add(lblProductSched);

		JLabel lblProductDescription = new JLabel("Product Description :");
		lblProductDescription.setBounds(21, 11, 121, 14);
		pnlSubCenter.add(lblProductDescription);

		JLabel lblProductPack = new JLabel("Product Pack :");
		lblProductPack.setBounds(21, 92, 121, 14);
		pnlSubCenter.add(lblProductPack);

		JLabel lblProductStrength = new JLabel("Product Strength :");
		lblProductStrength.setBounds(21, 117, 121, 14);
		pnlSubCenter.add(lblProductStrength);

		JLabel lblNameSearchResults = new JLabel("Name search results:");
		lblNameSearchResults.setBounds(328, 205, 136, 14);
		pnlSubCenter.add(lblNameSearchResults);

		edtProductPack.setBounds(181, 89, 191, 20);
		pnlSubCenter.add(edtProductPack);
		edtProductPack.setColumns(10);

		edtProductStrength.setBounds(181, 114, 191, 20);
		pnlSubCenter.add(edtProductStrength);
		edtProductStrength.setColumns(10);

		edtProductDescrip.setBounds(181, 10, 424, 70);
		pnlSubCenter.add(edtProductDescrip);
		cmbProductSched.setModel(new DefaultComboBoxModel<String>(prodSchedOptions));
		cmbProductSched.setBounds(181, 145, 191, 23);
		pnlSubCenter.add(cmbProductSched);
		JLabel lblTimeExecuted = new JLabel("Time Executed : ");
		lblTimeExecuted.setBounds(21, 509, 136, 14);
		pnlSubCenter.add(lblTimeExecuted);

		edtTimeExecuted = new JTextField();
		edtTimeExecuted.setBounds(181, 506, 192, 20);
		pnlSubCenter.add(edtTimeExecuted);
		edtTimeExecuted.setColumns(10);
		edtTimeExecuted.setEnabled(false);
		listGrid = new java.awt.List();
		listGrid.setBounds(181, 225, 424, 268);
		pnlSubCenter.add(listGrid);
		//----------------------------------------------
		listGrid.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(final java.awt.event.MouseEvent e) {
				/*cleaning textfield except Grid for new search*/
				cleanTextFieldExceptGrid();
				displayValues(aProductList.get(listGrid.getSelectedIndex()));
			}
		});

		JPanel pnlSubNorth = new JPanel();
		pnlCenter.add(pnlSubNorth, BorderLayout.NORTH);
		pnlSubNorth.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		pnlSubNorth.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel pnlWest = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlWest.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(pnlWest, BorderLayout.WEST);

		JPanel panel_2 = new JPanel();
		pnlWest.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_4);

		JLabel lblKeywordSearch = new JLabel("Keyword search : ");
		lblKeywordSearch.setHorizontalAlignment(SwingConstants.LEFT);
		lblKeywordSearch.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblKeywordSearch.setForeground(Color.RED);
		panel_4.add(lblKeywordSearch);

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.add(edtProductName1);
		edtProductName1.setColumns(20);
		//----------------------------------------------
		JButton btnSearchName = new JButton("Submit");
		panel_5.add(btnSearchName);

		btnSearchName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Destroying Grid list for new search*/
				listGrid.removeAll();
				//cleanTextField();
				//======
				name1 = edtProductName1.getText().toUpperCase();
				if(name1.equals("")){
					JOptionPane.showMessageDialog(null, "Keyword cannot be empty!");
				}else{
					if(name1.length()<3){
						JOptionPane.showMessageDialog(null, "Product name must be at least 3 characters long");
					}
					else{
						aProductList = new ArrayList<Product>();

						//get time here
						startRunningTime = new Date();
						//aProductList =
						endRunningTime = new Date();

						if(aProductList.size() > 0){
							displayValues(aProductList.get(0));
							for(int i=0;(i< 20 && i<aProductList.size());++i){
								listGrid.add(aProductList.get(i).getProductName()+" - "+ aProductList.get(i).getProductPack());
								//NORVASC,NEEDLE NOVOFINE,NUROFEN
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Nothin found.");
						}

						edtTimeExecuted.setText(getSearchRunningTime()+"ms");
						//
					}
				}
			}
		});

		JPanel pnlEast = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlEast.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.add(pnlEast, BorderLayout.EAST);

		JPanel panel_3 = new JPanel();
		pnlEast.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_6);

		JLabel lblIdSearch = new JLabel("ID Search : ");
		lblIdSearch.setForeground(Color.RED);
		lblIdSearch.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblIdSearch.setHorizontalAlignment(SwingConstants.LEFT);
		panel_6.add(lblIdSearch);

		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.add(edtProductID);
		edtProductID.setEnabled(true);
		edtProductID.setColumns(20);
		//----------------------------------------------
		JButton btnSearchID = new JButton("Submit");
		panel_7.add(btnSearchID);
		btnSearchID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cleanTextField();
				if(edtProductID.getText().equals("")){
					JOptionPane.showMessageDialog(null, "ID cannot be empty!");
				}
				else{
					id = numericutil.str2Int(edtProductID.getText());
					startRunningTime = new Date();
					Product product = null;
					endRunningTime = new Date();
					if(product != null){
						displayValues(product);
					}
					else{
						JOptionPane.showMessageDialog(null, "Nothin found.");
					}
					edtTimeExecuted.setText(getSearchRunningTime()+"ms");
				}

			}
		});

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
}
