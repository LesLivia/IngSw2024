package msg.users;

public class SuperAdminUser extends AdminUser {
    public static SuperAdminUser superadmin;

    private SuperAdminUser(String u) {
        super(u);
        this.role = UserRole.SUPERADMIN;
    }

    public static SuperAdminUser getInstance(String n) {
        if (superadmin == null) superadmin = new SuperAdminUser(n);
        return superadmin;
    }

}
