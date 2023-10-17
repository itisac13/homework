
import java.util.Random;

public class QuickSortAndShellSort {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = low + new Random().nextInt(high - low + 1);
        int pivotValue = arr[pivot];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivotValue);

            do {
                j--;
            } while (arr[j] > pivotValue);

            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void shellSort(int[] arr) {
        int n = arr.length;
        // System.out.println("checkmark1");
        // Generate the gap sequence
        int maxGap = (int) (Math.log(n) / Math.log(2));
        int[] gaps = new int[maxGap];
        for (int i = 0; i < maxGap; i++) {
            gaps[i] = (int) (Math.pow(2, maxGap - i) - 1);
        }
        // System.out.println("checkmark2");

        // Perform Shell Sort using the gap sequence
        for (int gap : gaps) {
            // System.out.println("checkmark3");
            for (int i = gap; i < n; i++) {
                // System.out.println("checkmark4");
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                    // System.out.println("checkmark5");
                }
                arr[j] = temp;
            }
        }
    }

    public static int[] generateRandomArray(int size, int minRange, int maxRange) {
        int[] randomArray = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(maxRange - minRange + 1) + minRange;
        }

        return randomArray;
    }


    public static void main(String[] args) {
        int size = 10000000;
        int minRange = 1;
        int maxRange = 10000000;
        int[] randomArray = generateRandomArray(size, minRange, maxRange);

        int[] quickSortArray = randomArray.clone();
        int[] shellSortArray = randomArray.clone();

        long startTime, endTime;
        long quickSortTime, shellSortTime;

        // Test QuickSort
        startTime = System.currentTimeMillis();
        quickSort(quickSortArray);


        endTime = System.currentTimeMillis();
        quickSortTime = endTime - startTime;
        System.out.println("QuickSort Time: " + quickSortTime + " ms");

        // Test ShellSort
        startTime = System.currentTimeMillis();
        shellSort(shellSortArray);
        endTime = System.currentTimeMillis();
        shellSortTime = endTime - startTime;


        System.out.println("ShellSort Time: " + shellSortTime + " ms");
    }

}
