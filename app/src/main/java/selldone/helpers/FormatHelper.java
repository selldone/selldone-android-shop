package selldone.helpers;

import com.redmadrobot.inputmask.helper.Mask;
import com.redmadrobot.inputmask.model.CaretString;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class FormatHelper {
    private static final NavigableMap<Long, String> suffixes = new TreeMap<>();
    public static DecimalFormat AmountNumberFormat = new DecimalFormat("#,###.########");
    public static DecimalFormat AmountNumberFormat_RIAL = new DecimalFormat("#,###");
    public static DecimalFormat AmountNumberFormat_PERCENT = new DecimalFormat("#,###.##");

    static {
        suffixes.put(1_000L, "k");
        suffixes.put(1_000_000L, "M");
        suffixes.put(1_000_000_000L, "G");
        suffixes.put(1_000_000_000_000L, "T");
        suffixes.put(1_000_000_000_000_000L, "P");
        suffixes.put(1_000_000_000_000_000_000L, "E");
    }

    public static String FormatNumber(double amount) {
        return FormatHelper.AmountNumberFormat.format(amount);
    }


    public static String FormatNumber_Rial(double amount) {
        return FormatHelper.AmountNumberFormat_RIAL.format(amount);
    }

    public static String FormatNumber_Percent(double amount) {
        return FormatHelper.AmountNumberFormat_PERCENT.format(amount);
    }

    public static String FormatCard(String card_number, int index) {
        return card_number.substring(index * 4, index * 4 + 4);
    }

    public static String FormatCard(String card_number) {
        if (card_number == null) return null;

        final Mask mask = new Mask("[9999]{ - }[9999]{ - }[9999]{ - }[9999]");

        final Mask.Result result = mask.apply(
                new CaretString(
                        card_number,
                        card_number.length()
                ),
                true // you may consider disabling autocompletion for your case
        );
        return result.getFormattedText().getString();


    }

    public static String FormatReceipt(String receipt_number) {
        if (receipt_number == null) return null;
        final Mask mask = new Mask("[9999]{ / }[9999]{ / }[9999]");

        final Mask.Result result = mask.apply(
                new CaretString(
                        receipt_number,
                        receipt_number.length()
                ),
                true // you may consider disabling autocompletion for your case
        );
        return result.getFormattedText().getString();


    }


    public static String BigNumberFormat(long value) {
        //Long.MIN_VALUE == -Long.MIN_VALUE so we need an adjustment here
        if (value == Long.MIN_VALUE) return BigNumberFormat(Long.MIN_VALUE + 1);
        if (value < 0) return "-" + BigNumberFormat(-value);
        if (value < 1000) return Long.toString(value); //deal with easy case

        Map.Entry<Long, String> e = suffixes.floorEntry(value);
        Long divideBy = e.getKey();
        String suffix = e.getValue();

        long truncated = value / (divideBy / 10); //the number part of the output times 10
        boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
        return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
    }


}
