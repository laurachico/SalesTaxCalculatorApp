import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import datatypes.Receipt;

public class SalesTaxApplicationTest {

    SalesTaxApplication salesTaxApplication = new SalesTaxApplication();

    @Test
    public void givenInputReceipt1_shouldGenerateExpectedGivenOutputReceipt1() {
        List<String> inputReceipt1 = new ArrayList();
        inputReceipt1.add("1 book at 12.49");
        inputReceipt1.add("1 music CD at 14.99");
        inputReceipt1.add("1 chocolate bar at 0.85");

        Receipt outputReceipt = salesTaxApplication.createOutputReceipt(inputReceipt1);
        Assert.assertEquals(1.50, outputReceipt.getTotalSalesTaxes(), 0.00);
        Assert.assertEquals(29.83, outputReceipt.getTotalReceiptAmount(), 0.00);

        String expectedReceipt = "Receipt\n" +
                "1 book : 12.49\n" +
                "1 music CD : 16.49\n" +
                "1 chocolate bar : 0.85\n" +
                "Sales Taxes: 1.5\n" +
                "Total: 29.83";
        Assert.assertEquals("Receipt is incorrect: ", expectedReceipt, outputReceipt.toString());
    }

    @Test
    public void givenInputReceipt2_shouldGenerateExpectedGivenOutputReceipt2() {
        List<String> inputReceipt2 = new ArrayList<>();
        inputReceipt2.add("1 imported box of chocolates at 10.00");
        inputReceipt2.add("1 imported bottle of perfume at 47.50");

        Receipt outputReceipt = salesTaxApplication.createOutputReceipt(inputReceipt2);
        Assert.assertEquals(7.65, outputReceipt.getTotalSalesTaxes(), 0.00);
        Assert.assertEquals(65.15, outputReceipt.getTotalReceiptAmount(), 0.00);

        String expectedReceipt = "Receipt\n" +
                "1 imported box of chocolates : 10.5\n" +
                "1 imported bottle of perfume : 54.65\n" +
                "Sales Taxes: 7.65\n" +
                "Total: 65.15";
        Assert.assertEquals("Receipt is incorrect: ", expectedReceipt, outputReceipt.toString());
    }

    @Test
    public void givenInputReceipt3_shouldGenerateExpectedGivenOutputReceipt3() {
        List<String> inputReceipt3 = new ArrayList<>();
        inputReceipt3.add("1 imported bottle of perfume at 27.99");
        inputReceipt3.add("1 bottle of perfume at 18.99");
        inputReceipt3.add("1 packet of headache pills at 9.75");
        inputReceipt3.add("1 box of imported chocolates at 11.25");

        Receipt outputReceipt = salesTaxApplication.createOutputReceipt(inputReceipt3);
        Assert.assertEquals(6.70, outputReceipt.getTotalSalesTaxes(), 0.00);
        Assert.assertEquals(74.68, outputReceipt.getTotalReceiptAmount(), 0.00);

        String expectedReceipt = "Receipt\n" +
                "1 imported bottle of perfume : 32.19\n" +
                "1 bottle of perfume : 20.89\n" +
                "1 packet of headache pills : 9.75\n" +
                "1 box of imported chocolates : 11.85\n" +
                "Sales Taxes: 6.7\n" +
                "Total: 74.68";
        Assert.assertEquals("Receipt is incorrect: ", expectedReceipt, outputReceipt.toString());
    }
}
