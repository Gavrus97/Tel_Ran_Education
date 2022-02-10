import java.security.Key;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomHashMap<K, V> implements CustomMap<K, V> {

    private static final double LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 16;
    private int size;
    private Pair<K, V>[] source = new Pair[INITIAL_CAPACITY];

    public CustomHashMap() {
    }


    private static class Pair<K, V> {
        K key;
        V value;
        Pair<K, V> next;

        public Pair(K key, V value, Pair<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    @Override
    public V put(K key, V value) {
        if (size > LOAD_FACTOR * source.length) {
            resize();
        }

        Pair<K, V> pair = findPair(key);


        if (pair == null) {
            int index = findIndex(key);
            pair = new Pair<>(key, value, source[index]);
            source[index] = pair; //если на месте source[index] находился другой элемент то он просто перезапишется ?
            size++;
            return null;
        }
        V res = pair.value;
        pair.value = value;
        return res;
    }

    private void resize() {
        int capacity = source.length * 2;
        Pair<K, V>[] resizedSource = new Pair[capacity];

        for (Pair<K, V> pair : source) {

            Pair<K, V> currentPairInChain = pair;
            while (currentPairInChain != null) {
                Pair<K, V> nextPairInChain = currentPairInChain.next;
                int newIndex = Math.abs(currentPairInChain.key.hashCode()) % resizedSource.length;

                currentPairInChain.next = resizedSource[newIndex];
                resizedSource[newIndex] = currentPairInChain;

                currentPairInChain = nextPairInChain;
            }
        }
        source = resizedSource;
    }


    private int findIndex(K key) {
        return Math.abs(key.hashCode()) % source.length;
    }

    /**
     * returns the pair with the key or null if there is no pair with such a key.
     *
     * @param key key
     * @return Pair<K, V>
     */
    private Pair<K, V> findPair(K key) {
        int index = findIndex(key);

        Pair<K, V> currentPair = source[index];
        while (currentPair != null) {
            if (currentPair.key.equals(key))
                return currentPair;
            currentPair = currentPair.next;

        }
        return null;
    }

    @Override
    public V get(K key) {
        Pair<K, V> currentPair = findPair(key);
        if (currentPair != null)
            return currentPair.value;
        return null;
    }


    public V removeMy(K key) {
        Pair<K, V> currentPair = findPair(key);
        if (currentPair != null) {
            int index = findIndex(key);
            if (source[index].equals(currentPair)) {
                source[index] = currentPair.next;
            } else if (!source[index].equals(currentPair) && currentPair.next == null) {
                Pair<K, V> last = source[index];
                while (!last.equals(currentPair)) {
                    if (last.next.equals(currentPair)) {
                        last.next = null;
                        break;
                    }
                    last = last.next;
                }
            } else if (!source[index].equals(currentPair) && currentPair.next != null) {
                Pair<K, V> prev = source[index];
                Pair<K, V> next = currentPair.next;
                while (!prev.equals(currentPair)) {
                    if (prev.next.equals(currentPair)) {
                        prev.next = next;
                    }
                    prev = prev.next;
                }
            }
            size--;
            return currentPair.value;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = findIndex(key);

        if (source[index] == null)
            return null;

        Pair<K, V> currentPair = source[index];

        if (currentPair.key.equals(key)) {
            V res = currentPair.value;
            source[index] = currentPair.next;
            clearPair(currentPair);
            size--;
            return res;
        }
        while (currentPair.next != null) {
            if (currentPair.next.key.equals(key)) {
                Pair<K, V> next = currentPair.next;
                V res = next.value;
                currentPair.next = next.next;
                clearPair(next);
                size--;
                return res;
            }
            currentPair = currentPair.next;
        }

        return null;
    }

    private void clearPair(Pair<K, V> currentPair) {
        currentPair.key = null;
        currentPair.value = null;
        currentPair.next = null;
    }

    @Override
    public boolean contains(K key) {
        Pair<K, V> currentPair = findPair(key);
        return currentPair != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<K> keyIterator() {
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator<K> {

        int index;
        int pairNumber = 0;
        Pair<K, V> currentPair;

        public KeyIterator() {
            if (size == 0)
                return;

            while ((currentPair = source[index]) == null) {
                index++;
            }


        }

        @Override
        public boolean hasNext() {
            return pairNumber < size;
        }

        @Override
        public K next() {
            if (pairNumber >= size) {
                throw new IndexOutOfBoundsException();
            }

            K res = currentPair.key;

            if (currentPair.next != null) {
                currentPair = currentPair.next;
            } else {
                do {
                    index++;
                } while (index < source.length && (currentPair = source[index]) == null);
            }
            pairNumber++;
            return res;
        }

    }


    @Override
    public Iterator<V> valueIterator() {
        return new ValueIterator();
    }

    private class ValueIterator implements Iterator<V>{

        KeyIterator keyIterator = new KeyIterator();

        @Override
        public boolean hasNext() {
            return keyIterator.hasNext();
        }

        @Override
        public V next() {
            K key = keyIterator.next();
            return get(key);
        }
    }

}
