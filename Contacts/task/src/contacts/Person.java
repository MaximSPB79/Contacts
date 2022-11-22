package contacts;

import java.time.LocalDateTime;

public class Person extends Essence {

    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String birthDate;
    private String gender;
    private LocalDateTime dataCreate;
    private LocalDateTime dataEdit;

    public Person() {
        this.id = new CreateID().getId();
        this.dataCreate = LocalDateTime.now().withSecond(0).withNano(0);
        this.dataEdit = dataCreate;
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + surname + "\n";
    }

    public String toStringInfo() {
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birth date: " + birthDate + "\n" +
                "Gender: " + gender + "\n" +
                "Number: " + phoneNumber + "\n" +
                "Time created: " + dataCreate + "\n" +
                "Time last edit: " + dataEdit;
    }

    public void setDataEdit(LocalDateTime dataEdit) {
        this.dataEdit = dataEdit;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(LocalDateTime dataCreate) {
        this.dataCreate = dataCreate;
    }

    public LocalDateTime getDataEdit() {
        return dataEdit;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setAddress(String address) {

    }


}

