package service;

import dao.User;
import dao.UserDAO;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getUsersWithShortName() {
        return userDAO.findAll().stream()
            .filter(user -> user.getFirstName().length() < 5)
            .collect(Collectors.toList());
    }
}
