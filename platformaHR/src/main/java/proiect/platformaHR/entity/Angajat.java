package proiect.platformaHR.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="angajat")
@SequenceGenerator(name="angajat_seq", initialValue = 4)
public class Angajat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "angajat_seq")
    @Column(name = "angajat_id")
    private Integer id;
    @Column(name="angajat_name")
    private String name;
    @Column(name="angajat_fulltime")
    private boolean fulltime;
    @Column(name="angajat_salariu")
    private Integer salariu;
    @Column(name="angajat_zile_co")
    private Integer zileco;
    @ManyToMany
    @JoinTable(name = "enrolment",
               joinColumns = {@JoinColumn(name="angajat_id")},
               inverseJoinColumns ={@JoinColumn(name = "post_id")})
    private List<Post> postList = new ArrayList<>();

    public Angajat() {
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

    public boolean isFulltime() {
        return fulltime;
    }

    public void setFulltime(boolean fulltime) {
        this.fulltime = fulltime;
    }

    public Integer getSalariu() {
        return salariu;
    }

    public void setSalariu(Integer salariu) {
        this.salariu = salariu;
    }

    public Integer getZileco() {
        return zileco;
    }

    public void setZileco(Integer zileco) {
        this.zileco = zileco;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
