import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Input_Validation {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

      Input();

    }

    public static boolean Input(){
        String firstName = "";
        String lastName = "";
        String date_str = "";
        String zipCode = "";
        String phoneNumber = "";
        String password = "";
        String reEnter = "";
        User user = new User(firstName, lastName, date_str, zipCode, phoneNumber, password, reEnter);

        System.out.println("Required: ");
        System.out.println("---------------------");

        //FirstName
        do{
            System.out.println("Enter your Firstname:");
            firstName = sc.nextLine();
            user.setFirstName(firstName);
        }while(checkName(user) ==false);

        //LastName
        do{
            System.out.println("Enter your Lastname:");
            lastName = sc.nextLine();
            user.setLastName(lastName);
        }while(checkName(user) ==false);

        //Date
        do{
            System.out.println("Enter your Birthday:");
            date_str = sc.nextLine();
            user.setBirthDay(date_str);
        }while(checkDate(user) ==false);

        //Zip_Code
        do{
            System.out.println("Enter your Zip-Code:");
            zipCode = sc.nextLine();
            user.setZipCode(zipCode);
        }while(checkZIP(user) ==false);

        //Phone_Number
        do{
            System.out.println("Enter your PhoneNumber:");
            phoneNumber = sc.nextLine();
            user.setPhoneNumber(phoneNumber);
        }while(checkPhoneNumber(user) ==false);

        //Password
        do{
            System.out.println("Enter your Password:");
            password = sc.nextLine();
            user.setPassword(password);
            System.out.println("Re-Enter your Password: ");
            reEnter = sc.nextLine();
            user.setReenter(reEnter);
        }while(checkPassword(user) ==false && reCheckPassword(user) ==false);


        return true;
    }
    public static boolean checkName(User user) {

        System.out.println(user.getFirstName());

        if (user.getFirstName().length() > 64 || user.getlastName().length() > 64) {
            return false;
        }

        if (user.getFirstName() == null || user.getlastName() == null) {
            return false;
        }
        int len = user.getFirstName().length();
        int len2 = user.getlastName().length();

        for (int i = 0; i < len; i++) {
            if ((Character.isLetter(user.getFirstName().charAt(i)) == false)) {
                return false;
            }
            return true;
        }
        for (int i = 0; i < len2; i++) {
            if ((Character.isLetter(user.getlastName().charAt(i)) == false)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean checkDate(User user) {
        if(user.getBirthDay() == ""){
            return true;
        }
        if(user.getBirthDay().length() != 10){
            return false;
        }

        String dateFormat = "dd.MM.yyyy";
        System.out.println(user.getBirthDay());
        try {
            DateFormat df = new SimpleDateFormat(dateFormat);
            df.setLenient(false);
            df.parse(user.getBirthDay());
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean checkZIP(User user) {
        if(user.getZipCode() == ""){
            return true;
        }

        System.out.println(user.getZipCode());

        if (user.getZipCode().length() > 4) {
            return false;
        }

        int len = user.getZipCode().length();
        for (int i = 0; i < len; i++) {
            if ((Character.isDigit(user.getZipCode().charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPhoneNumber(User user) {
        System.out.println(user.getPhoneNumber());

        int len = user.getPhoneNumber().length();

        if (user.getPhoneNumber().charAt(0) != '+') {
            return false;
        }
        for (int i = 1; i < len; i++) {
            if ((Character.isDigit(user.getPhoneNumber().charAt(i)) == false) && (user.getPhoneNumber().charAt(i) != ' ')) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPassword(User user) {
        System.out.println(user.getPassword());

        int counterSpecial = 0;
        int counterCapital = 0;
        int counterDigit = 0;
        int len = user.getPassword().length();

        for (int i = 0; i < len; i++) {
            if ((Character.isDigit(user.getPassword().charAt(i)) == false) && (Character.isLetter(user.getPassword().charAt(i)) == false) && (user.getPassword().charAt(i) != ' ')) {
                counterSpecial++;
            }
            if ((Character.isUpperCase(user.getPassword().charAt(i)) == true)) {
                counterCapital++;
            }
            if ((Character.isDigit(user.getPassword().charAt(i)) == true)) {
                counterDigit++;
            }
        }

        if (counterSpecial < 1 || counterCapital < 1 || counterDigit < 1 || len < 8) {
            return false;
        }
        return true;
    }

    public static boolean reCheckPassword(User user){

        if(user.getPassword().equals(user.getReenter())){
            return true;
        }else{
            return false;
        }
    }
}
