public class DoublyLinkedList {
    private static final int LL_SIZE = 4;
    static Node head;
    static Node tail;
    int size = 0;
    static class Node {
        int data;
        Node prev;
        Node next;
        public Node(int value){
            this.data = value;
        }
    }

    //insertion will at tail only (Order of insert)
    public Node insertElement(int value){
        Node newNode = new Node(value);
        if(tail == null)
        {
            head = tail = newNode;
            size++;
            return tail;
        }
            newNode.prev = tail;
            newNode.prev.next = newNode;
            if(size < LL_SIZE) {
                size++;
            }
            else {
                head = head.next;
            }
            return tail = newNode;
        }

    public void printElements()
    {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //removal will from head only (Order of insert)
    public int removeElement(){
        if(head == null)
        {
            return -1;
        }
        if(head.next != null)
        {
            int data = head.data;
            head = head.next;
            return data;
        }
        size--;
        return -1;
    }

    //Move element to tail when cache accessed
    public void moveToTail(Node node)
    {
        if(tail == node)
        {
            return;
        }
        Node temp = node;
        if(head == node)
        {
            node.prev = tail;
            tail.next = node;
            tail = node;
            head = head.next;
            node.next = null;
            return;

        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        insertElement(temp.data);
    }


}