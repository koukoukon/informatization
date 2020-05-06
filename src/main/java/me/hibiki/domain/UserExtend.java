package me.hibiki.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 高弘昆
 * @date 2020/4/29 14:25
 */
@Getter
@Setter
public class UserExtend extends User{
    private Department department;

    @Override
    public String toString() {
        return super.toString()+"UserExtend{" +
                "department=" + department +
                '}';
    }
}
