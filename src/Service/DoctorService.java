package Service;

import Behavior.Manageable;
import Behavior.Searchable;
import Entity.*;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService implements Manageable, Searchable {

    private static final Scanner scanner = new Scanner(System.in);

    static List<Doctor> doctors = new ArrayList<>();

    private List<String> availableSlots = new ArrayList<>();
    private List<String> assignedPatients = new ArrayList<>();


    private DepartmentService departmentService ;


    public Doctor addDoctor(){


        String id = HelperUtils.generateId();
        String doctorID = HelperUtils.generateId();

        String doctorFName = InputHandler.getStringInput("Enter doctor first name :");
        String doctorLName = InputHandler.getStringInput("Enter doctor last name :");

        LocalDate DOB = InputHandler.getDateInput("Enter doctor DOB : ");
        String gender = InputHandler.getStringInput("Enter doctor gender :");

        String phone = InputHandler.getStringInput("Enter doctor phone number : ");
        String email = InputHandler.getStringInput("Enter doctor email : ");

        String address = InputHandler.getStringInput("Enter doctor address :");
        String specialization = InputHandler.getStringInput("Enter doctor specialization :");

        String qualification = InputHandler.getStringInput("Enter Doctor qualification :");
        int experienceYears = InputHandler.getIntInput("Enter Doctor experienceYears : ");

        String departmentId = InputHandler.getStringInput("Enter Doctor Department Id : ");
        double consultationFee = InputHandler.getDoubleInput("Enter Doctor consultationFee :");


        Doctor doctor = new Doctor(id,doctorFName,DOB,doctorLName,gender,phone,email,address,doctorID,specialization,qualification,experienceYears,departmentId,consultationFee,availableSlots,assignedPatients);
        System.out.println("Doctor added successfully.");

        return doctor;
    }

    // add surgeon

    public void addSurgeon(){

        String id = HelperUtils.generateId();
        String doctorID = HelperUtils.generateId();

        String doctorFName = InputHandler.getStringInput("Enter doctor first name :");
        String doctorLName = InputHandler.getStringInput("Enter doctor last name :");

        LocalDate DOB = InputHandler.getDateInput("Enter doctor DOB : ");
        String gender = InputHandler.getStringInput("Enter doctor gender :");

        String phone = InputHandler.getStringInput("Enter doctor phone number : ");
        String email = InputHandler.getStringInput("Enter doctor email : ");

        String address = InputHandler.getStringInput("Enter doctor address :");
        String specialization = InputHandler.getStringInput("Enter doctor specialization :");

        String qualification = InputHandler.getStringInput("Enter Doctor qualification :");
        int experienceYears = InputHandler.getIntInput("Enter Doctor experienceYears : ");

        String departmentId = InputHandler.getStringInput("Enter Doctor consultationFee :");
        double consultationFee = InputHandler.getDoubleInput("Enter Doctor consultationFee :");

        int surgeriesPerformed = InputHandler.getIntInput("Enter Doctor surgeriesPerformed : ");
        boolean operationTheatreAccess = InputHandler.getConfirmation("Operation Theatre Access ?");

        List<String> surgeryTypes = new ArrayList<>();

        while (true) {
            String input =InputHandler.getStringInput("Enter doctor surgery Types (type 'q' to stop) :");

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            surgeryTypes.add(input);
        }

        Surgeon surgeon = new Surgeon(id,doctorFName,DOB,doctorLName,gender,phone,email,address,doctorID,specialization,qualification,experienceYears,departmentId,consultationFee,availableSlots,assignedPatients,surgeriesPerformed,surgeryTypes,operationTheatreAccess);
        System.out.println("Doctor added successfully.");

        doctors.add(surgeon);

    }

    // add Consultant

    public void addConsultant(){

        String id = HelperUtils.generateId();
        String doctorID = HelperUtils.generateId();

        String doctorFName = InputHandler.getStringInput("Enter doctor first name :");
        String doctorLName = InputHandler.getStringInput("Enter doctor last name :");

        LocalDate DOB = InputHandler.getDateInput("Enter doctor DOB : ");
        String gender = InputHandler.getStringInput("Enter doctor gender :");

        String phone = InputHandler.getStringInput("Enter doctor phone number : ");
        String email = InputHandler.getStringInput("Enter doctor email : ");

        String address = InputHandler.getStringInput("Enter doctor address :");
        String specialization = InputHandler.getStringInput("Enter doctor specialization :");

        String qualification = InputHandler.getStringInput("Enter Doctor qualification :");
        int experienceYears = InputHandler.getIntInput("Enter Doctor experienceYears : ");

        String departmentId = InputHandler.getStringInput("Enter Doctor Department Id : ");
        double consultationFee = InputHandler.getDoubleInput("Enter Doctor consultationFee :");

        boolean onlineConsultationAvailable  = InputHandler.getConfirmation("Available online ?");
        int consultationDuration = InputHandler.getIntInput("Enter doctor consultation duration : ");

        List<String> consultationTypes = new ArrayList<>();

        while (true) {
            String input =InputHandler.getStringInput("Enter doctor consultation Types (type 'q' to stop) :");

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            consultationTypes.add(input);
        }

        Consultant consultant = new Consultant(id,doctorFName,DOB,doctorLName,gender,phone,email,address,doctorID,specialization,qualification,experienceYears,departmentId,consultationFee,availableSlots,assignedPatients,consultationTypes,onlineConsultationAvailable,consultationDuration);
        doctors.add(consultant);

        System.out.println("Doctor added successfully.");

    }

    // add GeneralPractitioner
    public void addGeneralPractitioner(){

        String id = HelperUtils.generateId();
        String doctorID = HelperUtils.generateId();

        String doctorFName = InputHandler.getStringInput("Enter doctor first name :");
        String doctorLName = InputHandler.getStringInput("Enter doctor last name :");

        LocalDate DOB = InputHandler.getDateInput("Enter doctor DOB : ");
        String gender = InputHandler.getStringInput("Enter doctor gender :");

        String phone = InputHandler.getStringInput("Enter doctor phone number : ");
        String email = InputHandler.getStringInput("Enter doctor email : ");

        String address = InputHandler.getStringInput("Enter doctor address :");
        String specialization = InputHandler.getStringInput("Enter doctor specialization :");

        String qualification = InputHandler.getStringInput("Enter Doctor qualification :");
        int experienceYears = InputHandler.getIntInput("Enter Doctor experienceYears : ");

        String departmentId = InputHandler.getStringInput("Enter Doctor Department Id : ");
        double consultationFee = InputHandler.getDoubleInput("Enter Doctor consultationFee :");

        boolean walkinAvailable = InputHandler.getConfirmation("Available  walk in ?");
        boolean homeVisitAvailable = InputHandler.getConfirmation("Available  home visit ?");
        boolean vaccinationCertified = InputHandler.getConfirmation("Available  vaccination certified ?");

        GeneralPractitioner generalPractitioner = new GeneralPractitioner(id,doctorFName,DOB,doctorLName,gender,phone,email,address,doctorID,specialization,qualification,experienceYears,departmentId,consultationFee,availableSlots,assignedPatients,walkinAvailable,homeVisitAvailable,vaccinationCertified);
        doctors.add(generalPractitioner);
        System.out.println("Doctor added successfully.");

    }

    public List<Doctor> addDoctors(){

        Boolean continueFlag = true;
        while (continueFlag) {

            doctors.add(addDoctor());
            System.out.println("Doctor add successfully");

            System.out.println("Enter c to add more , and q to exit");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return doctors;

    }

    // Overloaded addDoctor

    public void addDoctor(String name, String specialization, String phone){

        Doctor doctor = new Doctor();
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);

        doctors.add(doctor);
    }

    // Overloaded addDoctor
    public void addDoctor(String name, String specialization, String phone, double consultationFee){

        Doctor doctor = new Doctor();

        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);
        doctor.setConsultationFee(consultationFee);

        doctors.add(doctor);
    }

    public void editDoctor(String doctorId){

        if (!HelperUtils.isValidString(doctorId)) {
            System.out.println("Invalid doctor ID.");
            return;
        }

        boolean found = false;

        for(Doctor doctor : doctors){

            if(doctor.getDoctorId().equals(doctorId)){

                found = true;

                String doctorFName = InputHandler.getStringInput("Enter doctor first name :");
                doctor.setFirstName(doctorFName);

                String doctorLName = InputHandler.getStringInput("Enter doctor last name :");
                doctor.setLastName(doctorLName);

                LocalDate DOB = InputHandler.getDateInput("Enter doctor DOB : ");
                doctor.setDateOfBirth(DOB);

                String gender = InputHandler.getStringInput("Enter doctor gender :");
                doctor.setGender(gender);

                String phone = InputHandler.getStringInput("Enter doctor phone number : ");
                doctor.setPhoneNumber(phone);

                String email = InputHandler.getStringInput("Enter doctor email : ");
                doctor.setEmail(email);

                String address = InputHandler.getStringInput("Enter doctor address :");
                doctor.setAddress(address);

                String specialization = InputHandler.getStringInput("Enter doctor specialization :");
                doctor.setSpecialization(specialization);

                String qualification = InputHandler.getStringInput("Enter Doctor qualification :");
                doctor.setQualification(qualification);

                int experienceYears = InputHandler.getIntInput("Enter Doctor experienceYears : ");
                doctor.setExperienceYears(experienceYears);

                String departmentId = InputHandler.getStringInput("Enter Doctor Department Id : ");
                doctor.setDepartmentId(departmentId);

                double consultationFee = InputHandler.getDoubleInput("Enter Doctor consultationFee :");
                doctor.setConsultationFee(consultationFee);

                System.out.println("doctor updated successfully");

                break;
            }
        }

        if (!found) {
            System.out.println("Doctor not found.");
        }

    }

    // remove doctor by ID
    public void removeDoctor(String doctorId){

        if (!HelperUtils.isValidString(doctorId)) {
            System.out.println("Invalid doctor ID.");
            return;
        }

        boolean removed = doctors.removeIf(
                d -> d.getDoctorId().equals(doctorId));

        if (removed) {
            System.out.println("Doctor removed successfully.");
        } else {
            System.out.println("Doctor not found.");
        }

    }

    //retrieve doctor
    public Doctor getDoctorById(String doctorId) {

        if (!HelperUtils.isValidString(doctorId)) {
            return null;
        }

        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId().equals(doctorId)) {
                return doctor;
            }

        }
        return null;
    }


    //display all doctors with formatted output
    public void displayAllDoctors(){

        if (HelperUtils.isNull(doctors)) {
            System.out.println("No doctors available.");
            return;
        }

        System.out.println("===== DOCTORS LIST =====");

             for(Doctor doctor: doctors){
                 doctor.displayInfo();

            System.out.println("------------------------");

             }

    }

    //get Doctors By Specialization
    public List<Doctor> getDoctorsBySpecialization(String specialization) {

        List<Doctor> specializationDoctors = new ArrayList<>();

        if (!HelperUtils.isValidString(specialization)) {
            return specializationDoctors;
        }

        for(Doctor doctor : doctors){

            if(doctor.getSpecialization().equalsIgnoreCase(specialization)){
                specializationDoctors.add(doctor);
            }
        }
            return specializationDoctors;
    }

    //get Available Doctors()
    public void getAvailableDoctors(){

        for(Doctor doctor : doctors){

            if(HelperUtils.isNull(doctor)){
                continue;

            }

            if ( !doctor.getAvailableSlots().isEmpty()) {
               doctor.displayInfo();
            }

        }

    }

    // Overloaded assignPatient(String doctorId , String patientId)
    public void assignPatient(String doctorId , String patientId) {

        if (!HelperUtils.isValidString(doctorId) ||
                !HelperUtils.isValidString(patientId)) {

            System.out.println("Invalid doctor or patient ID.");
            return;
        }

        Doctor doctor = getDoctorById(doctorId);

        if (HelperUtils.isNull(doctor)) {
            System.out.println("doctor not found.");
            return;
        }

                doctor.getAssignedPatients().add(patientId);

                System.out.println("Patient : "+ patientId + " assigned to Dr. " + doctorId);
                return;
            }


    // Overloaded assignPatient(Doctor doctor, Patient patient)

    public void assignPatient(Doctor doctor ,  Patient patient) {

        if (HelperUtils.isNull(doctor) || HelperUtils.isNull(patient)) {
            System.out.println("Doctor or Patient cannot be null.");
            return;
        }


        doctor.getAssignedPatients().add(patient.getPatientId());
        System.out.println("Patient : "+ patient.getPatientId() + " assigned to Dr. " + doctor.getDoctorId());

    }

    // Overloaded assignPatient(String doctorId, List<String> patientIds) - bulk assignment
    public void assignPatient(String doctorId, List<String> patientIds){

        if (!HelperUtils.isValidString(doctorId) || HelperUtils.isNull(patientIds)) {
            System.out.println("Invalid doctor ID or patient list.");
            return;
        }

        Doctor doctor = getDoctorById(doctorId);

        if (HelperUtils.isNull(doctor)) {
            System.out.println("Doctor not found.");
            return;
        }


        for(String patientId : patientIds){

            if (doctor.getAssignedPatients().contains(patientId)) {
                System.out.println("Already assigned: " + patientId);
                continue;
            }


            doctor.getAssignedPatients().add(patientId);
            System.out.println("Assigned patient " + patientId + " to Dr. " + doctorId);

        }

    }

    //Overloaded displayDoctors()
    public void displayDoctors(){

        if (HelperUtils.isNull(doctors)) {
            System.out.println("No doctors available.");
            return;
        }

        System.out.println("===== DOCTORS LIST =====");

        for (Doctor doctor : doctors){
            doctor.displayInfo();
            System.out.println("------------------------");
        }
    }

    // Overloaded displayDoctors(String specialization)
    public void displayDoctors(String specialization){

        if (!HelperUtils.isValidString(specialization)) {
            System.out.println("Invalid specialization.");
            return;
        }

        boolean found = false;

        for (Doctor doctor : doctors){

            if (HelperUtils.isNull(doctor)) {
                continue;
            }

            if(doctor.getSpecialization().equalsIgnoreCase(specialization)){
                doctor.displayInfo();
                found = true;

            }

        }
        if (!found) {
            System.out.println("No doctors found for specialization: " + specialization);
        }

    }

    // Overloaded displayDoctors(String departmentId, boolean showAvailableOnly)
