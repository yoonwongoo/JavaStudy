package javaPractice.java1;

public class ListNode {

    private String data;//자료
    public ListNode next;//다음노드를 가르키는 링크

    public ListNode(){
        data = null; //기본생성자는 기본적으로 null을 가진다.
        next = null;

    }

    public ListNode(String data){
        this.data = data;
        this.next = null;//자료만 들어온 경우는 다음노드를 가르키는 링크 X
    }

    public ListNode(String data, ListNode next){
        this.data = data;//자료
        this.next = next; //다음노드 링크
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }

}
