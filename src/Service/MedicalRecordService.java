package Service;

import Behavior.Manageable;
import Behavior.Searchable;
import Entity.MedicalRecord;
import Entity.Nurse;
import Entity.Patient;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordService implements Manageable, Searchable {

    static List<MedicalRecord> medicalRecordList = new ArrayList<>();

    PatientService patientService ;


    public MedicalRecord addMedicalRecord() {

        String recordId = HelperUtils.generateId();

        String patientId = InputHandler.getStringInput("Enter patient id ");
        String doctorId = InputHandler.getStringInput("Enter doctor id ");

        LocalDate date = InputHandler.getDateInput("Enter visit Date (yyyy-MM-dd):");
        String diagnosis = InputHandler.getStringInput("Enter diagnosis :");

        String prescription = InputHandler.getStringInput("Prescription :");
        String testResults = InputHandler.getStringInput("Enter test Results :");

        String notes = InputHandler.getStringInput("Enter notes :");


        MedicalRecord medicalRecord = new MedicalRecord(recordId,patientId,doctorId,date,diagnosis,testResults,prescription,notes);

        return medicalRecord;
    }

    public List<MedicalRecord> addMedicalRecords() {

        Boolean continueFlag = true;
        while (continueFlag) {

            medicalRecordList.add(addMedicalRecord());
            System.out.println("Medical record add successfully");

            if (InputHandler.getStringInput("Enter c to add more and q to exit").equals("q")) {
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

                medicalRecord.setPatientId(InputHandler.getStringInput("Enter updated patient id "));
                medicalRecord.setDoctorId(InputHandler.getStringInput("Enter updated doctor id "));


                medicalRecord.setVisitDate(InputHandler.getDateInput("Enter updated visit Date (yyyy-MM-dd)"));
                medicalRecord.setDiagnosis(InputHandler.getStringInput("Enter updated diagnosis "));

                medicalRecord.setPrescription(InputHandler.getStringInput("Enter updated prescription "));
                medicalRecord.setTestResults(InputHandler.getStringInput("Enter updated test Results "));

                medicalRecord.setNotes(InputHandler.getStringInput("Enter updated notes "));

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

    // get all medical records
    public void getRecords(){

        if(HelperUtils.isNull(medicalRecordList)){
            System.out.println(" No Medical records  found.");
            return;
        }

        for(MedicalRecord medicalRecord : medicalRecordList){

            if(HelperUtils.isNull(medicalRecord)){
                continue;
            }

            medicalRecord.displayInfo();
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
    public void getRecordsByPatientId(String patientId){

        if (!HelperUtils.isValidString(patientId)) {
            System.out.println("Invalid patient ID.");
            return ;
        }

        for (MedicalRecord medicalRecord : medicalRecordList){

            if (HelperUtils.isNull(medicalRecord)) {
                continue;
            }

            if(medicalRecord.getPatientId().equals(patientId)){
                medicalRecord.displayInfo();
            }
        }

    }

    // get Records By DoctorId

    public void getRecordsByDoctorId(String doctorId){

        if (!HelperUtils.isValidString(doctorId)) {
            System.out.println("Invalid doctor ID.");
            return ;
        }

        for (MedicalRecord medicalRecord : medicalRecordList){

            if (HelperUtils.isNull(medicalRecord)) {
                continue;
            }

            if(medicalRecord.getDoctorId().equals(doctorId)){
                medicalRecord.displayInfo();
            }
        }
    }

    //display PatientHistory

    public void displayPatientHistory(String patientId) {

        if (!HelperUtils.isValidString(patientId)) {
            System.out.println("Invalid patient ID.");
            return;
        }

        Patient patient = patientService.getPatientById(patientId);

        if(HelperUtils.isNull(patient)){
            System.out.println("Patient not found.");
            return;
        }

        if(HelperUtils.isNull(medicalRecordList)){
            System.out.println("No Medical records found.");
            return;
        }

        for(MedicalRecord medicalRecord : patient.getMedicalRecords()){
            medicalRecord.displayInfo();
            }
        }



    public void generatePatientHistoryReport(String patientId) {

        if(HelperUtils.isValidString(patientId)){
            System.out.println("Invalid patient ID.");
            return;
        }

        Patient patient = patientService.getPatientById(patientId);

        if (HelperUtils.isNull(patient)) {
            return;
        }

        System.out.println("PATIENT HISTORY REPORT");
        System.out.println("=======================");

        System.out.println("Patient ID: " + patient.getId());
        System.out.println("Name: " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Blood Group: " + patient.getBloodGroup());

        System.out.println();
        System.out.println("MEDICAL RECORDS:");
        System.out.println("----------------------------------");



        if(HelperUtils.isNull(medicalRecordList)){
            System.out.println("No Medical records found.");
            return;
        }

        for (MedicalRecord record : medicalRecordList) {

            if (record.getPatientId().equals(patientId)) {
                record.displaySummary();

            }
        }


    }

    @Override
    public void add(Object entity) {
        MedicalRecord medicalRecord = (MedicalRecord) entity;
        medicalRecordList.add(medicalRecord);

    }

    @Override
    public void remove(String id) {
        MedicalRecord medicalRecord = getMedicalRecord(id);
        if(HelperUtils.isNotNull(medicalRecord)){
            medicalRecordList.remove(medicalRecord);
        }

    }

    @Override
    public List<Object> getAll() {

        return List.of();
    }

    @Override
    public void search(String keyword) {

        boolean found = false;

        for (MedicalRecord medicalRecord : medicalRecordList) {

            if (

                            medicalRecord.getDiagnosis().equals(keyword)||
                            medicalRecord.getPrescription().equals(keyword)||
                            medicalRecord.getPatientId().equals(keyword)||
                            medicalRecord.getDoctorId().equals(keyword)
            ) {

                medicalRecord.displaySummary();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No medical records found.");
        }

    }

    @Override
    public Object searchById(String id) {

        MedicalRecord medicalRecord = getMedicalRecord(id);

        if(HelperUtils.isNotNull(medicalRecord)){

            return medicalRecord;
        }

        return null;
    }

    public Boolean handleRecordMenu(Integer recordOption) {
        Scanner scanner = new Scanner(System.in);

        switch (recordOption) {
            case 1 -> {
                addMedicalRecords();
            }
            case 2 -> {

                getRecords();
            }
            case 3 -> {
                String input = InputHandler.getStringInput("Enter patient id");
                getRecordsByPatientId(input);

            }

            case 4 -> {
                String input = InputHandler.getStringInput("Enter doctor id");
                getRecordsByDoctorId(input);


            }  case 5 -> {
                String input = InputHandler.getStringInput("Enter medical record id");
                editMedicalRecord(input);

            }  case 6 -> {
                String input = InputHandler.getStringInput("Enter medical record id to remove");
                removeMedicalRecord(input);

            }  case 7 -> {
                String input = InputHandler.getStringInput("Enter patient id to display history report");
                generatePatientHistoryReport(input);

            }  case 8 -> {
                return false;
            }

        }
        return true;
    }
}
