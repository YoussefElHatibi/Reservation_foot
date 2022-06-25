package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Terrain;
import com.bezkoder.springjwt.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/terrain")
public class TerrainController {
    @Autowired
    TerrainService terrainService;

    @GetMapping("/all")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Terrain> getAll(){
        return terrainService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Terrain getById(@PathVariable Long id){
        return terrainService.getById(id);
    }

    @PostMapping("/add")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Terrain create(@RequestBody Terrain terrain){
        return terrainService.create(terrain);
    }

    @PutMapping("/update")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Terrain updateById(@RequestBody Terrain updatedTerrain){
        return terrainService.update(updatedTerrain);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable  Long id){
        terrainService.deleteById(id);
    }
}
