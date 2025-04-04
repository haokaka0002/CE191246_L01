/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191246_l01;

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
public class Internship extends Candidates {

    // Store the student's major
    private String majors;
    // Store the current semester of the student
    private String semester;
    // Store the university name
    private String universityName;
    // IO object to handle input
    private IO io = new IO();
      
    /**
     * Default constructor for Internship class
     */
    public Internship() {
    }

    /**
     * Constructor with full parameters including inherited fields
     *
     * @param majors the major of the intern
     * @param semester the current semester
     * @param universityName the name of the university
     * @param candidateId candidate ID
     * @param firstName first name
     * @param lastName last name
     * @param birthDate birth year
     * @param address address
     * @param email email
     * @param phone phone number
     * @param candidatetype candidate type
     */
    public Internship(String majors, String semester, String universityName, String candidateId, String firstName, String lastName, int birthDate, String address, String email, String phone, int candidatetype) {
        super(candidateId, firstName, lastName, birthDate, address, email, phone, candidatetype);  // Call the constructor of the parent class
        this.majors = majors;  // Assign the major
        this.semester = semester;  // Assign the semester
        this.universityName = universityName;  // Assign the university name
    }

    /**
     * Method to input intern-specific data
     */
    public void entryDataAttribute() {
//        / Call parent method to input common candidate data
        super.setCandidatetype(1);  // Set the candidate type to 1 (intern)
        majors = io.checkMajors();  // Input the major
        semester = io.checkSemester();  // Input the semester
        universityName = io.checkUniversityname();  // Input the university name
    }

    /**
     * Get the major of the intern
     *
     * @return major
     */
    public String getMajors() {
        return majors;  // Return the major
    }

    /**
     * Set the major of the intern
     *
     * @param majors the major to set
     */
    public void setMajors(String majors) {
        this.majors = majors;  // Assign the major
    }

    /**
     * Get the current semester
     *
     * @return semester
     */
    public String getSemester() {
        return semester;  // Return the semester
    }

    /**
     * Set the semester
     *
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;  // Assign the semester
    }

    /**
     * Get the university name
     *
     * @return university name
     */
    public String getUniversityName() {
        return universityName;  // Return the university name
    }

    /**
     * Set the university name
     *
     * @param universityName the university name to set
     */
    public void setUniversityName(String universityName) {
        this.universityName = universityName;  // Assign the university name
    }

    /**
     * Display the full name of the candidate
     */
    @Override
    public void canShow() {
        System.out.println(super.getFirstName() + " " + super.getLastName());  // Print full name
    }

    /**
     * Display brief info after search
     *
     * @param no candidate number
     */
    
    @Override
    public void afterSearch(int no) {
        String name = super.getFirstName() + " " + super.getLastName();  // Combine full name
        System.out.printf("|%-3d|%-16s|%-9s|%-13s|%-10s|%-17s|%-4s|\n", no, name, super.getBirthDate(), super.getAddress(), super.getPhone(), super.getEmail(), super.getCandidatetype());  // Print short info
    }

    /**
     * Update specific fields based on index
     *
     * @param i the index of the field to update
     */
    
    @Override
    public void updateAbout(int i) {
       String checkid="";
        switch (i) {
           
            case 1:
                super.setFirstName(io.checkFirstName());  // Update first name
                break;
            case 2:
                super.setLastName(io.checkLastName());  // Update last name
                break;
            case 3:
                super.setBirthDate(io.checkBirthDate());  // Update birth date
                break;
            case 4:
                super.setAddress(io.checkAddress());  // Update address
                break; 
            default:
                updateAttribute(i);  // Update internship-specific attribute
                break;
        }
    }

    /**
     * Update attributes specific to Internship class
     *
     * @param i the index of attribute to update
     */
    public void updateAttribute(int i) {
        switch (i) {
            case 7:
                majors = io.checkMajors();  // Update major
                break;
            case 8:
                semester = io.checkSemester();  // Update semester
                break;
            case 9:
                universityName = io.checkUniversityname();  // Update university name
                break;
        }
    }

    /**
     * Show full details of the Internship candidate
     *
     * @param no candidate number
     */
  
    public void show(int no) {
        String name = super.getFirstName() + " " + super.getLastName();  // Combine full name
        System.out.printf("|%-3d|%-16s|%-16s|%-9s|%-13s|%-10s|%-17s|%-4s|%-17s|%-8s|%-18s|\n", no, super.getCandidateId(), name, super.getBirthDate(), super.getAddress(), super.getPhone(), super.getEmail(), super.getCandidatetype(), getMajors(), getSemester(), getUniversityName());  // Print full details
    }


}
