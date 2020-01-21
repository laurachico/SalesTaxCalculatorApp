import java.util.List;
import java.util.stream.Collectors;

import datatypes.Item;
import datatypes.Receipt;
import util.ItemParser;
import util.ItemTaxCalculator;


public class SalesTaxApplication {

    public Receipt createOutputReceipt(List<String> itemsBeforeTax) {
        List<Item> items = itemsBeforeTax.stream().map(ItemParser::parseItem).collect(Collectors.toList());
        items.forEach(ItemTaxCalculator::calculateItemTaxesAndTotalPrice);
        return new Receipt(items);
    }

}
