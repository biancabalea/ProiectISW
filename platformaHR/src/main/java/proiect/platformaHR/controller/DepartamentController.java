package proiect.platformaHR.controller;

import org.springframework.web.bind.annotation.*;
import proiect.platformaHR.entity.Departament;
import proiect.platformaHR.repository.DepartamentRepository;

import java.util.List;

@RestController
@RequestMapping("/departaments")
public class DepartamentController {
    private DepartamentRepository departamentRepository;

    public DepartamentController(DepartamentRepository departamentRepository) {
        this.departamentRepository = departamentRepository;
    }

    @GetMapping
    public List<Departament> getAllDepartements() {
        return departamentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Departament getDepartament (@PathVariable("id") Integer id) {
        return departamentRepository.findById(id).get();
    }

    @PostMapping
    public Departament createDepartament(@RequestBody Departament departament){
        return departamentRepository.save(departament);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartament(@PathVariable("id") Integer id) {
        departamentRepository.deleteById(id);
    }
}
