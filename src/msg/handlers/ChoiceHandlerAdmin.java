package msg.handlers;

import msg.Channel;
import msg.MsgServerException;
import msg.Server;
import msg.users.User;
import msg.users.UserFactory;
import msg.users.UserRole;

public class ChoiceHandlerAdmin implements ChoiceHandler {

    @Override
    public String getUserMsg() {
        return "Allowed actions:\n" +
                "get members\t\t\tadd member [name]\t\t\t\tremove member [name]\n" +
                "get channels\t\tnew channel [name]\t\t\t\tdelete channel [name]\n" +
                "get posts [channel]\tnew post [channel] [content]\n" +
                "switch account\n" +
                "quit";
    }

    public void handleChoice(Server server, String choice) throws MsgServerException {
        if (choice.toLowerCase().contains("new channel")) {
            String[] fields = choice.split(" ");
            if (fields.length < 3) throw new MsgServerException("Channel name is missing.");

            String newChannelName = fields[2];
            server.addChannel(newChannelName);
        } else if (choice.equalsIgnoreCase("get channels")) {
            for (Channel c : server.getChannels())
                System.out.println(c);
        } else if (choice.toLowerCase().contains("delete channel")) {
            String[] fields = choice.split(" ");
            if (fields.length < 3) throw new MsgServerException("Channel name is missing.");

            String toDelete = fields[2];
            server.deleteChannel(toDelete);
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
        } else if (choice.equalsIgnoreCase("get members")) {
            for (User u : server.getMembers())
                System.out.println(u);
        } else if (choice.toLowerCase().contains("add member")) {
            String[] fields = choice.split(" ");
            if (fields.length < 3) throw new MsgServerException("Username is missing.");

            server.addMember(UserFactory.getUser(UserRole.MEMBER.getDescriptor(), fields[2], false));
        } else if (choice.toLowerCase().contains("remove member")) {
            String[] fields = choice.split(" ");
            if (fields.length < 3) throw new MsgServerException("User name is missing.");

            // Perchè la seguente istruzione non avrebbe l'effetto desiderato?
            // server.removeMember(new User(fields[2]));

            if (server.lookupMember(fields[2]) != null)
                server.removeMember(server.lookupMember(fields[2]));
        } else if (choice.equalsIgnoreCase("switch account")) server.login();
    }

}
