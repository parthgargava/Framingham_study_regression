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
public class Patient extends Person {

    private int MRN;
    private boolean isSmoker;
    private boolean isInsured;
    private boolean isDiabetic;
    private ArrayList<VitalSigns> vitalSign;

    public Patient() {
        this.vitalSign = new ArrayList<>();
    }

    public ArrayList<VitalSigns> getVitalSign() {
        return vitalSign;
    }

    public void setVitalSign(ArrayList<VitalSigns> vitalSign) {
        this.vitalSign = vitalSign;
    }

    public int getMRN() {
        return MRN;
    }

    public void setMRN(int MRN) {
        this.MRN = MRN;
    }

    public boolean isIsSmoker() {
        return isSmoker;
    }

    public void setIsSmoker(boolean isSmoker) {
        this.isSmoker = isSmoker;
    }

    public boolean isIsInsured() {
        return isInsured;
    }

    public void setIsInsured(boolean isInsured) {
        this.isInsured = isInsured;
    }

    public boolean isIsDiabetic() {
        return isDiabetic;
    }

    public void setIsDiabetic(boolean isDiabetic) {
        this.isDiabetic = isDiabetic;
    }

}
