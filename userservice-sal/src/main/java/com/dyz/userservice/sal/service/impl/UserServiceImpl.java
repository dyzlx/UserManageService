package com.dyz.userservice.sal.service.impl;

import com.dyz.userservice.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;
}
