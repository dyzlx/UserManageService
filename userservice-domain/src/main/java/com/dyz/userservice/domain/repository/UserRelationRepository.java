package com.dyz.userservice.domain.repository;


import com.dyz.userservice.domain.entity.UserRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRelationRepository extends JpaRepository<UserRelation, Integer> {
}
