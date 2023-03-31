package six_kyu;

// https://www.codewars.com/kata/5503013e34137eeeaa001648

public class Diamond {

    public static String print(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int space = n / 2;
        int star = 1;
        if (n > 0 && n % 2 != 0) {
            for (int i = 1; i <= n / 2 + 1; i++) {
                for (int j = 1; j <= space; j++) {
                    stringBuilder.append(" ");
                }
                space--;
                for (int j = 1; j <= star; j++) {
                    stringBuilder.append("*");
                }
                star += 2;
                stringBuilder.append("\n");
            }
            space++;
            star -= 2;
            for (int i = 1; i <= n / 2; i++) {
                space++;
                for (int j = 1; j <= space; j++) {
                    stringBuilder.append(" ");
                }
                star -= 2;
                for (int j = 1; j <= star; j++) {
                    stringBuilder.append("*");
                }
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
        return null;
    }
}
