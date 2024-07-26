
public class LRUCache<key, value> {

    private HashTable<key, value> hashTable;

    public LRUCache(Integer capacity)  {
        this.hashTable = new HashTable<key, value>(capacity);
    }

    public void put(key k, value v) {
        this.hashTable.put(k, v);
    }

    public value get(key k) {
        return hashTable.get(k);
    }

    public void delete(key k) {
        this.hashTable.delete(k);
    }

    public void update(key k, value v) {
        this.hashTable.update(k, v);
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "hashTable=" + hashTable +
                '}';
    }

}
