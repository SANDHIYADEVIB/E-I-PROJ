package Creational_pattern.Singleton_pattern;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    private static CacheManager instance;
    private Map<String, String> cache;

    private CacheManager() {
        cache = new HashMap<>();
    }

    public static synchronized CacheManager getInstance() {
        if (instance == null) {
            instance = new CacheManager();
        }
        return instance;
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public void remove(String key) {
        cache.remove(key);
    }

    public void clear() {
        cache.clear();
    }

    @Override
    public String toString() {
        return "CacheManager{" +
                "cache=" + cache +
                '}';
    }
}
