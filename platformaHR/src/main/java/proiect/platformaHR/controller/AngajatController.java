package proiect.platformaHR.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proiect.platformaHR.entity.Angajat;
import proiect.platformaHR.repository.AngajatRepository;
import proiect.platformaHR.service.AngajatService;

import java.util.List;

@RestController
@RequestMapping("angajats")
public class AngajatController {

    private AngajatService angajatService;

    public AngajatController(AngajatService angajatService) {
        this.angajatService = angajatService;
    }

    @GetMapping
    public List<Angajat> getAllAngajats() {
       return angajatService.getAllAngajats();
    }
    @GetMapping("/{id}")
    public Angajat getAngajat(@PathVariable("id") Integer id){
        return angajatService.getAngajat(id);
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Angajat createAngajat(@RequestBody Angajat angajat){
        return angajatService.createAngajat(angajat);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Angajat updateAngajat(@PathVariable("id") Integer id, @RequestBody Angajat angajat) {
        return angajatService.updateAngajat(id, angajat);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Angajat updatePatchAngajat(@PathVariable("id") Integer id, @RequestBody Angajat angajat) {
        return angajatService.updatePatchAngajat(id, angajat);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteAngajat(@PathVariable("id") Integer id) {
        angajatService.deleteAngajat(id);
    }

}
