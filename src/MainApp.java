import Service.PatientService;

public class MainApp {
    public static void main(String[] args){

        PatientService patientService = new PatientService();
        patientService.addPatients();
    }
}
