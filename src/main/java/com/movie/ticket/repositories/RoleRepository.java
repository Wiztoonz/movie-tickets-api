package com.movie.ticket.repositories;

import com.movie.ticket.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select r from roles r where r.roleName = :roleName")
    Role findRole(String roleName);

}
