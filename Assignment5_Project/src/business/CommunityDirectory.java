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
public class CommunityDirectory {

    private ArrayList<Community> communityDirectory;

    public CommunityDirectory() {
        //communityDirectory= new ArrayList<>();
    }

    public ArrayList<Community> getCommunityDirectory() {
        return communityDirectory;
    }

    //PR - modified it to create a new list
    public void setCommunityDirectory() {
        this.communityDirectory = new ArrayList<>();

    }

    public Community addCommunity() {
        //communityDirectory= new ArrayList<>();
        Community comm = new Community();
        communityDirectory.add(comm);
        return comm;
    }

}
