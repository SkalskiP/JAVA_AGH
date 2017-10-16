package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class Test {
    // Class contains two fields:
    // LinkedList, that will hold information about points
    // Scanner, that will read input from user
    private static  LinkedList<Punkt3D> punkty = new LinkedList<>();
    private static  Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Variable that will trigger program termination
        boolean running = true;

        // Main loop
        while (running) {
            System.out.print("- - - - - - - - - - - - - - - - - - - - - -\n" +
                    "1. Wczytaj punkt 3D\n" +
                    "2. Wyświetl wszystkie punkty\n" +
                    "3. Oblicz odległość\n" +
                    "4. Zakończ\n" +
                    "- - - - - - - - - - - - - - - - - - - - - -\n");

            System.out.print("Wybierz opcję... ");
            int selected = scanner.nextInt();

            switch (selected) {

                case 1:
                    // Method that reads new point from user and store it inside list
                    zapiszPunkt();
                    break;
                case 2:
                    // Method that prints all stored points
                    wyswietlPunkty();
                    break;
                case 3:
                    // Method that calculates Euclidian distance between points
                    obliczOdleglosc2();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    break;
            }
        }
    }

    private static void wyswietlPunkty() {
        for (Punkt3D punkt :
                punkty) {
            System.out.println(punkty.indexOf(punkt) + ": " + punkt.toString());
        }
    }

    private static void zapiszPunkt() {
        System.out.println("Wpisz po kolei wspołrzędne:");

        System.out.print("X: ");
        double x = scanner.nextDouble();

        System.out.print("Y: ");
        double y = scanner.nextDouble();

        System.out.print("Z: ");
        double z = scanner.nextDouble();

        punkty.add(new Punkt3D(x, y, z));
    }

    private static void obliczOdleglosc() {
        System.out.println("Wybierz punkt z bazy:");
        wyswietlPunkty();
        System.out.println("Wybierz pierwszy punkt: ");
        int first = scanner.nextInt();
        System.out.println("Wybierz drugi punkt: ");
        int second = scanner.nextInt();
        if (first >= punkty.size() || second >= punkty.size() || first < 0 || second < 0) {
            System.out.println("Wprowadzono błędne indeksy");
        } else {
            System.out.println("Odległość między wybranymi punktami wynosi: "
                    + punkty.get(first).distance(punkty.get(second)));
        }
    }

    private static void obliczOdleglosc2() {
        System.out.println("Wybierz punkt z bazy:");
        wyswietlPunkty();
        int first_point = 0;
        int second_point = 0;

        System.out.println("Wybierz pierwszy punkt: ");
        while (first_point == 0) {
            try {
                first_point = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                first_point = 0;
                System.out.println("Nieprawidłowa wartość\n + " +
                                    "Wybierz pierwszy punkt: ");
            }
        }

        System.out.println("Wybierz drugi punkt: ");
        while (second_point == 0) {
            try {
                second_point = Integer.parseInt(scanner.nextLine())1;
            } catch (Exception e) {
                second_point = 0;
                System.out.println("Nieprawidłowa wartość\n + " +
                        "Wybierz drugi punkt: ");
            }
        }

        if (first_point >= punkty.size() || second_point >= punkty.size() || first_point < 0 || second_point < 0) {
            System.out.println("Wprowadzono błędne indeksy");
        } else {
            System.out.println("Odległość między wybranymi punktami wynosi: "
                    + punkty.get(first_point).distance(punkty.get(second_point)));
        }
    }
}
