import java.time.LocalDate;
import java.util.Date;

public class User {

    private String firstName;
    private String lastName;
    private String birthDay;
    private String zipCode;
    private String phoneNumber;
    private String password;
    private String reenter;


    public User(String firstName, String lastName, String birthDay, String zipCode, String phoneNumber, String password, String reenter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.reenter = reenter;
    }

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReenter() {
        return reenter;
    }

    public void setReenter(String reenter) {
        this.reenter = reenter;
    }
}
