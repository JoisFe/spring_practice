package com.example.TacoCloud.dto;

import com.example.TacoCloud.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : 조재철
 * @since 1.0
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public Users toUsers(PasswordEncoder passwordEncoder) {
        return new Users(
            username, passwordEncoder.encode(password),
            fullname, street,
            city, state,
            zip, phone
        );
    }
}
