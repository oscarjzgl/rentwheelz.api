package com.copilot.rentwheelz.api.dto;

import lombok.Data;

@Data
public class UserLoginDTO {
    private String userName;
    private String userPassword;
}