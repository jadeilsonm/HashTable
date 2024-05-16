import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class LRUCacheTest {

    private LRUCache<String, Integer> cache;

    public LRUCacheTest() {
        cache = new LRUCache<>(10);
    }

    @org.junit.jupiter.api.Test
    void put() {
        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);
        cache.put("d", 4);
        cache.put("e", 5);

        assertEquals(1, cache.get("a"));
        assertEquals(2, cache.get("b"));
    }

    @org.junit.jupiter.api.Test
    void get() {
        assertNotEquals(1, cache.get("zz"));
        cache.put("zz", 1);
        assertEquals(1, cache.get("zz"));
    }

    @org.junit.jupiter.api.Test
    void delete() {
        cache.put("a", 1);
        assertEquals(1, cache.get("a"));
        cache.delete("a");
        assertNull(cache.get("a"));
    }

    @org.junit.jupiter.api.Test
    void update() {
        cache.put("a", 1);
        assertEquals(1, cache.get("a"));
        cache.update("a", 2);
        assertEquals(2, cache.get("a"));
    }

    @org.junit.jupiter.api.Test
    void testLRU() {
        cache.put("g", 9); // ASCII 103
        cache.put("34", 10); // ASCII 103

        System.out.println(cache); // LRUCache{hashTable=HashTable{table=[[], [], [], [KeyValue{key=g, value=9}, KeyValue{key=34, value=10}], [], [], [], [], [], []]}}
        cache.get("34"); // 10
        System.out.println(cache); // LRUCache{hashTable=HashTable{table=[[], [], [], [KeyValue{key=34, value=10}, KeyValue{key=g, value=9}], [], [], [], [], [], []]}}
        // assertEquals(9, cache[0]);
        assertEquals("LRUCache{hashTable=HashTable{table=[[], [], [], [KeyValue{key=34, value=10}, KeyValue{key=g, value=9}], [], [], [], [], [], []]}}", cache.toString());
        cache.get("g"); // 9
        assertEquals("LRUCache{hashTable=HashTable{table=[[], [], [], [KeyValue{key=g, value=9}, KeyValue{key=34, value=10}], [], [], [], [], [], []]}}", cache.toString());
    }

    @BeforeEach
    void setUp() {
        cache = new LRUCache<>(10);
    }
}