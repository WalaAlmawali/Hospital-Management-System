package Service;

import Behavior.Manageable;
import Behavior.Searchable;
import Entity.*;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Utils.InputHandler;


public class PatientService implements Manageable, Searchable {

    static List<Patient> patients = new ArrayList<>();

    List<MedicalRecord> medicalRecords = new ArrayList<>();
    List<Appointment> appointments = new ArrayList<>();

    MedicalRecordService medicalRecordService = new MedicalRecordService();


    //add new normal patient

    public Patient addPatient() {


        String id = HelperUtils.generateId();
        String patientID = HelperUtils.generateId();

        String patientFName = InputHandler.getStringInput("Enter patient first name :");
        String patientLName = InputHandler.getStringInput("Enter patient last name :");

        LocalDate DOB = InputHandler.getDateInput("Enter patient DOB : ");
        String gender = InputHandler.getStringInput("Enter patient gender :");

        String phone = InputHandler.getStringInput("Enter patient phone number : ");
        String email = InputHandler.getStringInput("Enter patient email : ");

        String address = InputHandler.getStringInput("Enter patient address :");
        String bloodGroup = InputHandler.getStringInput("Enter patient blood Group : ");

        String emergencyContact = InputHandler.getStringInput("Enter patient emergency Contact : ");
        String insuranceId = InputHandler.getStringInput("Enter patient Insurance ID: ");

        LocalDate DOR = InputHandler.getDateInput("Enter registration Date (yyyy-MM-dd) :");

        List<String> allergies = new ArrayList<>();


        while (true) {
            String input = InputHandler.getStringInput("Enter patient allergies (type 'q' to stop) : ");

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            allergies.add(input);
        }

        Patient patient = new Patient(id, patientFName, DOB, patientLName, gender, phone, email, address, patientID, bloodGroup, allergies, emergencyContact, DOR, medicalRecords, insuranceId, appointments);

        System.out.println("Patient added successfully.");

        return patient;
    }
    //add new  Inpatient

    public void addInpatient(){

        String id = HelperUtils.generateId();
        String patientID = HelperUtils.generateId();

        String patientFName = InputHandler.getStringInput("Enter patient first name :");
        String patientLName = InputHandler.getStringInput("Enter patient last name :");

        LocalDate DOB = InputHandler.getDateInput("Enter patient DOB (yyyy-MM-dd): ");
        String gender = InputHandler.getStringInput("Enter patient gender :");

        String phone = InputHandler.getStringInput("Enter patient phone number : ");
        String email = InputHandler.getStringInput("Enter patient email : ");

        String address = InputHandler.getStringInput("Enter patient address :");
        String bloodGroup = InputHandler.getStringInput("Enter patient blood Group : ");

        String emergencyContact = InputHandler.getStringInput("Enter patient emergency Contact : ");
        String insuranceId = InputHandler.getStringInput("Enter patient Insurance ID: ");

        LocalDate DOR = InputHandler.getDateInput("Enter registration Date (yyyy-MM-dd) :");

        String roomNumber = InputHandler.getStringInput(" Enter Room Number: ");
        String bedNumber = InputHandler.getStringInput(" Enter Bed Number: ");

        String doctorId = InputHandler.getStringInput("Enter Admitting Doctor ID: ");
        double dailyCharge = InputHandler.getDoubleInput("Enter Daily Charges : ");

        List<String> allergies = new ArrayList<>();


        while (true) {
            String input = InputHandler.getStringInput("Enter patient allergies (type 'q' to stop) : ");

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            allergies.add(input);
        }

        InPatient inpatient = new InPatient(id, patientFName, DOB, patientLName, gender, phone, email, address, patientID, bloodGroup, allergies, emergencyContact, DOR, medicalRecords, insuranceId, appointments,LocalDate.now(),LocalDate.now(),roomNumber,bedNumber,doctorId,dailyCharge);

        patients.add(inpatient);

        System.out.println("Patient added successfully.");

    }

