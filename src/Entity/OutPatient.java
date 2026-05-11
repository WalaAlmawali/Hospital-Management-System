package Entity;

import java.time.LocalDate;
import java.util.List;

public class OutPatient extends Patient{

    private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;

    public OutPatient(String id, String firstName, LocalDate dateOfBirth, String lastName, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, List<MedicalRecord> medicalRecords, String insuranceId, List<Appointment> appointments, int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        super(id, firstName, dateOfBirth, lastName, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, medicalRecords, insuranceId, appointments);
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }



}
