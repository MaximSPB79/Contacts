package contacts;

import java.time.LocalDateTime;

public abstract class Essence {

    public int getId() {
        return 0;
    }

    public abstract String toStringInfo();

    public abstract void setId(int i);

    public abstract void setDataEdit(LocalDateTime withNano);

    public abstract void setName(String nextLine);

    public abstract String getName();

    public abstract String getSurname();

    public abstract String getPhoneNumber();

    public abstract void setPhoneNumber(String phoneNumber);

    public abstract void setSurname(String nextLine);

    public abstract void setBirthDate(String birthDate);

    public abstract void setGender(String gender);

    public abstract void setAddress(String address);

}
