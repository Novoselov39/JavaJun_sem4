package ru.gb.lesson4.hw;


import jakarta.persistence.*;


// * 2. PostComment (комментарий к публикации) (id, text, post_id)
@Entity
@Table(name="PostComment")
public class PostComment {

    @Id
    @Column(name="id")
    public Long id;

    @Column(name="text")
    public String text;

    @ManyToOne

    @JoinTable(name = "post_id" )
    public Post post;

    public PostComment()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", post=" + post +
                '}';
    }
}
