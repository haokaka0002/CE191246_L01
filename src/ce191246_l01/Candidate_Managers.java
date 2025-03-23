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
        do {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Update");
            System.out.println("6. Delete");
            System.out.println("7. Show");
            System.out.println("8. Exit");
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
        ex.entryData();
        list.add(ex);

    }

    public void fresher() {
        Candidates fr = new Fresher();
        fr.entryData();
        list.add(fr);

    }

    public void internship() {
        Candidates in = new Internship();
        in.entryData();
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

    public void delete() {

        showALl();
        if (!list.isEmpty()) {
            int index = Integer.parseInt(io.checkDelete());

            list.remove(index - 1);
            System.out.println("Delete successfully");
        }
    }

    public void showALl() {

        //ten type sothutu
        boolean check;
        System.out.println("List of candidate:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        check = false;
        System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+---------+");
        System.out.println("|No.|CandidatesID    |Fullname        |Birthdate|Address      |Phone     |Email            |Type|ExpInYear |ProSkill |");
        System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+---------+");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Experience) {

                list.get(i).show(i + 1);
                check = true;
            }
        }

        System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+---------+");

        if (!check) {
            System.out.println("List empty");
        }
        System.out.println("==========FRESHER CANDIDATE==============");
        check = false;
        System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+--------+----------+");
        System.out.println("|No.|CandidatesID    |Fullname        |Birthdate|Address      |Phone     |Email            |Type|Date      |Rank    |Education |");
        System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+--------+----------+");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Fresher) {

                list.get(i).show(i + 1);
                check = true;
            }
        }
        System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+----------+--------+----------+");

        if (!check) {
            System.out.println("List empty");
        }
        System.out.println("===========INTERN CANDIDATE==============");
        check = false;
        System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+-------+--------+----------+");
        System.out.println("|No.|CandidatesID    |Fullname        |Birthdate|Address      |Phone     |Email            |Type|Major  |Semester|University|");
        System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+-------+--------+----------+");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Internship) {
                list.get(i).show(i + 1);
                check = true;
            }
        }

        System.out.println("+---+----------------+----------------+---------+-------------+----------+-----------------+----+-------+--------+----------+");
        if (!check) {
            System.out.println("List empty");
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
}
