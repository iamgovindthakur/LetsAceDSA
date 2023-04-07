package Array;

/**
 * Forward declaration of guess API.
 *
 * @param num your guess
 * @return -1 if num is higher than the picked number
 * 1 if num is lower than the picked number
 * otherwise return 0
 * int guess(int num);
 */

public class GuessNumberHigherOrLower {

    static int pick = 6;

    public static int guess(int num) {
        return pick < num ? -1 : pick > num ? 1 : 0;
    }

    public static int guessNumber(int n) {
        int l = 1;
        int h = n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            int index = guess(mid);
            if (index == 0) return mid;
            else if (index == -1) h = mid - 1;
            else l = mid + 1;
        }
        return -1;

    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(guessNumber(n));
    }
}