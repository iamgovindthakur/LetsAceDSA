package binarysearch;

class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length - 1;
        int c = matrix[0].length - 1;
        int l = 0;
        int m = 0;
        while (l <= r && m <= c) {
            if (matrix[l][m] <= target && target <= matrix[l][c]) {
                if (matrix[l][m] == target)
                    return true;
                m++;
            } else
                l++;
        }
        return false;

    }
}