    // add out patient
    public void addOutpatient() {

        String id = HelperUtils.generateId();
        String patientID = HelperUtils.generateId();

        String patientFName = InputHandler.getStringInput("Enter patient first name :");
        String patientLName = InputHandler.getStringInput("Enter patient last name :");

        LocalDate DOB = InputHandler.getDateInput("Enter patient DOB (yyyy-MM-dd): ");
        String gender = InputHandler.getStringInput("Enter patient gender :");

        String phone = InputHandler.getStringInput("Enter patient phone number : ");
        String email = InputHandler.getStringInput("Enter patient email : ");

        String address = InputHandler.getStringInput("Enter patient address :");
        String bloodGroup = InputHandler.getStringInput("Enter patient blood Group : ");

        String emergencyContact = InputHandler.getStringInput("Enter patient emergency Contact : ");
        String insuranceId = InputHandler.getStringInput("Enter patient Insurance ID: ");

        LocalDate DOR = InputHandler.getDateInput("Enter registration Date (yyyy-MM-dd):");
        LocalDate lastVisit = InputHandler.getDateInput("Enter last visit date (yyyy-MM-dd) :");

        String prefDoctor= InputHandler.getStringInput("Enter doctor ID: ");
        int visit = InputHandler.getIntInput("Enter visit count number: ");

        List<String> allergies = new ArrayList<>();


        while (true) {
            String input = InputHandler.getStringInput("Enter patient allergies (type 'q' to stop) : ");

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            allergies.add(input);
        }

        OutPatient outPatient = new OutPatient(id, patientFName, DOB, patientLName, gender, phone, email, address, patientID, bloodGroup, allergies, emergencyContact, DOR, medicalRecords, insuranceId, appointments,visit,lastVisit,prefDoctor);

        patients.add(outPatient);

        System.out.println("Patient added successfully.");
    }

    // add Emergency Patient

    public void addEmergencyPatient(){

        String id = HelperUtils.generateId();
        String patientID = HelperUtils.generateId();

        String patientFName = InputHandler.getStringInput("Enter patient first name :");
        String patientLName = InputHandler.getStringInput("Enter patient last name :");

        LocalDate DOB = InputHandler.getDateInput("Enter patient DOB : ");
        String gender = InputHandler.getStringInput("Enter patient gender :");

        String phone = InputHandler.getStringInput("Enter patient phone number : ");
        String email = InputHandler.getStringInput("Enter patient email : ");

        String address = InputHandler.getStringInput("Enter patient address :");
        String bloodGroup = InputHandler.getStringInput("Enter patient blood Group : ");

        String emergencyContact = InputHandler.getStringInput("Enter patient emergency Contact : ");
        String insuranceId = InputHandler.getStringInput("Enter patient Insurance ID: ");

        LocalDate DOR = InputHandler.getDateInput("Enter registration Date (yyyy-MM-dd) :");

        String roomNumber = InputHandler.getStringInput(" Enter Room Number: ");
        String bedNumber = InputHandler.getStringInput(" Enter Bed Number: ");

        String doctorId = InputHandler.getStringInput("Enter Admitting Doctor ID: ");
        double dailyCharge = InputHandler.getDoubleInput("Enter Daily Charges : ");

        String type = InputHandler.getStringInput("Enter Emergency Type: ");
        String mode = InputHandler.getStringInput("Enter Arrival Mode: ");

        int triage = InputHandler.getIntInput("Enter Triage Level (1-5): ", 1, 5);

        Boolean admittedViaER = InputHandler.getConfirmation("Admitted via ER? ");

        List<String> allergies = new ArrayList<>();


        while (true) {
            String input = InputHandler.getStringInput("Enter patient allergies (type 'q' to stop) : ");

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            allergies.add(input);
        }

        EmergencyPatient emergencyPatient = new EmergencyPatient(id, patientFName, DOB, patientLName, gender, phone, email, address, patientID, bloodGroup, allergies, emergencyContact, DOR, medicalRecords, insuranceId, appointments,LocalDate.now(),LocalDate.now(),roomNumber,bedNumber,doctorId,dailyCharge,type,mode,triage,admittedViaER);
        patients.add(emergencyPatient);

        System.out.println("Patient added successfully.");

    }


    //add normal patient in patient list

