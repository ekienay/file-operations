package com.tls.Implements;

import com.tls.model.User;
import com.tls.service.CRUD;

import java.util.*;

public class UserServiceImpl implements CRUD<User,Long> {

    private final Map<Long,User> userLongMap = new HashMap<>();


    @Override
    public void create(User user) {
        userLongMap.put(user.getId(), user);
    }

    @Override
    public void update(User user, Long id) {
        userLongMap.put(id, user);
    }

    @Override
    public void delete(Long id) {
        userLongMap.remove(id);
    }

    @Override
    public Optional<User> readById(Long id) {
        return Optional.ofNullable((userLongMap.getOrDefault(id,null)));
    }

    @Override
    public Collection<User> findAll() {
        return userLongMap.values();
    }
}
