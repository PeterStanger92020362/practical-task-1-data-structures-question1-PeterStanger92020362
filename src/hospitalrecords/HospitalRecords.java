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
        
        //ArrayList<Object> hospitalRecords = new ArrayList<>();
        
        obtainRecords();
        
        System.out.println("**Patient records have been recorded successfully**\n");
        

        
        
        for (Object each: hospitalRecords){
            System.out.println(each + "\n");
            each.getName();
        }
        



        
        Patient bob = new Patient("b","B","B","B");
        System.out.println(bob.getPatientID());
        
    }
    

    
/*  
    public String searchRecords(ArrayList recordsArray, String patID) {
        
        String foundRecord = "";
        
        Iterator iterator = recordsArray.iterator();
        
        while (iterator.hasNext()) {
            Object recordPatID;
            recordPatID = iterator.next();
            recordPatID.getPatientID();
            if (each.patientID.equals(patID)){
                
            };
        }
        
        
        return foundRecord;
    }
 */   
    
    
    public static void obtainRecords() {
        
        String path = "ListOfPatients.txt";         //Use path to the ListOfPatients.txt here
        LineNumberReader lr = null;         //allows to read information from the file line by line
        String[] oneRecord = new String[4];        //an array to store info about one patient
        
        Patient pat;
              
        try {
            //using try-catch for exception handling to catch
            //possible errors with i/o operations
            FileReader inputStream = new FileReader(path);
            //FileReader reads the file’s contents
            lr = new LineNumberReader(inputStream);
            String str;
            while ((str = lr.readLine()) != null) {
                //while the next line exists
                oneRecord = str.split(",");
                //dividing one file line by commas and assigning to array
                pat = new Patient(oneRecord[0], oneRecord[1],
                        oneRecord[2], oneRecord[3]);
                
                hospitalRecords.add(pat);

                   
            }
        }
        catch (IOException ioe) {
            System.out.println("IOExcception occured");
        }
        
        
    }    
      
        
}
