package kh.edu.istad.m1b02restfulapi.dto;

public record UserCreateRequest(
        String username,
        String password,
        String fullname
) {
}
