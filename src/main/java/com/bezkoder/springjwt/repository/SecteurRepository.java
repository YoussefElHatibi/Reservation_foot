package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur,Long> {
}
