package org.aston.excersices;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * MyArrayList is a custom implementation of a dynamic array list.
 * It provides methods for adding, accessing, removing, and sorting elements.
 *
 * @param <T> the type of elements stored in the list
 */
public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size = 0;

    /**
     * Constructs an empty MyArrayList with an initial capacity of 10.
     */
    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param someObject the element to add
     */
    @Override
    public void add(T someObject) {
        increaseArray();
        array[size] = someObject;
        size++;
    }

    /**
     * Adds an element at the specified index in the list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     *
     * @param index      the index at which to add the element
     * @param someObject the element to add
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void addAtIndex(int index, T someObject) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        increaseArray();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = someObject;
        size++;
    }

    /**
     * Gets the element at the specified index.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param someObject the element to be removed
     */
    @Override
    public void removeByValue(T someObject) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(someObject)) {
                removeAtIndex(i);
            }
        }
    }

    /**
     * Removes the element at the specified index from the list.
     * Shifts any subsequent elements to the left.
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void removeAtIndex(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    /**
     * Replaces the element at the specified index with the specified element.
     *
     * @param index   the index of the element to replace
     * @param element the new element to be stored at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = element;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the list, leaving it empty.
     */
    @Override
    public void clear() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Sorts the elements of the list using the specified comparator.
     * Uses the quicksort algorithm.
     *
     * @param comparator the comparator to determine the order of the elements
     */
    public void sort(Comparator<? super T> comparator) {
        quicksort(0, size - 1, comparator);
    }

    private void quicksort(int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quicksort(low, pivotIndex - 1, comparator);
            quicksort(pivotIndex + 1, high, comparator);
        }
    }

    private int partition(int low, int high, Comparator<? super T> comparator) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    /**
     * Returns an iterator over the elements in the list.
     *
     * @return an iterator over the elements in the list
     */
    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                T t = array[index];
                index++;
                return t;
            }
        };
    }
}
