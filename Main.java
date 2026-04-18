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

    public static void bubbleSortAsc() {
        if (!grade.isEmpty()) {
            int currentValue = 0;
            int nextValue = 0;
            int temp = 0;
            for (int i = 0; i < grade.size(); i++) {
                for (int j = 0; j < grade.size() - 1 - i; j++) {
                    currentValue = grade.get(j);
                    nextValue = grade.get(j + 1);
                    if (currentValue > nextValue) {
                         temp = currentValue;
                         grade.set(j,nextValue);
                         grade.set(j+1,temp);
                    }
                }
            }
        }
    }

    public static void selectionSort() {
        for (int i = 0; i < grade.size(); i++) {
            int minInt = i;
            int temp = 0;
            for (int j = i; j < grade.size(); j++) {
                if (grade.get(j)<grade.get(minInt)){
                    minInt = j;
                }
            }
            temp = grade.get(i);
            grade.set(i, grade.get(minInt));
            grade.set(minInt,temp);
        }
    }

    public static void choice(){
        System.out.println("1. bubbleSort\n2. selectionSort");
        int num = scan.nextInt();

        switch (num){
            case 1:
                bubbleSortDesc();
                break;
            case 2:
                selectionSort();
                break;
            default:
                break;
        }
    }
    public static void bubbleSortDesc() {
        if (!grade.isEmpty()) {
            int currentValue = 0;
            int nextValue = 0;
            int temp = 0;
            for (int i = 0; i < grade.size(); i++) {
                for (int j = 0; j < grade.size() - 1 - i; j++) {
                    currentValue = grade.get(j);
                    nextValue = grade.get(j + 1);
                    if (currentValue < nextValue) {
                        temp = currentValue;
                        grade.set(j,nextValue);
                        grade.set(j+1,temp);
                    }
                }
            }
        }
    }
    public static void showStatistics(){
        int numValue = 0 ;
        int numMax = grade.get(0);
        int numMin = grade.get(0);
        int averageValue = 0;
        for (int i = 0; i < grade.size(); i++) {
            numValue++;
            if (grade.get(i)>numMax){
                numMax = grade.get(i);
            }
            if (grade.get(i)<numMin){
                numMin = grade.get(i);
            }

            if (grade.get(i)>=60){
                System.out.println("Не сдал - " + grade.get(i));
            }else System.out.println("Сдал - " + grade.get(i));

            averageValue += grade.get(i);
        }
            averageValue = averageValue / grade.size();

        System.out.println(numValue + " - Кол оценок");
        System.out.println(numMax + " - Макс значение");
        System.out.println(numMin + " - Мин значение");
        System.out.println(averageValue + " - Сред значение");



    }
    public static void ClearAllGrades(){
        if (!grade.isEmpty()){
            System.out.println("Clear grades...");
            grade.remove(0);
            for (int i = 0; i < grade.size(); i++) {
                grade.remove(i);
            }
            System.out.println("Grades clearing!");
        }
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
                    searchGrade();
                    break;
                case 6:
                    choice();
                    break;
                case 7:
                    bubbleSortDesc();
                    break;
                case 8:
                    showStatistics();
                    break;
                case 9:
                    ClearAllGrades();
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

