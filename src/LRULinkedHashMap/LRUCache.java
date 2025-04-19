package LRULinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<Key, Value> {

    private int cacheCapacity;

    private float LOAD_FACTOR = 1F;

    public LRUCache(int capacity) {
        this.cacheCapacity = capacity;
    }

    private Map<Key,Value> cacheMap = new LinkedHashMap<>(cacheCapacity,LOAD_FACTOR,true);

    public void printCache() {
        System.out.println(cacheMap);
    }

    public boolean addDataToCache(Key key, Value value) {
        if(cacheMap.containsKey(key))
        {
            updateCacheValue(key,value);
            return true;
        }
        if(cacheMap.size() == cacheCapacity)
        {
            System.out.println("CACHE FULL : DID LRU EVICTION");
            Key firstElementKey = cacheMap.entrySet().iterator().next().getKey();
            cacheMap.remove(firstElementKey);
            cacheMap.put(key, value);
            printCache();
            return true;
        }
        else {
            cacheMap.put(key, value);
            return true;
        }
    }

    public Value getDataFromCache(Key key) {
        Value v = cacheMap.get(key);
        System.out.println("Data accessed from cache -> " + v);
        printCache();
        return v;
    }

    public boolean updateCacheValue(Key key, Value value) {
        if(cacheMap.containsKey(key))
        {
            cacheMap.put(key,value);
            System.out.println("CACHE MAP UPDATED FOR -> " + key);
            System.out.println(cacheMap);
            return true;
        }
        else {
            return false;
        }

    }
}
