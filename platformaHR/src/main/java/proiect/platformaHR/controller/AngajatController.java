package proiect.platformaHR.controller;

import org.springframework.web.bind.annotation.*;
import proiect.platformaHR.entity.Angajat;
import proiect.platformaHR.repository.AngajatRepository;

import java.util.List;

@RestController
@RequestMapping("angajats")
public class AngajatController {

    public AngajatRepository angajatRepository;

    public AngajatController(AngajatRepository angajatRepository) {
        this.angajatRepository = angajatRepository;
    }
    @GetMapping
    public List<Angajat> getAllAngajats() {
       return  angajatRepository.findAll();
    }
    @GetMapping("/{id}")
    public Angajat getAngajat(@PathVariable("id") Integer id){
        return angajatRepository.findById(id).get();
    }
    @PostMapping
    public Angajat createAngajat(@RequestBody Angajat angajat){
        return angajatRepository.save(angajat);
    }

    @PutMapping("/{id}")
    public Angajat updateAngajat(@PathVariable("id") Integer id, @RequestBody Angajat angajat) {
        angajat.setId(id);
        return angajatRepository.save(angajat);
    }

    @PatchMapping("/{id}")
    public Angajat updatePatchAngajat(@PathVariable("id") Integer id, @RequestBody Angajat angajat) {
        Angajat modifiedAngajat = angajatRepository.findById(id).get();
        if(angajat.getName() != null) {
            modifiedAngajat.setName(angajat.getName());
        }
        if(angajat.isFulltime()) {
            modifiedAngajat.setFulltime(angajat.isFulltime());
        }
        if(angajat.getSalariu() != null){
            modifiedAngajat.setSalariu(angajat.getSalariu());
        }
        return angajatRepository.save(modifiedAngajat);
    }

    @DeleteMapping("/{id}")
    public void deleteAngajat(@PathVariable("id") Integer id) {
        angajatRepository.deleteById(id);
    }


}
