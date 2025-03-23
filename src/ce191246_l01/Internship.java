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
public class Internship extends Candidates{
    private String majors;
    private String semester;
    private String universityName;
    private IO io = new IO();

    public Internship() {
    }

    public Internship(String majors, String semester, String universityName, String candidateId, String firstName, String lastName, int birthDate, String address, String email, String phone, int candidatetype) {
        super(candidateId, firstName, lastName, birthDate, address, email, phone, candidatetype);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    
    
    public void entryData(){
        super.entryData();
        super.setCandidatetype(1);
       majors = io.checkMajors();
       semester = io.checkSemester();
       universityName=io.checkUniversityname();
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
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
                majors=io.checkMajors();
                break;
            case 9:
              semester=io.checkSemester();
                break;
            case 10:
               universityName=io.checkUniversityname();
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
        System.out.printf("|%-3d|%-16s|%-16s|%-9s|%-13s|%-10s|%-17s|%-4s|%-7s|%-8s|%-10s|\n",no,super.getCandidateId(),name,super.getBirthDate(),super.getAddress(),super.getPhone(),super.getEmail(), super.getCandidatetype(),getMajors(),getSemester(),getUniversityName());
    }
    
    
}
