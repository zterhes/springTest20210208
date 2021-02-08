package com.example.terhes_zoran_test_20210208.controller;

import com.example.terhes_zoran_test_20210208.Exception.ValidationException;
import com.example.terhes_zoran_test_20210208.entity.Team;
import com.example.terhes_zoran_test_20210208.service.TeamService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @PostMapping()
    public Team create(@RequestBody Team team) {
        try {
            return teamService.create(team);
        } catch (ValidationException e) {
            throw new ResponseStatusException(e.getHttpStatus(),e.getMessage());
        }
    }

    @PutMapping()
    public Team update(@RequestBody Team team) {
        try {
            return teamService.update(team);
        } catch (ValidationException e) {
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }

    @GetMapping()
    public List<Team> getAll(){
        return teamService.getAll();
    }

    @GetMapping("/{id}")
    public Team getById(@PathVariable(value = "id")String id){
        try {
            return teamService.getById(id);
        } catch (ValidationException e) {
            throw new ResponseStatusException(e.getHttpStatus(),e.getMessage());
        }
    }
}
