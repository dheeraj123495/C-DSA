public class maxSubArraySum {
    public static int maxSum(int[] nums){
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];

            max=Math.max(sum,max);
            if(sum<0) sum=0;
        }
        return max;
    }
    public static void main(String[] args){
        int[] arr = {5,4,-1,7,8};
        System.out.println("Max Sum : " + maxSum(arr));
    }
}
