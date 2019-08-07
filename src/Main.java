import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {

        int[] a = new int[]{
                1, 3, 3, 5, 7, 1, 1, 2
        };
        int[] a1 = new int[]{
                3, 1, 3, 1
        };

        int[] a2 = new int[]{
                1, 3, 4, 2, 2
        };

        int[] a3 = new int[]{
                //4,3,2,7,8,2,3,1
                3, 2, 1, 6, 7, 1, 2, 0
        };

        int[] a4 = new int[]{
                200, 200, 50, -300, -500, -1
        };

        //Solution.getRepetitiveElementsWithCount(a);
        String[] input = new String[] {
          "d", "abd","abc","bdcf", "abc", "abc", "bdcf","abcdf","abd"
        };
        System.out.println(
                Solution.getRepetitiveElementsSort(input)
        );
//        for (Integer i : result) {
//            System.out.println(i);
//        }
    }
}


