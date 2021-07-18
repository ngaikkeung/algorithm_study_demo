package com.example.demo.dataStructure;

public class LinkedList {
    ListNode firstNode;

    public void printList() {
        if (firstNode == null) {
            System.out.println("Linked list is empty");
            return;
        }

        ListNode currentNode = firstNode;
        StringBuilder sb = new StringBuilder();

        while (currentNode != null) {
            sb.append(currentNode.getValue()).append("->");
            currentNode = currentNode.getNext();
        }
        sb.append("null");
        System.out.println(sb);
    }

    public void pushFront(int x) {
        ListNode newNode = new ListNode(x);

        if (firstNode != null) {
            newNode.setNext(firstNode);
        }
        firstNode = newNode;
    }

    public void pushBack(int x) {
        ListNode newNode = new ListNode(x);

        if (firstNode == null) {
            firstNode = newNode;
            return;
        }

        // Traversal to last node
        ListNode currentNode = firstNode;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        // Add new node to last node
        currentNode.setNext(newNode);
    }

    public void delete(int x) {
        if (firstNode == null) {
            return;
        }

        // Value found at first node
        if (firstNode.getValue() == x) {
            firstNode = firstNode.getNext();
            return;
        }

        ListNode previousNode = firstNode;
        ListNode currentNode = firstNode.getNext();
        while (currentNode != null && currentNode.getValue() != x) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            System.out.println(x + " not found in linked list.");
            return;
        }

        previousNode.setNext(currentNode.getNext());
    }

    public void clear() {
        while (firstNode != null) {
            ListNode next = firstNode.getNext();
            firstNode.setNext(null);
            firstNode = next;
        }
    }

    public void reverse() {
        if (firstNode == null || firstNode.getNext() == null) {
            return;
        }

        ListNode previous = null;
        ListNode currentNode = firstNode;
        ListNode nextNode = firstNode.getNext();

        while (nextNode != null) {
            currentNode.setNext(previous);
            previous = currentNode;
            currentNode = nextNode;
            nextNode = currentNode.getNext();
        }

        currentNode.setNext(previous);
        firstNode = currentNode;
    }

    public int count() {
        int count = 0;
        ListNode currentNode = firstNode;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.getNext();
        }

        return count;
    }
}
