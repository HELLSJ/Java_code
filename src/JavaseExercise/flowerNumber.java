package JavaseExercise;
//求 0–999 中所有水仙花数（Armstrong Number）
//水仙花数 = 三位数，每一位立方和 = 自己
//例如：153 = 1? + 5? + 3?

public class flowerNumber {
    public static void main(String[] args) {
        for(int i=0;i<999;i++){
            int a = i/100;
            int b = (i/10) % 10;
            int c = i%10;
            int sum = a*a*a+b*b*b+c*c*c;

            if(sum==i){
                System.out.println(i);
            }
        }
    }
}
