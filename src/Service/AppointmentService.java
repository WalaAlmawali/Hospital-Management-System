package Service;

import Entity.Appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService {

    static List<Appointment> appointmentList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Appointment addAppointment(){

        System.out.println("Enter appointment Id :");
        String appointmentId = scanner.nextLine();

        System.out.println("Enter patient Id :");
        String patientId = scanner.nextLine();

        System.out.println("Enter doctor Id :");
        String doctorId = scanner.nextLine();

        System.out.println("Enter appointment Date :");
        String appointmentDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(appointmentDate);

        System.out.println("Enter appointment Time :");
        String appointmentTime = scanner.nextLine();

        System.out.println("Enter status :");
        String status = scanner.nextLine();

        System.out.println("Enter reason :");
        String reason = scanner.nextLine();

        System.out.println("Enter notes :");
        String notes = scanner.nextLine();

        Appointment appointment = new Appointment(notes,reason,status,appointmentTime,date,doctorId,patientId,appointmentId);


        return appointment;
    }

}
