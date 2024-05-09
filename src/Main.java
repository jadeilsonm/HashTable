public class Main {
    public static void main(String[] args) {

        HashTable<String, Integer> hashTable = new HashTable<>(10);
        hashTable.put("A", 1);
        hashTable.put("B", 2);
        hashTable.put("C", 3);
        hashTable.put("D", 4);

        System.out.println(hashTable.get("D"));


    }
}