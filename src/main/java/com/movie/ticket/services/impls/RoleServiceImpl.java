package com.movie.ticket.services.impls;

import com.movie.ticket.entities.Role;
import com.movie.ticket.repositories.RoleRepository;
import com.movie.ticket.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRole(String roleName) {
        return roleRepository.findRole(roleName);
    }

}
