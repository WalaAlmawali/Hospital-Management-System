package Service;

import Behavior.Appointable;
import Behavior.Manageable;
import Behavior.Searchable;
import Entity.*;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService implements Manageable,Searchable, Appointable {


    static List<Appointment> appointmentList = new ArrayList<>();

    DoctorService doctorService ;
    DepartmentService departmentService;
    PatientService patientService;

    //add new appointment
    public Appointment addAppointment(){

        String appointmentID = HelperUtils.generateId();
        String patientId = HelperUtils.generateId();

        String doctorId = InputHandler.getStringInput("Enter Doctor Id :");
        LocalDate appointmentDate = InputHandler.getDateInput("Enter appointment Date (yyyy-MM-dd):");

        String appointmentTime = InputHandler.getStringInput("Enter appointment Time (yyyy-MM-dd):");
        String reason = InputHandler.getStringInput("Enter reason :");
        String notes = InputHandler.getStringInput("Enter notes :");



        String status = "Scheduled";



        Appointment appointment = new Appointment(notes,reason,status,appointmentTime,appointmentDate,doctorId,patientId,appointmentID);


        return appointment;
    }

    public List<Appointment> addAppointments(){

        Boolean continueFlag = true;
        while (continueFlag) {

            appointmentList.add(addAppointment());
            System.out.println("Appointment add successfully");

            if (InputHandler.getStringInput("Enter c to add more , and q to exit").equals("q")) {
                continueFlag = false;
            }
        }
        return appointmentList;

    }

    // edit appointment by ID

    public void editAppointment(String appointmentId){

        if(!HelperUtils.isValidString(appointmentId)){
            System.out.println(" Invalid appointmentId");
            return;
        }

        boolean found = false;


        for(Appointment appointment : appointmentList){

            if(HelperUtils.isNull(appointment)){
                continue;
            }

            if(appointment.getAppointmentId().equals(appointmentId)){

                found = true;

                appointment.setDoctorId(InputHandler.getStringInput("Enter updated doctor Id :"));

                appointment.setAppointmentDate(InputHandler.getDateInput("Enter updated appointment Date :"));

                appointment.setAppointmentTime(InputHandler.getStringInput("Enter updated appointment Time :"));

                appointment.setStatus(InputHandler.getStringInput("Enter updated status :"));

                appointment.setReason(InputHandler.getStringInput("Enter updated reason :"));

               appointment.setNotes(InputHandler.getStringInput("Enter updated notes :"));

                System.out.println("Appointment updated successfully");
                break;

            }

        }
        if (!found) {
            System.out.println("Appointment not found.");
        }

    }

    // Delete appointment by ID
    public void removeAppointment(String appointmentId ){

        if(!HelperUtils.isValidString(appointmentId)){
            System.out.println("Invalid appointmentId");
            return;
        }

        appointmentList.removeIf(A -> A.getAppointmentId() == appointmentId);
        System.out.println("Appointment removed successfully");

        System.out.println("Appointment record not found");
    }

    //retrieve appointment
    public Appointment getAppointment(String appointmentId){

        if(!HelperUtils.isValidString(appointmentId)){
            System.out.println("Invalid appointmentId");
            return null;
        }

        for(Appointment appointment: appointmentList){
            if(appointment.getAppointmentId().equals(appointmentId)){
                return appointment;
            }

        }
        System.out.println("appointment Record not found");
        return null;
    }

    //get Appointments By Patient

    public void getAppointmentsByPatient(String patientId){

        if(!HelperUtils.isValidString(patientId)){
            System.out.println("Invalid patientId");
            return;
        }

        for(Appointment appointment : appointmentList){

            if(HelperUtils.isNull(appointment)){
                continue;
            }

            if(appointment.getPatientId().equals(patientId)){
                appointment.displayInfo();

            }
        }

    }

    // get Appointments By Doctor

    public void getAppointmentsByDoctor(String doctorId) {

        if(!HelperUtils.isValidString(doctorId)){
            System.out.println("Invalid doctorId");
            return ;
        }

        for(Appointment appointment : appointmentList){

            if(HelperUtils.isNull(appointment)){
                continue;
            }

            if(appointment.getDoctorId().equals(doctorId)){

                appointment.displayInfo();
            }
        }

        }

   // get Appointments By Date

    public void getAppointmentsByDate(LocalDate date){

        if(!HelperUtils.isValidDate(date)){
            System.out.println("Invalid date");
            return ;
        }

        for(Appointment appointment : appointmentList){

            if(HelperUtils.isNull(appointment)){
                continue;
            }

            if(appointment.getAppointmentDate().equals(date)){

                appointment.displayInfo();            }
        }
        }

        // reschedule Appointment
    public void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime){

        // Validate inputs
        if (!HelperUtils.isValidString(appointmentId)) {
            System.out.println("Invalid appointment ID.");
            return;
        }

        if (!HelperUtils.isValidDate(newDate) || HelperUtils.isPastDate(newDate)) {
            System.out.println("Invalid appointment date.");
            return;
        }

        if (!HelperUtils.isValidString(newTime)) {
            System.out.println("Invalid appointment time.");
            return;
        }
        for(Appointment appointment : appointmentList){

            if(appointment.getAppointmentId().equals(appointmentId)){

                appointment.setAppointmentDate(newDate);
                appointment.setAppointmentTime(newTime);
                appointment.setStatus("Rescheduled");

                System.out.println("Appointment rescheduled successfully.");
                return;
            }
        }

        System.out.println("Appointment not found.");

    }

        // cancel Appointment

    @Override
    public void scheduleAppointment(Appointment appointment) {

        // Validate appointment object
        if (HelperUtils.isNull(appointment)) {
            System.out.println("Invalid appointment.");
            return;
        }

        // Validate appointment date
        if (!HelperUtils.isValidDate(appointment.getAppointmentDate()) ||
                HelperUtils.isPastDate(appointment.getAppointmentDate())) {

            System.out.println("Invalid appointment date.");
            return;
        }

        // Validate appointment time
        if (!HelperUtils.isValidString(appointment.getAppointmentTime())) {
            System.out.println("Invalid appointment time.");
            return;
        }

        // Schedule appointment
        appointment.setStatus("Scheduled");
        appointmentList.add(appointment);

        System.out.println("Appointment scheduled successfully.");


    }

    public void cancelAppointment(String appointmentId){

        // Validate input
        if (!HelperUtils.isValidString(appointmentId)) {
            System.out.println("Invalid appointment ID.");
            return;
        }

        // Search and cancel
        for(Appointment appointment : appointmentList){

            if(appointment.getAppointmentId().equals(appointmentId)){
                appointment.setStatus("Cancelled");

                System.out.println("Appointment cancelled successfully.");
                return;
            }
        }
            System.out.println("Appointment not found.");

     }

    public void createAppointment(String patientId, String doctorId, LocalDate date){

        // Validate patient ID
        if (!HelperUtils.isValidString(patientId)) {
            System.out.println("Invalid patient ID.");
            return;
        }

        // Validate doctor ID
        if (!HelperUtils.isValidString(doctorId)) {
            System.out.println("Invalid doctor ID.");
            return;
        }

        // Validate date
        if (!HelperUtils.isValidDate(date) || HelperUtils.isPastDate(date)) {
            System.out.println("Invalid appointment date.");
            return;
        }

        // Create appointment
        Appointment appointment = new Appointment();

        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);
        appointment.setStatus("Scheduled");

        appointmentList.add(appointment);

        System.out.println("Appointment created successfully.");

    }

    //Overloaded createAppointment(String patientId, String doctorId, LocalDate date, String time)

    public void createAppointment(String patientId, String doctorId, LocalDate date ,String time){

        // Validate patient ID
        if (!HelperUtils.isValidString(patientId)) {
            System.out.println("Invalid patient ID.");
            return;
        }

        // Validate doctor ID
        if (!HelperUtils.isValidString(doctorId)) {
            System.out.println("Invalid doctor ID.");
            return;
        }

        // Validate date
        if (!HelperUtils.isValidDate(date) || HelperUtils.isPastDate(date)) {
            System.out.println("Invalid appointment date.");
            return;
        }

        // Validate time
        if (!HelperUtils.isValidString(time)) {
            System.out.println("Invalid appointment time.");
            return;
        }

        // Create appointment
        Appointment appointment = new Appointment();

        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);
        appointment.setAppointmentTime(time);
        appointment.setStatus("Scheduled");

        appointmentList.add(appointment);

        System.out.println("Appointment created successfully.");

    }

    // Overloaded createAppointment(Appointment appointment)
    public void createAppointment(Appointment appointment){

        // Validate appointment object
        if (HelperUtils.isNull(appointment)) {
            System.out.println("Invalid appointment.");
            return;
        }

        // Validate required fields (basic safety checks)
        if (!HelperUtils.isValidString(appointment.getPatientId())) {
            System.out.println("Invalid patient ID.");
            return;
        }

        if (!HelperUtils.isValidString(appointment.getDoctorId())) {
            System.out.println("Invalid doctor ID.");
            return;
        }

        if (!HelperUtils.isValidDate(appointment.getAppointmentDate()) ||
                HelperUtils.isPastDate(appointment.getAppointmentDate())) {

            System.out.println("Invalid appointment date.");
            return;
        }

        if (!HelperUtils.isValidString(appointment.getAppointmentTime())) {
            System.out.println("Invalid appointment time.");
            return;
        }

        // Set status
        appointment.setStatus("Scheduled");

        // Add appointment
        appointmentList.add(appointment);

        System.out.println("Appointment created successfully.");

    }

    // Overloaded rescheduleAppointment(String appointmentId, LocalDate newDate)

    public void rescheduleAppointment(String appointmentId, LocalDate newDate){

        if (!HelperUtils.isValidString(appointmentId)) {
            System.out.println("Invalid appointment ID.");
            return;
        }
        if (!HelperUtils.isValidDate(newDate)) {
            System.out.println("Invalid appointment date.");
            return;
        }

        if (HelperUtils.isPastDate(newDate)) {
            System.out.println("Cannot reschedule to a past date.");
            return;
        }

        Appointment appointment = getAppointment(appointmentId);

        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }


        appointment.setAppointmentDate(newDate);

        appointment.setStatus("Rescheduled");
        System.out.println("Appointment rescheduled successfully.");

    }

    // Overloaded rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason)

    public void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason){

        if (HelperUtils.isNull(appointment)) {
            System.out.println("Appointment cannot be null.");
            return;
        }

        if (!HelperUtils.isValidDate(newDate)) {
            System.out.println("Invalid appointment date.");
            return;
        }

        if (HelperUtils.isPastDate(newDate)) {
            System.out.println("Cannot reschedule to a past date.");
            return;
        }

        if (!HelperUtils.isValidString(newTime)) {
            System.out.println("Invalid appointment time.");
            return;
        }

        if (!HelperUtils.isValidString(reason)) {
            System.out.println("Invalid reason.");
            return;
        }

        appointment.setAppointmentDate(newDate);
        appointment.setAppointmentTime(newTime);
        appointment.setReason(reason);
        appointment.setStatus("Rescheduled");

        System.out.println("Appointment rescheduled successfully.");

    }

    // Overloaded displayAppointments(LocalDate date)
    public void displayAppointments(LocalDate date){

        if (!HelperUtils.isValidDate(date)) {
            System.out.println("Invalid date.");
            return;
        }

        boolean found = false;

        for(Appointment appointment: appointmentList){

            if(appointment.getAppointmentDate().equals(date)){

                appointment.displayInfo();

                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found for " + date);
        }
    }

    public void displayAppointments(){

        if(HelperUtils.isNull(appointmentList)){
            System.out.println("No appointments found.");
            return;
        }

        for(Appointment appointment: appointmentList){

            if(HelperUtils.isNull(appointment)){
                continue;
            }
            appointment.displayInfo();
        }
    }

    // Overloaded displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate)

    public void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate){

        if (!HelperUtils.isValidString(doctorId)) {
            System.out.println("Invalid doctor ID.");
            return;
        }

        if (!HelperUtils.isValidDate(startDate)
                || !HelperUtils.isValidDate(endDate)) {

            System.out.println("Invalid date range.");
            return;
        }

        if (endDate.isBefore(startDate)) {
            System.out.println("End date cannot be before start date.");
            return;
        }

        boolean found = false;

        for(Appointment appointment: appointmentList){

            if(appointment.getDoctorId().equals(doctorId)){

                LocalDate appointmentDate = appointment.getAppointmentDate();

                if ((appointmentDate.isEqual(startDate) || appointmentDate.isAfter(startDate)) &&
                        (appointmentDate.isEqual(endDate) || appointmentDate.isBefore(endDate))) {

                    appointment.displayInfo();

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

    public void ViewUpcomingAppointments(){

        if (HelperUtils.isNull(appointmentList)){
            System.out.println("No appointments found.");
            return;
        }

        for(Appointment appointment : appointmentList){

            if(HelperUtils.isNull(appointment)){
                continue;
            }

            if(appointment.getAppointmentDate().isAfter(LocalDate.now())){
                appointment.displayInfo();
            }
        }

    }

    public Boolean handleAppointmentMenu(Integer appointmentOption) {
        Scanner scanner = new Scanner(System.in);

        switch (appointmentOption) {
            case 1 -> {
               addAppointments();
            }
            case 2 -> {
                displayAppointments();
            }
            case 3 -> {

                String input = InputHandler.getStringInput("Enter patient id");
                getAppointmentsByPatient(input);
            }

            case 4 -> {
                String input = InputHandler.getStringInput("Enter doctor id");
                getAppointmentsByDoctor(input);


            }  case 5 -> {

                LocalDate dateInput = InputHandler.getDateInput("Enter date (yyyy-MM-dd):");
                getAppointmentsByDate(dateInput);

            }  case 6 -> {

                String appointmentId = InputHandler.getStringInput("Enter Appointment ID: ");
                LocalDate newDate = InputHandler.getDateInput("Enter Appointment new Date: ");
                String newTime = String.valueOf(InputHandler.getTimeInput("Enter Appointment new Time: "));

                rescheduleAppointment(appointmentId,newDate,newTime);


            }  case 7 -> {
                String input = InputHandler.getStringInput("Enter appointment ID to cancel: ");
                cancelAppointment(input);

            }  case 8 -> {
                String input = InputHandler.getStringInput("Enter appointment ID: ");

                AppointmentService appointmentService = new AppointmentService();
                Appointment appointment = appointmentService.getAppointment(input);

                appointment.complete();

            } case 9 ->{

                ViewUpcomingAppointments();

            }
            case 10 -> {

                return false;
            }

        }
        return true;
    }
    public void getupComingAppointments() {

        int scheduled = 0;
        int completed = 0;
        int cancelled = 0;

        LocalDate today = LocalDate.now();

        for (Appointment appointment : appointmentList) {
            appointment.displaySummary();
            if (appointment.getAppointmentDate().isAfter(today)) {

                if (appointment.getStatus().equalsIgnoreCase("Scheduled")) {
                    scheduled++;
                }
                else if (appointment.getStatus().equalsIgnoreCase("Completed")) {
                    completed++;
                }
                else if (appointment.getStatus().equalsIgnoreCase("Cancelled")) {
                    cancelled++;
                }
            }
        }

        System.out.println("===== FUTURE APPOINTMENT STATISTICS =====");
        System.out.println("Scheduled : " + scheduled);
        System.out.println("Completed : " + completed);
        System.out.println("Cancelled : " + cancelled);
    }

    public Boolean handleReportMenu(Integer reportOption) {


        switch (reportOption) {
            case 1 -> {
                getupComingAppointments();
            }
            case 2 -> {
                doctorService.DoctorPerformanceReport();
            }
            case 3 -> {
                departmentService.departmentOccupancyReport();
            }

            case 4 -> {
                patientService.patientStatisticsReport();
            }
            case 5 -> {
                patientService.emergencyCasesReport();

            }  case 6 -> {
                return false;
            }


        }
        return true;


    }
}
