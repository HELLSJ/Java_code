import java.util.Scanner;
import java.util.Arrays;
//实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
public class Homework {
    public static void main(String[] args) {
        int[][] array = new int[2][];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main66(String[] args) {
        int[][] array = {{1,2,3},{4,5,6}};
        System.out.println(array.length);
        System.out.println(array[1].length);
        System.out.println(array[2].length);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        for (int[] tmp:array) {
            for (int x : tmp) {
                System.out.println(x + " ");
            }
            System.out.println();
        }
        int[][] array2 = new int[][]{{1,2,3},{4,5,6}};
        int[][] array3 = new int[2][3];

        //定义二维数组行不能省略
        //int[][] array4 = new int[][3];这种是错误的

        //不规则二维数组
        int[][] array5 = new int[2][];
    }
    public static void main44(String[] args) {
        int[] array1 = {2, 4, 6, 3};
        int[] array2 = {2,4,6,3,10};
        System.out.println(Arrays.equals(array1, array2));//equals判断数组是否相同
        int[] array = new int[10];
        System.out.println(Arrays.toString(array));
        Arrays.fill(array, 9);
        Arrays.fill(array, 0, 3, 9);
        System.out.println(Arrays. toString(array));
        int[] copy = new int[array1.length];
        System.arraycopy(array1,0,copy,0,array1.length);
    }

//    public static void func(){
//// newArr和arr引用的是同一个数组
//// 因此newArr修改空间中内容之后，arr也可以看到修改的结果
//        int[] arr = {1,2,3,4,5,6};
//        int[] newArr = arr;
//        newArr[0] = 10;
//        System.out.println("newArr: " + Arrays.toString(arr));
//// 使用Arrays中copyOf方法完成数组的拷贝：
//// copyOf方法在进行数组拷贝时，创建了一个新的数组
//// arr和newArr引用的不是同一个数组
//        arr[0] = 1;
//        newArr = Arrays.copyOf(arr, arr.length);
//        System.out.println("newArr: " + Arrays.toString(newArr));
//// 因为arr修改其引用数组中内容时，对newArr没有任何影响
//        arr[0] = 10;
//        System.out.println("arr: " + Arrays.toString(arr));
//        System.out.println("newArr: " + Arrays.toString(newArr));
//// 拷贝某个范围.
//        int[] newArr2 = Arrays.copyOfRange(arr, 2, 4);
//        System.out.println("newArr2: " + Arrays.toString(newArr2));
//    }
}




//    public static int[] findnumber(int[] array, int target){
//        int[] ret = {-1,-1};
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i+1; j < array.length; j++) {
//                if(array[i] + array[j] == target){
//                    //return new int[]{i,j};
//                    ret[0] = i;
//                    ret[1] = j;
//                }
//            }
//        }
//        return ret;
//    }
//    public static void fun3(int[] array){
//        int i = 0;
//        int j = array.length-1;
//        while(i<j){
//            //i从前往后遍历，走完之后i下标就停在偶数位置
//            while(i<j && array[i] % 2 != 0){
//                i++;
//            }
//            //j从后往前遍历，走完之后j下标就停在奇数位置
//            while(i<j && array[j] %2 == 0){
//                j--;
//            }
//            //i和j交换
//            int tmp = array[i];
//            array[i] = array[j];
//            array[j] = tmp;
//        }
//    }
//    public static void move(char pos1, char pos2){
//        System.out.print(pos1+" => "+pos2+" ");
//    }
//    /**
//     * @param n 盘子数目
//     * @param pos1 起始位置
//     * @param pos2 中转位置
//     * @param pos3 目的位置
//     */
//    public static void hanio(int n, char pos1, char pos2, char pos3){
//        if(n == 1){
//            move(pos1,pos3);
//            return;
//        }
//        hanio(n-1,pos1,pos3,pos2);//第一次目的地是pos2
//        move(pos1,pos3);
//        hanio(n-1, pos2,pos1,pos3);
//    }
//    public static void main44(String[] args) {
//        hanio(1,'A','B','C');
//        System.out.println();
//        hanio(2,'A','B','C');
//        System.out.println();
//        hanio(3,'A','B','C');
//        System.out.println();
//    }
//    public static boolean judge(int[] arr){
//        int count = 0;
//        for(int num: arr){
//            if(num % 2 == 1){
//                count++;
//                if(count == 3){
//                    return true;
//                }
//            }else{
//                count = 0;
//            }
//        }
//        return false;
//    }
//
//    public static void main222(String[] args) {
//        int[] arr1 = {2, 6, 4, 1};
//        System.out.println(judge(arr1));
//        int[] arr2 = {1,2,34,3,4,5,7,23,12};
//        System.out.println(judge(arr2));
//    }
//    public static int findmore(int[] array){
//        int count = 0;
//        int ret = 0;
//        for(int num : array){
//            if(count == 0){
//                ret = num;
//                count = 1;
//            } else if (num == ret) {
//                count++;
//            }else{
//                count--;
//            }
//        }
//        return ret;
//    }
//
//    public static void main55(String[] args) {
//        int[] nums1 = {3, 2, 3};
//        System.out.println(findmore(nums1));
//
//        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
//        System.out.println(findmore(nums2));
//    }
//    public static void transform(int[] array){
//        for (int i = 0; i < array.length; i++) {
//            array[i] *= 2;
//        }
//    }
//    public static String myToString(int[] array){
//        if (array == null){
//            return "null";
//        }
//        if (array.length == 0){
//            return "[]";
//        }
//        String ret = "[";
//        for (int i = 0; i < array.length; i++) {
//            ret += array[i];
//            if (i != array.length-1){//最后一个不打印","
//                ret+=", ";
//            }
//        }
//        ret += "]";
//        return ret;
//    }
//    public static void sort(int[] array){
//        int i = 0;
//        int j = array.length-1;
//        while(i < j){
//            if (array[i] % 2 == 1){
//                i++;
//            }
//            else if(array[j] % 2 == 0){
//                j--;
//            }
//            else{
//                int tmp = array[i];
//                array[i] = array[j];
//                array[j] = tmp;
//                i++;
//                j--;
//            }
//        }
//    }
//public static String myToString(int[] array){
//    if (array == null){
//        return "null";
//    }
//    if (array.length == 0){
//        return "[]";
//    }
//    String ret = "[";
//    for (int i = 0; i < array.length; i++) {
//        ret += array[i];
//        if (i != array.length-1){//最后一个不打印","
//            ret+=", ";
//        }
//    }
//    ret += "]";
//    return ret;
//}
//public static int erFenSort(int[] array, int target){
//    int left = 0;
//    int right = array.length-1;
//    while(left < right){
//        int mid = (left + right) / 2;
//        if(array[mid] == target){
//            return mid;
//        } else if (array[mid] < target) {
//            left+=1;
//        }else {
//            right-=1;
//        }
//    }
//    return -1;
//}
//public static String myToString(int[] array){
//    if (array == null){
//        return "null";
//    }
//    if (array.length == 0){
//        return "[]";
//    }
//    String ret = "[";
//    for (int i = 0; i < array.length; i++) {
//        ret += array[i];
//        if (i != array.length-1){//最后一个不打印","
//            ret+=", ";
//        }
//    }
//    ret += "]";
//    return ret;
//}
//public static int[] lookFor(int[] array, int target){
//    int left = 0;
//    int right = array.length-1;
//    while(left <= right){
//        int sum = array[left] + array[right];
//        if(sum == target){
//            return new int[]{left,right};
//        } else if (sum < target) {
//            left++;
//        }else{
//            right--;
//        }
//    }
//    return null;
//}
//public static int findSingleNumber(int[] nums) {
//    int result = 0;
//    for (int num : nums) {
//        result ^= num;
//    }
//    return result;
//}
//
//    public static void main44(String[] args) {
//        int[] nums = {2,2,1};
//        System.out.println(findSingleNumber(nums));
//        int[] array = {4,1,2,1,2};
//        System.out.println(findSingleNumber(array));
//    }
}
