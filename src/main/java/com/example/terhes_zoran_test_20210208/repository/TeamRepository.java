package com.example.terhes_zoran_test_20210208.repository;

import com.example.terhes_zoran_test_20210208.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
}
