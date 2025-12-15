package Sort;

public class eightSortMethods {
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (array[j]>tmp){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    //œ£∂˚≈≈–Ú
    public static void shellSort(int[] array){
        int gap = array.length;
        while(gap>1) {
            gap /= 2;
            shell(array, gap);
        }
    }

    private static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i-tmp;
            for(;j>=0;j-=gap){
                if (array[j]>tmp){
                    array[j+gap]=array[i];
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    //÷±Ω”—°‘Ò≈≈–Ú
    public static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

}
