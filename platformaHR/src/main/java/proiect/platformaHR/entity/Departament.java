package proiect.platformaHR.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departament")
@SequenceGenerator(name="dept_seq", initialValue = 4)
public class Departament {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
    @Column(name="dept_id")
    private Integer id;
    @Column(name="dept_name")
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "departament", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();

    public Departament() {
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

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
