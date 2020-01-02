package com.dyz.userservice.domain.repository;

import com.dyz.userservice.domain.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    List<UserRole> queryUserRolesByUserId(Integer userId);
}
