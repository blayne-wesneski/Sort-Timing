package Assignment1;

public class sortTiming {

    public static void main(String[] args) {

        int[][] randomArrs = new int[22][];
        for (int i = 0; i < randomArrs.length; i++) {

            if (i + 1 * 10 <= 10000) {
                randomArrs[i] = randomArrs(1000, i + 1 * 10);
            } else if (i + 1 * 10 > 10000) {
                randomArrs[i] = randomArrs(1000, i * 10000);
            }

        }

        // TODO Fix this ridiculous mess. Probably use a 2D array I think? But how do I
        // set the length of the arrays properly in that case? I wish I wasn't so bad at
        // math.
        int[] randomArr = copyArray(randomArrs[0]);
        int[] randomArr2 = copyArray(randomArrs[1]);
        int[] randomArr3 = copyArray(randomArrs[2]);
        int[] randomArr4 = copyArray(randomArrs[3]);
        int[] randomArr5 = copyArray(randomArrs[4]);
        int[] randomArr6 = copyArray(randomArrs[5]);
        int[] randomArr7 = copyArray(randomArrs[6]);
        int[] randomArr8 = copyArray(randomArrs[7]);
        int[] randomArr9 = copyArray(randomArrs[8]);
        int[] randomArr10 = copyArray(randomArrs[9]);
        int[] randomArr11 = copyArray(randomArrs[10]);
        int[] randomArr12 = copyArray(randomArrs[11]);
        int[] randomArr13 = copyArray(randomArrs[12]);
        int[] randomArr14 = copyArray(randomArrs[13]);
        int[] randomArr15 = copyArray(randomArrs[14]);
        int[] randomArr16 = copyArray(randomArrs[15]);
        int[] randomArr17 = copyArray(randomArrs[16]);
        int[] randomArr18 = copyArray(randomArrs[17]);
        int[] randomArr19 = copyArray(randomArrs[18]);
        int[] randomArr20 = copyArray(randomArrs[19]);
        int[] randomArr21 = copyArray(randomArrs[20]);

        // Good lord it got worse. It definitely works... but it definitely sucks.

        bubble(randomArr, 1, 22);
        bubble(randomArr2, 2, 22);
        bubble(randomArr3, 3, 22);
        bubble(randomArr4, 4, 22);
        bubble(randomArr5, 5, 22);
        bubble(randomArr6, 6, 22);
        bubble(randomArr7, 7, 22);
        bubble(randomArr8, 8, 22);
        bubble(randomArr9, 9, 22);
        bubble(randomArr10, 10, 22);
        bubble(randomArr11, 11, 22);
        bubble(randomArr12, 12, 22);
        bubble(randomArr13, 13, 22);
        bubble(randomArr14, 14, 22);
        bubble(randomArr15, 15, 22);
        bubble(randomArr16, 16, 22);
        bubble(randomArr17, 17, 22);
        bubble(randomArr18, 18, 22);
        bubble(randomArr19, 19, 22);
        bubble(randomArr20, 20, 22);
        bubble(randomArr21, 21, 22);

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
