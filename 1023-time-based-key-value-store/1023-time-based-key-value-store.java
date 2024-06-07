class TimeMap {

    private HashMap<String, TreeMap<Integer, String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new TreeMap<>());
        store.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> map = store.getOrDefault(key, new TreeMap<>());
        Map.Entry<Integer, String> entry = map.floorEntry(timestamp);
        return entry != null ? entry.getValue() : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */