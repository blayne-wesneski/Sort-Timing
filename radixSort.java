package Assignment1;

public class radixSort {
    /*
     * CONSTRUCTOR
     */

    radixSort(int[] array) {
        int max = getMax(array);
        int numDigits = getNumDigits(max);
        int placeValue = 1;

        while (numDigits > 0) {
            countingSort(array, placeValue);
            placeValue *= 10;
            numDigits--;
        }
    }

    private void countingSort(int[] array, int placeValue) {
        int base = 10;
        int[] count = new int[base];
        int[] sortedValue = new int[array.length];

        // int buckets by 1 for each 'key'
        for (int i = 0; i < array.length; i++) {
            int digit = (array[i] / placeValue) % base;
            count[digit]++;
        }

        // transform into counting array
        for (int i = 1; i < base; i++) {
            count[i] = count[i - 1] + count[i];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int digit = (array[i] / placeValue) % base;

            sortedValue[--count[digit]] = array[i];
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = sortedValue[i];
        }
    }

    private int getMax(int[] array) {
        int currentMax = array[0];

        for (int i = 0; i < array.length; i++) {
            if (currentMax < array[i]) {
                currentMax = array[i];
            }
        }
        return currentMax;
    }
    private int getNumDigits(int num) {
        return (num + "").length();
    }
}
