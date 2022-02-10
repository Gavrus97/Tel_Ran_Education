package list;

import java.util.Iterator;

public class AdvancedArrayList<T> implements CustomList<T> {

    private T[] source;

    public AdvancedArrayList(){
        source = (T[])new Object[0];
    }

    public AdvancedArrayList(int initialSize){
        source = (T[])new Object[initialSize];
    }

    @Override
    public void set(int index, T value) {
        if (index < 0 || index >= source.length)
            throw new CustomOutOfBoundsException();

        source[index] = value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= source.length)
            throw new CustomOutOfBoundsException();
        return source[index];
    }

    @Override
    public int size() {
        return source.length;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == value)
                return true;
        }
        return false;
    }

    @Override
    public T removeById(int index) {
        if (index < 0 || index >= source.length)
            throw new CustomOutOfBoundsException();

        T[] newSource = (T[])new Object[source.length - 1];
        T res = source[index];

        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }

        for (int i = index; i < newSource.length; i++) {
            newSource[i] = source[i + 1];
        }

        source = newSource;
        return res;
    }

    @Override
    public void insert(int index, T value) {
        if (index < 0 || index > source.length)
            throw new CustomOutOfBoundsException();

        T[] newSource = (T[])new Object[source.length + 1];

        for (int i = 0; i < index; i++) {
            newSource[i] = source[i];
        }
        newSource[index] = value;

        for (int i = index + 1; i < newSource.length; i++) {
            newSource[i] = source[i - 1];
        }

        source = newSource;
    }


    public boolean removeByValue(T value) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == value){
                removeById(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T value) {
        insert(source.length, value);
    }

    @Override
    public void println() {
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator<>(source);
    }

    private static class BasicIterator<E> implements Iterator<E>{

        private E[] array;
        int currentIndex = 0;

        public BasicIterator(E[] source) {
            array = source;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < array.length;
        }

        @Override
        public E next() {
            E res = array[currentIndex];
            currentIndex++;
            return res;
        }
    }
}
