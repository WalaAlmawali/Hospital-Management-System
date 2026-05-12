package Entity;

import Behavior.Billable;
import Behavior.Displayable;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

// Level 3 Inheritance
public class InPatient extends Patient implements Displayable, Billable {

    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;

    // Constructor chaining to Patient
    public InPatient(String id, String firstName, LocalDate dateOfBirth, String lastName, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, List<MedicalRecord> medicalRecords, String insuranceId, List<Appointment> appointments, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges) {

        // Calls Patient constructor
        super(id, firstName, dateOfBirth, lastName, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, medicalRecords, insuranceId, appointments);
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getAdmittingDoctorId() {
        return admittingDoctorId;
    }

    public void setAdmittingDoctorId(String admittingDoctorId) {
        this.admittingDoctorId = admittingDoctorId;
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {
        this.dailyCharges = dailyCharges;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("admission Date : " + admissionDate);
        System.out.println("discharge Date :"+ dischargeDate);
        System.out.println("room Number: " + roomNumber);
        System.out.println("bedNumber :" + bedNumber);
        System.out.println("admitting Doctor Id : "+ admittingDoctorId);
        System.out.println("daily Charges: "+ dailyCharges);
        System.out.println("Stay Duration      : " + calculateStayDuration() + " days");
        System.out.println("Total Charges      : " + calculateTotalCharges());
    }

    @Override
    public void displaySummary() {

    }

    //calculate Stay Duration
    public long  calculateStayDuration(){

        if (HelperUtils.isNull(admissionDate) || HelperUtils.isNull(dischargeDate)) {

            System.out.println("Admission or discharge date is missing.");
            return 0;
        }

        // Prevent invalid date order
        if (dischargeDate.isBefore(admissionDate)) {

            System.out.println("Discharge date cannot be before admission date.");
            return 0;
        }

        return ChronoUnit.DAYS.between(admissionDate, dischargeDate);

    }

    // calculateTotalCharges()
    public double calculateTotalCharges() {

        return calculateStayDuration() * dailyCharges;
    }

    @Override
    public double calculateCharges() {
        return 0;
    }

    @Override
    public void generateBill() {

    }

    @Override
    public boolean processPayment(double amount) {
        return false;
    }
}
