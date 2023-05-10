package five_kyu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.codewars.com/kata/5279f6fe5ab7f447890006a7/java
public class PickPeaks {
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> peaks = new HashMap<>();
        List<Integer> listPos = new ArrayList<>();
        List<Integer> listPeaks = new ArrayList<>();
        peaks.put("pos", listPos);
        peaks.put("peaks", listPeaks);

        int peak = 0;
        int pos = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i]) {
                peak = arr[i];
                pos = i;
                if (peak > arr[i + 1]) {
                    listPos.add(pos);
                    listPeaks.add(peak);
                } else if (arr[i] == arr[i + 1]) {
                   while (i < arr.length - 2 && arr[i] == arr[i + 1]) {
                       i++;
                   }
                   if (peak > arr[i + 1]) {
                       listPos.add(pos);
                       listPeaks.add(peak);
                   }
                }
            }
            
        }
        
        return peaks;
    }
}
