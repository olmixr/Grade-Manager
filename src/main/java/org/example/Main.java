package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("Menu\nGrade - Manager");


    }

    public static void main(String[] args) {

        printMenu();
        System.out.println("Enter number: ");
        int number = scan.nextInt();


        while (true) {
            switch (number) {
                case 1:
                    System.out.println("1");
                    break;

                case 2:
                    System.out.println("2");
                    break;
                default:
                    break;
            }
        }
    }
}

