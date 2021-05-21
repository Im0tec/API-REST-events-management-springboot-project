package com.semester5.ac1.pooii.ac1_190309.repositories;

import java.util.List;

import com.semester5.ac1.pooii.ac1_190309.entities.Attend;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendRepository extends JpaRepository<Attend, Long>{
    
    List<Attend> findByBalance(Double balance);

    @Query("SELECT at FROM Attend at " +
            "WHERE " +
            "( at.balance = :balance ) ")
    public Page<Attend> findAttendeesBalancePageable(Pageable pageRequest, Double balance);
    
    @Query("SELECT at FROM Attend at ")
    public Page<Attend> findAttendeesPageable(Pageable pageRequest);
}
