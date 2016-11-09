/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import business.City;
import business.Community;
import business.CommunityDirectory;
import business.Family;
import business.FamilyDirectory;
import business.House;
import business.HouseDirectory;
import business.Patient;
import business.PatientDirectory;
import business.Person;
import business.PersonDirectory;
import business.VitalSignHistory;
import business.VitalSigns;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import logic.RandomGenerator;

/**
 *
 * @author Parth
 */
public class TestClass {

    public static void ageVsBloodPressure() { //linear regression
        Scanner scanAge = new Scanner(System.in);
        double[] age = {5, 14, 23, 32, 43, 40, 45, 53};

        double[] bloodPressure = {100, 110, 120, 133, 137, 138, 150, 153};

        RegressionModel model = new LinearRegressionModel(age, bloodPressure);
        model.compute();
        double[] coefficients = model.getCoefficients();

        System.out.printf("Output from our code: y = %.4f + %.4fx", coefficients[0], coefficients[1]);

        System.out.println("\n \n Predict bloodpressure for age \n");

        int inputAge = scanAge.nextInt();
        
        double predictedOutput= model.evaluateAt(inputAge);


        System.out.println("The predicated blood pressure at age: " + inputAge + "\n blood pressure: \n" + predictedOutput);

    }

    public static void main(String h[]) {

        int personCounter = 0;
        int communityCounter = 0;
        int houseCounter = 0;
        int familyCounter = 0;
        double totalScore = 0;

        Random randomGenerator = new Random();
        RandomGenerator classGenerator = new RandomGenerator();

        InputUser inputUser = new InputUser();
        totalScore = inputUser.getFromUser();

        System.out.println("\nThank you for using risk score analyser\n\n");

        City city = new City();
        city.setName("Flamingham");
/**
 *
 */
        CommunityDirectory communityDirectory1 = new CommunityDirectory();

        communityDirectory1.setCommunityDirectory();
        Community commarr[] = new Community[10];
        House house[] = new House[10];
        Family family[] = new Family[10];
        Person person[] = new Person[10];
        Patient patient[] = new Patient[1000];
        VitalSigns vitals[] = new VitalSigns[1000];
        Patient patientTemp[] = new Patient[1000];

        for (int i = 0; i < 10; ++i) { //populating 10 communities
            commarr[i] = new Community();
            commarr[i] = communityDirectory1.addCommunity();
            commarr[i].setCommunityName("CommunityName_" + i);
            commarr[i].setCommunityLocation("Location_" + RandomGenerator.randInt(1, 10) + i);
            commarr[i].setCommunityCleanlinessScore(RandomGenerator.randDouble(5, 10));
            commarr[i].setCommunityID("" + communityCounter);
            HouseDirectory houseDirectory = new HouseDirectory();
            communityCounter++;

            for (int j = 0; j < 10; ++j) { //populating 10 houses
                house[j] = new House();
                house[j] = houseDirectory.addHouse(communityDirectory1, commarr[i]);
                house[j].setHouseAddress("House address_" + RandomGenerator.randInt(100, 200));
                house[j].setHouseNumber("Unit " + "00" + RandomGenerator.randInt(1, 10));
                house[j].setHouseID("" + houseCounter);
                houseCounter++;

                FamilyDirectory familyDirectory = new FamilyDirectory();
                for (int k = 0; k < 2; ++k) { //populating 2 family per house
                    family[k] = new Family();
                    family[k] = familyDirectory.addFamily(houseDirectory, house[j]);

                    family[k].setLastName("LastName_" + RandomGenerator.randInt(1, 400));
                    family[k].setFamilyID("" + familyCounter);
                    PersonDirectory personDirectory = new PersonDirectory();
                    PatientDirectory patientDirectory = new PatientDirectory();
                    VitalSignHistory vsh = new VitalSignHistory();

                    familyCounter++;
                    for (int l = 0; l < 5; ++l) { //populating 5 person in 1 house
//We have used the concept of inheritence where every patient is a child of person (Parent class).
//Therefore, since parent attributes and methods can be accessed by child, we create just the child object!

                        patient[l] = new Patient();
                        patient[l] = patientDirectory.addPatient(familyDirectory, family[k]);
                        patient[l].setFname("FirstName_" + classGenerator.generateString(randomGenerator, "SAPRAT", 5));
                        patient[l].setLastName(family[k].getLastName());
                        patient[l].setSocialNumber(personCounter);
                        patient[l].setMobNumber("" + RandomGenerator.randInt(1000000, 99999999));
                        patient[l].setAge(RandomGenerator.randInt(20, 80));
                        patient[l].setIncome(RandomGenerator.randInt(10000, 999999));
                        patient[l].setGender(RandomGenerator.generateGender());

                        patient[l].setMRN(RandomGenerator.randInt(100000, 999999));
                        patient[l].setIsDiabetic(RandomGenerator.getRandomBoolean());
                        patient[l].setIsInsured(RandomGenerator.getRandomBoolean());
                        patient[l].setIsSmoker(RandomGenerator.getRandomBoolean());

                        for (int m = 0; m < 5; ++m) { //adding 5 vitals to each of the patient
                            vitals[m] = new VitalSigns();
                            vitals[m] = vsh.addVitals(patient[l]);
                            vitals[m].setBloodPressure(RandomGenerator.randInt(100, 150));
                            vitals[m].setCholestrol(RandomGenerator.randInt(100, 150));
                            vitals[m].setRespirationRate(RandomGenerator.randInt(80, 100));
                        }

                        personCounter++;
                    }

                }
            }

        }

//this is to create an array of patient type which stores all patients directly (temporary)
        int yu = 0;
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 5; l++) {

                        patientTemp[yu]
                                = communityDirectory1.getCommunityDirectory().get(i).getHouseDirectory().gethouseList().get(j).getFamilyList().get(k).getPatientlist().get(l);
                        yu++;
                    }

                }
            }

        }

        try {

            //REPORT GENERATION PHASE!
//report 1 community level
            System.out.println("\n These are the reports generated in city flamingham");
            double cleanlinessScore = 0;
            int maleCount = 0;

            //AVERAGE COMMUNITY SCORE
            for (int q = 0; q < 10; q++) {
                cleanlinessScore = (cleanlinessScore + communityDirectory1.getCommunityDirectory().get(q).getCommunityCleanlinessScore());
            }
            System.out.println("\n Average community cleanliness score of the city (on a scale of 10):  " + cleanlinessScore / 10 + "\n");

//report 2 community level
//NUMBER OF MALES IN THE CITY
            for (int w = 0; w < 1000; w++) {
                if (patientTemp[w].getGender() == "Male") {
                    maleCount = maleCount + 1;
                }
            }
            System.out.println("Number of male citizens in the city are: " + maleCount + "\n");

//report 3 community level
//BEST CLEANLINESS SCORE COMMUNITY
            double maxCleanlinessScore = (double) communityDirectory1.getCommunityDirectory().get(0).getCommunityCleanlinessScore();
            for (int k = 1; k < 10; ++k) {
                if (communityDirectory1.getCommunityDirectory().get(k).getCommunityCleanlinessScore() > maxCleanlinessScore) {
                    maxCleanlinessScore = communityDirectory1.getCommunityDirectory().get(k).getCommunityCleanlinessScore();
                }

            }
            System.out.println("The highest community level cleanliness score(on a scale of 10) is: " + maxCleanlinessScore);

//report 2 community level
//AVERAGE POPULATION PER COMMUNITY
            int counterPopulation = 0;
            int communityPopulation = 0;
            for (int i = 0; i < 1000; i++) {
                if (patientTemp[i] != null) {
                    counterPopulation++;
                }
            }
            System.out.println(counterPopulation + " is the total population\n");

            for (int j = 0; j < 10; ++j) {
                if (communityDirectory1.getCommunityDirectory().get(j) != null) {
                    communityPopulation++;
                }
            }
            System.out.println(communityPopulation + " is the community population\n");

            System.out.println("Average population per community is: " + counterPopulation / communityCounter + "\n\n");

//report 3 Community Level
//ALL COMMUNITY WITH LOCATION ID
            System.out.println("\n \n List of all communities and location!");
            for (int u = 0; u < 10; u++) {
                System.out.println("Community ID  " + communityDirectory1.getCommunityDirectory().get(u).getCommunityID() + " with Location " + communityDirectory1.getCommunityDirectory().get(u).getCommunityLocation());
            }

//Person
//Report 1
//Age is greater than 40
//PERSON WITH AGE>40
            int population_greater_40 = 0;

            for (int i = 0; i < 1000; i++) {
                if (patientTemp[i].getAge() > 40) {
                    population_greater_40++;
                }
            }
            System.out.println("\n\nTotal population greater than 40--->" + population_greater_40 + "\n");

//House Level
//Report 1
//No. of Families in community 1 house 
            Scanner input = new Scanner(System.in);
            System.out.println("\nEnter Community number: ");
            String communityinput = input.nextLine();
            System.out.println("\nEnter House number: ");
            String houseinput = input.nextLine();
            int families_in_comm1_house1
                    = communityDirectory1.getCommunityDirectory().get(Integer.parseInt(communityinput))
                    .getHouseDirectory().gethouseList().get(Integer.parseInt(houseinput)).getFamilyList().size();
            String houseaddress = communityDirectory1.getCommunityDirectory().get(Integer.parseInt(communityinput))
                    .getHouseDirectory().gethouseList().get(Integer.parseInt(houseinput)).getHouseAddress();
            yu++;
            System.out.println("\nNo. of Families in community and house are: " + families_in_comm1_house1);
            System.out.println("\nHouse address of these families is: " + houseaddress);

//Report2
//House Address of last house in the last community
            String agegreaterthan40_in_comm1
                    = communityDirectory1.getCommunityDirectory().get(9)
                    .getHouseDirectory().gethouseList().get(9).getHouseAddress();

            System.out.println("\n\nHouse Address of last house in the last community: \n" + agegreaterthan40_in_comm1);

//Report3
//Total Houses in the city
            int totalhouses = 0;
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < 10; j++) {
                    //     for (int k=0;k<2;++k)
                    //     {
                    totalhouses = totalhouses + communityDirectory1.getCommunityDirectory().get(i)
                            .getHouseDirectory().gethouseList().get(j).getFamilyList().size();
                    //}
                }

            }
            System.out.println("\n\nTotal houses in the city---->" + totalhouses);

