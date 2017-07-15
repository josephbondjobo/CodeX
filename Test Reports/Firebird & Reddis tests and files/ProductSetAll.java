package com.reroute.datasource;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSetAll {

    // ------------------------------------
    public final Product setAll(final ResultSet pRs) {
        Product product = new Product();
        try {
            product.setIdProduct(pRs.getInt("IDPRODUCT"));
            product.setProductName(pRs.getString("PRODUCTNAME"));
            product.setProductPack(pRs.getString("PRODUCTPACK"));
            product.setProductDescription(pRs.getString("PRODUCTDESCRIPTION"));
            product.setProductSchedule(pRs.getString("PRODUCTSCHEDULE"));
            product.setProductStrength(pRs.getString("PRODUCTSTRENGTH"));
            product.setDosageForm(pRs.getString("DOSAGEFORM"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }
}
