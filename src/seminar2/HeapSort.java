package seminar2;


public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;


        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);


        for (int i = n - 1; i >= 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;


            heapify(arr, i, 0);
        }
    }


    void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2


        if (l < n && arr[l] > arr[largest])
            largest = l;


        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;


            heapify(arr, n, largest);
        }
    }


    static void printArray(int[] arr) {
        int n = arr.length;
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {17, 10, 1, 5, 81, 66};
        int n = arr.length;

        System.out.println("Изначальный список:");
        printArray(arr);

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Отсортированный список:");
        printArray(arr);
    }
}