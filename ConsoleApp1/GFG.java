
import java.util.*;
public class GFG {
    public static int longestConsecutive(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> s = new HashSet<>();
        for (int a:nums){
            s.add(a);
        }
        int m1=0;
        for (int b:s){
            if(!s.contains(b-1)){
                int cn=b;
                int c1=1;
                while (s.contains(cn+1)){
                    cn++;
                    c1++;
                }
                m1=Math.max(m1,c1);
            }
        }
        return m1;
    }
    public static void main(String[] args){
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        System.out.println("Longest Consecutive Sequence : " + longestConsecutive(arr));
    }
}
