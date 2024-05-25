package org.example;

import java.util.Comparator;

/**
 * MyList is a custom interface representing a dynamic list of elements.
 * It provides methods for adding, accessing, removing, and modifying elements in the list.
 *
 * @param <T> the type of elements stored in the list
 */
public interface MyList<T> extends Iterable<T> {
    /**
     * Adds an element to the end of the list.
     *
     * @param t the element to add
     */
    void add(T t);

    /**
     * Adds an element at the specified index in the list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     *
     * @param index the index at which to add the element
     * @param t     the element to add
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void addAtIndex(int index, T t);

    /**
     * Gets the element at the specified index.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T get(int index);

    /**
     * Removes the first occurrence of the specified element from the list, if it is present.
     * If the list does not contain the element, it is unchanged.
     *
     * @param t the element to be removed
     */
    void remove(T t);

    /**
     * Removes the element at the specified index from the list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void removeAtIndex(int index);

    /**
     * Replaces the element at the specified index with the specified element.
     *
     * @param index   the index of the element to replace
     * @param element the new element to be stored at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void set(int index, T element);

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    int size();

    /**
     * Removes all elements from the list, leaving it empty.
     */
    void clear();

    /**
     * Sorts the elements of the list according to the specified comparator.
     * The sorting algorithm used may vary depending on the implementation.
     * Implementations are encouraged to use efficient sorting algorithms such as quicksort
     *
     * @param comparator the comparator to determine the order of the elements
     */
    void sort(Comparator<? super T> comparator);

}
