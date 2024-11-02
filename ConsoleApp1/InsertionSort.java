import java.util.Arrays;

public class InsertionSort {
    public static void insertionSorting(int[] arr){
        for (int i = 1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;
            while (j >=0 && key < arr[j]){
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args){
            int[] arr = {5,2,1,6,9,8,3};
        insertionSorting(arr);
    }
}
