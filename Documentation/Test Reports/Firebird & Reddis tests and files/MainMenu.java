package com.reroute.main;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

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
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 761, 541);
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		width = 600;
		height = 450;
		frmMenu.setSize(width, height);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnl_North = new JPanel();
		frmMenu.getContentPane().add(pnl_North, BorderLayout.NORTH);

		JMenuItem menuAdd = new JMenuItem("Add Product");
		menuAdd.setEnabled(false);
		menuAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMenu.dispose();
				//AddProduct addproduct = new AddProduct();
				//addproduct.frmAddProduct.setVisible(true);
			}
		});

		JMenuItem menuSearch = new JMenuItem("Search Product");
		menuSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMenu.dispose();
				SearchProduct searchproduct = new SearchProduct();
				searchproduct.frmSearchProduct.setVisible(true);
			}
		});
		pnl_North.add(menuSearch);
		pnl_North.add(menuAdd);

		JMenuItem menuEdit = new JMenuItem("Edit Product");
		menuEdit.setEnabled(false);
		menuEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMenu.dispose();
				//EditProduct editproduct = new EditProduct();
				//editproduct.frmEditProduct.setVisible(true);
			}
		});
		pnl_North.add(menuEdit);

		JMenuItem menuDelete = new JMenuItem("Delete Product");
		menuDelete.setEnabled(false);
		menuDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMenu.dispose();
				//DeleteProduct deleteproduct = new DeleteProduct();
				//deleteproduct.frmDeleteProduct.setVisible(true);
			}
		});
		pnl_North.add(menuDelete);

		JPanel pnl_Center = new JPanel();
		frmMenu.getContentPane().add(pnl_Center, BorderLayout.CENTER);

		JPanel pnl_South = new JPanel();
		frmMenu.getContentPane().add(pnl_South, BorderLayout.SOUTH);

		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMenu.dispose();
				Login login = new Login();
				login.frmLogin.setVisible(true);
			}
		});
		pnl_South.add(btnReturn);
	}

}
