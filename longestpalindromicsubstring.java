public class longestpalindromicsubstring {
    public static void main(String[] args) {
        String s="abc";
        System.out.println(s.substring(1,2));
    }
    public String longestPalindrome(String s){
        int max=0;
        String result=null;
        if(s.length()>0) result=s.substring(0,1);
        for (int i=0;i<s.length();i++){
            int lenEven=centerExpand(s,i,i+1);
            int lenOld=centerExpand(s,i,i);

            if (lenEven<=max&&lenOld<=max) continue;

            if (lenEven>lenOld){
                max=lenEven;
                result=s.substring(i-lenEven/2+1,i+lenEven/2+1);
            }else if (lenOld>lenEven){
                max=lenOld;
                result=s.substring(i-lenOld/2,i+lenOld/2+1);
            }


        }
        return result;
    }
    public int centerExpand(String s,int left,int right){
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return  right-left-1;
    }

}
