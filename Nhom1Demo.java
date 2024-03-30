// Import class arraylist to use for creating and managing dynamic arrays
import java.util.ArrayList;
// import class Scanner to read data from different input sources such as keyboard or files
import java.util.Scanner;

// Define a new class named "Nhom1Demo" and this class is accessible from outside the class.
public class Nhom1Demo {
    // define three static variables (scn, studentFirstNames, studentLastNames ) in class Nhom1Demo
    // With the Scanner object, the program can read data entered from the keyboard.
    private static Scanner scn = new Scanner(System.in);
    private static ArrayList<String> studentFirstNames = new ArrayList<>();
    private static ArrayList<String> studentLastNames = new ArrayList<>();

    //Define a "main" method in class Nhom1Demo
    public static void main(String args[]) {

        // Declare a variable named "isRunning" of data type boolean and assign the value "true"
        Boolean isRunning = true;
        // Use a while loop, it will continue running as long as the variable "isRunning" is evaluated as "true"
        while (isRunning) {

            System.out.println("----Student Management System----");
            System.out.println("1: Enter student list.");
            System.out.println("2: Find students by last name.");
            System.out.println("3: Find and edit students by full name.");
            System.out.println("4: End.");
            // "collectInput()" method to take input from user and assign to variable "userInput"
            int userInput = collectInput();

            // Use the "switch" statement to specify the action corresponding to the user's selection.
            switch (userInput) {
                case 1:
                    enterStudentList(studentFirstNames, studentLastNames);
                    break;
                case 2:
                    findStudentByLastName(studentFirstNames, studentLastNames);
                    break;
                case 3:
                    findAndEditStudentByFullName(studentFirstNames, studentLastNames);
                    break;
                case 4:
                    isRunning = false;
                    break;
            }
        }
        // The "Scanner" object will stop receiving data and will no longer be usable.
        scn.close();
    }

    // Takes input from the user and returns a value of type "int"
    private static int collectInput() {

        System.out.print("Enter Your Choice: ");

        // Declare a variable "userInput" of type integer (int) to store the value entered from the keyboard.
        int userInput;

        // "while" loop, it will continue to repeat when the user enters a valid value.
        while (true) {
            try {
                // Read an integer from the keyboard using the "nextInt()" method of the "Scanner" object
                userInput = scn.nextInt();
                if (userInput >= 1 && userInput <= 4) {
                    break;
                } else {
                    System.out.print("Invalid Input! Please Enter 1, 2, 3, or 4: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid Input! Please Enter A Number: ");

                //scn.next() is used to read and remove invalid input lines, then the program will ask the user to re-enter.
                scn.next();
            }
        }
        // Once a valid value has been entered, the loop ends and the method returns the "userInput" value.
        return userInput;
    }

    /*The enterStudentList() method is a static method of the Nhom1Demo class, used to enter a student list 
    including first names and last names of students and store them into two lists "firstNames" and "lastNames".*/
    private static void enterStudentList(ArrayList<String> firstNames, ArrayList<String> lastNames) {

        System.out.print("Enter Number Of Students: ");
        //Declare a variable "numberOfStudents" of type integer (int) to store the value entered from the keyboard.
        int numberOfStudents;
        // "while" loop, it will continue to repeat when the user enters a valid value.
        while (true) {

            try {
                numberOfStudents = scn.nextInt();
                /*If the input value is an integer greater than 0, 
                the loop will end and the "numberOfStudents" value will be updated. */ 
                if (numberOfStudents > 0) {
                    break;
                } 
                /*If the input value is not an integer or is a number less than or equal to 0,
                 the program will print an error message and ask the user to re-enter.. */
                else {
                    System.out.print("Invalid Input! Please Enter A Number Greater Than Zero: ");
                }
                //If the user enters a non-numeric string, nextInt() will throw an exception
            } catch (Exception e) {
                System.out.print("Invalid Input! Please Enter A Number: ");
                //scn.next() is used to read and remove invalid input lines, then the program will ask the user to re-enter.
                scn.next();
            }
        }
        /*The for loop will iterate from i = 1 to i = numberOfStudents. 
        In each loop, student information will be entered from the keyboard 
        and added to the "firstNames" and "lastNames" lists. */
        for (int i = 1; i <= numberOfStudents; i++) {

            System.out.print("Enter The First Name Of Student " + i + ": ");
            String studentFirstName = scn.next();
            firstNames.add(studentFirstName);

            System.out.print("Enter The Last Name Of Student " + i + ": ");
            String studentLastName = scn.next();
            lastNames.add(studentLastName);
        }
    }
    
    /*The "findStudentByLastName" method is a static method,
     used to find students based on their last name in the lastNames list. */
    private static void findStudentByLastName(ArrayList<String> firstNames, ArrayList<String> lastNames) {
        
        // Search for students in the lastNames list

        System.out.print("Enter The Last Name To Search For: ");

        //Reads the input string from the user and stores it in the variable "lastNameToSearch"
        String lastNameToSearch = scn.next();

        /*Use the indexOf() method of the list "lastNames" to search 
        for the first last name of the entered student (lastNameToSearch).
        The result of this method will be the index of the element in the lastNames list
        that is equal to lastNameToSearch, or -1 if not found.*/
        int studentIndex = lastNames.indexOf(lastNameToSearch);


        /*If "studentIndex" is different from -1, it means the student was found in the "lastNames" list,
             and the student's full name will be printed to the screen using the "studentIndex" index. */
        if (studentIndex != -1) {

            System.out.println("Student Found: " + firstNames.get(studentIndex) + " " + lastNames.get(studentIndex));

        /*If "studentIndex" is -1, it means the student is not found in the lastNames list,
         and the program prints the message "Student Not Found!"*/
        } else {
            System.out.println("Student Not Found!");
        }
    }

    //The "findAndEditStudentByFullName" method is used to find and edit a student's information based on their full name
    private static void findAndEditStudentByFullName(ArrayList<String> firstNames, ArrayList<String> lastNames) {
        
        //Prints to the screen a message asking the user to enter the full name of the student they want to edit.
        System.out.print("Enter The Full Name Of The Student To Edit: ");
        scn.nextLine();

        //Reads the input string from the user using the nextLine() method and stores it in the inputFullName variable.
        String inputFullName = scn.nextLine();
        Boolean isFounded = false;

        /*The for loop iterates through each student in the list. In each loop,
         the full names of the students in the list are generated from their first and last names.*/
        for (int i = 0; i < firstNames.size(); i++) {
            String fullNameInList = firstNames.get(i) + " " + lastNames.get(i);

            //If fullNameInList is equal to inputFullName, it means the student has been found
            if (fullNameInList.equals(inputFullName)) {
                System.out.println("Student Found: " + fullNameInList);

                // Message and ask the user to enter a new first name
                System.out.print("Enter The New First Name: ");
                String newFirstName = scn.next();
                firstNames.set(i, newFirstName);
                
                //This new information is updated into the firstNames and lastNames lists corresponding to index "i".

                // Message and ask the user to enter a new last name
                System.out.print("Enter The New Last Name: ");
                String newLastName = scn.next();
                lastNames.set(i, newLastName);

                //The isFounded variable is set to true to indicate that the student has been found and edited
                isFounded = true;
                break;
            }
        }
        //If no students are found in the loop, "isFounded" retains the value "false".
        if (!isFounded) {
            //So, no students were found, the program prints the message "Student Not Found!".
            System.out.println("Student Not Found!");
        }
    }
}