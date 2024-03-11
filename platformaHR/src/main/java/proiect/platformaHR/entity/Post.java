package proiect.platformaHR.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_dept_id", referencedColumnName = "dept_id")
    private Departament departament;

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }
}
