import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("1", "user1", "user1@gmail.com");
        User user2 = new User("2", "user2", "user2@gmail.com");

        user1.createPost("My first post", "image1.jpg");
        user1.createPost("My second post", "image2.jpg");
        user2.createPost("another user post", "image3.jpg");

        user1.followUser(user2);

        user1.viewFeed();
        user1.loadUserFromFile("1");
        List<Post> user1Posts = user1.getPosts();  
        String user1Username = user1.getUsername();

    }

}
