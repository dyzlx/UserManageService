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

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"userId", "roleId"})
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user_role")
@IdClass(value = UserRoleKey.class)
public class UserRole {

    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Id
    @Column(name = "role_id", nullable = false)
    private int roleId;

}

@EqualsAndHashCode
class UserRoleKey implements Serializable {

    private int userId;

    private int roleId;
}

