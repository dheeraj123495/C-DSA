import java.util.*;
import java.lang.*;
class stringEndocing
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            String s=sc.next();
            String result="";
            for (int i=0;i<n ;i+=2 ){
                if(s.charAt(i)=='0' && s.charAt(i+1)=='0'){
                    result+="A";
                }else if (s.charAt(i)=='0' && s.charAt(i+1)=='1') {
                    result+="T";
                }else if (s.charAt(i)=='1' && s.charAt(i+1)=='0'){
                    result+="C";
                }else {
                    result+="G";
                }
            }
            System.out.println(result);
        }
    }
}

