package Assignment1;

import java.util.HashMap;
import java.util.Map;

public class sortTiming {

    private static Map<String, Integer> sortMap = new HashMap<>();
    private static int[][][] cases;

    static {
        sortMap.put("Bubble", 0);
        sortMap.put("Selection", 1);
        sortMap.put("Insertion", 2);
        sortMap.put("Merge", 3);
        sortMap.put("Quick", 4);
        sortMap.put("Radix", 5);
    }

    public static void main(String[] args) {

        int[][] randomArrs = new int[22][];

        /*
         * I think I figured out the math on this loop. I'm not
         * really sure what I was trying to achieve with my original math here. After I
         * wrote it down and wasted an embarassing amount of scrap paper I got it
         * figured out. I knew what I needed to do code wise, I just got caught on the
         * math. I'm admittedly pretty bad at math.
         */
        for (int i = 0; i < randomArrs.length; i++) {

            if (i < 4) {
                randomArrs[i] = randomArrs(1000, (int) Math.pow(10, i + 1));
            } else if (i >= 4) {
                randomArrs[i] = randomArrs(1000, ((i - 2) * 10000));
            }

        }

        // copying the arrays for each sort function
        int[][] randomArrs1 = new int[randomArrs.length][];
        int[][] randomArrs2 = new int[randomArrs.length][];
        int[][] randomArrs3 = new int[randomArrs.length][];
        int[][] randomArrs4 = new int[randomArrs.length][];
        int[][] randomArrs5 = new int[randomArrs.length][];

        for (int i = 0; i < randomArrs.length; i++) {
            randomArrs1[i] = copyArray(randomArrs[i]);
            randomArrs2[i] = copyArray(randomArrs[i]);
            randomArrs3[i] = copyArray(randomArrs[i]);
            randomArrs4[i] = copyArray(randomArrs[i]);
            randomArrs5[i] = copyArray(randomArrs[i]);
        }

        int maxIterations = randomArrs.length;

        initializeCases(maxIterations);

        // invoke the sorts
        for (int i = 0; i < randomArrs.length; i++) {
            bubble(randomArrs[i], i + 1, randomArrs.length);
        }
        for (int i = 0; i < randomArrs1.length; i++) {
            selection(randomArrs1[i], i + 1, randomArrs1.length);
        }
        for (int i = 0; i < randomArrs2.length; i++) {
            merge(randomArrs2[i], i + 1, randomArrs2.length);
        }
        for (int i = 0; i < randomArrs3.length; i++) {
            radix(randomArrs3[i], i + 1, randomArrs3.length);
        }
    }

    public static void printArray(int[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }

        System.out.println(array[array.length - 1] + "]");
    }

    // random array generation
    private static int[] randomArrs(int max, int length) {

        int[] new_list = new int[length];

        for (int i = 0; i < new_list.length; i++) {
            new_list[i] = (int) (Math.random() * max);
        }

        return new_list;
    }

    // Swap function for sorts
    private static void swap(int left, int right, int arr[]) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    // copy array
    public static int[] copyArray(int[] array) {

        int[] new_array = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            new_array[i] = array[i];
        }

        return new_array;
    }

    /*
     * This is way overkill for this assignment, but I mostly wanted to do it to
     * challenge myself. This uses a map to store the information related to the
     * sorts in a 3 dimensional array. The first key is the sort type, the second is
     * the number of iterations, and the third is the number of elements and the
     * time it took to sort them. Now I just have to implement the last two sorts
     * and print it to a CSV and I should be good to go.
     */

    public static void initializeCases(int maxIterations) {
        cases = new int[sortMap.size()][maxIterations + 1][2];
    }

    public static void storeCases(String sort, int iteration, int maxIterations, int elements, int time) {

        cases[sortMap.get(sort)][iteration][0] = elements;

        cases[sortMap.get(sort)][iteration][1] = time;

    }

    // Bubble Sort
    public static void bubble(int[] arr, int iteration, int maxIterations) {

        int n = arr.length;

        long startTime = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    swap(j, j + 1, arr);
                }
            }

        }

        long endTime = System.nanoTime();

        int time = (int) ((endTime - startTime) / 1000000);

        storeCases("Bubble", iteration, maxIterations, n, time);

        System.out.println("Bubble Sort: " + time + "ms");
    }

    // Selection Sort
    public static void selection(int[] arr, int iteration, int maxIterations) {

        int n = arr.length;

        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            int current = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[current]) {
                    current = j;
                }
            }
            swap(i, current, arr);
        }

        long endTime = System.nanoTime();

        int time = (int) ((endTime - startTime) / 1000000);

        storeCases("Selection", iteration, maxIterations, n, time);

        System.out.println("Selection Sort: " + time + "ms");
    }

    public static void merge(int[] arr, int iteration, int maxIterations) {
        int n = arr.length;

        long startTime = System.nanoTime();

        new mergeSort(arr);

        long endTime = System.nanoTime();

        int time = (int) ((endTime - startTime) / 1000000);

        storeCases("Merge", iteration, maxIterations, n, time);

        System.out.println("Merge Sort: " + time + "ms");
    }

    public static void radix(int[] arr, int iteration, int maxIterations) {
        int n = arr.length;

        long startTime = System.nanoTime();

        new radixSort(arr);

        long endTime = System.nanoTime();

        int time = (int) ((endTime - startTime) / 1000000);

        storeCases("Radix", iteration, maxIterations, n, time);

        System.out.println("Radix Sort: " + time + "ms");
    }
}
