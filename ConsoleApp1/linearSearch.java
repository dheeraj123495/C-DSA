import java.util.Scanner;

public class linearSearch {
    public static int searchElement(int[] arr,int length,int ele){
        for (int i=0;i<length-1;i++){
            if(arr[i] == ele){
                return i+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,3,5,2,7,9};
        System.out.println("Enter element to search");
        int searchEle = sc.nextInt();
        int pos = searchElement(arr,arr.length,searchEle);
        if (pos>0){
            System.out.println("Element found at position : " + pos);
        }
        else {
            System.out.println("Search element not found");
        }
    }
}
