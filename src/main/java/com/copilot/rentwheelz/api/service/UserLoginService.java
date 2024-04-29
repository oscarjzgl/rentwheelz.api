package com.copilot.rentwheelz.api.service;

import com.copilot.rentwheelz.api.dto.StatusOperation;
import com.copilot.rentwheelz.api.dto.UserLoginDTO;
import com.copilot.rentwheelz.api.entity.User;
import com.copilot.rentwheelz.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    private UserRepository userRepository;

    public StatusOperation login(UserLoginDTO userLoginDTO) {
        User user =  userRepository.findByUserNameAndUserPassword(userLoginDTO.getUserName(), userLoginDTO.getUserPassword());
        if(user == null) {
            return new StatusOperation("Invalid credentials", 0, "Invalid credentials", null);
        }
        return new StatusOperation("success", 1, "Login successful", user);
    }
}