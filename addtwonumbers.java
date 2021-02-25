public class addtwonumbers {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode first=l1;
        ListNode second=l2;
        ListNode result=new ListNode(0);
        ListNode temp=result;
        int sum,flag=0;
        while (first!=null&&second!=null){
            sum=0;
            int num1=first.val;
            int num2=second.val;
            sum=num1+num2+flag;
            temp.next=new ListNode(sum%10);//增加新的节点
            flag=sum/10;//储存有没有进位
            first=first.next;
            second=second.next;
            temp=temp.next;
        }
        if (first!=null&&second==null){
            while (first!=null){
                sum=0;
                sum=first.val+flag;
                temp.next=new ListNode(sum%10);
                flag=sum/10;
                first=first.next;
                temp=temp.next;
            }
        }
        if (first==null&&second!=null){
            while (second!=null){
                sum=0;
                sum=second.val+flag;
                temp.next=new ListNode(sum%10);
                flag=sum/10;
                second=second.next;
                temp=temp.next;
            }
        }
        if (flag==1) temp.next=new ListNode(1);
        return result.next;

    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
