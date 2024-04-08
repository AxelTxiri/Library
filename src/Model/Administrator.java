package Model;

import java.security.Permission;
import java.util.ArrayList;
enum Permissions {
    READ, UPDATE, DELETE
}

public class Administrator extends User {
    ArrayList<Permission> permissions;
    boolean isSuperAdmin;

    public Administrator() {
    }
    public Administrator(Profile profile, String username, String password,ArrayList<Permission> permissions,
                         boolean isSuperAdmin) {
        super(profile, username, password);
        this.permissions = permissions;
        this.isSuperAdmin = isSuperAdmin;
    }

    public ArrayList<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<Permission> permissions) {
        this.permissions = permissions;
    }

    public boolean isSuperAdmin() {
        return isSuperAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        isSuperAdmin = superAdmin;
    }
}
