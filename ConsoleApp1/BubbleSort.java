import java.util.Arrays;

public class BubbleSort {
    public static int[] sortList(int[] arr){
        for (int i = 0;i<arr.length-1;i++){
            boolean swapped = false;
            for (int j = 0;j< arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            System.out.println(i + "th iteration : " + Arrays.toString(arr));
            if (!swapped)
                break;
        }
        return arr;
    }
    public static void main(String[] args){
        int arr[] = {7,8,3,1,2};
        arr = sortList(arr);
        System.out.println(Arrays.toString(arr));
    }
}
