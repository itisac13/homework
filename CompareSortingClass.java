
import java.util.Arrays;
import java.util.Random;
public class CompareSortingClass {
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

        int[] test = RandomizedArray(10000, 0, 100);
        int[] test2 = Arrays.copyOf(test, test.length);

        long start = System.currentTimeMillis();
        bubbleSort(test);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Time elapsed in milliseconds to execute bubble sort:");
        System.out.println(timeElapsed);


        long start2 = System.currentTimeMillis();
        selectionSort(test2);
        long finish2 = System.currentTimeMillis();
        long timeElapsed2 = finish2 - start2;
        System.out.println("Time elapsed in milliseconds to execute selection sort:");
        System.out.println(timeElapsed2);

    }
}
