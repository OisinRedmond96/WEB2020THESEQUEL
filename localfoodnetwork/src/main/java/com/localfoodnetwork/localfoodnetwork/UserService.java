package com.localfoodnetwork.localfoodnetwork;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class UserService {
 
    @Autowired
    private UserRepository repo;
        
    public void save(User user) {
        repo.save(user);
    }

    public List<User> listAll() {
        return repo.findAll();
    }
}
