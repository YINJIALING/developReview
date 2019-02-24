package deadlineNewYear;

public class 链表中环的入口结点 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
		ListNode res=null;
        if(pHead==null||pHead.next==null)
        		return res;
        ListNode p1=pHead;
        ListNode p2=pHead;
        while(p2!=null&&p2.next!=null) {//注意这里的条件
        		p1=p1.next;
        		p2=p2.next.next;
        		if(p1==p2) {//找相聚点
        			p1 = pHead;
                    while(p1!=p2){
                        p1 = p1.next;
                        p2 = p2.next;//找环的入口
                        //TODO 为什么第二次相遇就是环的入口
                    }
                    return p1;
        		}
        		
        }
       return res;
    }

}
