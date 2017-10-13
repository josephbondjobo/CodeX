package cos301.datasource;

import cos301.util.NumericUtil;

public class StockItem {

    private NumericUtil numericutil = new NumericUtil();
    // private DateUtil dateutil = new DateUtil();

    private int idStockItem = 0;
    private int idProduct = 0;
    private int idSupplier = 0;
    private String stockItemProdNo = "";
    private String stockItemName = "";

    // --------------------------
    public final void initialize() {
        idStockItem = 0;
        idProduct = 0;
        idSupplier = 0;
        stockItemProdNo = "";
        stockItemName = "";
    }

    // ---------------------------------------------------------------------
    /**
     * @return the idStockItem
     */
    public final int getIdStockItem() {
        return idStockItem;
    }

    /**
     * @param idStockItem
     *            the idStockItem to set
     */
    public final void setIdStockItem(final int idStockItem) {
        this.idStockItem = idStockItem;
    }

    public final void setIdStockItem(final String idStockItem) {
        this.idStockItem = numericutil.str2Int(idStockItem);
    }

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
    public final void setIdProduct(final int idProduct) {
        this.idProduct = idProduct;
    }

    public final void setIdProduct(final String idProduct) {
        this.idProduct = numericutil.str2Int(idProduct);
    }

    /**
     * @return the idSupplier
     */
    public final int getIdSupplier() {
        return idSupplier;
    }

    /**
     * @param idSupplier
     *            the idSupplier to set
     */
    public final void setIdSupplier(final int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public final void setIdSupplier(final String idSupplier) {
        this.idSupplier = numericutil.str2Int(idSupplier);
    }

    /**
     * @return the stockItemProdNo
     */
    public final String getStockItemProdNo() {
        return stockItemProdNo;
    }

    /**
     * @param stockItemProdNo
     *            the stockItemProdNo to set
     */
    public final void setStockItemProdNo(final String stockItemProdNo) {
        this.stockItemProdNo = stockItemProdNo;
    }

    /**
     * @return the stockItemName
     */
    public final String getStockItemName() {
        return stockItemName;
    }

    /**
     * @param stockItemName
     *            the stockItemName to set
     */
    public final void setStockItemName(final String stockItemName) {
        this.stockItemName = stockItemName;
    }
}
