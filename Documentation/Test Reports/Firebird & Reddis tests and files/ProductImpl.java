package com.reroute.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.reroute.tools.DataBaseConnect;
import com.reroute.tools.GetProperties;

public class ProductImpl implements ProductDao {
    private static final String FILE_NAME = "ProductImpl";

    private GetProperties getproperties = new GetProperties();
    private ProductSetAll productsetall = new ProductSetAll();

    private Connection connection = null;



    //
    @Override
    public final List<Product> getProductNameLike(final String pName1,
            final String pName2,final String pName3, final String pName4,
            final String pName5) {

        List<Product> list = new ArrayList<Product>();

        Connection connection = null;

        ResultSet rs = null;


        PreparedStatement pstmt = null;
        try {
            //connection = pDatasource.getConnection();
        	connection = DataBaseConnect.setConnection(getproperties.GetProperty("DATABASE"));

            String sql = getProductNameLikeSql();
            if (connection != null) {
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, "%" + pName1.trim() + "%");
                pstmt.setString(2, "%" + pName2.trim() + "%");
                pstmt.setString(3, "%" + pName3.trim() + "%");
                pstmt.setString(4, "%" + pName4.trim() + "%");
                pstmt.setString(5, "%" + pName5.trim() + "%");

                rs = pstmt.executeQuery();

                while (rs.next()) {
                    list.add(productsetall.setAll(rs));
                } // end if
            } else {
                Throwable ex = new Throwable();
                ex.printStackTrace();
                System.out.println("*****Error getProductContain : " + FILE_NAME);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseConnect.close(rs, pstmt, connection);
        }

        return list;
    }

    // -------------------
    private String getProductNameLikeSql() {

        String sql = "";
        sql += "SELECT * ";
        sql += "FROM PRODUCT c ";
        sql += "WHERE c.PRODUCTNAME LIKE ? ";
        sql += "AND c.PRODUCTNAME LIKE ? ";
        sql += "AND c.PRODUCTNAME LIKE ? ";
        sql += "AND c.PRODUCTNAME LIKE ? ";
        sql += "AND c.PRODUCTNAME LIKE ? ";
        sql += "ORDER BY c.PRODUCTNAME ";
        return sql;
    }

    // -------------------
    @Override
    public final Product getProductName(final String productName) {
        Product product = null;
        PreparedStatement pstmtSelectOnName = null;
        connection = DataBaseConnect
                .setConnection(getproperties.GetProperty("DATABASE"));
        ResultSet rs = null;

        String sql = getProductNameSql();

        if (connection != null) {
            try {
                pstmtSelectOnName = connection.prepareStatement(sql);
                pstmtSelectOnName.setString(1, productName);

                rs = pstmtSelectOnName.executeQuery();

                if (rs.next()) {
                    product = productsetall.setAll(rs);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                DataBaseConnect.close(rs, pstmtSelectOnName, connection);
            }
        } else {
            Throwable ex = new Throwable();
            ex.printStackTrace();
            System.out.println("*****Error Get : " + FILE_NAME);
        }

        return product;
    }

    // -------------------
    private String getProductNameSql() {
        String sql = "";

        sql += " SELECT * FROM PRODUCT WHERE ";
        sql += " PRODUCTNAME = ?";

        return sql;
    }

    // -------------------
    @Override
    public final List<Product> getProductNameStartWith(final String productName) {
    	List<Product> list = null;
        ResultSet rs = null;
        Connection con = null;

        if (!productName.trim().equals("")) {
            PreparedStatement pstmt = null;
            try {
                con = DataBaseConnect
                        .setConnection(getproperties.GetProperty("DATABASE"));

                String sql = getProductNameStartWithSql();

                if (con != null) {
                	list = new ArrayList<Product>();
                    pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, productName.trim() + "%");
                    //pstmt.setString(1, productName);

                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        list.add(productsetall.setAll(rs));
                    }
                } else {
                    Throwable ex = new Throwable();
                    ex.printStackTrace();
                    System.out.println("*****Error Get Product Name : " + FILE_NAME);
                }
            } catch (Exception ex) {
            	ex.printStackTrace();
            	System.out.println("====\n"+productName);
            } finally {
                DataBaseConnect.close(rs, pstmt, con);
            }
        } //
        return list;
    }

    // -------------------
    private String getProductNameStartWithSql() {
        String sql = "";

        sql += " SELECT * FROM PRODUCT WHERE ";
        sql += " PRODUCTNAME LIKE ? ";

        return sql;
    }

    // -------------------
    @Override
    public final Product getProductNameAndPack(final String pProductName,
            final String pPack, final DataSource pDs) {

        Product product = null;
        PreparedStatement pstmt = null;

        ResultSet rs = null;
        Connection con = null;

        String sql = buildSelectOnNameandPackSql();
        try {
            con = pDs.getConnection();

            if (con != null) {

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, pProductName);
                pstmt.setString(2, pPack);

                rs = pstmt.executeQuery();

                if (rs.next()) {
                    product = productsetall.setAll(rs);
                }

            } else {
                Throwable ex = new Throwable();
                ex.printStackTrace();
                System.out.println("*****Error Get NameAndPack : " + FILE_NAME);
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("Product Name :" + pProductName);
        } finally {
            DataBaseConnect.close(rs, pstmt, con);
        }
        return product;
    }
    // -------------------
    public final String buildSelectOnNameandPackSql() {
        String sql = "";

        sql += " SELECT * FROM PRODUCT WHERE ";
        sql += " PRODUCTNAME = ? and PRODUCTPACK = ?";

        return sql;
    }
    // -------------------
    @Override
    public final Product getProductOnId(final int pIdProduct) {
        Product product = null;
        PreparedStatement pstmt = null;
        connection = DataBaseConnect
                .setConnection(getproperties.GetProperty("DATABASE"));
        ResultSet rs = null;

        String sql = getProductOnIdSql();

        if (connection != null) {
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, pIdProduct);

                rs = pstmt.executeQuery();

                if (rs.next()) {
                    product = productsetall.setAll(rs);
                } // end if
                  // stmt.close();
            } catch (Exception ex) {
            	ex.printStackTrace();
            	System.out.println("Product ID :" + pIdProduct);
            } finally {
                DataBaseConnect.close(rs, pstmt, connection);
            }
        } else {
            Throwable ex = new Throwable();
            ex.printStackTrace();
            System.out.println("*****Error Get NameAndPack : " + FILE_NAME);
        }

        return product;
    }

    // -------------------
    @Override
    public final Product getProductOnId(final int pIdProduct, final DataSource pDs) {
        Product product = null;
        ResultSet rs = null;
        Connection con = null;

        if (pIdProduct > 0) {
            PreparedStatement pstmt = null;
            try {
                con = pDs.getConnection();

                String sql = getProductOnIdSql();

                if (con != null) {

                    pstmt = con.prepareStatement(sql);
                    pstmt.setInt(1, pIdProduct);

                    rs = pstmt.executeQuery();

                    if (rs.next()) {
                        product = productsetall.setAll(rs);
                    } // end if
                      // stmt.close();
                } else {
                    Throwable ex = new Throwable();
                    ex.printStackTrace();
                    System.out.println("*****Error Get Barcode : " + FILE_NAME);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                DataBaseConnect.close(rs, pstmt, con);
            }
        } //
        return product;

    }

    // -------------------
    private String getProductOnIdSql() {
        String sql = "";

        sql += " SELECT * FROM PRODUCT WHERE ";
        sql += " IDPRODUCT = ?";

        return sql;
    }
}