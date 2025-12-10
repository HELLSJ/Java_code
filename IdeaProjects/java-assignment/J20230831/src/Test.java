public class Test {
    public static void main(String[] args) {
        int[][] array = new int[2][];
        array[0] = new int[]{1,2};
        array[1] = new int[]{1,2,3};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
