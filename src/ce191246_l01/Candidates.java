/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191246_l01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * L01 - title: Create a Java console program to manage Candidates of company.
 *
 * @author Phan Duc Tho - CE191246
 *
 * Date: 1/3/2025
 *
 */
public abstract class Candidates {

    // IO object for input validation and user interaction
    private IO io = new IO();

    // Fields to store candidate information
    private String candidateId;       // Unique ID for the candidate
    private String firstName;         // Candidate's first name
    private String lastName;          // Candidate's last name
    private int birthDate;            // Year of birth
    private String address;           // Residential address
    private String email;             // Email address
    private String phone;             // Contact phone number
    private int candidatetype;        // Candidate type (0 = Experience, 1 = Fresher, 2 = Internship)

    // Static set to track used candidate IDs and avoid duplication
    /**
     * Default constructor for Candidates. Used when no initial data is
     * provided.
     */
    public Candidates() {
    }

    /**
     * Constructor with all candidate information.
     *
     * @param candidateId Unique identifier for the candidate
     * @param firstName Candidate's first name
     * @param lastName Candidate's last name
     * @param birthDate Year of birth
     * @param address Residential address
     * @param email Email address
     * @param phone Contact phone number
     * @param candidatetype Type of candidate (0 = Experience, 1 = Fresher, 2 =
     * Internship)
     */
    public Candidates(String candidateId, String firstName, String lastName, int birthDate, String address, String email, String phone, int candidatetype) {
        this.candidateId = candidateId; // Assign candidate ID
        this.firstName = firstName; // Assign first name
        this.lastName = lastName; // Assign last name
        this.birthDate = birthDate; // Assign birth year
        this.address = address; // Assign address
        this.email = email; // Assign email
        this.phone = phone; // Assign phone number
        this.candidatetype = candidatetype; // Assign candidate type
    }

    /**
     * Method to input candidate data using IO class with validation. Ensures ID
     * uniqueness across all candidate objects.
     */
    public void entryData() {

        // Input and validate the remaining candidate information
        firstName = io.checkFirstName();     // Validate first name
        lastName = io.checkLastName();       // Validate last name
        birthDate = io.checkBirthDate();     // Validate year of birth
        address = io.checkAddress();         // Validate address
          
    }

    // === Getter and Setter methods ===
    /**
     * Get the candidate ID.
     *
     * @return candidateId as String
     */
    public String getCandidateId() {
        return candidateId;
    }

    /**
     * Set the candidate ID.
     *
     * @param candidateId ID to assign
     */
    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    /**
     * Get the first name of the candidate.
     *
     * @return firstName as String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the candidate's first name.
     *
     * @param firstName First name to assign
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the candidate.
     *
     * @return lastName as String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the candidate's last name.
     *
     * @param lastName Last name to assign
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the candidate's birth year.
     *
     * @return birthDate as int
     */
    public int getBirthDate() {
        return birthDate;
    }

    /**
     * Set the birth year of the candidate.
     *
     * @param birthDate Year of birth
     */
    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Get the address of the candidate.
     *
     * @return address as String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address of the candidate.
     *
     * @param address Address to assign
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the email address of the candidate.
     *
     * @return email as String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the candidate.
     *
     * @param email Email to assign
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the candidate's phone number.
     *
     * @return phone as String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the phone number of the candidate.
     *
     * @param phone Phone number to assign
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get the candidate type (0 = Experience, 1 = Fresher, 2 = Internship).
     *
     * @return candidatetype as int
     */
    public int getCandidatetype() {
        return candidatetype;
    }

    /**
     * Set the type of candidate.
     *
     * @param candidatetype Candidate type identifier
     */
    public void setCandidatetype(int candidatetype) {
        this.candidatetype = candidatetype;
    }

    // === Abstract methods to be implemented by subclasses ===
    /**
     * Display detailed candidate information. Implemented differently based on
     * candidate type.
     */
    public abstract void canShow();

    /**
     * Actions to perform after search results are displayed.
     *
     * @param no Index or identifier for the candidate
     */
//    public abstract void afterSearch(int no);
    public void afterSearch(int no) {
        String nameFull = getFirstName() + " " + getLastName();  // Combine full name
        System.out.printf("|%-3d|%-16s|%-9s|%-13s|%-10s|%-17s|%-4s|\n", no, nameFull, getBirthDate(), getAddress(), getPhone(), getEmail(), getCandidatetype());  // Print candidate data
    }

    /**
     * Update candidate details.
     *
     * @param i Identifier or index of the candidate
     */
    public abstract void entryDataAttribute();
            
    public abstract void updateAbout(int i);

    public abstract void show(int no);

}
