/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191246_l01;

import java.util.Scanner;

/**
 * L01 - title: Create a Java console program to manage Candidates of company.
 *
 * @author Phan Duc Tho - CE191246
 *
 * Date: 1/4/2025
 *
 */
public class IO {

    private Scanner sc = new Scanner(System.in);
    private int candidatetype;

    public String checkCandidateId() {
        String input;
        do {
            System.out.print("Enter CandidateId: ");
            input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Invalid.Please enter again!");
                continue;
            }
            if (input.toUpperCase().charAt(0) == 'N' && input.toUpperCase().charAt(1) == 'V' && input.length() == 5) {
                for (int i = 2; i < 5; i++) {
                    if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                        System.out.println("Invalid.Please enter again!");

                        continue;
                    }
                }

            } else {
                System.out.println("Invalid.Please enter again!");

                continue;
            }
            break;

        } while (true);
        return input;
    }

    public String checkFirstName() {
        String input;
        do {
            try {
                System.out.print("Enter FirstName: ");
                input = sc.nextLine();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    throw new Exception();
                }
                for (int i = 0; i < input.length(); i++) {    // If the character is not a valid hexadecimal digit, prompt the user to try again
                    if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'))) {
                        System.out.println("Invalid. Please enter again!"); // Error message
                        throw new Exception();
                    }
                }

                break;
            } catch (Exception e) {
                continue;
            }

        } while (true);
        return input;
    }

    public String checkLastName() {
        String input;
        do {
            try {
                System.out.print("Enter LastName: ");
                input = sc.nextLine();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    throw new Exception();
                }
                for (int i = 0; i < input.length(); i++) {    // If the character is not a valid hexadecimal digit, prompt the user to try again
                    if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'))) {
                        System.out.println("Invalid. Please enter again!"); // Error message
                        throw new Exception();
                    }
                }

                break;
            } catch (Exception e) {
                continue;
            }

        } while (true);
        return input;
    }

    public int checkBirthDate() {
        int input;
        System.out.print("Enter BirthDate: ");

        do {
            try {
                input = Integer.parseInt(sc.nextLine().trim()); // Read and parse the salary input as a double

                if ((2025 - input) < 18) {
                    System.out.print("Impossible! Please enter BirthDate again: "); // Error message if the salary is not valid
                    continue;

                }

                if (input > 1900 && input < 2026) { // Check if the salary is greater than 100
                    break; // Exit the loop if the salary is valid
                } else {
                    System.out.print("Impossible! Please enter BirthDate again: "); // Error message if the salary is not valid
                    continue; // Continue to the next iteration of the loop
                }
            } catch (Exception e) {
                System.out.print("Impossible! Please enter BirthDate again: "); // Error message if the input is not a valid number
            }
        } while (true); // Continue looping until a valid salary is entered

        return input; // Return the valid salary entered by the user
    }

    public String checkAddress() {
        String input;
        do {
            System.out.print("Enter Address: ");
            input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Invalid.Please enter again!");
                continue;
            }
            break;

        } while (true);
        return input;
    }

    public String checkPhone() {
        String input;
        do {
            try {
                System.out.print("Enter Phone: ");
                input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    throw new Exception();
                }
                if (input.length() != 10) {
                    System.out.println("Invalid. Please enter again!");
                    throw new Exception();
                }
                for (int i = 0; i < input.length(); i++) {    // If the character is not a valid hexadecimal digit, prompt the user to try again
                    if (!((input.charAt(i) >= '0' && input.charAt(i) <= '9'))) {
                        System.out.println("Invalid. Please enter again!"); // Error message
                        throw new Exception();
                    }
                }
                break;
            } catch (Exception e) {
                continue;
            }

        } while (true);
        return input;
    }

    public String checkEmail() {
        String input;
        do {
            try {
                System.out.print("Enter Email: ");
                input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    throw new Exception();
                }
                String[] w = input.split("@");
                String str1 = w[0];
                String str2 = w[1];

                if (w.length != 2) {
                    System.out.println("Invalid.Please enter again!");
                    throw new Exception();
                }
                if (str1.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    throw new Exception();
                }

                if (!(str2.toUpperCase().charAt(str2.length() - 1) == 'M' && str2.toUpperCase().charAt(str2.length() - 2) == 'O' && str2.toUpperCase().charAt(str2.length() - 3) == 'C' && str2.toUpperCase().charAt(str2.length() - 4) == '.')) {
                    System.out.println("Invalid.Please enter again!");
                    throw new Exception();
                }

                String[] s = str2.split("\\.");
                String ar1 = s[0];
                String ar2 = s[1];

                if (s.length != 2) {
                    System.out.println("Invalid.Please enter again!");
                    throw new Exception();
                }
                if (ar1.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    throw new Exception();
                }

            } catch (ArrayIndexOutOfBoundsException i) {
                System.out.println("Invalid.Please enter again!");
                continue;

            } catch (Exception e) {
                continue;
            }

            break;

        } while (true);
        return input;
    }

    public int expInYear() {
        int input;
        System.out.print("Enter year of experience: ");

        do {
            try {
                input = Integer.parseInt(sc.nextLine().trim()); // Read and parse the salary input as a double

                if (input > 0) { // Check if the salary is greater than 100
                    break; // Exit the loop if the salary is valid
                } else {
                    System.out.print("Impossible! Please enter year of experience again: "); // Error message if the salary is not valid
                    continue; // Continue to the next iteration of the loop
                }
            } catch (Exception e) {
                System.out.print("Impossible! Please enter year of experience again: "); // Error message if the input is not a valid number
            }
        } while (true); // Continue looping until a valid salary is entered

        return input; // Return the valid salary entered by the user
    }

    public String proSkill() {
        String input;
        do {
            try {
                System.out.print("Enter proSkill: ");
                input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    throw new Exception();
                }
                for (int i = 0; i < input.length(); i++) {    // If the character is not a valid hexadecimal digit, prompt the user to try again
                    if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'))) {
                        System.out.println("Invalid. Please enter again!"); // Error message
                        throw new Exception();
                    }
                }

                break;
            } catch (Exception e) {
                continue;
            }

        } while (true);
        return input;
    }

    public String checkGraduation_date() {
        String input;
        do {
            System.out.print("Enter graduated time: ");
            input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Invalid.Please enter again!");
                continue;
            }
            try {

                String w[] = input.split("/");
                int day = Integer.parseInt(w[0]);
                int month = Integer.parseInt(w[1]);
                int years = Integer.parseInt(w[2]);

                if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day > 30) {
                        System.out.println("Invalid.Please enter again!");
                        throw new Exception();
                    }
                }

                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    if (day > 31) {
                        System.out.println("Invalid.Please enter again!");
                        throw new Exception();
                    }
                }
                if (month == 2) {
                    if (day > 28) {
                        System.out.println("Invalid.Please enter again!");
                        throw new Exception();
                    }
                }

            } catch (Exception e) {
                continue;
            }

            break;

        } while (true);
        return input;
    }

    public String checkGraduation_rank() {
        String input; // Declare a variable to store the user's choice
        do {
            try {
                System.out.print("Enter Rank of Graduation: ");

                input = sc.nextLine().trim(); // Read and parse the input as an integer
                if (input.equalsIgnoreCase("(Excellence") || input.equalsIgnoreCase("Good") || input.equalsIgnoreCase("Fair") || input.equalsIgnoreCase("Poor")) { // Check if the choice is valid
                    break; // Break the loop if the choice is valid
                } else {
                    System.out.println("Must enter Excellence, Good, Fair, Poor "); // Error message if the choice is not valid
                    continue; // Continue the loop if the choice is not valid
                }

            } catch (Exception e) { // Catch any exceptions (e.g., invalid input that is not an integer)
                System.out.println("Must enter Excellence, Good, Fair, Poor ");
            }

        } while (true); // Continue the loop until a valid choice is entered

        return input; // Return the valid choice entered by the user
    }

    public String checkMajors() {
        String input;
        do {
            try {
                System.out.print("Enter Majors: ");
                input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    continue;
                }
                for (int i = 0; i < input.length(); i++) {    // If the character is not a valid hexadecimal digit, prompt the user to try again
                    if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'))) {
                        System.out.println("Invalid. Please enter again!"); // Error message
                        continue;
                    }
                }
                break;
            } catch (Exception e) {
                continue;
            }

        } while (true);
        return input;
    }

    public String checkSemester() {
        String input;
        do {
            try {
                System.out.print("Enter Semester: ");
                input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    continue;
                }
                int check = Integer.parseInt(input);
                if (check > 0) {
                    break;
                } else {
                    System.out.println("Invalid.Please enter again!");
                    continue;

                }

            } catch (Exception e) {
                continue;
            }

        } while (true);
        return input;
    }

    public String checkUniversityname() {
        String input;
        do {
            try {
                System.out.print("Enter Semester: ");
                input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    continue;
                }
                for (int i = 0; i < input.length() - 1; i++) {    // If the character is not a valid hexadecimal digit, prompt the user to try again
                    if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) >= 'A' && input.charAt(i) <= 'F'))) {
                        System.out.println("Invalid. Please enter again!"); // Error message
                        continue;
                    }
                }
                break;
            } catch (Exception e) {
                continue;
            }

        } while (true);
        return input;
    }

    public String checkEducation() {
        String input;
        do {
            try {
                System.out.print("Enter Education: ");
                input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    continue;
                }
                for (int i = 0; i < input.length() - 1; i++) {    // If the character is not a valid hexadecimal digit, prompt the user to try again
                    if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) >= 'A' && input.charAt(i) <= 'F'))) {
                        System.out.println("Invalid. Please enter again!"); // Error message
                        continue;
                    }
                }
                break;
            } catch (Exception e) {
                continue;
            }

        } while (true);
        return input;
    }

    public int checkChoice() {
        int choice = 0; // Declare a variable to store the user's choice

        do {
            try {
                choice = Integer.parseInt(sc.nextLine().trim()); // Read and parse the user's input into an integer

                if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 7 || choice == 8 || choice == 9) { // Check if the choice is valid
                    break; // Exit the loop if the choice is valid
                } else {
                    System.out.print("Must enter 1 - 9: "); // Prompt the user again if the choice is invalid
                    continue; // Continue to the next iteration of the loop
                }
            } catch (Exception e) {
                System.out.print("Must enter 1 - 9: "); // Error message if the input is not a valid integer
            }
        } while (true); // Continue looping until a valid choice is entered

        return choice; // Return the valid choice entered by the user
    }

    public String searchName() {
        String input;
        do {
            try {
                System.out.print("Input Candidate name (First name or Last name): ");
                input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    continue;
                }

                break;
            } catch (Exception e) {
                continue;
            }

        } while (true);
        return input;
    }

    public String checkCandidateType() {
        String input;
        do {
            try {
                System.out.print("Enter candidate type: ");
                input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    continue;
                }
                int check = Integer.parseInt(input);
                if (check >= 0 && check <= 2) {
                    break;
                } else {
                    System.out.println("Invalid.Please enter again!");
                    continue;

                }

            } catch (Exception e) {
                continue;
            }

        } while (true);
        return input;
    }

    public String checkNumber() {
        String input;
        do {
            try {
                System.out.print("Enter choose option update: ");
                input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    continue;
                }
                int check = Integer.parseInt(input);
                if (check > 0) {
                    break;
                } else {
                    System.out.println("Invalid.Please enter again!");
                    continue;

                }

            } catch (Exception e) {
                continue;
            }

        } while (true);
        return input;
    }

    public String checkIndex() {
        String input;
        do {
            try {
                System.out.print("Enter Index Update: ");
                input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    continue;
                }
                int check = Integer.parseInt(input);
                if (check > 0) {
                    break;
                } else {
                    System.out.println("Invalid.Please enter again!");
                    continue;

                }

            } catch (Exception e) {
                continue;
            }

        } while (true);
        return input;
    }

    public String checkDelete() {
        String input;
        do {
            try {
                System.out.print("Enter Index Delete: ");
                input = sc.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Invalid.Please enter again!");
                    continue;
                }
                int check = Integer.parseInt(input);
                if (check > 0) {
                    break;
                } else {
                    System.out.println("Invalid.Please enter again!");
                    continue;

                }

            } catch (Exception e) {
                continue;
            }

        } while (true);
        return input;
    }
}
