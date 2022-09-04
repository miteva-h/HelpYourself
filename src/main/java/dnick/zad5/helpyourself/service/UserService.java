package dnick.zad5.helpyourself.service;

import dnick.zad5.helpyourself.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> listAll();
    User create(String username, String password, String role);
}
