/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author prane
 */
public class VitalSigns {

    private int cholestrol;
    private int respirationRate;
    private int bloodPressure;
    private int MRN;
    private ArrayList<VitalSigns> vitalsList;

    public VitalSigns() {
        vitalsList = new ArrayList<VitalSigns>();
    }

    public ArrayList<VitalSigns> getVitalsList() {
        return vitalsList;
    }

    public void setVitalsList(ArrayList<VitalSigns> vitalsList) {
        this.vitalsList = vitalsList;
    }

    public int getMRN() {
        return MRN;
    }

    public void setMRN(int MRN) {
        this.MRN = MRN;
    }

    public int getCholestrol() {
        return cholestrol;
    }

    public void setCholestrol(int cholestrol) {
        this.cholestrol = cholestrol;
    }

    public int getRespirationRate() {
        return respirationRate;
    }

    public void setRespirationRate(int respirationRate) {
        this.respirationRate = respirationRate;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

}
