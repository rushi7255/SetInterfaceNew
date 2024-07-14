package com.assignment;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running Set Operations:");
        SetOperations.main(args);

        System.out.println("\nRunning Performance Analysis:");
        PerformanceAnalysis.main(args);

        System.out.println("\nDemonstrating Conference functionality:");
        demonstrateConference();
    }

    private static void demonstrateConference() {
        Conference conference = new Conference();

        // Add attendees
        conference.addAttendee(new Person(1, "Rushi", 25));
        conference.addAttendee(new Person(2, "Saru", 30));
        conference.addAttendee(new Person(3, "Charlie", 35));
        conference.addAttendee(new Person(4, "Akki", 40));
        conference.addAttendee(new Person(1, "Dk", 25)); // Duplicate

        System.out.println("Duplicate attendees: " + conference.findDuplicateAttendees());
        System.out.println("Unique attendees: " + conference.listUniqueAttendees());
        System.out.println("Attendees between 30 and 40: " + conference.findAttendeesInAgeRange(30, 40));
    }
}