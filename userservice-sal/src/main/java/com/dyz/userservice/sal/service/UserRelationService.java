package com.dyz.userservice.sal.service;


public interface UserRelationService {

    /**
     *
     * @param initiatorUserId
     * @param recipientUserId
     */
    void makeFriends(Integer initiatorUserId, Integer recipientUserId);

    /**
     *
     * @param initiatorUserId
     * @param deletedFriendId
     */
    void deleteFriends(Integer initiatorUserId, Integer deletedFriendId);
}
