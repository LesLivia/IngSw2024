package msg.users;

public class AdminUser extends User {

    AdminUser(String u) {
        super(u);
        this.role = UserRole.ADMIN;
    }


}
