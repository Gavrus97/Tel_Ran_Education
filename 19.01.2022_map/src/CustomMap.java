import java.util.Iterator;

public interface CustomMap<K, V>{

    /**
     * The method puts the Value corresponding to the key. If the pair with the key exists,
     * then the value will be replaced
     * @param key not null
     * @param value value
     * @return old value corresponding to the key
     */
    V put(K key, V value);

    /**
     * return the value corresponding to the key. If there is no key, the null will be returned.
     * @param key not null
     * @return value
     */
    V get(K key);

    /**
     * removes the pair with the key and returns the value. Or returns null, if there is no such a key.
     * @param key key
     * @return value
     */
    V remove(K key);

    /**
     * returns true if there is a pair with the key, false otherwise.
     * @param key not null
     * @return true or false
     */
    boolean contains(K key);

    int size();

    Iterator<K> keyIterator();

    Iterator<V> valueIterator();



}
