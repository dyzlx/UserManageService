package com.dyz.userservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateVo {

    @Email
    @NotBlank
    private String emailAddress;

    @NotBlank
    @Size(min = 1, max = 20)
    private String nickName;

    @NotBlank
    @Size(min = 1, max = 20)
    private String phoneNumber;

    @NotBlank
    private String birthday;

    @NotBlank
    @Size(min = 6, max = 15)
    private String password;

    @NotBlank
    private String gender;
}
