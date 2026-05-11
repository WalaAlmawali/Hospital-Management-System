import Service.PatientService;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        PatientService patientService = new PatientService();
        patientService.addPatient("wala","salam","9888");
        patientService.displayAllPatients();
    }
}
