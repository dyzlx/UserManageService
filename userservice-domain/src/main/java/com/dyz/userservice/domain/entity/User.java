package com.dyz.userservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Builder
@Getter
@Setter
@ToString(exclude = {"password"})
@EqualsAndHashCode(of = {"id", "emailAddress", "phoneNumber", "nickName"})
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email_address", length = 50, nullable = false)
    private String emailAddress;

    @Column(name = "phone_number", length = 50, nullable = false)
    private String phoneNumber;

    @Column(name = "nick_name", length = 100, nullable = false)
    private String nickName;

    @Column(name = "register_time", nullable = false)
    private Date registerTime;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "gender", length = 10, nullable = false)
    private String gender;

    /**
     * false : the user deleted his account
     */
    @Column(name = "enable", nullable = false)
    @Type(type = "yes_no")
    private boolean enable;

    /**
     * false : the user is temporarily unable to access their accounts
     */
    @Column(name = "available", nullable = false)
    @Type(type = "yes_no")
    private boolean available;

    @Column(name = "profile_photo_id")
    private int profilePhotoId;
}
