package Entity;

public class EmergencyPatient extends Patient{

    private String emergencyType;
    private String arrivalMode; // Ambulance / Walk-in
    private int triageLevel;    // 1 to 5
    private boolean admittedViaER;


}
