package com.example.terhes_zoran_test_20210208.service;

import com.example.terhes_zoran_test_20210208.Exception.ValidationException;
import com.example.terhes_zoran_test_20210208.entity.Team;
import com.example.terhes_zoran_test_20210208.repository.TeamRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team create(Team team) throws ValidationException {
        if(team.getName().equals("")|| team.getName() == null || team.getKind() == null || team.getUniverse() == null){
            throw new ValidationException("Bad Input");
        }
        return teamRepository.save(team);
    }

    public Team update(Team team) throws ValidationException {
        if(team.getName().equals("")|| team.getName() == null || team.getKind() == null || team.getUniverse() == null){
            throw new ValidationException("Bad Input");
        }
        Optional<Team> updateable = teamRepository.findById(team.getId());
        if (updateable.isEmpty()) throw new ValidationException("Id not found");
        Team oldEntity = updateable.get();
        oldEntity.setKind(team.getKind());
        oldEntity.setName(team.getName());
        oldEntity.setUniverse(team.getUniverse());
        return teamRepository.save(oldEntity);
    }

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Team getById(String id) throws ValidationException {
        Optional<Team> result = teamRepository.findById(id);
        if(result.isEmpty())throw new ValidationException("Id not found");
        return result.get();
    }
}
