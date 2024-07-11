import java.util.HashMap;

public class LRUCache {

    private static final int CACHE_SIZE = 4;
    private HashMap<Integer,DoublyLinkedList.Node> lruCache;
    private DoublyLinkedList dll;

    public LRUCache(){
        lruCache = new HashMap<>(CACHE_SIZE);
        dll = new DoublyLinkedList();
    }


    // we will use the above created doubly linked list for LRU implementation
    // head -> mid -> tail
    // new element will be inserted into tail and head element will get removed.
    // all the elements of linked list will be present in HashMap also.

    public void printCacheContent(){
        if(dll.size > 0)
        {
            /*lruCache.entrySet().stream().forEach(set ->
            {
                System.out.print(set.getValue().data + " ");
            });
            System.out.println();*/
            dll.printElements();
        }
    }

    public int getdata(int requestedData)
    {
        if(lruCache.containsKey(requestedData)){
            System.out.println("Data present in cache -> " + requestedData);
            DoublyLinkedList.Node currentNode = lruCache.get(requestedData);
            dll.moveToTail(currentNode);
            return requestedData;
        }
        else
            {
                //considering that data is present in persistence or main source
                System.out.println("Data NOT present in cache -> " + requestedData);

                if(lruCache.size() > CACHE_SIZE)
                {
                    dll.removeElement();
                    DoublyLinkedList.Node tailNode = dll.insertElement(requestedData);
                    lruCache.put(requestedData,tailNode);
                }
                else
                {
                    DoublyLinkedList.Node tailNode = dll.insertElement(requestedData);
                    lruCache.put(requestedData,tailNode);
                }

            }
        return requestedData;
    }





}
