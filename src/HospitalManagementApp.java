import Entity.Menu;
import Service.*;
import Utils.MenuMessages;

import java.util.Scanner;

public class HospitalManagementApp {


    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
         Menu menu = new Menu();


//        AppointmentService appointmentService = new AppointmentService();
//        DepartmentService departmentService = new DepartmentService();
         DoctorService doctorService = new DoctorService();
//        MedicalRecordService medicalRecordService = new MedicalRecordService();
          NurseService nurseService = new NurseService();
          PatientService patientService = new PatientService();

        Boolean mainMenuContinue = true;

        while (mainMenuContinue) {

            menu.displayMenu();

            Integer option = input.nextInt();
            switch (option) {
                case 1 -> {
                  Boolean patientMenuContinue = true;
                   while (patientMenuContinue) {
                        System.out.println(" ***********Patient Menu ***********");
                        System.out.println(MenuMessages.PATIENT_MENU_MESSAGE);
                       Integer patientOption = input.nextInt();
                        patientMenuContinue = patientService.handlePatientMenu(patientOption);
                  }
                }
               case 2 -> {
                   Boolean doctorMenuContinue = true;
                    while (doctorMenuContinue) {
                        System.out.println(" ***********Doctor Menu ***********");
                        System.out.println(MenuMessages.DOCTOR_MENU_MESSAGE);
                        Integer doctorOption = input.nextInt();
                        doctorMenuContinue = doctorService.handleDoctorMenu(doctorOption);
                    }

                }
                case 3 ->{
                    Boolean nurseMenuContinue = true;
                    while (nurseMenuContinue) {
                        System.out.println(" ***********Nurse Menu ***********");
                        System.out.println(MenuMessages.NURSE_MENU_MESSAGE);
                        Integer nurseOption = input.nextInt();
                        nurseMenuContinue = nurseService.handleNurseMenu(nurseOption);
                    }

                }
//                case 4 -> {
//                    Boolean appointmentMenuContinue = true;
//                    while (appointmentMenuContinue) {
//                        System.out.println(" ***********Appointment Menu ***********");
//                        System.out.println(MenuMessages.APPOINTMENT_MENU_MESSAGE);
//                        Integer appointmentOption = input.nextInt();
//                        appointmentMenuContinue = appointmentService.handleAppointmentMenu(appointmentOption);
//                    }
//                }
//
//                case 5 ->{
//                    Boolean recordMenuContinue = true;
//                    while (recordMenuContinue) {
//                        System.out.println(" *********** Medical Records Menu ***********");
//                        System.out.println(MenuMessages.MEDICALRECORDS_MENU_MESSAGE);
//                        Integer recordOption = input.nextInt();
//                        recordMenuContinue = medicalRecordService.handleRecordMenu(recordOption);
//                    }
//
//
//                }
//
//                case 6 ->{
//                    Boolean depMenuContinue = true;
//                    while (depMenuContinue) {
//                        System.out.println(" *********** Department Menu ***********");
//                        System.out.println(MenuMessages.DEPARTMENT_MENU_MESSAGE);
//                        Integer depOption = input.nextInt();
//                        depMenuContinue = departmentService.handleDepMenu(depOption);
//                    }
//
//                }
//                case 7 ->{
//                    Boolean reportMenuContinue = true;
//                    while (reportMenuContinue) {
//                        System.out.println(" *********** Reports Menu ***********");
//                        System.out.println(MenuMessages.REPORT_MENU_MESSAGE);
//                        Integer reportOption = input.nextInt();
//                        reportMenuContinue = appointmentService.handleReportMenu(reportOption);
//                    }
//

  //              }
                case 8->{
                    System.out.println("Exit");
                    mainMenuContinue = false;
                }
                default -> System.out.println("Select a choice from the list");

            }
        }


    }
}
