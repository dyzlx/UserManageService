package com.dyz.userservice.domain.repository;


import com.dyz.userservice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where if(?1 is NULL,1=1,id=?1)"
            + " and if(?2 is NULL,1=1,email_address=?2)"
            + " and if(?3 is NULL,1=1,phone_number=?3)"
            + " and if(?4 is NULL,1=1,nick_name like %?4%)"
            + " and register_time between ?5 and ?6", nativeQuery = true)
    List<User> queryUsers(Integer id, String emailAddress, String phoneNumber, String nickName,
                                Date fromRegisterTime, Date toRegisterTime);

    @Query(value = "select * from user where id=?1 and enable='Y'", nativeQuery = true)
    User getEnableUserById(Integer id);

    User getUserById(Integer id);
}
