package com.nit.travel;
import java.util.ArrayList;
import java.util.Scanner;

class TravelPlanner {
    private static class Destination {
        String name;
        String date;
        String preferences;
        double budget;

        Destination(String name, String date, String preferences, double budget) {
            this.name = name;
            this.date = date;
            this.preferences = preferences;
            this.budget = budget;
        }

        @Override
        public String toString() {
            return "Destination: " + name + 
                   "\nDate: " + date + 
                   "\nPreferences: " + preferences + 
                   "\nBudget: $" + budget;
        }
    }

    private final ArrayList<Destination> destinations = new ArrayList<>();
    private double totalBudget = 0;

    public void addDestination(String name, String date, String preferences, double budget) {
        destinations.add(new Destination(name, date, preferences, budget));
        totalBudget += budget;
    }

    public void displayItinerary() {
        if (destinations.isEmpty()) {
            System.out.println("No destinations added yet.");
            return;
        }

        System.out.println("\n--- Travel Itinerary ---");
        for (int i = 0; i < destinations.size(); i++) {
            System.out.println("Stop #" + (i + 1));
            System.out.println(destinations.get(i));
            System.out.println("-----------------------");
        }
        System.out.println("Total Budget: $" + totalBudget);
    }
}

public class TravelItineraryPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelPlanner planner = new TravelPlanner();
        boolean exit = false;

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (!exit) {
            System.out.println("\n1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter destination name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter travel date (e.g., 2024-11-25): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter preferences (e.g., sightseeing, adventure): ");
                    String preferences = scanner.nextLine();
                    System.out.print("Enter budget for this destination: $");
                    double budget = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    planner.addDestination(name, date, preferences, budget);
                    System.out.println("Destination added successfully!");
                    break;

                case 2:
                    planner.displayItinerary();
                    break;

                case 3:
                    System.out.println("Exiting Travel Itinerary Planner. Have a great trip!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
