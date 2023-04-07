package binarysearch;

//LC 441
public class ArrangingCoins {

    static public int arrangeCoins(int n) {
//        int l = 0;
//        int h = n;
//        while (l < h) {
//            final int m = l + (h - l) / 2;
//            if (m * (m + 1) / 2 < n)
//                l = m + 1;
//            else
//                h = m - 1;
//        }
//        return l;

        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);

    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(arrangeCoins(n));
    }
}
