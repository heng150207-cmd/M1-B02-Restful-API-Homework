package kh.edu.istad.m1b02restfulapi.service;

import kh.edu.istad.m1b02restfulapi.dto.UserCreateRequest;
import kh.edu.istad.m1b02restfulapi.dto.UserRespone;
import kh.edu.istad.m1b02restfulapi.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
   UserRespone create(UserCreateRequest userCreateRequest);

   void deleteById(UUID id);

    List<UserRespone> getAll();

    User getById(UUID id);
}
