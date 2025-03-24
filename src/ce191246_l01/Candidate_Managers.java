/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191246_l01;

import java.util.ArrayList;

/**
 * L01 - title: Create a Java console program to manage Candidates of company.
 *
 * @author Phan Duc Tho - CE191246
 *
 * Date: 1/4/2025
 *
 */
public class Candidate_Managers {

    private ArrayList<Candidates> list = new ArrayList<>(); // List to store all candidates

    private IO io = new IO(); // IO object to handle user inputs and validations
    Experience ex = new Experience();
    Fresher fr = new Fresher();
    Internship in = new Internship();

    /**
     * Displays the main menu for the candidate management system.
     */
    public void menu() {

        int choice; // Variable to store user choice
 list.add(new Internship("toan", "tho", "fpt", "3112", "phan", "ThoInter", 1, "302", "phan@gmail.com", "0377164760", 2));
        list.add(new Internship("toan", "tho", "fpt", "3112", "phan", "Tho", 1, "302", "phan@gmail.com", "0377164760", 2));
        list.add(new Internship("toan", "tho", "fpt", "3112", "phan", "Tho", 1, "302", "phan@gmail.com", "0377164760", 2));
        list.add(new Internship("toan", "tho", "fpt", "3112", "phan", "Tho", 1, "302", "phan@gmail.com", "0377164760", 2));
        list.add(new Fresher("20/10/2006", "good", "daihoc", "se1092", "thofr", "phan", 1, "302", "phan@gmail.com", "0377164760", 1));
        list.add(new Fresher("20/10/2006", "good", "daihoc", "se1092", "tho", "phan", 1, "302", "phan@gmail.com", "0377164760", 1));
        list.add(new Fresher("20/10/2006", "good", "daihoc", "se1092", "tho", "phan", 1, "302", "phan@gmail.com", "0377164760", 1));
        list.add(new Experience(1, "yasuo", "se1902", "thoex", "phan", 1, "302", "tho@gmail.com", "0377174760", 0));
        list.add(new Experience(1, "yasuo", "se1902", "tho", "phan", 1, "302", "tho@gmail.com", "0377174760", 0));
        list.add(new Experience(1, "yasuo", "se1902", "tho", "phan", 1, "302", "tho@gmail.com", "0377174760", 0));
        do {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM"); // Display menu title
            System.out.println("1. Experience"); // Option 1
            System.out.println("2. Fresher"); // Option 2
            System.out.println("3. Internship"); // Option 3
            System.out.println("4. Searching"); // Option 4
            System.out.println("5. Update"); // Option 5
            System.out.println("6. Delete"); // Option 6
            System.out.println("7. Show"); // Option 7
            System.out.println("8. Show detail"); // Option 8
            System.out.println("9. Exit"); // Option 9
            System.out.print("Please choose: "); // Prompt user for choice

            choice = io.checkChoice(); // Validate and get choice
            switch (choice) { // Process user choice
                case 1:
                    experience(); // Handle Experience case
                    break;
                case 2:
                    fresher(); // Handle Fresher case
                    break;
                case 3:
                    internship(); // Handle Internship case
                    break;
                case 4:
                    searching(); // Handle Searching case
                    break;
                case 5:
                    update(); // Handle Update case
                    break;
                case 6:
                    delete(); // Handle Delete case
                    break;
                case 7:
                    show(); // Handle Show case
                    break;
                case 8:
                    showALl(); // Handle Show All Details case
                    break;
                case 9:
                    break; // Exit loop
            }
        } while (choice != 9); // Loop until user chooses to exit

    }

    /**
     * Adds a new Experience candidate.
     */
    public void experience() {
        Candidates ex = new Experience(); // Create new Experience object
        ex.entryData(); // Input data
        list.add(ex); // Add to list

    }

    /**
     * Adds a new Fresher candidate.
     */
    public void fresher() {
        Candidates fr = new Fresher(); // Create new Fresher object
        fr.entryData(); // Input data
        list.add(fr); // Add to list

    }

    /**
     * Adds a new Internship candidate.
     */
    public void internship() {
        Candidates in = new Internship(); // Create new Internship object
        in.entryData(); // Input data
        list.add(in); // Add to list

    }

