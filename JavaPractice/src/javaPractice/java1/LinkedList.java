package javaPractice.java1;

public class LinkedList {

    int count; //개수
    private ListNode head; //헤더


    public LinkedList() {
        count = 0;
        head = null;

    }

    public ListNode addElm(String data) {
        ListNode node;
        if (head == null) { //헤더가 비어 있을 경우. 즉 최초 삽입.

            node = new ListNode(data);
            head = node; //헤더에 String 데이터가 들어가고 다음링크는 null;
        } else { //아닐경우 즉 , 최초 삽입이 아닐경우.
            node = new ListNode(data);//일단 데이터를 넣어주고,
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;   //null일경우 값 넣어주기.
        }
        count++;
        return node;
    }

    public ListNode insertElm(String data, int position) {

        ListNode node = new ListNode(data);


        ListNode tempNode = head;
        ListNode preNode = null;


        if (position < 0 || position > count) {
            return null;
        }

        if (position == 0) {
            node.next = head;
            head = node; //헤더자리에 들어갔으니까 헤더가 된다.
        } else {

            for (int i = 0; i < position; i++) {
                preNode = tempNode;
                tempNode = tempNode.next;
            }

            node.next = preNode.next;
            preNode.next = node;
        }
        count++;
        return node;
    }


    public ListNode removeElm(int position) {


        ListNode preNode = null;
        ListNode tempNode = head;
        if (position < 0) {
            System.out.println("0보다 작을 수 없습니다.");
        }
        if (position == 0) {
            head = tempNode.next;
        } else {

            for (int i = 0; i < position; i++) {
                preNode = tempNode;
                tempNode = tempNode.next;
            }

            preNode.next = tempNode.next;
        }
        count--;

        return tempNode;
    }

    public void printNode(){
        if(count ==0){
            System.out.println("출력할 요소가 없습니다.");
            return ;
        }
        ListNode temp = head;
        while(temp != null){

            System.out.print(temp.getData());//요소값을 뱉는다.
            temp = temp.getNext();
            if(temp != null){

                System.out.print("=>");
            }
        }

    }
}
