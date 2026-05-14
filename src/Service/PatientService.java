package Service;

import Behavior.Manageable;
import Behavior.Searchable;
import Entity.Appointment;
import Entity.MedicalRecord;
import Entity.Patient;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService implements Manageable, Searchable {
    Scanner scanner = new Scanner(System.in);

    static List<Patient> patients = new ArrayList<>();
    List<MedicalRecord> medicalRecords = new ArrayList<>();
    List<Appointment> appointments = new ArrayList<>();


    //add new patient

    public Patient addPatient() {


        String id = HelperUtils.generateId();

        System.out.println("Enter patient first name :");
        String patientFName = scanner.nextLine();

        System.out.println("Enter patient last name :");
        String patientLName = scanner.nextLine();

        System.out.println("Enter patient DOB (yyyy-MM-dd): ");
        LocalDate DOB;

        try {
            DOB = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid DOB format.");
            return null;
        }
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

        System.out.println("Enter registration Date (yyyy-MM-dd) :");
        LocalDate DOR;

        try {
            DOR = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid registration date format.");
            return null;
        }


        System.out.println("Enter patient insurance Id :");
        String insuranceId = scanner.nextLine();

        List<String> allergies = new ArrayList<>();

        System.out.println("Enter patient allergies (type 'q' to stop) :");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            allergies.add(input);
        }

        Patient patient = new Patient(id, patientFName, DOB, patientLName, gender, phone, email, address, patientID, bloodGroup, allergies, emergencyContact, DOR, medicalRecords, insuranceId, appointments);

        System.out.println("Patient added successfully.");

        return patient;
    }

    public List<Patient> addPatients() {

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

    // Overload addPatient(String firstName, String lastName, String phone) - minimal info

    public void addPatient(String firstName, String lastName, String phone) {

        Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);

        patients.add(patient);
        System.out.println("Patient add successfully");

    }

    // Overload addPatient(String firstName, String lastName, String phone, String bloodGroup, String email)

    public void addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) {
        Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patient.setBloodGroup(bloodGroup);
        patient.setEmail(email);

        patients.add(patient);
        System.out.println("Patient add successfully");

    }

    // search Patients by any field

    public List<Patient> searchPatients(String keyword) {

        List<Patient> matchedPatients = new ArrayList<>();

        if (!HelperUtils.isValidString(keyword)) {
            return matchedPatients;
        }


        for (Patient patient : patients) {

            if (HelperUtils.isNull(patient)) {
                continue;
            }

            if ( patient.getFirstName().toLowerCase().contains(keyword.toLowerCase())
                    || patient.getLastName().toLowerCase().contains(keyword.toLowerCase())
                    || patient.getPhoneNumber().contains(keyword)
                    || patient.getBloodGroup().toLowerCase().contains(keyword.toLowerCase())
                    || patient.getEmail().toLowerCase().contains(keyword.toLowerCase())) {

                matchedPatients.add(patient);

            }

        }
        return matchedPatients;
    }

    // search by name
    public List<Patient> searchPatients(String firstName, String lastName) {

        List<Patient> matchedPatients = new ArrayList<>();

        if (!HelperUtils.isValidString(firstName) ||
                !HelperUtils.isValidString(lastName)) {
            return matchedPatients;
        }

        for (Patient patient : patients) {

            if (HelperUtils.isNull(patient)) {
                continue;
            }

            if(patient.getFirstName().equalsIgnoreCase(firstName) && patient.getLastName().equalsIgnoreCase(lastName)){

                matchedPatients.add(patient);
            }


        }
            return matchedPatients;
        }


   //update existing patient
   public void editPatient(String patientId){


       if (!HelperUtils.isValidString(patientId)) {
           System.out.println("Invalid patient ID.");
           return;
       }

       boolean found = false;

       for(Patient patient: patients ){

           if (HelperUtils.isNull(patient)) {
               continue;
           }

            if(patient.getPatientId().equals(patientId)){

                found = true;

                System.out.println("Enter updated patient first name :");
                patient.setFirstName(scanner.nextLine());

                System.out.println("Enter updated patient last name :");
                patient.setLastName(scanner.nextLine());

                System.out.println("Enter updated patient DOB (yyyy-MM-dd): ");

                try {
                    patient.setDateOfBirth(LocalDate.parse(scanner.nextLine()));
                } catch (Exception e) {
                    System.out.println("Invalid DOB format. Skipping update.");
                }

                System.out.println("Enter updated patient gender :");
                patient.setGender(scanner.nextLine());

                System.out.println("Enter updated patient phone number :");
                patient.setPhoneNumber(scanner.nextLine());

                System.out.println("Enter updated patient email :");
                patient.setEmail(scanner.nextLine());

                System.out.println("Enter updated patient address :");
                patient.setAddress(scanner.nextLine());

                System.out.println("Enter updated patient blood Group :");
               patient.setBloodGroup(scanner.nextLine());

                System.out.println("Enter updated patient emergency Contact :");
                patient.setEmergencyContact(scanner.nextLine());

                System.out.println("Enter updated registration Date (yyyy-MM-dd) :");

                try {
                    LocalDate DOR = LocalDate.parse(scanner.nextLine());
                    patient.setRegistrationDate(DOR);
                } catch (Exception e) {
                    System.out.println("Invalid registration date. Skipping update.");
                }


                System.out.println("Enter updated patient insurance Id :");
               patient.setInsuranceId(scanner.nextLine());

                System.out.println("Enter allergies (type 'q' to stop):");

                List<String> allergies = new ArrayList<>();

                while (true) {
                    String input = scanner.nextLine();

                    if (input.equalsIgnoreCase("q")) {
                        break;
                    }

                    if (!input.trim().isEmpty()) {
                        allergies.add(input);
                    }
                }

                patient.setAllergies(allergies);

                System.out.println("Patient updated successfully");
                break;

            }
        }
       if (!found) {
           System.out.println("Patient not found.");
       }

   }

   // remove patient by ID
   public void removePatient(String patientId){

       if (!HelperUtils.isValidString(patientId)) {
           System.out.println("Invalid patient ID.");
           return;
       }

       boolean removed = patients.removeIf(
               p -> p != null &&
                       HelperUtils.isValidString(p.getPatientId()) &&
                       p.getPatientId().equals(patientId));

       if (removed) {
           System.out.println("Patient removed successfully.");
       } else {
           System.out.println("Patient not found.");
       }

   }

   //retrieve patient
   public Patient getPatientById(String patientId){

        for(Patient patient: patients){
            if(patient.getPatientId().equals(patientId)){
                return patient;
            }

        }
       System.out.println("patient not found");
        return null;
   }

   //display all patients with formatted output
    public void displayAllPatients(){

        for(Patient patient: patients){
            patient.displayInfo();
        }

    }

    // display filtered by criteria
    public void displayPatients(String filter){

        for (Patient patient : patients) {

            boolean matches = false;

            // filter by ID
            if (patient.getPatientId().toLowerCase().contains(filter.toLowerCase())) {
                matches = true;
            }

            // filter by first name
            else if (patient.getFirstName().toLowerCase().contains(filter.toLowerCase())) {
                matches = true;
            }

            // filter by last name
            else if (patient.getLastName().toLowerCase().contains(filter.toLowerCase())) {
                matches = true;
            }

            // filter by phone
            else if (patient.getPhoneNumber().contains(filter)) {
                matches = true;
            }

            // filter by gender
            else if (patient.getGender().toLowerCase().contains(filter.toLowerCase())) {
                matches = true;
            }

            if (matches) {
                System.out.println(patient);
            }
        }


    }

    //display limited number
    public void displayPatients(int limit){
        int count = 0;

            for(Patient patient :patients){

                if(count >= limit) {
                    break;
                }
                patient.displayInfo();
                count++;
            }
        }




    //search functionality
    public void searchPatientsByName(String name) {

        boolean found = false;


        for(Patient patient : patients){

            String fullName = patient.getFirstName() + " " + patient.getLastName();

            if(fullName.toLowerCase().contains(name.toLowerCase())){
                patient.displayInfo();
                found = true;
            }
        }

        if(!found){
            System.out.println("No patients found with this name");
        }

    }

    @Override
    public void add(Object entity) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Object> getAll() {
        return List.of();
    }

    @Override
    public void search(String keyword) {

    }

    @Override
    public Object searchById(String id) {
        return null;
    }
}
