package com.uas.repository;

import com.uas.exception.NotFoundException;
import com.uas.model.User;

public interface UserRepository {

    public User save(User user);

    public User findByUsername(String username) throws NotFoundException;

    public Boolean login(User user);

}
