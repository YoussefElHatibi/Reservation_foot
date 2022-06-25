package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.models.Secteur;
import com.bezkoder.springjwt.repository.SecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecteurService {
    @Autowired
    SecteurRepository secteurRepository;

    public Secteur getById(Long id){
        return secteurRepository.findById(id).get();
    }

    public Secteur create(Secteur secteur){
        return secteurRepository.save(secteur);
    }

    public Secteur update(Secteur updatedSecteur){
        return secteurRepository.save(updatedSecteur);
    }

    public List<Secteur> getAll(){
        return secteurRepository.findAll();
    }

    public void deleteById(Long id){
        secteurRepository.deleteById(id);
    }
}
