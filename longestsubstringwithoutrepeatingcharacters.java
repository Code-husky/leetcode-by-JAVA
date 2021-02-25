import java.util.HashSet;
import java.util.Set;

public class longestsubstringwithoutrepeatingcharacters {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstring(String s){
        int result=0,flag=0;
        Set<Character> window=new HashSet<Character>();
        for (int i=0;i<s.length();i++){
            if (i!=0) window.remove(s.charAt(i-1));
            while(flag<s.length()&&!window.contains(s.charAt(flag))){
                window.add(s.charAt(flag));
                flag++;
            }
            result=Math.max(result,flag-i);
        }
        return result;
    }
}
