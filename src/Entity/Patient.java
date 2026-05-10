package Entity;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Patient extends Person {


    private String patientId;
    private String bloodGroup;
    private List<String> allergies;
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<MedicalRecord> medicalRecords;
    private List <Appointment>appointments;

    public Patient(String id, String firstName, LocalDate dateOfBirth, String lastName, String gender, String phoneNumber, String email, String address) {
        super(id, firstName, dateOfBirth, lastName, gender, phoneNumber, email, address);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("patient Id : "+ patientId);
        System.out.println("patient blood Group : "+ bloodGroup);
        System.out.println("patient allergies : "+ allergies);
        System.out.println("patient emergency Contact : "+ emergencyContact);
        System.out.println("patient registration Date : "+ registrationDate);
        System.out.println("patient insuranceId : "+ insuranceId);
        System.out.println("patient medical Records : "+ medicalRecords);
        System.out.println("patient appointments : "+ appointments);

    }

    public void addMedicalRecord(){

        System.out.println("Add new medical");


    }

}