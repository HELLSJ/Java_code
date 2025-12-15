package Sort;

public class eightSortMethods {
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (array[j]>tmp){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    //希尔排序
    public static void shellSort(int[] array){
        int gap = array.length;
        while(gap>1) {
            gap /= 2;
            shell(array, gap);
        }
    }

    private static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i-tmp;
            for(;j>=0;j-=gap){
                if (array[j]>tmp){
                    array[j+gap]=array[i];
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    //直接选择排序
    public static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    //冒泡排序
    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param array
     */
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            //每一趟都比较上一趟有没有交换
            boolean flg = false;
            //每一趟结束后：最后 i 个元素已经有序, 所以是length-1-i
            for (int j = 0; j < array.length-1-i; j++) {
                //只比较 相邻两个
                //前面大 → 换
                //一换就说明这一趟不是“全有序”
                //标记 flg = true
                if(array[j] > array[j+1]){
                    swap(array, j, j+1);
                    flg = true;
                }
            }
            //如果一整趟都没有发生交换
            //说明数组已经排好序了
            //直接结束，不用再排
            if(flg==false){
                break;
            }
        }
    }
    
    //快速排序
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }

    private static void quick(int[] array, int start, int end) {
        if(start>=end){
            return;
        }
        int pivot = partitionHoare(array, start, end);
        quick(array,start,pivot-1);
        quick(array,pivot+1,end);
    }
    // Hoare 思路
    // 选择区间的第一个元素 作为 pivot
    // 使用两个指针：left 从左向右扫描，right 从右向左扫描
    // 指针移动规则：right 向左移动，寻找 第一个小于 pivot 的元素；left 向右移动，寻找 第一个大于 pivot 的元素
    // 当 left < right 时：交换这两个“放错位置”的元素
    // 重复上述过程，直到 left 和 right 相遇
    // 将 pivot 与相遇位置的元素交换
    // 此时 pivot 位于最终正确位置，返回该位置
    private static int partitionHoare(int[] array, int left, int right) {
        int tmp = array[left];
        int i = left;
        while(left<right){
            while(left<right && array[right]>=tmp){
                right--;
            }
            while(left<right && array[left]<=tmp){
                left++;
            }
            swap(array,left,right);
        }
        swap(array,i,left);
        return left;
    }

}
