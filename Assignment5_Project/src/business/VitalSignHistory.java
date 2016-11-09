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
public class VitalSignHistory {

    public VitalSignHistory() {
        //vitalHistory = new ArrayList<VitalSigns>();
    }

    public VitalSigns addVitals(Patient pat) {
        VitalSigns vs = new VitalSigns();
        pat.getVitalSign().add(vs);
        return vs;
    }

}
