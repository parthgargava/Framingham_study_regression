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
public class FamilyDirectory {

    public ArrayList<Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(ArrayList<Family> familyList) {
        this.familyList = familyList;
    }

    private ArrayList<Family> familyList;

    public FamilyDirectory() {
        //this.familyList=new ArrayList<>();
    }

//    public ArrayList<Family> getfamilyist() {
//        return familyList;
//    }
//
//    public void setfamilyist(ArrayList<Family> familyList) {
//        this.familyList = familyList;
//    }
    public Family addFamily(HouseDirectory hd, House h) {
        Family hs1 = new Family();
        h.getFamilyList().add(hs1);
        return hs1;
    }

}
