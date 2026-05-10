package Entity;

import javax.xml.crypto.Data;
import java.util.Date;
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

    public Patient(String id, String firstName, Date dateOfBirth, String lastName, String gender, String phoneNumber, String email, String address) {
        super(id, firstName, dateOfBirth, lastName, gender, phoneNumber, email, address);
    }
}