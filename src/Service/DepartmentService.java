package Service;

import Behavior.Manageable;
import Behavior.Searchable;
import Entity.*;
import Utils.HelperUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentService implements Manageable, Searchable {

    Scanner scanner = new Scanner(System.in);

    static List<Department> departmentList = new ArrayList<>();
    List<Doctor> doctors = new ArrayList<>();
    List<Nurse> nurses = new ArrayList<>();
    DoctorService doctorService = new DoctorService();

    public Department addDepartment(){


        String departmentId = HelperUtils.generateId();

        System.out.println("Enter department Name :");
        String departmentName = scanner.nextLine();

        System.out.println("Enter department head DoctorId :");
        String headDoctorId = scanner.nextLine();

        System.out.println("Enter department  bed Capacity :");
        int bedCapacity = scanner.nextInt();

        System.out.println("Enter department available Beds :");
        int availableBeds = scanner.nextInt();

        // Validate required fields
        if (!HelperUtils.isValidString(departmentName) ||
                !HelperUtils.isValidString(headDoctorId) ||
                !HelperUtils.isPositive(bedCapacity) || !HelperUtils.isPositive(availableBeds)) {

            System.out.println("Invalid input data.");
            return null;
        }

        Department department = new Department(departmentId,departmentName,headDoctorId,doctors,nurses,bedCapacity,availableBeds);

        return department;

    }

    public List<Department> addDepartments(){

        Boolean continueFlag = true;
        while (continueFlag) {

            departmentList.add(addDepartment());
            System.out.println("Department add successfully");

            System.out.println("Enter c to add more , and q to exit");

            if (scanner.nextLine().equalsIgnoreCase("q")) {
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


        for(Department department : departmentList){

            if(!department.getDepartmentId().equals(departmentId)) {
                continue;
            }

            found = true;


                System.out.println("Enter updated department Name :");
                department.setDepartmentName(scanner.nextLine());

                System.out.println("Enter updated department head DoctorId :");
                department.setHeadDoctorId(scanner.nextLine());

                System.out.println("Enter updated department  bed Capacity :");
                int bedCapacity = scanner.nextInt();

                System.out.println("Enter updated department available Beds :");
                int availableBeds= scanner.nextInt();

            if (!HelperUtils.isValidNumber(
                    availableBeds,
                    0,
                    bedCapacity)) {

                System.out.println("Available beds cannot exceed bed capacity.");
                return;
            }

            department.setBedCapacity(bedCapacity);
            department.setAvailableBeds(availableBeds);

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

    //retrieve department
    public Department getDepartment(String departmentId){

        if (!HelperUtils.isValidString(departmentId)) {
            System.out.println("Invalid department ID.");
            return null;
        }

        for(Department department: departmentList){

            if(department.getDepartmentId().equals(departmentId)){
                return department;
            }

        }
        System.out.println("department not found");
        return null;
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
                System.out.println("Enter department id");
                String depId = scanner.nextLine();

            }

            case 4 -> {
                System.out.println("Enter department id");
                String depId = scanner.nextLine();

                System.out.println("Enter doctor id");
                String docId = scanner.nextLine();

                assignDoctorToDepartment(depId,docId);

            }  case 5 -> {



            }  case 6 -> {
                System.out.println("Enter department id to update ");
                String input = scanner.nextLine();

                editDepartment(input);

            }  case 7 -> {


            }  case 8 -> {
                return false;

            }

        }
        return true;
    }

    public void departmentOccupancyReport(String departmentId) {
        System.out.println("==== Department Occupancy Report ====");
        if (HelperUtils.isNull(departmentId)) {
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
