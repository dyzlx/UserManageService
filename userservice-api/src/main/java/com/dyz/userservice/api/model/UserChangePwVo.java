package com.dyz.userservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserChangePwVo {

    @NotNull
    private int userId;

    @Size(min = 6, max = 15)
    @NotBlank
    private String originPassword;

    @Size(min = 6, max = 15)
    @NotBlank
    private String newPassword;
}
