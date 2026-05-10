package Service;

import Entity.Doctor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService {
    Scanner scanner = new Scanner(System.in);

    static List<Doctor> doctors = new ArrayList<>();
    private List<String> availableSlots;
    private List<String> assignedPatients;


    public Doctor addDoctor(){

        System.out.println("Enter Doctor id :");
        String id = scanner.nextLine();

        System.out.println("Enter Doctor first name :");
        String doctorFName = scanner.nextLine();

        System.out.println("Enter Doctor last name :");
        String doctorLName = scanner.nextLine();

        System.out.println("Enter Doctor DOB: ");
        String dateOfBirth = scanner.nextLine();
        LocalDate DOB = LocalDate.parse(dateOfBirth);

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
        int experienceYears = scanner.nextInt();

        System.out.println("Enter Doctor departmentId :");
        String departmentId = scanner.nextLine();

        System.out.println("Enter Doctor consultationFee :");
        double consultationFee = scanner.nextDouble();

        // List<String> availableSlots, List<String> assignedPatients) {
        Doctor doctor = new Doctor(id,doctorFName,DOB,doctorLName,gender,phone,email,address,doctorId,specialization,qualification,experienceYears,departmentId,consultationFee,availableSlots,assignedPatients);
        return doctor;
    }

    public List<Doctor> addDoctors(){

        Boolean continueFlag = true;
        while (continueFlag) {

            doctors.add(addDoctor());
            System.out.println("Patient add successfully");

            System.out.println("Enter c to add more , and q to exit");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return doctors;

    }


}
