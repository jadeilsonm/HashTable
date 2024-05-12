import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        LRUCache<String, Integer> cache = new LRUCache<>(10);

        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);
        cache.put("d", 4);
        cache.put("e", 5);
        cache.put("f", 6);
        cache.put("g", 7);
        cache.put("h", 8);
        cache.put("i", 9);
        cache.put("34", 10);

        System.out.println(cache.get("i"));
        cache.get("34");

    }
}