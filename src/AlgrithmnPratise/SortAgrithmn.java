package AlgrithmnPratise;

import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.Arrays;
import java.util.Scanner;

import static com.sun.tools.javac.jvm.ByteCodes.arraylength;
import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * Created by liudeyu on 2017/3/8.
 */
public class SortAgrithmn {
    public void displayArray(int[] array, String string) {
        if (array == null) {
            return;
        }
        System.out.println(string);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public void bubbleSort(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public void selectSort(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int minValue = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minValue) {
                    minValue = array[j];
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    public void insertSort(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j;
            for (j = i; j > 0; j--) {
                if (tmp < array[j - 1]) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = tmp;
        }
    }

    public int[] randomCreateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size) % (2 * size);
        }
        return array;
    }

    /*希尔排序，较容易忘记它的思想，不好写*/
    public void shellSort(int[] array) {
        if (array == null) {
            return;
        }
        int n = array.length / 2;
        while (n > 0) {
            int i = n;
            while (i < array.length) {
                int tmp = array[i];
                int j = i;
                while (j - n >= 0 && array[j - n] > tmp) {
                    array[j] = array[j - n];
                    j -= n;
                }
                array[j] = tmp;
                i++;
            }
            n = n / 2;
        }

    }

    public void quickSort(int[] array) {
        if (array == null) {
            return;
        }
        ToImplementQuickSort(array, 0, array.length - 1);
    }

    public void mergeSort(int[] array) {
        if (array == null) {
            return;
        }
        toImplementMergeSort(array, 0, array.length - 1);
    }

    private void toImplementMergeSort(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (left < mid) {
            toImplementMergeSort(array, left, mid);
        }
        if (mid + 1 < right) {
            toImplementMergeSort(array, mid + 1, right);
        }
        int[] rawArray = new int[array.length];
        rawArray = Arrays.copyOf(array, array.length);
        int i = left, j = mid + 1;
        int a1 = left;
        while (i <= mid && j <= right) {
            if (rawArray[i] < rawArray[j]) {
                array[a1++] = rawArray[i++];
            } else {
                array[a1++] = rawArray[j++];
            }
        }
        while (i <= mid) {
            array[a1++] = rawArray[i++];
        }
        while (j <= right) {
            array[a1++] = rawArray[j++];
        }
    }

    private void ToImplementQuickSort(int[] array, int i, int i1) {
        if (i >= i1) {
            return;
        }
        int left = i;
        int right = i1;
        int guard = array[left];
        while (left < right) {
            while (left < right && array[right] > guard) {
                right--;
            }
            if (left < right) {
                array[left] = array[right];
                left++;
            }
            while (left < right && array[left] < guard) {
                left++;
            }
            if (left < right) {
                array[right] = array[left];
                right--;
            }
        }
        array[left] = guard;
        if (i < left) {
            ToImplementQuickSort(array, i, left - 1);
        }
        if (left < i1) {
            ToImplementQuickSort(array, left + 1, i1);
        }
    }

    public static void main(String[] argv) {
        SortAgrithmn sortAgrithmn = new SortAgrithmn();
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        while (n >= 0) {
            int[] array = sortAgrithmn.randomCreateArray(n);
            sortAgrithmn.displayArray(array, "raw");
            int[] array2 = Arrays.copyOf(array, array.length);
            sortAgrithmn.insertSort(array2);
            sortAgrithmn.displayArray(array2, "insert sort");
            array2 = Arrays.copyOf(array, array.length);
            sortAgrithmn.bubbleSort(array2);
            sortAgrithmn.displayArray(array2, "bubble sort");
            array2 = Arrays.copyOf(array, array.length);
            sortAgrithmn.selectSort(array2);
            sortAgrithmn.displayArray(array2, "select sort");
            array2 = Arrays.copyOf(array, array.length);
            sortAgrithmn.shellSort(array2);
            sortAgrithmn.displayArray(array2, "shell sort");
            array2 = Arrays.copyOf(array, array.length);
            sortAgrithmn.quickSort(array2);
            sortAgrithmn.displayArray(array2, "quick sort");
            array2 = Arrays.copyOf(array, array.length);
            sortAgrithmn.mergeSort(array2);
            sortAgrithmn.displayArray(array2, "merge sort");
            n = scanner.nextInt();
        }
    }
}
