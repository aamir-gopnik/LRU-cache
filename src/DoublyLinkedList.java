public class DoublyLinkedList<E> {
    private static final int LL_SIZE = 4;
    Node front;
    Node back;
    int size = 0;
    class Node<E> {
        E data;
        Node prev;
        Node next;
        public Node(E value){
            this.data = value;
        }
    }

    //insertion will at front only (Order of insert)
    public Node insertElement(E value){
        Node newNode = new Node(value);
        if(front == null)
        {
            front = back = newNode;
            size++;
            return front;
        }
            newNode.prev = front;
            newNode.prev.next = newNode;
            if(size < LL_SIZE) {
                size++;
            }
            else {
                front = front.next;
            }
            return front = newNode;
        }

    public void printElements()
    {
        Node temp = back;
        System.out.print("B -> ");
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(" <- F");
        System.out.println();
    }

    //removal will be done from back only (Order of insert)
    public E removeElement(){
        if(back == null)
        {
            System.out.println("Exception: Data not found for removal");
        }
        if(back.next != null)
        {
            E data = (E) back.data;
            back = back.next;
            return data;
        }
        size--;
        return null;
    }

    //Move element to Front when cache accessed
    public void moveToFront(Node node)
    {
        if(front == node)
        {
            return;
        }
        Node temp = node;
        if(back == node)
        {
            back = node.next;
            node.prev = null;
            insertElement((E) temp.data);
            return;

        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        insertElement((E) temp.data);
    }


}