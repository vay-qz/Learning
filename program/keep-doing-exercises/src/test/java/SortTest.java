import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SortTest {
    private Sort sort = new Sort();
    private int[] arr = {1,2,3,4,56,7,8,89,9,9,1};
    private int[] rightResult = {1,1,2,3,4,7,8,9,9,56,89};
    @Test
    void bubbleSort() {
        sort.bubbleSort(arr);
        Assert.assertArrayEquals(arr, rightResult);
    }

    @Test
    void selectSort(){
        sort.selectSort(arr);
        Assert.assertArrayEquals(arr, rightResult);
    }

    @Test
    void insertSort(){
        sort.insertSort(arr);
        Assert.assertArrayEquals(arr, rightResult);
    }

    @Test
    void shellSort(){
        sort.shellSort(arr);
        Assert.assertArrayEquals(arr, rightResult);
    }

    @Test
    void binaryInsertSort(){
        sort.binaryInsertSort(arr);
        Assert.assertArrayEquals(arr, rightResult);
    }

    @Test
    void mergeSort(){
        sort.mergeSort(arr);
        Assert.assertArrayEquals(arr, rightResult);
    }

    @Test
    void quickSort(){
        sort.quickSort(arr);
        Assert.assertArrayEquals(arr, rightResult);
    }

    @Test
    void heapSort(){
        sort.heapSort(arr);
        Assert.assertArrayEquals(arr, rightResult);
    }

    @Test
    void countSort(){
        sort.countSort(arr);
        Assert.assertArrayEquals(arr, rightResult);
    }

    @Test
    void bucketSort(){
        sort.bucketSort(arr);
        Assert.assertArrayEquals(arr, rightResult);
    }

    @Test
    void radixSort(){
        sort.radixSort(arr);
        Assert.assertArrayEquals(arr, rightResult);
    }

    private void printArr(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}