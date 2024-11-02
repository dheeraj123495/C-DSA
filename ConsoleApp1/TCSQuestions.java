import java.lang.reflect.Array;
import java.util.Arrays;

public class TCSQuestions {
    public static void reverseString(String st){
        String st1 = "";
        for (int i = st.length()-1;i>=0;i--){
            st1 = st1 + st.charAt(i);
        }
        System.out.println(st + " reverse String is : " + st1);
    }
    public static boolean isPalindrom(String st){
        int start = 0;
        int end = st.length()-1;
        while (start < end){
            if(st.charAt(start) == st.charAt(end)){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }
    public static void factorial(int num){
        if(num == 0){
            System.out.println("Factorial is " + 1);
            return;
        }else {
            int res = 1;
            while (num > 0){
                res = res * num;
                num--;
            }
            System.out.println("Factorial is " + res);
        }
    }
    public static void binarySearch(int[] arr,int ele){
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = low+(high-low)/2;
            if (arr[mid] == ele){
                System.out.println("Element found in position : " + mid);
                return;
            }
            if (arr[mid] < ele){
                low = mid + 1;
            }
            else {
                high = mid -1 ;
            }
        }
        System.out.println("Element not found");
    }

    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length-1;i++){
            boolean isSorted = false;
            for (int j = 0; j < arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    isSorted = true;
                }
            }
            if(!isSorted){
                break;
            }
        }
        System.out.println("Sorted array  : " + Arrays.toString(arr));
    }
    public static void maxElement(int[] nums){
        int maxElement = nums[0];
        for (int i = 1; i < nums.length; i++){
            if(maxElement < nums[i]){
                maxElement = nums[i];
            }
        }
        System.out.println("Max element is : " + maxElement);
    }
    public static void sumOfNum(int num){
        int sum = 0;
        int digit = 0;
        while(num > 0){
            digit = num % 10;
            sum = sum + digit;
            num = num / 10;
        }
        System.out.println("Sum is : " + sum);
    }
    public static void main(String[] args){
        //Reverse a String
//        String st = "Dheeraj";
//        reverseString(st);

        //Check if string is palindrome
//        String st = "abxbsa";
//        if(isPalindrom(st)){
//            System.out.println(st + " is palindrome");
//        }else{
//            System.out.println(st + " is not palindrome");
//        }


        //Factorial of a number
//        int num = 6;
//        factorial(num);

        //Binary search
//        int[] arr = {1,3,5,2,7,9,30};
//        Arrays.sort(arr);
//        int searchElement = 3;
//        binarySearch(arr,searchElement);

        //Bubble sort
//        int[] arr = {7,8,3,1,2};
//        bubbleSort(arr);

        //Find max element in array
//        int[] arr = {5,3,7,1,7};
//        maxElement(arr);

        int num = 125;
        sumOfNum(num);

    }
}
