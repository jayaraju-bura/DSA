// Implement HashTable
public class HashTable<K, V>{
    private HashMapEntry <K, V>[]  buckets;
    private int capacity;
    private int size = 0;
    private double loadfactor = 0.75;
    
    public HashTable() {
        this(32);
    }
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new HashMapEntry[this.capacity];
    }
    public void put(K key, V value) {
        
        if (size == loadfactor * capacity) {
            HashMapEntry<K, V>[] old = buckets;
            capacity *= 2;
            size = 0;
            buckets = new HashMapEntry[capacity];
            for(HashMapEntry<K, V>entry : old){
                while(entry != null){
                    put(entry.key, entry.value);
                    entry = entry.next;
                }
            }
            
        }
        
        HashMapEntry <K, V> entry = new HashMapEntry<>(key, value, null);
        int index = getHash(key) % getBucketSize();
        HashMapEntry <K, V> existing = buckets[index];
        if (existing == null){
            buckets[index] = entry;
            size++;
        }
        else {
            while(existing.next != null){
                if(existing.key.equals(key)) {
                    existing.value = value;
                }
                existing = existing.next;
            }
            if(existing.key.equals(key)){
                existing.value = value;
            }
            else{
                existing.next = entry;
                size++;
            }
        }
        
    }
    
    public V get(K key){
        HashMapEntry<K, V>bucket = buckets[getHash(key) % getBucketSize()];
        while(bucket != null) {
            if(bucket.key == key){
                return bucket.value;
            }
        }
        return null;
    }
    public int size() {
        return size;
    }
    
    public int getHash(K key) {
        return (key == null)? 0: Math.abs(key.hashCode());
    }
    public int getBucketSize() {
        return buckets.length;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(HashMapEntry entry : buckets) {
            sb.append("[");
            while(entry != null) {
                sb.append(entry);  
                if(entry.next != null){
                    sb.append(",");
                }
                entry = entry.next;
                
            }
            sb.append("]");
            
        }
        return "{" + sb.toString() + "}";
        
    }
    
    
    static class HashMapEntry<K, V> {
        final K key;
        V value;
        HashMapEntry <K, V> next;
        public HashMapEntry(K key, V value, HashMapEntry<K, V>next) {
            this.key = key;
            this.value = value;
            this.next = next;
            
        }
        
        public K getKey() {
            return key;
            
        }
        public V getValue() {
            return value;
        }
        public HashMapEntry <K, V> getNext() {
            return next;
        }
        
        @Override
        public int hashCode() {
            int hash = 13;
            hash = 17 * hash + ((key == null) ? 0: key.hashCode());
            hash = 17 * hash + ((value == null) ? 0: value.hashCode());
            return hash;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj == this){
                return true;
            } 
            if (obj instanceof HashMapEntry) {
                
                HashMapEntry entry = (HashMapEntry) obj;
                return key.equals(entry.getKey()) && value.equals(entry.getValue());
                
            }
            else
            {
                return false;
            }
            
        }
        
        @Override
        public String toString() {
            return "{" + key +  " , " +  value + "}";
        }
    }
    
    public static void main() {
        System.out.println("Hello world");
        HashTable<String, String> myMap = new HashTable<>();
        myMap.put("USA", "Washington DC");
        myMap.put("Nepal", "Kathmandu");
        myMap.put("India", "New Delhi");
        myMap.put("Australia", "Sydney");
    }
    
}
