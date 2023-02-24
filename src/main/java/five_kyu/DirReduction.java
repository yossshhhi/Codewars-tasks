package five_kyu;

import java.util.*;

/**  Task
*    Write a function dirReduc which will take an array of strings and returns an array
*    of strings with the needless directions removed (W<->E or S<->N side by side).
*    Notes
*    Not all paths can be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible.
*    "NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite of each other and can't become such.
*    Hence, the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].
*/
public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        List<String> array = new ArrayList<>(Arrays.stream(arr).toList());
        for (int i = 0; i < array.size() - 1; i++) {
            if ((array.get(i).equals("NORTH") && array.get(i + 1).equals("SOUTH"))
                    || (array.get(i).equals("SOUTH") && array.get(i + 1).equals("NORTH"))) {
                array.remove(i);
                array.remove(i);
                i = -1;
            } else if ((array.get(i).equals("WEST") && array.get(i + 1).equals("EAST"))
                    || (array.get(i).equals("EAST") && array.get(i + 1).equals("WEST"))) {
                array.remove(i);
                array.remove(i);
                i = -1;
            }
        }
        return array.stream().filter(Objects::nonNull).toArray(String[]::new);
    }

    public static void main(String[] args) {
        Arrays.stream(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}))
                .forEach(System.out::println);
        System.out.println();
        Arrays.stream(dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}))
                .forEach(System.out::println);
    }
}
