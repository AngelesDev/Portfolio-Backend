package com.portfolio.backend.Controller;

import com.portfolio.backend.Entity.User;
import com.portfolio.backend.Interface.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://argp-66abf.firebaseapp.com"})
public class UserController {

    @Autowired
    IUserService iuserService;

    @GetMapping("/user/get")
    public List<User> getUser() {
        return iuserService.getUser();
    }

    @PostMapping("/user/create")
    public String createUser(@RequestBody User user) {
        iuserService.saveUser(user);
        return "El usuario fue creado correctamente";
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        iuserService.deleteUser(id);
        return "El usuario fue eliminado correctamente";
    }

    @PutMapping("/user/edit/{id}")
    public User editUser(@PathVariable int id,
            @RequestParam("username") String newUsername,
            @RequestParam("password") String newPassword) {
        User username = iuserService.findUser(id);
        username.setUsername(newUsername);
        username.setPassword(newPassword);

        iuserService.saveUser(username);
        return username;
    }
}
