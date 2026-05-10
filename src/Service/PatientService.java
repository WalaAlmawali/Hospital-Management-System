package Service;

import Entity.Appointment;
import Entity.MedicalRecord;
import Entity.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService {
    Scanner scanner = new Scanner(System.in);

    static List<Patient> patients = new ArrayList<>();
    List<MedicalRecord> medicalRecords = new ArrayList<>();
    List<Appointment> appointments = new ArrayList<>();


    public Patient addPatient(){


        System.out.println("Enter patient id :");
        String patientId = scanner.nextLine();

        System.out.println("Enter patient first name :");
        String patientFName = scanner.nextLine();

        System.out.println("Enter patient last name :");
        String patientLName = scanner.nextLine();

        System.out.println("Enter patient DOB: ");
        String dateOfBirth = scanner.nextLine();
        LocalDate DOB = LocalDate.parse(dateOfBirth);

        System.out.println("Enter patient gender :");
        String gender = scanner.nextLine();

        System.out.println("Enter patient phone number :");
        String phone = scanner.nextLine();

        System.out.println("Enter patient email :");
        String email = scanner.nextLine();

        System.out.println("Enter patient address :");
        String address = scanner.nextLine();

        System.out.println("Enter patient id :");
        String patientID = scanner.nextLine();

        System.out.println("Enter patient blood Group :");
        String bloodGroup = scanner.nextLine();

        System.out.println("Enter patient emergency Contact :");
        String emergencyContact = scanner.nextLine();

        System.out.println("Enter registration Date :");
        String dateOfRegistration = scanner.nextLine();
        LocalDate DOR = LocalDate.parse(dateOfBirth);


        System.out.println("Enter patient insurance Id :");
        String insuranceId = scanner.nextLine();

        System.out.println("Enter patient allergies :");

        Boolean continueFlag = true;

        List<String> allergies = new ArrayList<>();

        while (continueFlag) {

            allergies.add(scanner.nextLine());
            System.out.println("Enter c to add more allergies , and q to exit");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }

        Patient patient = new Patient(patientId,patientFName,DOB,patientLName,gender,phone,email,address,patientID,bloodGroup,allergies,emergencyContact,DOR,medicalRecords,insuranceId,appointments);

        return patient;
    }
    public List<Patient> addPatients(){

        Boolean continueFlag = true;
        while (continueFlag) {

            patients.add(addPatient());
            System.out.println("Patient add successfully");

            System.out.println("Enter c to add more , and q to exit");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return patients;

    }

   public void editPatient(String patientId, Patient updatedPatient){

        for(Patient patient: patients ){

            if(patient.getId().equals(patientId)){










            }
        }

   }

}
