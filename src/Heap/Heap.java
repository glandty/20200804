package Heap;

import java.util.Arrays;

public class Heap {
    //向下调整建堆
    public static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2*parent + 1;
        while(child < size) {
            if(child + 1 < size && array[child+1] > array[child]) {
                child = child + 1;
            }
            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                break;
            }
            parent = child;
            child = 2*parent + 1;
        }
    }

    public static void creatHeap(int[] array, int size) {
        for (int i = (size - 1 - 1) / 2; i >= 0 ; i--) {
            shiftDown(array, size, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 6, 3, 1};
        creatHeap(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}