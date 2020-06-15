/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalrecords;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class HospitalRecords {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<Patient> hospitalRecords = new ArrayList<>();  
    
    
    public static void main(String[] args) {
        
        obtainRecords();
        
        Scanner sc = new Scanner(System.in);
        String input = "";

        OUTER:
        while (true) {
            System.out.println("\nPress S for Search, Press E for exit");
            input = sc.nextLine();

            switch (input.toLowerCase()) {
                case "s":
                    System.out.println("Enter Patient ID to search\n");
                    input = sc.nextLine();
                    System.out.println(searchRecords(input));
                    break;
                case "e":
                    break OUTER;
                default:
                    break;
            }
        }
        
        System.out.println("Bye...");
        
                 
    }
    

    
  
    public static String searchRecords(String patID) {
        
        String foundRecord = "";
        
        for (int i = 0; i < hospitalRecords.size(); i++) {
                      
            if (hospitalRecords.get(i).getPatientID().toLowerCase().equals(patID.toLowerCase()) ){
                System.out.println("\n" + hospitalRecords.get(i).toString() +"\n");
                int index = i;
                foundRecord = removeRecord(index);
                break;
            } else {
                foundRecord = "The search found no matching patient.";
            }
        }    

        return foundRecord;
    }
    
    public static String removeRecord(int index){
        
        System.out.println("Would you like to remove the patient's record(s)?");
        System.out.println("Y or N?");
              
        String result;
        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
              
        if (input.toLowerCase().equals("y")){
            hospitalRecords.remove(index);
            result = "Record(s) removed successfully";
        } else {
            result = "No record(s) removed.";
        }
        return result;
    }
  

    
    public static void obtainRecords() {
        
        String path = "ListOfPatients.txt";         //Use path to the ListOfPatients.txt here
        LineNumberReader lr = null;         //allows to read information from the file line by line
        String[] oneRecord = new String[4];        //an array to store info about one patient
        
        Patient pat;
              
        try {
            //using try-catch for exception handling to catch
            //possible errors with i/o operations
            FileReader inputStream = new FileReader(path);              //FileReader reads the file’s contents
            lr = new LineNumberReader(inputStream);
            String str;
            while ((str = lr.readLine()) != null) {                 //while the next line exists
                oneRecord = str.split(",");                 //dividing one file line by commas and assigning to array
                
                pat = new Patient(oneRecord[0], oneRecord[1],
                        oneRecord[2], oneRecord[3]);
                
                hospitalRecords.add(pat);
                   
            }
            System.out.println("**Patient records have been recorded successfully**");
        }
        catch (IOException ioe) {
            System.out.println("IOExcception occured");
        }
        
        
        
    }    
      
        
}