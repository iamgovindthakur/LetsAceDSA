package array.slidingWindow;

class NumberOfSubstringsContainingAllThreeCharacters {
    static public int numberOfSubstrings(String s) {
        int[] count = {0, 0, 0};
        int res = 0;
        int i = 0;
        int n = s.length();
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) --count[s.charAt(i++) - 'a'];
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}