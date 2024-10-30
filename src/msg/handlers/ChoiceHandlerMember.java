package msg.handlers;

import msg.Channel;
import msg.MsgServerException;
import msg.Server;

public class ChoiceHandlerMember implements ChoiceHandler {

    @Override
    public String getUserMsg() {
        return "Allowed actions:\n" +
                "get members\n" +
                "get channels\n" +
                "get posts [channel]\tnew post [channel] [content]\n" +
                "switch account\n" +
                "quit";
    }

    public void handleChoice(Server server, String choice) throws MsgServerException {
        if (choice.equalsIgnoreCase("get channels")) {
            for (Channel c : server.getChannels())
                System.out.println(c);
        } else if (choice.toLowerCase().contains("new post")) {
            String[] fields = choice.split(" ");
            if (fields.length < 4) throw new MsgServerException("Channel name and/or post content missing.");


            StringBuilder content = new StringBuilder();
            int i;
            for (i = 0; i < fields.length; i++)
                if (i > 2)
                    content.append(" ").append(fields[i]);

            Channel ch = server.lookupChannel(fields[2]);
            if (ch != null)
                server.getLoggedUser().writePost(ch, content.toString());
        } else if (choice.toLowerCase().contains("get posts")) {
            String[] fields = choice.split(" ");
            if (fields.length < 3) throw new MsgServerException("Channel name missing.");

            String channel = fields[2];
            for (Channel c : server.getChannels())
                if (c.getName().equals(channel))
                    c.printPosts();
        } else if (choice.equalsIgnoreCase("switch account")) server.login();
    }

}
