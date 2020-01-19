package com.dyz.userservice.sal.bo;

import com.dyz.userservice.common.constant.ServiceConstant;
import com.dyz.userservice.common.exception.IllegalParamException;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

@Data
@Builder
public class UserQueryBo {

    private Integer userId;

    private String emailAddress;

    private String phoneNumber;

    private String nickName;

    private Date fromRegisterTime;

    private Date toRegisterTime;
    
    /**
     * must Boolean, can not be boolean
     */
    private Boolean enable;
    
    /**
     * must Boolean, can not be boolean
     */
    private Boolean available;

    public Date getFromRegisterTime() {
        if (Objects.isNull(fromRegisterTime)) {
            try {
                return DateUtils.parseDate(ServiceConstant.DEFAULT_FROM_DATE, ServiceConstant.DATE_FORMAT_SHORT);
            } catch (ParseException e) {
                throw new IllegalParamException(0, "Illega param fromTime");
            }
        }
        return fromRegisterTime;
    }

    public Date getToRegisterTime() {
        if (Objects.isNull(fromRegisterTime)) {
            try {
                return DateUtils.parseDate(ServiceConstant.DEFAULT_TO_DATE, ServiceConstant.DATE_FORMAT_SHORT);
            } catch (ParseException e) {
                throw new IllegalParamException(0, "Illega param toTime");
            }
        }
        return fromRegisterTime;
    }


}
