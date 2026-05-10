package Entity;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public Patient(String id, String firstName, LocalDate dateOfBirth, String lastName, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, List<MedicalRecord> medicalRecords, String insuranceId, List<Appointment> appointments) {
        super(id, firstName, dateOfBirth, lastName, gender, phoneNumber, email, address);

        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.allergies = new ArrayList<>();
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.medicalRecords = new ArrayList<>();
        this.insuranceId = insuranceId;
        this.appointments = new ArrayList<>();
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

    // Add medical record
    public void addMedicalRecord(MedicalRecord record){
        medicalRecords.add(record);
        System.out.println("Medical record added.");
    }

}