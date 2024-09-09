public class Main {
    public static void main(String[] args) {
        // Create a multilevel cache system with space for 2 cache levels
        MultilevelCache cache = new MultilevelCache(2);

        // Add cache levels (L1 with size 3, L2 with size 2)
        cache.addCacheLevel(3); // L1 cache with 3 entries
        cache.addCacheLevel(2); // L2 cache with 2 entries

        // Insert data into the cache
        cache.put("A", "1");
        cache.put("B", "2");
        cache.put("C", "3");

        // Try to get data from cache
        System.out.println("Get A: " + cache.get("A")); // Should find it in L1
        System.out.println("Get D: " + cache.get("D")); // Will return null (cache miss)

        // Add more data and evict older data
        cache.put("D", "4"); // This will evict one from L1

        // Display current cache status
        cache.displayCache();
    }
}