package LRULinkedHashMap;

public class MainClient {

    public static void main(String[] args) {
        LRUCache<Integer,String> cache = new LRUCache<>(4);
        cache.addDataToCache(1,"aamir");
        cache.addDataToCache(2,"rashid");
        cache.addDataToCache(3,"owais");
        cache.addDataToCache(4,"danish");

        cache.printCache();
        cache.getDataFromCache(1);
        cache.addDataToCache(5, "kamaal");
        cache.addDataToCache(4, "dan");
    }
}
