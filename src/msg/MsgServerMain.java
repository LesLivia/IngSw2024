package msg;

public class MsgServerMain {
    public static void main(String[] args) {
        Server msgServer = new Server("ingSw");

        msgServer.login();

        msgServer.startup();
    }
}