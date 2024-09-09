class MultilevelCache {
    private final CacheLevel[] cacheLevels;
    private int levelCount;

    // Constructor to initialize with a maximum number of levels
    public MultilevelCache(int maxLevels) {
        this.cacheLevels = new CacheLevel[maxLevels];
        this.levelCount = 0;
    }

    // Add a new cache level
    public void addCacheLevel(int size) {
        if (levelCount < cacheLevels.length) {
            cacheLevels[levelCount] = new CacheLevel(size);
            levelCount++;
        }
    }

    // Get data from cache, starting from L1
    public String get(String key) {
        for (int i = 0; i < levelCount; i++) {
            String value = cacheLevels[i].get(key);
            if (value != null) {
                // Move data to higher levels (L1) if found in lower levels
                promoteToHigherLevels(key, value, i);
                return value;
            }
        }
        System.out.println("Cache miss! Data not found.");
        return null;
    }

    // Put data into L1 cache
    public void put(String key, String value) {
        if (levelCount > 0) {
            cacheLevels[0].put(key, value); // Always insert in L1
        }
    }

    // Promote data to higher levels
    private void promoteToHigherLevels(String key, String value, int currentLevel) {
        if (currentLevel > 0) {
            cacheLevels[currentLevel - 1].put(key, value);
        }
    }

    // Display all levels of cache
    public void displayCache() {
        for (int i = 0; i < levelCount; i++) {
            System.out.print("Level " + (i + 1) + ": ");
            if (cacheLevels[i].isEmpty()) {
                System.out.println("Cache is empty");
            } else {
                cacheLevels[i].displayCache();
            }
        }
    }
}