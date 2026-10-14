package com.practice.secureJobPortal.UserService;

import com.practice.secureJobPortal.entity.User;
import com.practice.secureJobPortal.loginDTOs.LoginRequest;
import com.practice.secureJobPortal.loginDTOs.LoginResponse;
import com.practice.secureJobPortal.registrationDTOs.RegisterRequest;
import com.practice.secureJobPortal.userRepository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public User convertRegisterRequestToUser(RegisterRequest registerRequest){
        User user = new User();
        user.setName(registerRequest.getValidateName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        return user;
    }

    @Override
    public String registerUser(RegisterRequest registerRequest) {
        if(userRepository.existsByEmail(registerRequest.getEmail())){
            return "User with email: " + registerRequest.getEmail() + " already exists.";
        }
        User user = convertRegisterRequestToUser(registerRequest);
        userRepository.save(user);

        return "User registered successfully with email: " + registerRequest.getEmail();
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail()).orElse(null);

        if(user == null){
            return new LoginResponse(null,null,null,"User with email: " + loginRequest.getEmail() + " does not exist.");
        }

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            return new LoginResponse(null,null,null,"Invalid password for email: " + loginRequest.getEmail());
        }
        return new LoginResponse(user.getId(),user.getName(),user.getEmail(),"Login successful for email: " + loginRequest.getEmail());
    }


}
