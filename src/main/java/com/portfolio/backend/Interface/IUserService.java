package com.portfolio.backend.Interface;

import com.portfolio.backend.Entity.User;
import java.util.List;

public interface IUserService {
    public List<User> getUser();
    
    public void saveUser(User user);
    
    public void deleteUser(int id);
    
    public User findUser(int id);
}
