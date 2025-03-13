package com.myboost.purchase.presenter;

import com.myboost.purchase.entity.User;
import com.myboost.purchase.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserPresenter {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/users")
    public Map<String, Object> findAllActiveUsers() {
        Map<String, Object> response = new HashMap<>();
        List<User> users = userServiceImpl.findAllActiveUsers();
        response.put("status", "success");
        response.put("data", users);

        return response;
    }

    @GetMapping("/users/{id}")
    public Map<String, Object> findUserById(Long id) {
        Map<String, Object> response = new HashMap<>();
        User user = userServiceImpl.findUserById(id);
        response.put("status", "success");
        response.put("data", user);

        return response;
    }

    @PostMapping("/users")
    public Map<String, Object> saveUser(User user) {
        Map<String, Object> response = new HashMap<>();
        User savedUser = userServiceImpl.saveUser(user);
        response.put("status", "success");
        response.put("data", savedUser);

        return response;
    }

    @PutMapping("/users/{id}")
    public Map<String, Object> updateUser(Long id, User user) {
        Map<String, Object> response = new HashMap<>();
        User updatedUser = userServiceImpl.updateUser(id, user);
        response.put("status", "success");
        response.put("data", updatedUser);

        return response;
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Object> deleteUser(Long id) {
        Map<String, Object> response = new HashMap<>();
        userServiceImpl.deleteUser(id);
        response.put("status", "success");
        response.put("data", "User deleted successfully");

        return response;
    }
}
