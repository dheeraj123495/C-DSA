import javax.xml.stream.events.DTD;
import java.util.Scanner;

public class airlineRestriction {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            if(a+b <= d && c<=e){
                System.out.println("Yes");
            }
            else if(b+c <= d && a<=e){
                System.out.println("Yes");
            }
            else if(a+c <= d && b <= e){
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }
}
