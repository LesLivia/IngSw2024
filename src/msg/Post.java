package msg;

import msg.users.User;

public class Post {
    private String content;
    private User author;

    public Post(String c, User a) {
        this.content = c;
        this.author = a;
    }

    public String getContent() {
        return content;
    }


    public User getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return this.getAuthor().getUsername() + ": " + this.getContent();
    }
}
