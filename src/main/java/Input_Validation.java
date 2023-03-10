import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Scanner;

public class Input_Validation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your Firstname:");
        String firstName = sc.nextLine();
        System.out.println("Enter your Lastname:");
        String lastName = sc.nextLine();
        System.out.println("Enter your Birthdate:");
        LocalDate date = LocalDate.parse(sc.nextLine());


        User user = new User(firstName,lastName,date,0,0,null,null);

        //System.out.println(checkName(user));
        System.out.println();


    }

    public static boolean checkName(User user) {

        if(user.getFirstName().length() > 64|| user.getlastName().length() > 64){
            return false;
        }

        if ( user.getFirstName()== null || user.getlastName()== null) {
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

    public static boolean checkDate(User user){
        if(user.getBirthDay().isDate(date, datePattern, false)){
            return true;
        }
        return false;


    }

    public static boolean isDate(String value,String datePattern, boolean strict)





}
