package proiect.platformaHR.entity;

import jakarta.persistence.*;

@Entity
@Table(name="post")
@SequenceGenerator(name="post_seq", initialValue = 4)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    @Column(name = "post_id")
    private Integer id;
    @Column(name="post_name")
    private String name;
}
