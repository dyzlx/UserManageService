package com.dyz.userservice.sal.bo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString(of = {"userId"})
public class UserChangePwBo {
    
    private Integer userId;
    
    private String originPassword;
    
    private String newPassword;
}
