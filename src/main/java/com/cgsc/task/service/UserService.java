package com.cgsc.task.service;

import com.cgsc.task.entity.User;
import com.cgsc.task.mapper.AbstractMapper;
import com.cgsc.task.mapper.UserMapper;
import com.cgsc.task.model.UserModel;
import com.cgsc.task.repository.AbstractRepository;
import com.cgsc.task.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UserService extends AbstractService<User, UserModel> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Transactional
    public User save(UserModel model) {

        User user = userMapper.toEntity(model);
        User findUser = userRepository.findByGithubId(model.getGithubId()).orElse(null);

        if (findUser != null) {
            user.setId(findUser.getId());
            user.setCreateDate(findUser.getCreateDate());
            user.setLastUpdateDate(LocalDateTime.now());
        }

        return userRepository.save(user);
    }

    @Override
    AbstractRepository<User> getRepository() {
        return userRepository;
    }

    @Override
    AbstractMapper<User, UserModel> getMapper() {
        return userMapper;
    }
}
