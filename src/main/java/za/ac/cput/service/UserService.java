package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Users;
import za.ac.cput.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * UserService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 24-Jul-24
 */

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users create(Users users) {
        return userRepository.save(users);
    }

    @Override
    public Users read(String s) {
        return userRepository.findById(s).orElse(null);
    }

    @Override
    public Users update(Users users) {
        return userRepository.save(users);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<Users> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Users> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public List<Users> findUsersCreatedAfter(LocalDate createdAt) {
        return userRepository.findUsersCreatedAfter(createdAt);
    }

    public boolean validateUser(String email, String password) {
        Users user = userRepository.findByEmailAndPassword(email, password);
        return user != null;
    }
}
