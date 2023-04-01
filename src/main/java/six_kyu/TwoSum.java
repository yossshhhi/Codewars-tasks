package six_kyu;

// https://www.codewars.com/kata/52c31f8e6605bcc646000082

public class TwoSum {

    public static int[] twoSum(int[] numbers, int target)
    {
        int[] indexes = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    indexes[0] = i;
                    indexes[1] = j;
                }
            }
        }
        return indexes;
    }
}
