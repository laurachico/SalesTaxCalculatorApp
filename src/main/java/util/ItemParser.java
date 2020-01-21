package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import datatypes.Item;


public class ItemParser {

    private static final String PARSE_REGEX = "(\\d+) ([\\w\\s]*) at (\\d+.\\d{2})";

    public static Item parseItem(String input) {
        Pattern pattern = Pattern.compile(PARSE_REGEX);
        Matcher matcher = pattern.matcher(input);
        matcher.find();

        return new Item(Integer.parseInt(matcher.group(1)), matcher.group(2), Double.parseDouble(matcher.group(3)));
    }
}
