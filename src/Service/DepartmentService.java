package Service;

import Entity.Department;
import Entity.Doctor;
import Entity.Nurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentService {

    Scanner scanner = new Scanner(System.in);

    static List<Department> departmentList = new ArrayList<>();
    List<Doctor> doctors = new ArrayList<>();
    List<Nurse> nurses = new ArrayList<>();

    public Department addDepartment(){

        System.out.println("Enter Department Id :");
        String departmentId = scanner.nextLine();

        System.out.println("Enter department Name :");
        String departmentName = scanner.nextLine();

        System.out.println("Enter department head DoctorId :");
        String headDoctorId = scanner.nextLine();

        System.out.println("Enter department  bed Capacity :");
        int bedCapacity = scanner.nextInt();

        System.out.println("Enter department available Beds :");
        int availableBeds = scanner.nextInt();

        Department department = new Department(departmentId,departmentName,headDoctorId,doctors,nurses,bedCapacity,availableBeds);

        return department;

    }

    public List<Department> addDepartments(){


    }

}
