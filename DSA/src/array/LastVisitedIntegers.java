package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LastVisitedIntegers {
    public static List<Integer> lastVisitedIntegers(List<String> words) {

        List<Integer> numList = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int prevCount = 0;

        for (String word : words) {
            if (word.equals("prev")) {
                prevCount++;
                if (prevCount > numList.size()) ans.add(-1);
                else ans.add(numList.get(numList.size() - prevCount));
            } else {
                numList.add(Integer.parseInt(word));
                prevCount = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("1", "prev", "2", "prev", "prev");
        System.out.println(lastVisitedIntegers(words));
    }
}