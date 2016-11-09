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
public class House {

    private String houseAddress;
    private String houseNumber;
    private String houseID;

    public ArrayList<Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(ArrayList<Family> familyList) {
        this.familyList = familyList;
    }

    private ArrayList<Family> familyList;

    public House() {
        this.familyList = new ArrayList<>();
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseID() {
        return houseID;
    }

    public void setHouseID(String houseID) {
        this.houseID = houseID;
    }

}
