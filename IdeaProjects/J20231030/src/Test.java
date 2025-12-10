import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void initArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length-i;
        }
    }
    public static void notOrder(int[] array){
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
    }
    public static void testInsert(int[] array){
        int[] tmpArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        Sort.insertSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("直接插入排序时间："+(endTime-startTime));
    }
    public static void testShell(int[] array){
        int[] tmpArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        Sort.shellSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序时间："+(endTime-startTime));
    }
    public static void testSelect(int[] array){
        int[] tmpArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        Sort.selectSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序时间："+(endTime-startTime));
    }
    public static void testQuick(int[] array){
        int[] tmpArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        Sort.quickSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("快速排序时间："+(endTime-startTime));
    }

    public static void testMerge(int[] array){
        int[] tmpArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        Sort.mergeSort(tmpArray);
        long endTime = System.currentTimeMillis();
        System.out.println("归并排序耗时："+(endTime-startTime));
    }


    public static void main(String[] args) {
        int[] array = new int[10_0000];
        initArray(array);
        testInsert(array);
        testShell(array);
//        testSelect(array);
//        testQuick(array);
        testMerge(array);

    }
}
