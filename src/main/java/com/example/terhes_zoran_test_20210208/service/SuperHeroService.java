package com.example.terhes_zoran_test_20210208.service;

import com.example.terhes_zoran_test_20210208.Exception.ValidationException;
import com.example.terhes_zoran_test_20210208.entity.Kind;
import com.example.terhes_zoran_test_20210208.entity.SuperHero;
import com.example.terhes_zoran_test_20210208.repository.SuperHeroRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperHeroService {

    SuperHeroRepository superHeroRepository;

    @Autowired
    public SuperHeroService(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }

    SuperHeroRepository superheroRepository;


    public SuperHero create(SuperHero superhero) throws ValidationException {
        if (superhero.getName().equals("") || superhero.getName() == null || superhero.getUniverse() == null) {
            throw new ValidationException("Bad Input");
        }
        if (!superhero.getUniverse().equals(superhero.getTeam().getUniverse())) {
            throw new ValidationException("Bad universe");
        }
        if (superhero.getHero() && superhero.getTeam().getKind() == Kind.HERO || !superhero.getHero() && superhero.getTeam().getKind() == Kind.VILLAIN) {
            throw new ValidationException("Bad Input");
        }
        return superheroRepository.save(superhero);
    }

    public SuperHero update(SuperHero superhero) throws ValidationException {
        Optional<SuperHero> updatable = superheroRepository.findById(superhero.getId());
        if (updatable.isEmpty()) throw new ValidationException("Id not found");
        SuperHero oldEntity = updatable.get();
        oldEntity.setHero(superhero.getHero());
        oldEntity.setName(superhero.getName());
        oldEntity.setTeam(superhero.getTeam());
        oldEntity.setUniverse(superhero.getUniverse());
        return superheroRepository.save(oldEntity);
    }

    public List<SuperHero> getAll() {
        return superheroRepository.findAll();
    }

    public SuperHero getById(String id) throws ValidationException {
        Optional<SuperHero> result = superheroRepository.findById(id);
        if (result.isEmpty()) throw new ValidationException("Id not found");
        return result.get();
    }
}
