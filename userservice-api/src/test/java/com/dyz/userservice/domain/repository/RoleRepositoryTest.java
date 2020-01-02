package com.dyz.userservice.domain.repository;

import com.dyz.userservice.domain.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void addRoleTest() {
        Role roleAdmin = Role.builder().name("ADMIN").build();
        Role roleReadUser = Role.builder().name("READ_USER").build();
        Role roleSuperUser = Role.builder().name("SUPER_USER").build();
        //roleRepository.saveAll(new ArrayList<>(Arrays.asList(roleAdmin, roleReadUser, roleSuperUser)));
    }
}
