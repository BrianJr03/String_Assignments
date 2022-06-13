import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int [] array = new int [] {9, 8, 6, 345, 45, 2, 55};
        System.out.println("\nOriginal: " + Arrays.toString(array));
        System.out.println("\nSorted:   " + Arrays.toString(bubbleSortAscending(array)));
    }

    static public int[] bubbleSortAscending(int[] array) {
        int temp;
        for (int i = 0; i <array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
