public class MainLRUcache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        //{1 ,2, 3, 4}
        lruCache.getdata(1);
        lruCache.printCacheContent();

        lruCache.getdata(2);
        lruCache.printCacheContent();

        lruCache.getdata(3);
        lruCache.printCacheContent();

        lruCache.getdata(1);
        lruCache.printCacheContent();

        lruCache.getdata(4);
        lruCache.printCacheContent();

        lruCache.getdata(3);
        lruCache.printCacheContent();


    }
}
