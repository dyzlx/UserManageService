package com.dyz.userservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"initiatorId", "recipientId"})
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user_relation")
@IdClass(UserRelationKey.class)
public class UserRelation {

    @Id
    @Column(name = "initiator_id", nullable = false)
    private int initiatorId;

    @Id
    @Column(name = "recipient_id", nullable = false)
    private int recipientId;

    @Column(name = "create_time", nullable = false)
    private Date createTime;
}

@EqualsAndHashCode
class UserRelationKey implements Serializable {

    private int initiatorId;

    private int recipientId;
}
