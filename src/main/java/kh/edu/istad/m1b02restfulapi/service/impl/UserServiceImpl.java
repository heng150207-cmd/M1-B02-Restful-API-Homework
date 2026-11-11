package kh.edu.istad.m1b02restfulapi.service.impl;

import kh.edu.istad.m1b02restfulapi.dto.UserCreateRequest;
import kh.edu.istad.m1b02restfulapi.dto.UserRespone;
import kh.edu.istad.m1b02restfulapi.model.User;
import kh.edu.istad.m1b02restfulapi.repository.UserRepository;
import kh.edu.istad.m1b02restfulapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserRespone create(UserCreateRequest userCreateRequest){
        //1,Maping data from dto domain model
        User user = new User();
        user.setUsername(userCreateRequest.username());
        user.setPassword(userCreateRequest.password());
        user.setFullName(userCreateRequest.fullname());
        //2.manage system data
        user.setId(UUID.randomUUID());
        user.setIsActive(true);

        // 3. Save data
        userRepository.insertOne(user);

        // 4. Map data from domain model to dto
        return new UserRespone(
                user.getId(),
                user.getFullName(),
                user.getIsActive()
        );

    }

    @Override
    public void deleteById(UUID id) {
        // validate user ID
        if (!userRepository.checkById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User not found!"
            );
        }

        userRepository.deleteOne(id);
    }

    @Override
    public List<UserRespone> getAll() {
        return userRepository.selectAll()
                .stream()
                .map(user -> new UserRespone(user.getId(),
                        user.getFullName(),
                        user.getIsActive()
                        ))
                .toList();
    }

    @Override
    public User getById(UUID id) {
        return null;
    }
}
