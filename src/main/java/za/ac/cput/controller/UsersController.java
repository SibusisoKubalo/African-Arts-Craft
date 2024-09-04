package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Users;
import za.ac.cput.service.UserService;

import java.time.LocalDate;
import java.util.List;

/**
 * UsersController.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 24-Jul-24
 */


@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users createdUser = userService.create(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") long id) {
        Users user = userService.read(String.valueOf(id));
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id") long id, @RequestBody Users user) {
        Users existingUser = userService.read(String.valueOf(id));
        if (existingUser != null) {
            // Update the fields that can be changed
            Users updatedUser = new Users.Builder()
                    .copy(existingUser) // Copy existing user
                    .setUsername(user.getUsername()) // Update fields
                    .setPassword(user.getPassword())
                    .setEmail(user.getEmail())
                    .setFirst_name(user.getFirst_name())
                    .setLast_name(user.getLast_name())
                    .setCreated_at(existingUser.getCreated_at()) // Preserve creation date
                    .setUpdated_at(LocalDate.now()) // Set current date as update date
                    .build();
            Users savedUser = userService.update(updatedUser);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long id) {
        Users existingUser = userService.read(String.valueOf(id));
        if (existingUser != null) {
            userService.delete(String.valueOf(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<Users>> getUsersByUsername(@PathVariable("username") String username) {
        List<Users> users = userService.findByUsername(username);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Users>> getUsersByEmail(@PathVariable("email") String email) {
        List<Users> users = userService.findByEmail(email);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<Users>> getUsersByLastName(@PathVariable("lastName") String lastName) {
        List<Users> users = userService.findByLastName(lastName);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/createdAfter/{createdAt}")
    public ResponseEntity<List<Users>> getUsersCreatedAfter(@PathVariable("createdAt") String createdAt) {
        LocalDate date;
        try {
            date = LocalDate.parse(createdAt);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Users> users = userService.findUsersCreatedAfter(date);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateUser(@RequestParam String email, @RequestParam String password) {
        boolean isValid = userService.validateUser(email, password);
        if (isValid) {
            return ResponseEntity.ok("User is valid");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