public void displayDoctors(String departmentId, boolean showAvailableOnly){

    if (!HelperUtils.isValidString(departmentId)) {
        System.out.println("Invalid department ID.");
        return;
    }


    Department department = departmentService.getDepartmentById(departmentId) ;

    if (HelperUtils.isNull(department)) {
        System.out.println("Department not found.");
        return;
    }


            List<Doctor> availableDoctors = department.getDoctors();

            if (HelperUtils.isNull(availableDoctors)) {
                System.out.println("No doctors in this department.");
                return;
            }

            for(Doctor doctor : availableDoctors){

                if (doctor == null) {
                    continue;
                }

                if (showAvailableOnly) {

                if(!doctor.getAvailableSlots().isEmpty()){

                    doctor.displayInfo();
                }else{
                    doctor.displayInfo();
                }
                }

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

    public void DoctorPerformanceReport(){

        Doctor doctor = getDoctorById(InputHandler.getStringInput("Enter doctor id"));

        if(HelperUtils.isNotNull(doctor)){

            System.out.println("Doctor Performance Report");
            doctor.displaySummary();
            System.out.println("Number of patients handled:   " + doctor.getAssignedPatients().size());
        }

    }

    public Boolean handleDoctorMenu(Integer doctorOption) {


        switch (doctorOption) {
            case 1 -> {

                addDoctors();

            }
            case 2 -> {
                addSurgeon();

            }
            case 3 -> {

                addConsultant();
            }

            case 4 -> {
                addGeneralPractitioner();

            }  case 5 -> {
               displayDoctors();

            }  case 6 -> {

                String input = InputHandler.getStringInput("Enter Specialization");
                displayDoctors(input);


            }  case 7 -> {

                getAvailableDoctors();


            }  case 8 -> {
                String doctorId = InputHandler.getStringInput("Enter Doctor ID: ");
                String patientId = InputHandler.getStringInput(" Enter Patient ID: ");

                assignPatient(doctorId,patientId);

            }  case 9 -> {

                String input =InputHandler.getStringInput("Enter Doctor ID to update: ");
                editDoctor(input);

            }case 10 -> {

                String input =InputHandler.getStringInput("Enter Doctor ID to remove: ");
                removeDoctor(input);
            }case 11 -> {
                return false;

            }

        }
        return true;
    }
}
