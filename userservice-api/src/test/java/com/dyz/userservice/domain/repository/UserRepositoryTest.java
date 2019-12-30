package com.dyz.userservice.domain.repository;

import com.dyz.userservice.domain.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUserTest() {
        User user = User.builder()
                .birthday(new Date())
                .emailAddress("13212068907@163.com")
                .enable(true)
                .gender("man")
                .nickName("Small Strong")
                .password("658080")
                .phoneNumber("13212068907")
                .registerTime(new Date())
                .roleId(1)
                .build();
        //userRepository.save(user);
    }
}
