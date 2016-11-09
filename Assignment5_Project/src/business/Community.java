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
public class Community {

    private HouseDirectory houseDirectory;

    private String communityID;
    private String communityName;
    private String communityLocation;
    private double communityCleanlinessScore;

    public Community() {
        this.houseDirectory = new HouseDirectory();

    }

    public HouseDirectory getHouseDirectory() {
        return houseDirectory;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityLocation() {
        return communityLocation;
    }

    public void setCommunityLocation(String communityLocation) {
        this.communityLocation = communityLocation;
    }

    public double getCommunityCleanlinessScore() {
        return communityCleanlinessScore;
    }

    public void setCommunityCleanlinessScore(double communityCleanlinessScore) {
        this.communityCleanlinessScore = communityCleanlinessScore;
    }

    public String getCommunityID() {
        return communityID;
    }

    public void setCommunityID(String communityID) {
        this.communityID = communityID;
    }

}
