package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain,Long> {
}
