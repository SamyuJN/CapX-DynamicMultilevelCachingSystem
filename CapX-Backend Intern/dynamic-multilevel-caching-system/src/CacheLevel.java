// CacheLevel.java
public class CacheLevel {
    private final String[] keys;
    private final String[] values;
    private final int size;
    private int count; // To track how many items are currently in the cache

    // Check if the cache is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Constructor to initialize the cache size
    public CacheLevel(int size) {
        this.size = size;
        this.keys = new String[size];
        this.values = new String[size];
        this.count = 0;
    }

    // Get data from the cache
    public String get(String key) {
        for (int i = 0; i < count; i++) {
            if (keys[i].equals(key)) {
                // Move the found item to the front (most recently used)
                String value = values[i];
                moveToFront(i);
                return value;
            }
        }
        return null; // Cache miss
    }

    // Put data into the cache
    public void put(String key, String value) {
        // Check if the key is already in the cache
        for (int i = 0; i < count; i++) {
            if (keys[i].equals(key)) {
                // Update the value and move it to the front
                values[i] = value;
                moveToFront(i);
                return;
            }
        }

        // If cache is full, remove the least recently used (last element)
        if (count == size) {
            removeLast();
        }

        // Insert the new key-value pair at the front
        insertAtFront(key, value);
    }

    // Move an item to the front (most recently used)
    private void moveToFront(int index) {
        String key = keys[index];
        String value = values[index];
        // Shift all elements to the right of the index
        for (int i = index; i > 0; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[0] = key;
        values[0] = value;
    }

    // Remove the last (least recently used) item from the cache
    private void removeLast() {
        keys[count - 1] = null;
        values[count - 1] = null;
        count--; // Just reduce the count to remove the last item
    }

    // Insert a new key-value pair at the front
    private void insertAtFront(String key, String value) {
        if (count == size) {
            // If cache is full, do not insert
            return;
        }
        // Shift all elements to the right
        for (int i = count; i > 0; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[0] = key;
        values[0] = value;
        count++; // Increment the count to reflect the new item
    }

    // Display the current cache status
    public void displayCache() {
        System.out.println("Cache Status:");
        for (int i = 0; i < count; i++) {
            System.out.println("Key: " + keys[i] + ", Value: " + values[i]);
        }
    }

    public static void main(String[] args) {
        CacheLevel cache = new CacheLevel(5);
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        cache.displayCache();
        System.out.println("Get key1: " + cache.get("key1"));
        cache.displayCache();
        cache.put("key4", "value4");
        cache.put("key5", "value5");
        cache.put("key6", "value6");
        cache.displayCache();
    }
}