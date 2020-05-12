package me.hibiki.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 高弘昆
 * @date 2020/5/12 18:03
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserFileExtend extends UserFile{
    private User user;
    private Department department;
}
