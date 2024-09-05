package Assignment1;

public class sortTiming {

    public static void main(String[] args) {

        int[][] randomArrs = new int[22][];

        /*
         * I think I figured out the math on this loop. I'm not
         * really sure what I was trying to achieve with my original math here. After I
         * wrote it down and wasted an embarassing amount of scrap paper I got it
         * figured out.I knew what I needed to do code wise, I just got caught on the
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

        // invoke the sorts
        for (int i = 0; i < randomArrs.length; i++) {
            bubble(randomArrs[i], i + 1, randomArrs.length);
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

        System.out.println("Bubble Sort: case " + iteration + " of " + maxIterations + ", " + n + " elements, "
                + (endTime - startTime) / 1000000 + "ms");
    }
}
