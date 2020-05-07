package me.hibiki.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 高弘昆
 * @date 2020/5/7 15:43
 */
@Getter
@Setter
public class ApplyExtend extends Apply{
    private User user;

    @Override
    public String toString() {
        return super.toString()+"ApplyExtend{" +
                "user=" + user +
                '}';
    }
}
