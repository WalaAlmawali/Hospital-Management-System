package Service;

import Behavior.Manageable;
import Behavior.Searchable;
import Entity.Department;
import Entity.Doctor;
import Entity.Patient;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService implements Manageable, Searchable {
    Scanner scanner = new Scanner(System.in);

    static List<Doctor> doctors = new ArrayList<>();
    private List<String> availableSlots;
    private List<Patient> assignedPatients;
    PatientService patientService = new PatientService();
    DepartmentService departmentService = new DepartmentService();


    public Doctor addDoctor(){


        String id = HelperUtils.generateId();

        System.out.println("Enter Doctor first name :");
        String doctorFName = scanner.nextLine();

        System.out.println("Enter Doctor last name :");
        String doctorLName = scanner.nextLine();

        System.out.println("Enter Doctor DOB (yyyy-MM-dd): ");
        LocalDate dob;

        try {
            dob = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return null;
        }


        System.out.println("Enter Doctor gender :");
        String gender = scanner.nextLine();

        System.out.println("Enter Doctor phone number :");
        String phone = scanner.nextLine();

        System.out.println("Enter Doctor email :");
        String email = scanner.nextLine();

        System.out.println("Enter Doctor address :");
        String address = scanner.nextLine();

        System.out.println("Enter Doctor ID :");
        String doctorId = scanner.nextLine();

        System.out.println("Enter Doctor specialization :");
        String specialization = scanner.nextLine();

        System.out.println("Enter Doctor qualification :");
        String qualification = scanner.nextLine();

        System.out.println("Enter Doctor experienceYears :");
        int experienceYears;

        try {
            experienceYears = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid experience years.");
            return null;
        }

        System.out.println("Enter Doctor departmentId :");
        String departmentId = scanner.nextLine();

        System.out.println("Enter Doctor consultationFee :");
        double consultationFee ;

        try {
            consultationFee = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid consultation fee.");
            return null;
        }

        Doctor doctor = new Doctor(id,doctorFName,dob,doctorLName,gender,phone,email,address,doctorId,specialization,qualification,experienceYears,departmentId,consultationFee,availableSlots,assignedPatients);
        return doctor;
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

                System.out.println("Enter updated Doctor first name :");
                doctor.setFirstName(scanner.nextLine());

                System.out.println("Enter updated Doctor last name :");
               doctor.setLastName(scanner.nextLine());

                System.out.println("Enter updated Doctor DOB: ");

                try {
                    LocalDate dob = LocalDate.parse(scanner.nextLine());
                    doctor.setDateOfBirth(dob);
                } catch (Exception e) {
                    System.out.println("Invalid date format.");
                }

                System.out.println("Enter updated Doctor gender :");
                doctor.setGender(scanner.nextLine());

                System.out.println("Enter updated Doctor phone number :");
                doctor.setPhoneNumber(scanner.nextLine());

                System.out.println("Enter updated Doctor email :");
               doctor.setEmail(scanner.nextLine());

                System.out.println("Enter updated Doctor address :");
                String address = scanner.nextLine();

                System.out.println("Enter updated Doctor specialization :");
                doctor.setSpecialization(scanner.nextLine());

                System.out.println("Enter updated Doctor qualification :");
                doctor.setExperienceYears(Integer.parseInt(scanner.nextLine()));

                System.out.println("Enter updated Doctor experienceYears :");
                doctor.setExperienceYears(scanner.nextInt());

                System.out.println("Enter updated Doctor departmentId :");
               doctor.setDepartmentId(scanner.nextLine());

                System.out.println("Enter updated Doctor consultationFee :");
                doctor.setConsultationFee(Double.parseDouble(scanner.nextLine()));

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
    public List<Doctor> getAvailableDoctors(){

        List<Doctor> availableDoctors = new ArrayList<>();

        for(Doctor doctor : doctors){

            if (!doctor.getAvailableSlots().isEmpty()) {
                availableDoctors.add(doctor);
            }

        }

        return availableDoctors;
    }

    // Overloaded assignPatient(String doctorId , String patientId)
    public void assignPatient(String doctorId , String patientId) {

        Patient patient = patientService.getPatientById(patientId);

        for(Doctor doctor : doctors){

            if(doctor.getDoctorId().equals(doctorId)){
                doctor.getAssignedPatients().add(patient);

                System.out.println("Patient : "+ patientId + " assigned to Dr. " + doctorId);
            }
        }

    }

    // Overloaded assignPatient(Doctor doctor, Patient patient)
    public void assignPatient(Doctor doctor ,  Patient patient) {

        doctor.getAssignedPatients().add(patient);
        System.out.println("Patient : "+ patient.getPatientId() + " assigned to Dr. " + doctor.getDoctorId());

    }

    // Overloaded assignPatient(String doctorId, List<String> patientIds) - bulk assignment
    public void assignPatient(String doctorId, List<String> patientIds){

        Doctor doctor = getDoctorById(doctorId);

        for(String patientId : patientIds){

            doctor.getAssignedPatients().add(patientService.getPatientById(patientId));

        }

    }

    //Overloaded displayDoctors()
    public void displayDoctors(){

        for (Doctor doctor : doctors){
            doctor.displayInfo();
        }
    }

    // Overloaded displayDoctors(String specialization)
    public void displayDoctors(String specialization){

        for (Doctor doctor : doctors){

            if(doctor.getSpecialization().equalsIgnoreCase(specialization)){
                doctor.displayInfo();
            }

        }

    }

    // Overloaded displayDoctors(String departmentId, boolean showAvailableOnly)
public void displayDoctors(String departmentId, boolean showAvailableOnly){

    Department department = departmentService.getDepartment(departmentId) ;

        if(showAvailableOnly){

            List<Doctor> availableDoctors = department.getDoctors();

            for(Doctor doctor : availableDoctors){

                if(!doctor.getAvailableSlots().isEmpty()){

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
}
