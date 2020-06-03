package me.hibiki.domain;

import lombok.Data;

/**
 * @author 高弘昆
 * @date 2020/4/29 14:25
 */
@Data
public class UserExtend extends User{
    private Department department;
}
