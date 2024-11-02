import javax.swing.text.html.parser.Parser;
import java.util.Arrays;

public class leetCode {
    public static void main(String[] args){
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        String st = "";
        for (int i = 0;i < digits.length; i++){
            st = st + digits[i];
        }
        int sum = Integer.parseInt(st) + 1;
        String de = String.valueOf(sum);
        System.out.println("String is : " + de.charAt(1));
        int[] newArray = new int[de.length()];
        System.out.println("array length : " + newArray.length);
        for (int i = 0;i<de.length();i++){
            newArray[i] = Character.getNumericValue(de.charAt(i));
        }
        System.out.println(Arrays.toString(newArray));
    }
}