//Report3
//Total Houses in the city
            double blood_pressure = 0;
            double cholestrol = 0;
            double respirationrate = 0;
            Scanner inputnew = new Scanner(System.in);
            System.out.println("\n\nEnter Community number (1-10)");
            String newcommunityinput = input.nextLine();
            System.out.println("Enter House number");
            String newhouseinput = input.nextLine();
            System.out.println("Enter Family Number (For any house it is either 0 or 1)");
            String newfamilyinput = input.nextLine();
            System.out.println("Enter Person number (For any family there can be upto 5 persons) ");
            String newpersoninput = input.nextLine();
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < 2; ++k) {
                        for (int l = 0; l < 5; ++l) {
                            for (int m = 0; m < 5; ++m) {

                                blood_pressure = communityDirectory1.getCommunityDirectory().get(Integer.parseInt(newcommunityinput))
                                        .getHouseDirectory().gethouseList().get(Integer.parseInt(newhouseinput)).getFamilyList().get(Integer.parseInt(newfamilyinput)).getPatientlist().get(Integer.parseInt(newpersoninput)).getVitalSign().get(m).getBloodPressure();
                                cholestrol = communityDirectory1.getCommunityDirectory().get(i)
                                        .getHouseDirectory().gethouseList().get(j).getFamilyList().get(k).getPatientlist().get(l).getVitalSign().get(m).getCholestrol();
                                respirationrate = communityDirectory1.getCommunityDirectory().get(i)
                                        .getHouseDirectory().gethouseList().get(j).getFamilyList().get(k).getPatientlist().get(l).getVitalSign().get(m).getRespirationRate();
                            }
                        }
                    }
                }

            }
            System.out.println("\nAverage Vitals of the Person");
            System.out.println("Blood Pressure-->" + blood_pressure / 5);
            System.out.println("Cholestrol-->" + cholestrol / 5);
            System.out.println("Respiration Rate-->" + respirationrate / 5);

//report 1 All family names
            int familyNameCount = 0;

            Scanner s = new Scanner(System.in);
            System.out.println(" \n\nEnter family ID where familyID varies from 0-199");
            String inputFamilyID = s.nextLine();

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < 2; k++) {
                        if (communityDirectory1.getCommunityDirectory().get(i).getHouseDirectory().gethouseList().get(j).getFamilyList().get(k).getFamilyID().equals(inputFamilyID)) {
                            System.out.println(communityDirectory1.getCommunityDirectory().get(i).getHouseDirectory().gethouseList().get(j).getFamilyList().get(k).getLastName() + "is the surname of the family");
                        }

                    }
                }
            }

//
            System.out.println("\n\nUsing linear regression (machine algorithm) we try to predict the line for a person with dependency on bloodPressure and age!");
            ageVsBloodPressure();
        } catch (Exception e) {
            System.out.println("Wrong input for report generation!");
        }
    }

}
