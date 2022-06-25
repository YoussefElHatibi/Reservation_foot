package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.models.Terrain;
import com.bezkoder.springjwt.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerrainService {
    @Autowired
    TerrainRepository terrainRepository;

    public Terrain getById(Long id){
        return terrainRepository.findById(id).get();
    }

    public Terrain create(Terrain terrain){
        return terrainRepository.save(terrain);
    }

    public Terrain update(Terrain updatedTerrain){
        return terrainRepository.save(updatedTerrain);
    }

    public List<Terrain> getAll(){
        return terrainRepository.findAll();
    }

    public void deleteById(Long id){
        terrainRepository.deleteById(id);
    }
}
