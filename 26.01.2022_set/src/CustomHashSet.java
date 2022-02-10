import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CustomHashSet<T> implements CustomSet<T> {

    private final Object o = new Object();
    private HashMap<T, Object> source = new HashMap<>();

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
        HashMap<T, Object> newSource = new HashMap<>();
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
