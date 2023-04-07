package binarysearch;

class ValidPerfectSquare {
    static public boolean isPerfectSquare(int num) {
        int l = 1;
        int h = num;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (mid * mid == num)
                return true;
            else if (mid < num / mid)
                l = mid + 1;
            else
                h = mid - 1;

        }
        return false;
    }

    public static void main(String[] args) {
        int num=17;
        System.out.println(isPerfectSquare(num));
    }
}