    /**
     * Searches for candidates by name and type.
     */
    public void searching() {
        if (list.isEmpty()) { // If list is empty
            System.out.println("ist not data. Please enter data"); // Inform user
        } else {
            boolean check; // Flag to check if any candidates exist per type
            System.out.println("List of candidate:"); // Title
            System.out.println("===========EXPERIENCE CANDIDATE============"); // Section title
            check = false; // Reset check
            for (Candidates s : list) { // Loop through list
                if (s instanceof Experience) { // Check if Experience
                    s.canShow(); // Display summary
                    check = true; // Found at least one
                }
            }
            if (check == false) { // If none found
                System.out.println("List empty"); // Inform user
            }
            System.out.println("==========FRESHER CANDIDATE=============="); // Section title
            check = false; // Reset check
            for (Candidates s : list) { // Loop again
                if (s instanceof Fresher) { // Check if Fresher
                    s.canShow(); // Display summary
                    check = true; // Found
                }
            }
            if (check == false) { // If none found
                System.out.println("List empty"); // Inform user
            }
            System.out.println("===========INTERN CANDIDATE=============="); // Section title
            check = false; // Reset check
            for (Candidates s : list) { // Loop again
                if (s instanceof Internship) { // Check if Internship
                    s.canShow(); // Display summary
                    check = true; // Found
                }
            }
            if (check == false) { // If none found
                System.out.println("List empty"); // Inform user
            }

            String nameCheck = io.searchName(); // Get name for search
            int typeCheck = Integer.parseInt(io.checkCandidateType()); // Get type for search
            int i = 0; // Index counter
            check = false; // Reset check
            System.out.println("+---+----------------+---------+-------------+----------+-----------------+----+"); // Table header
            System.out.println("|No.|Fullname        |Birthdate|Address      |Phone     |Email            |Type|"); // Table columns
            System.out.println("+---+----------------+---------+-------------+----------+-----------------+----+"); // Table line

            for (Candidates s : list) { // Loop list
                if (s.getFirstName().contains(nameCheck) || s.getLastName().contains(nameCheck)) { // Match name
                    if (typeCheck == 0) { // Check type Experience
                        if (s instanceof Experience) {
                            Experience ex = (Experience) list.get(i);
                            i++; // Increase index
                            ex.afterSearch(i); // Show row
                            check = true; // Found
                        }
                    } else if (typeCheck == 1) { // Fresher
                        if (s instanceof Fresher) {
                            Fresher fr = (Fresher) list.get(i);
                            i++;// Increase index
                            fr.afterSearch(i);// Show row
                            check = true;// Found
                        }

                    } else if (typeCheck == 2) { // Internship
                        if (s instanceof Internship) {
                            Internship in = (Internship) list.get(i);
                            i++;// Increase index
                            in.afterSearch(i);// Show row
                            check = true;// Found
                        }

                    }

                }
            }
            System.out.println("+---+----------------+---------+-------------+----------+-----------------+----+"); // End line

            if (!check) { // If none found
                System.out.println("list Empty"); // Inform user
            }

        }
    }

    /**
     * Updates candidate information based on user selection.
     */
   
    public void update() {
        showALl();
        int select = 0, checkUp = 0;
        if (list.isEmpty()) {
            System.out.println("list Empty");
        } else {

            do {
                select = Integer.parseInt(io.checkIndex());
                if (select <= list.size()) {
                    break;
                } else {
                    System.out.println("only in list");
                }
            } while (true);

            System.out.println("1. Update candidateId ");
            System.out.println("2. Update firstName ");
            System.out.println("3. Update lastName ");
            System.out.println("4. Update birthDate ");
            System.out.println("5. Update address ");
            System.out.println("6. Update email ");
            System.out.println("7. Update phone ");
            if (list.get(select - 1) instanceof Experience) {
                System.out.println("8. Update Experience Of Years");
                System.out.println("9. Update ProSkill");
            } else if (list.get(select - 1) instanceof Fresher) {
                System.out.println("8. Update Graduation Date");
                System.out.println("9. Update Graduation Rank");
                System.out.println("10. Update Education");

            } else {
                System.out.println("8. Update  Majors");
                System.out.println("9. Update Semester");
                System.out.println("10. universityName");
            }

            checkUp = Integer.parseInt(io.checkNumber());

            //   in menu nguoi dung can update gi
            // int select = io.kiem tra phan can update
            list.get(select - 1).updateAbout(checkUp);

            System.out.println("update successfully!");
        }

    }


