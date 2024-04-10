package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AdministratorRepository {
    public static ArrayList<Administrator> admins = new ArrayList<>();
    public void createAdmin(Profile profile, String username, String password, ArrayList<Permissions> permissions, boolean isSuperAdmin) {
        Administrator admin = new Administrator(profile,username,password, permissions, isSuperAdmin);
        admins.add(admin);
        System.out.println("Admin successfully created.");
    }

    public void readAdmin() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
        System.out.printf("%-5s %-10s %-15s %-15s %-10s\n","#","Name","Last Name","Birthdate","Books Title");
        int adminId=0;
        for(Administrator admin : admins){
            adminId++;
            System.out.printf("%-5s %-10s %-15s %-15s %-10s"
                    ,adminId,admin.getProfile().getName(),admin.getProfile().getLastName()
                    ,dateFormat.format(admin.getProfile().getBirthdate()),"Permissions:");
            for (Permissions permission : admin.getPermissions()) {
                System.out.print(permission + " ");
            }
            System.out.println();
        }
    }

    public void updateAdmin(int index, Profile profile, String username, String password, ArrayList<Permissions> permissions, boolean isSuperAdmin) {
        Administrator admin = new Administrator(profile,username,password, permissions, isSuperAdmin);
        admins.set(index, admin);
        System.out.println("Admin successfully updated.");
    }

    public void deleteAdmin(int deleteIndex) {
        if(!admins.isEmpty()){
            System.out.println("There is no admins to delete.");
        }
        admins.remove(deleteIndex);
        System.out.println("Successfully deleted.");
    }
}
