package com.dyz.userservice.sal.service.impl;

import com.dyz.userservice.common.exception.IllegalParamException;
import com.dyz.userservice.common.exception.NoDataException;
import com.dyz.userservice.domain.entity.Role;
import com.dyz.userservice.domain.entity.User;
import com.dyz.userservice.domain.entity.UserRole;
import com.dyz.userservice.domain.repository.RoleRepository;
import com.dyz.userservice.domain.repository.UserRepository;
import com.dyz.userservice.domain.repository.UserRoleRepository;
import com.dyz.userservice.sal.access.LogicFileAccess;
import com.dyz.userservice.sal.bo.UserChangePwBo;
import com.dyz.userservice.sal.bo.UserCreateBo;
import com.dyz.userservice.sal.bo.UserInfoBo;
import com.dyz.userservice.sal.bo.UserQueryBo;
import com.dyz.userservice.sal.service.UserService;
import com.dyz.userservice.sal.translation.UserModelTranslator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private LogicFileAccess logicFileAccess;

    @Override
    public List<UserInfoBo> queryUsersInfo(UserQueryBo queryBo) {
        log.info("begin to query user info");
        if (Objects.isNull(queryBo)) {
            log.error("param is null");
            throw new IllegalParamException(0, "query param is null");
        }
        List<UserInfoBo> results = UserModelTranslator.toBoList(
                userRepository.queryEnableUsers(
                        queryBo.getUserId(), queryBo.getEmailAddress(),
                        queryBo.getPhoneNumber(), queryBo.getNickName(),
                        queryBo.getFromRegisterTime(), queryBo.getToRegisterTime()));
        log.info("end of query user info, result = {}", results);
        return results;
    }

    @Override
    public Integer createUser(UserCreateBo createBo) {
        log.info("begin to create user, createBo = {}", createBo);
        if (!ObjectUtils.allNotNull(createBo, createBo.getPhoneNumber(), createBo.getEmailAddress(),
                createBo.getGender(), createBo.getNickName(), createBo.getBirthday(), createBo.getPassword())) {
            log.error("param is null");
            throw new IllegalParamException(0, "create param is null");
        }
        User newUser = UserModelTranslator.toEntity(createBo);
        newUser.setAvailable(true);
        newUser.setEnable(true);
        newUser.setRegisterTime(new Date());
        if (Objects.nonNull(createBo.getProfilePhoto())) {
            log.info("upload user profile photo");
            MultipartFile[] photo = transferMultipartFiles(createBo.getProfilePhoto());
            // TODO userId
            Integer photoId = logicFileAccess.uploadFiles(photo, null).get(0);
            newUser.setProfilePhotoId(photoId);
            log.info("upload finish, photo id = {}", photoId);
        }
        userRepository.save(newUser);
        log.info("end of create user");
        return newUser.getId();
    }

    @Override
    public void unableUser(Integer userId) {
        log.info("begin to unable user, userId = {}", userId);
        User user = getUserByUserId(userId);
        user.setEnable(false);
        userRepository.save(user);
        log.info("end of unable user");
    }

    @Override
    public void changeUserAvailableStatus(Integer userId, boolean available) {
        log.info("begin to change user available status, userId = {}", userId);
        User user = getUserByUserId(userId);
        user.setAvailable(false);
        userRepository.save(user);
        log.info("end of change");
    }

    @Override
    public void changeUserPassword(UserChangePwBo changePwBo) {
        log.info("begin to change user password, changeBo = {}", changePwBo);
        if(!ObjectUtils.allNotNull(changePwBo, changePwBo.getNewPassword(),
                changePwBo.getOriginPassword(), changePwBo.getUserId())) {
            log.error("param is null");
            throw new IllegalParamException(0, "param is null");
        }
        User user = getUserByUserId(changePwBo.getUserId());
        String oldPassword = user.getPassword();
        if(!Objects.equals(oldPassword, changePwBo.getOriginPassword())) {
            log.error("origin password is not current");
            throw new IllegalParamException(0, "origin password is not current");
        }
        user.setPassword(changePwBo.getNewPassword());
        userRepository.save(user);
        log.info("end of change");
    }

    @Override
    public void changeUserRole(Integer userId, List<Integer> roleIds) {
        log.info("begin to change user role, userId = {}, roleIds = {}", userId, roleIds);
        if(Objects.isNull(userId) || CollectionUtils.isEmpty(roleIds)) {
            log.error("param is null");
            throw new IllegalParamException(0, "param is null");
        }
        User user = getUserByUserId(userId);
        userRoleRepository.deleteUserRolesByUserId(user.getId());
        List<UserRole> newUserRoles = new ArrayList<>();
        roleIds.forEach(x -> {
            Role role = getRoleByRoleId(x);
            if(Objects.isNull(role)) {
                log.error("no such role");
                throw new NoDataException(0, "no such role");
            }
            UserRole userRole = UserRole.builder().roleId(role.getId()).userId(user.getId()).build();
            newUserRoles.add(userRole);
        });
        userRoleRepository.saveAll(newUserRoles);
        log.info("end of change");
    }

    
    /**
     * get user
     * @param userId
     * @return
     */
    private User getUserByUserId(Integer userId) {
        User user = userRepository.getEnableUserById(userId);
        if(Objects.isNull(user)) {
            log.error("no such enable user");
            throw new NoDataException(0, "no such user");
        }
        return user;
    }
    
    /**
     * get role
     * @param roleId
     * @return
     */
    private Role getRoleByRoleId(Integer roleId) {
        Role role = roleRepository.queryById(roleId);
        if(Objects.isNull(role)) {
            log.error("no such enable user");
            throw new NoDataException(0, "no such user");
        }
        return role;
    }

    /**
     * transfer MultipartFile
     *
     * @param files
     * @return
     */
    private MultipartFile[] transferMultipartFiles(MultipartFile...files) {
        log.info("begin to transfer multipart files, count = {}", files.length);
        if (Objects.isNull(files)) {
            return null;
        }
        MultipartFile[] resultFiles = new MultipartFile[files.length];
        int fileIndex = 0;
        for (MultipartFile file : files) {
            DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file", MediaType.ALL_VALUE,
                    true, file.getOriginalFilename());
            InputStream input = null;
            try {
                input = file.getInputStream();
                OutputStream os = fileItem.getOutputStream();
                IOUtils.copy(input, os);
                MultipartFile result = new CommonsMultipartFile(fileItem);
                resultFiles[fileIndex++] = result;
            } catch (IOException e) {
                log.error("transfer multipart file fail!", e);
            }
        }
        log.info("end of transfer multipart file");
        return resultFiles;
    }
}
