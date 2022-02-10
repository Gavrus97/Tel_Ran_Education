import java.util.*;

public class CustomTreeSet<T> implements CustomSet<T> {


    Comparator<T> comparator;
    private final Object o = new Object();
    Map<T,Object> source;

    public CustomTreeSet(Comparator<T> comparator){
        this.comparator = comparator;
        this.source = new TreeMap<>(comparator);
    }

    @Override
    public boolean add(T elt) {
        return source.put(elt, o) == null;
    }

    @Override
    public boolean remove(T elt) {
        return source.remove(elt) != null;
    }

    @Override
    public boolean contains(T elt) {
        return source.containsKey(elt);
    }

    @Override
    public void addAll(Set<T> another) {
        for(T elt : another){
            this.add(elt);
        }
    }

    @Override
    public void removeAll(Set<T> another) {
        for(T elt : another){
            this.remove(elt);
        }
    }

    @Override
    public void retainAll(Set<T> another) {
        TreeMap<T, Object> newSource = new TreeMap<>(comparator);
        for(T elt : another){
            if (source.containsKey(elt)){
                newSource.put(elt,o);
            }
        }
        source = newSource;
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public Iterator<T> iterator() {
        return source.keySet().iterator();
    }
}