    public List<Patient> addPatients() {

        Boolean continueFlag = true;
        while (continueFlag) {

            patients.add(addPatient());
            System.out.println("Patient add successfully");

            if (InputHandler.getStringInput("Enter c to add more patient , and q to exit").equals("q")) {
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

    public void searchPatients(String keyword) {

        List<Patient> matchedPatients = new ArrayList<>();

        if (!HelperUtils.isValidString(keyword)) {
            System.out.println("Invalid search keyword");
            return;
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
        for (Patient patient : matchedPatients) {

            patient.displayInfo();
        }
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

                String patientFName = InputHandler.getStringInput("Enter updated patient first name :");
                patient.setFirstName(patientFName);

                String patientLName = InputHandler.getStringInput("Enter updated patient last name :");
                patient.setLastName(patientLName);

                LocalDate DOB = InputHandler.getDateInput("Enter updated patient DOB : ");
                patient.setDateOfBirth(DOB);

                String gender = InputHandler.getStringInput("Enter updated patient gender :");
                patient.setGender(gender);

                String phone = InputHandler.getStringInput("Enter updated patient phone number : ");
                patient.setPhoneNumber(phone);

                String email = InputHandler.getStringInput("Enter updated patient email : ");
                patient.setEmail(email);

                String address = InputHandler.getStringInput("Enter updated patient address :");
                patient.setAddress(address);

                String bloodGroup = InputHandler.getStringInput("Enter updated patient blood Group : ");
                patient.setBloodGroup(bloodGroup);

                String emergencyContact = InputHandler.getStringInput("Enter updated patient emergency Contact : ");
                patient.setEmergencyContact(emergencyContact);

                String insuranceId = InputHandler.getStringInput("Enter updated patient Insurance ID: ");
                patient.setInsuranceId(insuranceId);

                LocalDate DOR = InputHandler.getDateInput("Enter updated registration Date :");
                patient.setRegistrationDate(DOR);

                List<String> allergies = new ArrayList<>();


                while (true) {
                    String input = InputHandler.getStringInput("Enter updated patient allergies (type 'q' to stop) : ");

                    if (input.equalsIgnoreCase("q")) {
                        break;
                    }

                    allergies.add(input);
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

       if (!HelperUtils.isValidString(patientId)) {
           return null;
       }

        for(Patient patient: patients){

            if(!HelperUtils.isNull(patient) && patient.getPatientId().equals(patientId)){
                return patient;
            }

        }
        return null;
   }

   //display all patients with formatted output
    public void displayAllPatients(){

        if(HelperUtils.isNull(patients)){
            System.out.println("No patients available.");
            return;
        }

        System.out.println("===== PATIENT LIST =====");

        for(Patient patient: patients){

            if (HelperUtils.isNull(patient)) {
                continue;
            }
            patient.displayInfo();

            System.out.println("------------------------");

        }

    }

    // display filtered by criteria
    public void displayPatients(String filter){

        if (!HelperUtils.isValidString(filter)) {
            System.out.println("Invalid search filter.");
            return;
        }

        boolean matches = false;

        for (Patient patient : patients) {

            if (HelperUtils.isNull(patient)) {
                continue;
            }


            // filter by first name
             if (patient.getFirstName().toLowerCase().contains(filter.toLowerCase())) {
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
                patient.displayInfo();

            }else {
                System.out.println("No patients found for: " + filter);

            }
        }


    }

    //display limited number
    public void displayPatients(int limit){

        if (HelperUtils.isNull(patients)) {
            System.out.println("No patients available.");
            return;
        }

        if (HelperUtils.isNegative(limit) || limit == 0) {
            System.out.println("Invalid limit. Must be greater than 0.");
            return;
        }

        System.out.println("===== PATIENT LIST (LIMIT " + limit + ") =====");

        int count = 0;

            for(Patient patient :patients){

                if(HelperUtils.isNull(patient)){
                    continue;
                }

                if(count >= limit) {
                    break;
                }

                patient.displayInfo();
                System.out.println("------------------------");

                count++;
            }
        }




    //search functionality
    public void searchPatientsByName(String name) {

        if (!HelperUtils.isValidString(name)) {
            System.out.println("Invalid search name.");
            return;
        }

        boolean found = false;

        for(Patient patient : patients){

            if (HelperUtils.isNull(patient)) {
                continue;
            }

            String fullName =patient.getFirstName() + " " + patient.getLastName();

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

        Patient patient = (Patient) entity;

        for (Patient p : patients) {

            if (p.getId().equals(patient.getId())) {
                return;
            }
        }

        patients.add(patient);
    }

    @Override
    public void remove(String id) {

        Patient patient = getPatientById(id);

        if (HelperUtils.isNull(patient)) {

            System.out.println("patient not found.");
            return;
        }
        patients.remove(patient);

        System.out.println("patient removed successfully.");
    }

    @Override
    public List<Object> getAll() {
        return List.of();
    }

    @Override
    public void search(String keyword) {
        boolean found = false;

        for (Patient patient : patients) {

            if (

                    patient.getId().equalsIgnoreCase(keyword)
                            || patient.getFirstName().equalsIgnoreCase(keyword)
                            || patient.getLastName().equalsIgnoreCase(keyword)
                            || patient.getGender().equalsIgnoreCase(keyword)
                            || patient.getPhoneNumber().equalsIgnoreCase(keyword)
                            || patient.getEmail().equalsIgnoreCase(keyword)
                            || patient.getAddress().equalsIgnoreCase(keyword)
                            || patient.getBloodGroup().equalsIgnoreCase(keyword)
                            || patient.getEmergencyContact().equalsIgnoreCase(keyword)
                            || patient.getInsuranceId().equalsIgnoreCase(keyword)
                            || patient.getDateOfBirth().toString().equalsIgnoreCase(keyword)
                            || patient.getRegistrationDate().toString().equalsIgnoreCase(keyword)

            ) {

                patient.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("patient not found.");
        }

    }

    @Override
    public Object searchById(String id) {

        if (HelperUtils.isNull(patients)) {

            System.out.println("patient list is empty.");
            return null;
        }

        for (Patient patient : patients) {

            if (patient.getId().equalsIgnoreCase(id)) {
                return patient;
            }
        }

        System.out.println("patient not found.");
        return null;
    }



    public Boolean handlePatientMenu(Integer patientOption) {
        Scanner scanner = new Scanner(System.in);

        switch (patientOption) {
            case 1 -> {
                addPatients();

            }
            case 2 -> {
                addInpatient();

            }
            case 3 -> {

                addOutpatient();
            }

            case 4 -> {

                addEmergencyPatient();

            }  case 5 -> {
                displayAllPatients();

            }  case 6 -> {
                String input = InputHandler.getStringInput("Enter world to search :");
                searchPatients(input);

            }  case 7 -> {
                String patientId = InputHandler.getStringInput("Enter patient id to update :");
                editPatient(patientId);

            }  case 8 -> {
                String patientId = InputHandler.getStringInput("Enter patient id to remove :");
                removePatient(patientId);

            }  case 9 -> {
                String patientId = InputHandler.getStringInput("Enter patient id to display history :");
                medicalRecordService.displayPatientHistory(patientId);

            }case 10 -> {
                return false;

            }

        }
        return true;
    }

    public static void patientStatisticsReport() {

        int inPatientCount = 0;
        int outPatientCount = 0;
        int emergencyCount = 0;
        int count = 0;

        for (Patient p : patients) {
            count++;
            if (p instanceof InPatient) {
                inPatientCount++;
            }if (p instanceof OutPatient) {
                outPatientCount++;
            }if (p instanceof EmergencyPatient) {
                emergencyCount++;
            }
        }

        System.out.println("  Total Patients     : " + count);
        System.out.println("  In-Patients        : " + inPatientCount);
        System.out.println("  Out-Patients       : " + outPatientCount);
        System.out.println("  Emergency Patients : " + emergencyCount);
    }

    public void emergencyCasesReport() {

        List<EmergencyPatient> emergencyPatients = new ArrayList<>();
        for (Patient p : patients) {
            if (p instanceof EmergencyPatient) {
                emergencyPatients.add((EmergencyPatient) p);
            }
        }

        int triage1 = 0, triage2 = 0, triage3 = 0, triage4 = 0, triage5 = 0;
        for (EmergencyPatient ep : emergencyPatients) {
            switch (ep.getTriageLevel()) {
                case 1 -> triage1++;
                case 2 -> triage2++;
                case 3 -> triage3++;
                case 4 -> triage4++;
                case 5 -> triage5++;
            }
        }

        int admittedViaERCount    = 0;
        int notAdmittedViaERCount = 0;

        for (EmergencyPatient ep : emergencyPatients) {
            if (ep.isAdmittedViaER()) {
                admittedViaERCount++;
            } else {
                notAdmittedViaERCount++;
            }
        }

        int ambulanceCount = 0;
        int walkInCount    = 0;
        for (EmergencyPatient ep : emergencyPatients) {
            if (ep.getArrivalMode().equalsIgnoreCase("Ambulance")) {
                ambulanceCount++;
            } else if (ep.getArrivalMode().equalsIgnoreCase("Walk-in")) {
                walkInCount++;
            }
        }

        // ── Print Report ──────────────────────────────────────────────
        System.out.println("EMERGENCY CASES REPORT");
        System.out.println("-----------------------");
        System.out.println("Total Emergency Cases : " + emergencyPatients.size());
        System.out.println();
        System.out.println("------------------------");
        System.out.println("TRIAGE LEVEL BREAKDOWN");
        System.out.println("Level 1 - Critical       : " + triage1);
        System.out.println("Level 2 - Emergent       : " + triage2);
        System.out.println("Level 3 - Urgent         : " + triage3);
        System.out.println("Level 4 - Less Urgent    : " + triage4);
        System.out.println("Level 5 - Non Urgent     : " + triage5);
        System.out.println();

        System.out.println("--------------------------");
        System.out.println("ADMITTED VIA ER BREAKDOWN");
        System.out.println("--------------------------");
        System.out.println("Admitted Via ER          : " + admittedViaERCount);
        System.out.println("Not Admitted Via ER      : " + notAdmittedViaERCount);
        System.out.println();

        System.out.println("---------------------------");
        System.out.println("ARRIVAL MODE BREAKDOWN");
        System.out.println("----------------------------");
        System.out.println("Ambulance                : " + ambulanceCount);
        System.out.println("Walk-in                  : " + walkInCount);
        System.out.println();



    }
}





