package Entity;

import java.util.List;

public class Nurse extends Person {

    private String nurseId;
    private String departmentId;
    private String shift; // Morning / Evening / Night
    private String qualification;
    private List<String> assignedPatients;
}
