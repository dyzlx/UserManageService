package com.dyz.userservice.sal.service;


import com.dyz.userservice.sal.bo.UserInfoBo;
import com.dyz.userservice.sal.bo.UserRelationInfoBo;

import java.util.List;

public interface UserRelationService {

    /**
     * make friends
     * @param relationInfoBo
     */
    void makeFriends(UserRelationInfoBo relationInfoBo);

    /**
     * delete friends
     * @param relationInfoBo
     */
    void deleteFriends(UserRelationInfoBo relationInfoBo);

    /**
     * query friends
     * @param userId
     * @return
     */
    public List<UserInfoBo> getFriends(Integer userId);
}
