package msg.handlers;

import msg.MsgServerException;
import msg.Server;
import msg.users.UserRole;

public class ChoiceHandlerStrategy {

    private static ChoiceHandler strategy;
    private static UserRole cachedRole;

    public static void setStrategy(UserRole role) {
        if (role.equals(UserRole.MEMBER)) strategy = new ChoiceHandlerMember();
        else if (role.equals(UserRole.ADMIN)) strategy = new ChoiceHandlerAdmin();
        else strategy = new ChoiceHandlerSuperadmin();

        if (cachedRole == null || !cachedRole.equals(role)) System.out.println(strategy.getUserMsg());
        cachedRole = role;
    }

    public static void handleChoice(Server server, String choice) throws MsgServerException {
        strategy.handleChoice(server, choice);
    }

}
