package Entity;

import Behavior.Displayable;
import Utils.HelperUtils;

import java.time.LocalDate;

public class MedicalRecord implements Displayable {
    private String recordId;
    private String patientId;
    private String doctorId;
    private LocalDate visitDate;
    private String diagnosis;
    private String prescription;
    private String testResults;
    private String notes;

    public MedicalRecord(String recordId, String patientId, String doctorId, LocalDate visitDate, String diagnosis, String testResults, String prescription, String notes) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.testResults = testResults;
        this.prescription = prescription;
        this.notes = notes;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {

        if (!HelperUtils.isValidString(patientId)) {
            throw new IllegalArgumentException("Invalid patient ID");
        }
        this.patientId = patientId;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {

        if (HelperUtils.isNull(visitDate)) {
            throw new IllegalArgumentException("Visit date cannot be null");
        }

        if (visitDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Visit date cannot be in the future");
        }
        this.visitDate = visitDate;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {

        if (!HelperUtils.isValidString(doctorId)) {
            throw new IllegalArgumentException("Invalid doctor ID");
        }
        this.doctorId = doctorId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {

        if (!HelperUtils.isValidString(diagnosis)) {
            throw new IllegalArgumentException("Diagnosis cannot be empty");
        }
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {

        if (!HelperUtils.isValidString(prescription)) {
            throw new IllegalArgumentException("Prescription cannot be empty");
        }
        this.prescription = prescription;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {

        if (!HelperUtils.isValidString(testResults)) {
            throw new IllegalArgumentException("Test results cannot be empty");
        }
        this.testResults = testResults;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {

        this.notes = notes;
    }

    public void displayInfo(){

        System.out.println("record Id : " + recordId);
        System.out.println("patient Id : " + patientId);
        System.out.println("doctor Id : " + doctorId);
        System.out.println("visit Date  : " + visitDate);
        System.out.println("diagnosis  : " + diagnosis);
        System.out.println("prescription  : " + prescription);
        System.out.println("test Results  : " + testResults);
        System.out.println("notes  : " + notes);


    }

    @Override
    public void displaySummary() {

    }
}
