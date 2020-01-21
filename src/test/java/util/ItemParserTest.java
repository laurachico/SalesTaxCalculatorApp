package util;

import org.junit.Assert;
import org.junit.Test;

import datatypes.Item;

public class ItemParserTest {

    @Test
    public void itemShouldBeParsed_And_AllItemsFieldsSetCorrectly() {
        String inputItem = "1 imported box of chocolates at 10.00";
        Item parsedItem = ItemParser.parseItem(inputItem);
        Assert.assertEquals("Quantity not parsed correctly", 1, parsedItem.getQuantity());
        Assert.assertEquals("Name not parsed correctly", "imported box of chocolates", parsedItem.getItemName());
        Assert.assertEquals(10.00, parsedItem.getBaseItemCost(), 0.00);
    }

}
