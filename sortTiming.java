package Assignment1;

import java.util.HashMap;
import java.util.Map;

public class sortTiming {

    private static Map<String, Integer> sortMapValue = new HashMap<>();
    private static Map<Integer, String> sortMapKey = new HashMap<>();
    private static int[][][] cases;

    static {
        sortMapValue.put("Bubble", 0);
        sortMapValue.put("Selection", 1);
        sortMapValue.put("Insertion", 2);
        sortMapValue.put("Merge", 3);
        sortMapValue.put("Quick", 4);
        sortMapValue.put("Radix", 5);

        sortMapKey.put(0, "Bubble");
        sortMapKey.put(1, "Selection");
        sortMapKey.put(2, "Insertion");
        sortMapKey.put(3, "Merge");
        sortMapKey.put(4, "Quick");
        sortMapKey.put(5, "Radix");
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
            insertion(randomArrs2[i], i + 1, randomArrs2.length);
        }
        for (int i = 0; i < randomArrs3.length; i++) {
            merge(randomArrs3[i], i + 1, randomArrs3.length);
        }
        for (int i = 0; i < randomArrs5.length; i++) {
            radix(randomArrs5[i], i + 1, randomArrs5.length);
        }

        printCases();
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
        cases = new int[sortMapValue.size()][maxIterations][2];
    }

    public static void storeCases(String sort, int iteration, int maxIterations, int elements, int time) {

        cases[sortMapValue.get(sort)][iteration - 1][0] = elements;

        cases[sortMapValue.get(sort)][iteration - 1][1] = time;

    }

    public static void printCases() {

        for (int i = 0; i < cases.length; i++) {
            System.out.println(sortMapKey.get(i) + " Sort: ");
            for (int j = 0; j < cases[i].length; j++) {
                System.out.print("Case " + (j) + ": ");
                for (int k = 0; k < cases[i][j].length; k++) {
                    if (k == 0) {
                        System.out.print(cases[i][j][k] + " elements, ");
                    } else {
                        System.out.print(cases[i][j][k] + "ms");
                    }
                }
                System.out.println();
            }
        }

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

        // Debug code, remove or modify later
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

        // Debug code, remove or modify later
        System.out.println("Selection Sort: " + time + "ms");
    }

    // Insertion sort
    public static void insertion(int[] arr, int iteration, int maxIterations) {

        int n = arr.length;

        long startTime = System.nanoTime();

        for (int i = 0; i < arr.length; i++) {

            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                // Shift to the right
                arr[j + 1] = arr[j];
                j -= 1;
            }

            arr[j + 1] = current;
        }

        long endTime = System.nanoTime();

        int time = (int) ((endTime - startTime) / 1000000);

        storeCases("Insertion", iteration, maxIterations, n, time);

        // Debug code, remove or modify later
        System.out.println("Insertion Sort: " + time + "ms");
    }

    public static void merge(int[] arr, int iteration, int maxIterations) {
        int n = arr.length;

        long startTime = System.nanoTime();

        new mergeSort(arr);

        long endTime = System.nanoTime();

        int time = (int) ((endTime - startTime) / 1000000);

        storeCases("Merge", iteration, maxIterations, n, time);

        // Debug code, remove or modify later
        System.out.println("Merge Sort: " + time + "ms");
    }

    public static void radix(int[] arr, int iteration, int maxIterations) {
        int n = arr.length;

        long startTime = System.nanoTime();

        new radixSort(arr);

        long endTime = System.nanoTime();

        int time = (int) ((endTime - startTime) / 1000000);

        storeCases("Radix", iteration, maxIterations, n, time);

        // Debug code, remove or modify later
        System.out.println("Radix Sort: " + time + "ms");
    }
}
