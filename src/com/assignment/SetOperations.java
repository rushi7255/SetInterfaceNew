package com.assignment;

import java.util.*;
import java.util.stream.Collectors;

public class SetOperations {
    public static void main(String[] args) {
        Set<Person> hashSet = new HashSet<>();
        Set<Person> linkedHashSet = new LinkedHashSet<>();

        // Add elements to sets
        addPersons(hashSet);
        addPersons(linkedHashSet);

        // Perform set operations
        System.out.println("Union: " + union(hashSet, linkedHashSet));
        System.out.println("Intersection: " + intersection(hashSet, linkedHashSet));
        System.out.println("Difference (hashSet - linkedHashSet): " + difference(hashSet, linkedHashSet));
        System.out.println("Difference (linkedHashSet - hashSet): " + difference(linkedHashSet, hashSet));

        // Find max and min age
        System.out.println("Max age in HashSet: " + findMaxAge(hashSet));
        System.out.println("Min age in HashSet: " + findMinAge(hashSet));

        // Sort persons by age
        List<Person> sortedPersons = sortPersonsByAge(hashSet);
        System.out.println("Sorted persons by age: " + sortedPersons);

        // Filter persons by age
        Set<Person> filteredSet = filterPersonsByAge(hashSet, 30);
        System.out.println("Persons older than 30: " + filteredSet);
    }

    private static void addPersons(Set<Person> set) {
        set.add(new Person(1, "Rushi", 25));
        set.add(new Person(2, "Saru", 30));
        set.add(new Person(3, "Charlie", 35));
        set.add(new Person(4, "Akki", 40));
        set.add(new Person(1, "Dk", 25)); // Duplicate, should not be added
    }

    private static Set<Person> union(Set<Person> set1, Set<Person> set2) {
        Set<Person> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    private static Set<Person> intersection(Set<Person> set1, Set<Person> set2) {
        Set<Person> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    private static Set<Person> difference(Set<Person> set1, Set<Person> set2) {
        Set<Person> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }

    private static int findMaxAge(Set<Person> set) {
        return set.stream().mapToInt(Person::getAge).max().orElse(0);
    }

    private static int findMinAge(Set<Person> set) {
        return set.stream().mapToInt(Person::getAge).min().orElse(0);
    }

    private static List<Person> sortPersonsByAge(Set<Person> set) {
        return set.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
    }

    private static Set<Person> filterPersonsByAge(Set<Person> set, int minAge) {
        return set.stream()
                .filter(p -> p.getAge() > minAge)
                .collect(Collectors.toSet());
    }
}