import java.util.Arrays;
import java.util.Scanner;

//创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
//
//要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
public class Test {
    public static void main(String[] args) {
        int n = 3; // 盘子数量
        hanoi(n, 'A', 'C', 'B');
    }

    public static void hanoi(int n, char source, char target, char auxiliary) {
        if (n == 1) {
            System.out.println("将第1个盘子从柱子" + source + "移动到柱子" + target);
            return;
        }
        hanoi(n - 1, source, auxiliary, target);
        System.out.println("将第" + n + "个盘子从柱子" + source + "移动到柱子" + target);
        hanoi(n - 1, auxiliary, target, source);
    }
}
//    public static void bubbleSort(int[] array){
//        //i代表遍历趟数
//        for (int i = 0; i < array.length-1; i++) {
//            //每次比上一次少一个,优化：比较趟数
//            boolean flg = false;//优化：比较结果
//            //j代表元素下标，相当于C里面的指针
//            for (int j = 0; j < array.length-1-i; j++) {
//                if(array[j] > array[j+1]){
//                    int tmp = array[j];
//                    array[j] = array[j+1];
//                    array[j+1] = tmp;
//                    flg = true;
//                }
//            }
//            if(!flg){
//                //没有交换
//                return;
//            }
//        }
//    }
//    public static void reverse(int[] array){
//        if (array == null){
//            return;
//        }
//        int i = 0;
//        int j = array.length-1;
//        while(i < j){
//            int tmp = array[i];
//            array[i] = array[j];
//            array[j] = tmp;
//            i++;
//            j--;
//        }
//    }
//    public static void main4(String[] args) {
//        int[] array = {8,12,5,7,9};
//        System.out.println(myToString(array));
//        //reverse(array);
//        bubbleSort(array);
//        System.out.println(myToString(array));
//    }
//    public static void main234(String[] args) {
//        int[] array = {100,22,33,4,5};
//        System.out.println(Arrays.toString(array));
//        Arrays.sort(array);//数组排序
//        Arrays.sort(array,0,3);
//        System.out.println(Arrays.toString(array));
//    }
//
//    public static void main53(String[] args) {
//        int[] array = {100,22,33,4,5};
//        System.out.println(myToString(array));
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
//
//    public static void main45(String[] args) {
//        int[] ret = func3();
//        for (int i = 0; i < ret.length; i++) {
//            System.out.println(ret[i]);
//        }
//    }
//    public static int[] func3(){
//        int[] ret = new int[2];
//        ret[0] = 99;
//        ret[1] = 199;
//        return ret;//作为返回值的形式进行传递
//    }
//    public static int max2(int a, int b){
//        if (a >= b){
//            return a;
//        } else{
//            return b;
//        }
//    }
//    public static int max3(int a, int b, int c){
//        if (c >= max2(a,b)){
//            return c;
//        }else{
//            return max2(a,b);
//        }
//    }
//    public static void main3(String[] args) {
//        int a = 10;
//        int b = 20;
//        int c = 30;
//        System.out.println(max2(a,b));
//        System.out.println(max3(a,b,c));
//    }
//    public static int jc(int n){
//        int result = 1;
//        for (int i = 1; i <= n ; i++) {
//            result *= i;
//        }
//        return result;
//    }
//    public static int jcsum(int n){
//        int sum = 0;
//        for (int i = 1; i <= n; i++) {
//            sum += jc(i);
//        }
//        return sum;
//    }
//    public static void main4(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = jcsum(n);
//        System.out.println(m);
//    }
//public static int fibonacci(int n) {
//    if (n <= 0) {
//        return 0;
//    } else if (n == 1 || n == 2) {
//        return 1;
//    } else {
//        int prev1 = 1;
//        int prev2 = 1;
//        int result = 0;
//
//        for (int i = 3; i <= n; i++) {
//            result = prev1 + prev2;
//            prev1 = prev2;
//            prev2 = result;
//        }
//
//        return result;
//    }
//}
//
//    public static void main7(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = fibonacci(n);
//        System.out.println(m);
//    }
//    public static int sumNum(int a, int b){
//        return a + b;
//    }
//    public static double sumNum(double a, double b, double c){
//        return a+b+c;
//    }
//    public static void main2(String[] args) {
//        System.out.println(sumNum(2,3));
//        System.out.println(sumNum(1.2,3.2,5.4));
//    }
//    public static int maxNum(int a, int b){
//        return a > b ? a : b;
//    }
//    public static double maxNum(double a, double b, double c){
//        double maxab = a > b ? a : b;
//        return maxab > c ? maxab : c;
//    }
//    public static void main2(String[] args) {
//        int a = 2;
//        int b = 3;
//        System.out.println(maxNum(a,b));
//        double c = 3.5;
//        System.out.println(maxNum(a,b,c));
//    }

//    public static int fac(int n){
//        if (n == 1){
//            return 1;
//        }
//        int tmp = n * fac(n-1);
//        return tmp;
//    }

//    public static void num(int n){
//        if(n<10){
//            System.out.println(n % 10);
//            return;
//        }
//        num(n/10);
//        System.out.println(n % 10);
//    }
//    public static void main3(String[] args) {
//        System.out.println(fib1(5));
//        System.out.println(fib1(40));
//    }
//    public static int fib1(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if(n == 1){
//            return 1;
//        }
//        return fib1(n - 1) + fib1(n - 2);
//    }
//    public static int fib2(int n){
//        if(n == 1 || n == 2){
//            return 1;
//        }
//        int f1 = 1;
//        int f2 = 1;
//        int f3 = 1;
//        for (int i = 3; i <= n ; i++) {
//            f3 = f1 + f2;
//            f1 = f2;
//            f2 = f3;
//        }
//        return f3;
//    }
//    public static void main23(String[] args) {
//        int[] array = {1,2,3,4};
//        int len = array.length;
////        System.out.println(len);
//        int[] array2 = new int[]{1,2,3,4};
//        int[] array3 = new int[10];
//        int[] array4;
//        array4 = new int[10];
//        int[] array5 = null;
////        int[] array5 = new int[10];
////        System.out.println(array5);
//    }
//
//    public static void main5(String[] args) {
//        //第一种遍历方式
//        int[] array = {1,2,3,4};
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println();
//
//
//        //第二种：增强for循环：for-each
//        for(int x: array){
//            System.out.print(x + " ");
//        }
//        System.out.println();

        //第三种：
//    }
//    public static void func() {
//        int[] array1 = new int[3];
//        array1[0] = 10;
//        array1[1] = 20;
//        array1[2] = 30;
//        int[] array2 = new int[]{1,2,3,4,5};
//        array2[0] = 100;
//        array2[1] = 200;
//        array1 = array2;
//        array1[2] = 300;
//        array1[3] = 400;
//        array2[4] = 500;
//        for (int i = 0; i < array2.length; i++) {
//            System.out.println(array2[i]);
//        }
//    }
//public static void main44(String[] args) {
//    int[] array = {1,2,3,4};
//    /*
//        当我 分开调用func1和 func2
//        func1();
//        func2();
//        array这个数组 里面的值 分别是多少？
//     */
//    //func1(array);
//    func2(array);
//    for (int x : array) {
//        System.out.print(x+" ");
//    }
//    System.out.println();
//
//}
//
//    public static void func1(int[] array) {
//        array[0] = 99;
//    }
//    public static void func2(int[] array) {
//        array = new int[]{11, 22, 33, 44, 55};
//    }
//
//}
