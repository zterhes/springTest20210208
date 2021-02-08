package com.example.terhes_zoran_test_20210208.controller;

import com.example.terhes_zoran_test_20210208.Exception.ValidationException;
import com.example.terhes_zoran_test_20210208.entity.SuperHero;
import com.example.terhes_zoran_test_20210208.entity.Team;
import com.example.terhes_zoran_test_20210208.service.SuperHeroService;
import com.example.terhes_zoran_test_20210208.service.TeamService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/super-hero")
public class SuperHeroController {
    SuperHeroService superHeroService;

    @Autowired
    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }


    @PostMapping()
    public SuperHero create(@RequestBody SuperHero superHero) {
        try {
            return superHeroService.create(superHero);
        } catch (ValidationException e) {
            throw new ResponseStatusException(e.getHttpStatus(),e.getMessage());
        }
    }

    @PutMapping()
    public SuperHero update(@RequestBody SuperHero superHero) {
        try {
            return superHeroService.update(superHero);
        } catch (ValidationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping()
    public List<SuperHero> getAll(){
        return superHeroService.getAll();
    }

    @GetMapping("/{id}")
    public SuperHero getById(@PathVariable(value = "id")String id){
        try {
            return superHeroService.getById(id);
        } catch (ValidationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }
}
