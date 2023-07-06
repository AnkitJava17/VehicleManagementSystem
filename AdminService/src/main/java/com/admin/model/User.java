package com.admin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

private int userId;
    private String email;
    private String username;
    private String firstname;
    private String lastname;
    private String mobile;
    private String password;
    private String profile; 
}
