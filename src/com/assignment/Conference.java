package com.assignment;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Conference {
    private Set<Person> attendees;

    public Conference() {
        this.attendees = new HashSet<>();
    }

    public void addAttendee(Person person) {
        attendees.add(person);
    }

    public void removeAttendee(Person person) {
        attendees.remove(person);
    }

    public Set<Person> findDuplicateAttendees() {
        Set<Integer> seenIds = new HashSet<>();
        return attendees.stream()
                .filter(p -> !seenIds.add(p.getId()))
                .collect(Collectors.toSet());
    }

    public Set<Person> listUniqueAttendees() {
        return new HashSet<>(attendees);
    }

    public Set<Person> findAttendeesInAgeRange(int minAge, int maxAge) {
        return attendees.stream()
                .filter(p -> p.getAge() >= minAge && p.getAge() <= maxAge)
                .collect(Collectors.toSet());
    }
}