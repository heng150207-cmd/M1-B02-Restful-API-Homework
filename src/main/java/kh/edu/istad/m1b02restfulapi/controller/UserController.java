package kh.edu.istad.m1b02restfulapi.controller;

import kh.edu.istad.m1b02restfulapi.dto.UserCreateRequest;
import kh.edu.istad.m1b02restfulapi.dto.UserRespone;
import kh.edu.istad.m1b02restfulapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id){
        userService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserRespone create(@RequestBody UserCreateRequest userCreateRequest){
        return userService.create(userCreateRequest);
    }

    @GetMapping
    public List<UserRespone> getAll() {
        return userService.getAll();
    }


}

