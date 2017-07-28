package cos301.datasource;

import cos301.util.NumericUtil;
import soap.ObjectArray;

public class Product {

    private NumericUtil numericutil = new NumericUtil();

    private int idProduct = 0;
    private String productName = "";
    private String productPack = ""; // PRODUCTPACK
    private String productStrength = "";    // PPRODUCTSTRENGTH
    private String productDescription = "";
    private String productSchedule = "";
    private String dosageForm = "";

    public Product(){
        this.idProduct = 0;
        this.productName = "";
        this.productPack = ""; // PRODUCTPACK
        this.productStrength = "";    // PPRODUCTSTRENGTH
        this.productDescription = "";
        this.productSchedule = "";
        this.dosageForm = "";
    }
    
    public Product(ObjectArray o){
        this.idProduct = o.getContents().get(0) == null ? null : new Integer(o.getContents().get(0).toString());
        this.productName = o.getContents().get(1) == null ? null : o.getContents().get(1).toString();
        this.productPack = o.getContents().get(2) == null ? null : o.getContents().get(2).toString();
        this.productStrength = o.getContents().get(3) == null ? null : o.getContents().get(3).toString();
        this.productDescription = o.getContents().get(4) == null ? null : o.getContents().get(4).toString();
        this.productSchedule = o.getContents().get(5) == null ? null : o.getContents().get(5).toString();
        this.dosageForm = o.getContents().get(6) == null ? null : o.getContents().get(6).toString();
    }
    // ------
    /**
     * @return the idProduct
     */
    public final int getIdProduct() {
        return idProduct;
    }

    /**
     * @param idProduct
     *            the idProduct to set
     */
    public final void setIdProduct(final int pIdProduct) {
        this.idProduct = pIdProduct;
    }

    public final void setIdProduct(final String pIdProduct) {
        this.idProduct = numericutil.str2Int(pIdProduct);
    }


    /**
     * @return the productName
     */
    public final String getProductName() {
        return productName;
    }

    /**
     * @param productName
     *            the productName to set
     */
    public final void setProductName(final String pProductName) {
        this.productName = pProductName;
    }

    public final String getProductPack() {
        return productPack;
    }

    public final void setProductPack(final String pProductPack) {
        this.productPack = pProductPack;
    }

    /**
     * @return the productDescription
     */
    public final String getProductDescription() {
        return productDescription;
    }

    /**
     * @param productDescription
     *            the productDescription to set
     */
    public final void setProductDescription(final String pProductDescription) {
        this.productDescription = pProductDescription;
    }

    /**
     * @return the productSchedule
     */
    public final String getProductSchedule() {
        return productSchedule;
    }

    /**
     * @param productSchedule
     *            the productSchedule to set
     */
    public final void setProductSchedule(final String pProductSchedule) {
        this.productSchedule = pProductSchedule;
    }

    /**
     * @return the dosageForm
     */
    public final String getDosageForm() {
        if (dosageForm == null) {
            dosageForm = "";
        }
        return dosageForm;
    }

    /**
     * @param dosageForm the dosageForm to set
     */
    public final void setDosageForm(final String pDosageForm) {
        this.dosageForm = pDosageForm;
    }

    /**
     * @return the productStrength
     */
    public final String getProductStrength() {
        if (productStrength == null) {
            productStrength = "";
        }
        return productStrength;
    }

    /**
     * @param productStrength the productStrength to set
     */
    public final void setProductStrength(String productStrength) {
        this.productStrength = productStrength;
    }
    
    public @Override String toString(){
        return "( " + getIdProduct() +"," +getProductName() +","+ getProductPack()
                +"," + getProductStrength() +","+ getProductSchedule() +"," + getProductDescription()+ ")";
    }
}
