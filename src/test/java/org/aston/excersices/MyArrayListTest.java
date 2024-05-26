package org.aston.excersices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyArrayListTest {
    private MyArrayList<Integer> myArrayList;

    @BeforeEach
    public void setUp() {
        myArrayList = new MyArrayList<>();
    }

    @Test
    public void shouldIncreaseSizeAfterAddingElements() {
        Assertions.assertEquals(0, myArrayList.size());
        for (int i = 0; i < 500; i++) {
            myArrayList.add(i);
        }
        Assertions.assertEquals(500, myArrayList.size());
    }

    @Test
    void shouldReturnCorrectElementAtIndex() {
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        Assertions.assertEquals(10, myArrayList.get(0));
        Assertions.assertEquals(20, myArrayList.get(1));
        Assertions.assertEquals(30, myArrayList.get(2));
    }

    @Test
    public void shouldInsertElementAtCorrectIndex() {
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.addAtIndex(1, 2);
        Assertions.assertEquals(2, myArrayList.get(1));
        Assertions.assertEquals(3, myArrayList.size());
    }

    @Test
    public void testShouldRemoveElementByValue() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.removeByValue(2);
        Assertions.assertEquals(2, myArrayList.size());
        Assertions.assertEquals(3, myArrayList.get(1));
    }

    @Test
    public void shouldRemoveElementAtIndex() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.removeAtIndex(0);
        Assertions.assertEquals(2, myArrayList.size());
        Assertions.assertEquals(2, myArrayList.get(0));
    }

    @Test
    public void shouldReplaceElementAtIndex() {
        myArrayList.add(2);
        myArrayList.add(4);
        myArrayList.add(6);
        myArrayList.set(0, 3);
        Assertions.assertEquals(3, myArrayList.size());
        Assertions.assertEquals(3, myArrayList.get(0));
    }

    @Test
    public void shouldClearAllElements() {
        for (int i = 0; i < 1000; i++) {
            myArrayList.add(i);
        }
        myArrayList.clear();
        Assertions.assertEquals(0, myArrayList.size());
    }

    @Test
    void shouldSortElementsInAscendingOrder() {
        myArrayList.add(100);
        myArrayList.add(10);
        myArrayList.add(50);
        myArrayList.add(5);
        myArrayList.sort(Integer::compareTo);
        Assertions.assertEquals(5, myArrayList.get(0));
        Assertions.assertEquals(10, myArrayList.get(1));
        Assertions.assertEquals(50, myArrayList.get(2));
        Assertions.assertEquals(100, myArrayList.get(3));
    }

    @Test
    void shouldThrowExceptionWhenGetOutOfBounds() {
        myArrayList.add(1);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(1));
    }

    @Test
    void shouldThrowExceptionWhenRemoveAtIndexOutOfBounds() {
        myArrayList.add(1);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.removeAtIndex(1));
    }

    @Test
    void shouldThrowExceptionWhenSetOutOfBounds() {
        myArrayList.add(1);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.set(10, 3));
    }
}
