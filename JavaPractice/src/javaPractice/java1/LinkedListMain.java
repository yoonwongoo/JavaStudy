package javaPractice.java1;

public class LinkedListMain {

    public static void main(String[]args) {

        LinkedList lL = new LinkedList();

        lL.addElm("1");

        lL.addElm("2");
        lL.insertElm("5",2);
        lL.printNode();
    }
}