    /**
     * Deletes a candidate based on the selected index.
     */
    public void delete() {

        showALl(); // Show all candidates
        if (!list.isEmpty()) { // Check if list is not empty
            int index = Integer.parseInt(io.checkDelete()); // Get index to delete
if(index>list.size()){
    System.out.println("NOT DATA");
    
}else{
            list.remove(index - 1); // Remove candidate from list
            System.out.println("Delete successfully"); // Confirm deletion
        }
    }
    }
    /**
     * Shows detailed list of all candidates separated by type.
     */
    public void showALl() {

        boolean check; // Flag to check if any candidates exist per section

        int countEx = 0; // Count Experience candidates
        int countFr = 0; // Count Fresher candidates
        int countIn = 0; // Count Internship candidates
        System.out.println("List of candidate:"); // Display title

        // Experience section
        System.out.println("===========EXPERIENCE CANDIDATE=========="); // Header
        check = false; // Reset check
        for (int i = 0; i < list.size(); i++) { // Loop through list
            if (list.get(i) instanceof Experience) { // Check type
                countEx++; // Count up
            }
        }
        if (countEx != 0) {

            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+---------+"); // Table header
            System.out.println("|No.|CandidatesID    |Fullname        |Birthdate|Address      |Phone     |Email            |Type|ExpInYear |ProSkill |"); // Columns
            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+---------+"); // Separator
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Experience) {
                Experience ex = (Experience) list.get(i);
                ex.show(i + 1);
                check = true;
            }
        }

        if (countEx != 0) {//check is have data or no

            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+---------+"); // Footer
        }

        if (!check) {//check is have data or no
            System.out.println("List empty"); // Inform user
        }

        // Fresher section
        System.out.println("===========FRESHER CANDIDATE============="); // Header
        check = false; // Reset check

        for (int i = 0; i < list.size(); i++) {// Loop through list
            if (list.get(i) instanceof Fresher) {//check is have data or no

                countFr++; // Count up

            }
        }
        if (countFr != 0) {//check is have data or no
            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+--------+----------+"); // Header
            System.out.println("|No.|CandidatesID    |Fullname        |Birthdate|Address      |Phone     |Email            |Type|Date      |Rank    |Education |"); // Columns
            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+--------+----------+"); // Separator
        }
        for (int i = 0; i < list.size(); i++) {// Loop through list
            if (list.get(i) instanceof Fresher) {//check is have data or no
                Fresher fr = (Fresher) list.get(i);
                fr.show(i + 1); // Show
                check = true;// Found
            }
        }
        if (countFr != 0) {//check is have data or no
            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+--------+----------+"); // Footer
        }
        if (!check) {//check is have data or no
            System.out.println("List empty"); // Inform user
        }

        // Internship section
        System.out.println("===========INTERN CANDIDATE=============="); // Header
        check = false; // Reset
        for (int i = 0; i < list.size(); i++) {// Loop through list
            if (list.get(i) instanceof Internship) {//check is have data or no

                countIn++; // Count up

            }
        }
        if (countIn != 0) {//check is have data or no
            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+-------+--------+----------+"); // Header
            System.out.println("|No.|CandidatesID    |Fullname        |Birthdate|Address      |Phone     |Email            |Type|Major  |Semester|University|"); // Columns
            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+-------+--------+----------+"); // Separator
        }
        for (int i = 0; i < list.size(); i++) {// Loop through list
            if (list.get(i) instanceof Internship) {//check is have data or no
                Internship in = (Internship) list.get(i);
                in.show(i + 1); // Show
                check = true; // Found
            }
        }
        if (countIn != 0) {//check is have data or no
            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+-------+--------+----------+"); // Footer
        }
        if (!check) {//check is have data or no
            System.out.println("List empty"); // Inform user
        }

    }

    /**
     * Shows a summary list of all candidates.
     */
    public void show() {
        int i = 0; // Counter
        if (list.isEmpty()) { // Check if empty
            System.out.println("list is empty"); // Inform user
        } else {
            System.out.println("+---+----------------+---------+-------------+----------+-----------------+----+"); // Header
            System.out.println("|No.|Fullname        |Birthdate|Address      |Phone     |Email            |Type|"); // Columns
            System.out.println("+---+----------------+---------+-------------+----------+-----------------+----+"); // Separator
            for (Candidates s : list) { // Loop list
                i++; // Increment index
                s.afterSearch(i); // Show summary
            }
            System.out.println("+---+----------------+---------+-------------+----------+-----------------+----+"); // Footer
        }
    }
}
