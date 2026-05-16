package Service;

import Behavior.Manageable;
import Behavior.Searchable;
import Entity.Doctor;
import Entity.Nurse;
import Entity.Patient;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseService implements Manageable, Searchable {

    static List<Nurse> nurseList = new ArrayList<>();
    List<String> assignedPatients = new ArrayList<>();


    public Nurse addNurse() {


        String id = HelperUtils.generateId();


        String nurseFName = InputHandler.getStringInput("Enter Nurse first name :");
        String nurseLName = InputHandler.getStringInput("Enter Nurse last name :");

        LocalDate DOB = InputHandler.getDateInput("Enter DOB (yyyy-MM-dd): ");
        String gender = InputHandler.getStringInput("Enter Nurse gender (M/F): ");

        String phone = InputHandler.getStringInput("Enter Nurse phone number :");
        String email = InputHandler.getStringInput("Enter Nurse email :");

        String address = InputHandler.getStringInput("Enter Nurse address :");
        String nurseId = HelperUtils.generateId();

        String departmentId = InputHandler.getStringInput("Enter Nurse department Id :");
        String shift = InputHandler.getStringInput("Enter Nurse shift :");

        String qualification = InputHandler.getStringInput("Enter Nurse qualification :");

        Nurse nurse = new Nurse(id, nurseFName, DOB, nurseLName, gender, phone, email, address, nurseId, departmentId, shift, qualification, assignedPatients);

        System.out.println("Nurse created successfully.");
        return nurse;
    }

    public List<Nurse> addNurses() {

        Boolean continueFlag = true;
        while (continueFlag) {

            nurseList.add(addNurse());
            System.out.println("Nurse add successfully");

            if (InputHandler.getStringInput("Enter c to add more , and q to exit").equals("q")) {
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

                String nurseFName = InputHandler.getStringInput("Enter updated Nurse first name :");
                nurse.setFirstName(nurseFName);

                String nurseLName = InputHandler.getStringInput("Enter updated Nurse last name :");
                nurse.setLastName(nurseLName);

                LocalDate DOB = InputHandler.getDateInput("Enter updated DOB (yyyy-MM-dd): ");
                nurse.setDateOfBirth(DOB);

                String gender = InputHandler.getStringInput("Enter updated Nurse gender (M/F): ");
                nurse.setGender(gender);

                String phone = InputHandler.getStringInput("Enter updated Nurse phone number :");
                nurse.setPhoneNumber(phone);

                String email = InputHandler.getStringInput("Enter updated Nurse email :");
                nurse.setEmail(email);

                String address = InputHandler.getStringInput("Enter updated Nurse address :");
                nurse.setAddress(address);

                String departmentId = InputHandler.getStringInput("Enter updated Nurse department Id :");
                nurse.setDepartmentId(departmentId);

                String shift = InputHandler.getStringInput("Enter updated Nurse shift :");
                nurse.setShift(shift);

                String qualification = InputHandler.getStringInput("Enter updated Nurse qualification :");
                nurse.setQualification(qualification);

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

    // Method to assign patient to nurse
    public void assignPatient(String patientId ,String nurseId ) {

        // Validate patientId
        if (HelperUtils.isNull(patientId)) {
            System.out.println("Invalid patient.");
            return;
        }

        // Validate nurse ID
        if (HelperUtils.isValidString(nurseId)) {
            System.out.println("Invalid nurse ID.");
            return;
        }

        // Check if patient already assigned
        if (assignedPatients.contains(patientId)) {
            System.out.println("Patient " + patientId + " is already assigned.");
            return;
        }

        assignedPatients.add(patientId);
        System.out.println("Patient " + patientId
                + " assigned to Nurse " + nurseId);
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
    public void getNursesByDepartment(String departmentId){

        if (!HelperUtils.isValidString(departmentId)) {
            System.out.println("Invalid department ID.");
            return;
        }

        for(Nurse nurse : nurseList){

            if (HelperUtils.isNull(nurse)) {
                continue;
            }

            if(nurse.getDepartmentId().equals(departmentId)){
                nurse.displayInfo();
            }
        }

    }

    // get Nurse By Shift
    public void getNursesByShift(String shift){

        if (!HelperUtils.isValidString(shift)) {
            System.out.println("Invalid shift");
            return ;
        }

        for(Nurse nurse : nurseList){

            if (HelperUtils.isNull(nurse)) {
                continue;
            }

            if(nurse.getShift().equals(shift)){
                nurse.displayInfo();
            }
        }

    }


    @Override
    public void add(Object entity) {

        Nurse nurse = (Nurse) entity;
        for(Nurse n : nurseList){
            if (n.getId().equals(nurse.getId())) {
                return;
            }
        }
        nurseList.add(nurse);

    }

    @Override
    public void remove(String id) {

        Nurse nurse = getNurseById(id);
        nurseList.remove(nurse);

    }

    @Override
    public List<Object> getAll() {

        return List.of(nurseList);
    }

    @Override
    public void search(String keyword) {
        boolean found = false;

        for (Nurse nurse : nurseList) {

            if (
                    nurse.getFirstName().equalsIgnoreCase(keyword) ||
                            nurse.getLastName().equalsIgnoreCase(keyword) ||
                            nurse.getGender().equalsIgnoreCase(keyword) ||
                            nurse.getPhoneNumber().equalsIgnoreCase(keyword) ||
                            nurse.getEmail().equalsIgnoreCase(keyword) ||
                            nurse.getAddress().equalsIgnoreCase(keyword) ||
                            nurse.getDepartmentId().equalsIgnoreCase(keyword) ||
                            nurse.getShift().equalsIgnoreCase(keyword) ||
                            nurse.getQualification().equalsIgnoreCase(keyword) ||
                            nurse.getDateOfBirth().toString().equalsIgnoreCase(keyword)
            ) {

                nurse.displayInfo();
                found = true;
            }

        }
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
                String input = InputHandler.getStringInput("Enter department id");
                getNursesByDepartment(input);
            }

            case 4 -> {

                String input = InputHandler.getStringInput("Enter shift");
                getNursesByShift(input);

            }  case 5 -> {
                String nurseId = InputHandler.getStringInput("Enter Nurse ID: ");
                String patientId = InputHandler.getStringInput("Enter Patient ID: ");

                assignPatient(patientId,nurseId);

            }  case 6 -> {

                String nurseId = InputHandler.getStringInput("Enter Nurse ID to update: ");
                editNurse(nurseId);

            }  case 7 -> {
                String nurseId = InputHandler.getStringInput("Enter Nurse ID to remove: ");
                removeNurse(nurseId);

            }  case 8 -> {
                return false;

            }

        }
        return true;
    }
}
