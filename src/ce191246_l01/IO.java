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

    // Create a Scanner object to read input from the console
    private Scanner sc = new Scanner(System.in);

    // Declare a variable to store candidate type
    private int candidatetype;

    /**
     * This method checks and validates a Candidate ID input. The format must
     * start with 'NV' followed by 3 digits (e.g., NV001).
     *
     * @return A valid Candidate ID string
     */
    public String checkCandidateId() {
        String input; // Declare input variable
        do {
            System.out.print("Enter CandidateId: "); // Prompt the user for Candidate ID
            input = sc.nextLine().trim(); // Read and trim whitespace from input

            if (input.isEmpty()) { // Check if input is empty
                System.out.println("Invalid.Please enter again!"); // Print error message
                continue; // Skip to next iteration
            }

            // Check if input starts with 'NV' and is 5 characters long
            if (input.toUpperCase().charAt(0) == 'N' && input.toUpperCase().charAt(1) == 'V' && input.length() == 5) {
                for (int i = 2; i < 5; i++) { // Check characters from index 2 to 4
                    if (input.charAt(i) < '0' || input.charAt(i) > '9') { // Check if character is not a digit
                        System.out.println("Invalid.Please enter again!"); // Print error
                        continue; // Continue to next loop iteration
                    }
                }

            } else { // If not matching the required format
                System.out.println("Invalid.Please enter again!"); // Print error
                continue; // Continue to next loop iteration
            }

            break; // Exit loop if all checks passed

        } while (true); // Repeat until valid input

        return input; // Return the valid Candidate ID
    }

    /**
     * This method checks and validates the user's first name. Only allows
     * alphabetic characters and spaces.
     *
     * @return A valid first name string
     */
    public String checkFirstName() {
        String input; // Declare input variable
        do {
            try {
                System.out.print("Enter FirstName: "); // Prompt for first name
                input = sc.nextLine().trim(); // Read and trim input

                if (input.isEmpty()) { // Check if input is empty
                    System.out.println("Invalid.Please enter again!"); // Print error
                    throw new Exception(); // Throw exception to retry
                }

                for (int i = 0; i < input.length(); i++) { // Loop through each character
                    if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
                            || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')
                            || input.charAt(i) == ' ')) { // Check if character is not a letter or space
                        System.out.println("Invalid. Please enter again!"); // Print error
                        throw new Exception(); // Throw exception to retry
                    }
                }

                break; // Exit loop if valid

            } catch (Exception e) {
                continue; // Retry if exception occurs
            }

        } while (true); // Repeat until valid input

        return input; // Return the valid first name
    }

    /**
     * This method checks and validates the user's last name. Only allows
     * alphabetic characters and spaces.
     *
     * @return A valid last name string
     */
    public String checkLastName() {
        String input; // Declare input variable
        do {
            try {
                System.out.print("Enter LastName: "); // Prompt for last name
                input = sc.nextLine().trim(); // Read and trim input

                if (input.isEmpty()) { // Check if input is empty
                    System.out.println("Invalid.Please enter again!"); // Print error
                    throw new Exception(); // Throw exception to retry
                }

                for (int i = 0; i < input.length(); i++) { // Loop through each character
                    if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
                            || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')
                            || input.charAt(i) == ' ')) { // Check if character is not a letter or space
                        System.out.println("Invalid. Please enter again!"); // Print error
                        throw new Exception(); // Throw exception to retry
                    }
                }

                break; // Exit loop if valid

            } catch (Exception e) {
                continue; // Retry if exception occurs
            }

        } while (true); // Repeat until valid input

        return input; // Return the valid last name
    }

    /**
     * This method checks and validates the user's birth year. Must be between
     * 1901 and 2025, and user must be at least 18 years old.
     *
     * @return A valid year of birth as an integer
     */
    public int checkBirthDate() {
        int input; // Declare variable for birth year
        String data = "";
        System.out.print("Enter BirthDate: "); // Prompt for birth year

        do {
            try {
                data = sc.nextLine().trim();//input data

                for (int i = 0; i < data.length(); i++) { // Loop through each character
                    if (!((data.charAt(i) >= '0' && data.charAt(i) <= '9'))) { // Check if character is not a digit
                        System.out.print("Impossible! Please enter BirthDate again: "); // Display error message
                        throw new Exception(); // Force loop to retry
                    }
                }
                input = Integer.parseInt(data); // Read and parse input
                if ((2025 - input) < 18) { // Check if user is under 18
                    System.out.print("Impossible! Please enter BirthDate again: "); // Print error
                    throw new Exception(); // Throw exception to retry
                }

                if (input > 1900 && input < 2026) { // Check valid year range
                    break; // Exit loop if valid
                } else {
                    System.out.print("Impossible! Please enter BirthDate again: "); // Print error
                    throw new Exception(); // Throw exception to retry
                }
            } catch (Exception e) {

                continue;//continue the loop
            }
        } while (true); // Repeat until valid input

        return input; // Return valid birth year
    }

    /**
     * This method checks and validates the user's address. It ensures that the
     * address is not left empty.
     *
     * @return A valid address string
     */
    public String checkAddress() {
        String input; // Declare variable to store input
        do {
            System.out.print("Enter Address: "); // Prompt the user to enter address
            input = sc.nextLine().trim(); // Read and trim the input

            if (input.isEmpty()) { // Check if input is empty
                System.out.println("Invalid.Please enter again!"); // Display error message
                continue; // Ask again
            }
            break; // Exit loop if input is valid

        } while (true); // Repeat until valid input
        return input; // Return the validated address
    }

    /**
     * This method checks and validates the user's phone number. Phone number
     * must be exactly 10 digits and only numeric.
     *
     * @return A valid phone number string
     */
    public String checkPhone() {
        String input; // Declare variable to store phone number
        do {
            try {
                System.out.print("Enter Phone: "); // Prompt the user to enter phone number
                input = sc.nextLine().trim(); // Read and trim the input

                if (input.isEmpty()) { // Check if input is empty
                    System.out.println("Invalid.Please enter again!"); // Display error message
                    throw new Exception(); // Force loop to retry
                }

                if (input.length() != 10) { // Check if phone number length is not 10
                    System.out.println("Invalid. Please enter again!"); // Display error message
                    throw new Exception(); // Force loop to retry
                }

                for (int i = 0; i < input.length(); i++) { // Loop through each character
                    if (!((input.charAt(i) >= '0' && input.charAt(i) <= '9')&&input.charAt(0) == '0')) { // Check if character is not a digit
                        System.out.println("Invalid. Please enter again!"); // Display error message
                        throw new Exception(); // Force loop to retry
                    }
                }
                break; // Exit loop if input is valid
            } catch (Exception e) {
                continue; // Retry on any exception
            }

        } while (true); // Repeat until valid input
        return input; // Return the validated phone number
    }

    /**
     * This method checks and validates the user's email address. It ensures
     * correct structure like example@domain.com.
     *
     * @return A valid email address string
     */
    public String checkEmail() {
        String input; // Declare variable to store email
        do {
            try {
                System.out.print("Enter Email: "); // Prompt user to enter email
                input = sc.nextLine().trim(); // Read and trim input

                if (input.isEmpty()) { // Check if input is empty
                    System.out.println("Invalid.Please enter again!"); // Display error message
                    throw new Exception(); // Force retry
                }

                String[] w = input.split("@"); // Split email by '@'
                String str1 = w[0]; // Local part before '@'
                String str2 = w[1]; // Domain part after '@'

                if (w.length != 2) { // Email must contain exactly one '@'
                    System.out.println("Invalid.Please enter again!"); // Display error message
                    throw new Exception(); // Force retry
                }

                if (str1.isEmpty()) { // Local part must not be empty
                    System.out.println("Invalid.Please enter again!"); // Display error message
                    throw new Exception(); // Force retry
                }

                // Check if email ends with .com (case-insensitive)
                if (!(str2.toUpperCase().charAt(str2.length() - 1) == 'M'
                        &&//check character M
                        str2.toUpperCase().charAt(str2.length() - 2) == 'O'
                        &&//check character M
                        str2.toUpperCase().charAt(str2.length() - 3) == 'C'
                        &&//check character M
                        str2.toUpperCase().charAt(str2.length() - 4) == '.')) {//check character .
                    System.out.println("Invalid.Please enter again!"); // Display error message
                    throw new Exception(); // Force retry
                }

                String[] s = str2.split("\\."); // Split domain part by '.'
                String ar1 = s[0]; // Domain name
                String ar2 = s[1]; // TLD (e.g. com)

                if (s.length != 2) { // Must be exactly 2 parts after splitting by '.'
                    System.out.println("Invalid.Please enter again!"); // Display error message
                    throw new Exception(); // Force retry
                }

                if (ar1.isEmpty()) { // Domain name must not be empty
                    System.out.println("Invalid.Please enter again!"); // Display error message
                    throw new Exception(); // Force retry
                }

            } catch (ArrayIndexOutOfBoundsException i) {
                System.out.println("Invalid.Please enter again!"); // Display error message for out-of-bound array
                continue; // Retry
            } catch (Exception e) {
                continue; // Retry on other exceptions
            }

            break; // Exit loop if input is valid

        } while (true); // Repeat until valid input
        return input; // Return the validated email
    }

    /**
     * This method checks and validates the user's years of experience. The
     * input must be a positive integer.
     *
     * @return A valid number of years of experience
     */
    public int expInYear() {
        int input; // Declare a variable to store the input
        System.out.print("Enter year of experience: "); // Prompt the user to enter experience

        do {
            try {
                input = Integer.parseInt(sc.nextLine().trim()); // Read and parse input as integer

                if (input > 0) { // Check if input is greater than 0
                    break; // Exit loop if valid
                } else {
                    System.out.print("Impossible! Please enter year of experience again: "); // Error message
                    continue; // Retry
                }
            } catch (Exception e) {
                System.out.print("Impossible! Please enter year of experience again: "); // Error for invalid number
            }
        } while (true); // Repeat until valid input

        return input; // Return validated experience
    }

    /**
     * This method checks and validates the user's professional skill. The input
     * must contain only alphabetic characters.
     *
     * @return A valid professional skill string
     */
    public String proSkill() {
        String input; // Declare input variable
        do {
            try {
                System.out.print("Enter proSkill: "); // Prompt user for professional skill
                input = sc.nextLine().trim(); // Read and trim input

                if (input.isEmpty()) { // Check if input is empty
                    System.out.println("Invalid.Please enter again!"); // Error message
                    throw new Exception(); // Force retry
                }
                for (int i = 0; i < input.length(); i++) { // Loop through each character
                    if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
                            || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')||input.charAt(i)==' ')) { // Check if character is not a letter
                        System.out.println("Invalid. Please enter again!"); // Error message
                        throw new Exception(); // Force retry
                    }
                }

                break; // Exit loop if valid
            } catch (Exception e) {
                continue; // Retry on error
            }

        } while (true); // Repeat until valid input
        return input; // Return the validated skill
    }

    /**
     * This method checks and validates the user's graduation date. The format
     * should be day/month/year, and the date must be valid.
     *
     * @return A valid graduation date string
     */
    public String checkGraduation_date(int birthOfYears) {
        String input; // Declare input variable
        do {
            System.out.print("Enter graduated time: "); // Prompt for graduation date
            input = sc.nextLine().trim(); // Read and trim input

            if (input.isEmpty()) { // Check if input is empty
                System.out.println("Invalid.Please enter again!"); // Error message
                continue; // Retry
            }
            try {
                String w[] = input.split("/"); // Split input into parts by "/"
                int day = Integer.parseInt(w[0]); // Parse day
                int month = Integer.parseInt(w[1]); // Parse month
                int years = Integer.parseInt(w[2]); // Parse year

                if (years > 2025) { // Year must not be in the future
                    System.out.println("Invalid!"); // Error message
                    throw new Exception(); // Retry
                }

                if (month == 4 || month == 6 || month == 9 || month == 11) { // Months with 30 days
                    if (day > 30) {
                        System.out.println("Invalid!"); // Error message
                        throw new Exception(); // Retry
                    }
                }

                if (month == 1 || month == 3 || month == 5 || month == 7
                        || month == 8 || month == 10 || month == 12) { // Months with 31 days
                    if (day > 31) {
                        System.out.println("Invalid!"); // Error message
                        throw new Exception(); // Retry
                    }
                }

                if (years % 4 == 0 && month == 2) { // Leap year check for February
                    if (day > 29) {
                        System.out.println("Invalid!"); // Error message
                        throw new Exception(); // Retry
                    }
                } else if (month == 2) { // Non-leap year February
                    if (day > 28) {
                        System.out.println("Invalid!"); // Error message
                        throw new Exception(); // Retry
                    }
                }
                if(years<=birthOfYears){
                    System.out.println("Invalid");
                    throw new Exception();
                    
                }

            } catch (Exception e) {
                System.out.println("Please enter again! ");// Error message

                continue; // Retry on any parsing or logic error
            }

            break; // Exit loop if input is valid

        } while (true); // Repeat until valid input
        return input; // Return the validated graduation date
    }

    /**
     * This method checks and validates the user's graduation rank. Acceptable
     * values: Excellence, Good, Fair, Poor.
     *
     * @return A valid graduation rank string
     */
    public String checkGraduation_rank() {
        String input; // Declare variable to store input
        do {
            try {
                System.out.print("Enter Rank of Graduation: "); // Prompt for rank
                input = sc.nextLine().trim(); // Read and trim input

                if (input.equalsIgnoreCase("(Excellence")
                        || // Check for valid ranks
                        input.equalsIgnoreCase("Good")
                        || input.equalsIgnoreCase("Fair")
                        || input.equalsIgnoreCase("Poor")) {
                    break; // Valid input
                } else {
                    System.out.println("Must enter Excellence, Good, Fair, Poor "); // Error message
                    continue; // Retry
                }

            } catch (Exception e) {
                System.out.println("Must enter Excellence, Good, Fair, Poor "); // Error on exception
            }

        } while (true); // Repeat until valid input
        return input; // Return validated graduation rank
    }

    /**
     * This method checks and validates the user's major. The input must contain
     * only alphabetic characters.
     *
     * @return A valid major string
     */
    public String checkMajors() {
        String input; // Declare variable to store input
        do {
            try {
                System.out.print("Enter Majors: "); // Prompt for major
                input = sc.nextLine().trim(); // Read and trim input

                if (input.isEmpty()) { // Check if input is empty
                    System.out.println("Invalid.Please enter again!"); // Error message
                    throw new Exception(); // Retry
                }

                for (int i = 0; i < input.length(); i++) { // Loop through each character
                    if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
                            || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')
                            || input.charAt(i) == ' ')) { // Check if character is not a letter or space
                        System.out.println("Invalid. Please enter again!"); // Print error
                        throw new Exception(); // Throw exception to retry
                    }
                }

                break; // Exit if input is valid

            } catch (Exception e) {
                continue; // Retry on exception
            }

        } while (true); // Repeat until valid input
        return input; // Return validated major
    }

    /**
     * This method checks and validates the user's semester. It must be a
     * positive integer.
     *
     * @return A valid semester as string
     */
    public String checkSemester() {
        String input; // Declare variable to store input
        do {
            try {
                System.out.print("Enter Semester: "); // Prompt for semester
                input = sc.nextLine().trim(); // Read and trim input

                if (input.isEmpty()) { // Check if input is empty

                    throw new Exception(); // Retry
                }

                int check = Integer.parseInt(input); // Parse input to integer
                if (check > 0) { // Check if number is positive
                    break; // Valid input
                } else {

                    throw new Exception(); // Retry
                }

            } catch (Exception e) {
                System.out.println("Invalid.Please enter again!"); // Error message

                continue; // Retry on exception
            }

        } while (true); // Repeat until valid input
        return input; // Return validated semester
    }

    /**
     * This method checks and validates the name of the university. Only allows
     * alphabetic characters from A to F and a to z (note: logic may need
     * adjustment).
     *
     * @return A valid university name string
     */
    public String checkUniversityname() {
        String input; // Declare input variable
        do {
            try {
                System.out.print("Enter Universityname: "); // Prompt the user (label may be incorrect, should be 'University Name')
                input = sc.nextLine().trim(); // Read and trim input

                if (input.isEmpty()) { // Check if input is empty
                    System.out.println("Invalid.Please enter again!"); // Error message
                    throw new Exception(); // Retry
                }

                for (int i = 0; i < input.length(); i++) { // Loop through each character
                    if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
                            || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')||input.charAt(i)==' ')) { // Check if character is not a letter
                        System.out.println("Invalid. Please enter again!"); // Error message
                        throw new Exception(); // Force retry
                    }
                }

                break; // Exit loop if valid
            } catch (Exception e) {
                continue; // Retry on exception
            }

        } while (true); // Loop until valid input
        return input; // Return university name
    }

    /**
     * This method checks and validates the education input. Only allows
     * characters A–F and a–z (note: might not cover all valid cases).
     *
     * @return A valid education string
     */
    public String checkEducation() {
        String input; // Declare input variable
        do {
            try {
                System.out.print("Enter Education: "); // Prompt the user
                input = sc.nextLine().trim(); // Read and trim input

                if (input.isEmpty()) { // Check if input is empty
                    System.out.println("Invalid.Please enter again!"); // Error message
                    throw new Exception();// Retry
                }

                for (int i = 0; i < input.length(); i++) { // Loop through each character
                    if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
                            || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')
                            || input.charAt(i) == ' ')) { // Check if character is not a letter or space
                        System.out.println("Invalid. Please enter again!"); // Print error
                        throw new Exception(); // Throw exception to retry
                    }
                }
                break; // Exit loop if input is valid
            } catch (Exception e) {
                continue; // Retry on exception
            }

        } while (true); // Repeat until valid input
        return input; // Return validated education
    }

    /**
     * This method checks and validates the user's menu choice. Only accepts
     * integer values from 1 to 9.
     *
     * @return A valid choice as integer
     */
    public int checkChoice() {
        int choice = 0; // Declare variable to store user's choice

        do {
            try {
                choice = Integer.parseInt(sc.nextLine().trim()); // Read and parse input

                if (choice == 1 || choice == 2 || choice == 3 || choice == 4
                        || choice == 5 || choice == 6 || choice == 7 || choice == 8 || choice == 9) { // Check if valid option
                    break; // Exit if valid
                } else {
                    System.out.print("Must enter 1 - 9: "); // Error message
                    continue; // Retry
                }

            } catch (Exception e) {
                System.out.print("Must enter 1 - 9: "); // Error if not a number
            }

        } while (true); // Repeat until valid choice

        return choice; // Return validated choice
    }

    /**
     * This method prompts user to enter a candidate's name for searching. Input
     * must not be empty.
     *
     * @return A valid name input string
     */
    public String searchName() {
        String input; // Declare input variable
        do {
            try {
                System.out.print("Input Candidate name (First name or Last name): "); // Prompt user
                input = sc.nextLine().trim(); // Read and trim input

                if (input.isEmpty()) { // Check if empty
                    System.out.println("Invalid.Please enter again!"); // Error message
                    throw new Exception(); // Retry
                }
                for (int i = 0; i < input.length() - 1; i++) { // Loop through characters except last one
                    if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
                            || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'))) { // Check if character is valid
                        System.out.println("Invalid. Please enter again!"); // Error message
                        throw new Exception(); // Retry
                    }
                }

                break; // Exit if valid
            } catch (Exception e) {
                continue; // Retry on exception
            }

        } while (true); // Repeat until valid
        return input; // Return name
    }

    /**
     * This method checks and validates candidate type input. Only accepts 0, 1,
     * or 2.
     *
     * @return A valid candidate type string
     */
    public String checkCandidateType() {
        String input; // Declare input variable
        do {
            try {
                System.out.print("Enter candidate type: "); // Prompt the user
                input = sc.nextLine().trim(); // Read and trim input

                if (input.isEmpty()) { // Check if empty

                    throw new Exception(); // Retry
                }

                int check = Integer.parseInt(input); // Parse input

                if (check >= 0 && check <= 2) { // Check if valid range
                    break; // Exit loop
                } else {

                    throw new Exception(); // Retry
                }

            } catch (Exception e) {
                System.out.println("Invalid.Please enter again!"); // Error message
                continue; // Retry on exception
            }

        } while (true); // Repeat until valid input
        return input; // Return candidate type
    }

    /**
     * This method checks and validates a numeric option for updating. Must be a
     * positive integer.
     *
     * @return A valid number as string
     */
    public String checkNumber() {
        String input; // Declare input variable
        do {
            try {
                System.out.print("Enter choose option update: "); // Prompt user
                input = sc.nextLine().trim(); // Read and trim input

                if (input.isEmpty()) { // Check if empty

                    throw new Exception(); // Retry
                }

                int check = Integer.parseInt(input); // Parse to integer

                if (check > 0) { // Check if greater than 0
                    break; // Exit if valid
                } else {

                    throw new Exception(); // Retry
                }

            } catch (Exception e) {
                System.out.println("Invalid.Please enter again!"); // Error message
                continue; // Retry on exception
            }

        } while (true); // Repeat until valid
        return input; // Return number
    }

    /**
     * This method checks and validates the index for updating. Must be a
     * positive integer.
     *
     * @return A valid index string
     */
    public String checkIndex() {
        String input; // Declare input variable
        do {
            try {
                System.out.print("Enter Index Update: "); // Prompt user
                input = sc.nextLine().trim(); // Read and trim input

                if (input.isEmpty()) { // Check if input is empty

                    throw new Exception(); // Retry
                }

                int check = Integer.parseInt(input); // Parse to integer

                if (check > 0) { // Check if positive
                    break; // Exit if valid
                } else {

                    throw new Exception(); // Retry
                }

            } catch (Exception e) {
                System.out.println("Invalid.Please enter again!"); // Error message
                continue; // Retry on exception
            }

        } while (true); // Repeat until valid
        return input; // Return index
    }

    /**
     * This method checks and validates the index for deletion. Must be a
     * positive integer.
     *
     * @return A valid delete index string
     */
    public String checkDelete() {
        String input; // Declare input variable
        do {
            try {
                System.out.print("Enter Index Delete: "); // Prompt user
                input = sc.nextLine().trim(); // Read and trim input

                if (input.isEmpty()) { // Check if input is empty

                    throw new Exception(); // Retry
                }

                int check = Integer.parseInt(input); // Parse to integer

                if (check > 0) { // Check if valid
                    break; // Exit if valid
                } else {

                    throw new Exception(); // Retry
                }

            } catch (Exception e) {
                System.out.println("Invalid.Please enter again!"); // Error message
                continue; // Retry on exception
            }

        } while (true); // Repeat until valid
        return input; // Return index to delete
    }

}
