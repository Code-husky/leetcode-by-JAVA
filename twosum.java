import java.util.HashMap;
import java.util.Map;

public class twosum {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        int len=nums.length;
        for (int i=0;i<len;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
