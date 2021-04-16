import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountNumberInArray {
    public static void main(String[] args) {
        //求出数组内所有满足求和等于target的数字组合，每个数字只允许出现一次
        //这种求出所有可能的集合的题目需要进行递归和回溯，设置越界返回和符合条件返回，并且设置深层递归的条件
        //因为数组中的每个数字只允许出现一次，而相同的数字有可能出现很多次，所以将总数组的相同的数组存成哈希表，在调用中是使用for循环来遍历同一个数字的多个次数
        //回溯问题，需要将本次循环添加进数组的新数字移除，这样才能返回上层递归
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<Integer>();
        List<int[]> freq=new ArrayList<int[]>();
        Arrays.sort(candidates);
        for (int nums:candidates){
            if (freq.isEmpty()||nums!=freq.get(freq.size()-1)[0])
                freq.add(new int[]{nums,1});
            else ++freq.get(freq.size()-1)[1];
        }
        DfsOfFindUniqueSumNumber(result,temp,freq,0,target);
        return result;
    }
    public static void DfsOfFindUniqueSumNumber(List<List<Integer>>result,List<Integer> temp,List<int []>freq,int index,int target){
        if (target==0){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        if (index==freq.size()||target<freq.get(index)[0])
            return;
        DfsOfFindUniqueSumNumber(result,temp,freq,index+1,target);
        int time=Math.min(target/freq.get(index)[0],freq.get(index)[1]);
        for (int i=1;i<=time;i++){
            temp.add(freq.get(index)[0]);
            DfsOfFindUniqueSumNumber(result,temp,freq,index+1,target-i*freq.get(index)[0]);
        }
        for (int i=1;i<=time;i++){
            temp.remove(temp.size()-1);
        }
    }
}
