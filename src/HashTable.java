import java.util.Arrays;
import java.util.LinkedList;

public class HashTable<Key, Value> {
    private Integer sizeMix;
    private LinkedList<KeyValue<Key, Value>>[] table;
    private Integer size;

    public HashTable(Integer sizeMix) {
        this.sizeMix = sizeMix;
        size =  0;
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
                if (kv.value != null) {
                    var value = kv.value;
                }
                kv.value = val;
                return;
            }
        }
        if (table[i].size() >= 5) {
            table[i].removeLast();
        }
        table[i].addFirst(new KeyValue<>(key, val));
        size++;
    }

    public Value get(Key key) {
        return getAndSynchronize(key);
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "table=" + Arrays.toString(table) +
                '}';
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
        getAndSynchronize(key);
    }

    public int size() {
        return size;
    }

    private Value getAndSynchronize(Key k) {
        int i = hash(k);
        Value result = (Value) "Não existe";
        for (KeyValue<Key, Value> kv : table[i]) {
            if (kv.key.equals(k)) {
                result = kv.value;
                table[i].remove(kv);
                table[i].addFirst(kv);
                System.out.println(table[i]);
                break;
            }
        }
        return result;
    }

    public LinkedList<KeyValue<Key, Value>>[] getTable() {
        return table;
    }

    public static class KeyValue<Key, Value> {
        Key key;
        Value value;

        public KeyValue(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "KeyValue{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}



