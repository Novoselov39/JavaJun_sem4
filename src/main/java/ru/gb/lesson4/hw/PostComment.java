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

//    @ManyToOne
    @Column(name="post_id")
//    @JoinColumn(name="id")
    public Long post_id;

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

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", post_id=" + post_id +
                '}';
    }
}
