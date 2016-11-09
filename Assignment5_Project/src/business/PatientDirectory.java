/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author Parth
 */
public class PatientDirectory {

    //private ArrayList<Person> personList;
    public PatientDirectory() {
        //this.personList=new ArrayList<>();
    }
//
//    public ArrayList<Person> getpersonList() {
//        return personList;
//    }

//    public void setpersonist(ArrayList<Person> personList) {
//        this.personList = personList;
//    }
    public Patient addPatient(FamilyDirectory fd, Family fam) {
        Patient hs1 = new Patient();
        fam.getPatientlist().add(hs1);
        return hs1;
    }

}
