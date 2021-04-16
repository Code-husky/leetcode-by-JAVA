public class DpOfSubMaxArray {
    public static void main(String[] args) {

    }
    public static int maxSubArray(int[] nums) {
        int result=nums[0];
        int pre=0;
        for (int number:nums){
            pre=Math.max(pre+number,number);
            result=Math.max(result,pre);
        }
        return result;
    }
}
