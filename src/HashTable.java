import java.util.LinkedList;

public class HashTable {

    private LinkedList<KeyValue> table;
    private Integer size;
    private Integer sizeMix = 10;

    public void put(String key, Object value) {}

    public void get(String key) {}

    public void remove(String key) {}
}

class KeyValue<T> {
    private String key;
    private LinkedList<T> value;
}


