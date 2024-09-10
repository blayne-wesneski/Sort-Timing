package Assignment1;

public class mergeSort {
    private final int[] array, temp;

    /* CONSTRUCTOR */
    mergeSort(int[] array) {
        this.array = array;
        this.temp = new int[this.array.length];

        split(0, array.length - 1);
    }

    private void split(int low, int high) {
        if (low == high) {
            return;
        }

        int mid = (low + high) / 2;

        split(low, mid);
        split(mid + 1, high);

        merge(low, mid, high);
    }

    private void merge(int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int t = low;

        while (i <= mid && j <= high) {
            if (this.array[i] < this.array[j]) {
                this.temp[t++] = this.array[i++];
            } else {
                this.temp[t++] = this.array[j++];
            }
        }

        while (i <= mid) {
            this.temp[t++] = this.array[i++];
        }

        while (j <= high) {
            this.temp[t++] = this.array[j++];
        }

        for (t = low; t <= high; t++) {
            this.array[t] = this.temp[t];
        }
    }
}
