package Entity;

import Behavior.Displayable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Level 3 Inheritance
public class Surgeon extends Doctor implements Displayable {

    private int surgeriesPerformed;
    private List<String> surgeryTypes;
    private boolean operationTheatreAccess;

    // Constructor chaining to Doctor
    public Surgeon(String id, String firstName, LocalDate dateOfBirth, String lastName, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<Patient> assignedPatients, int surgeriesPerformed, List<String> surgeryTypes, boolean operationTheatreAccess) {

        // Calls Doctor constructor
        super(id, firstName, dateOfBirth, lastName, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);

        this.surgeriesPerformed = surgeriesPerformed;
        this.surgeryTypes = new ArrayList<>();
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {
        this.surgeriesPerformed = surgeriesPerformed;
    }

    public List<String> getSurgeryTypes() {
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<String> surgeryTypes) {
        this.surgeryTypes = surgeryTypes;
    }

    public boolean isOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }

    //performSurgery()

    public boolean  performSurgery(String surgeryType){

        // Validate surgery type input
        if (surgeryType == null || surgeryType.trim().isEmpty()) {
            System.out.println("Invalid surgery type.");
            return false;
        }

        if(!surgeryTypes.contains(surgeryType)){

            System.out.println("Surgery type not authorized: " + surgeryType);

            return false;
        }

        if(!operationTheatreAccess){

            System.out.println("Access denied: No operation theatre privileges.");

            return false;
        }

        surgeriesPerformed++;

        System.out.println("Surgery performed successfully: " + surgeryType);

        return true;
    }

    // updateSurgeryCount()
    public void updateSurgeryCount(int count) {

        if (count < 0) {
            System.out.println("Invalid surgery count.");
            return;
        }

        this.surgeriesPerformed = count;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("surgeries Performed : " + surgeriesPerformed);
        System.out.println("surgery Types : " + surgeryTypes);
        System.out.println("operation Theatre Access : " + operationTheatreAccess);



    }
}
