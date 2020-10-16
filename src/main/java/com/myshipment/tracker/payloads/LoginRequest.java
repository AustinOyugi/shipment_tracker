package com.myshipment.tracker.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Austin Oyugi
 * @date 10/13/2020
 * @email austinoyugi@gmail.com
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String userNameOrEmail;
    private String password;
}
