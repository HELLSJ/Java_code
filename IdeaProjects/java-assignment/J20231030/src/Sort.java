import java.util.Stack;

public class Sort {
    //直接插入排序
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }
    //希尔排序
    public static void shellSort(int[] array){
        int gap = array.length;
        while(gap>1){
            gap /= 2;
            shell(array,gap);
        }
    }

    /**
     * 对每组进行排序
     * 这段代码其实跟插入排序差不多，就是i其实位置在gap上，j每次递减递增gap个单位
     * @param array
     * @param gap
     */

    public static void shell(int[] array, int gap){
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i -gap ;
            for (; j >= 0 ; j-=gap) {
                if (array[j] > tmp){
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    /**
     * 选择排序
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * 稳定性：不稳定
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            //j往后遍历，每次找到比minIndex下标元素小的就进行下标替换
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array,i,minIndex);
        }
    }
    public static void selectSort2(int[] array){
        int left = 0;
        int right = array.length-1;
        while(left<right){
            int minIndex = left;
            int maxIndex = right;
            //找到最大值和最小值下标
            for (int i = left+1; i <= right; i++) {
                if(array[i] < array[minIndex]){
                    minIndex = i;
                }
                if(array[i] > array[maxIndex]){
                    maxIndex = i;
                }
            }
            swap(array,minIndex,left);
            if(maxIndex == left){
                maxIndex = minIndex;
            }
            swap(array,maxIndex,right);
            left++;
            right--;
        }
    }
    private static void createHeap(int[] array) {
        for (int parent = (array.length-1-1)/2; parent >= 0 ; parent--) {
            siftDown(array,parent,array.length);//alt+enter
        }
    }

    private static void siftDown(int[] array,int parent, int length) {
        int child = 2*parent + 1;
        while (child < length) {
            if(child+1 < length && array[child] < array[child+1]) {
                child++;
            }
            if(array[child] > array[parent]) {
                swap(array,child,parent);
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    /**
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(1)
     * 稳定性：不稳定的排序
     * @param array
     */
    public static void heapSort(int[] array) {
        createHeap(array);
        int end = array.length-1;
        while (end > 0) {
            swap(array,0,end);
            siftDown(array,0,end);
            end--;
        }
    }

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param array
     */
    public static void bubbleSort(int[] array){
        //i代表趟数
        for (int i = 0; i < array.length-1; i++) {
            //每一趟都比较上一趟有没有交换
            boolean flg = false;
            //j来比较每个数据的大小
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                    flg = true;
                }
            }
            if(flg==false){
                break;
            }
        }
    }

    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }

    private static void quick(int[] array, int start, int end){
        if(start >= end){
            return;
        }
        //找到中间的值
        int pivot = partitionHoare(array,start,end);
        //左右分别进行递归
        quick(array,start,pivot-1);
        quick(array,pivot+1,end);
    }
    private static int partitionHoare(int[] array, int left, int right){
        int tmp = array[left];
        int i = left;
        //整个的循环，要求left和right相遇之后能交换数字
        while(left<right){
            //单独的循环，因为如果right--一直找不到比tmp大的数，而right不能一直减到最左边的边界
            //所以需要再规定依次left<right
            while(left<right && array[right] >= tmp){
                right--;
            }
            while (left<right && array[left] <= tmp){
                left++;
            }
            swap(array,left,right);
        }
        swap(array,i,left);
        return left;
    }

    private static int partitionHole(int[] array, int left, int right){
        int tmp = array[left];
        //整个的循环，要求left和right相遇之后能交换数字
        while(left<right){
            //单独的循环，因为如果right--一直找不到比tmp大的数，而right不能一直减到最左边的边界
            //所以需要再规定依次left<right
            while(left<right && array[right] >= tmp){
                right--;
            }
            array[left] = array[right];
            while (left<right && array[left] <= tmp){
                left++;
            }
            array[right] = array[left];
            swap(array,left,right);
        }
        array[left] = tmp;
        return left;
    }
    /**
     * 前后指针法：
     *  总结：
     *  1. Hoare
     *  2. 挖坑法
     *  3. 前后指针法
     *  这3种方式  每次划分之后的前后顺序 有可能是不一样的
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] array, int left, int right) {
        int prev = left;
        int cur = left + 1;
        while (cur <= right) {
            if (array[cur] < array[left] && array[++prev] != array[cur]) {
                swap(array, cur, prev);
            }
            cur++;
        }

        swap(array, prev, left);
        return prev;
    }

    private static int middleNum(int[] array, int left,int right){
        int mid = (left+right)/2;
        //求中位数的下标
        if(array[left] < array[right]){
            if(array[mid]<array[left]){
                return left;
            }else if(array[mid] > array[right]){
                return right;
            }else{
                return mid;
            }
        }else{
            //array[left] > array[right]
            if(array[mid]>array[left]){
                return left;
            }else if(array[mid] < array[right]){
                return right;
            }else{
                return mid;
            }
        }
    }

    public static void insertSort(int[] array, int left,int right) {
        for (int i = left+1; i <= right; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= left; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }
    private static void quick2(int[] array, int start, int end){
        if(start>=end){
            return;
        }
        if(end-start+1<=15){
            insertSort(array,start,end);
            return;
        }
        //1 2 3 4 5 6 7
        int index = middleNum(array,start,end);
        swap(array,index,start);
        //4 2 3 1 5 6 7
        int pivot = partition(array,start,end);
        quick2(array,start,pivot-1);
        quick2(array,pivot+1,end);
    }

    public static void quickSortNor(int[] array){
        int start = 0;
        int end = array.length-1;
        Stack<Integer> stack = new Stack<>();
        int pivot = partitionHoare(array,start,end);
        if(pivot>start+1){
            stack.push(start);
            stack.push(pivot-1);
        }
        if(pivot+1<end){
            stack.push(pivot+1);
            stack.push(end);
        }
        while(!stack.isEmpty()){
            end = stack.pop();
            start=stack.pop();
            pivot = partitionHoare(array,start,end);
            if(pivot>start+1){
                stack.push(start);
                stack.push(pivot-1);
            }
            if(pivot+1<end){
                stack.push(pivot+1);
                stack.push(end);
            }
        }
    }

    public static void mergeSort(int[] array){
        mergeSortFun(array,0, array.length-1);
    }

    private static void mergeSortFun(int[] array,int start,int end){
        if(start>=end){
            return;
        }
        //分解
        int mid = (start+end)/2;
        mergeSortFun(array,start,mid);
        mergeSortFun(array,mid+1,end);
        //合并
        merge(array,start,mid,end);
    }

    private static void merge(int[] array, int left, int mid,int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = right;
        int[] tmpArr = new int[right-left+1];
        int k = 0;//tmpArr的下标
        //同时满足两个归并段都有数据
        while(s1 <= e1 && s2 <= e2){
            if(array[s1] <= array[s2]){
                tmpArr[k++] = array[s1++];
            }else{
                tmpArr[k++] = array[s2++];
            }
        }
        while(s1 <= e1){
            tmpArr[k++] = array[s1++];
        }
        while(s2 <= e2){
            tmpArr[k++] = array[s2++];
        }
        //把排好的数据拷贝回原来的数组array中
        for (int i = 0; i < tmpArr.length; i++) {
            array[i+left] = tmpArr[i];
        }
    }

    /**
     * 非递归实现
     * @param array
     */

    public static void mergeSortNor(int[] array){
        int gap = 1;
        while(gap<array.length){
            for (int i = 0; i < array.length; i = i+gap*2) {
                int left = i;
                int mid = left+gap-1;
                int right = mid+gap;
                if(mid >= array.length){
                    mid = array.length-1;
                }
                if(right>=array.length){
                    right = array.length-1;
                }
                merge(array,left,mid,right);
            }
            gap*=2;
        }
    }

    /**
     * 计数排序的场景：
     * 指定范围内的排序
     * @param array
     */

    public static void countSort(int[] array){
        int minVal = array[0];
        int maxVal = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]<minVal){
                minVal = array[i];
            }
            if(array[i]>maxVal){
                maxVal=array[i];
            }
        }
        //确定计数数组的长度
        int len = maxVal-minVal+1;
        int[] count = new int[len];

        //遍历array数组 把数据出现的次数存储到计数数组中
        for (int i = 0; i < array.length; i++) {
            count[array[i]-minVal]++;
        }
        //遍历计数数组，把实际的数组写回array数组
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while(count[i]>0){
                //这里需要写回array,得从array的0位置开始写
                array[index] = i+minVal;
                index++;
                //每次写进array一个元素，计数数组的对应元素数量就得减少
                count[i]--;
            }
        }
    }
}
