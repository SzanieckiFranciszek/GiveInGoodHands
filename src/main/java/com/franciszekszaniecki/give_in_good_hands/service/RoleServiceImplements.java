package com.franciszekszaniecki.give_in_good_hands.service;

import com.franciszekszaniecki.give_in_good_hands.model.Role;
import com.franciszekszaniecki.give_in_good_hands.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImplements implements RoleService {
    private  final RoleRepository roleRepository;

    public RoleServiceImplements(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }
}
