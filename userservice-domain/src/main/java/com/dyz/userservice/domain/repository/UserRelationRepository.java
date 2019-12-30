package com.dyz.userservice.domain.repository;


import com.dyz.userservice.domain.entity.UserRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRelationRepository extends JpaRepository<UserRelation, Integer> {

    @Query(value = "select * from user_relation where if(?1 is NULL,1=1,initiator_id=?1)"
            + " and if(?2 is NULL,1=1,recipient_id=?2)"
            + " and create_time between ?3 and ?4", nativeQuery = true)
    List<UserRelation> queryUserRelationsInfo(Integer initiatorId, Integer recipientId, Date fromTime, Date toTime);

    @Query(value = "select * from user_relation where initiator_id=?1 or recipient_id=?1", nativeQuery = true)
    List<UserRelation> queryUserRelationsByUserId(Integer userId);
}
