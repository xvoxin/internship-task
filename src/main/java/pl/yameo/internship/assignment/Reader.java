package main.java.pl.yameo.internship.assignment;

import java.util.Scanner;

public class Reader {

    private Scanner scanner;

    public Reader(){
        scanner = new Scanner(System.in);
    }

    public Integer readInteger() {
        Integer value = null;

        while (value == null) {
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
            } else {
                scanner.next();
            }
        }
        return value;
    }

    public Double readDouble(){
        Double value = null;

        while (value == null) {
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
            } else {
                scanner.next();
            }
        }
        return value;
    }
}
