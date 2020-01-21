package util;

import org.junit.Assert;
import org.junit.Test;

import datatypes.Item;

public class ItemTaxCalculatorTest {

    @Test
    public void foodItem_ShouldBeExemptedOfBasicSalesTax() {
        Item chocolateItem = new Item(1, "chocolate bar", 0.85);
        ItemTaxCalculator.calculateItemTaxesAndTotalPrice(chocolateItem);
        Assert.assertEquals(0.00, chocolateItem.getTotalTaxCost(), 0.00);
        Assert.assertEquals(0.85, chocolateItem.getTotalItemCost(), 0.00);
    }

    @Test
    public void bookItem_ShouldBeExemptedOfBasicSalesTax() {
        Item bookItem = new Item(1, "book", 12.49);
        ItemTaxCalculator.calculateItemTaxesAndTotalPrice(bookItem);
        Assert.assertEquals(12.49, bookItem.getTotalItemCost(), 0.00);
    }

    @Test
    public void medicalProductItem_ShouldBeExemptedOfBasicSalesTax() {
        Item medicalItem = new Item(1, "headache pills", 9.75);
        ItemTaxCalculator.calculateItemTaxesAndTotalPrice(medicalItem);
        Assert.assertEquals(9.75, medicalItem.getTotalItemCost(), 0.00);
    }

    @Test
    public void importedButExemptedOfBasicSalesItem_ShouldOnlyHaveImportedSalesTax() {
        Item importedChocolateItem = new Item(1, "imported box of chocolates", 10.00);
        ItemTaxCalculator.calculateItemTaxesAndTotalPrice(importedChocolateItem);
        Assert.assertEquals(0.50, importedChocolateItem.getImportedSalesTax(), 0.00);
        Assert.assertEquals(0.50, importedChocolateItem.getTotalTaxCost(), 0.00);
        Assert.assertEquals(10.50, importedChocolateItem.getTotalItemCost(), 0.00);
    }

    @Test
    public void importedAndNoExemptedOfBasicSalesItem_ShouldOnlyHaveImportedSalesTax() {
        Item importedChocolateItem = new Item(1, "imported box of chocolates", 10.00);
        ItemTaxCalculator.calculateItemTaxesAndTotalPrice(importedChocolateItem);
        Assert.assertEquals(0.50, importedChocolateItem.getImportedSalesTax(), 0.00);
        Assert.assertEquals(0.50, importedChocolateItem.getTotalTaxCost(), 0.00);
        Assert.assertEquals(10.50, importedChocolateItem.getTotalItemCost(), 0.00);
    }
}
