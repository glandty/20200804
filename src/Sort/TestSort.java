package Sort;

import java.util.Arrays;

public class TestSort {
    //插入排序(升序)  时间复杂度O(n^2)  空间复杂度O(1) 稳定排序
    public static void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            int v= array[bound];
            int cur = bound - 1;
            for (;cur >= 0; cur--) {
                if(array[cur] > v) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }

    //希尔排序   时间复杂度O(n^2) 空间复杂度O(1) 不稳定排序
    public static void shellSort(int [] array) {
        int gap = array.length / 2;
        while(gap > 1) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        insertSortGap(array, 1);
    }


    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int v= array[bound];
            int cur = bound - gap;
            for (;cur >= 0; cur -= gap) {
                if(array[cur] > v) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = v;
        }
    }

    //选择排序  时间复杂度O(n^2) 空间复杂度O(1) 不稳定排序
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if(array[cur] < array[bound]) {
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

    //交换函数
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //堆排序 时间复杂度O(N*logN) 空间复杂度O(1) 不稳定排序
    public static void heapSort(int[] array) {
        creatHeap(array);

        for (int i = 0; i < array.length - 1; i++) {
            swap(array,0, array.length - 1 - i);
            shiftDown(array, array.length - i -1, 0);
        }
    }

    private static void creatHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0 ; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private static void shiftDown(int[] array, int heapLength, int index) {
        int parent = index;
        int child = 2*parent + 1;
        while(child < heapLength) {
            if(child + 1 < heapLength && array[child+1] > array[child]) {
                child = child + 1;
            }
            if(array[child] > array[parent]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            } else {
                break;
            }
            parent = child;
            child = 2*parent + 1;
        }
    }

    //冒泡排序 时间复杂度O(N^2)  空间复杂度O(1)  稳定排序
    public static void bubberSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if(array[cur - 1] > array[cur]) {
                    swap(array,cur - 1, cur);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array ={8,6,9,7,1,5,3,4,2};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        bubberSort(array);
        System.out.println(Arrays.toString(array));
    }
}
