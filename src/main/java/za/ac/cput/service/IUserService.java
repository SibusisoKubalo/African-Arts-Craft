package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Users;

import java.util.List;

/**
 * IUserService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 24-Jul-24
 */

@Service
public interface IUserService extends IService<Users, String> {

    void delete(String id);

    List<Users> findByUsername(String username);

    List<Users> findByLastName(String last_name);

    List<Users> findByEmail(String email);
}
