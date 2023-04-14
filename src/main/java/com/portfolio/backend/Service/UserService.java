package com.portfolio.backend.Service;

import com.portfolio.backend.Entity.User;
import com.portfolio.backend.Interface.IUserService;
import com.portfolio.backend.Repository.IUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired IUserRepository iuserRepository;
    
    @Override
    public List<User> getUser() {
        List<User> user = iuserRepository.findAll();
        return user;
    }

    @Override
    public void saveUser(User user) {
        iuserRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        iuserRepository.deleteById(id);
    }

    @Override
    public User findUser(int id) {
        User user = iuserRepository.findById(id).orElse(null);
        return user;
    }
}
