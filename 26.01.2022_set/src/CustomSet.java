import java.util.Set;

public interface CustomSet<T> extends Iterable<T>{

    /**
     *
     * @param elt element
     * @return whether the element did not exist in the set
     */
    boolean add(T elt);

    /**
     *
     * @param elt element
     * @return true if the element was removed
     */
    boolean remove(T elt);

    boolean contains(T elt);

    void addAll(java.util.Set<T> another);

    void removeAll(java.util.Set<T> another);

    void retainAll(java.util.Set<T> another);

    int size();

}
