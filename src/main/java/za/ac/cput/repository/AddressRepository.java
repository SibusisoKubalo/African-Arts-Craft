package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Addresses;
import za.ac.cput.domain.Users;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * AddressRepository.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 27-Jul-24
 */

@Repository
public interface AddressRepository extends JpaRepository<Addresses, Long> {

}
