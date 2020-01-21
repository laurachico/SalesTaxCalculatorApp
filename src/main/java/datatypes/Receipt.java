package datatypes;

import java.util.List;

import static util.MathUtil.roundOffTwoDecimals;

public class Receipt {

    private String purchaseItems;
    private double totalTaxesAmount = 0.00;
    private double totalReceiptAmount = 0.00;

    public Receipt(List<Item> purchaseItems) {

        StringBuilder itemsList = new StringBuilder();
        for (Item purchaseItem : purchaseItems) {
            totalTaxesAmount = totalTaxesAmount + purchaseItem.getTotalTaxCost();
            totalReceiptAmount = totalReceiptAmount + purchaseItem.getTotalItemCost();
            itemsList.append(purchaseItem.toString()).append("\n");
        }
        totalTaxesAmount = roundOffTwoDecimals(totalTaxesAmount);
        totalReceiptAmount = roundOffTwoDecimals(totalReceiptAmount);
        this.purchaseItems = itemsList.toString();
    }

    public double getTotalSalesTaxes() {
        return totalTaxesAmount;
    }

    public double getTotalReceiptAmount() {
        return totalReceiptAmount;
    }

    @Override
    public String toString() {
        return "Receipt" + "\n"
                + purchaseItems
                + "Sales Taxes: " + totalTaxesAmount + "\n"
                + "Total: " + totalReceiptAmount;
    }
}
