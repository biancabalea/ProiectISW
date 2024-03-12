package proiect.platformaHR.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proiect.platformaHR.entity.Departament;
import proiect.platformaHR.service.DepartamentService;
import java.util.List;

@RestController
@RequestMapping("/departaments")
public class DepartamentController {

    private DepartamentService departamentService;

    public DepartamentController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    @GetMapping
    public List<Departament> getAllDepartements() {
        return departamentService.getAllDepartements();
    }

    @GetMapping("/{id}")
    public Departament getDepartament (@PathVariable("id") Integer id) {
        return departamentService.getDepartament(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Departament createDepartament(@RequestBody Departament departament){
        return departamentService.createDepartament(departament);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteDepartament(@PathVariable("id") Integer id) {
        departamentService.deleteDepartament(id);
    }
}
