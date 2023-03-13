package five_kyu;

public class RGBToHex {
    public static String rgb(int r, int g, int b) {
        return String.format("%02X%02X%02X", rangeValid(r), rangeValid(g), rangeValid(b));
    }

    public static void main(String[] args) {
        System.out.println(rgb(0, 0, 0));
        System.out.println(rgb(255, 255, 256));
        System.out.println(rgb(254, 253, 252));
        System.out.println(rgb(-20, 275, 125));
    }

    public static int rangeValid(int i) {
        if (i < 0) {
            return 0;
        } else if (i > 255) {
            return 255;
        }
        return i;
    }
}
