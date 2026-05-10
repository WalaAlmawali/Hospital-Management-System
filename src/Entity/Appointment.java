package Entity;

import java.time.LocalDate;

public class Appointment {

    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private String notes;

    public Appointment(String notes, String reason, String status, String appointmentTime, LocalDate appointmentDate, String doctorId, String patientId, String appointmentId) {
        this.notes = notes;
        this.reason = reason;
        this.status = status;
        this.appointmentTime = appointmentTime;
        this.appointmentDate = appointmentDate;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentId = appointmentId;
    }
}
