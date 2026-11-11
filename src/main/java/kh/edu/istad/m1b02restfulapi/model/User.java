package kh.edu.istad.m1b02restfulapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID id;
    private String username;
    private String password;
    private String fullName;
    public Boolean isActive;
}
