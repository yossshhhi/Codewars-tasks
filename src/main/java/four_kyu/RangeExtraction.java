package four_kyu;

import java.util.ArrayList;
import java.util.List;

public class RangeExtraction {
    public static String rangeExtraction(int[] arr) {
        String result = "";
        List<Integer> seq = new ArrayList<>();
        seq.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 == arr[i]) {
                if (seq.size() == 0)
                    seq.add(arr[i - 1]);
                seq.add(arr[i]);
            } else {
                if (seq.isEmpty())
                        result += arr[i - 1] + ",";
            }

            if (arr[i - 1] + 1 != arr[i]) {
                result = seqRecord(seq, result);
            }
        }

        if (seq.size() > 0) {
            result = seqRecord(seq, result);
        }
        if (!result.endsWith(arr[arr.length -1] + ",")) {
            result += arr[arr.length -1] + ",";
        }
        return result.substring(0, result.length() - 1);
    }

    public static String seqRecord(List<Integer> seq, String result) {
        if (seq.size() > 2) {
            result += seq.get(0) + "-" + seq.get(seq.size() - 1) + ",";
            seq.clear();
        } else if (seq.size() == 2) {
            result += seq.get(0) + "," + seq.get(1) + ",";
            seq.clear();
        } else if (seq.size() == 1){
            result += seq.get(0) + ",";
            seq.clear();
        }
        return result;
    }
}
