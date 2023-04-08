package binarysearch;

//LC 1608
public class SpecialArrayWithXElementsGreaterThanOrEqualX {

//    static int firstElementGreaterThanN(int[] nums, int n) {
//        int l = 0;
//        int h = nums.length;
//        while (l < h) {
//            final int m = l + (h - l) / 2;
//            if (nums[m] >= n) h = m;
//            else l = m + 1;
//        }
//        return l;
//    }

//    static public int specialArray(int[] nums) {
//        Arrays.sort(nums);
//        int res = -1;
//        for (int i = 0; i < nums.length; i++) {
//            int count = firstElementGreaterThanN(nums, i);
//            if (i == nums.length - count) return count;
//        }
//        return -1;
//    }

    public static int specialArray(int[] nums) {
        int end=nums.length;
        int start=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            int count=0;
            for (int num : nums) {
                if (num >= mid) count++;
            }
            if(count==mid)
                return mid;
            if(count>mid)
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5};
        System.out.println(specialArray(nums));
    }
}
