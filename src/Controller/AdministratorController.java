package Controller;

import Model.AdministratorRepository;
import Model.Permissions;
import Model.Profile;

import java.security.Permission;
import java.util.ArrayList;
import java.util.Scanner;

public class AdministratorController {
    public static Scanner scanner = new Scanner(System.in);
    public static AdministratorRepository adminRepository = new AdministratorRepository();
    public static ProfileController profileController = new ProfileController();
    public static int option=0;
    public static void adminOperations(){
        adminMenu();

        do{
            switch (option){
                case 1 :
                    Profile profile = ProfileController.profileBuilder();
                    ArrayList<Permissions> permissions = new ArrayList<>();
                    System.out.println("Enter username:");
                    String username = scanner.nextLine();
                    System.out.println("Enter password:");
                    String password = scanner.nextLine();
                    boolean isSuperAdmin = false;

                    adminRepository.createAdmin(profile,username,password,permissions,isSuperAdmin);

                    adminMenu();
                    break;
                case 2:
                    if(AdministratorRepository.admins.isEmpty()){
                        System.out.println("There's no admins to see.");
                        System.out.println();
                    }
                    else {
                        System.out.println("ADMIN LIST:");
                        adminRepository.readAdmin();
                    }

                    adminMenu();
                    break;
                case 3:
                    if(AdministratorRepository.admins.isEmpty()){
                        System.out.println("There's no admins to update.");
                        System.out.println();
                    }
                    else {
                        adminRepository.readAdmin();
                        System.out.println();
                        System.out.println("Enter the # of the admin to edit:");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        index--;

                        Profile updatedProfile = ProfileController.profileBuilder();
                        ArrayList<Permissions> permissions1 = new ArrayList<>();
                        scanner.nextLine();
                        System.out.println("Enter username:");
                        String username1 = scanner.nextLine();
                        System.out.println("Enter password:");
                        String password1 = scanner.nextLine();
                        boolean isSuperAdmin1 = false;
                        adminRepository.updateAdmin(index, updatedProfile,username1,password1,permissions1,isSuperAdmin1);
                    }

                    adminMenu();
                    break;
                case 4:
                    if(AdministratorRepository.admins.isEmpty()){
                        System.out.println("There's no admins to delete.");
                        System.out.println();
                    }
                    else{
                        adminRepository.readAdmin();
                        System.out.println();
                        System.out.println("Enter the # of the admin to delete:");
                        int deleteIndex = scanner.nextInt();
                        scanner.nextLine();
                        deleteIndex--;
                        adminRepository.deleteAdmin(deleteIndex);
                    }

                    adminMenu();
                    break;
            }
        }while(option!=5);
    }
    public static void adminMenu(){
        System.out.println("*******************************");
        System.out.println("*          ADMIN MENU         *");
        System.out.println("*******************************");
        System.out.println("*       1.Create Admin        *");
        System.out.println("*       2.Read Admin          *");
        System.out.println("*       3.Update Admin        *");
        System.out.println("*       4.Delete Admin        *");
        System.out.println("*       5.Main Menu           *");
        System.out.println("*******************************");

        System.out.println("Enter your option:");
        do{
            option = scanner.nextInt();
            if (option<1||option>5){
                System.out.println("Enter a valid option:");
            }
        }while(option<1||option>5);
        System.out.println();
    }
}
