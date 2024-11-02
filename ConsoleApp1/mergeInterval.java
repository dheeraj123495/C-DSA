import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeInterval {
    public static int[][] merge(int[][] in){
        if(in == null || in.length <= 1){
            return in;
        }
        Arrays.sort(in,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> m = new ArrayList<>();
        int c[] = in[0];
        for (int i=1;i<in.length;i++){
            if(in[i][0]<=c[1]){
                c[1] = Math.max(c[1],in[i][1]);
            }
            else {
                m.add(c);
                c=in[i];
            }
        }
        m.add(c);
        return m.toArray(new int[m.size()][]);
    }
    public static void main(String[] args){
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        arr = merge(arr);
        System.out.println("Merged interval is :");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
