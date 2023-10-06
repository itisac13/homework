
import java.util.Arrays;
import java.util.Random;
public class CompareSortingClassWithInsertion {
    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();

        return random.nextInt(max - min + 1) + min;
    }

    public static void bubbleSort(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length - (i + 1); j++)
            {
                int current = arr[j];
                int next = arr[j+1];

                if (current > next)
                {
                    // swap
                    arr[j] = next;
                    arr[j + 1] = current;
                }
            }
        }

    }


    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public static int[] RandomizedArray(int size, int start, int end)
    {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = generateRandomNumber(start, end);
        }

        return arr;

    }
    public static void main(String[] args)
    {

        int arrayLength = 10000;

        int[] randomArray1 = RandomizedArray(arrayLength, 0, 100);
        int[] randomArray2 = Arrays.copyOf(randomArray1, arrayLength);
        int[] randomArray3 = Arrays.copyOf(randomArray1, arrayLength);

        long startTime, endTime, elapsedTime;
        
        startTime = System.currentTimeMillis();
        insertionSort(randomArray1);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Insertion Sort took " + elapsedTime + " milliseconds to complete with " + arrayLength + " number of elements");

        startTime = System.currentTimeMillis();
        selectionSort(randomArray2);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Selection Sort took " + elapsedTime + " milliseconds to complete with " + arrayLength + " number of elements");

        startTime = System.currentTimeMillis();
        bubbleSort(randomArray3);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Bubble Sort took " + elapsedTime + " milliseconds to complete with " + arrayLength + " number of elements");


    }
}
