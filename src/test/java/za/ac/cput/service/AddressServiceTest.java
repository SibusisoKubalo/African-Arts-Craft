package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Addresses;
import za.ac.cput.domain.Users;
import za.ac.cput.repository.AddressRepository;
import za.ac.cput.service.AddressService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional
class AddressServiceTest {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    private Addresses address;
    private Users user;

    @BeforeEach
    void setUp() {
        user = new Users.Builder()
                .setUser_id(56)
                .setUsername("testuser")
                .setPassword("password")
                .setEmail("test@example.com")
                .setFirst_name("Test")
                .setLast_name("User")
                .setCreated_at(LocalDate.now())
                .setUpdated_at(LocalDate.now())
                .build();

        address = new Addresses.Builder()
                .setAddress_id(1L)
                .setUser_id(19)
                .setAddress_line1("123 Test St")
                .setAddress_line2("Apt 4B")
                .setCity("Test City")
                .setProvince("Test Province")
                .setPostal_code("12345")
                .setCountry("Test Country")
                .setCreated_at(LocalDate.now())
                .setUpdated_at(LocalDate.now())
                .build();
    }

    @Test
    void create() {
        Addresses createdAddress = addressService.create(address);
        System.out.println(createdAddress);
        assertNotNull(createdAddress);
        assertEquals(address.getAddress_id(), createdAddress.getAddress_id());
        assertEquals(address.getAddress_line1(), createdAddress.getAddress_line1());
    }

    @Test
    void read() {
        addressService.create(address);  // Ensure the address is in the database
        Addresses foundAddress = addressService.read(address.getAddress_id());
        System.out.println(foundAddress);

        assertNotNull(foundAddress);
        assertEquals(address.getAddress_id(), foundAddress.getAddress_id());
    }

    @Test
    void update() {
        Addresses createdAddress = addressService.create(address);
        createdAddress = new Addresses.Builder()
                .copy(createdAddress)
                .setAddress_line1("new Address updated address")
                .build();
        Addresses updatedAddress = addressService.update(createdAddress);
        System.out.println(updatedAddress);
        assertNotNull(updatedAddress);
        assertEquals("new Address updated address", updatedAddress.getAddress_line1());
    }

    @Test
    void findAll() {
        addressService.create(address);
        List<Addresses> addresses = addressService.findAll();

        assertNotNull(addresses);
        assertFalse(addresses.isEmpty());
        assertEquals(1, addresses.size());
    }

}
