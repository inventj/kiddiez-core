package be.inventj.kiddiez.model;

import java.util.Date;

public class Kid {

    private String firstName;
    private String lastName;
    private Date birthDate;

    public Kid(){

    }

    public Kid(String firstName, String lastName, Date birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
