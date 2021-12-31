package com.movie.ticket.services.impls;

import com.movie.ticket.entities.Role;
import com.movie.ticket.entities.User;
import com.movie.ticket.repositories.UserRepository;
import com.movie.ticket.services.RoleService;
import com.movie.ticket.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleService.findRole("USER");
        User saveUser = userRepository.save(user);
        saveUser.addRole(role);
        return saveUser;
    }

}
