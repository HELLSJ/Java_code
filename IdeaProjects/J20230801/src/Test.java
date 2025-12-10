import java.util.Scanner;

public class Test {
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        while(count != 0){
            System.out.println("请输入密码，你还有 " + count + " 次机会！");
            String password = scanner.nextLine();
            if(password.equals("1234")){
                System.out.println("登陆成功");
            }else{
                System.out.println("密码错误");
            }
        }
    }

    public static void main8(String[] args) {
        for (int i = 0; i < 999999; i++) {
            int count = 0;//计算i有几位数
            int tmp = i;
            while(i != 0){
                count++;
                i = i / 10;
            }
            //count的值是多少位数 i还是没有变的
            //计算i的每一位
            tmp = i;
            int sum = 0;
            while(tmp != 0){
                sum += Math.pow(tmp % 10, count);
                tmp /= 10;

            }
            if (sum == i){
                System.out.println(i);
            }
        }
    }

    public static void main5(String[] args) {
        int n = 15;
        int count = 0;
        while(n != 0){
            count++;
            n = n&(n-1);
        }
        System.out.println(count);
    }
    public static int sum(int a, int b){//形参
        //System.out.println(a+b);
        return a+b;
    }
//    public static void main3(String[] args){
//
//        String s;
//
//        System.out.println("s="+s);
//
//    }
    public static void main44(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("交换前: a = " + a + " b = " + b);
        swap(a, b);
        System.out.println("交换后: a = " + a + " b = " + b);
    }
    public static void swap(int x, int y) {
        int tmp = x;
        x = y;
        y = tmp;
    }
    public static void main25(String[] args) {
        int[] arr = {10, 20};
        swap(arr);
        System.out.println("arr[0] = " + arr[0] + " arr[1] = " + arr[1]);
    }
    public static void swap(int[] arr) {
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }
//    创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
//
//    要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
    public static void main(String[] args) {

    }
}
// 运行结果
//arr[0] = 20 arr[1] = 10







