import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

//        [ 0,1, 2, 3, 4, 5, 6, 7]  n = 8,  1-7 (7numbers)
//        [ 1,3, 3, 5, 7, 1, 1, 2]
    /*
    * O(n) run-time
    * */
    public static List<Integer> getRepetitiveElements(int[] array) {
        if (array == null) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();
        int toVisit;
        int nextStep;

        // for loop to iterate through array
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 0) { // duplicate or visited, no point to handle it anymore
                continue;
                // 0 for duplicate
                // -1 for visited
                // if ith index <-> number i has been visited, we can just skip this entry

            } else {
                // ith index <-> number i is not visited
                // so read the value of array[i]
                toVisit = array[i]; // starting from unexplored i index value
                // this logic keep exploring til reaching a visited one
                while(array[toVisit] > 0) {
                    nextStep = array[toVisit]; // record nextPos
                    array[toVisit] = -1; // mark curPos as visited
                    // update curPos
                    toVisit = nextStep;
                }

                // array[toVisit] either -1 or 0
                // -1: meaning visited before
                // 0: not only visited, but duplicate found already
                if (array[toVisit] != 0) {
                    array[toVisit] = 0; // mark once
                    result.add(toVisit);
                }
            }
        }

        return result;
    }

    /*
     * O(n*k) run-time where k means the maximum list of different strings mapping to same index
     *
     * Another solution would be sort the strings and do in-replace comparison to find matching strings
     * O(n*logn) for sorting, and assuming the string comparison takes O(1) constant amount of time.
     *
     * */
    public static List<String> getRepetitiveElements(String[] array)
    {
        if (array == null) return null;

        // variable -> each index maps to a linkedlist containing the values
        List<Integer>[] hashMap = new ArrayList[array.length];
        List<String> duplicateSet = new ArrayList<>();
        int index;
        int n = array.length;
        String curString;
        for (int i = 0; i < array.length; i++) {
            curString = array[i];
            index = curString.hashCode()%n;
            if (hashMap[index] == null) {
                hashMap[index]=new ArrayList<>(); // store the i index
                hashMap[index].add(i); // put in i within the arrayList
            } else { // index is not null
                List<Integer> matchingIndice = hashMap[index];
                boolean hit = false;
                for (Integer mi: matchingIndice) {
                    if (array[mi].compareTo(curString)==0) {
                        // collision, and the string matches, we are happy
                        if (!duplicateSet.contains(curString)) { // this is O(m) where m is # of duplicate strings in the set
                            duplicateSet.add(curString);// found duplicate string
                        }
                        hit = true;
                        break; // exit -> found a match
                    }
                }
                if (!hit) {
                    matchingIndice.add(i); // put i into the linkedlist
                    hashMap[index] = matchingIndice;
                }
            }
        }

        return duplicateSet;
    }

    //Sort algorithm
    public static List<String> getRepetitiveElementsSort(String[] array)
    {
        if (array == null) return null;
        Arrays.sort(array,(a, b)-> (a.hashCode()-b.hashCode()));

        List<String> duplicateSet = new ArrayList<>();
        int startIndex = 0;
        // O(n)
        while (startIndex < array.length) {
            while (startIndex+1 < array.length && array[startIndex] == array[startIndex+1]){
                startIndex++;
            }
            if (startIndex-1 >= 0 && array[startIndex-1] == array[startIndex]) {
                duplicateSet.add(array[startIndex]);
            }
            startIndex++;
        }
        return duplicateSet;

    }


// if the numbers are not bounded to 1->n-1 .  (negatives)
// --> sort numbers nlogn and do in-place search
    /*
    * O(n*logn)
    * */
    public List<Integer> getRepetitiveElementsUnBounded(int[] array) {
        if (array== null) return null;

        List<Integer> result = new ArrayList<>();
        Arrays.sort(array); // complexity: O(nlogn)

        int startIndex = 0;
        // O(n)
        while (startIndex < array.length) {
            while (startIndex+1 < array.length && array[startIndex] == array[startIndex+1]){
                startIndex++;
            }
            if (startIndex-1 >= 0 && array[startIndex-1] == array[startIndex]) {
                result.add(array[startIndex]);
            }
            startIndex++;
        }
        return result;
    }
}
