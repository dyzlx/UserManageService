package com.dyz.userservice.domain.repository;

import com.dyz.userservice.common.constant.ServiceConstant;
import com.dyz.userservice.domain.entity.User;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUserTest() {
        User user1 = User.builder()
                .birthday(new Date())
                .emailAddress("1319123861@qq.com")
                .enable(true)
                .available(true)
                .gender("woman")
                .nickName("Lx")
                .password("123456")
                .phoneNumber("15332093083")
                .registerTime(new Date())
                .roleId(1)
                .build();
        User user2 = User.builder()
                .birthday(new Date())
                .emailAddress("13212068907@163.com")
                .enable(true)
                .available(true)
                .gender("man")
                .nickName("Yun")
                .password("123456")
                .phoneNumber("15010389831")
                .registerTime(new Date())
                .roleId(1)
                .build();
        //userRepository.save(user1);
        //userRepository.save(user2);
    }

    @Test
    public void queryUsersTest() throws ParseException {
        Date fromDate = DateUtils.parseDate("1996-03-13", ServiceConstant.DATE_FORMAT_SHORT);
        Date toDate = DateUtils.parseDate("9999-03-13", ServiceConstant.DATE_FORMAT_SHORT);
        List<User> users = userRepository.queryUsers(null,null,null,null,fromDate,toDate);
        System.out.println(users);
    }

    @Test
    public void queryUserTest(){
        User user = userRepository.getEnableUserById(1);
        System.out.println(user);
    }

    @Test
    public void unableUserTest() {
        User user = userRepository.getUserById(1);
        user.setEnable(true);
        userRepository.save(user);
    }
}
