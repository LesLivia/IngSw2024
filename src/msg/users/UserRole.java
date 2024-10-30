package msg.users;

public enum UserRole {

    MEMBER("member"), ADMIN("admin"), SUPERADMIN("superadmin");

    private final String descriptor;

    UserRole(String d) {
        this.descriptor = d;
    }

    public String getDescriptor() {
        return descriptor;
    }

}
