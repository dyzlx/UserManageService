package com.dyz.userservice.domain.repository;

import com.dyz.userservice.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role queryById(Integer id);

    Role queryByName(String name);

    @Query(value = "select * from role where if(?1 is NULL,1=1,id=?1)"
            + " and if(?2 is NULL,1=1,name like %?2%)", nativeQuery = true)
    List<Role> queryRoleInfo(Integer id, String name);

}
