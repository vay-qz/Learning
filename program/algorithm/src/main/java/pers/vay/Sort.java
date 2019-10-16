package pers.vay;

import java.util.*;

public class Sort {

    /**
     * 冒泡排序
     * @param arr
     */
    public void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length; i++){
            for(int j = 0; j < arr.length - 1 - i;j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }


    /**
     * 选择排序
     * @param arr
     */
    public void selectSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int place = i;
            int j = i + 1;
            for(; j < arr.length; j++){
                if(arr[place] > arr[j]){
                    place = j;
                }
            }
            if(i != place){
                swap(arr, i, place);
            }
        }
    }

    /**
     * 简单插入排序
     * @param arr
     */
    public void insertSort(int[] arr){
        for(int i = 1; i < arr.length;i++){
            int temp = arr[i];
            int j = i;
            for(; j > 0; j--){
                if(temp < arr[j-1]){
                    arr[j] = arr[j-1];
                }else{
                    break;
                }
            }
            arr[j] = temp;
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public void shellSort(int[] arr){
        int space = arr.length;
        while(space > 1){
            space = space/3 + 1;
            for(int i = 0; i < space; i++){
                for(int j = i + space; j < arr.length; j += space){
                    int temp = arr[j];
                    int t = j;
                    for(; t > i; t -= space){
                        if(temp < arr[t - space]){
                            arr[t] = arr[t - space];
                        }else{
                            break;
                        }
                    }
                    arr[t] = temp;
                }
            }
        }
        printArr(arr);
    }

    /**
     * 折半插入排序
     * @param arr
     */
    public void binaryInsertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int head = 0, tail = i;
            while(head < tail){
                int mid = (head + tail)/2;
                if(temp > arr[mid]){
                    head = mid + 1;
                }else{
                    tail = mid;
                }
            }
            int j = i;
            for(; j > tail; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    /**
     * 快速排序
     * @param arr
     */
    public void quickSort(int[] arr){
        qsort(0, arr.length - 1, arr);
    }

    private void qsort(int left, int right, int[] arr) {
        if(left > right){
            return;
        }
        int l = left;
        int r = right;
        int sb = arr[left];
        while(left < right){
            //左边为哨兵就要出右边开始找，否则归位时会有问题
            while(sb <= arr[right] && left < right){
                right--;
            }
            while(sb >= arr[left] && left < right){
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, l, left);
        qsort(l, left - 1, arr);
        qsort(left + 1, r, arr);
    }

    /**
     * 归并排序
     */
    public void mergeSort(int[] arr){
        copy(tt(arr), arr);
    }

    private void copy(int[] tt, int[] arr) {
        for(int i = 0; i < tt.length; i++){
            arr[i] = tt[i];
        }
    }

    private int[] tt(int[] l){
        if(l.length < 2){
            return l;
        }
        int mid = l.length/2;
        int[] t = merge(tt(getHeadArray(l, mid)),tt(getTailArray(l, mid)));
        return t;
    }

    private int[] getHeadArray(int[] l, int mid) {
        int[] res = new int[mid];
        for(int i = 0; i < res.length; i++){
            res[i] = l[i];
        }
        return res;
    }

    private int[] getTailArray(int[] l, int mid){
        int[] res = new int[l.length%2==1?mid+1:mid];
        for(int i = 0; i < l.length - mid; i++){
            res[i] = l[i + mid];
        }
        return res;
    }

    private int[] merge(int[] left, int[] right){
        int i = 0, j = 0, k = 0;
        int[] res = new int[left.length + right.length];
        while(i < left.length&&j < right.length){
            if(left[i] < right[j]){
                res[k++] = left[i++];
            }else{
                res[k++] = right[j++];
            }
        }
        while(i < left.length){
            res[k++] = left[i++];
        }
        while(j < right.length){
            res[k++] = right[j++];
        }
        return res;
    }

    /**
     * 堆排序
     * @param arr
     */
    public void heapSort(int[] arr){
        for(int i = arr.length/2 - 1; i >= 0; i--){
            deal(i, arr.length, arr);
        }

        for(int i = arr.length - 1; i > 0; i--){
            swap(arr, 0, i);
            deal(0, i, arr);
        }
    }

    private void deal(int node, int len, int[] arr) {
        int temp = arr[node];
        for(int k = 2 * node + 1; k < len; k = k * 2 + 1){
            if(k + 1 < len && arr[k] < arr[k+1]){
                k++;
            }
            if(temp < arr[k]){
                swap(arr, node, k);
                node = k;
            }else{
                break;
            }
        }
    }


    /**
     * 计数排序
     */
    public void countSort(int[] arr){
        int max = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int[] count = new int[max + 1];
        for(int i = 0;i < arr.length; i++){
            count[arr[i]]++;
        }
        int i = 0, j = 0;
        while(j < count.length){
            if(count[j] == 0){
                j++;
                continue;
            }else{
                arr[i++] = j;
                count[j]--;
            }
        }
    }

    /**
     * 桶排序
     */
    public void bucketSort(int[] arr){
        int bucketNum = 5;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int space = (max - min)/bucketNum + 1;
        Map<Integer, ArrayList<Integer>> bucket = new HashMap<>();
        for(int i = 0; i < bucketNum; i++){
            bucket.put(i, new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i++){
            bucket.get((arr[i] - min)/space).add(arr[i]);
        }
        int t = 0;
        for(Map.Entry<Integer, ArrayList<Integer>> entry : bucket.entrySet()){
            entry.getValue().sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for(Integer i : entry.getValue()){
                arr[t++] = i;
            }
        }
    }

    /**
     * 基数排序
     * @param arr
     */
    public void radixSort(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int radix = getRadix(max);
        for(int i = 0; i < radix; i++){
            List<List<Integer>> lists = getLists();
            for(int j = 0; j < arr.length; j++){
                lists.get(getNum(i, arr[j])).add(arr[j]);
            }
            int t = 0;
            for(List<Integer> l : lists){
                for(Integer ii : l){
                    arr[t++] = ii;
                }
            }
        }
    }

    private int getNum(int radix, int num) {
        for(int i = 0; i < radix ; i++){
            num/=10;
        }
        if(num > 9){
            return num % 10;
        }else{
            return num;
        }
    }

    private List<List<Integer>> getLists() {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            List<Integer> l = new ArrayList<>();
            list.add(l);
        }
        return list;
    }

    private int getRadix(int max) {
        int num = 0;
        while(max > 0){
            max/=10;
            num++;
        }
        return num;
    }

    private void swap(int[] arr, int j, int i) {
        if(j == i){
            return;
        }
        arr[j] = arr[j] + arr[i];
        arr[i] = arr[j] - arr[i];
        arr[j] = arr[j] - arr[i];
    }

    private void printArr(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
