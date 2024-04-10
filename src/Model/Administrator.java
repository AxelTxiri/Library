package Model;

import java.util.ArrayList;

public class Administrator extends User {
    ArrayList<Permissions> permissions;
    boolean isSuperAdmin;

    public Administrator() {
    }

    public Administrator(Profile profile, String username, String password, ArrayList<Permissions> permissions, boolean isSuperAdmin) {
        super(profile, username, password);
        this.permissions = permissions;
        this.isSuperAdmin = isSuperAdmin;
    }

    public ArrayList<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<Permissions> permissions) {
        this.permissions = permissions;
    }

    public boolean isSuperAdmin() {
        return isSuperAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        isSuperAdmin = superAdmin;
    }
}
