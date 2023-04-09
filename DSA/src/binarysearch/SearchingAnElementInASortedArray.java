package binarysearch;

import java.io.IOException;

class SearchingAnElementInASortedArray {
    static int getInsertPosition(int[] arr, int k) {
        int l = 0;
        int h = arr.length;
        while (l < h) {
            final int mid = l + (h - l) / 2;
            if (arr[mid] >= k) h = mid;
            else l = mid + 1;
        }
        return l;
    }

    static int searchInSorted(int[] arr, int K) {
        return arr[getInsertPosition(arr, K)] != K ? -1 : 1;
    }

    public static void main(String[] args) throws IOException {
        int K = 4;
        int[] arr = new int[]{1, 2, 3, 5, 6};
        System.out.println(searchInSorted(arr, K));
    }
}



