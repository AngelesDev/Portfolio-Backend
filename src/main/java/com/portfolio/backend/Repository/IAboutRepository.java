package com.portfolio.backend.Repository;

import com.portfolio.backend.Entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAboutRepository extends JpaRepository<About, Long> {
    
}