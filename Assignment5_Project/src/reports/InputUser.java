/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import business.Patient;
import business.VitalSigns;
import java.util.Scanner;

/**
 *
 * @author Parth
 */
public class InputUser {

    double totalScore = 0;
    double otherFactors = 0;

    public double getFromUser() {

        Scanner s = new Scanner(System.in);

        Patient patient = new Patient();
        VitalSigns vs = new VitalSigns();
        System.out.println("Welcome to Framingham Heart Study \n \n This study will calculate your risk of heart disease\n");

        try {
            System.out.println("Enter first name: ");
            String firstName = s.nextLine();
            patient.setFname(firstName);

            System.out.println("Enter last name: ");
            String lastName = s.nextLine();
            patient.setLastName(lastName);

            System.out.println("Enter age: ");
            int age = s.nextInt();
            patient.setAge(age);

            System.out.println("Enter gender: ");
            String gender = s.next();
            patient.setGender(gender);

            System.out.println("Enter Social Security Number: ");
            int socialNumber = s.nextInt();
            patient.setSocialNumber(socialNumber);
            vs.setMRN(socialNumber);

            System.out.println("Are you a smoker? Give a true/false");
            boolean isSmoker = s.nextBoolean();
            patient.setIsSmoker(isSmoker);

            System.out.println("Are you insured? Give a true/false");
            boolean isInsured = s.nextBoolean();
            patient.setIsInsured(isInsured);

            System.out.println("Are you diabetic? Give a true/false");
            boolean isDiabetic = s.nextBoolean();
            patient.setIsDiabetic(isDiabetic);

            System.out.println("Please enter your cholestrol (It is measured out of 100. Eg. 85)");
            int cholestrol = s.nextInt();
            vs.setCholestrol(cholestrol);

            System.out.println("Please enter your respiration rate (It is measured out of 100 eg. 55)");
            int respirationRate = s.nextInt();
            vs.setRespirationRate(respirationRate);

            System.out.println("Please enter your blood Pressure (It is in a range of 100-150) ");
            int bloodPressure = s.nextInt();
            vs.setBloodPressure(bloodPressure);

            System.out.println("*********THANK YOU! WE ARE CALCULATING YOUR HEART RISK**********");

            System.out.println(
                    "\n \n First name: " + patient.getFname() + "\n Last name: " + patient.getLastName() + "\n age: " + patient.getAge()
                    + "\n gender: " + patient.getGender());

            if (patient.isIsSmoker() == true) {
                otherFactors = 0.5;
            }
            if (patient.isIsDiabetic() == true) {
                otherFactors = otherFactors + 0.15;
            }
            if (patient.isIsInsured() == true) {
                otherFactors = otherFactors - 0.1;
            }
            totalScore
                    = (cholestrol * 0.2 + respirationRate * 0.3 + bloodPressure * 0.09 + otherFactors + age * 0.2) / 10;

            System.out.println("Your chance of getting coronary heart disease : " + totalScore + "%\n\n");

        } catch (Exception e) {
            System.out.println("Wrong input, please try again!\n\n");
        }

        return totalScore;

    }

}
