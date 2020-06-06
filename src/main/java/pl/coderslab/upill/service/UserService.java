package pl.coderslab.upill.service;

import pl.coderslab.upill.entity.User;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);

    void deleteUserById(Long id);
}
