package coding.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class FindingPairs {

    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1,5,3,4,2,-1,-4,-1,4);
        int k = 3;
       // getTotalCountOfPair(numList, k);
        //printAllCountPairIfNumbersAreDistinct(numList,k);
        printAllCountPairIfNumbersAreNotDistinct(numList, k);
    }

    private static void printAllCountPairIfNumbersAreNotDistinct(List<Integer> numList, int k) {
        HashMap<Integer, Integer> hashs = new HashMap<>();

        for (int i = 0; i < numList.size(); i++) {
            int t = k - numList.get(i);
            if (hashs.containsKey(t)) {
                int count = hashs.get(t);
                for (int j = 0; j < count; j++)
                    System.out.print("(" + t + ", " + numList.get(i) +")" + "\n");
            }
            if (hashs.containsKey(numList.get(i))) {
                hashs.put(numList.get(i), hashs.get(numList.get(i) + 1));
            } else {
                hashs.put(numList.get(i), 1);
            }
        }
    }

    private static void printAllCountPairIfNumbersAreDistinct(List<Integer> numList, int k) {
        numList = Arrays.asList(1,5,3,4,2,-1,-4);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numList.size(); i++) {
            if(set.contains(k - numList.get(i))) {
                System.out.println(numList.get(i) + " " + (k - numList.get(i)));
            }
            set.add(numList.get(i));
        }

    }

    private static void getTotalCountOfPair(List<Integer> numList, int k) {
        Map<Integer, Boolean> numMap = new HashMap<>();
        for (Integer integer : numList) {
            numMap.put(integer, true);
        }

        int count = 0;
        for (Integer i : numList) {
            if(Objects.nonNull(numMap.get(i-k))) {
                count++;
            } else if(Objects.nonNull(numMap.get(i+k))){
                count++;
            }
        }
        System.out.println("Total count: " + count/2);
    }
}
