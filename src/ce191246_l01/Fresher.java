/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191246_l01;

/**
 * L01 - title: Create a Java console program to manage Candidates of company.
 *
 * @author Phan Duc Tho - CE191246
 *
 * Date: 1/4/2025
 *
 */
public class Fresher extends Candidates {

    // Create an IO object to handle input operations
    private IO io = new IO();
    // Store graduation date
    private String graduation_date;
    // Store graduation rank
    private String graduation_rank;
    // Store education background
    private String education;

    /**
     * Default constructor for Fresher class
     */
    public Fresher() {
    }

    /**
     * Constructor with all attributes, including inherited ones
     *
     * @param graduation_date the date of graduation
     * @param graduation_rank the rank at graduation
     * @param education the education institution or field
     * @param candidateId ID of the candidate
     * @param firstName first name
     * @param lastName last name
     * @param birthDate birth year
     * @param address address of the candidate
     * @param email email of the candidate
     * @param phone phone number
     * @param candidatetype candidate type identifier
     */
    public Fresher(String graduation_date, String graduation_rank, String education, String candidateId, String firstName, String lastName, int birthDate, String address, String email, String phone, int candidatetype) {
        super(candidateId, firstName, lastName, birthDate, address, email, phone, candidatetype);  // Call parent constructor
        this.graduation_date = graduation_date;  // Set graduation date
        this.graduation_rank = graduation_rank;  // Set graduation rank
        this.education = education;  // Set education background
    }

    /**
     * Method to enter data specific to Fresher candidate
     */
    public void entryData() {
        super.entryData();  // Call the entryData method from parent class
        super.setCandidatetype(1);  // Set candidate type as Fresher (1)
        graduation_date = io.checkGraduation_date();  // Get graduation date from input
        graduation_rank = io.checkGraduation_rank();  // Get graduation rank from input
        education = io.checkEducation();  // Get education info from input
    }

    /**
     * Get the graduation date
     *
     * @return graduation date
     */
    public String getGraduation_date() {
        return graduation_date;  // Return the graduation date
    }

    /**
     * Set the graduation date
     *
     * @param graduation_date the new graduation date to set
     */
    public void setGraduation_date(String graduation_date) {
        this.graduation_date = graduation_date;  // Set the graduation date
    }

    /**
     * Get the graduation rank
     *
     * @return graduation rank
     */
    public String getGraduation_rank() {
        return graduation_rank;  // Return the graduation rank
    }

    /**
     * Set the graduation rank
     *
     * @param graduation_rank the new graduation rank to set
     */
    public void setGraduation_rank(String graduation_rank) {
        this.graduation_rank = graduation_rank;  // Set the graduation rank
    }

    /**
     * Get the education
     *
     * @return education
     */
    public String getEducation() {
        return education;  // Return the education
    }

    /**
     * Set the education
     *
     * @param education the new education to set
     */
    public void setEducation(String education) {
        this.education = education;  // Set the education
    }

    /**
     * Display candidate full name
     */
    @Override
    public void canShow() {
        System.out.println(super.getFirstName() + " " + super.getLastName());  // Print full name
    }

    /**
     * Display basic info after search
     *
     * @param no the index or number of the candidate
     */
    
    public void afterSearch(int no) {
        String name = super.getFirstName() + " " + super.getLastName();  // Combine full name
        System.out.printf("|%-3d|%-16s|%-9s|%-13s|%-10s|%-17s|%-4s|\n", no, name, super.getBirthDate(), super.getAddress(), super.getPhone(), super.getEmail(), super.getCandidatetype());  // Print formatted candidate info
    }

    /**
     * Update candidate information based on field index
     *
     * @param i the field index to update
     */
    
    public void updateAbout(int i) {
        switch (i) {
            case 1:
                super.setCandidateId(io.checkCandidateId());  // Update candidate ID
                break;
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
            case 6:
                super.setEmail(io.checkEmail());  // Update email
                break;
            case 7:
                super.setPhone(io.checkPhone());  // Update phone
                break;
            default:
                updateAttribute(i);  // Update attributes specific to Fresher
                break;
        }
    }

    /**
     * Update attributes specific to Fresher
     *
     * @param i the field index to update
     */
    public void updateAttribute(int i) {
        switch (i) {
            case 8:
                graduation_date = io.checkGraduation_date();  // Update graduation date
                break;
            case 9:
                graduation_rank = io.checkGraduation_rank();  // Update graduation rank
                break;
            case 10:
                education = io.checkEducation();  // Update education
                break;
        }
    }

    /**
     * Show candidate info before updating
     *
     * @param i the index of candidate
     */
    /**
     * Show full details of Fresher candidate
     *
     * @param no the order number for display
     */
    public void show(int no) {
        String name = super.getFirstName() + " " + super.getLastName();  // Combine full name
        System.out.printf("|%-3d|%-16s|%-16s|%-9s|%-13s|%-10s|%-17s|%-4s|%-9s|%-8s|%-10s|\n", no, super.getCandidateId(), name, super.getBirthDate(), super.getAddress(), super.getPhone(), super.getEmail(), super.getCandidatetype(), getGraduation_date(), getGraduation_rank(), getEducation());  // Print all details
    }
}
