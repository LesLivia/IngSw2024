package msg;

import msg.handlers.ChoiceHandlerStrategy;
import msg.users.User;
import msg.users.UserFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    private String name;
    private ArrayList<User> members;
    private ArrayList<Channel> channels;
    private User loggedUser;

    public Server(String n) {
        this.name = n;
        this.members = new ArrayList<>();
        this.channels = new ArrayList<>();
        this.loggedUser = null;
    }

    public String getName() {
        return name;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public User lookupMember(String name) {
        for (User u : this.getMembers())
            if (u.getUsername().equalsIgnoreCase(name)) return u;
        return null;
    }

    public void addMember(User u) {
        for (User u2 : this.getMembers())
            if (u2.getUsername().equalsIgnoreCase(u.getUsername())) return;

        this.getMembers().add(u);
    }

    public void updateMember(User oldU, User newU) {
        int i;
        for (i = 0; i < this.getMembers().size(); i++)
            if (this.getMembers().get(i).getUsername().equalsIgnoreCase(oldU.getUsername())) {
                this.getMembers().set(i, newU);
                return;
            }
    }

    public void removeMember(User u) {
        this.getMembers().remove(u);
    }

    public ArrayList<Channel> getChannels() {
        return channels;
    }

    public Channel lookupChannel(String name) {
        for (Channel ch : this.getChannels())
            if (ch.getName().equals(name)) return ch;
        return null;
    }

    public void addChannel(String name) {
        for (Channel c : this.getChannels()) {
            // non ammettiamo più di un canale con lo stesso nome (se trova un canale già esistente
            // col nome specificato, l'invocazione del metodo non ha effetto)
            if (c.getName().equals(name)) return;
        }
        this.channels.add(new Channel(name));
    }

    public void deleteChannel(String name) {
        for (Channel c : this.getChannels()) {
            if (c.getName().equals(name)) {
                this.getChannels().remove(c);
                return;
            }
        }
    }

    public void login() {
        Scanner in = new Scanner(System.in);

        System.out.print("username: ");

        String enteredUser = in.nextLine();

        System.out.print("role: ");
        // TODO: come possiamo evitare che l'utente inserisca un ruolo arbitrario?
        String enteredRole = in.nextLine();

        this.loggedUser = UserFactory.getUser(enteredRole, enteredUser, true);

        // TODO: facendo così, se si fa il login con lo stesso utente più di una volta,
        // TODO: viene duplicato nella lista members: come si potrebbe risolvere?
        this.addMember(this.loggedUser);
    }

    public void startup() {
        System.out.println(this.getName() + " starting up...");

        Scanner in = new Scanner(System.in);
        String choice;

        do {
            System.out.print(">> ");
            choice = in.nextLine();
            try {
                ChoiceHandlerStrategy.handleChoice(this, choice);
            } catch (MsgServerException e) {
                System.out.println(e.getMessage());
            }
        } while (!choice.equalsIgnoreCase("quit"));

        System.out.println(this.getName() + " stopped.");
    }


}
