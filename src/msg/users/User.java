package msg.users;

import msg.Channel;
import msg.Post;

public class User {

    private String username;
    protected UserRole role;

    User(String u) {
        this.username = u;
        this.role = UserRole.MEMBER;
    }

    public String getUsername() {
        return username;
    }

    public UserRole getRole() {
        return role;
    }

    public void writePost(Channel c, String s) {
        c.getPosts().add(new Post(s, this));
    }

    @Override
    public String toString() {
        return this.getUsername() + " (" + this.getRole().getDescriptor() + ")";
    }

}
