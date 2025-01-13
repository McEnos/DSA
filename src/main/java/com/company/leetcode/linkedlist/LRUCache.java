package com.company.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 * <p>
 * 146 LRU Cache
 * <p>
 * put ensures that if the cache exceeds capacity, the least recently used node is removed.
 * uses a HashMap for O(1) lookups and a doubly linked list to maintain the order of usage.
 * The head and tail dummy nodes simplify insertion and deletion logic.
 */
public class LRUCache {
    //This is a custom class to represent each node in the doubly linked list.
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity; // The maximum number of items the cache can hold.
    private final Map<Integer, Node> map; //A HashMap that stores the mapping between keys and nodes for O(1) access.
    // Dummy nodes that represent the start and end of the doubly linked list to make insertion and removal easier.
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;  // Update the value
            remove(node); // Remove node from its current position
            insertAtHead(node);  // Move it to the front (most recently used)
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key); // Remove the least recently used node from the map
                remove(tail.prev);  // Remove the node from the linked list
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);  // Add new node to the map
            insertAtHead(newNode);  // Insert it at the head (most recently used)
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node); // Remove node from its current position
        insertAtHead(node); // Insert the node at the head of the linked list to mark it as most recently used.
        return node.value;
    }

    /**
     * This method removes a node from the doubly linked list by updating the prev and next pointers of the adjacent nodes.
     * Make the new node’s next point to the current first node (head.next).
     * Update the prev pointer of the current first node to the new node.
     * Update the next pointer of the head to the new node.
     * Set the prev pointer of the new node to the head.
     */
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * This method inserts a node at the head of the linked list
     * @param node
     */
    private void insertAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
