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
public class HouseDirectory {

    private ArrayList<House> houseList;

    public HouseDirectory() {
        this.houseList = new ArrayList<>();
    }

    public ArrayList<House> gethouseList() {
        return houseList;
    }

    public void sethouseist(ArrayList<House> houseList) {
        this.houseList = houseList;
    }

    public House addHouse(CommunityDirectory cd, Community com) {
        House hs1 = new House();
        com.getHouseDirectory().gethouseList().add(hs1);
        return hs1;
    }

}
