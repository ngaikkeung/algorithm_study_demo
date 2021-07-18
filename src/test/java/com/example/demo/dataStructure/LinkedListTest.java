package com.example.demo.dataStructure;

import com.example.demo.GeneralUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LinkedListTest {

    private static final int SIZE = 10000;

    @Test
    public void testPushFront() {
        LinkedList linkedList = new LinkedList();
        int[] randomIntArray = GeneralUtils.getRandomIntArray(SIZE, 0, 1000);

        Arrays.stream(randomIntArray).forEach(linkedList::pushFront);

        linkedList.printList();

        Assertions.assertEquals(SIZE, linkedList.count());
    }

    @Test
    public void testPushBack() {
        LinkedList linkedList = new LinkedList();
        int[] randomIntArray = GeneralUtils.getRandomIntArray(SIZE, 0, 1000);

        Arrays.stream(randomIntArray).forEach(linkedList::pushBack);

        linkedList.printList();

        Assertions.assertEquals(SIZE, linkedList.count());
    }

    @Test
    public void testDelete() {
        LinkedList linkedList = new LinkedList();

        int[] randomIntArray = GeneralUtils.getRandomIntArray(SIZE, 0, 1000);

        Arrays.stream(randomIntArray).forEach(linkedList::pushBack);

        linkedList.delete(randomIntArray[0]);
        Assertions.assertEquals(SIZE - 1, linkedList.count());

        linkedList.delete(randomIntArray[SIZE - 1]);
        Assertions.assertEquals(SIZE - 2, linkedList.count());
    }

    @Test
    public void testClear() {
        LinkedList linkedList = new LinkedList();

        int[] randomIntArray = GeneralUtils.getRandomIntArray(SIZE, 0, 1000);

        Arrays.stream(randomIntArray).forEach(linkedList::pushBack);

        linkedList.delete(randomIntArray[0]);
        Assertions.assertEquals(SIZE - 1, linkedList.count());

        linkedList.clear();
        Assertions.assertEquals(0, linkedList.count());
    }

    @Test
    public void testReverse() {
        LinkedList linkedList = new LinkedList();

        int[] randomIntArray = GeneralUtils.getRandomIntArray(10, 0, 1000);
        Arrays.stream(randomIntArray).forEach(linkedList::pushBack);

        linkedList.printList();
        linkedList.reverse();
        linkedList.printList();
    }
}
