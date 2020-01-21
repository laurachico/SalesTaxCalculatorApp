package datatypes;

import java.util.stream.Stream;
import util.MathUtil;

public class Item {

    private int quantity;
    private String itemName;
    private double baseItemCost;
    private double basicSalesTax;
    private double importedSalesTax;

    public Item(int quantity, String itemName, double baseItemCost) {
        this.quantity = quantity;
        this.itemName = itemName;
        this.baseItemCost = baseItemCost;
    }

    public boolean isImported() {
        return itemName.contains("imported");
    }

    public boolean isExemptedOfBasicSalesTax() {
        return Stream.of("book", "chocolate", "pill")
                .anyMatch(exemptedItem -> itemName.contains(exemptedItem));
    }

    public double getTotalTaxCost() {
        return MathUtil.roundOffTwoDecimals(quantity * (basicSalesTax + importedSalesTax));
    }

    public double getTotalItemCost() {
        return MathUtil.roundOffTwoDecimals((quantity * baseItemCost) + getTotalTaxCost());
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getBaseItemCost() {
        return baseItemCost;
    }

    public void setBaseItemCost(double baseItemCost) {
        this.baseItemCost = baseItemCost;
    }

    public double getBasicSalesTax() {
        return basicSalesTax;
    }

    public void setBasicSalesTax(double basicSalesTax) {
        this.basicSalesTax = basicSalesTax;
    }

    public double getImportedSalesTax() {
        return importedSalesTax;
    }

    public void setImportedSalesTax(double importedSalesTax) {
        this.importedSalesTax = importedSalesTax;
    }

    @Override
    public String toString() {
        return quantity + " " + itemName + " : " + getTotalItemCost();
    }
}
