package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consultant extends Doctor{

    private List<String> consultationTypes;
    private boolean onlineConsultationAvailable;
    private int consultationDuration; // int - in minutes

    public Consultant(String id, String firstName, LocalDate dateOfBirth, String lastName, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients, List<String> consultationTypes, boolean onlineConsultationAvailable, int consultationDuration) {

        super(id, firstName, dateOfBirth, lastName, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);

        this.consultationTypes = new ArrayList<>();
        this.onlineConsultationAvailable = onlineConsultationAvailable;
        this.consultationDuration = consultationDuration;
    }

    public List<String> getConsultationTypes() {
        return consultationTypes;
    }

    public void setConsultationTypes(List<String> consultationTypes) {
        this.consultationTypes = consultationTypes;
    }

    public boolean isOnlineConsultationAvailable() {
        return onlineConsultationAvailable;
    }

    public void setOnlineConsultationAvailable(boolean onlineConsultationAvailable) {
        this.onlineConsultationAvailable = onlineConsultationAvailable;
    }

    public int getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(int consultationDuration) {
        this.consultationDuration = consultationDuration;
    }
}
