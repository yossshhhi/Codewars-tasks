package five_kyu;

public class Node {
    private Node next;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static Node createChain(int piece, int loop) {
        Node head = new Node(0);
        Node temp = head;
        Node headLoop = null;
        for (int i = 1; i < piece + loop; i++) {
            if (i == piece) {
                headLoop = new Node(i);
                temp.setNext(headLoop);
                temp = temp.getNext();
                continue;
            }
            temp.setNext(new Node(i));
            temp = temp.getNext();
        }
        temp.setNext(headLoop);
        return head;
    }
}
