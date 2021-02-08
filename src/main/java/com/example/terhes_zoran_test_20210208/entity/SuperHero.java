package com.example.terhes_zoran_test_20210208.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SuperHero {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;

    String name;

    Universe universe;

    Team team;

    Boolean hero;

    protected SuperHero(){}; //valamiért nem kezeli a lombok a noargsconstrucor-t

    public SuperHero(String name, Universe universe, Team team, Boolean hero) {
        this.name = name;
        this.universe = universe;
        this.team = team;
        this.hero = hero;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", universe=" + universe +
                ", team=" + team +
                ", hero=" + hero +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Universe getUniverse() {
        return universe;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Boolean getHero() {
        return hero;
    }

    public void setHero(Boolean hero) {
        this.hero = hero;
    }
}
