package com.semester5.ac1.pooii.ac1_190309.repositories;

import com.semester5.ac1.pooii.ac1_190309.entities.BaseUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseUserRepository extends JpaRepository<BaseUser, Long>{
    
}
