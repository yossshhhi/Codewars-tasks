package five_kyu;

import java.util.Arrays;

public class IPAddress {
    public static String longToIP(long ip) {
        StringBuilder s = new StringBuilder(Long.toBinaryString(ip));
        while (s.length() < 32) {
            s.insert(0, "0");
        }
        String[] array = {s.substring(0, 8), s.substring(8, 16), s.substring(16, 24), s.substring(24, 32)};
        return Arrays.stream(array).map(n -> Integer.parseInt(n, 2)).map(String::valueOf)
                .reduce("", (string1, string2) -> string1 + "." + string2).substring(1);
    }

    public static void main(String[] args) {
        System.out.println(longToIP(2154959208L));
        System.out.println(longToIP(32));
        System.out.println(longToIP(2149583361L));
    }
}
