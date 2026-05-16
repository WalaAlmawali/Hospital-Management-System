package Service;

import Behavior.Manageable;
import Behavior.Searchable;
import Entity.*;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentService implements Manageable, Searchable {


    static List<Department> departmentList = new ArrayList<>();
    List<Doctor> doctors = new ArrayList<>();
    List<Nurse> nurses = new ArrayList<>();
    DoctorService doctorService = new DoctorService();
    NurseService nurseService ;

    public Department addDepartment(){


        String departmentId = HelperUtils.generateId();

        String departmentName = InputHandler.getStringInput("Enter Department Name");
        String headDoctorId = InputHandler.getStringInput("Enter Department Head Doctor Id");

        int bedCapacity = InputHandler.getIntInput("Enter Department Bed Capacity");
        int availableBeds = InputHandler.getIntInput("Enter Department Available Beds :");


        Department department = new Department(departmentId,departmentName,headDoctorId,doctors,nurses,bedCapacity,availableBeds);

        return department;

    }

    public List<Department> addDepartments(){

        Boolean continueFlag = true;
        while (continueFlag) {

            departmentList.add(addDepartment());
            System.out.println("Department add successfully");


            if (InputHandler.getStringInput("Enter c to add more , q to exit").equals("q")) {
                continueFlag = false;
            }
        }
        return departmentList;

    }

    // edit department

    public void editDepartment(String departmentId){

        if (!HelperUtils.isValidString(departmentId)) {
            System.out.println("Invalid department ID.");
            return;
        }

        boolean found = false;

        if(HelperUtils.isNull(departmentList)){
            System.out.println("Department list is empty.");
            return;
        }

        for(Department department : departmentList){

            if(!department.getDepartmentId().equals(departmentId)) {
                continue;
            }

            found = true;

                department.setDepartmentName(InputHandler.getStringInput("Enter updated Department Name :"));
                department.setHeadDoctorId(InputHandler.getStringInput("Enter updated Department Head DoctorId :"));

                department.setBedCapacity(InputHandler.getIntInput("Enter updated Department Bed Capacity :"));
                department.setAvailableBeds(InputHandler.getIntInput("Enter updated Department Available Beds :"));

               System.out.println("department updated successfully");
               break;

        }
        if (!found) {
            System.out.println("Department not found.");
        }

        }



    // remove department by ID
    public void removeDepartment(String departmentId){

        if (!HelperUtils.isValidString(departmentId)) {
            System.out.println("Invalid department ID.");
            return;
        }

        boolean removed = departmentList.removeIf(
                d -> d.getDepartmentId().equals(departmentId));

        if (removed) {
            System.out.println("Department removed successfully");
        }else {
            System.out.println("Department record not found");
        }
    }
    public Department getDepartmentById(String departmentId){

        if(HelperUtils.isNull(departmentList)){
            System.out.println("Department list is empty");
            return null;
        }

        for(Department department: departmentList){

            if(department.getDepartmentId().equals(departmentId)){
                return department;
            }

        }
        return null;
    }

    //retrieve department
    public void getDepartment(String departmentId){

        if (!HelperUtils.isValidString(departmentId)) {
            System.out.println("Invalid department ID.");
            return;
        }

        if(HelperUtils.isNull(departmentList)){
            System.out.println("Department list is empty");
            return;
        }

        for(Department department: departmentList){

            if(department.getDepartmentId().equals(departmentId)){
               department.displayInfo();
               break;
            }

        }
        System.out.println("department not found");

    }

    // display All Departments
    public void displayAllDepartments(){

        if (HelperUtils.isNull(departmentList)) {
            System.out.println("No departments available.");
            return;
        }

        for(Department department : departmentList){
            department.displayInfo();
        }
    }

    // assign Doctor To Department(String doctorId, String departmentId)

    public void assignDoctorToDepartment(String doctorId, String departmentId){

        if (!HelperUtils.isValidString(doctorId) ||
                !HelperUtils.isValidString(departmentId)) {

            System.out.println("Invalid doctor or department ID.");
            return;
        }

        Doctor doctor = doctorService.getDoctorById(doctorId);

        if (HelperUtils.isNull(doctor)) {
            System.out.println("Doctor not found.");
            return;
        }

        boolean foundDepartment = false;

        for(Department department : departmentList){

            if(department.getDepartmentId().equals(departmentId)){

                foundDepartment = true;

                if (department.getDoctors().contains(doctor)) {
                    System.out.println("Doctor already assigned to this department.");
                    return;
                }

                department.getDoctors().add(doctor);

                System.out.println("Doctor assigned successfully.");
                return;
            }
        }

            if (!foundDepartment) {
             System.out.println("Department not found.");
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

    public void viewDepartmentStatistics() {
        if (HelperUtils.isNull(departmentList)) {
            System.out.println("No departments available.");
            return;
        }
        System.out.println("========== Department Statistics ==========");
        for (Department department : departmentList) {
            System.out.println("Department  : " + department.getDepartmentName());
            System.out.println("Doctors     : " + department.getDoctors().size());
            System.out.println("Nurses      : " + department.getNurses().size());
            System.out.println("Bed Capacity: " + department.getBedCapacity());
            System.out.println("Available Beds : " + department.getAvailableBeds());

            System.out.println("-------------------------------------------");
        }
    }


    public Boolean handleDepMenu(Integer depOption) {
        Scanner scanner = new Scanner(System.in);

        switch (depOption) {
            case 1 -> {
                addDepartments();
            }
            case 2 -> {
                displayAllDepartments();

            }
            case 3 -> {

                String depId = InputHandler.getStringInput("Enter Department ID");
                getDepartment(depId);

            }

            case 4 -> {

                String doctorId     = InputHandler.getStringInput("Enter doctor ID: ");
                String departmentId = InputHandler.getStringInput("Enter department ID: ");

                assignDoctorToDepartment(doctorId,departmentId);

            }  case 5 -> {

                String nurseId = InputHandler.getStringInput("Enter Nurse ID: ");
                Nurse nurse = nurseService.getNurseById(nurseId);

                String departmentId = InputHandler.getStringInput("Enter department ID: ");
                Department department = getDepartmentById(departmentId);

                department.getNurses().add(nurse);


            }  case 6 -> {
                String input = InputHandler.getStringInput("Enter department ID to update: ");
                editDepartment(input);

            }  case 7 -> {
                viewDepartmentStatistics();
            }  case 8 -> {
                return false;

            }

        }
        return true;
    }

    public void departmentOccupancyReport() {

        System.out.println("==== Department Occupancy Report ====");

        if (HelperUtils.isNull(departmentList)) {
            System.out.println("No departments found.");
            return;
        }

        for (Department department : departmentList) {

            int occupiedBeds = department.getBedCapacity() - department.getAvailableBeds();
            System.out.println("Department: " + department.getDepartmentName() );
            department.displaySummary();
            System.out.println("Bed Capacity: " + department.getBedCapacity());
            System.out.println("Available Beds: " + department.getAvailableBeds());
            System.out.println("Occupied Beds: " + occupiedBeds);
            System.out.println("-----------------------------------");
        }
    }

}
