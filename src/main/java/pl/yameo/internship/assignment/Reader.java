package main.java.pl.yameo.internship.assignment;

import java.util.Scanner;

public class Reader {

    private Scanner scanner;

    public Reader(){
        scanner = new Scanner(System.in);
    }

    public Integer readInteger() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                scanner.next();
            }
        }
    }

    public Double readDouble(){
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                scanner.next();
            }
        }
    }
}
