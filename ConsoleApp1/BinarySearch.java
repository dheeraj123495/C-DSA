import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static int searchElement(int[] arr,int length,int ele){
        int low = 0;
        int high = length-1;
        while (low <= high){
            int mid = low+(high-low)/2;
            if (arr[mid] == ele){
                return mid+1;
            }
            if (arr[mid] < ele){
                low = mid + 1;
            }
            else {
                high = mid -1 ;
            }        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,3,5,2,7,9,30};
        Arrays.sort(arr);
        System.out.println("Enter element to search");
        int searchEle = sc.nextInt();
        int pos = searchElement(arr,arr.length,searchEle);
        System.out.println(pos);
        if (pos>0){
            System.out.println("Element found at position : " + pos);
        }
        else {
            System.out.println("Search element not found");
        }
    }
}
