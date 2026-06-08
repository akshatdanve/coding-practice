import java.util.*;

class Entry {
    String key;
    int value;
    Entry next;

    Entry(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap {
    Entry[] buckets;
    int capacity;
    int size;

    MyHashMap() {
        capacity = 16;
        size = 0;
        buckets = new Entry[capacity];
    }

    int hashFunction(String key) {
        int hash = 0;

        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 31 + key.charAt(i)) % capacity;
        }

        return hash;
    }

    void put(String key, int value) {
        int index = hashFunction(key);

        // Empty bucket
        if (buckets[index] == null) {
            buckets[index] = new Entry(key, value);
            size++;
            return;
        }

        // Check if key already exists
        Entry curr = buckets[index];

        while (curr != null) {
            if (curr.key.equals(key)) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        // Key not found, append at end
        curr = buckets[index];

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = new Entry(key, value);
        size++;
    }

    int get(String key) {
        int index = hashFunction(key);

        Entry curr = buckets[index];

        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1;
    }
    
    void remove(String key){
        int index = hashFunction(key);
        Entry prev = null;
        Entry curr = buckets[index];
        
        while(curr!=null){
            if(curr.key.equals(key)){
                if(prev==null){
                    buckets[index]=curr.next;
                }
                else{
                    prev.next=curr.next;
                }
                size--;
                return;
            }
            prev=curr;
            curr=curr.next;
            
        }
    }
}

public class Main {
    public static void main(String[] args) {

        MyHashMap map = new MyHashMap();

        map.put("apple", 3);
        System.out.println(map.get("apple"));

        map.put("apple", 10);
        System.out.println(map.get("apple"));
        map.remove("apple");
        System.out.println(map.get("apple"));
    }
}
