package com.shnud.noxray.Structures;

import java.util.Iterator;

/**
 * Created by Andrew on 26/12/2013.
 */
public class SynchHashMapArrayList<K, T> extends HashMapArrayList<K, T> {

    public SynchHashMapArrayList() {
        super();
    }

    @Override
    public void add(K key, T object) {
        super.add(key, object);
    }

    @Override
    public void remove(K key) {
        super.remove(key);
    }

    @Override
    public T get(K key) {
        return super.get(key);
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean containsKey(K key) {
        return super.containsKey(key);
    }

    @Override
    public Iterator<T> iterator() {
        return super.iterator();
    }

    @Override
    public void clear() {
        super.clear();
    }

    private class SynchHashMapArrayListIterator implements Iterator<T> {

        private int index = -1;

        @Override
        public boolean hasNext() {
            synchronized (SynchHashMapArrayList.this) {
                if(index + 1 < _list.size())
                    return true;

                return false;
            }
        }

        @Override
        public T next() {
            synchronized (SynchHashMapArrayList.this) {
                return _list.get(++index);
            }
        }

        @Override
        public void remove() {
            synchronized (SynchHashMapArrayList.this) {
                _hashMap.remove(_list.get(index));
                _list.remove(index);
                index--;
            }
        }
    }
}
