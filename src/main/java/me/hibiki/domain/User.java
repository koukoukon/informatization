package me.hibiki.domain;

import java.io.Serializable;
import lombok.Data;
/**
 * @author 高弘昆
 * @date 2020/4/29 12:41
 */
@Data
public class User implements Serializable {
    private Long userId;

    private String userName;

    private String userPassword;

    private String userNickname;

    private String userGender;

    private String userEmail;

    private String userPhone;

    private Integer authorityPid;

    private Long departmentPid;

    private Integer userDeleteFlag;

    private static final long serialVersionUID = 1L;
}