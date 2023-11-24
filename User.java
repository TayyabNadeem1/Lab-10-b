import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String id;
    String username;
    private String email;
    private String profilePicture;
    private String bio;
    private List<Post> posts;
    private List<User> followers;
    private List<User> following;

    public User(String id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.posts = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public String getUsername() {
        return username;
    }

    public void createPost(String caption, String image) {
        Post post = new Post(caption, image, this);
        posts.add(post);
    }

    public void deletePost(Post post) {
        posts.remove(post);
    }

    public void followUser(User user) {
        following.add(user);
        user.followers.add(this);
    }

    public void unfollowUser(User user) {
        following.remove(user);
        user.followers.remove(this);
    }

    public void viewFeed() {
        for (User user : following) {
            for (Post post : user.posts) {
                post.viewPost();
            }
        }
    }

    public List<Post> getPosts() {
        return posts;
    }

     public void saveUserProfile() {
        try (PrintWriter writer = new PrintWriter(username + ".txt")) {
            writer.println("Username: " + username);
            writer.println("Email: " + email);
            writer.println("Posts:");
            for (Post post : posts) {
                writer.println("Image: " + post.getImage());
                writer.println("Caption: " + post.getCaption());
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User loadUserFromFile(String userId) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 && parts[0].equals(userId)) {
                    return new User(parts[0], parts[1], parts[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }
}