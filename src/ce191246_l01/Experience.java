/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191246_l01;

import com.sun.imageio.plugins.bmp.BMPConstants;
import java.util.HashSet;
import java.util.Set;

/**
 * L01 - title: Create a Java console program to manage Candidates of company.
 *
 * @author Phan Duc Tho - CE191246
 *
 * Date: 1/4/2025
 *
 */
public class Experience extends Candidates {

    // Create an IO object to use input methods
    private IO io = new IO();
    // Store the number of years of experience
    private int ExpInYear;
    // Store the professional skill
    private String proSkill;

    /**
     * Default constructor for Experience class
     */
    public Experience() {
    }

    /**
     * Constructor with all attributes including those from parent class
     *
     * @param ExpInYear number of years of experience
     * @param proSkill professional skill
     * @param candidateId ID of candidate
     * @param firstName first name of candidate
     * @param lastName last name of candidate
     * @param birthDate birth year of candidate
     * @param address address of candidate
     * @param email email of candidate
     * @param phone phone number of candidate
     * @param candidatetype type of candidate
     */
    public Experience(int ExpInYear, String proSkill, String candidateId, String firstName, String lastName, int birthDate, String address, String email, String phone, int candidatetype) {
        super(candidateId, firstName, lastName, birthDate, address, email, phone, candidatetype);  // Call parent constructor
        this.ExpInYear = ExpInYear;  // Assign experience in years
        this.proSkill = proSkill;  // Assign professional skill
    }

    /**
     * Getter for ExpInYear
     *
     * @return number of years of experience
     */
    public int getExpInYear() {
        return ExpInYear;  // Return the experience years
    }

    /**
     * Setter for ExpInYear
     *
     * @param ExpInYear number of years of experience to set
     */
    public void setExpInYear(int ExpInYear) {
        this.ExpInYear = ExpInYear;  // Set the experience years
    }

    /**
     * Getter for proSkill
     *
     * @return professional skill
     */
    public String getProSkill() {
        return proSkill;  // Return professional skill
    }

    /**
     * Setter for proSkill
     *
     * @param proSkill professional skill to set
     */
    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;  // Set professional skill
    }

    /**
     * Method to enter data for Experience candidate
     */
   
    public void entryDataAttribute() {
          // Call entryData method from parent class
        super.setCandidatetype(0);  // Set candidate type to 0 for Experience
        do {
            ExpInYear = io.expInYear();  // Input experience in years
            if ((2025 - getBirthDate() - 5) < ExpInYear) {  // Validate experience with birth year
                System.out.println("imposible");  // Print message if not valid
                continue;  // Continue loop
            } else {
                break;  // Exit loop if valid
            }
        } while (true);  // Loop until valid input is received

        proSkill = io.proSkill();  // Input professional skill
    }

    /**
     * Display candidate’s full name
     */
    @Override
    public void canShow() {
        System.out.println(super.getFirstName() + " " + super.getLastName());  // Print full name
    }

    /**
     * Show candidate data after search
     *
     * @param no number to display in order
     */
    @Override
    public void afterSearch(int no) {
        String name = super.getFirstName() + " " + super.getLastName();  // Combine full name
        System.out.printf("|%-3d|%-16s|%-9s|%-13s|%-10s|%-17s|%-4s|\n", no, name, super.getBirthDate(), super.getAddress(), super.getPhone(), super.getEmail(), super.getCandidatetype());  // Print candidate data
    }

    /**
     * Update information based on selected field
     *
     * @param i index of attribute to update
     */
    @Override
    public void updateAbout(int i) {

        switch (i) {
            case 2:
                super.setFirstName(io.checkFirstName());  // Update first name
                break;
            case 3:
                super.setLastName(io.checkLastName());  // Update last name
                break;
            case 4:
                super.setBirthDate(io.checkBirthDate());  // Update birth date
                break;
            case 5:
                super.setAddress(io.checkAddress());  // Update address
                break;

            default:
                updateAttribute(i);  // Update experience-specific attribute
                break;
        }
    }

    /**
     * Update specific attributes of Experience candidate
     *
     * @param i index of attribute
     */
    public void updateAttribute(int i) {
        switch (i) {
            case 8:
                ExpInYear = io.expInYear();  // Update experience in years
                break;
            case 9:
                proSkill = io.proSkill();  // Update professional skill
                break;
        }
    }

    /**
     * Show all details of Experience candidate
     *
     * @param no number to display in order
     */
    public void show(int no) {
        String name = super.getFirstName() + " " + super.getLastName();  // Combine full name
        System.out.printf("|%-3d|%-16s|%-16s|%-9s|%-13s|%-10s|%-17s|%-4s|%-10d|%-9s|\n", no, super.getCandidateId(), name, super.getBirthDate(), super.getAddress(), super.getPhone(), super.getEmail(), super.getCandidatetype(), getExpInYear(), getProSkill());  // Print all details
    }

}
