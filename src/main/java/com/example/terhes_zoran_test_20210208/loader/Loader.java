package com.example.terhes_zoran_test_20210208.loader;

import com.example.terhes_zoran_test_20210208.entity.Kind;
import com.example.terhes_zoran_test_20210208.entity.Team;
import com.example.terhes_zoran_test_20210208.entity.Universe;

public class Loader {
    Team team1;
    Team team2;

    public Loader() {
        this.team1.setName("Team1");
        this.team1.setKind(Kind.HERO);
        this.team1.setUniverse(Universe.DC);
        this.team2.setName("Team2");
        this.team2.setKind(Kind.VILLAIN);
        this.team2.setUniverse(Universe.MARVEL);
    }
}
