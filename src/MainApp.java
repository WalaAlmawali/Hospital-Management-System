import Service.PatientService;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        PatientService patientService = new PatientService();
        patientService.addPatients();
       patientService.displayPatients("wala");


    }
}
