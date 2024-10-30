package msg;

import java.util.ArrayList;

public class Channel {
    private String name;
    private ArrayList<Post> posts;

    public Channel(String n) {
        this.name = n;
        this.posts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    // Differenza con lo spostare questo metodo nella classe User?
/*
    public void addPost(User u, String c) {
        this.getPosts().add(new Post(c, u));
    }
*/

    public void printPosts() {
        for (Post p : this.getPosts()) {
            System.out.println(p);
        }
    }

    @Override
    public String toString() {
        return "# " + this.getName();
    }
}
