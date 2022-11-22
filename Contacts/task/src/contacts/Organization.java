package contacts;

import java.time.LocalDateTime;

public class Organization extends Essence {

    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private LocalDateTime dataCreate;
    private LocalDateTime dataEdit;

    public Organization() {
        this.id = new CreateID().getId();
        this.dataCreate = LocalDateTime.now().withSecond(0).withNano(0);
        this.dataEdit = dataCreate;
    }

    @Override
    public String toStringInfo() {
        return "Organization name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Number: " + phoneNumber + "\n" +
                "Time created: " + dataCreate + "\n" +
                "Time last edit: " + dataEdit;
    }

    @Override
    public String toString() {
        return id + ". " + name + "\n";
    }

    @Override
    public void setId(int i) {
        this.id = i;
    }

    @Override
    public void setDataEdit(LocalDateTime withNano) {

    }

    @Override
    public void setName(String nextLine) {
        this.name = nextLine;
    }


    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setSurname(String nextLine) {

    }

    @Override
    public void setBirthDate(String birthDate) {

    }

    @Override
    public void setGender(String gender) {

    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return null;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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
}
