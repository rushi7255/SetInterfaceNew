package com.assignment;

import java.util.*;

public class PerformanceAnalysis {
    private static final int NUM_ELEMENTS = 1_000_000;

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        // Measure add performance
        long hashSetAddTime = measureAddPerformance(hashSet);
        long linkedHashSetAddTime = measureAddPerformance(linkedHashSet);

        // Measure contains performance
        long hashSetContainsTime = measureContainsPerformance(hashSet);
        long linkedHashSetContainsTime = measureContainsPerformance(linkedHashSet);

        // Measure remove performance
        long hashSetRemoveTime = measureRemovePerformance(hashSet);
        long linkedHashSetRemoveTime = measureRemovePerformance(linkedHashSet);

        // Print results
        System.out.println("Performance Analysis (time in milliseconds):");
        System.out.println("Operation\t\tHashSet\t\tLinkedHashSet");
        System.out.println("Add\t\t\t" + hashSetAddTime + "\t\t" + linkedHashSetAddTime);
        System.out.println("Contains\t\t" + hashSetContainsTime + "\t\t" + linkedHashSetContainsTime);
        System.out.println("Remove\t\t\t" + hashSetRemoveTime + "\t\t" + linkedHashSetRemoveTime);
    }

    private static long measureAddPerformance(Set<Integer> set) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            set.add(i);
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long measureContainsPerformance(Set<Integer> set) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            set.contains(i);
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long measureRemovePerformance(Set<Integer> set) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            set.remove(i);
        }
        return System.currentTimeMillis() - startTime;
    }
}