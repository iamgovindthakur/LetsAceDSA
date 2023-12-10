package array;

class CountTestedDevicesAfterTestOperations {

    static void reduceAllNextIndexValueBy1(int[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++)
            arr[i] = Math.max(0, arr[i] - 1);
    }

    public static int countTestedDevices(int[] batteryPercentages) {
//         O(N)
//        int k = 0;
//        for (int a : A)
//            k += a > k ?  1 : 0;
//        return k;
        int count = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] > 0) {
                count++;
                reduceAllNextIndexValueBy1(batteryPercentages, i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] batteryPercentages = {1, 1, 2, 1, 3};
        System.out.println(countTestedDevices(batteryPercentages));
    }
}