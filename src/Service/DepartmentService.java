package Service;

import Behavior.Manageable;
import Behavior.Searchable;
import Entity.Appointment;
import Entity.Department;
import Entity.Doctor;
import Entity.Nurse;
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

        Doctor doctor = doctorService.getDoctorById(doctorId);

        for(Department department : departmentList){

            if(department.getDepartmentId().equals(departmentId)){

                department.getDoctors().add(doctor);
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
