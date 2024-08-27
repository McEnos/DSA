package com.company.collection;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Collection<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

       /* if (strings.contains("one")) {
            System.out.println("one is here");
        }

        if (!strings.contains("three")) {
            System.out.println("three is not here");
        }
        Collection<String> first = new ArrayList<>();
        first.add("one");
        first.add("four");*/

        //Collection<String> second = new ArrayList<>();
        //second.add("one");
        //second.add("four");

        //System.out.println("Is the first contained is strings? "+ strings.containsAll(first));
        //System.out.println("Is second contained in strings? "+strings.containsAll(second));
        //boolean hasChanged = strings.addAll(first);

        //System.out.println("Has strings changed? " + hasChanged);
        //System.out.println("strings= " + strings);

        Collection<String> toBeRemoved = new ArrayList<>();
        toBeRemoved.add("one");
        toBeRemoved.add("four");

        //boolean hasChanged = strings.removeAll(toBeRemoved);
        //System.out.println("Has strings changed? " + hasChanged);
        //System.out.print("strings = " + strings);

        Collection<String> toBeRetained = new ArrayList<>();
        toBeRetained.add("one");
        toBeRetained.add("four");

        boolean hasChanged = strings.retainAll(toBeRetained);

        System.out.println("Has strings changed? " + hasChanged);
        System.out.println("strings = " + strings);

        //strings.clear();
        String[] array = strings.toArray(new String[]{});
        System.out.println("converted array " + Arrays.toString(array));
        //System.out.println("strings after clearing "+strings);

        Predicate<String> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNullOrEmpty = isNull.or(isEmpty);

        Collection<String> strings1 = new ArrayList<>(); //List.of(null,"","one","two","","three",null);
        strings1.add(null);
        strings1.add("");
        strings1.add("one");
        strings1.add("two");
        strings1.add("");
        strings1.add("three");
        strings1.add(null);
        System.out.println("strings1 = " + strings1);
        strings1.removeIf(isNullOrEmpty);
        System.out.println("filtered strings1 = " + strings1);

        Collection<String> strings2 = List.of("one", "two", "three");

        for (String element : strings2) {
            System.out.println(element);
        }
        Collection<String> strings3 = List.of("one", "two", "three", "four");

        for (Iterator<String> iterator = strings3.iterator(); iterator.hasNext(); ) {
            String element = iterator.next();
            if (element.length() == 3) {
                System.out.println(element);
            }
        }

        for (int i : new Range(0, 5)) {
            System.out.println("i = " + i);
        }

        List<String> strings4 = List.of("one", "two", "three", "four", "five", "six");
        Set<String> set = new HashSet<>();
        set.addAll(strings4);

        SortedSet<String> strings5 = new TreeSet<>(Set.of("z", "k", "a", "b", "c", "d", "e", "f"));

        System.out.println(strings5);

        NavigableSet<String> sortedStrings = new TreeSet<>(Set.of("a", "b", "c", "d", "e", "f"));
        System.out.println(sortedStrings);
        NavigableSet<String> descendingSet = sortedStrings.descendingSet();
        System.out.println(descendingSet);

        List<String> immutableStrings = List.of("one", "two", "three", "four", "five");
        Set<String> immutableSet = Set.of("one", "two", "three", "five");
        System.out.println(immutableSet);

        List<String> listFromArray = Arrays.asList("one", "two", "three", "four");

        listFromArray.add("six");

        System.out.println(listFromArray);

        Queue<String> queue = new ArrayDeque<>();
        queue.poll();
        Deque<String> deque = new ArrayDeque<>();


        Map<Integer, String> map1 = Map.of(
                1, "one",
                2, "two",
                3, "three"
        );
        Map.Entry<Integer, String> e1 = Map.entry(1, "one");
        Map.Entry<Integer, String> e2 = Map.entry(2, "two");
        Map.Entry<Integer, String> e3 = Map.entry(3, "three");

        // Collections.min(listFromArray, Comparator.comparing((v1,v2) -> v1.compareTo(v2));

        /**
         *Collections Framework is a set of classes and interfaces in Java
         * that provides implementations of common data structures like lists,
         * sets, maps, etc., along with algorithms to manipulate them.
         * common components of the Collections Framework are:
         * 1) Collection Interface: The root interface in the collection hierarchy.
         * 2) List Interface: The ordered collection (sometimes called a sequence).It extends the Collection interface.
         *     Implementation classes: ArrayList: Resizable-array implementation of the List interface.
         *     LinkedList:doubly linked list implementation of List, Vector: , Stack
         * allows duplicate elements.
         * 3) Set Interface: A collection that cannot contain duplicate elements.It extends the Collection interface.
         *    Implementation classes:
         *    HashSet: Uses a hash table to store elements.
         *    TreeSet: Uses a Red-Black tree to store elements, providing ordered traversal.
         *    SortedSet Interface: A Set that maintains its elements in ascending order.
         * 4) Map Interface: An object that maps keys to values. A map cannot contain duplicate keys.Does not extend the Collection interface.
         *   Implementation classes:
         *   HashMap: Uses a hash table to store key-value pairs.
         *   TreeMap: Uses a Red-Black tree to store key-value pairs, providing ordered traversal.
         *   SortedMap Interface: A Map that maintains its mappings in ascending key order.
         *   LinkedHashMap: Implements the Map interface, backed by a linked list (actually a LinkedHashMap instance).
         *   Hashtable: Implements the Map interface with a hash table (actually a HashMap instance).
         * <p>
         * 5) Queue Interface: A collection used to hold multiple elements prior to processing. Besides basic Collection operations.
         *   Implementation classes:
         *   PriorityQueue: An unbounded priority queue based on a priority heap.
         *   BlockingQueue Interface: A Queue that additionally supports operations that wait for the queue to become non-empty when retrieving an element,
         *   and wait for space to become available in the queue when storing an element.
         * 6) Deque Interface: A linear collection that supports element insertion and removal at both ends.
         * 7) Iterator Interface: An object that enables iteration over a collection.
         * 8) ListIterator Interface: An iterator for lists that allows the programmer to traverse the list in either direction,
         * modify the list during iteration, and obtain the iterator's current position in the list.
         */
    }
}
