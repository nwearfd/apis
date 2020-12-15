package com.junil.apis.service;

import com.junil.apis.model.User;
import com.junil.apis.vo.UserRegisterVO;
import com.junil.apis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public User find(int userId) throws Exception{
        Optional<User> searchedUser = this.userRepository.findById(userId);
//        if(searchedUser == null){
//            throw new Exception("해당 유저를 찾지 못하였습니다");
        return searchedUser.orElseThrow(() -> new Exception("해당 유저를 찾지 못하였습니다."));
    }
    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public void initializeUsers(){
        User user1 = User.builder()
                .email("example1@sample.com")
                .name("Mr. Sample")
                .phone("01000001234")
                .build();

        User user2 = User.builder()
                .email("example2@sample.com")
                .name("Mrs. Sample")
                .phone("01000001234")
                .build();

        User user3 = User.builder()
                .email("example3@sample.com")
                .name("ms. Sample data")
                .phone("01000001234")
                .build();

        this.userRepository.save(user1);
        this.userRepository.save(user2);
        this.userRepository.save(user3);
        this.userRepository.flush();

    }

    public void createUser(UserRegisterVO userRegisterVo){
        User createUser = User.builder()
                .email(userRegisterVo.getEmail())
                .phone(userRegisterVo.getPhone())
                .name(userRegisterVo.getName())
                .build();

        this.userRepository.save(createUser);
        this.userRepository.flush();

    }

    public void deleteUser(int userId){
        this.userRepository.deleteById(userId);
    }
}
