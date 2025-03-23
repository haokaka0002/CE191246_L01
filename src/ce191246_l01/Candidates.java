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
public abstract class Candidates {
    
    private IO io = new IO();
    
    private String candidateId;
    private String firstName;
    private String lastName;
    private int birthDate;
    private String address;
    private String email;
    private String phone;
    private int candidatetype;

    public Candidates() {
    }

    public Candidates(String candidateId, String firstName, String lastName, int birthDate, String address, String email, String phone, int candidatetype) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.candidatetype = candidatetype;
    }
    
    public void entryData(){
        candidateId = io.checkCandidateId();
        firstName = io.checkFirstName();
        lastName = io.checkLastName();
        birthDate = io.checkBirthDate();
        address = io.checkAddress();
        email = io.checkEmail();
        phone = io.checkPhone();
        
    }
    
    
    

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCandidatetype() {
        return candidatetype;
    }

    public void setCandidatetype(int candidatetype) {
        this.candidatetype = candidatetype;
    }
    
    public abstract void canShow();
    
    public abstract void afterSearch(int no);
    
    public abstract void updateAbout(int i);
    
    public abstract void beforeUpdate(int i);
    
    public abstract void show(int no);
    
    
}
