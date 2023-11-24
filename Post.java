import java.util.ArrayList;
import java.util.List;

public class Post {
    private String caption;
    private String image;
    private User author;
    private List<Comment> comments;
    private List<User> likes;

    public Post(String caption, String image, User author) {
        this.caption = caption;
        this.image = image;
        this.author = author;
        this.comments = new ArrayList<>();
        this.likes = new ArrayList<>();
    }

    public void viewPost() {
        System.out.println("Author: " + author.username);
        System.out.println("Caption: " + caption);
        System.out.println("Image: " + image);
        System.out.println("Likes: " + likes.size());
        System.out.println("Comments:");
        for (Comment comment : comments) {
            comment.viewComment();
        }
    }

    public String getCaption() {
        return caption;
    }

    public void addComment(User user, String text) {
        Comment comment = new Comment(text, user, this);
        comments.add(comment);
    }

    public void addLike(User user) {
        likes.add(user);
    }
    

    public void removeLike(User user) {
        likes.remove(user);
    }

    public String getImage() {
        return this.image;
    }

}
