public class Comment {
    private String text;
    private User author;
    private Post post;

    public Comment(String text, User author, Post post) {
        this.text = text;
        this.author = author;
        this.post = post;
    }

    public void viewComment() {
        System.out.println("Author: " + author.username);
        System.out.println("Text: " + text);
    }
}
