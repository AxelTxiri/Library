package Controller;

import Model.Profile;

import java.util.Date;
import java.util.Scanner;

public class ProfileController {
    public static Scanner scanner = new Scanner(System.in);
    public static DateController dateController = new DateController();
    public static Profile profileBuilder(){
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Last name:");
        String lastName = scanner.nextLine();
        Date birthdate = dateController.dateInput();

        Profile profile = new Profile(name,lastName,birthdate);
        return profile;
    }
}
