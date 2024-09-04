package Assignment1;

public class sortTiming {

    public static void main(String[] args) {

        // TODO Fix this ridiculous mess. Probably use a 2D array I think? But how do I
        // set the length of the arrays properly in that case? I wish I wasn't so bad at
        // math.
        int[] randomArr = randomArrs(1000, 10);
        int[] randomArr2 = randomArrs(1000, 100);
        int[] randomArr3 = randomArrs(1000, 1000);
        int[] randomArr4 = randomArrs(1000, 10000);
        int[] randomArr5 = randomArrs(1000, 20000);
        int[] randomArr6 = randomArrs(1000, 30000);
        int[] randomArr7 = randomArrs(1000, 40000);
        int[] randomArr8 = randomArrs(1000, 50000);
        int[] randomArr9 = randomArrs(1000, 60000);
        int[] randomArr10 = randomArrs(1000, 70000);
        int[] randomArr11 = randomArrs(1000, 80000);
        int[] randomArr12 = randomArrs(1000, 90000);
        int[] randomArr13 = randomArrs(1000, 100000);
        int[] randomArr14 = randomArrs(1000, 110000);
        int[] randomArr15 = randomArrs(1000, 120000);
        int[] randomArr16 = randomArrs(1000, 130000);
        int[] randomArr17 = randomArrs(1000, 140000);
        int[] randomArr18 = randomArrs(1000, 150000);
        int[] randomArr19 = randomArrs(1000, 160000);
        int[] randomArr20 = randomArrs(1000, 170000);
        int[] randomArr21 = randomArrs(1000, 180000);
        int[] randomArr22 = randomArrs(1000, 190000);

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
        bubble(randomArr22, 22, 22);

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
