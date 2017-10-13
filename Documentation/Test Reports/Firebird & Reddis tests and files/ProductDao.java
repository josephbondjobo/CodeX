package com.reroute.datasource;

import java.util.List;

import javax.sql.DataSource;

public interface ProductDao {
    Product getProductNameAndPack(String pProductName, String pPack,
            DataSource pDs);

    List<Product> getProductNameLike(String pName1, String pName2,
            String pName3, String pName4, String pName5);

	Product getProductName(String productName);

	Product getProductOnId(int pIdProduct);

	Product getProductOnId(int pIdProduct, DataSource pDs);

	List<Product> getProductNameStartWith(String productName);
}
