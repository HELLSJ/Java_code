public class Test {
    String s;

    public static int add(int a,int b) {
        return a+b;
    }

    public static int add(int a,int b,int c) {
        return a+b+c;
    }

//    public static int add(int[] array) {
//        int ret = 0;
//        for (int x: array) {
//            ret += x;
//        }
//        return ret;
//    }

    /**
     * ...可变参数
     * @param array
     * @return
     */

    public static int add(int... array){
        int ret = 0;
        for (int x: array) {
            ret += x;
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(add(array));
        System.out.println(add(new int[]{1, 3, 4, 5, 6}));
    }
}
