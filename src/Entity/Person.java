package Entity;

import java.util.Date;
import java.util.Objects;

public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;

    public Person(String id, String firstName, Date dateOfBirth, String lastName, String gender, String phoneNumber, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}
