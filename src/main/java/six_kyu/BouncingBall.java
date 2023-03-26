package six_kyu;

// https://www.codewars.com/kata/5544c7a5cb454edb3c000047

public class BouncingBall {
    public static int bouncingBall(double h, double bounce, double window) {
        int times = -1;
        if (bounce <= 0 || bounce >= 1 || window > h || h < 0) {
            return -1;
        }
        double hOfBounce = h;
        while(hOfBounce > window) {
            hOfBounce *= bounce;
            times += 2;
        }
        return times;
    }
}
