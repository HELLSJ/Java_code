import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main4(String[] args) {
        Random random = new Random(123);// 默认随机种子是系统时间
        int randNum = random.nextInt(100);//[0,100)
        System.out.println("生成的随机数字："+ randNum);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入要猜的数字：");
            int num = scanner.nextInt();
            if (num > randNum){
                System.out.println("猜大了");
            }else if(num < randNum){
                System.out.println("猜小了");
            }else{
                System.out.println("猜对了");
                break;
            }
        }
    }


        public static void main5(String[] args) {
            int count = 0;
            for (int i = 1; i <= 100; i++) {
                count += countDigit(i);
            }
            System.out.println(count);
        }

        public static int countDigit(int num) {
            int count = 0;
            while (num > 0) {
                if (num % 10 == 9) {
                    count++;
                }
                num /= 10;
            }
            return count;
        }

    public static void main24(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if(i / 10 == 9){
                count++;
            }
            if(i%10==9){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
    }

    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入要判断的数字: ");
            int num = scanner.nextInt();
            boolean isPrime = isPrimeNumber(num);

            if (isPrime) {
                System.out.println(num + " 是素数。");
            } else {
                System.out.println(num + " 不是素数。");
            }
        }
    }
    public static boolean isPrimeNumber(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main9(String[] args) {
        int a = 20;
        int b = 40;
        int gcd = calculateGCD(a,b);
        System.out.println(gcd);
    }
    public static int calculateGCD(int n, int m){
        while (m != 0){
            int tmp = m;
            m = n % m;
            n = tmp;
        }
        return n;
    }

    public static void main6(String[] args) {
        double result = result();
        System.out.println(result);
    }
    public static double result(){
        double sum = 0.0;
        int n = 100;
        for (int i = 1; i <= n; i++) {
            if(i % 2 == 0){
                sum -= 1.0/i;
            }else{
                sum += 1.0/i;
            }
        }
        return sum;

    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            printXPattern(n);
        }
    }

    public static void printXPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i == (n - j - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main2(String[] args) {
        final String correctPassword = "password";
        int maxAttempts = 3;
        Scanner scanner = new Scanner(System.in);

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("请输入密码：");
            String inputPassword = scanner.nextLine();

            if (inputPassword.equals(correctPassword)) {
                System.out.println("登录成功");
                break;
            } else {
                System.out.println("密码错误，请重新输入。剩余尝试次数：" + (maxAttempts - attempt));
            }
        }

        System.out.println("退出程序");
    }
    public static void main23(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个整数n：");
        int n = scanner.nextInt();

        if (n > 0) {
            MultiplicationTable(n);
        } else {
            System.out.println("请输入大于0的整数。");
        }
    }

    public static void MultiplicationTable(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int product = i * j;
                System.out.print(product + "\t");
            }
            System.out.println();
        }
    }

}




