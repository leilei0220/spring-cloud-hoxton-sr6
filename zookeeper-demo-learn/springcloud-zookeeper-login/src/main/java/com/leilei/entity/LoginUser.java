package com.leilei.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lei
 * @version 1.0
 * @date 2020/8/23 15:11
 * @desc
 */
@Data
public class LoginUser {
    private String username;
    private String password;
    private LocalDateTime loginTime;
}
