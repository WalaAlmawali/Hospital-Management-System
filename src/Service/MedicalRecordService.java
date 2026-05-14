package Service;

import Behavior.Manageable;
import Behavior.Searchable;
import Entity.MedicalRecord;
import Entity.Nurse;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService implements Manageable, Searchable {

    Scanner scanner = new Scanner(System.in);
    static List<MedicalRecord> medicalRecordList = new ArrayList<>();

    public MedicalRecord addMedicalRecord() {

        String recordId = HelperUtils.generateId();

        System.out.println("Enter patient Id :");
        String patientId = scanner.nextLine();

        System.out.println("Enter doctor Id :");
        String doctorId = scanner.nextLine();

        System.out.println("Enter visit Date (yyyy-MM-dd):");
        LocalDate date;

        try {
            date = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return null;
        }

        System.out.println("Enter diagnosis :");
        String diagnosis = scanner.nextLine();

        System.out.println("Enter prescription :");
        String prescription = scanner.nextLine();

        System.out.println("Enter test Results :");
        String testResults = scanner.nextLine();

        System.out.println("Enter notes :");
        String notes = scanner.nextLine();

        // Basic validation
        if (!HelperUtils.isValidString(patientId) ||
                !HelperUtils.isValidString(doctorId) ||
                !HelperUtils.isValidString(diagnosis)) {

            System.out.println("Invalid input data.");
            return null;
        }

        MedicalRecord medicalRecord = new MedicalRecord(recordId,patientId,doctorId,date,diagnosis,testResults,prescription,notes);

        return medicalRecord;
    }

    public List<MedicalRecord> addMedicalRecords() {

        Boolean continueFlag = true;
        while (continueFlag) {

            medicalRecordList.add(addMedicalRecord());
            System.out.println("Medical record add successfully");

            System.out.println("Enter c to add more , and q to exit");
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return medicalRecordList;

    }

    public void editMedicalRecord(String recordId) {

        if (!HelperUtils.isValidString(recordId)) {
            System.out.println("Invalid record ID.");
            return;
        }

        boolean found = false;

        for(MedicalRecord medicalRecord : medicalRecordList){

            if(medicalRecord.getRecordId().equals(recordId)){

                found = true;

                System.out.println("Enter updated patient Id :");
                medicalRecord.setPatientId(scanner.nextLine());

                System.out.println("Enter updated doctor Id :");
                medicalRecord.setDoctorId(scanner.nextLine());

                System.out.println("Enter updated visit Date (yyyy-MM-dd):");

                try {
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    medicalRecord.setVisitDate(date);
                } catch (Exception e) {
                    System.out.println("Invalid date format. Skipping update.");
                }

                System.out.println("Enter updated diagnosis :");
                medicalRecord.setDiagnosis(scanner.nextLine());

                System.out.println("Enter updated prescription :");
                medicalRecord.setPrescription(scanner.nextLine());

                System.out.println("Enter updated test Results :");
                medicalRecord.setTestResults(scanner.nextLine());

                System.out.println("Enter updated notes :");
                medicalRecord.setNotes(scanner.nextLine());

                System.out.println("Medical record updated successfully");
                break;
            }

        }
        if (!found) {
            System.out.println("Medical record not found.");
        }

    }

    // remove medical record by ID
    public void removeMedicalRecord(String recordId){

        if (!HelperUtils.isValidString(recordId)) {
            System.out.println("Invalid record ID.");
            return;
        }

        boolean removed = medicalRecordList.removeIf(
                m -> m.getRecordId().equals(recordId));

        if (removed) {
            System.out.println("Medical record removed successfully.");
        } else {
            System.out.println("Medical record not found.");
        }


    }

    //retrieve medical record
    public MedicalRecord getMedicalRecord(String recordId){

        if (!HelperUtils.isValidString(recordId)) {
            return null;
        }

        for(MedicalRecord medicalRecord: medicalRecordList){

            if(!HelperUtils.isNull(medicalRecord) && medicalRecord.getRecordId().equals(recordId)){
                return medicalRecord;
            }

        }
        System.out.println("medical Record not found");
        return null;
    }

    //get Records By PatientId
    public List<MedicalRecord> getRecordsByPatientId(String patientId){

        List<MedicalRecord> patientMedicalRecords = new ArrayList<>();

        if (!HelperUtils.isValidString(patientId)) {
            return patientMedicalRecords;
        }

        for (MedicalRecord medicalRecord : medicalRecordList){

            if (HelperUtils.isNull(medicalRecord)) {
                continue;
            }

            if(medicalRecord.getPatientId().equals(patientId)){
                patientMedicalRecords.add(medicalRecord);
            }
        }

        return patientMedicalRecords;
    }

    // get Records By DoctorId

    public List<MedicalRecord> getRecordsByDoctorId(String doctorId){

        List<MedicalRecord> doctorMedicalRecords = new ArrayList<>();

        if (!HelperUtils.isValidString(doctorId)) {
            return doctorMedicalRecords;
        }

        for (MedicalRecord medicalRecord : medicalRecordList){

            if (HelperUtils.isNull(medicalRecord)) {
                continue;
            }

            if(medicalRecord.getDoctorId().equals(doctorId)){
                doctorMedicalRecords.add(medicalRecord);
            }
        }

        return doctorMedicalRecords;
    }

    //display PatientHistory

    public void displayPatientHistory(String patientId) {

        if (!HelperUtils.isValidString(patientId)) {
            System.out.println("Invalid patient ID.");
            return;
        }

        boolean found = false;

        for(MedicalRecord medicalRecord : medicalRecordList){

            if (HelperUtils.isNull(medicalRecord)) {
                continue;
            }
            if(medicalRecord.getPatientId().equals(patientId)){
                medicalRecord.displayInfo();
                found = true;

            }
        }
        if (!found) {
            System.out.println("No medical history found for patient: " + patientId);
        }
    }

    @Override
    public void add(Object entity) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Object> getAll() {
        return List.of();
    }

    @Override
    public void search(String keyword) {

    }

    @Override
    public Object searchById(String id) {
        return null;
    }
}
