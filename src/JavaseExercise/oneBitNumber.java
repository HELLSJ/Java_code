package JavaseExercise;

public class oneBitNumber {
    public static int countOnes(int n) {
        int count = 0;

        while (n != 0) {
            count += (n & 1);  // 查看最低位是否是 1
            n >>= 1;           // 右移一位
        }

        return count;
    }
}
