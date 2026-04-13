package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);



    public static void printMenu() {
        System.out.println(
                "==============================\n" +
                "        GRADE MANAGER\n" +
                "==============================\n" +
                "1. Add grade\n"+
                "2. Show all grades\n"+
                "3. Update grade\n"+
                "4. Remove grade\n"+
                "5. Search grade\n" +
                "6. Sort grades ascending\n" +
                "7. Sort grades descending\n" +
                "8. Show statistics\n" +
                "9. Clear all grades\n" +
                "0. Exit\n"+
                "==============================\n"
                );
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

