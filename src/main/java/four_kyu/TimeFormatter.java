package four_kyu;

// https://www.codewars.com/kata/52742f58faf5485cae000b9a/java
public class TimeFormatter {
    public static String formatDuration(int seconds) {
        if (seconds == 0)
            return "now";
        int year = seconds / (365 * (24 * 3600));
        int day = seconds / (24 * 3600) % 365;
        int hour = seconds % (24 * 3600) / 3600;
        int minute = seconds % 3600 / 60;
        int second = seconds % 60;

        String result = (year > 0 ? String.format("%d %s, ", year, year == 1 ? "year" : "years") : "") +
                (day > 0 ? String.format("%d %s, ", day, day == 1 ? "day" : "days") : "") +
                (hour > 0 ? String.format("%d %s, ", hour, hour == 1 ? "hour" : "hours") : "") +
                (minute > 0 ? String.format("%d %s, ", minute, minute == 1 ? "minute" : "minutes") : "") +
                (second > 0 ? String.format("%d %s, ", second, second == 1 ? "second" : "seconds") : "");
        result = result.replaceFirst("\\,\\s$", "");

        String beforeAnd = result.replaceFirst("\\,\\s\\d{1,2}\\s\\w{3,7}$", "") + " and";
        String afterAnd = result.replaceFirst("^.+\\,", "");
        return result.matches("^.+\\,.+") ? beforeAnd + afterAnd : result;
    }
}
