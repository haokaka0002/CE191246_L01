/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191246_l01;

import java.awt.Choice;
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

    private ArrayList<Candidates> list = new ArrayList<>();

    private IO io = new IO();

    public void menu() {
        int choice;
        list.add(new Internship("toan", "tho", "fpt", "3110", "phan", "ThoInter", 1, "302", "phan@gmail.com", "0377164760", 2));
        list.add(new Internship("toan", "tho", "fpt", "3111", "phan", "Tho", 1, "302", "phan@gmail.com", "0377164760", 2));
        list.add(new Internship("toan", "tho", "fpt", "3112", "phan", "Tho", 1, "302", "phan@gmail.com", "0377164760", 2));
        list.add(new Internship("toan", "tho", "fpt", "3113", "phan", "Tho", 1, "302", "phan@gmail.com", "0377164760", 2));
        list.add(new Fresher("20/10/2006", "good", "daihoc", "se1010", "thofr", "phan", 1, "302", "phan@gmail.com", "0377164760", 1));
        list.add(new Fresher("20/10/2006", "good", "daihoc", "se1011", "tho", "phan", 1, "302", "phan@gmail.com", "0377164760", 1));
        list.add(new Fresher("20/10/2006", "good", "daihoc", "se1012", "tho", "phan", 1, "302", "phan@gmail.com", "0377164760", 1));
        list.add(new Experience(1, "yasuo", "se1910", "thoex", "phan", 1, "302", "tho@gmail.com", "0377174760", 0));
        list.add(new Experience(1, "yasuo", "se1911", "tho", "phan", 1, "302", "tho@gmail.com", "0377174760", 0));
        list.add(new Experience(1, "yasuo", "se1912", "tho", "phan", 1, "302", "tho@gmail.com", "0377174760", 0));
        do {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Update");
            System.out.println("6. Delete");
            System.out.println("7. Show");
            System.out.println("8. Show All");
            System.out.println("9. exit");
            System.out.print("Please choose: ");

            choice = io.checkChoice();
            switch (choice) {
                case 1:
                    experience();
                    break;
                case 2:
                    fresher();
                    break;
                case 3:
                    internship();
                    break;
                case 4:
                    searching();
                    break;
                case 5:
                    update();
                    break;
                case 6:
                    delete();
                    break;
                case 7:
                    show();
                    break;
                case 8:
                    showALl();
                    break;
                case 9:
                    break;
            }
        } while (choice != 9);

    }

    public void experience() {

        Candidates ex = new Experience();
        ex.setCandidateId(checkId());

        ex.entryData();
        ex.setPhone(checkPhone());
        ex.setEmail(checkEmail());
        ex.entryDataAttribute();
        list.add(ex);

    }

    public void fresher() {
        Candidates fr = new Fresher();
        fr.setCandidateId(checkId());

        fr.entryData();
        fr.setPhone(checkPhone());
        fr.setEmail(checkEmail());
        fr.entryDataAttribute();
        list.add(fr);

    }

    public void internship() {
        Candidates in = new Internship();
        in.setCandidateId(checkId());

        in.entryData();
        in.setPhone(checkPhone());
        in.setEmail(checkEmail());
        in.entryDataAttribute();
        list.add(in);

    }

    public void searching() {
        boolean check;
        System.out.println("List of candidate:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        check = false;
        for (Candidates s : list) {
            if (s instanceof Experience) {
                s.canShow();
                check = true;
            }
        }
        if (check == false) {
            System.out.println("List empty");
        }
        System.out.println("==========FRESHER CANDIDATE==============");
        check = false;
        for (Candidates s : list) {
            if (s instanceof Fresher) {
                s.canShow();
                check = true;
            }
        }
        if (check == false) {
            System.out.println("List empty");
        }
        System.out.println("===========INTERN CANDIDATE==============");
        check = false;
        for (Candidates s : list) {
            if (s instanceof Internship) {
                s.canShow();
                check = true;
            }
        }
        if (check == false) {
            System.out.println("List empty");
        }

        String nameCheck = io.searchName();
        int typeCheck = Integer.parseInt(io.checkCandidateType());
        int i = 0;
        check = false;
        System.out.println("+---+----------------+---------+-------------+----------+-----------------+----+");
        System.out.println("|No.|Fullname        |Birthdate|Address      |Phone     |Email            |Type|");
        System.out.println("+---+----------------+---------+-------------+----------+-----------------+----+");

        for (Candidates s : list) {
            if (s.getFirstName().contains(nameCheck) || s.getLastName().contains(nameCheck)) {
                if (typeCheck == 0) {
                    if (s instanceof Experience) {
                        i++;
                        s.afterSearch(i);
                        check = true;
                    }

                } else if (typeCheck == 1) {
                    if (s instanceof Fresher) {
                        i++;
                        s.afterSearch(i);
                        check = true;
                    }

                } else if (typeCheck == 2) {
                    if (s instanceof Internship) {
                        i++;
                        s.afterSearch(i);
                        check = true;
                    }

                }

            }
        }
        System.out.println("+---+----------------+---------+-------------+----------+-----------------+----+");

        if (!check) {
            System.out.println("list Empty");
        }

    }

    /**
     * 1 id
     *
     *
     *
     * 7.email
     *
     * if s instanceof Experience 8.exp in year
     *
     * else s instance of Fresher
     *
     * 8.graduation_date
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

            
            System.out.println("1. Update firstName ");
            System.out.println("2. Update lastName ");
            System.out.println("3. Update birthDate ");
            System.out.println("4. Update address ");
            System.out.println("5. Update email ");
            System.out.println("6. Update phone ");
            if (list.get(select - 1) instanceof Experience) {
                System.out.println("7. Update Experience Of Years");
                System.out.println("8. Update ProSkill");
            } else if (list.get(select - 1) instanceof Fresher) {
                System.out.println("7. Update Graduation Date");
                System.out.println("8. Update Graduation Rank");
                System.out.println("9. Update Education");

            } else {
                System.out.println("7. Update  Majors");
                System.out.println("8. Update Semester");
                System.out.println("9. universityName");
            }

            checkUp = Integer.parseInt(io.checkNumber());
            
            if (checkUp == 6) {
                list.get(select - 1).setPhone(checkPhone());
            }
            if (checkUp == 5) {
                list.get(select - 1).setPhone(checkEmail());
            } else {
                //   in menu nguoi dung can update gi
                // int select = io.kiem tra phan can update
                list.get(select - 1).updateAbout(checkUp);
            }
            System.out.println("update successfully!");
        }

    }

    public void delete() {

        showALl();
        String choice;
        if (!list.isEmpty()) {
            int index = Integer.parseInt(io.checkDelete());
            if (index > list.size()) {
                System.out.println("Not find to delete");
            }
            choice =io.checkChoiceDelete();
            if(choice.equalsIgnoreCase("yes")){

                list.remove(index - 1);
                System.out.println("Delete successfully");
            }
        }
    }

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

            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+----------------+"); // Table header
            System.out.println("|No.|CandidatesID    |Fullname        |Birthdate|Address      |Phone     |Email            |Type|ExpInYear |ProSkill        |"); // Columns
            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+----------------+"); // Separator
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Experience) {

                list.get(i).show(i + 1);
                check = true;
            }
        }

        if (countEx != 0) {//check is have data or no

            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+----------------+"); // Footer
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
                list.get(i).show(i + 1);
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
            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+-----------------+--------+------------------+"); // Header
            System.out.println("|No.|CandidatesID    |Fullname        |Birthdate|Address      |Phone     |Email            |Type|Major            |Semester|University        |"); // Columns
            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+-----------------+--------+------------------+"); // Separator
        }
        for (int i = 0; i < list.size(); i++) {// Loop through list
            if (list.get(i) instanceof Internship) {//check is have data or no
                list.get(i).show(i + 1);
                check = true; // Found
            }
        }
        if (countIn != 0) {//check is have data or no
            System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+-----------------+--------+------------------+"); // Footer
        }
        if (!check) {//check is have data or no
            System.out.println("List empty"); // Inform user
        }

    }

    public void show() {
        int i = 0;
        System.out.println("+---+----------------+---------+-------------+----------+-----------------+----+");
        System.out.println("|No.|Fullname        |Birthdate|Address      |Phone     |Email            |Type|");
        System.out.println("+---+----------------+---------+-------------+----------+-----------------+----+");
        for (Candidates s : list) {
            i++;
            s.afterSearch(i);
        }
        System.out.println("+---+----------------+---------+-------------+----------+-----------------+----+");

    }

    public String checkId() {
        String checkid;
        boolean check;
        do {
            check = false;
            checkid = io.checkCandidateId();
            for (Candidates ca : list) {
                if (checkid.equalsIgnoreCase(ca.getCandidateId())) {
                    System.out.println("ID is used");
                    check = true;
                }

            }
        } while (check);
        return checkid;

    }

    public String checkPhone() {
        String checkphone;
        boolean check;
        do {
            check = false;
            checkphone = io.checkPhone();
            for (Candidates ca : list) {
                if (checkphone.equalsIgnoreCase(ca.getPhone())) {
                    System.out.println("Phone is used");
                    check = true;
                }

            }
        } while (check);
        return checkphone;

    }

    public String checkEmail() {
        String checkemail;
        boolean check;
        do {
            check = false;
            checkemail = io.checkEmail();
            for (Candidates ca : list) {
                if (checkemail.equalsIgnoreCase(ca.getEmail())) {
                    System.out.println("Email is used");
                    check = true;
                }

            }
        } while (check);
        return checkemail;

    }
}
