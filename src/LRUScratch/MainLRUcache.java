package LRUScratch;

public class MainLRUcache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache<String>();
        //{1 ,2, 3, 4}
        lruCache.getdata("a");
        lruCache.printCacheContent();

        lruCache.getdata("b");
        lruCache.printCacheContent();

        lruCache.getdata("c");
        lruCache.printCacheContent();

        lruCache.getdata("b");
        lruCache.printCacheContent();

        lruCache.getdata("d");
        lruCache.printCacheContent();

        lruCache.getdata("e");
        lruCache.printCacheContent();

        lruCache.getdata("f");
        lruCache.printCacheContent();

        lruCache.getdata("e");
        lruCache.printCacheContent();

        lruCache.getdata("g");
        lruCache.printCacheContent();


    }
}
