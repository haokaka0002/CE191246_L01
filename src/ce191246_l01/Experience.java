/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191246_l01;

import com.sun.imageio.plugins.bmp.BMPConstants;

/**
 * L01 - title: Create a Java console program to manage Candidates of company.
 *
 * @author Phan Duc Tho - CE191246
 *
 * Date: 1/4/2025
 *
 */
public class Experience extends Candidates {

    private IO io = new IO();
    private int ExpInYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(int ExpInYear, String proSkill, String candidateId, String firstName, String lastName, int birthDate, String address, String email, String phone, int candidatetype) {
        super(candidateId, firstName, lastName, birthDate, address, email, phone, candidatetype);
        this.ExpInYear = ExpInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int ExpInYear) {
        this.ExpInYear = ExpInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public void entryData() {
        super.entryData();
        super.setCandidatetype(0);
        do{
             ExpInYear = io.expInYear();
             if((2025-getBirthDate()-5)<ExpInYear){
                 System.out.println("imposible");
                 continue;
             }else break;
            
        }while(true);
       
        proSkill = io.proSkill();
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
                ExpInYear = io.expInYear();
                break;
            case 9:
                proSkill = io.proSkill();
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
        System.out.printf("|%-3d|%-16s|%-16s|%-9s|%-13s|%-10s|%-17s|%-4s|%-10d|%-9s|\n", no,super.getCandidateId(), name, super.getBirthDate(), super.getAddress(), super.getPhone(), super.getEmail(), super.getCandidatetype(),getExpInYear(),getProSkill());
   

    }

}
