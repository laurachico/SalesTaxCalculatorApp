package util;

import datatypes.Item;

import static util.MathUtil.roundOffToMultipleOf5Percent;
import static util.MathUtil.roundOffTwoDecimals;

public class ItemTaxCalculator {

    private static final double BASIC_SALES_TAX_PERCENT = 0.1;
    private static final double IMPORT_DUTY_TAX_PERCENT = 0.05;

    public static void calculateItemTaxesAndTotalPrice(Item item) {

        if (!item.isExemptedOfBasicSalesTax()) {
            item.setBasicSalesTax(roundOffTwoDecimals(BASIC_SALES_TAX_PERCENT * item.getBaseItemCost()));
        }
        if (item.isImported()) {
            item.setImportedSalesTax(roundOffToMultipleOf5Percent(IMPORT_DUTY_TAX_PERCENT * item.getBaseItemCost()));
        }
    }
}
