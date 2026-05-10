package Entity;

import javax.xml.crypto.Data;
import java.util.List;

public class Patient extends Person {

    private String patientId;
    private String bloodGroup;
    private List allergies;
    private String emergencyContact;
    private Data registrationDate;
    private String insuranceId;
    private List medicalRecords;
    private List appointments;

}