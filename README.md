# Project 2: Fancy Grade Manager

## Goal

Build a console CRUD application in Java that manages student grades using `ArrayList<Integer>`.

This project should feel like a nicer and cleaner version of the banking project:

- A clear text menu
- Separate methods for each action
- Good input validation
- A dynamic list instead of a fixed-size array
- Small algorithms written by hand
- Clean, readable output for the user

The application should store grades as integer values from `0` to `100`.

## What You Will Practise

- Creating and using an `ArrayList<Integer>`
- Adding, reading, updating, and removing values
- Using loops with lists
- Writing your own algorithms
- Sorting values
- Searching values
- Validating user input
- Organizing code into methods
- Making a console app pleasant to use

## Main Requirement

Create a Java program called **Grade Manager**.

The program should keep running until the user chooses `Exit`.

Example menu:

```text
==============================
        GRADE MANAGER
==============================
1. Add grade
2. Show all grades
3. Update grade
4. Remove grade
5. Search grade
6. Sort grades ascending
7. Sort grades descending
8. Show statistics
9. Clear all grades
0. Exit
==============================
Choose an option:
```

You may make the menu more fancy, but it must stay easy to read.

## Data Rules

- Use `ArrayList<Integer>` to store all grades.
- A grade must be an integer from `0` to `100`.
- If the user enters an invalid grade, print a helpful message and ask again or return to the menu.
- The program must not crash when the user enters a wrong menu option.
- The program must handle an empty grade list.

Examples:

```text
No grades yet. Add a grade first.
```

```text
Invalid grade. Please enter a number from 0 to 100.
```

## Required Features

### 1. Add Grade

Ask the user for a grade and add it to the list.

Example:

```text
Enter grade: 87
Grade 87 was added.
```

### 2. Show All Grades

Print all grades with their positions.

Example:

```text
Grades:
1. 90
2. 75
3. 88
```

Use user-friendly numbering starting from `1`, even though Java indexes start from `0`.

### 3. Update Grade

Ask the user which grade number to update, then ask for the new grade.

Example:

```text
Which grade do you want to update? 2
Enter new grade: 80
Grade number 2 was changed from 75 to 80.
```

Internally, remember to convert the user's number to a Java index.

### 4. Remove Grade

Ask the user which grade number to remove.

Example:

```text
Which grade do you want to remove? 1
Grade 90 was removed.
```

### 5. Search Grade

Ask the user for a grade value and search for it using a loop.

Example:

```text
Enter grade to search: 88
Grade 88 was found at position 3.
```

If the grade appears more than once, print all positions.

Example:

```text
Grade 75 was found at positions: 2, 5, 8
```

Do not use advanced search helpers for this feature. Write the loop yourself.

### 6. Sort Grades Ascending

Sort grades from smallest to biggest.

Example:

```text
Before: [90, 75, 88]
After:  [75, 88, 90]
```

For algorithm practice, write your own sorting method. You can use **bubble sort** or **selection sort**.

Do not use `Collections.sort()` for the required version.

### 7. Sort Grades Descending

Sort grades from biggest to smallest.

Example:

```text
Before: [75, 88, 90]
After:  [90, 88, 75]
```

You can either write a second sorting method or reuse your ascending sort and then reverse the list manually.

Do not use `Collections.reverse()` for the required version.

### 8. Show Statistics

Print useful information about the grades.

Required statistics:

- Number of grades
- Highest grade
- Lowest grade
- Average grade
- Number of passing grades
- Number of failing grades

Use `60` as the passing grade.

Example:

```text
Grade Statistics
----------------
Amount of grades: 5
Highest grade: 95
Lowest grade: 55
Average grade: 78.4
Passing grades: 4
Failing grades: 1
```

Write the algorithms yourself using loops.

### 9. Clear All Grades

Ask for confirmation before deleting all grades.

Example:

```text
Are you sure you want to remove all grades? yes/no
```

Only clear the list if the user types `yes`.

## Suggested Code Structure

You can keep everything in one class for this project, but the code should be split into methods.

Recommended methods:

```java
public static void printMenu()
public static int readMenuChoice()
public static int readGrade()
public static void addGrade()
public static void showGrades()
public static void updateGrade()
public static void removeGrade()
public static void searchGrade()
public static void sortAscending()
public static void sortDescending()
public static void showStatistics()
public static void clearGrades()
```

The list can be stored like this:

```java
static ArrayList<Integer> grades = new ArrayList<>();
static Scanner scanner = new Scanner(System.in);
```

Remember the import:

```java
import java.util.ArrayList;
import java.util.Scanner;
```

## Algorithm Hints

### Find Highest Grade

Start with the first grade as the current highest grade.

Then loop through the list and replace the highest grade when you find a bigger value.

### Find Lowest Grade

Start with the first grade as the current lowest grade.

Then loop through the list and replace the lowest grade when you find a smaller value.

### Calculate Average

Add all grades into a `sum` variable.

Then divide by the number of grades:

```java
double average = (double) sum / grades.size();
```

### Bubble Sort Idea

Bubble sort compares two neighboring values and swaps them if they are in the wrong order.

Example:

```text
[90, 75, 88]
90 and 75 are in the wrong order, so swap them:
[75, 90, 88]
90 and 88 are in the wrong order, so swap them:
[75, 88, 90]
```

## Milestones

### Milestone 1: Basic Menu

- Create the project
- Add the menu
- Make the program repeat until the user exits
- Handle invalid menu choices

### Milestone 2: Basic CRUD

- Add grades
- Show grades
- Update grades
- Remove grades
- Handle empty list cases

### Milestone 3: Algorithms

- Search for a grade
- Sort grades ascending
- Sort grades descending
- Calculate statistics

### Milestone 4: Polish

- Improve output messages
- Make the menu nice
- Test invalid input
- Remove repeated code by creating helper methods

## Optional Bonus Features

Do these only after the required features work well.

- Save grades to a file when the program exits
- Load grades from a file when the program starts
- Add an autosave option
- Add a second list for student names
- Add letter grades, for example `A`, `B`, `C`, `D`, `F`
- Show the median grade
- Show how many grades are excellent, good, average, and poor
- Add a "random test data" option that inserts 10 random grades
- Add a "remove all failing grades" option

## Rules

- Use `ArrayList<Integer>`, not a normal array.
- Use methods. Do not put all logic inside `main`.
- Use loops for search, sorting, and statistics.
- Do not use `Collections.sort()` for the required sorting feature.
- Do not use `Collections.max()` or `Collections.min()` for the required statistics feature.
- Keep variable and method names clear.
- Test the program after each milestone.

## Example Final Session

```text
==============================
        GRADE MANAGER
==============================
1. Add grade
2. Show all grades
3. Update grade
4. Remove grade
5. Search grade
6. Sort grades ascending
7. Sort grades descending
8. Show statistics
9. Clear all grades
0. Exit
==============================
Choose an option: 1
Enter grade: 92
Grade 92 was added.

Choose an option: 1
Enter grade: 76
Grade 76 was added.

Choose an option: 2
Grades:
1. 92
2. 76

Choose an option: 8
Grade Statistics
----------------
Amount of grades: 2
Highest grade: 92
Lowest grade: 76
Average grade: 84.0
Passing grades: 2
Failing grades: 0

Choose an option: 0
Goodbye.
```