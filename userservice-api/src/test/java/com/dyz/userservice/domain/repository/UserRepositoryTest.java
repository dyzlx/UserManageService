package com.dyz.userservice.domain.repository;

import com.dyz.userservice.common.constant.ServiceConstant;
import com.dyz.userservice.domain.entity.User;
import com.dyz.userservice.domain.entity.UserRelation;
import com.dyz.userservice.domain.entity.UserRole;
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

    @Autowired
    private UserRelationRepository userRelationRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

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
                .build();
        //userRepository.save(user1);
        //userRepository.save(user2);
    }

    @Test
    public void queryUsersTest() throws ParseException {
        Date fromDate = DateUtils.parseDate("1996-03-13", ServiceConstant.DATE_FORMAT_SHORT);
        Date toDate = DateUtils.parseDate("9999-03-13", ServiceConstant.DATE_FORMAT_SHORT);
        List<User> users = userRepository.queryEnableUsers(null,null,null,null,fromDate,toDate);
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
        //userRepository.save(user);
    }

    @Test
    public void makefriendsTest() {
        UserRelation userRelation = UserRelation.builder().initiatorId(1).recipientId(2).createTime(new Date()).build();
        //userRelationRepository.save(userRelation);
    }

    @Test
    public void giveUserARoleTest() {
        UserRole userRole = UserRole.builder().userId(1).roleId(1).build();
        //userRoleRepository.save(userRole);
    }
}
