//获取一个数二进制序列中的偶数位和奇数位
//
//「偶数位」= bit0、bit2、bit4...
//「奇数位」= bit1、bit3、bit5...



package JavaseExercise;

import java.util.Scanner;

public class getOddAndEvenBit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //0000 0010
        for (int i = 31; i >= 1 ; i-=2) {
            System.out.print(((n>>>i) & 1) + " " );
        }
        System.out.println();
        for (int i = 30; i >= 0 ; i-=2) {
            System.out.print(((n>>>i) & 1) + " " );
        }
    }

}
