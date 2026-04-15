package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Integer> grade = new ArrayList<Integer>();


    public static void addGrade(){
        System.out.println("Enter grade: ");
        int number = scan.nextInt();
        if(0<=number && number<=100) {
            grade.add(number);
        }else {
            System.out.println("Error Grade");
        }
    }

    public static void allGrade(){
        int i = 0;
        for (int s : grade) {
            System.out.println("На номер " + i);
            System.out.println(s);
            System.out.println("-----");
            i++;
        }
    }
    public static void updateGrade(){
        if (!grade.isEmpty()){
            System.out.println("Number index:");
            int index = scan.nextInt();
            System.out.println("Number value: ");
            int value = scan.nextInt();
          if (value >= 0 && value <= 100){
                if (index >= 0 && index <= grade.size()) {
                    grade.set(index, value);
                    System.out.println("Grade value edit!");
                }
            }else System.out.println("Value слишком большой или маленький");
        }
    }

    public static void removeGrade(){
        if (!grade.isEmpty()){
            System.out.println("Number index:");
            int index = scan.nextInt();
                if (index >= 0 && index <= grade.size()) {
                    grade.remove(index);
                    System.out.println("Grade index removed!");
            }else
                System.out.println("индекс не правильный!");
        }
        System.out.println("Нету оценок!");
    }

    public static void searchGrade() {
        int index = 0;
        int sovpad = 0;
        System.out.println("Оценка для поиска:");
        int value = scan.nextInt();
        for (int i : grade) {
            if (i == value) {
                sovpad++;
                System.out.println("Совпадение найдено " + sovpad + " номера " + i + " на позиции: " + index);
            }
            index++;
        }
        if (sovpad == 0) System.out.println("Нету таких оценок!");
    }
    
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
        boolean exit = false;
        while (true) {
            printMenu();
             int number = 0;
            System.out.println("Enter number: ");
            if (scan.hasNextInt()){
               number = scan.nextInt();
            }else {
                System.out.println("Error number!");
                scan.next();
            }

            switch (number) {
                case 1:
                    addGrade();
                    break;
                case 2:
                    allGrade();
                    break;
                case 3:
                    updateGrade();
                    break;
                case 4:
                    removeGrade();
                    break;
                case 5:
                    searchGrade();;
                    break;
                case 6:
                    ;
                    break;
                case 7:
                    ;
                    break;
                case 8:
                    ;
                    break;
                case 9:
                    ;
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    break;
            }
            if (exit == true) break;
        }
        System.out.println("Exit");
    }
}

