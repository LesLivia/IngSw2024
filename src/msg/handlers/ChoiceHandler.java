package msg.handlers;

import msg.MsgServerException;
import msg.Server;

public interface ChoiceHandler {

    String getUserMsg();

    void handleChoice(Server server, String choice) throws MsgServerException;

}
