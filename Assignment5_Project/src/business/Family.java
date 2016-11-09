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
public class Family {

    private ArrayList<Patient> patientlist;

    private String familyID;
    private String lastName;

    public Family() {
        this.patientlist = new ArrayList<>();
    }

    public ArrayList<Patient> getPatientlist() {
        return patientlist;
    }

    public void setFamilylist(ArrayList<Patient> patientlist) {
        this.patientlist = patientlist;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFamilyID() {
        return familyID;
    }

    public void setFamilyID(String familyID) {
        this.familyID = familyID;
    }

}
