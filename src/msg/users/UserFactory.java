package msg.users;

import msg.handlers.ChoiceHandlerStrategy;

public class UserFactory {

    public static User getUser(String role, String user, Boolean loggingIn) {
        if (role.equalsIgnoreCase(UserRole.MEMBER.getDescriptor())) {
            if (loggingIn) ChoiceHandlerStrategy.setStrategy(UserRole.MEMBER);
            return new User(user);
        } else if (role.equalsIgnoreCase(UserRole.ADMIN.getDescriptor())) {
            if (loggingIn) ChoiceHandlerStrategy.setStrategy(UserRole.ADMIN);
            return new AdminUser(user);
        } else {
            if (loggingIn) ChoiceHandlerStrategy.setStrategy(UserRole.SUPERADMIN);
            return SuperAdminUser.getInstance(user);
        }
    }

}
