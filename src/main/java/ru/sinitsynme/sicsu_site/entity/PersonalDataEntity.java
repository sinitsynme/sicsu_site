package ru.sinitsynme.sicsu_site.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "personal_data")
public class PersonalDataEntity implements Comparable<PersonalDataEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String firstName;

    private String lastName;

    private String patronymic;

    private Date birthDate;

    private String email;

    public PersonalDataEntity() {
    }

    public PersonalDataEntity(String firstName, String lastName, String patronymic, Date birthDate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(PersonalDataEntity otherPersonalData) {
        int firstNameCompareValue = this.firstName.compareTo(otherPersonalData.firstName);
        int lastNameCompareValue = this.lastName.compareTo(otherPersonalData.lastName);
        int patronymicCompareValue = this.patronymic.compareTo(otherPersonalData.patronymic);

        return lastNameCompareValue != 0 ? lastNameCompareValue :
                firstNameCompareValue != 0 ? firstNameCompareValue :
                        patronymicCompareValue;
    }
}
