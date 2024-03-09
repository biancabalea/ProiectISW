package proiect.platformaHR.entity;

import jakarta.persistence.*;

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

}
