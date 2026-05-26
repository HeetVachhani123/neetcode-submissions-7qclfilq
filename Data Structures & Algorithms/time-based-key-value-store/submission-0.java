class TimeMap {
    
    // Inner class to pair a timestamp with its corresponding value
    private static class TimeValue {
        int timestamp;
        String value;

        TimeValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<TimeValue>> map;

    /** Initializes the object of the data structure. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    /** Stores the key with the value at the given timestamp. */
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeValue(timestamp, value));
    }
    
    /** Returns a value such that timestamp_prev <= timestamp. */
    public String get(String key, int timestamp) {
        // If the key doesn't exist, return empty string
        if (!map.containsKey(key)) {
            return "";
        }
        
        List<TimeValue> list = map.get(key);
        return binarySearch(list, timestamp);
    }

    // Helper method to perform binary search for the floor timestamp
    private String binarySearch(List<TimeValue> list, int timestamp) {
        int left = 0;
        int right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid).timestamp <= timestamp) {
                // This is a potential candidate, save it
                result = list.get(mid).value;
                // Look for a larger timestamp that might still be <= target timestamp
                left = mid + 1;
            } else {
                // The current timestamp is too large, look to the left
                right = mid - 1;
            }
        }

        return result;
    }
}