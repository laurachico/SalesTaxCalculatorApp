package util;

public class MathUtil {

    public static double roundOffTwoDecimals(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    public static double roundOffToMultipleOf5Percent(double number){
        return Math.ceil(number * 20) / 20.0; // round up to multiple of 0.05
    }
}
