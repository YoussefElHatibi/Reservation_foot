package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Secteur;
import com.bezkoder.springjwt.service.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/secteur")
public class SecteurController {
    @Autowired
    SecteurService secteurService;

    @GetMapping("/all")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Secteur> getAll(){
        return secteurService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Secteur getById(@PathVariable Long id){
        return secteurService.getById(id);
    }

    @PostMapping("/add")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Secteur create(@RequestBody Secteur secteur){
        return secteurService.create(secteur);
    }

    @PutMapping("/update")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Secteur updateById(@RequestBody Secteur updatedSecteur){
        return secteurService.update(updatedSecteur);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable  Long id){
        secteurService.deleteById(id);
    }
}
