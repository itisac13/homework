public class MatrixSearchClass {
    public static int[] MatrixSearch(int[][] matrix, int target) {
        int num_rows = matrix.length;
        int num_cols = matrix[0].length;
        int left = 0;
        int right = num_rows * num_cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / num_cols][mid % num_cols];

            if (midValue == target) {
                return new int[]{mid / num_cols, mid % num_cols};
            } else if (midValue < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }

        return new int[]{-1, -1}; // not found
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 4;
        int[] result = MatrixSearch(arr, target);

        if (result[0] != -1 && result[1] != -1) {
            System.out.println("Found at: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("Found");
        }
    }
}
