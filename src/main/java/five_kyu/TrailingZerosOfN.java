package five_kyu;

// https://www.codewars.com/kata/52f787eb172a8b4ae1000a34/java

public class TrailingZerosOfN {
    public static int zeros(int n) {
        int result = 0;
        while (n > 1){
            result += n / 5;
            n = n / 5;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(zeros(1000)); // 249
        System.out.println(zeros(0)); // 0
        System.out.println(zeros(6)); // 1
        System.out.println(zeros(14)); // 2
    }
}
