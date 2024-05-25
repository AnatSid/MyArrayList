package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


class MyArrayListTest {
    private MyArrayList<Integer> myArrayList;

    @BeforeEach
    public void setUp() {
        myArrayList = new MyArrayList<>();
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(0, myArrayList.size());
        for (int i = 0; i < 100; i++) {
            myArrayList.add(i);
        }
        Assertions.assertEquals(100, myArrayList.size());
    }

    @Test
    public void testAdd() {
        for (int i = 0; i < 500; i++) {
            myArrayList.add(i);
        }
        Assertions.assertEquals(500, myArrayList.size());
    }

    @Test
    void testGet() {
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        Assertions.assertEquals(10, myArrayList.get(0));
        Assertions.assertEquals(20, myArrayList.get(1));
        Assertions.assertEquals(30, myArrayList.get(2));
    }

    @Test
    public void testAddAtIndex() {
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.addAtIndex(1, 2);
        Assertions.assertEquals(3, myArrayList.size());
        Assertions.assertEquals(2, myArrayList.get(1));
    }

    @Test
    public void testRemoveByValue() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.remove(2);
        Assertions.assertEquals(2, myArrayList.size());
        Assertions.assertEquals(3, myArrayList.get(1));
    }

    @Test
    public void testRemoveAtIndex() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.removeAtIndex(0);
        Assertions.assertEquals(2, myArrayList.size());
        Assertions.assertEquals(2, myArrayList.get(0));
    }

    @Test
    public void testSet() {
        myArrayList.add(2);
        myArrayList.add(4);
        myArrayList.add(6);
        myArrayList.set(0, 3);
        Assertions.assertEquals(3, myArrayList.size());
        Assertions.assertEquals(3, myArrayList.get(0));
    }

    @Test
    public void testClear() {
        for (int i = 0; i < 1000; i++) {
            myArrayList.add(i);
        }
        myArrayList.clear();
        Assertions.assertEquals(0, myArrayList.size());
    }

    @Test
    void testSort() {
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
    void testSortReverse() {
        for (int i = 50; i >= 1; i--) {
            myArrayList.add(i);
        }
        myArrayList.sort(Integer::compareTo);
        Assertions.assertEquals(1, myArrayList.get(0));
        Assertions.assertEquals(2, myArrayList.get(1));
        Assertions.assertEquals(3, myArrayList.get(2));
    }

    @Test
    void testSortWithStrings() {
        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add("banana");
        stringList.add("apple");
        stringList.add("cherry");
        stringList.sort(String::compareTo);
        Assertions.assertEquals("apple", stringList.get(0));
        Assertions.assertEquals("banana", stringList.get(1));
        Assertions.assertEquals("cherry", stringList.get(2));
    }

    @Test
    void testSortingCustomObjectForAge() {
        MyArrayList<PersonForTest> peopleList = new MyArrayList<>();
        peopleList.add(new PersonForTest("Alex", 25));
        peopleList.add(new PersonForTest("Bob", 30));
        peopleList.add(new PersonForTest("Charlie", 20));

        Comparator<PersonForTest> ageComparator = Comparator.comparing(PersonForTest::getAge);
        peopleList.sort(ageComparator);

        Assertions.assertEquals(20, peopleList.get(0).getAge());
        Assertions.assertEquals(25, peopleList.get(1).getAge());
        Assertions.assertEquals(30, peopleList.get(2).getAge());
    }

    @Test
    void testGetOutOfBoundsIndex() {
        myArrayList.add(1);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(1));
    }

    @Test
    void testRemoveAtIndexOutOfBoundsIndex() {
        myArrayList.add(1);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.removeAtIndex(1));
    }
}
