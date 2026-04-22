package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Main implements Serializable {
    static Random random = new Random();
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Integer> grade = new ArrayList<Integer>();
    public static final String SAVE = "save.ser";
    public static final String SAVESETTING = "setting.ser";

    public static final String UNDO1 = "undo/undo1.ser";
    public static final String UNDO2 = "undo/undo2.ser";
    public static final String UNDO3 = "undo/undo3.ser";
    public static final String UNDO4 = "undo/undo4.ser";
    private static String undoExchenge;

    static boolean autosave = false;
    static boolean infoload = false;
    static boolean oneuse = true;

    public static void Undo() throws FileNotFoundException {
        System.out.println("Undo option:  ");

        if (undoAdd == true) {
            System.out.println("1. Undo the grade add");
        }
        if (undoUpdate == true) {
            System.out.println("2. Undo the grade update");
        }
        if (undoRemove == true) {
            System.out.println("3. Undo the grade remove");
        }
        if (undoClear == true) {
            System.out.println("4. Undo clear all grade");
        }
        if (undoAdd || undoUpdate || undoRemove || undoClear) {
            System.out.println("0. Exit");
            int number = scan.nextInt();
            switch (number) {
                case 1:
                    if (undoAdd == true) {
                        undoAdd = false;
                        undoExchenge = UNDO1;
                        LoadGradesUndo();
                    }
                case 2:
                    if (undoUpdate == true) {
                        undoUpdate = false;
                        undoExchenge = UNDO2;
                        LoadGradesUndo();
                    }
                case 3:
                    if (undoRemove == true) {
                        undoRemove = false;
                        undoExchenge = UNDO3;
                        LoadGradesUndo();
                    }
                case 4:
                    if (undoClear == true) {
                        undoClear = false;
                        undoExchenge = UNDO4;
                        LoadGradesUndo();
                    }
                case 0:
                    break;
            }

        }else System.out.println("Nothing");
    }
    public static void SaveGradesUndo() {
        try {
            FileOutputStream outputStream = new FileOutputStream(undoExchenge);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(grade);
            System.out.println("Save file success! " + undoExchenge);
            objectOutputStream.close();

        } catch (NotSerializableException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void LoadGradesUndo() throws FileNotFoundException {

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(undoExchenge))) {
            grade = (ArrayList<Integer>) inputStream.readObject();
            System.out.println("Load success! " + undoExchenge);

        } catch (NotSerializableException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void randomArrays(){
        System.out.println("Насколько заполнить массив?");
        int value = scan.nextInt();
        grade.clear();
        if (grade.isEmpty()){
            for (int i = 0; i< value;i++) {
                int randomInt = random.nextInt(100);
                grade.add(i, randomInt);
            }
        }
    }

    public static void SaveGrades() {
        try {
            FileOutputStream outputStream = new FileOutputStream(SAVE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(grade);
            System.out.println("Save file success! " + SAVE);
            objectOutputStream.close();

        } catch (NotSerializableException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void LoadGrades() throws FileNotFoundException {

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(SAVE))) {
            grade = (ArrayList<Integer>) inputStream.readObject();
            System.out.println("Load success! " + SAVE);

        } catch (NotSerializableException e) {
        throw new RuntimeException(e);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void SaveAutoLoadSetting() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVESETTING))) {
            oos.writeObject(infoload);
            System.out.println("The file has been saved successfully!(autoload) -  " + SAVESETTING);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadAutoLoadSetting() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(SAVESETTING))) {
            infoload = (boolean) inputStream.readObject();
            System.out.println("Get info false or true! - " + SAVESETTING);
        } catch (FileNotFoundException e) {
            System.out.println("The auto-load settings file was not found; using the default value!");
        } catch (IOException e) {
            System.out.println("File download error!");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to save! Save data invalid!");
        }
    }

    public static boolean AutoSave(){
        autosave = !autosave;
        return autosave;
    }

    public static boolean AutoloadAccounts() throws FileNotFoundException {
        infoload = !infoload;
        SaveAutoLoadSetting();
        if(infoload == true){
            loadAutoLoadSetting();
        }
        return infoload;
    }

    static boolean undoAdd = false;
    public static void addGrade(){
        System.out.println("Enter grade: ");
        int number = scan.nextInt();
        if(0<=number && number<=100) {

            undoAdd = true;
            undoExchenge = UNDO1;
            SaveGradesUndo();

            grade.add(number);
        }else {
            System.out.println("Error Grade");
        }
    }

    public static void allGrade(){
        int i = 0;
        if (!grade.isEmpty()){
        for (int s : grade) {
            System.out.println("На номер " + i);
            System.out.println(s);
            System.out.println("-----");
            i++;
            }
        }
        else System.out.println("Null grades");
    }

    static boolean undoUpdate = false;
    public static void updateGrade(){
        if (!grade.isEmpty()){
            System.out.println("Number index:");
            int index = scan.nextInt();
            System.out.println("Number value: ");
            int value = scan.nextInt();
          if (value >= 0 && value <= 100){
                if (index >= 0 && index < grade.size()) {

                    undoUpdate = true;
                    undoExchenge = UNDO2;
                    SaveGradesUndo();

                    grade.set(index, value);
                    System.out.println("Grade value edit!");
                }else System.out.println("Index error!");
            }else System.out.println("The value is too large or too small");
        }
    }
    static boolean undoRemove =  false;
    public static void removeGrade(){
        if (!grade.isEmpty()){
            System.out.println("Number index:");
            int index = scan.nextInt();
                if (index >= 0 && index <= grade.size()) {

                    undoRemove = true;
                    undoExchenge = UNDO3;
                    SaveGradesUndo();

                    grade.remove(index);
                    System.out.println("Grade index removed!");
            }else
                System.out.println("Index not correct!");
        }
        System.out.println("Null grade!");
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
        System.out.println("Null grades");
    }

    public static void selectionSort() {
        if (!grade.isEmpty()) {
            for (int i = 0; i < grade.size(); i++) {
                int minInt = i;
                int temp = 0;
                for (int j = i; j < grade.size(); j++) {
                    if (grade.get(j) < grade.get(minInt)) {
                        minInt = j;
                    }
                }
                temp = grade.get(i);
                grade.set(i, grade.get(minInt));
                grade.set(minInt, temp);
            }
        }
        System.out.println("Null grades");
    }
    public static void insertionSort() {
        if (!grade.isEmpty()) {
            for (int i = 1; i < grade.size(); i++) {
                int current = grade.get(i);

                int j = i;
                while (j > 0 && grade.get(j - 1) > current) {
                    grade.set(j, grade.get(j - 1));
                    j--;
                }
                grade.set(j, current);
            }
        }
        System.out.println("Null grades");
    }
    public static void choice(){
        System.out.println("1. bubbleSort\n2. selectionSort\n3. insertionSort");
        int num = scan.nextInt();

        switch (num){
            case 1:
                bubbleSortDesc();
                break;
            case 2:
                selectionSort();
                break;
            case 3:
                insertionSort();
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
        System.out.println("Null grades");
    }
    public static void showStatistics(){
        if (!grade.isEmpty()) {
            int numValue = 0;
            int numMax = grade.get(0);
            int numMin = grade.get(0);
            int averageValue = 0;
            for (int i = 0; i < grade.size(); i++) {
                numValue++;
                if (grade.get(i) > numMax) {
                    numMax = grade.get(i);
                }
                if (grade.get(i) < numMin) {
                    numMin = grade.get(i);
                }
                if (grade.get(i) >= 60) {
                    System.out.println("Не сдал - " + grade.get(i));
                } else System.out.println("Сдал - " + grade.get(i));

                averageValue += grade.get(i);
            }
            averageValue = averageValue / grade.size();

            System.out.println(numValue + " - Кол оценок");
            System.out.println(numMax + " - Макс значение");
            System.out.println(numMin + " - Мин значение");
            System.out.println(averageValue + " - Сред значение");


        }
        System.out.println("Null grades");
    }

    static boolean undoClear = false;
    public static void ClearAllGrades(){
        if (!grade.isEmpty()){
            System.out.println("Clear grades...");
            grade.remove(0);
            for (int i = 0; i < grade.size(); i++) {

                undoClear = true;
                undoExchenge = UNDO4;
                SaveGradesUndo();

                grade.remove(i);
            }
            System.out.println("Grades clearing!");
        }
        System.out.println("Null grades");
    }
    public static void printMenu() {
        System.out.println(
                "==============================\n" +
                "        GRADE MANAGER\n" +
                "==============================\n" +
                "1. Add grade - (Can undo)\n"+
                "2. Show all grades\n"+
                "3. Update grade - (Can undo)\n"+
                "4. Remove grade - (Can undo)\n"+
                "5. Search grade\n" +
                "6. Sort grades ascending\n" +
                "7. Sort grades descending\n" +
                "8. Show statistics\n" +
                "9. Clear all grades - (Can undo)\n" +
                "10. SaveGrades data\n" +
                "11. LoadGrades data\n" +
                "12. AUTOSaveGrades data " + autosave+
                "\n13. AUTOLoadGrades data " + infoload+
                "\n14. Random arrays\n" +
                "\n15. Undo parameters\n" +

                "\n"+
                "0. Exit\n"+
                "==============================\n"
                );
    }

    public static void main(String[] args) throws IOException {
        boolean exit = false;
        while (true) {
            if (oneuse == true){
            loadAutoLoadSetting();
            oneuse = false;
            }
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
                case 10:
                    SaveGrades();
                    break;
                case 11:
                    LoadGrades();
                    break;
                case 12:
                    AutoSave();
                    break;
                case 13:
                    AutoloadAccounts();
                    break;
                case 14:
                    randomArrays();
                    break;
                case 15:
                    Undo();
                    break;
                case 0:
                    exit = true;
                    if (infoload==true)SaveAutoLoadSetting();
                    break;
                default:
                    break;
            }
            if (exit == true) break;
        }
        System.out.println("Exit");
    }
}

