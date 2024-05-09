import java.util.LinkedList;

public class HashTable<Key, Value> {
    private Integer sizeMix = 10;
    private LinkedList<KeyValue<Key, Value>>[] table;
    private Integer size;

    public HashTable(int sizeMix) {
        this.sizeMix = sizeMix;
        size = 0;
        table = (LinkedList<KeyValue<Key, Value>>[]) new LinkedList[sizeMix];
        for (int i = 0; i < sizeMix; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % sizeMix;
    }

    public void put(Key key, Value val) {
        int i = hash(key);
        for (KeyValue<Key, Value> kv : table[i]) {
            if (kv.key.equals(key)) {
                kv.value = val;
                return;
            }
        }
        table[i].add(new KeyValue<>(key, val));
        size++;
    }

    public Value get(Key key) {
        int i = hash(key);
        for (KeyValue<Key, Value> kv : table[i]) {
            if (kv.key.equals(key)) {
                return kv.value;
            }
        }
        return null;
    }

    public void delete(Key key) {
        int i = hash(key);
        for (KeyValue<Key, Value> kv : table[i]) {
            if (kv.key.equals(key)) {
                table[i].remove(kv);
                size--;
                return;
            }
        }
    }

    public void update(Key key, Value val) {
        int i = hash(key);
        for (KeyValue<Key, Value> kv : table[i]) {
            if (kv.key.equals(key)) {
                kv.value = val;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    private static class KeyValue<Key, Value> {
        Key key;
        Value value;

        public KeyValue(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}



