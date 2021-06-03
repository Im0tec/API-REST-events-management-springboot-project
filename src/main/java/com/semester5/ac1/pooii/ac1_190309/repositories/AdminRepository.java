/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.repositories;

import java.util.List;
import java.util.Optional;

import com.semester5.ac1.pooii.ac1_190309.entities.Admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository <Admin, Long>{
    
    Object findByEmail = null;

    List<Admin> findByPhoneNumber(String phoneNumber);

    @Query("SELECT ad FROM Admin ad " +
            "WHERE " +
            " ( LOWER(ad.phoneNumber)          LIKE     LOWER(CONCAT('%', :phone, '%')))")
    public Page<Admin> findAdminsPageable(Pageable pageRequest, String phone);

    Optional<Admin> findByEmail(String email);
}
