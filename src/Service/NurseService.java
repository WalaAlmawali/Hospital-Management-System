package Service;

import Behavior.Manageable;
import Behavior.Searchable;
import Entity.Doctor;
import Entity.Nurse;
import Entity.Patient;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseService implements Manageable, Searchable {
    Scanner scanner = new Scanner(System.in);

    static List<Nurse> nurseList = new ArrayList<>();
    List<String> assignedPatients = new ArrayList<>();


    public Nurse addNurse() {


        String id = HelperUtils.generateId();

        System.out.println("Enter Nurse first name :");
        String nurseFName = scanner.nextLine();

        System.out.println("Enter Nurse last name :");
        String nurseLName = scanner.nextLine();

        System.out.println("Enter Nurse DOB (yyyy-MM-dd): ");
        LocalDate DOB;

        try {
            DOB = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return null;
        }


        System.out.println("Enter Nurse gender :");
        String gender = scanner.nextLine();

        System.out.println("Enter Nurse phone number :");
        String phone = scanner.nextLine();

        System.out.println("Enter Nurse email :");
        String email = scanner.nextLine();

        System.out.println("Enter Nurse address :");
        String address = scanner.nextLine();

        System.out.println("Enter Nurse nurse Id :");
        String nurseId = scanner.nextLine();

        System.out.println("Enter Nurse department Id :");
        String departmentId = scanner.nextLine();

        System.out.println("Enter Nurse shift :");
        String shift = scanner.nextLine();

        System.out.println("Enter Nurse qualification :");
        String qualification = scanner.nextLine();

        // Basic validation
        if (!HelperUtils.isValidString(nurseFName) ||
                !HelperUtils.isValidString(nurseId) ||
                !HelperUtils.isValidString(departmentId)) {

            System.out.println("Invalid nurse data.");
            return null;
        }

        Nurse nurse = new Nurse(id, nurseFName, DOB, nurseLName, gender, phone, email, address, nurseId, departmentId, shift, qualification, assignedPatients);

        System.out.println("Nurse created successfully.");
        return nurse;
    }

    public List<Nurse> addNurses() {

        Boolean continueFlag = true;
        while (continueFlag) {

            nurseList.add(addNurse());
            System.out.println("Nurse add successfully");

            System.out.println("Enter c to add more , and q to exit");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return nurseList;

    }

    public void editNurse(String nurseId) {

        if (!HelperUtils.isValidString(nurseId)) {
            System.out.println("Invalid nurse ID.");
            return;
        }

        boolean found = false;

        for (Nurse nurse : nurseList){

            if(nurse.getNurseId().equals(nurseId)){

                found = true;

                System.out.println("Enter updated Nurse first name :");
                nurse.setFirstName(scanner.nextLine());

                System.out.println("Enter updated Nurse last name :");
                nurse.setLastName(scanner.nextLine());

                System.out.println("Enter updated Nurse DOB (yyyy-MM-dd): ");

                try {
                    LocalDate DOB = LocalDate.parse(scanner.nextLine());
                    nurse.setDateOfBirth(DOB);
                } catch (Exception e) {
                    System.out.println("Invalid date format. Skipping DOB update.");
                }

                System.out.println("Enter updated Nurse gender :");
                nurse.setGender(scanner.nextLine());

                System.out.println("Enter updated Nurse phone number :");
                nurse.setPhoneNumber(scanner.nextLine());

                System.out.println("Enter updated Nurse email :");
                nurse.setEmail(scanner.nextLine());

                System.out.println("Enter updated Nurse address :");
                nurse.setAddress(scanner.nextLine());

                System.out.println("Enter updated Nurse department Id :");
                nurse.setDepartmentId(scanner.nextLine());

                System.out.println("Enter updated Nurse shift :");
                nurse.setShift(scanner.nextLine());

                System.out.println("Enter updated Nurse qualification :");
                nurse.setQualification(scanner.nextLine());

                System.out.println("Nurse updated successfully");
                break;

            }

        }
        if (!found) {
            System.out.println("Nurse not found.");
        }

    }

    // remove nurse by ID
    public void removeNurse(String nurseId){

        nurseList.removeIf(N -> N.getNurseId() == nurseId);
        System.out.println("Nurse removed successfully");

        System.out.println("Nurse not found");

    }

    //retrieve nurse
    public Nurse getNurseById(String nurseId){

        if (!HelperUtils.isValidString(nurseId)) {
            return null;
        }

        for(Nurse nurse: nurseList){

            if(!HelperUtils.isNull(nurse) && nurse.getNurseId().equals(nurseId)){
                return nurse;
            }

        }
        return null;
    }

    //display all nurses with formatted output
    public void displayAllNurses(){

        if (HelperUtils.isNull(nurseList)) {
            System.out.println("No nurses available.");
            return;
        }

        for(Nurse nurse: nurseList){
            nurse.displayInfo();
        }

    }

    // get Nurse By Department
    public List<Nurse> getNursesByDepartment(String departmentId){

        List<Nurse> departmentNurse = new ArrayList<>();

        if (!HelperUtils.isValidString(departmentId)) {
            return departmentNurse;
        }

        for(Nurse nurse : nurseList){

            if (HelperUtils.isNull(nurse)) {
                continue;
            }

            if(nurse.getDepartmentId().equals(departmentId)){
                departmentNurse.add(nurse);
            }
        }
        return departmentNurse;
    }

    // get Nurse By Shift
    public List<Nurse> getNursesByShift(String shift){

        List<Nurse> shiftNurse = new ArrayList<>();

        if (!HelperUtils.isValidString(shift)) {
            return shiftNurse;
        }

        for(Nurse nurse : nurseList){

            if (HelperUtils.isNull(nurse)) {
                continue;
            }

            if(nurse.getShift().equals(shift)){
                shiftNurse.add(nurse);
            }
        }
        return shiftNurse;
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

    public Boolean handleNurseMenu(Integer nurseOption) {
        Scanner scanner = new Scanner(System.in);

        switch (nurseOption) {
            case 1 -> {
                addNurses();
            }
            case 2 -> {
                displayAllNurses();

            }
            case 3 -> {
                System.out.println("Enter department id");
                String input = scanner.nextLine();
                System.out.println(getNursesByDepartment(input));
            }

            case 4 -> {
                System.out.println("Enter shift");
                String input = scanner.nextLine();
                getNursesByShift(input);

            }  case 5 -> {
                System.out.println("Enter nurse id  ");
                String nurseId = scanner.nextLine();

                System.out.println("Enter patient id  ");
                String patientId = scanner.nextLine();

                Nurse nurse = getNurseById(nurseId);
                PatientService patientService = new PatientService();
                Patient patient = patientService.getPatientById(patientId);

                nurse.assignPatient(patient,nurseId);

            }  case 6 -> {
                System.out.println("Enter nurse id to update ");
                String input = scanner.nextLine();
                editNurse(input);

            }  case 7 -> {
                System.out.println("Enter nurse id to remove ");
                String input = scanner.nextLine();
                removeNurse(input);

            }  case 8 -> {
                return false;

            }

        }
        return true;
    }
}
