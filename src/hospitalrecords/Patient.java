/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalrecords;

/**
 *
 * @author Peter
 */

    
public class Patient {
    
    private String patientID;
    private String name;
    private String checkInDate;
    private String assignedPersonnel;
    
    
    public Patient(String patID, String patName, String patDate, String patAssigned) {
        this.patientID = patID;
        this.name = patName;
        this.checkInDate = patDate;
        this.assignedPersonnel = patAssigned;
    
    }
    
    public String getPatientID() {
        return this.patientID;  
    }

    public String getName() {
        return this.name;
    }

    public String getCheckInDate() {
        return this.checkInDate;
    }

    public String getAssignedPersonnel() {
        return this.assignedPersonnel;
    }    
    

    

    @Override
    public String toString(){
        return "Patient ID: " + this.patientID
                + "\nName: " + this.name
                + "\nCheck in Date: " + this.checkInDate
                + "\nAssigned Medical Personnel: " + this.assignedPersonnel;
    }
}
