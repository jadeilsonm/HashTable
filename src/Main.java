public class Main {
    public static void main(String[] args) {

        LRUCache<String, String> cache = new LRUCache<>(10);

        cache.put("a", "Maria");
        cache.put("b", "João");
        cache.put("c", "Carlos");
        cache.put("d", "Pedro");
        cache.put("e", "Thiago");
        cache.put("f", "Victor");
        cache.put("z", "Lucas");
        cache.put("h", "Gabriel");
        cache.put("><", "Rafael");
        cache.put("34", "Marcos");
        cache.put(";?", "Miguel");
        cache.put("34", "Joaquim");
        System.out.println(cache.get("g"));
        cache.put("==", "Jair");
        cache.put("]    ", "Bill");
        cache.put("34", "Lula");
        System.out.println(cache.get(";?"));
    }
}