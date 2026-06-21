package utils;

public class Pair<K, V> {

    private K key;
    private V value;

    // Constructor
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Getter
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    // Setter
    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    // Static method: Hoán đổi key và value
    public static <K, V> Pair<V, K> swap(Pair<K, V> pair) {
        return new Pair<>(pair.getValue(), pair.getKey());
    }

    // Static method: So sánh value của 2 Pair
    public static <K, V extends Comparable<V>> int comparePairs(
            Pair<K, V> p1,
            Pair<K, V> p2) {

        return p1.getValue().compareTo(p2.getValue());
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}