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
private IO io = new IO();
    private String graduation_date;
    private String graduation_rank;
    private String education;

    public Fresher() {
    }

    public Fresher(String graduation_date, String graduation_rank, String education, String candidateId, String firstName, String lastName, int birthDate, String address, String email, String phone, int candidatetype) {
        super(candidateId, firstName, lastName, birthDate, address, email, phone, candidatetype);
        this.graduation_date = graduation_date;
        this.graduation_rank = graduation_rank;
        this.education = education;
    }
    

   
    public void entryData(){
        super.entryData();
        super.setCandidatetype(1);
        graduation_date = io.checkGraduation_date();
        graduation_rank = io.checkGraduation_rank();
        education = io.checkEducation();
        
    }

    public String getGraduation_date() {
        return graduation_date;
    }

    public void setGraduation_date(String graduation_date) {
        this.graduation_date = graduation_date;
    }

    public String getGraduation_rank() {
        return graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        this.graduation_rank = graduation_rank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    

    @Override
     public void canShow() {
        System.out.println(super.getFirstName() + " " + super.getLastName());
    }

     @Override
   public void afterSearch(int no) {
        String name = super.getFirstName() + " " + super.getLastName();
        System.out.printf("|%-3d|%-16s|%-9s|%-13s|%-10s|%-17s|%-4s|\n", no, name, super.getBirthDate(), super.getAddress(), super.getPhone(), super.getEmail(), super.getCandidatetype());
    }
    @Override
    public void updateAbout(int i) {
        switch (i) {
            case 1:
                super.setCandidateId(io.checkCandidateId());
                break;
            case 2:
                super.setFirstName(io.checkFirstName());
                break;
            case 3:
                super.setLastName(io.checkLastName());
                break;
            case 4:
               
                super.setBirthDate(io.checkBirthDate());
                 break;
            case 5:
                super.setAddress(io.checkAddress());
                break;
            case 6:
                super.setEmail(io.checkEmail());
                break;
            case 7:
                super.setPhone(io.checkPhone());
                break;
            default:
                updateAttribute(i);
                break;

        }
    }

     public void updateAttribute(int i) {
        switch(i){
            case 8:
                graduation_date=io.checkGraduation_date();
                break;
            case 9:
                graduation_rank = io.checkGraduation_rank();
                break;
            case 10:
                education=io.checkEducation();
                break;
        }
    }

    @Override
    public void beforeUpdate(int i) {
         String name = super.getFirstName() + " " + super.getLastName();
        System.out.printf("|%-3d|%-16s|%-4d|\n", i, name, super.getCandidatetype());
        
    }

    @Override
    public void show(int no) {
       String name = super.getFirstName() + " " + super.getLastName();
        System.out.printf("|%-3d|%-16s|%-16s|%-9s|%-13s|%-10s|%-17s|%-4s|%-7s|%-8s|%-10s|\n",no,super.getCandidateId(),name,super.getBirthDate(),super.getAddress(),super.getPhone(),super.getEmail(), super.getCandidatetype(),getGraduation_date(),getGraduation_rank(),getEducation());
        
    }

    
    
    
    

}
