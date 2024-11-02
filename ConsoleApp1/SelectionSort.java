import java.util.Arrays;

public class SelectionSort {
    public static int[] selectSortList(int[] arr){
        int size = arr.length;
        for (int step = 0;step < size-1;step++){
            int low_index = step;
            for (int j = step+1;j<size;j++){
                if (arr[j] < arr[low_index])
                {
                    low_index = j;
                }
            }
            int temp = arr[step];
            arr[step] = arr[low_index];
            arr[low_index] = temp;
        }
        return arr;
    }
    public static void main(String[] args){
        int[] arr = {7,8,3,1,2};
        arr = selectSortList(arr);
        System.out.println(Arrays.toString(arr));
    }
}
