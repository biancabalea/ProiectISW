package proiect.platformaHR.entity;

import jakarta.persistence.*;

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
}
