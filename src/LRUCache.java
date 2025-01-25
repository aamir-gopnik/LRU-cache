import java.util.HashMap;

public class LRUCache<KEY> {

    private static final int CACHE_SIZE = 4;
    private HashMap<KEY,DoublyLinkedList.Node> lruCache;
    private DoublyLinkedList dll;

    public LRUCache(){
        lruCache = new HashMap<>(CACHE_SIZE);
        dll = new DoublyLinkedList<KEY>();
    }


    // We will use the above created doubly linked list for LRU implementation
    // back -> mid -> front
    // new element will be inserted into front and element from back will get removed.
    // all the elements of linked list will be present in HashMap also.
    // In case of Cache Hit -> element will be moved to front of Linked List

    public void printCacheContent(){
        if(dll.size > 0)
        {
            dll.printElements();
        }
    }

    // Function will be called when Data is Requested from Cache
    public KEY getdata(KEY requestedData)
    {
        if(lruCache.containsKey(requestedData)){
            System.out.println("Data present in cache -> Moving to Front of Cache " + requestedData);
            DoublyLinkedList.Node currentNode = lruCache.get(requestedData);
            dll.moveToFront(currentNode);
            return requestedData;
        }
        else
            {
                //considering that data is present in persistence or main source
                System.out.println("Data NOT present in cache -> Inserting to Front of Cache " + requestedData);

                if(lruCache.size() >= CACHE_SIZE)
                {
                    System.out.println("CACHE SIZE FULL, EVICTING LEAST RECENTLY USED ELEMENT");
                    dll.removeElement();
                    DoublyLinkedList.Node newFrontNode = dll.insertElement(requestedData);
                    lruCache.put(requestedData,newFrontNode);
                }
                else
                {
                    System.out.println("CACHE NOT FULL, INSERTING IN CACHE");
                    DoublyLinkedList.Node tailNode = dll.insertElement(requestedData);
                    lruCache.put(requestedData,tailNode);
                }

            }
        return requestedData;
    }





}
